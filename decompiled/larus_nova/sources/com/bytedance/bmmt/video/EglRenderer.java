package com.bytedance.bmmt.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private static GlClearWorkaround.WORKAROUND_STATUS enableGLWorkaround;
    private final GlTextureFrameBuffer bitmapTextureFramebuffer;
    private final Matrix drawMatrix;
    private RendererCommon.GlDrawer drawer;
    private EglBase eglBase;
    private final EglSurfaceCreation eglSurfaceCreationRunnable;
    private final Object firstRenderLock;
    private final ArrayList<FirstVideoFrameRenderListener> firstVideoFrameListeners;
    private final Object fpsReductionLock;
    private final VideoFrameDrawer frameDrawer;
    private final ArrayList<FrameListenerAndParams> frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final GlClearWorkaround glClearWorkaround;
    private final Object handlerLock;
    private boolean haveRenderFirstVideoFrame;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private final Runnable logStatisticsRunnable;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    protected final String name;
    private long nextFrameTimeNs;
    private BmmtVideoFrameInterface pendingFrame;
    private volatile RendererCommon.ScalingType renderModel;
    private long renderSwapBufferTimeNs;
    private Handler renderThreadHandler;
    private long renderTimeNs;
    private final Object statisticsLock;
    private long statisticsStartTimeNs;
    private boolean usePresentationTimeStamp;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.EglRenderer$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = null;

        static {
            int[] r100 = new int[RendererCommon.ScalingType.values().length];
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = r100;
            r100[RendererCommon.ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_FILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class EglSurfaceCreation implements Runnable {
        private Object surface;
        final /* synthetic */ EglRenderer this$0;

        public /* synthetic */ EglSurfaceCreation(EglRenderer r100, int r101) {
            this(r100);
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            monitor-enter(this);
            com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation_com_larus_apm_impl_protector_RunnableLancet_run(this);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation__run$___twin___() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L5:
            if (this.surface != null) goto L7;
        L19:
            monitor-exit(this);
            return;
        L7:
            if (EglRenderer.i(this.this$0) == null) goto L19;
            if (EglRenderer.i(this.this$0).hasSurface() == true) goto L19;
            Object r100 = this.surface;     // Catch: Throwable -> L21
            if ((r100 instanceof Surface) == false) goto L14;
            EglRenderer.i(this.this$0).createSurface((Surface) this.surface);     // Catch: Throwable -> L21
        L16:
            EglRenderer.i(this.this$0).makeCurrent();     // Catch: Throwable -> L21
            GLES20.glPixelStorei(3317, 1);     // Catch: Throwable -> L21
            goto L19
        L14:
            if ((r100 instanceof SurfaceTexture) == false) goto L18;
            EglRenderer.i(this.this$0).createSurface((SurfaceTexture) this.surface);     // Catch: Throwable -> L21
            goto L16
        L18:
            throw new IllegalStateException("Invalid surface: " + this.surface);     // Catch: Throwable -> L21
        }

        private EglSurfaceCreation(EglRenderer r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation_com_larus_apm_impl_protector_RunnableLancet_run(EglSurfaceCreation r100) {
            r100.com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public synchronized void setSurface(Object r100) {
            monitor-enter(this);
            this.surface = r100;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public interface FirstVideoFrameRenderListener {
        void onFirstVideoFrameRender();
    }

    public interface FrameListener {
        void onFrame(Bitmap r100);
    }

    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener r100, float r101, RendererCommon.GlDrawer r102, boolean r103) {
            this.listener = r100;
            this.scale = r101;
            this.drawer = r102;
            this.applyFpsReduction = r103;
        }
    }

    public static class HandlerWithExceptionCallback extends Handler {
        private final Runnable exceptionCallback;

        @Override // android.os.Handler
        public void dispatchMessage(Message r100) {
            super.dispatchMessage(r100);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e);
            this.exceptionCallback.run();
            throw e;
        }

        public HandlerWithExceptionCallback(Looper r100, Runnable r101) {
            super(r100);
            this.exceptionCallback = r101;
        }
    }

    public static /* synthetic */ void a(EglRenderer r100, float r101, float r102, float r103, float r104) {
        r100.lambda$clearImage$6(r101, r102, r103, r104);
    }

    public static /* synthetic */ void b(EglRenderer r100, EglBase.Context r101, int[] r102) {
        r100.lambda$init$0(r101, r102);
    }

    public static /* synthetic */ void c(EglRenderer r100, RendererCommon.GlDrawer r101, FrameListener r102, float r103, boolean r104) {
        r100.lambda$addFrameListener$3(r101, r102, r103, r104);
    }

    public static /* synthetic */ void d(EglRenderer r100) {
        r100.renderFrameOnRenderThread();
    }

    public static /* synthetic */ void e(EglRenderer r100, Runnable r101) {
        r100.lambda$releaseEglSurface$5(r101);
    }

    public static /* synthetic */ void f(EglRenderer r100, CountDownLatch r101) {
        r100.lambda$release$1(r101);
    }

    public static /* synthetic */ void g(EglRenderer r100, Looper r101) {
        r100.lambda$release$2(r101);
    }

    public static /* synthetic */ void h(EglRenderer r100, CountDownLatch r101, FrameListener r102) {
        r100.lambda$removeFrameListener$4(r101, r102);
    }

    public static /* bridge */ /* synthetic */ EglBase i(EglRenderer r100) {
        return r100.eglBase;
    }

    public static /* bridge */ /* synthetic */ Object j(EglRenderer r100) {
        return r100.handlerLock;
    }

    public static /* bridge */ /* synthetic */ Runnable k(EglRenderer r100) {
        return r100.logStatisticsRunnable;
    }

    public static /* bridge */ /* synthetic */ Handler l(EglRenderer r100) {
        return r100.renderThreadHandler;
    }

    public static /* bridge */ /* synthetic */ void m(EglRenderer r100) {
        r100.renderThreadHandler = null;
    }

    public static /* bridge */ /* synthetic */ void n(EglRenderer r100) {
        r100.logStatistics();
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    static {
        enableGLWorkaround = GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown;
    }

    private void logStatistics() {
        DecimalFormat r100 = new DecimalFormat("#.0");
        long r101 = System.nanoTime();
        Object r102 = this.statisticsLock;
        monitor-enter(r102);
        long r103 = r101 - this.statisticsStartTimeNs;     // Catch: Throwable -> L11
        if (r103 > 0) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(r103) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + r100.format((((long) this.framesRendered) * TimeUnit.SECONDS.toNanos(1)) / r103) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");     // Catch: Throwable -> L11
        resetStatistics(r101);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void notifyFristRenderCallback() {
        Object r100 = this.firstRenderLock;
        monitor-enter(r100);
        Iterator<FirstVideoFrameRenderListener> r101 = this.firstVideoFrameListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onFirstVideoFrameRender();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void renderFrameOnRenderThread() {
        Object r100 = this.frameLock;
        monitor-enter(r100);
        BmmtVideoFrameInterface r101 = this.pendingFrame;     // Catch: Throwable -> L88
        if (r101 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L88
        return;
    L8:
        this.pendingFrame = null;     // Catch: Throwable -> L88
        monitor-exit(r100);     // Catch: Throwable -> L88
        EglBase r102 = this.eglBase;
        if (r102 != null) goto L13;
    L86:
        logD("Dropping frame - No surface");
        r101.release();
        return;
    L13:
        if (r102.hasSurface() == false) goto L86;
        Object r103 = this.fpsReductionLock;
        monitor-enter(r103);
        long r104 = this.minRenderPeriodNs;     // Catch: Throwable -> L83
        if (r104 != Long.MAX_VALUE) goto L21;
    L19:
        boolean r110 = false;
    L27:
        monitor-exit(r103);     // Catch: Throwable -> L83
        long r111 = System.nanoTime();
        if (r101.getRotatedHeight() > 0) goto L31;
        return;
    L31:
        float r105 = r101.getRotatedWidth() / r101.getRotatedHeight();
        Object r106 = this.layoutLock;
        monitor-enter(r106);
        float r107 = this.layoutAspectRatio;     // Catch: Throwable -> L80
        if (r107 != 0.0f) goto L37;
        r107 = r105;
    L37:
        monitor-exit(r106);     // Catch: Throwable -> L80
        int r108 = this.eglBase.surfaceWidth();
        int r109 = this.eglBase.surfaceHeight();
        int r112 = AnonymousClass3.$SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[this.renderModel.ordinal()];
        float r113 = 1.0f;
        if (r112 == 1) goto L50;
        if (r112 != 2) goto L42;
        float r114 = 1.0f;
    L46:
        float r115 = 1.0f;
    L47:
        int r116 = 0;
    L48:
        int r117 = 0;
    L53:
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        Matrix r118 = this.drawMatrix;
        if (this.mirrorHorizontally == false) goto L56;
        float r119 = -1.0f;
    L58:
        if (this.mirrorVertically == false) goto L60;
        r113 = -1.0f;
    L60:
        r118.preScale(r119, r113);
        this.drawMatrix.preScale(r115, r114);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        if (r110 == false) goto L74;
        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, 0.0f, 0.0f, 0.0f, 0.0f);
        boolean r120 = true;
        this.frameDrawer.drawFrame(r101, this.drawer, this.drawMatrix, r116, r117, r108, r109);
        long r121 = System.nanoTime();
        if (this.usePresentationTimeStamp == false) goto L65;
        this.eglBase.swapBuffers(r101.getTimestampNs());
    L66:
        long r122 = System.nanoTime();
        Object r123 = this.statisticsLock;
        monitor-enter(r123);
        this.framesRendered++;     // Catch: Throwable -> L71
        this.renderTimeNs += r122 - r111;     // Catch: Throwable -> L71
        this.renderSwapBufferTimeNs += r122 - r121;     // Catch: Throwable -> L71
        monitor-exit(r123);     // Catch: Throwable -> L71
    L75:
        notifyCallbacks(r101, r110);
        if (this.haveRenderFirstVideoFrame == true) goto L78;
        notifyFristRenderCallback();
        this.haveRenderFirstVideoFrame = r120;
    L78:
        r101.release();
        return;
    L71:
        th = move-exception;
        throw th;
    L65:
        this.eglBase.swapBuffers();
        goto L66
    L74:
        r120 = true;
        goto L75
    L56:
        r119 = 1.0f;
        goto L58
    L42:
        if (r105 <= r107) goto L44;
        r115 = r107 / r105;
        r108 = r108;
        r109 = r109;
        r114 = 1.0f;
        goto L47
    L44:
        r114 = r105 / r107;
        goto L46
    L50:
        if (r105 <= r107) goto L52;
        int r124 = (int) (this.eglBase.surfaceWidth() / r105);
        r109 = r124;
        r108 = r108;
        r117 = (this.eglBase.surfaceHeight() - r124) / 2;
        r114 = 1.0f;
        r115 = 1.0f;
        r116 = 0;
        goto L53
    L52:
        int r125 = (int) (this.eglBase.surfaceHeight() * r105);
        r108 = r125;
        r116 = (this.eglBase.surfaceWidth() - r125) / 2;
        r109 = r109;
        r114 = 1.0f;
        r115 = 1.0f;
    L80:
        th = move-exception;
        throw th;
    L21:
        if (r104 > 0) goto L23;
    L22:
        r110 = true;
        goto L27
    L23:
        long r126 = System.nanoTime();     // Catch: Throwable -> L83
        long r127 = this.nextFrameTimeNs;     // Catch: Throwable -> L83
        if (r126 >= r127) goto L26;
        logD("Skipping frame rendering - fps reduction is active.");     // Catch: Throwable -> L83
        goto L19
    L26:
        long r128 = r127 + this.minRenderPeriodNs;     // Catch: Throwable -> L83
        this.nextFrameTimeNs = r128;     // Catch: Throwable -> L83
        this.nextFrameTimeNs = Math.max(r128, r126);     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        throw th;
    L88:
        th = move-exception;
        throw th;
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void printStackTrace() {
        Object r100 = this.handlerLock;
        monitor-enter(r100);
        Handler r101 = this.renderThreadHandler;     // Catch: Throwable -> L16
        if (r101 != null) goto L7;
        Thread r102 = null;
    L8:
        if (r102 == null) goto L14;
        StackTraceElement[] r103 = r102.getStackTrace();     // Catch: Throwable -> L16
        if (r103.length <= 0) goto L14;
        logW("EglRenderer stack trace:");     // Catch: Throwable -> L16
        int r104 = r103.length;     // Catch: Throwable -> L16
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L14;
        logW(r103[r105].toString());     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L7:
        r102 = ThreadMethodProxy.getLooperThread(r101.getLooper());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void release() {
        logD("Releasing.");
        final CountDownLatch r100 = new CountDownLatch(1);
        Object r101 = this.handlerLock;
        monitor-enter(r101);
        Handler r102 = this.renderThreadHandler;     // Catch: Throwable -> L22
        if (r102 != null) goto L9;
        logD("Already released");     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L9:
        r102.removeCallbacks(this.logStatisticsRunnable);     // Catch: Throwable -> L22
        this.renderThreadHandler.postAtFrontOfQueue(new g(this, r100));     // Catch: Throwable -> L22
        final Looper r103 = this.renderThreadHandler.getLooper();     // Catch: Throwable -> L22
        this.renderThreadHandler.post(new h(this, r103));     // Catch: Throwable -> L22
        this.renderThreadHandler = null;     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        ThreadUtils.awaitUninterruptibly(r100);
        Object r104 = this.frameLock;
        monitor-enter(r104);
        BmmtVideoFrameInterface r105 = this.pendingFrame;     // Catch: Throwable -> L19
        if (r105 == null) goto L16;
        r105.release();     // Catch: Throwable -> L19
        this.pendingFrame = null;     // Catch: Throwable -> L19
    L16:
        monitor-exit(r104);     // Catch: Throwable -> L19
        logD("Releasing done.");
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    public EglRenderer(String r100) {
        this.glClearWorkaround = new GlClearWorkaround();
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList();
        this.firstVideoFrameListeners = new ArrayList();
        this.fpsReductionLock = new Object();
        this.frameDrawer = new VideoFrameDrawer();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.firstRenderLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
        this.renderModel = RendererCommon.ScalingType.SCALE_ASPECT_FILL;
        this.logStatisticsRunnable = new AnonymousClass1(this);
        this.eglSurfaceCreationRunnable = new EglSurfaceCreation(this, 0);
        this.name = r100;
        this.haveRenderFirstVideoFrame = false;
    }

    private void createEglSurfaceInternal(Object r100) {
        this.eglSurfaceCreationRunnable.setSurface(r100);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    private /* synthetic */ void lambda$release$1(CountDownLatch r100) {
        this.glClearWorkaround.release();
        GLES20.glUseProgram(0);
        RendererCommon.GlDrawer r101 = this.drawer;
        if (r101 == null) goto L5;
        r101.release();
        this.drawer = null;
    L5:
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase == null) goto L8;
        logD("eglBase detach and release.");
        this.eglBase.detachCurrent();
        this.eglBase.release();
        this.eglBase = null;
    L8:
        this.frameListeners.clear();
        Object r102 = this.firstRenderLock;
        monitor-enter(r102);
        this.firstVideoFrameListeners.clear();     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        r100.countDown();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$release$2(Looper r100) {
        logD("Quitting render thread.");
        ThreadMethodProxy.quit(r100);
    }

    private /* synthetic */ void lambda$releaseEglSurface$5(Runnable r100) {
        EglBase r101 = this.eglBase;
        if (r101 == null) goto L5;
        r101.detachCurrent();
        this.eglBase.releaseSurface();
    L5:
        r100.run();
    }

    private void logD(String r100) {
        Logging.i(TAG, this.name + r100);
    }

    private void logW(String r100) {
        Logging.w(TAG, this.name + r100);
    }

    private void postToRenderThread(Runnable r100) {
        Object r101 = this.handlerLock;
        monitor-enter(r101);
        Handler r102 = this.renderThreadHandler;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.post(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void resetStatistics(long r100) {
        Object r101 = this.statisticsLock;
        monitor-enter(r101);
        this.statisticsStartTimeNs = r100;     // Catch: Throwable -> L7
        this.framesReceived = 0;     // Catch: Throwable -> L7
        this.framesDropped = 0;     // Catch: Throwable -> L7
        this.framesRendered = 0;     // Catch: Throwable -> L7
        this.renderTimeNs = 0;     // Catch: Throwable -> L7
        this.renderSwapBufferTimeNs = 0;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFristFrameListener(FirstVideoFrameRenderListener r100) {
        Object r101 = this.firstRenderLock;
        monitor-enter(r101);
        this.firstVideoFrameListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void createEglSurface(SurfaceTexture r100) {
        createEglSurfaceInternal(r100);
    }

    @Override // com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r100) {
        Object r101 = this.statisticsLock;
        monitor-enter(r101);
        this.framesReceived++;     // Catch: Throwable -> L40
        monitor-exit(r101);     // Catch: Throwable -> L40
        Object r102 = this.handlerLock;
        monitor-enter(r102);
    L37:
        th = move-exception;
        throw th;
    L9:
        if (this.renderThreadHandler != null) goto L13;
        logD("Dropping frame - Not initialized or already released.");     // Catch: Throwable -> L37
        monitor-exit(r102);     // Catch: Throwable -> L37
        return;
    L13:
        Object r103 = this.frameLock;     // Catch: Throwable -> L37
        monitor-enter(r103);     // Catch: Throwable -> L37
        BmmtVideoFrameInterface r104 = this.pendingFrame;     // Catch: Throwable -> L34
        if (r104 == null) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r104.release();     // Catch: Throwable -> L34
    L21:
        this.pendingFrame = r100;     // Catch: Throwable -> L34
        r100.retain();     // Catch: Throwable -> L34
        this.renderThreadHandler.post(new d(this));     // Catch: Throwable -> L34
        monitor-exit(r103);     // Catch: Throwable -> L34
        monitor-exit(r102);     // Catch: Throwable -> L37
        if (r105 == false) goto L33;
        Object r106 = this.statisticsLock;
        monitor-enter(r106);
        this.framesDropped++;     // Catch: Throwable -> L30
        monitor-exit(r106);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L33:
        return;
    L18:
        r105 = false;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L40:
        th = move-exception;
        throw th;
    }

    public void releaseEglSurface(final Runnable r100) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        Object r101 = this.handlerLock;
        monitor-enter(r101);
        Handler r102 = this.renderThreadHandler;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.removeCallbacks(this.eglSurfaceCreationRunnable);     // Catch: Throwable -> L12
        this.renderThreadHandler.postAtFrontOfQueue(new f(this, r100));     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        r100.run();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeFrameListener(final FrameListener r100) {
        final CountDownLatch r101 = new CountDownLatch(1);
        Object r102 = this.handlerLock;
        monitor-enter(r102);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.renderThreadHandler != null) goto L9;
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(this.renderThreadHandler.getLooper())) goto L15;
        postToRenderThread(new e(this, r101, r100));     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        ThreadUtils.awaitUninterruptibly(r101);
        return;
    L15:
        throw new RuntimeException("removeFrameListener must not be called on the render thread.");     // Catch: Throwable -> L16
    }

    public void setFpsReduction(float r100) {
        logD("setFpsReduction: " + r100);
        Object r101 = this.fpsReductionLock;
        monitor-enter(r101);
        long r102 = this.minRenderPeriodNs;     // Catch: Throwable -> L13
        if (r100 > 0.0f) goto L7;
        this.minRenderPeriodNs = Long.MAX_VALUE;     // Catch: Throwable -> L13
    L9:
        if (this.minRenderPeriodNs == r102) goto L11;
        this.nextFrameTimeNs = System.nanoTime();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        this.minRenderPeriodNs = (long) (TimeUnit.SECONDS.toNanos(1) / r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void setLayoutAspectRatio(float r100) {
        logD("setLayoutAspectRatio: " + r100);
        Object r101 = this.layoutLock;
        monitor-enter(r101);
        this.layoutAspectRatio = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMirror(boolean r100) {
        logD("setMirrorHorizontally: " + r100);
        Object r101 = this.layoutLock;
        monitor-enter(r101);
        this.mirrorHorizontally = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMirrorVertically(boolean r100) {
        logD("setMirrorVertically: " + r100);
        Object r101 = this.layoutLock;
        monitor-enter(r101);
        this.mirrorVertically = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRenderModel(RendererCommon.ScalingType r100) {
        this.renderModel = r100;
    }

    public void createEglSurface(Surface r100) {
        createEglSurfaceInternal(r100);
    }

    private String averageTimeAsString(long r100, int r101) {
        if (r101 > 0) goto L5;
        return "NA";
    L5:
        return TimeUnit.NANOSECONDS.toMicros(r100 / ((long) r101)) + " us";
    }

    private /* synthetic */ void lambda$init$0(EglBase.Context r100, int[] r101) {
        if (r100 != null) goto L4;
        logD("EglBase10.create context");
        this.eglBase = EglBase.CC.createEgl10(r101);
    L5:
        this.glClearWorkaround.init();
        return;
    L4:
        logD("EglBase.create shared context");
        this.eglBase = EglBase.CC.create(r100, r101);
        goto L5
    }

    private /* synthetic */ void lambda$removeFrameListener$4(CountDownLatch r100, FrameListener r101) {
        r100.countDown();
        Iterator<FrameListenerAndParams> r102 = this.frameListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r102.next().listener != r101) goto L4;
        r102.remove();
        goto L4
    }

    private void notifyCallbacks(BmmtVideoFrameInterface r210, boolean r211) {
        if (this.frameListeners.isEmpty() == false) goto L5;
        return;
    L5:
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        Matrix r100 = this.drawMatrix;
        if (this.mirrorHorizontally == false) goto L8;
        float r101 = -1.0f;
    L10:
        if (this.mirrorVertically == false) goto L12;
        float r102 = -1.0f;
    L13:
        r100.preScale(r101, r102);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> r103 = this.frameListeners.iterator();
    L15:
        if (r103.hasNext() == false) goto L27;
        FrameListenerAndParams r110 = r103.next();
        if (r211 == true) goto L21;
        if (r110.applyFpsReduction == true) goto L15;
    L21:
        r103.remove();
        int r111 = (int) (r110.scale * r210.getRotatedWidth());
        int r112 = (int) (r110.scale * r210.getRotatedHeight());
        if (r111 == 0) goto L26;
        if (r112 == 0) goto L26;
        this.bitmapTextureFramebuffer.setSize(r111, r112);
        GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
        glClear(r111, r112, 16384, 0.0f, 0.0f, 0.0f, 0.0f);
        this.frameDrawer.drawFrame(r210, r110.drawer, this.drawMatrix, 0, 0, r111, r112);
        ByteBuffer r113 = ByteBuffer.allocateDirect((r111 * r112) * 4);
        GLES20.glViewport(0, 0, r111, r112);
        GLES20.glReadPixels(0, 0, r111, r112, 6408, 5121, r113);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
        Bitmap r104 = Bitmap.createBitmap(r111, r112, Bitmap.Config.ARGB_8888);
        r104.copyPixelsFromBuffer(r113);
        r110.listener.onFrame(r104);
    L26:
        r110.listener.onFrame(null);
        goto L15
    L27:
        return;
    L12:
        r102 = 1.0f;
        goto L13
    L8:
        r101 = 1.0f;
        goto L10
    }

    public void addFrameListener(FrameListener r100, float r101) {
        addFrameListener(r100, r101, null, false);
    }

    public void addFrameListener(FrameListener r100, float r101, RendererCommon.GlDrawer r102) {
        addFrameListener(r100, r101, r102, false);
    }

    public void init(EglBase.Context r100, int[] r101, RendererCommon.GlDrawer r102) {
        init(r100, r101, r102, false);
    }

    private void clearSurfaceOnRenderThread(float r110, float r111, float r112, float r113) {
        EglBase r100 = this.eglBase;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hasSurface() == false) goto L9;
        logD("clearSurface");
        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, r110, r111, r112, r113);
        this.eglBase.swapBuffers();
        return;
    }

    private /* synthetic */ void lambda$addFrameListener$3(RendererCommon.GlDrawer r100, FrameListener r101, float r102, boolean r103) {
        if (r100 != null) goto L4;
        r100 = this.drawer;
    L4:
        this.frameListeners.add(new FrameListenerAndParams(r101, r102, r100, r103));
    }

    private /* synthetic */ void lambda$clearImage$6(float r100, float r101, float r102, float r103) {
        clearSurfaceOnRenderThread(r100, r101, r102, r103);
    }

    public void addFrameListener(final FrameListener r100, final float r101, final RendererCommon.GlDrawer r110, final boolean r111) {
        postToRenderThread(new j(this, r110, r100, r101, r111));
    }

    public void clearImage(final float r110, final float r111, final float r112, final float r113) {
        Object r100 = this.handlerLock;
        monitor-enter(r100);
        Handler r101 = this.renderThreadHandler;     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        r101.postAtFrontOfQueue(new c(this, r110, r111, r112, r113));     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void init(final EglBase.Context r100, final int[] r101, RendererCommon.GlDrawer r102, boolean r103) {
        Object r104 = this.handlerLock;
        monitor-enter(r104);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.renderThreadHandler != null) goto L10;
        logD("Initializing EglRenderer");     // Catch: Throwable -> L11
        this.drawer = r102;     // Catch: Throwable -> L11
        this.usePresentationTimeStamp = r103;     // Catch: Throwable -> L11
        PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2(this.name + TAG);     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r105);     // Catch: Throwable -> L11
        HandlerWithExceptionCallback r106 = new HandlerWithExceptionCallback(r105.getLooper(), new AnonymousClass2(this));     // Catch: Throwable -> L11
        this.renderThreadHandler = r106;     // Catch: Throwable -> L11
        ThreadUtils.invokeAtFrontUninterruptibly(r106, new i(this, r100, r101));     // Catch: Throwable -> L11
        this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);     // Catch: Throwable -> L11
        resetStatistics(System.nanoTime());     // Catch: Throwable -> L11
        this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4));     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException(this.name + "Already initialized");     // Catch: Throwable -> L11
    }

    private void glClear(int r110, int r111, int r112, float r113, float r114, float r115, float r116) {
        if (enableGLWorkaround != GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown) goto L6;
        enableGLWorkaround = GlClearWorkaround.isNeedWorkaround();
    L6:
        if (enableGLWorkaround != GlClearWorkaround.WORKAROUND_STATUS.kStatusEnable) goto L8;
        this.glClearWorkaround.clear(r110, r111, r112, r113, r114, r115, r116, 1.0f, 8);
        return;
    L8:
        GLES20.glClearColor(r113, r114, r115, r116);
        GLES20.glClear(16384);
    }
}
