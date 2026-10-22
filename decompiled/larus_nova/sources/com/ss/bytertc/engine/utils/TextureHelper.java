package com.ss.bytertc.engine.utils;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlRectDrawer;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.bytedance.realx.video.YuvHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class TextureHelper {
    public static final int FORMAT_TEXTURE_2D = 10;
    public static final int FORMAT_TEXTURE_OES = 11;
    private static final String TAG = "TextureHelper";
    private static final int TEXTURE_MAX_COUNT = 45;
    private static float[] TEX_MATRIX;
    private static float[] YUV_TEX_MATRIX;
    private final EglBase mEglBase;
    private int mFrameBufferId;
    private final Handler mHandler;
    private int mHeight;
    private boolean mIsQuitting;
    private boolean mIsRelease;
    private boolean mIsTextureInUse;
    private int mTextureCnt;
    private GlRectDrawer mTextureDrawer;
    private List<Integer> mTextureFreeQueue;
    private List<Integer> mTextureUsedQueue;
    private int mWidth;
    private YuvConverter mYuvConverter;
    private YuvUploader mYuvUploader;

    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        public YuvUploader() {
        }

        public void release() {
            this.copyBuffer = null;
            int[] r100 = this.yuvTextures;
            if (r100 == null) goto L6;
            GLES20.glDeleteTextures(3, r100, 0);
            this.yuvTextures = null;
            return;
        }

        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(VideoFrame.I420Buffer r100) {
            return uploadYuvData(r100.getWidth(), r100.getHeight(), new int[]{r100.getStrideY(), r100.getStrideU(), r100.getStrideV()}, new ByteBuffer[]{r100.getDataY(), r100.getDataU(), r100.getDataV()});
        }

        public int[] uploadYuvData(int r110, int r111, int[] r210, ByteBuffer[] r211) {
            int r100 = 0;
            int r101 = r110 / 2;
            int[] r102 = {r110, r101, r101};
            int r103 = r111 / 2;
            int[] r104 = {r111, r103, r103};
            int r105 = 0;
            int r106 = 0;
        L3:
            if (r105 >= 3) goto L8;
            int r107 = r210[r105];
            int r108 = r102[r105];
            if (r107 <= r108) goto L7;
            r106 = Math.max(r106, r108 * r104[r105]);
        L7:
            r105 = r105 + 1;
            goto L3
        L8:
            if (r106 <= 0) goto L15;
            ByteBuffer r109 = this.copyBuffer;
            if (r109 != null) goto L12;
        L13:
            this.copyBuffer = ByteBuffer.allocateDirect(r106);
            goto L15
        L12:
            if (r109.capacity() < r106) goto L13;
        L15:
            if (this.yuvTextures != null) goto L19;
            this.yuvTextures = new int[3];
            int r112 = 0;
        L17:
            if (r112 >= 3) goto L19;
            this.yuvTextures[r112] = GlUtil.generateTexture(3553);
            r112 = r112 + 1;
        L19:
            if (r100 >= 3) goto L26;
            GLES20.glPixelStorei(3317, 1);
            GLES20.glActiveTexture(33984 + r100);
            GLES20.glBindTexture(3553, this.yuvTextures[r100]);
            int r113 = r210[r100];
            int r114 = r102[r100];
            if (r113 != r114) goto L23;
            ByteBuffer r115 = r211[r100];
        L24:
            GLES20.glTexImage2D(3553, 0, 6409, r102[r100], r104[r100], 0, 6409, 5121, r115);
            r100 = r100 + 1;
            goto L19
        L23:
            YuvHelper.copyPlane(r211[r100], r113, this.copyBuffer, r114, r114, r104[r100]);
            r115 = this.copyBuffer;
            goto L24
        L26:
            return this.yuvTextures;
        }
    }

    public static /* synthetic */ TextureHelper a(EglBase.Context r100, Handler r101, int r102, int r103, String r104) {
        return lambda$create$2(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ TextureHelper b(EGLContext r100, Handler r101, int r102, int r103, String r104) {
        return lambda$create$1(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void c(TextureHelper r100) {
        r100.lambda$dispose$7();
    }

    public static /* synthetic */ Integer d(TextureHelper r100, int r101, int r102, int r103) {
        return r100.lambda$generateTexture$6(r101, r102, r103);
    }

    public static /* synthetic */ TextureHelper e(javax.microedition.khronos.egl.EGLContext r100, Handler r101, int r102, int r103, String r104) {
        return lambda$create$0(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void f(int r100) {
        lambda$releaseTextureID$5(r100);
    }

    public static /* synthetic */ void g(TextureHelper r100, int r101) {
        r100.lambda$queueTexture$4(r101);
    }

    public static /* synthetic */ void h(TextureHelper r100, int[] r101) {
        r100.lambda$dequeueTexture$3(r101);
    }

    private /* synthetic */ void lambda$dispose$7() {
        this.mIsQuitting = true;
        if (this.mIsTextureInUse == true) goto L6;
        release();
        return;
    }

    public int dequeueTexture() {
        final int[] r100 = new int[1];
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new e(this, r100));
        return r100[0];
    }

    public synchronized void dispose() {
        monitor-enter(this);
        LogUtil.d(TAG, "dispose()");     // Catch: Throwable -> L6
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new d(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        TEX_MATRIX = new float[16];
        YUV_TEX_MATRIX = new float[16];
    }

    private void release() {
        if (ThreadMethodProxy.getLooperThread(this.mHandler.getLooper()) != ThreadMethodProxy.currentThread()) goto L35;
        if (this.mIsTextureInUse == true) goto L33;
        if (this.mIsQuitting == false) goto L33;
        this.mIsRelease = true;
        YuvConverter r100 = this.mYuvConverter;
        if (r100 == null) goto L11;
        r100.release();
    L11:
        YuvUploader r101 = this.mYuvUploader;
        if (r101 == null) goto L14;
        r101.release();
    L14:
        List<Integer> r102 = this.mTextureFreeQueue;
        if (r102 != null) goto L17;
    L22:
        this.mTextureFreeQueue.clear();
        List<Integer> r103 = this.mTextureUsedQueue;
        if (r103 != null) goto L25;
    L30:
        this.mTextureUsedQueue.clear();
        GLES20.glDeleteFramebuffers(1, new int[]{this.mFrameBufferId}, 0);
        this.mFrameBufferId = 0;
        this.mEglBase.release();
        ThreadMethodProxy.quit(this.mHandler.getLooper());
        return;
    L25:
        if (r103.size() <= 0) goto L30;
        Iterator<Integer> r104 = this.mTextureUsedQueue.iterator();
    L28:
        if (r104.hasNext() == false) goto L30;
        GLES20.glDeleteTextures(1, new int[]{r104.next().intValue()}, 0);
        goto L28
    L17:
        if (r102.size() <= 0) goto L22;
        Iterator<Integer> r105 = this.mTextureFreeQueue.iterator();
    L20:
        if (r105.hasNext() == false) goto L22;
        GLES20.glDeleteTextures(1, new int[]{r105.next().intValue()}, 0);
    L33:
        throw new IllegalStateException("Unexpected release.");
    L35:
        throw new IllegalStateException("Wrong thread.");
    }

    public EglBase.Context getEglBaseContext() {
        EglBase r100 = this.mEglBase;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEglBaseContext();
    }

    public long getNativeEglContext() {
        EglBase r100 = this.mEglBase;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getEglBaseContext().getNativeEglContext();
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public static /* synthetic */ GlRectDrawer access$000(TextureHelper r100) {
        return r100.mTextureDrawer;
    }

    public static /* synthetic */ int access$100(TextureHelper r100) {
        return r100.mFrameBufferId;
    }

    public static /* synthetic */ int access$200(TextureHelper r100) {
        return r100.mWidth;
    }

    public static /* synthetic */ int access$300(TextureHelper r100) {
        return r100.mHeight;
    }

    public static /* synthetic */ YuvUploader access$400(TextureHelper r100) {
        return r100.mYuvUploader;
    }

    public static /* synthetic */ YuvConverter access$600(TextureHelper r100) {
        return r100.mYuvConverter;
    }

    public static /* synthetic */ boolean access$700(TextureHelper r100) {
        return r100.mIsQuitting;
    }

    public static /* synthetic */ void access$800(TextureHelper r100) {
        r100.release();
    }

    private /* synthetic */ void lambda$dequeueTexture$3(int[] r100) {
        List<Integer> r101 = this.mTextureFreeQueue;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() != 0) goto L9;
        int r102 = generateTexture(3553, this.mWidth, this.mHeight);
        r100[0] = r102;
        if (r102 <= 0) goto L12;
        this.mTextureUsedQueue.add(Integer.valueOf(r102));
        return;
    L12:
        return;
    L9:
        r100[0] = ((Integer) ListProtector.get(this.mTextureFreeQueue, 0)).intValue();
        ListProtector.remove(this.mTextureFreeQueue, 0);
        this.mTextureUsedQueue.add(Integer.valueOf(r100[0]));
    }

    private /* synthetic */ void lambda$queueTexture$4(int r100) {
        List<Integer> r101 = this.mTextureUsedQueue;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(Integer.valueOf(r100)) == false) goto L11;
        this.mTextureUsedQueue.remove(new Integer(r100));
        List<Integer> r102 = this.mTextureFreeQueue;
        if (r102 == null) goto L12;
        r102.add(Integer.valueOf(r100));
        return;
    L12:
        return;
    }

    private static /* synthetic */ void lambda$releaseTextureID$5(int r100) {
        GLES20.glDeleteTextures(1, new int[]{r100}, 0);
    }

    public void post(Runnable r100) {
        Handler r101 = this.mHandler;
        if (r101 == null) goto L6;
        r101.post(r100);
        return;
    }

    public void queueTexture(final int r100) {
        this.mHandler.post(new g(this, r100));
    }

    public void releaseTextureID(final int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (this.mIsQuitting == false) goto L6;
        return;
    L6:
        if (this.mIsRelease == true) goto L12;
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new b(r100));
        return;
    }

    public synchronized VideoFrame.I420Buffer textureToYuv(final VideoFrame.TextureBuffer r100) {
        monitor-enter(this);
        final VideoFrame.I420Buffer[] r101 = new VideoFrame.I420Buffer[1];     // Catch: Throwable -> L7
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new AnonymousClass3(this, r101, r100));     // Catch: Throwable -> L7
        VideoFrame.I420Buffer r102 = r101[0];     // Catch: Throwable -> L7
        monitor-exit(this);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ GlRectDrawer access$002(TextureHelper r100, GlRectDrawer r101) {
        r100.mTextureDrawer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(TextureHelper r100, boolean r101) {
        r100.mIsTextureInUse = r101;
        return r101;
    }

    public static /* synthetic */ YuvConverter access$602(TextureHelper r100, YuvConverter r101) {
        r100.mYuvConverter = r101;
        return r101;
    }

    public void yuvToTexture(VideoFrame.I420Buffer r100, int r101) {
        yuvToTexture(r100, r101, YUV_TEX_MATRIX);
    }

    private int generateTexture(final int r100, final int r101, final int r102) {
        if (this.mTextureCnt != 45) goto L7;
        return 0;
    L7:
        return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new i(this, r100, r101, r102))).intValue();
    }

    private /* synthetic */ Integer lambda$generateTexture$6(int r110, int r111, int r112) throws Exception {
        int r113 = GlUtil.generateTexture(r110);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r113);
        GLES20.glTexImage2D(3553, 0, 6408, r111, r112, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        if (GLES20.glGetError() != 0) goto L5;
        this.mTextureCnt++;
        return Integer.valueOf(r113);
    L5:
        return 0;
    }

    public void drawTexture(int r100, int r101, int r102) {
        drawTexture(r100, r101, r102, TEX_MATRIX);
    }

    public void yuvToTexture(final VideoFrame.I420Buffer r100, final int r101, final float[] r102) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new AnonymousClass2(this, r101, r100, r102));
    }

    private TextureHelper(Object r100, Handler r101, int r102, int r103) {
        this.mTextureCnt = 0;
        this.mTextureFreeQueue = new LinkedList();
        this.mTextureUsedQueue = new LinkedList();
        if (ThreadMethodProxy.getLooperThread(r101.getLooper()) != ThreadMethodProxy.currentThread()) goto L22;
        this.mWidth = r102;
        this.mHeight = r103;
        this.mHandler = r101;
        Matrix.setIdentityM(TEX_MATRIX, 0);
        Matrix.setIdentityM(YUV_TEX_MATRIX, 0);
        Matrix.translateM(YUV_TEX_MATRIX, 0, 0.5f, 0.5f, 0.0f);
        Matrix.scaleM(YUV_TEX_MATRIX, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(YUV_TEX_MATRIX, 0, -0.5f, -0.5f, 0.0f);
        if ((r100 instanceof javax.microedition.khronos.egl.EGLContext) == false) goto L8;
        this.mEglBase = EglBase.CC.createEgl10((javax.microedition.khronos.egl.EGLContext) r100, EglBase.CONFIG_PIXEL_BUFFER);
    L23:
        this.mEglBase.createPbufferSurface(this.mWidth, this.mHeight);     // Catch: RuntimeException -> L16
        this.mEglBase.makeCurrent();     // Catch: RuntimeException -> L16
        int[] r104 = new int[1];
        GLES20.glGenFramebuffers(1, r104, 0);
        this.mFrameBufferId = r104[0];
        this.mTextureDrawer = new GlRectDrawer();
        this.mYuvUploader = new YuvUploader();
        GlUtil.checkNoGLES2Error("TextureHelper construct");
        return;
    L16:
        e = move-exception;
        this.mEglBase.release();
        ThreadMethodProxy.quit(r101.getLooper());
        throw e;
    L8:
        if ((r100 instanceof EGLContext) == false) goto L11;
        this.mEglBase = EglBase.CC.createEgl14((EGLContext) r100, EglBase.CONFIG_PIXEL_BUFFER);
        goto L23
    L11:
        if ((r100 instanceof EglBase.Context) == false) goto L20;
        this.mEglBase = EglBase.CC.create((EglBase.Context) r100);
        goto L23
    L20:
        throw new RuntimeException("unknown shareContext:" + r100);
    L22:
        throw new IllegalStateException("TextureHelper must be created on the handler thread");
    }

    public static TextureHelper create(final String r100, final EGLContext r101, final int r110, final int r111) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r102);
        final Handler r103 = new Handler(r102.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(r103, new h(r101, r103, r110, r111, r100));
    }

    public void drawTexture(final int r100, final int r110, final int r111, final float[] r112) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.mHandler, new AnonymousClass1(this, r111, r100, r110, r112));
    }

    public static TextureHelper create(final String r100, final EglBase.Context r101, final int r110, final int r111) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r102);
        final Handler r103 = new Handler(r102.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(r103, new c(r101, r103, r110, r111, r100));
    }

    public static TextureHelper create(final String r100, final javax.microedition.khronos.egl.EGLContext r101, final int r110, final int r111) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r102);
        final Handler r103 = new Handler(r102.getLooper());
        return (TextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(r103, new f(r101, r103, r110, r111, r100));
    }

    private static /* synthetic */ TextureHelper lambda$create$0(javax.microedition.khronos.egl.EGLContext r100, Handler r101, int r102, int r103, String r104) throws Exception {
        return new TextureHelper(r100, r101, r102, r103);
    L4:
        e = move-exception;
        LogUtil.e(TAG, r104 + " create failure", e);
        return null;
    }

    private static /* synthetic */ TextureHelper lambda$create$1(EGLContext r100, Handler r101, int r102, int r103, String r104) throws Exception {
        return new TextureHelper(r100, r101, r102, r103);
    L4:
        e = move-exception;
        LogUtil.e(TAG, r104 + " create failure", e);
        return null;
    }

    private static /* synthetic */ TextureHelper lambda$create$2(EglBase.Context r100, Handler r101, int r102, int r103, String r104) throws Exception {
        return new TextureHelper(r100, r101, r102, r103);
    L4:
        e = move-exception;
        LogUtil.e(TAG, r104 + " create failure", e);
        return null;
    }
}
