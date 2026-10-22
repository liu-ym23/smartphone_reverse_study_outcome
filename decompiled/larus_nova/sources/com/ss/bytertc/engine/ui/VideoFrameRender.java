package com.ss.bytertc.engine.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlRectDrawer;
import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.EglRenderer;
import com.ss.bytertc.engine.adapter.VideoFrameConverter;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.mediaio.CountDownLatchI420Buffer;
import com.ss.bytertc.engine.mediaio.SurfaceEglRender;
import com.ss.bytertc.engine.mediaio.TextureEglRenderer;
import com.ss.bytertc.engine.utils.ByteBufferUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoFrame;
import com.ss.bytertc.engine.video.converter.WebRTCConverter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameRender implements View.OnLayoutChangeListener, RendererCommon.RendererEvents, EglRenderer.FirstVideoFrameRenderListener {
    private static final String TAG = "VideoFrameRender";
    private boolean enableFixedSize;
    private final VideoFrameConverter frameConverter;
    private volatile EglRenderer mEglRenderer;
    private final AtomicBoolean mEglSurfaceCreatedAtomic;
    private final Object mFirstFrameListenerLock;
    private final ArrayList<FirstVideoFrameRenderListener> mFirstVideoFrameListeners;
    private final AtomicBoolean mHasInitAtomic;
    private boolean mHasReceivedFirstFrame;
    private final AtomicBoolean mHasRenderViewAtomic;
    private long mReceiveFirstTimeStampMs;
    private final Object mRenderLock;
    private final String mRenderName;
    private volatile Surface mSurface;
    private final SurfaceLifecycleCallback mSurfaceLifecycleCallbackCallback;
    private volatile SurfaceView mSurfaceView;
    private final Object mTextureProcessLock;
    private Looper mTextureProcessLooper;
    private volatile TextureView mTextureView;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;

    public interface FirstVideoFrameRenderListener {
        void onFirstVideoFrameRender(int r100);
    }

    public interface SurfaceLifecycleCallback {
        void onCreated();

        void onDestroy();
    }

    public static /* synthetic */ void a(VideoFrameRender r100, int r101, int r102) {
        r100.lambda$onFrameResolutionChanged$1(r101, r102);
    }

    public static /* synthetic */ void b(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102) {
        lambda$createYUV$3(r100, r101, r102);
    }

    public static /* synthetic */ void c(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102) {
        lambda$createYUV$4(r100, r101, r102);
    }

    public static /* synthetic */ void d() {
        lambda$renderTextureFrame$2();
    }

    public static /* synthetic */ void e(VideoFrameRender r100, EglBase.Context r101) {
        r100.lambda$init$0(r101);
    }

    private static /* synthetic */ void lambda$renderTextureFrame$2() {
    }

    @Override // com.bytedance.realx.video.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
    }

    private void initSurfaceView() {
        if (this.mSurfaceView != null) goto L5;
        return;
    L5:
        if (this.mHasInitAtomic.get() == false) goto L20;
        Object r100 = this.mRenderLock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L10:
        if ((this.mEglRenderer instanceof SurfaceEglRender) == false) goto L12;
        ((SurfaceEglRender) this.mEglRenderer).bind(this.mSurfaceView);     // Catch: Throwable -> L14
        this.mSurfaceView.addOnLayoutChangeListener(this);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    }

    private void initTextureView() {
        if (this.mTextureView != null) goto L5;
        return;
    L5:
        if (this.mEglRenderer != null) goto L7;
        return;
    L7:
        if (this.mHasInitAtomic.get() == false) goto L26;
        Object r100 = this.mRenderLock;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L12:
        if ((this.mEglRenderer instanceof TextureEglRenderer) == false) goto L17;
        TextureEglRenderer r101 = (TextureEglRenderer) this.mEglRenderer;     // Catch: Throwable -> L19
        r101.bind(this.mTextureView, this.mSurfaceLifecycleCallbackCallback);     // Catch: Throwable -> L19
        if (this.mTextureView.isShown() == false) goto L16;
        r101.setLayoutAspectRatio(this.mTextureView.getMeasuredWidth() / this.mTextureView.getMeasuredHeight());     // Catch: Throwable -> L19
    L16:
        this.mTextureView.addOnLayoutChangeListener(this);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    }

    private void notifyFristRenderCallback() {
        Object r100 = this.mFirstFrameListenerLock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mFirstVideoFrameListeners.isEmpty() == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L8:
        int r101 = (int) (System.currentTimeMillis() - this.mReceiveFirstTimeStampMs);     // Catch: Throwable -> L14
        Iterator<FirstVideoFrameRenderListener> r102 = this.mFirstVideoFrameListeners.iterator();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        r102.next().onFirstVideoFrameRender(r101);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    public void disableFpsReduction() {
        Object r100 = this.mRenderLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglRenderer == null) goto L7;
        this.mEglRenderer.disableFpsReduction();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public void onDispose() {
        if (this.mHasInitAtomic.compareAndSet(true, false) == false) goto L29;
        Object r100 = this.mRenderLock;
        monitor-enter(r100);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (this.mEglRenderer == null) goto L10;
        this.mEglRenderer.release();     // Catch: Throwable -> L25
        this.mEglRenderer.createEglSurface(null);     // Catch: Throwable -> L25
    L10:
        if (this.mSurfaceView == null) goto L13;
        this.mSurfaceView.removeOnLayoutChangeListener(this);     // Catch: Throwable -> L25
    L15:
        this.mEglSurfaceCreatedAtomic.set(false);     // Catch: Throwable -> L25
        monitor-exit(r100);     // Catch: Throwable -> L25
        Object r101 = this.mFirstFrameListenerLock;
        monitor-enter(r101);
        this.mFirstVideoFrameListeners.clear();     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L13:
        if (this.mTextureView == null) goto L15;
        this.mTextureView.setSurfaceTextureListener(null);     // Catch: Throwable -> L25
        this.mTextureView.removeOnLayoutChangeListener(this);     // Catch: Throwable -> L25
        goto L15
    L29:
        throw new IllegalStateException("Try to dispose an not initialized VideoFrameRender");
    }

    public void onStart() {
        if (this.mHasRenderViewAtomic.get() == true) goto L5;
        return;
    L5:
        if (this.mHasInitAtomic.get() == true) goto L8;
        return;
    L8:
        if (this.mTextureView == null) goto L11;
        initTextureView();
        return;
    L11:
        if (this.mSurfaceView == null) goto L16;
        initSurfaceView();
        return;
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize == true) goto L5;
    L21:
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        this.mSurfaceView.getHolder().setSizeFromLayout();
        return;
    L5:
        if (this.rotatedFrameWidth == 0) goto L21;
        if (this.rotatedFrameHeight == 0) goto L21;
        if (this.mSurfaceView.getWidth() == 0) goto L21;
        if (this.mSurfaceView.getHeight() == 0) goto L21;
        float r100 = this.mSurfaceView.getWidth() / this.mSurfaceView.getHeight();
        int r101 = this.rotatedFrameWidth;
        int r102 = this.rotatedFrameHeight;
        if ((r101 / r102) <= r100) goto L15;
        r101 = (int) (r102 * r100);
    L16:
        int r103 = Math.min(this.mSurfaceView.getWidth(), r101);
        int r104 = Math.min(this.mSurfaceView.getHeight(), r102);
        LogUtil.d(TAG, "updateSurfaceSize. Layout size: " + this.mSurfaceView.getWidth() + "x" + this.mSurfaceView.getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + r103 + "x" + r104 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if (r103 == this.surfaceWidth) goto L19;
    L20:
        this.surfaceWidth = r103;
        this.surfaceHeight = r104;
        this.mSurfaceView.getHolder().setFixedSize(r103, r104);
        return;
    L19:
        if (r104 != this.surfaceHeight) goto L20;
        return;
    L15:
        r102 = (int) (r101 / r100);
        goto L16
    }

    @Override // com.ss.bytertc.base.media.EglRenderer.FirstVideoFrameRenderListener
    public void onFirstVideoFrameRender() {
        notifyFristRenderCallback();
    }

    public void release() {
        onDispose();
    }

    public VideoFrameRender(String r100) {
        this.mReceiveFirstTimeStampMs = 0;
        this.mHasReceivedFirstFrame = false;
        this.mHasInitAtomic = new AtomicBoolean(false);
        this.mHasRenderViewAtomic = new AtomicBoolean(false);
        this.mEglSurfaceCreatedAtomic = new AtomicBoolean(false);
        this.mRenderLock = new Object();
        this.mTextureProcessLock = new Object();
        this.mFirstFrameListenerLock = new Object();
        this.mFirstVideoFrameListeners = new ArrayList();
        this.mRenderName = r100;
        this.frameConverter = new VideoFrameConverter(true);
        this.mSurfaceLifecycleCallbackCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ AtomicBoolean access$000(VideoFrameRender r100) {
        return r100.mEglSurfaceCreatedAtomic;
    }

    public static /* synthetic */ AtomicBoolean access$100(VideoFrameRender r100) {
        return r100.mHasInitAtomic;
    }

    private /* synthetic */ void lambda$init$0(EglBase.Context r100) {
        this.mEglRenderer.init(r100, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    private void onVideoFrame(VideoFrame r100) {
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglSurfaceCreatedAtomic.get() == true) goto L7;
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L7:
        if (this.mEglRenderer == null) goto L15;
        if (this.mHasReceivedFirstFrame == true) goto L12;
        this.mReceiveFirstTimeStampMs = System.currentTimeMillis();     // Catch: Throwable -> L17
        this.mHasReceivedFirstFrame = true;     // Catch: Throwable -> L17
    L12:
        this.mEglRenderer.onFrame(r100);     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
    }

    private void postOrRun(Runnable r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L6;
        r100.run();
        return;
    }

    private void runOnUIThread(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r100);
    }

    public void consumeVideoFrame(IVideoFrame r100) {
        if (r100.bufferType() != VideoBufferType.GL_TEXTURE) goto L6;
        VideoFrame r101 = WebRTCConverter.convertByteTexFrame2WebrtcTexFrame(r100, this.mTextureProcessLooper);
    L12:
        if (r101 == null) goto L15;
        onVideoFrame(r101);
        r101.release();
        return;
    L15:
        return;
    L6:
        if (r100.pixelFormat() != VideoPixelFormat.I420) goto L9;
        r101 = WebRTCConverter.convertByteI420Frame2WebrtcI420Frame(r100);
        goto L12
    L9:
        if (r100.pixelFormat() != VideoPixelFormat.RGBA) goto L11;
        r101 = WebRTCConverter.convertByteRGBAFrame2WebrtcI420Frame(r100);
        goto L12
    L11:
        r101 = null;
        goto L12
    }

    public void init(final EglBase.Context r100) {
        if (this.mHasInitAtomic.compareAndSet(false, true) == false) goto L26;
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.mSurfaceView == null) goto L9;
    L16:
        this.rotatedFrameWidth = 0;     // Catch: Throwable -> L22
        this.rotatedFrameHeight = 0;     // Catch: Throwable -> L22
        if ((this.mEglRenderer instanceof SurfaceEglRender) == false) goto L19;
        ThreadUtils.invokeAtFrontUninterruptibly(new Handler(Looper.getMainLooper()), new e(this, r100));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L19:
        this.mEglRenderer.init(r100, EglBase.CONFIG_PLAIN, new GlRectDrawer());     // Catch: Throwable -> L22
        goto L20
    L9:
        if (this.mSurface != null) goto L16;
        if (this.mTextureView != null) goto L16;
        if (this.mEglRenderer != null) goto L16;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L26:
        throw new IllegalStateException("Already initialized");
    }

    public void setEnableHardwareScaler(boolean r100) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = r100;
        if (this.mSurfaceView == null) goto L6;
        updateSurfaceSize();
        return;
    }

    public void setFpsReduction(float r100) {
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglRenderer == null) goto L7;
        this.mEglRenderer.setFpsReduction(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void setFristVideoFrameRenderListener(FirstVideoFrameRenderListener r100) {
        Object r101 = this.mFirstFrameListenerLock;
        monitor-enter(r101);
        this.mFirstVideoFrameListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMirror(boolean r100) {
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglRenderer == null) goto L7;
        this.mEglRenderer.setMirror(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void setProcessTextureLopper(Looper r100) {
        Object r101 = this.mTextureProcessLock;
        monitor-enter(r101);
        this.mTextureProcessLooper = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRenderView(Surface r100) {
        if (this.mEglSurfaceCreatedAtomic.get() == true) goto L17;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mHasRenderViewAtomic.compareAndSet(false, true) == false) goto L21;
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
        this.mSurface = r100;     // Catch: Throwable -> L14
        new EglRenderer(this.mRenderName).createEglSurface(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        this.mEglSurfaceCreatedAtomic.compareAndSet(false, true);
        return;
    L14:
        th = move-exception;
        throw th;
    L21:
        return;
    }

    public void setScalingType(RendererCommon.ScalingType r100) {
        Object r101 = this.mRenderLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglRenderer == null) goto L7;
        this.mEglRenderer.setRenderModel(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    private /* synthetic */ void lambda$onFrameResolutionChanged$1(int r100, int r101) {
        this.rotatedFrameWidth = r100;
        this.rotatedFrameHeight = r101;
    }

    public void setRenderView(SurfaceView r100, SurfaceHolder.Callback r101) {
        if (this.mEglSurfaceCreatedAtomic.get() == true) goto L16;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mHasRenderViewAtomic.compareAndSet(false, true) == false) goto L20;
        this.mSurfaceView = r100;
        Object r102 = this.mRenderLock;
        monitor-enter(r102);
        SurfaceEglRender r103 = new SurfaceEglRender(this.mRenderName);     // Catch: Throwable -> L13
        r103.setSurfaceHolderCallback(r101);     // Catch: Throwable -> L13
        r103.setSurfaceLifecycleLisenter(this.mSurfaceLifecycleCallbackCallback);     // Catch: Throwable -> L13
        this.mEglRenderer = r103;     // Catch: Throwable -> L13
        this.mEglRenderer.addFristFrameListener(this);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    public void setRenderView(TextureView r100, TextureView.SurfaceTextureListener r101) {
        if (this.mEglSurfaceCreatedAtomic.get() == true) goto L16;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mHasRenderViewAtomic.compareAndSet(false, true) == false) goto L20;
        Object r102 = this.mRenderLock;
        monitor-enter(r102);
        this.mTextureView = r100;     // Catch: Throwable -> L13
        TextureEglRenderer r103 = new TextureEglRenderer(this.mRenderName);     // Catch: Throwable -> L13
        r103.setSurfaceTextureListener(r101);     // Catch: Throwable -> L13
        this.mEglRenderer = r103;     // Catch: Throwable -> L13
        this.mEglRenderer.addFristFrameListener(this);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    private VideoFrame.Buffer createYUV(byte[] r110, int r111, int r112) {
        if (r110 != null) goto L5;
    L23:
        return null;
    L5:
        if (r110.length == 0) goto L23;
        int r113 = (r111 + 1) / 2;
        int r100 = r111 * r112;
        int r101 = ((r112 + 1) / 2) * r113;
        final ByteBuffer r102 = ByteBufferUtils.nativeAllocateBuffer(r100);
        final ByteBuffer r103 = ByteBufferUtils.nativeAllocateBuffer(r101);
        final ByteBuffer r104 = ByteBufferUtils.nativeAllocateBuffer(r101);
        if (r102 == null) goto L17;
        if (r103 == null) goto L17;
        if (r104 == null) goto L17;
        r102.put(r110, 0, r100);
        r103.put(r110, r100, r101);
        r104.put(r110, r100 + r101, r101);
        r102.position(0);
        r103.position(0);
        r104.position(0);
        if ((this.mEglRenderer instanceof TextureEglRenderer) == false) goto L16;
        return CountDownLatchI420Buffer.wrap(r111, r112, r102, r111, r103, r113, r104, r113, new a(r102, r103, r104));
    L16:
        return JavaI420Buffer.wrap(r111, r112, r102, r111, r103, r113, r104, r113, new b(r102, r103, r104));
    L17:
        if (r102 == null) goto L19;
        ByteBufferUtils.nativeReleaseBuffer(r102);
    L19:
        if (r103 == null) goto L21;
        ByteBufferUtils.nativeReleaseBuffer(r103);
    L21:
        if (r104 == null) goto L23;
        ByteBufferUtils.nativeReleaseBuffer(r104);
        goto L23
    }

    private static /* synthetic */ void lambda$createYUV$3(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102) {
        ByteBufferUtils.nativeReleaseBuffer(r100);
        ByteBufferUtils.nativeReleaseBuffer(r101);
        ByteBufferUtils.nativeReleaseBuffer(r102);
    }

    private static /* synthetic */ void lambda$createYUV$4(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102) {
        ByteBufferUtils.nativeReleaseBuffer(r100);
        ByteBufferUtils.nativeReleaseBuffer(r101);
        ByteBufferUtils.nativeReleaseBuffer(r102);
    }

    @Override // com.bytedance.realx.video.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int r100, int r101, int r102) {
        if (r102 == 0) goto L7;
        if (r102 == 180) goto L7;
        final int r103 = r101;
    L8:
        if (r102 == 0) goto L10;
        if (r102 == 180) goto L10;
    L11:
        postOrRun(new d(this, r103, r100));
        return;
    L10:
        r100 = r101;
    L7:
        r103 = r100;
        goto L8
    }

    private void renderI420Frame(byte[] r100, int r101, int r102, int r103, long r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L15;
        VideoFrameConverter r105 = this.frameConverter;
        if (r105 != null) goto L8;
        return;
    L8:
        if ((this.mEglRenderer instanceof TextureEglRenderer) == false) goto L10;
        VideoFrame.I420Buffer r106 = r105.convertToJavaI420Buffer(r100, r101, r102, true);
    L11:
        if (r106 == null) goto L17;
        VideoFrame r107 = new VideoFrame(r106, r103, r104);
        onVideoFrame(r107);
        r107.release();
        return;
    L17:
        return;
    L10:
        r106 = r105.convertToJavaI420Buffer(r100, r101, r102, false);
        goto L11
    }

    private void renderI420Frame(ByteBuffer r100, int r101, int r102, int r103, long r104) {
        if (r100 == null) goto L12;
        VideoFrameConverter r105 = this.frameConverter;
        if (r105 != null) goto L6;
        return;
    L6:
        if ((this.mEglRenderer instanceof TextureEglRenderer) == false) goto L8;
        VideoFrame.I420Buffer r106 = r105.convertToJavaI420Buffer(r100, r101, r102, true);
    L9:
        if (r106 == null) goto L14;
        VideoFrame r107 = new VideoFrame(r106, r103, r104);
        onVideoFrame(r107);
        r107.release();
        return;
    L14:
        return;
    L8:
        r106 = r105.convertToJavaI420Buffer(r100, r101, r102, false);
        goto L9
    }

    public void consumeByteArrayFrame(byte[] r100, ByteBuffer r101, int r110, int r111, int r112, int r113, long r114) {
        if (r110 == VideoPixelFormat.I420.value()) goto L5;
        return;
    L5:
        renderI420Frame(r100, r111, r112, r113, r114);
    }

    public void consumeByteBufferFrame(ByteBuffer r100, ByteBuffer r101, int r110, int r111, int r112, int r113, long r114) {
        if (r110 == VideoPixelFormat.I420.value()) goto L5;
        return;
    L5:
        renderI420Frame(r100, r111, r112, r113, r114);
    }

    private void renderTextureFrame(int r110, VideoFrame.TextureBuffer.Type r111, int r112, int r113, int r114, long r115, float[] r116, Looper r117) {
        VideoFrame r100 = new VideoFrame(new TextureBufferImpl(r112, r113, r111, r110, RendererCommon.convertMatrixToAndroidGraphicsMatrix(r116), new Handler(r117), new YuvConverter(), new c()), r114, r115);
        onVideoFrame(r100);
        r100.release();
    }

    public void consumeTextureFrame(int r110, ByteBuffer r111, int r112, int r113, int r114, int r115, long r210, float[] r211) {
        if (r112 == VideoPixelFormat.I420.value()) goto L5;
        return;
    L5:
        Object r116 = this.mTextureProcessLock;
        monitor-enter(r116);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mTextureProcessLooper != null) goto L10;
        this.mTextureProcessLooper = Looper.getMainLooper();     // Catch: Throwable -> L13
    L10:
        renderTextureFrame(r110, VideoFrame.TextureBuffer.Type.RGB, r113, r114, r115, r210, r211, this.mTextureProcessLooper);     // Catch: Throwable -> L13
        monitor-exit(r116);     // Catch: Throwable -> L13
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        ThreadUtils.checkIsOnMainThread();
        Object r109 = this.mRenderLock;
        monitor-enter(r109);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mEglRenderer == null) goto L8;
        this.mEglRenderer.setLayoutAspectRatio((r103 - r101) / (r104 - r102));     // Catch: Throwable -> L12
    L8:
        if (this.mSurfaceView == null) goto L10;
        updateSurfaceSize();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r109);     // Catch: Throwable -> L12
    }

    public void consumeYUVByteArrayFrame(byte[] r110, byte[] r111, byte[] r210, int r211, int r212, int r213, int r214, int r215, int r216, long r217, ByteBuffer r218) {
        renderI420Frame(this.frameConverter.convertRawYUV2ByteArray(r110, r111, r210, r211, r212, r213, r214, r215), r214, r215, r216, r217);
    }
}
