package com.ss.bytertc.base.media;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlRectDrawer;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.TimestampAligner;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes40.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private static float[] TEX_MATRIX;
    private boolean capture2DTexture;
    private final EglBase eglBase;
    private final int frameBufferId;
    private int frameRotation;
    private final GlRectDrawer glRectDrawer;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private long lastDeliverTime;
    private VideoSink listener;
    private boolean mUsedByCamera;
    private int maxDeliverTimerInternal;
    private final int oesTextureId;
    private VideoSink pendingListener;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private int textureWidth;
    final Runnable timedDeliverRunnable;
    private final TimestampAligner timestampAligner;
    private final int twoDTextureId;
    private final YuvConverter yuvConverter;

    public static /* synthetic */ void a(SurfaceTextureHelper r100) {
        r100.lambda$stopListening$1();
    }

    public static /* synthetic */ void b(SurfaceTextureHelper r100) {
        r100.returnTextureFrame();
    }

    public static /* synthetic */ void c(SurfaceTextureHelper r100, SurfaceTexture r101) {
        r100.lambda$new$0(r101);
    }

    public static /* synthetic */ void d(SurfaceTextureHelper r100) {
        r100.lambda$dispose$5();
    }

    public static /* synthetic */ void e(SurfaceTextureHelper r100, int r101) {
        r100.lambda$setFrameRotation$3(r101);
    }

    public static /* synthetic */ void f(SurfaceTextureHelper r100) {
        r100.lambda$returnTextureFrame$4();
    }

    public static /* synthetic */ void g(SurfaceTextureHelper r100, int r101, int r102) {
        r100.lambda$setTextureSize$2(r101, r102);
    }

    private /* synthetic */ void lambda$dispose$5() {
        this.isQuitting = true;
        if (this.isTextureInUse == true) goto L6;
        release();
        return;
    }

    private /* synthetic */ void lambda$returnTextureFrame$4() {
        this.isTextureInUse = false;
        if (this.isQuitting == false) goto L5;
        release();
        return;
    L5:
        tryDeliverTextureFrame();
    }

    private /* synthetic */ void lambda$stopListening$1() {
        this.listener = null;
        this.pendingListener = null;
    }

    static {
        TEX_MATRIX = new float[16];
    }

    private void release() {
        if (ThreadMethodProxy.getLooperThread(this.handler.getLooper()) != ThreadMethodProxy.currentThread()) goto L18;
        if (this.isTextureInUse == true) goto L16;
        if (this.isQuitting == false) goto L16;
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        if (this.capture2DTexture == false) goto L11;
        GLES20.glDeleteTextures(1, new int[]{this.twoDTextureId}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.glRectDrawer.release();
    L11:
        this.surfaceTexture.release();
        this.eglBase.release();
        ThreadMethodProxy.quit(this.handler.getLooper());
        TimestampAligner r100 = this.timestampAligner;
        if (r100 == null) goto L19;
        r100.dispose();
        return;
    L19:
        return;
    L16:
        throw new IllegalStateException("Unexpected release.");
    L18:
        throw new IllegalStateException("Wrong thread.");
    }

    private void returnTextureFrame() {
        this.handler.post(new r(this));
    }

    private void tryDeliverTextureFrame() {
        if (ThreadMethodProxy.getLooperThread(this.handler.getLooper()) != ThreadMethodProxy.currentThread()) goto L34;
        if (this.isQuitting == false) goto L7;
        return;
    L7:
        if (this.hasPendingTexture == true) goto L9;
        return;
    L9:
        if (this.isTextureInUse == false) goto L11;
        return;
    L11:
        if (this.listener != null) goto L14;
        return;
    L14:
        if (this.textureWidth != 0) goto L16;
    L31:
        RXLogging.w(TAG, "Texture size has not been set.");
        return;
    L16:
        if (this.textureHeight == 0) goto L31;
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] r100 = new float[16];
        if (this.mUsedByCamera == false) goto L21;
        r100 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    L22:
        long r101 = this.surfaceTexture.getTimestamp();
        TimestampAligner r102 = this.timestampAligner;
        if (r102 == null) goto L25;
        r101 = r102.translateTimestamp(r101);
    L25:
        this.lastDeliverTime = System.currentTimeMillis();
        if (this.capture2DTexture == false) goto L28;
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.twoDTextureId, 0);
        GlRectDrawer r103 = this.glRectDrawer;
        int r110 = this.oesTextureId;
        float[] r111 = TEX_MATRIX;
        int r104 = this.textureWidth;
        int r105 = this.textureHeight;
        r103.drawOes(r110, r111, r104, r105, 0, 0, r104, r105);
        GLES20.glBindFramebuffer(36160, 0);
        TextureBufferImpl r106 = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.RGB, this.twoDTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(r100), this.handler, this.yuvConverter, new m(this));
    L29:
        VideoFrame r107 = new VideoFrame(r106, this.frameRotation, r101);
        this.listener.onFrame(r107);
        r107.release();
        return;
    L28:
        r106 = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(r100), this.handler, this.yuvConverter, new m(this));
        goto L29
    L21:
        this.surfaceTexture.getTransformMatrix(r100);
        goto L22
    L34:
        throw new IllegalStateException("Wrong thread.");
    }

    public void dispose() {
        RXLogging.i(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new q(this));
    }

    public void stopListening() {
        RXLogging.i(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new o(this));
    }

    private void updateTexImage() {
        Object r100 = EglBase.lock;
        monitor-enter(r100);
        this.surfaceTexture.updateTexImage();     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        RXLogging.w(TAG, "updateTexImage failed, exception: " + e.toString());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public static /* synthetic */ VideoSink access$100(SurfaceTextureHelper r100) {
        return r100.pendingListener;
    }

    public static /* synthetic */ VideoSink access$200(SurfaceTextureHelper r100) {
        return r100.listener;
    }

    public static /* synthetic */ boolean access$300(SurfaceTextureHelper r100) {
        return r100.hasPendingTexture;
    }

    public static /* synthetic */ void access$400(SurfaceTextureHelper r100) {
        r100.updateTexImage();
    }

    public static /* synthetic */ int access$500(SurfaceTextureHelper r100) {
        return r100.maxDeliverTimerInternal;
    }

    public static /* synthetic */ Handler access$600(SurfaceTextureHelper r100) {
        return r100.handler;
    }

    public static /* synthetic */ long access$700(SurfaceTextureHelper r100) {
        return r100.lastDeliverTime;
    }

    public static /* synthetic */ void access$800(SurfaceTextureHelper r100) {
        r100.tryDeliverTextureFrame();
    }

    private /* synthetic */ void lambda$new$0(SurfaceTexture r100) {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    private /* synthetic */ void lambda$setFrameRotation$3(int r100) {
        this.frameRotation = r100;
    }

    public void setFrameRotation(final int r100) {
        this.handler.post(new l(this, r100));
    }

    public void setMinFps(int r100) {
        if (r100 <= 0) goto L4;
        this.maxDeliverTimerInternal = (int) (1000.0f / r100);
        return;
    L4:
        this.maxDeliverTimerInternal = 0;
    }

    public void setUsedByCamera(boolean r100) {
        this.mUsedByCamera = r100;
    }

    public void startListening(VideoSink r100) {
        if (this.listener != null) goto L9;
        if (this.pendingListener != null) goto L9;
        this.pendingListener = r100;
        this.handler.post(this.setListenerRunnable);
        this.handler.post(this.timedDeliverRunnable);
        return;
    L9:
        throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
    }

    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer r100) {
        return r100.toI420();
    }

    public static /* synthetic */ VideoSink access$102(SurfaceTextureHelper r100, VideoSink r101) {
        r100.pendingListener = r101;
        return r101;
    }

    public static /* synthetic */ VideoSink access$202(SurfaceTextureHelper r100, VideoSink r101) {
        r100.listener = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(SurfaceTextureHelper r100, boolean r101) {
        r100.hasPendingTexture = r101;
        return r101;
    }

    public static SurfaceTextureHelper create(String r100, EglBase.Context r101) {
        return create(r100, r101, false);
    }

    private /* synthetic */ void lambda$setTextureSize$2(int r110, int r111) {
        this.textureWidth = r110;
        this.textureHeight = r111;
        if (this.capture2DTexture == false) goto L6;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.twoDTextureId);
        GLES20.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        return;
    }

    public void setTextureSize(final int r100, final int r101) {
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L7;
        this.surfaceTexture.setDefaultBufferSize(r100, r101);
        this.handler.post(new n(this, r100, r101));
        return;
    L7:
        throw new IllegalArgumentException("Texture height must be positive, but was " + r101);
    L9:
        throw new IllegalArgumentException("Texture width must be positive, but was " + r100);
    }

    public static SurfaceTextureHelper create(String r100, EglBase.Context r101, boolean r102) {
        return create(r100, r101, r102, false);
    }

    private static void setOnFrameAvailableListener(SurfaceTexture r100, SurfaceTexture.OnFrameAvailableListener r101, Handler r102) {
        r100.setOnFrameAvailableListener(r101, r102);
    }

    private SurfaceTextureHelper(EglBase.Context r100, Handler r101, boolean r102, boolean r103) {
        this.yuvConverter = new YuvConverter();
        this.capture2DTexture = false;
        this.mUsedByCamera = false;
        this.setListenerRunnable = new AnonymousClass2(this);
        this.lastDeliverTime = 0;
        this.maxDeliverTimerInternal = -1;
        this.timedDeliverRunnable = new AnonymousClass3(this);
        if (ThreadMethodProxy.getLooperThread(r101.getLooper()) != ThreadMethodProxy.currentThread()) goto L19;
        this.handler = r101;
        if (r102 == false) goto L7;
        TimestampAligner r104 = new TimestampAligner();
    L8:
        this.timestampAligner = r104;
        this.capture2DTexture = r103;
        EglBase r105 = EglBase.CC.create(r100, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = r105;
        r105.createDummyPbufferSurface();     // Catch: RuntimeException -> L15
        r105.makeCurrent();     // Catch: RuntimeException -> L15
        if (r103 == false) goto L12;
        this.glRectDrawer = new GlRectDrawer();
        int[] r106 = new int[1];
        GLES20.glGenFramebuffers(1, r106, 0);
        this.frameBufferId = r106[0];
        Matrix.setIdentityM(TEX_MATRIX, 0);
        this.twoDTextureId = GlUtil.generateTexture(3553);
    L13:
        int r107 = GlUtil.generateTexture(36197);
        this.oesTextureId = r107;
        SurfaceTexture r108 = new SurfaceTexture(r107);
        this.surfaceTexture = r108;
        setOnFrameAvailableListener(r108, new p(this), r101);
        return;
    L12:
        this.glRectDrawer = null;
        this.frameBufferId = 0;
        this.twoDTextureId = 0;
    L15:
        e = move-exception;
        this.eglBase.release();
        ThreadMethodProxy.quit(r101.getLooper());
        throw e;
    L7:
        r104 = null;
        goto L8
    L19:
        throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    }

    public static SurfaceTextureHelper create(final String r100, final EglBase.Context r101, final boolean r110, final boolean r111) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r102);
        final Handler r103 = new Handler(r102.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(r103, new AnonymousClass1(r101, r103, r110, r111, r100));
    }

    public /* synthetic */ SurfaceTextureHelper(EglBase.Context r100, Handler r101, boolean r102, boolean r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
