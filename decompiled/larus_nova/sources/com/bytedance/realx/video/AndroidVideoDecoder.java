package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Surface;
import androidx.camera.core.RetryPolicy;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.memory.NativeRXByteMemory;
import com.bytedance.realx.video.memory.NativeRXVideoFrame;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
class AndroidVideoDecoder extends MediaCodec.Callback implements VideoDecoder, VideoSink {
    private static final int ADAPTIVE_PLAYBACK_MAX_DIMENSION = 9000;
    private static final int DEFAULT_OUTPUT_FRAME_WAIT_TIME_MS = 16;
    private static final int DEQUEUE_INPUT_INDEX_TIME_US = 5000;
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final String DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE = "bytertc.hw.decoder.dr.vsync.cache.size";
    private static final int DIRECT_RENDER_MODE_BY_VSYNC = 2;
    private static final int DIRECT_RENDER_MODE_NONE = 0;
    private static final int DIRECT_RENDER_MODE_NORMAL = 1;
    private static final String ENABLE_CHECK_SYS_RESOLUTION_SUPPORT = "bytertc.check.sys.resolution.support.enable";
    private static final String FLAG_CHECK_TEXTURE_SIZE = "bytertc.hw.decoder.check.texture.size";
    private static final String FLAG_TEXTURE_MEMORY_REUSE = "bytertc.hw.decoder.texture.memory.reuse";
    private static final String HISI_DECODER_END_CODE = "bytertc.hisi.decoder.endcode.enable";
    private static final String MAX_EGL_NUM = "bytertc.hw.decoder.maxeglnum";
    private static final int MAX_OUTPUT_FRAME_WAIT_TIME_MS = 1300;
    private static final int MAX_RECREATE_DECODER_COUNT = 2;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 6000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final int MIN_OUTPUT_FRAME_TIME_DELTA_MS = 10;
    private static final String NEW_INPUT_BUFFER_API = "bytertc.hw.decoder.newinputbuffer";
    private static final String NEW_OUTPUT_BUFFER_API = "bytertc.hw.decoder.newoutputbuffer";
    private static final String TAG = "AndroidVideoDecoder";
    private static final int TEXTURE_PLAYOUT_INSIDE_DECODER = 0;
    private static final int TEXTURE_PLAYOUT_OUTSIDE_DECODER = 1;
    private static int curEglContextNum = 0;
    private static int maxDirectRenderCacheSize = 5;
    private static int maxEglContextNum = 16;
    private int adaptive_playback_max_height;
    private int adaptive_playback_max_width;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private long avgInputTimeDelta;
    private VideoDecoder.Callback callback;
    private long callbackDecodedFrameCount;
    private final Object callbackLock;
    private MediaCodecWrapper codec;
    private final String codecName;
    private final RXVideoCodecStandard codecType;
    private int colorFormat;
    private long currentFrameCache;
    private long currentInputTimeDelta;
    private long currentOutputTime;
    private final Object dimensionLock;
    private int directRenderMode;
    private Thread directRenderThread;
    private long dropDecodedFrameCount;
    boolean enableCheckSysResolutionSupport;
    boolean enableHisiEndCode;
    private boolean enableRetryDeliver;
    boolean enableTextureMemoryReuse;
    boolean enableTextureSizeCheck;
    private boolean enable_adaptive_playback;
    private int encoded_height;
    private int encoded_width;
    private Surface exSurface;
    private int frameCacheThreshold;
    private boolean hasDecodedFirstFrame;
    private int height;
    private LinkedList<Integer> inputBuffers;
    private long inputFrameCount;
    private AtomicBoolean isError;
    private boolean keyFrameRequired;
    private long lastInputTime;
    private long lastOutputTime;
    private float maxDeaccelerateRatio;
    private int maxExSurfaceRecreateDecoderCount;
    private int maxTryCount;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private float minAccelerateRatio;
    private long minFrameCache;
    private boolean mustUseYUVoutput;
    private SurfaceTextureHelper outSideSurfaceTextureHelper;
    private LinkedBlockingQueue<OutputBufferInfo> outputBufferQueue;
    private final Object outputBufferQueueLock;
    private long outputFrameCount;
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private long packetCount2s;
    private HashMap<String, String> privateParams;
    private DecodedTextureMetadata renderedTextureMetadata;
    private final Object renderedTextureMetadataLock;
    private volatile boolean running;
    private VideoDecoder.Settings settings;
    private EglBase.Context sharedContext;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private final Object smoothOutputLock;
    private int stride;
    private Surface surface;
    private SurfaceTextureHelper surfaceTextureHelper;
    private final Object surfaceTextureHelperLock;
    private int texturePlayoutMode;
    private long timeForAvg;
    private boolean useAsyncMode;
    private boolean useNewInputBufferAPI;
    private boolean useNewOutputBufferAPI;
    private boolean usingInternalSurfaceLast;
    private HashMap<String, String> vpassPrivateParams;
    private int width;

    public static class DecodedTextureMetadata {
        final long presentationTimestampUs;

        public DecodedTextureMetadata(long r100) {
            this.presentationTimestampUs = r100;
        }
    }

    public static class OutputBufferInfo {
        final int bufferIndex;
        final long presentationTimestampUs;

        public OutputBufferInfo(long r100, int r101) {
            this.presentationTimestampUs = r100;
            this.bufferIndex = r101;
        }
    }

    public static /* synthetic */ void a(AndroidVideoDecoder r100, HandlerThread r101) {
        r100.lambda$releaseInternal$0(r101);
    }

    public static /* synthetic */ int b(AndroidVideoDecoder r100, int r101, MediaCodec.BufferInfo r102, boolean r103) {
        return r100.lambda$deliverTextureFrameOutSide$1(r101, r102, r103);
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public final /* synthetic */ long createNativeVideoDecoder() {
        return VideoDecoder.CC.$default$createNativeVideoDecoder(this);
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    private void createDirectRenderVSyncThread() {
        PthreadThreadV2 r100 = new PthreadThreadV2(new AnonymousClass1(this), TAG);
        this.directRenderThread = r100;
        ThreadMethodProxy.start(r100);
    }

    private Thread createOutputThread() {
        final String r100 = "AndroidVideoDecoder.outputThread";
        return new AnonymousClass3(this, r100);
    }

    private VideoCodecStatus initSurfaceTextureHelper() {
    L19:
        e = move-exception;
        RXLogging.e(TAG, "err when create surface:" + e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L3:
        if (this.sharedContext != null) goto L7;
        if (this.settings.enableAGFXSurfaceTextureHelper == true) goto L7;
    L18:
        return VideoCodecStatus.OK;
    L7:
        if (this.exSurface != null) goto L18;
        VideoDecoder.Settings r100 = this.settings;     // Catch: Exception -> L19
        if (r100.enableYUVOutput == true) goto L18;
        if (curEglContextNum >= maxEglContextNum) goto L18;
        if (this.surfaceTextureHelper != null) goto L15;
    L16:
        SurfaceTextureHelper r101 = createSurfaceTextureHelper();     // Catch: Exception -> L19
        this.surfaceTextureHelper = r101;     // Catch: Exception -> L19
        initSurfaceTextureHelper(r101, false);     // Catch: Exception -> L19
        goto L18
    L15:
        if (r100.enableSurfaceTextureReuse == true) goto L18;
        goto L16
    }

    private void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: IllegalStateException -> L5
    L6:
        RXLogging.i(TAG, "Releasing MediaCodec on output thread");
        this.codec.stop();     // Catch: Exception -> L9
    L24:
        this.codec.release();     // Catch: Exception -> L13
    L16:
        if (this.settings.enableSurfaceTextureReuse == true) goto L18;
        releaseSurface();
    L18:
        RXLogging.i(TAG, "Release on output thread done");
        return;
    L13:
        e = move-exception;
        RXLogging.e(TAG, "Media decoder release failed", e);
        this.shutdownException = e;
    L9:
        e = move-exception;
        RXLogging.e(TAG, "Media decoder stop failed", e);
    L5:
        RXLogging.e(TAG, "thread check err");
        goto L6
    }

    private VideoCodecStatus releaseInternal() {
        if (this.running == true) goto L36;
        RXLogging.d(TAG, "release: Decoder is not running.");
        return VideoCodecStatus.OK;
    L36:
        Thread r100 = this.directRenderThread;     // Catch: Exception -> L11
        if (r100 == null) goto L14;
        ThreadMethodProxy.join(r100, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);     // Catch: Exception -> L11
        this.directRenderThread = null;     // Catch: Exception -> L11
    L14:
        if (this.useAsyncMode == false) goto L38;
        VideoCodecStatus r101 = VideoCodecStatus.OK;
        this.running = false;
        final HandlerThread r102 = this.asyncOutputThread;
        if (r102 == null) goto L21;
        this.asyncHandler.post(new a(this, r102));
        if (ThreadUtils.joinUninterruptibly(this.asyncOutputThread, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS) == true) goto L20;
        RXLogging.e(TAG, "Media decoder release timeout", new RuntimeException());
        r101 = VideoCodecStatus.TIMEOUT;
    L20:
        this.asyncOutputThread = null;
        this.asyncHandler = null;
    L21:
        return r101;
    L38:
        this.running = false;     // Catch: Throwable -> L33
        if (ThreadUtils.joinUninterruptibly(this.outputThread, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS) == true) goto L27;
        RXLogging.e(TAG, "Media decoder release timeout", new RuntimeException());     // Catch: Throwable -> L33
        VideoCodecStatus r103 = VideoCodecStatus.TIMEOUT;     // Catch: Throwable -> L33
        this.codec = null;
        this.outputThread = null;
        return r103;
    L27:
        this.codec = null;
        this.outputThread = null;
        if (this.shutdownException == null) goto L32;
        RXLogging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
        this.shutdownException = null;
        return VideoCodecStatus.ERROR;
    L32:
        return VideoCodecStatus.OK;
    L33:
        th = move-exception;
        this.codec = null;
        this.outputThread = null;
        throw th;
    L11:
        e = move-exception;
        RXLogging.e(TAG, "directRenderThread join error", e);
        goto L14
    }

    private void updateCheckSysResolutionStatus() {
        Iterator<Map.Entry<String, String>> r100 = this.privateParams.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Map.Entry<String, String> r101 = r100.next();
        if (r101.getKey().equals(ENABLE_CHECK_SYS_RESOLUTION_SUPPORT) == false) goto L4;
        if (r101.getValue() == "0") goto L9;
        if (r101.getValue() != "1") goto L4;
        this.enableCheckSysResolutionSupport = true;
        RXLogging.w(TAG, "set android hardware decoder open check sys resolution support");
        goto L4
    L9:
        this.enableCheckSysResolutionSupport = false;
        RXLogging.w(TAG, "set android hardware decoder close check sys resolution support");
        goto L4
    }

    public SurfaceTextureHelper createSurfaceTextureHelper() {
        if (this.settings.enableAGFXSurfaceTextureHelper == false) goto L7;
        return SurfaceTextureHelper.createWithAGFX("decoder-texture-thread");
    L7:
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    public void deliverDecodedFrame() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: Exception -> L20
        if (this.codec != null) goto L7;
        RXLogging.w(TAG, "codec is null when call deliverDecodedFrame");     // Catch: Exception -> L20
        return;
    L7:
        MediaCodec.BufferInfo r100 = new MediaCodec.BufferInfo();     // Catch: Exception -> L20
        MediaCodecWrapper r101 = this.codec;     // Catch: Exception -> L20
        if (this.settings.latencyInsensitiveMode == false) goto L10;
        long r102 = OpenConfig.DEFAULT_LOADING_TIMEOUT;
    L11:
        int r103 = r101.dequeueOutputBuffer(r100, r102);     // Catch: Exception -> L20
        if (r103 != (-2)) goto L15;
        reformat(this.codec.getOutputFormat());     // Catch: Exception -> L20
        return;
    L15:
        if (r103 >= 0) goto L18;
        RXLogging.w(TAG, "dequeueOutputBuffer err, returned " + r103);     // Catch: Exception -> L20
        return;
    L18:
        drainOutputFrame(r100, r103);     // Catch: Exception -> L20
        return;
    L10:
        r102 = 100000;
    L20:
        RXLogging.e(TAG, "deliverDecodedFrame failed");
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public void disableExternalSurface() {
        RXLogging.w(TAG, "disable external surface.");
        this.exSurface = null;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus release() {
        RXLogging.w(TAG, "mediacodec release start");
        VideoCodecStatus r100 = releaseInternal();
        releaseSurface();
        releaseSurfaceTextureHelper();
        Object r101 = this.renderedTextureMetadataLock;
        monitor-enter(r101);
        this.renderedTextureMetadata = null;     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        this.callback = null;
        this.encoded_width = 0;
        this.encoded_height = 0;
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public void releaseSurface() {
        RXLogging.w(TAG, "releaseSurface start");
    L19:
        e = move-exception;
        RXLogging.e(TAG, "releaseSurface:" + e);
    L21:
        RXLogging.w(TAG, "releaseSurface end");
        return;
    L4:
        if (this.surface == null) goto L6;
        RXLogging.w(TAG, "release surface");     // Catch: Exception -> L19
        this.surface.release();     // Catch: Exception -> L19
        this.surface = null;     // Catch: Exception -> L19
    L6:
        Object r100 = this.surfaceTextureHelperLock;     // Catch: Exception -> L19
        monitor-enter(r100);     // Catch: Exception -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L9:
        if (this.surfaceTextureHelper == null) goto L11;
        RXLogging.w(TAG, "surfaceTextureHelper.stopListening()");     // Catch: Throwable -> L16
        this.surfaceTextureHelper.stopListening();     // Catch: Throwable -> L16
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L16
    L13:
        if (this.settings.enableSurfaceTextureReuse == true) goto L21;
        releaseSurfaceTextureHelper();     // Catch: Exception -> L19
        goto L21
    }

    public void releaseSurfaceTextureHelper() {
        Object r100 = this.surfaceTextureHelperLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.surfaceTextureHelper == null) goto L7;
        RXLogging.w(TAG, "release surfaceTextureHelper");     // Catch: Throwable -> L9
        this.surfaceTextureHelper.dispose();     // Catch: Throwable -> L9
        this.surfaceTextureHelper = null;     // Catch: Throwable -> L9
        curEglContextNum--;     // Catch: Throwable -> L9
        RXLogging.w(TAG, "release surfaceTextureHelper done, curEglContextNum:" + curEglContextNum);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    private void directRenderByVSync() {
        Looper.prepare();     // Catch: Exception -> L4
        Choreographer.getInstance().postFrameCallback(new AnonymousClass2(this));     // Catch: Exception -> L4
        Looper.loop();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        RXLogging.e(TAG, "direct render by vsync is error", e);
    }

    private void smoothOutputFrame() {
        long r100 = SystemClock.elapsedRealtime();
        this.currentOutputTime = r100;
        long r101 = this.outputFrameCount;
        long r102 = this.inputFrameCount;
        if (r101 <= r102) goto L5;
        this.outputFrameCount = r102;
    L5:
        long r103 = this.minFrameCache;
        if (r103 >= 0) goto L8;
        this.minFrameCache = this.currentFrameCache;
    L14:
        long r104 = this.lastOutputTime;
        long r105 = r100 - r104;
        long r106 = this.avgInputTimeDelta;
        if (r106 > 0) goto L20;
        r106 = this.currentInputTimeDelta;
        if (r106 > 0) goto L27;
        r106 = 16;
    L27:
        if (r104 > 0) goto L29;
    L48:
        this.lastOutputTime = SystemClock.elapsedRealtime();
        return;
    L29:
        if (r105 >= r106) goto L48;
        long r107 = r106 - r105;
        if (this.currentFrameCache <= this.minFrameCache) goto L34;
        r107 = r107 / 2;
    L34:
        if (r107 <= 1300) goto L37;
        r107 = 1300;
    L37:
        if (r107 <= 0) goto L48;
        Object r108 = this.smoothOutputLock;     // Catch: Exception -> L46
        monitor-enter(r108);     // Catch: Exception -> L46
        this.smoothOutputLock.wait(r107);     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L20:
        long r109 = this.currentInputTimeDelta;
        if (r109 >= r106) goto L27;
        r106 = 10;
        if (r109 <= 10) goto L27;
        r106 = r109;
        goto L27
    L8:
        long r110 = this.currentFrameCache;
        if (r103 > r110) goto L11;
    L13:
        this.minFrameCache = r103;
        goto L14
    L11:
        if (r110 < 0) goto L13;
        r103 = r110;
        goto L13
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    public static /* synthetic */ void access$000(AndroidVideoDecoder r100) {
        r100.directRenderByVSync();
    }

    public static /* synthetic */ Object access$100(AndroidVideoDecoder r100) {
        return r100.outputBufferQueueLock;
    }

    public static /* synthetic */ LinkedBlockingQueue access$200(AndroidVideoDecoder r100) {
        return r100.outputBufferQueue;
    }

    public static /* synthetic */ MediaCodecWrapper access$300(AndroidVideoDecoder r100) {
        return r100.codec;
    }

    public static /* synthetic */ VideoDecoder.Callback access$400(AndroidVideoDecoder r100) {
        return r100.callback;
    }

    public static /* synthetic */ long access$508(AndroidVideoDecoder r100) {
        long r101 = r100.dropDecodedFrameCount;
        r100.dropDecodedFrameCount = 1 + r101;
        return r101;
    }

    public static /* synthetic */ boolean access$700(AndroidVideoDecoder r100) {
        return r100.running;
    }

    public static /* synthetic */ void access$800(AndroidVideoDecoder r100) {
        r100.releaseCodecOnOutputThread();
    }

    private void callbackDirectRenderFrame(long r110) {
        VideoDecoder.Callback r100 = this.callback;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.hasDecodedFirstFrame == true) goto L8;
        this.hasDecodedFirstFrame = true;
    L8:
        NativeRXByteMemory r101 = new NativeRXByteMemory(this.width, this.height, 0, null, null, RXPixelFormat.kUnknown);
        NativeRXVideoFrame r111 = NativeRXVideoFrame.createRXVideoFrame(r101, r110 * 1000, null, RXColorSpace.kUnknown, RXVideoRotation.VIDEO_ROTATION_0);
        r100.onDecodedFrame(r111);
        this.callbackDecodedFrameCount++;
        r101.release();
        r111.release();
    }

    private VideoCodecStatus feedInputBufferAsync(EncodedImage r110) {
        int r100 = r110.buffer.remaining();
        if (this.settings.latencyInsensitiveMode == false) goto L5;
        int r101 = 5000000;
    L6:
        int r102 = r101 / 5000;
    L7:
        Object r103 = this.callbackLock;
        monitor-enter(r103);
        if (this.inputBuffers.size() > 0) goto L12;
        int r104 = -1;
    L13:
        monitor-exit(r103);     // Catch: Throwable -> L40
        if (r104 != (-1)) goto L20;
        r102 = r102 - 1;
        Thread.sleep(5);     // Catch: InterruptedException -> L18
    L18:
        e = move-exception;
        RXLogging.i(TAG, "" + e);
    L20:
        if (r104 != (-1)) goto L22;
        if (r102 > 0) goto L7;
    L22:
        if (r104 != (-1)) goto L45;
        RXLogging.w(TAG, "decode() - no HW buffers available; decoder falling behind");
        return VideoCodecStatus.OVERLOAD;
    L45:
        ByteBuffer r105 = this.codec.getInputBuffer(r104);     // Catch: Exception -> L37
        if (r105.capacity() >= r100) goto L30;
        RXLogging.e(TAG, "decode() - HW buffer too small");
        return VideoCodecStatus.OVERLOAD;
    L30:
        r105.put(r110.buffer);
        this.codec.queueInputBuffer(r104, 0, appendHisiEndCode(r105, r100), TimeUnit.NANOSECONDS.toMicros(r110.captureTimeNs), 0);     // Catch: IllegalStateException -> L34
        return VideoCodecStatus.OK;
    L34:
        e = move-exception;
        RXLogging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L37:
        e = move-exception;
        RXLogging.e(TAG, "getInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L12:
        r104 = this.inputBuffers.removeFirst().intValue();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L5:
        r101 = DEQUEUE_INPUT_TIMEOUT_US;
        goto L6
    }

    private VideoCodecStatus feedInputBufferSync(EncodedImage r110) {
        int r100 = r110.buffer.remaining();
        MediaCodecWrapper r101 = this.codec;     // Catch: IllegalStateException -> L32
        if (this.settings.latencyInsensitiveMode == false) goto L6;
        long r102 = 5000000;
    L7:
        int r103 = r101.dequeueInputBuffer(r102);     // Catch: IllegalStateException -> L32
        if (r103 >= 0) goto L37;
        RXLogging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
        return VideoCodecStatus.OVERLOAD;
    L37:
    L29:
        e = move-exception;
        RXLogging.e(TAG, "getInputBuffers failed,useNewInputBufferAPI" + this.useNewInputBufferAPI + "exception:" + e);
        return VideoCodecStatus.ERROR;
    L12:
        if (this.useNewInputBufferAPI == false) goto L14;
        ByteBuffer r104 = this.codec.getInputBuffer(r103);     // Catch: Exception -> L29
    L15:
        if (r104 != null) goto L19;
        RXLogging.e(TAG, "decode() - HW buffer is null");
        return VideoCodecStatus.OVERLOAD;
    L19:
        if (r104.remaining() >= r100) goto L22;
        RXLogging.e(TAG, "decode() - HW buffer too small");
        return VideoCodecStatus.OVERLOAD;
    L22:
        r104.put(r110.buffer);
        this.codec.queueInputBuffer(r103, 0, appendHisiEndCode(r104, r100), TimeUnit.NANOSECONDS.toMicros(r110.captureTimeNs), 0);     // Catch: IllegalStateException -> L26
        return VideoCodecStatus.OK;
    L26:
        e = move-exception;
        RXLogging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L14:
        r104 = this.codec.getInputBuffers()[r103];     // Catch: Exception -> L29
        goto L15
    L6:
        r102 = 500000;
    L32:
        e = move-exception;
        RXLogging.e(TAG, "dequeueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    }

    private void initMediaFormat(MediaFormat r110) {
        if (this.sharedContext == null) goto L7;
        if (this.settings.enableYUVOutput == true) goto L7;
    L9:
        MediaCodecWrapper r100 = this.codec;
        if (r100 != null) goto L12;
    L22:
        VideoDecoder.Settings r101 = this.settings;
        if (r101.outputByDts == true) goto L25;
    L30:
        Iterator<Map.Entry<String, String>> r102 = this.privateParams.entrySet().iterator();
    L32:
        if (r102.hasNext() == false) goto L49;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey().equals(GXTemplateKey.FLEXBOX_MAX_WIDTH) == true) goto L32;
        if (r103.getKey().equals(GXTemplateKey.FLEXBOX_MAX_HEIGHT) == true) goto L32;
        RXLogging.w(TAG, "set android hardware decoder private param with Key:" + r103.getKey() + " Value:" + r103.getValue());
        if (r103.getKey().equals(HISI_DECODER_END_CODE) == false) goto L43;
        if ("0".equals(r103.getValue()) == false) goto L43;
        this.enableHisiEndCode = false;
        RXLogging.w(TAG, "set android hardware decoder close hisi hw decoder endcode");
    L43:
        RXLogging.w(TAG, "set android hardware decoder private param with Key:" + r103.getKey() + " Value:" + r103.getValue());
        if (isNumeric(r103.getValue()) == true) goto L45;
        if (r103.getValue().length() <= 0) goto L32;
        r110.setString(r103.getKey(), r103.getValue());
        goto L32
    L45:
        r110.setInteger(r103.getKey(), CastIntegerProtector.parseInt(r103.getValue()));
        goto L32
    L49:
        return;
    L25:
        if (r101.latencyInsensitiveMode == true) goto L30;
        setIntegerParam(r110, "low-latency", 1);
        setIntegerParam(r110, "vendor.qti-ext-dec-picture-order.enable", 1);
        setIntegerParam(r110, "vendor.qti-ext-dec-low-latency.enable", 1);
        setIntegerParam(r110, "vendor.rtc-ext-dec-low-latency.enable", 1);
        if (this.width >= this.height) goto L29;
        setIntegerParam(r110, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
    L29:
        setIntegerParam(r110, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        setIntegerParam(r110, "fast-output-mode", 1);
        setStringParam(r110, "vendor.vdec.example-ext-dec-low-latency.enable", "true");
        goto L30
    L12:
        if (r100.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).isFeatureSupported("adaptive-playback") == false) goto L22;
        if (setAdaptivePlaybackParam(r110, GXTemplateKey.FLEXBOX_MAX_WIDTH, Integer.valueOf(r110.getInteger("width"))) == true) goto L16;
    L18:
        boolean r104 = false;
    L19:
        this.enable_adaptive_playback = r104;
        if (r104 == false) goto L22;
        this.adaptive_playback_max_width = r110.getInteger(GXTemplateKey.FLEXBOX_MAX_WIDTH);
        this.adaptive_playback_max_height = r110.getInteger(GXTemplateKey.FLEXBOX_MAX_HEIGHT);
        RXLogging.w(TAG, "enable adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);
        goto L22
    L16:
        if (setAdaptivePlaybackParam(r110, GXTemplateKey.FLEXBOX_MAX_HEIGHT, Integer.valueOf(r110.getInteger("height"))) == false) goto L18;
        r104 = true;
    L7:
        if (this.exSurface != null) goto L9;
        RXLogging.w(TAG, "init colorFormat is(I420:19):" + this.colorFormat);
        setIntegerParam(r110, "color-format", Integer.valueOf(this.colorFormat));
        goto L9
    }

    private boolean isNumeric(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.matches("[0-9]+") == false) goto L6;
        return true;
    }

    private boolean isSupportedColorFormat(int r100) {
        int[] r101 = MediaCodecUtils.DECODER_COLOR_FORMATS;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103] == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void lambda$releaseInternal$0(HandlerThread r100) {
        releaseCodecOnOutputThread();
        if (r100 == null) goto L6;
        r100.quit();
        return;
    }

    private void reformat(MediaFormat r100) {
        this.outputThreadChecker.checkIsOnValidThread();
        if (r100.containsKey(MEDIA_FORMAT_KEY_CROP_LEFT) == true) goto L5;
    L11:
        int r101 = r100.getInteger("width");
        int r102 = r100.getInteger("height");
    L12:
        Object r103 = this.dimensionLock;
        monitor-enter(r103);
    L53:
        th = move-exception;
        throw th;
    L15:
        if (this.hasDecodedFirstFrame == true) goto L17;
    L23:
        this.width = r101;     // Catch: Throwable -> L53
        this.height = r102;     // Catch: Throwable -> L53
        monitor-exit(r103);     // Catch: Throwable -> L53
        if (this.surfaceTextureHelper != null) goto L32;
        if (this.outSideSurfaceTextureHelper != null) goto L32;
        if (this.exSurface != null) goto L32;
    L34:
        if (r100.containsKey("color-format") == false) goto L39;
        this.colorFormat = r100.getInteger("color-format");
        RXLogging.i(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
        if (isSupportedColorFormat(this.colorFormat) == true) goto L39;
        stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
        return;
    L39:
        Object r104 = this.dimensionLock;
        monitor-enter(r104);
    L50:
        th = move-exception;
        throw th;
    L42:
        if (r100.containsKey(MEDIA_FORMAT_KEY_STRIDE) == false) goto L45;
        this.stride = r100.getInteger(MEDIA_FORMAT_KEY_STRIDE);     // Catch: Throwable -> L50
    L45:
        if (r100.containsKey(MEDIA_FORMAT_KEY_SLICE_HEIGHT) == false) goto L47;
        this.sliceHeight = r100.getInteger(MEDIA_FORMAT_KEY_SLICE_HEIGHT);     // Catch: Throwable -> L50
    L47:
        RXLogging.i(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);     // Catch: Throwable -> L50
        this.stride = Math.max(this.width, this.stride);     // Catch: Throwable -> L50
        this.sliceHeight = Math.max(this.height, this.sliceHeight);     // Catch: Throwable -> L50
        monitor-exit(r104);     // Catch: Throwable -> L50
        return;
    L32:
        if (this.settings.enableYUVOutput == false) goto L39;
    L17:
        if (this.width == r101) goto L19;
    L20:
        stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + r101 + "*" + r102));     // Catch: Throwable -> L53
        monitor-exit(r103);     // Catch: Throwable -> L53
        return;
    L19:
        if (this.height == r102) goto L23;
    L5:
        if (r100.containsKey(MEDIA_FORMAT_KEY_CROP_RIGHT) == false) goto L11;
        if (r100.containsKey(MEDIA_FORMAT_KEY_CROP_BOTTOM) == false) goto L11;
        if (r100.containsKey(MEDIA_FORMAT_KEY_CROP_TOP) == false) goto L11;
        r101 = (r100.getInteger(MEDIA_FORMAT_KEY_CROP_RIGHT) + 1) - r100.getInteger(MEDIA_FORMAT_KEY_CROP_LEFT);
        r102 = (r100.getInteger(MEDIA_FORMAT_KEY_CROP_BOTTOM) + 1) - r100.getInteger(MEDIA_FORMAT_KEY_CROP_TOP);
        RXLogging.i(TAG, "stream have crop info newWidth:" + r101 + " newHeight:" + r102);
        goto L12
    }

    private void stopOnOutputThread(Exception r100) {
        this.outputThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode == false) goto L5;
        this.isError.set(true);
        return;
    L5:
        this.running = false;
        this.shutdownException = r100;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus decode(EncodedImage r210) {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = this.lastInputTime;
        if (r101 <= 0) goto L5;
        this.currentInputTimeDelta = r100 - r101;
    L5:
        this.lastInputTime = r100;
        long r102 = this.packetCount2s + 1;
        this.packetCount2s = r102;
        if (0 != this.timeForAvg) goto L8;
        this.timeForAvg = r100;
    L8:
        long r110 = this.timeForAvg;
        if ((r100 - r110) < 2000) goto L14;
        if (r102 <= 0) goto L14;
        this.avgInputTimeDelta = (r100 - r110) / r102;
        this.packetCount2s = 0;
        this.timeForAvg = r100;
    L14:
        if (this.isError.get() == false) goto L118;
        RXLogging.e(TAG, "mediacodec error.");
        return VideoCodecStatus.ERROR;
    L118:
        int r103 = r210.encodedWidth;     // Catch: Exception -> L113
        boolean r104 = true;
        if (r103 != this.encoded_width) goto L22;
        if (r210.encodedHeight != this.encoded_height) goto L22;
    L46:
        if (this.codec != null) goto L48;
    L104:
        StringBuilder r105 = new StringBuilder("decode uninitalized, codec: ");     // Catch: Exception -> L113
        if (this.codec != null) goto L108;
        r104 = false;
    L108:
        r105.append(r104);     // Catch: Exception -> L113
        r105.append(", callback: ");     // Catch: Exception -> L113
        r105.append(this.callback);     // Catch: Exception -> L113
        RXLogging.d(TAG, r105.toString());     // Catch: Exception -> L113
        return VideoCodecStatus.UNINITIALIZED;
    L48:
        if (this.callback == null) goto L104;
        ByteBuffer r106 = r210.buffer;     // Catch: Exception -> L113
        if (r106 != null) goto L55;
        RXLogging.e(TAG, "decode() - no input data");     // Catch: Exception -> L113
        return VideoCodecStatus.ERR_PARAMETER;
    L55:
        if (r106.remaining() != 0) goto L59;
        RXLogging.e(TAG, "decode() - input buffer empty");     // Catch: Exception -> L113
        return VideoCodecStatus.ERR_PARAMETER;
    L59:
        if (this.keyFrameRequired == true) goto L61;
    L68:
        VideoCodecStatus r107 = VideoCodecStatus.OK;     // Catch: Exception -> L113
        if (this.useAsyncMode == false) goto L71;
        VideoCodecStatus r108 = feedInputBufferAsync(r210);     // Catch: Exception -> L113
    L73:
        if (r108 == VideoCodecStatus.OK) goto L76;
        return r108;
    L76:
        if (this.keyFrameRequired == false) goto L78;
        this.keyFrameRequired = false;     // Catch: Exception -> L113
    L78:
        VideoDecoder.Settings r109 = this.settings;     // Catch: Exception -> L113
        if (r109.enableSmoothOutput == true) goto L81;
    L102:
        this.inputFrameCount++;     // Catch: Exception -> L113
        return VideoCodecStatus.OK;
    L81:
        if (r109.latencyInsensitiveMode == true) goto L102;
        if (r109.enableBFrameDecode == true) goto L102;
        long r111 = this.inputFrameCount - this.outputFrameCount;     // Catch: Exception -> L113
        if (r111 > 0) goto L88;
        r111 = this.currentFrameCache;     // Catch: Exception -> L113
    L88:
        this.currentFrameCache = r111;     // Catch: Exception -> L113
        long r112 = this.minFrameCache;     // Catch: Exception -> L113
        if (r112 < 0) goto L102;
        if (r111 <= r112) goto L102;
        Object r113 = this.smoothOutputLock;     // Catch: Exception -> L101
        monitor-enter(r113);     // Catch: Exception -> L101
        this.smoothOutputLock.notify();     // Catch: Throwable -> L98
        monitor-exit(r113);     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        throw th;     // Catch: Exception -> L101
    L101:
        RXLogging.e(TAG, "currentFrameCache:" + this.currentFrameCache + " minFrameCache:" + this.minFrameCache);     // Catch: Exception -> L113
        goto L102
    L71:
        r108 = feedInputBufferSync(r210);     // Catch: Exception -> L113
        goto L73
    L61:
        if (r210.frameType == EncodedImage.FrameType.kIntra) goto L65;
        RXLogging.e(TAG, "decode() - key frame required first");     // Catch: Exception -> L113
        return VideoCodecStatus.NO_OUTPUT;
    L65:
        if (r210.completeFrame == true) goto L68;
        RXLogging.e(TAG, "decode() - complete frame required first");     // Catch: Exception -> L113
        return VideoCodecStatus.NO_OUTPUT;
    L22:
        if (this.codec != null) goto L24;
    L30:
        StringBuilder r114 = new StringBuilder("resolution changed, try to reinit decoder. enable_adaptive_playback: ");     // Catch: Exception -> L113
        r114.append(this.enable_adaptive_playback);     // Catch: Exception -> L113
        r114.append(", is first init: ");     // Catch: Exception -> L113
        if (this.encoded_width != 0) goto L33;
        boolean r115 = true;
    L34:
        r114.append(r115);     // Catch: Exception -> L113
        r114.append(", new width: ");     // Catch: Exception -> L113
        r114.append(r210.encodedWidth);     // Catch: Exception -> L113
        r114.append(", new height: ");     // Catch: Exception -> L113
        r114.append(r210.encodedHeight);     // Catch: Exception -> L113
        RXLogging.w(TAG, r114.toString());     // Catch: Exception -> L113
        if (this.encoded_width != 0) goto L37;
    L38:
        VideoCodecStatus r116 = reinitDecode(r210.encodedWidth, r210.encodedHeight);     // Catch: Exception -> L113
        if (r116 == VideoCodecStatus.OK) goto L41;
        return r116;
    L41:
        Object r117 = this.dimensionLock;     // Catch: Exception -> L113
        monitor-enter(r117);     // Catch: Exception -> L113
        int r118 = r210.encodedWidth;     // Catch: Throwable -> L110
        this.encoded_width = r118;     // Catch: Throwable -> L110
        int r119 = r210.encodedHeight;     // Catch: Throwable -> L110
        this.encoded_height = r119;     // Catch: Throwable -> L110
        this.width = r118;     // Catch: Throwable -> L110
        this.height = r119;     // Catch: Throwable -> L110
        monitor-exit(r117);     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        throw th;     // Catch: Exception -> L113
    L37:
        if (this.enable_adaptive_playback == true) goto L41;
    L33:
        r115 = false;
        goto L34
    L24:
        if (this.enable_adaptive_playback == false) goto L30;
        if (r103 <= this.adaptive_playback_max_width) goto L28;
    L29:
        RXLogging.w(TAG, "frame resolution(" + r210.encodedWidth + "*" + r210.encodedHeight + " exceeded maximum limit of adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);     // Catch: Exception -> L113
        this.enable_adaptive_playback = false;     // Catch: Exception -> L113
        goto L30
    L28:
        if (r210.encodedHeight <= this.adaptive_playback_max_height) goto L30;
    L113:
        e = move-exception;
        RXLogging.e(TAG, "android decode err", e);
        return VideoCodecStatus.ERROR;
    }

    @Override // com.bytedance.realx.video.VideoDecoder, com.bytedance.realx.video.VideoSink
    public void onFrame(RXVideoFrameInterface r110) {
        VideoDecoder.Callback r100 = this.callback;
        if (r100 != null) goto L6;
        this.dropDecodedFrameCount++;
        RXLogging.e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
        return;
    L6:
        Object r101 = this.renderedTextureMetadataLock;
        monitor-enter(r101);
        DecodedTextureMetadata r102 = this.renderedTextureMetadata;     // Catch: Throwable -> L17
        if (r102 != null) goto L13;
        RXLogging.e(TAG, "renderedTextureMetadata is null drop current decoded frame,running:" + this.running);     // Catch: Throwable -> L17
        r100.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "renderedTextureMetadata is null");     // Catch: Throwable -> L17
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L13:
        long r103 = r102.presentationTimestampUs * 1000;     // Catch: Throwable -> L17
        this.renderedTextureMetadata = null;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        r110.setTimestampNs(r103);
        r100.onDecodedFrame(r110);
        this.callbackDecodedFrameCount++;
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public void setExternalSurface(Surface r100) {
        RXLogging.w(TAG, "set external surface:" + r100);
        if (r100 == this.exSurface) goto L10;
        MediaCodecWrapper r101 = this.codec;
        if (r101 == null) goto L10;
        r101.setOutputSurface(r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        RXLogging.e(TAG, "setOutputSurface error:" + e);
    L10:
        this.exSurface = r100;
        this.surface = null;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus updateSettings(VideoDecoder.Settings r100) {
        this.settings = r100;
        RXLogging.w(TAG, "updateSettings outputByDts:" + this.settings.outputByDts + ", smoothOutput:" + this.settings.enableSmoothOutput + ", yuv mode:" + this.settings.enableYUVOutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", context: " + this.settings.sharedContext + ", enableAsyncMode:" + r100.enableAsyncMode + ", directRenderMode:" + r100.directRenderMode + ", texturePlayoutMode:" + r100.texturePlayoutMode);
        return VideoCodecStatus.OK;
    }

    public static /* synthetic */ void access$600(AndroidVideoDecoder r100, long r101) {
        r100.callbackDirectRenderFrame(r101);
    }

    private int appendHisiEndCode(ByteBuffer r100, int r101) {
        if (this.enableHisiEndCode == true) goto L5;
        return r101;
    L5:
        if (this.codecName.startsWith("OMX.hisi") == false) goto L11;
        byte[] r102 = {0, 0, 0, 1, 30, 72, 83, 80, 73, 67, 69, 78, 68, 0, 0, 0, 1, 0};
        int r103 = r101 + 18;
        if (r100.capacity() < r103) goto L12;
        r100.put(r102);
        return r103;
    L12:
        return r101;
    L11:
        return r101;
    }

    private void deliverByteFrame(int r110, MediaCodec.BufferInfo r210) {
        Object r100 = this.dimensionLock;
        monitor-enter(r100);
        int r101 = this.width;     // Catch: Throwable -> L48
        int r102 = this.height;     // Catch: Throwable -> L48
        int r103 = this.stride;     // Catch: Throwable -> L48
        int r104 = this.sliceHeight;     // Catch: Throwable -> L48
        monitor-exit(r100);     // Catch: Throwable -> L48
        VideoDecoder.Callback r105 = this.callback;
        int r106 = r210.size;
        if (r106 >= (((r101 * r102) * 3) / 2)) goto L11;
        RXLogging.e(TAG, "Insufficient output buffer size: " + r210.size);
        return;
    L11:
        if (r106 >= (((r103 * r102) * 3) / 2)) goto L15;
        if (r104 != r102) goto L15;
        if (r103 <= r101) goto L15;
        int r107 = (r106 * 2) / (r102 * 3);
    L54:
    L45:
        e = move-exception;
        RXLogging.e(TAG, "getOutputBuffer failed!", e);
        return;
    L17:
        if (this.useAsyncMode == false) goto L20;
        ByteBuffer r108 = this.codec.getOutputBuffer(r110);     // Catch: Exception -> L45
    L23:
        r108.position(r210.offset);     // Catch: Exception -> L45
        r108.limit(r210.offset + r210.size);     // Catch: Exception -> L45
        ByteBuffer r109 = r108.slice();     // Catch: Exception -> L45
    L42:
        e = move-exception;
        RXLogging.e(TAG, "buffer err!", e);
        this.dropDecodedFrameCount++;
        return;
    L26:
        if (this.colorFormat != 19) goto L28;
        NativeRXByteMemory r111 = copyI420Buffer(r109, r107, r104, r101, r102);     // Catch: Exception -> L42
    L29:
        if (r111 != null) goto L56;
        RXLogging.e(TAG, "byteMemory is null, colorFormat:" + this.colorFormat);
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;
        return;
    L56:
        this.codec.releaseOutputBuffer(r110, false);     // Catch: Exception -> L39
        NativeRXVideoFrame r112 = NativeRXVideoFrame.createRXVideoFrame(r111, r210.presentationTimeUs * 1000, null, RXColorSpace.kUnknown, RXVideoRotation.VIDEO_ROTATION_0);
        if (r105 != null) goto L37;
        RXLogging.e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;
        r111.release();
        r112.release();
        return;
    L37:
        r105.onDecodedFrame(r112);
        this.callbackDecodedFrameCount++;
        r111.release();
        r112.release();
        return;
    L39:
        e = move-exception;
        RXLogging.e(TAG, "releaseOutputBuffer failed!", e);
        r111.release();
        return;
    L28:
        r111 = copyNV12Buffer(r109, r107, r104, r101, r102);     // Catch: Exception -> L42
        goto L29
    L20:
        if (this.useNewOutputBufferAPI == false) goto L22;
        r108 = this.codec.getOutputBuffer(r110);     // Catch: Exception -> L45
        goto L23
    L22:
        r108 = this.codec.getOutputBuffers()[r110];     // Catch: Exception -> L45
    L15:
        r107 = r103;
    L48:
        th = move-exception;
        throw th;
    }

    private void deliverTextureFrame(int r110, MediaCodec.BufferInfo r111) {
        Object r100 = this.dimensionLock;
        monitor-enter(r100);
        int r101 = this.width;     // Catch: Throwable -> L119
        int r102 = this.height;     // Catch: Throwable -> L119
        monitor-exit(r100);     // Catch: Throwable -> L119
        VideoDecoder.Settings r103 = this.settings;
        if (r103.enableSmoothOutput == false) goto L12;
        if (r103.latencyInsensitiveMode == true) goto L12;
        smoothOutputFrame();
    L12:
        if (this.settings.latencyInsensitiveMode == false) goto L37;
        if (this.running == false) goto L37;
        boolean r104 = true;
        int r105 = 0;
    L16:
        if (r104 == false) goto L37;
        if (r105 >= 200) goto L37;
        r105 = r105 + 1;
        Object r106 = this.renderedTextureMetadataLock;
        monitor-enter(r106);
    L33:
        th = move-exception;
        throw th;
    L22:
        if (this.renderedTextureMetadata != null) goto L24;
        boolean r107 = false;
    L25:
        monitor-exit(r106);     // Catch: Throwable -> L33
        if (r107 == false) goto L32;
        Thread.sleep(10);     // Catch: InterruptedException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        r104 = r107;
        goto L16
    L24:
        r107 = true;
    L37:
        if (this.enableRetryDeliver == true) goto L39;
    L69:
        VideoDecoder.Callback r108 = this.callback;
        Object r112 = this.renderedTextureMetadataLock;
        monitor-enter(r112);
    L116:
        th = move-exception;
        throw th;
    L72:
        if (this.renderedTextureMetadata == null) goto L85;
        MediaCodecWrapper r109 = this.codec;     // Catch: Throwable -> L116
        if (r109 == null) goto L85;
        r109.releaseOutputBuffer(r110, false);     // Catch: IllegalStateException -> L77 Throwable -> L116
    L80:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L116
        if (r108 == null) goto L83;
        r108.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "waiting for texture for the previous frame");     // Catch: Throwable -> L116
    L83:
        monitor-exit(r112);     // Catch: Throwable -> L116
        return;
    L77:
        e = move-exception;
        RXLogging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L116
    L85:
        Object r113 = this.surfaceTextureHelperLock;     // Catch: Throwable -> L116
        monitor-enter(r113);     // Catch: Throwable -> L116
        SurfaceTextureHelper r114 = this.surfaceTextureHelper;     // Catch: Throwable -> L113
        if (r114 == null) goto L100;
        r114.setTextureSize(r101, r102, this.enableTextureSizeCheck);     // Catch: Throwable -> L113
        monitor-exit(r113);     // Catch: Throwable -> L113
        this.renderedTextureMetadata = new DecodedTextureMetadata(r111.presentationTimeUs);     // Catch: Throwable -> L116
        MediaCodecWrapper r115 = this.codec;     // Catch: Throwable -> L116
        if (r115 != null) goto L128;
    L98:
        monitor-exit(r112);     // Catch: Throwable -> L116
        return;
    L128:
        r115.releaseOutputBuffer(r110, true);     // Catch: IllegalStateException -> L95 Throwable -> L116
    L95:
        e = move-exception;
        RXLogging.e(TAG, "releaseOutputBuffer failed!", e);     // Catch: Throwable -> L116
        goto L98
    L100:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L113
        if (r108 == null) goto L103;
        r108.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "surfaceTextureHelper is null");     // Catch: Throwable -> L113
    L103:
        RXLogging.e(TAG, "surfaceTextureHelper is null, drop current decoded frame.");     // Catch: Throwable -> L113
        MediaCodecWrapper r116 = this.codec;     // Catch: Throwable -> L113
        if (r116 != null) goto L122;
    L110:
        monitor-exit(r113);     // Catch: Throwable -> L113
        monitor-exit(r112);     // Catch: Throwable -> L116
        return;
    L122:
        r116.releaseOutputBuffer(r110, false);     // Catch: IllegalStateException -> L107 Throwable -> L113
    L107:
        e = move-exception;
        RXLogging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        throw th;     // Catch: Throwable -> L116
    L39:
        if (this.running == false) goto L69;
        long r117 = SystemClock.elapsedRealtime();
        long r118 = this.inputFrameCount - this.outputFrameCount;
        if (r118 >= 0) goto L44;
        r118 = this.frameCacheThreshold + 1;
    L44:
        this.currentFrameCache = r118;
        RXLogging.i(TAG, "currentFrameCache:" + this.currentFrameCache);
        if (this.currentFrameCache > this.frameCacheThreshold) goto L47;
        float r119 = this.maxTryCount;
        float r120 = this.maxDeaccelerateRatio;
    L48:
        int r121 = (int) (r119 * r120);
        boolean r122 = true;
    L49:
        if (r122 == false) goto L68;
        if ((SystemClock.elapsedRealtime() - r117) >= r121) goto L68;
        Object r123 = this.renderedTextureMetadataLock;
        monitor-enter(r123);
    L65:
        th = move-exception;
        throw th;
    L55:
        if (this.renderedTextureMetadata != null) goto L57;
        boolean r124 = false;
    L58:
        monitor-exit(r123);     // Catch: Throwable -> L65
        if (r124 == false) goto L64;
        Thread.sleep(1);     // Catch: InterruptedException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
    L64:
        r122 = r124;
        goto L49
    L57:
        r124 = true;
    L68:
        RXLogging.i(TAG, "retry delivering frame take ms: " + (SystemClock.elapsedRealtime() - r117));
        goto L69
    L47:
        r119 = this.maxTryCount;
        r120 = this.minAccelerateRatio;
    L119:
        th = move-exception;
        throw th;
    }

    private void deliverTextureFrameOutSide(final int r100, final MediaCodec.BufferInfo r101) {
        this.renderedTextureMetadata = new DecodedTextureMetadata(r101.presentationTimeUs);
        Object r102 = this.surfaceTextureHelperLock;
        monitor-enter(r102);
        SurfaceTextureHelper r103 = this.outSideSurfaceTextureHelper;     // Catch: Throwable -> L19
        if (r103 == null) goto L10;
        r103.setTextureSize(this.width, this.height);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        this.outSideSurfaceTextureHelper.onFrame(new MediaCodecTextureBufferHelper(new b(this, r100, r101)));
        return;
    L10:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L19
        this.callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "outSideSurfaceTextureHelper is null");     // Catch: Throwable -> L19
        RXLogging.e(TAG, "outSideSurfaceTextureHelper is null, drop current decoded frame.");     // Catch: Throwable -> L19
        MediaCodecWrapper r104 = this.codec;     // Catch: Throwable -> L19
        if (r104 != null) goto L23;
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L23:
        r104.releaseOutputBuffer(r100, false);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        RXLogging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void drainOutputFrame(MediaCodec.BufferInfo r110, int r111) {
        this.outputFrameCount++;
        if (this.isError.get() == false) goto L6;
        RXLogging.w(TAG, "codec is error when call drainOutputFrame");
        return;
    L6:
        VideoDecoder.Callback r100 = this.callback;
        if (r100 != null) goto L10;
        RXLogging.e(TAG, "callback is null, return");
        return;
    L10:
        boolean r101 = true;
        if (this.exSurface == null) goto L44;
        int r102 = this.texturePlayoutMode;
        if (r102 == 0) goto L60;
        if (1 != r102) goto L63;
        deliverTextureFrameOutSide(r111, r110);
        return;
    L63:
        return;
    L60:
        int r103 = this.directRenderMode;     // Catch: Exception -> L37
        if (1 != r103) goto L21;
        if (Build.VERSION.SDK_INT < 23) goto L19;
        this.codec.releaseOutputBuffer(r111, r110.presentationTimeUs * 1000);     // Catch: Exception -> L37
    L35:
        if (r101 == false) goto L61;
        callbackDirectRenderFrame(r110.presentationTimeUs);
        return;
    L61:
        return;
    L19:
        this.codec.releaseOutputBuffer(r111, true);     // Catch: Exception -> L37
        goto L35
    L21:
        if (2 != r103) goto L34;
        Object r104 = this.outputBufferQueueLock;     // Catch: Exception -> L37
        monitor-enter(r104);     // Catch: Exception -> L37
        this.outputBufferQueue.put(new OutputBufferInfo(r110.presentationTimeUs, r111));     // Catch: Throwable -> L31
        if (this.outputBufferQueue.size() <= maxDirectRenderCacheSize) goto L29;
        OutputBufferInfo r112 = this.outputBufferQueue.poll();     // Catch: Throwable -> L31
        if (r112 == null) goto L29;
        this.codec.releaseOutputBuffer(r112.bufferIndex, false);     // Catch: Throwable -> L31
        r100.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "direct render drop frame");     // Catch: Throwable -> L31
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L31
    L29:
        monitor-exit(r104);     // Catch: Throwable -> L31
        r101 = false;
        goto L35
    L31:
        th = move-exception;
        throw th;     // Catch: Exception -> L37
    L34:
        this.codec.releaseOutputBuffer(r111, true);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        StringWriter r113 = new StringWriter();
        e.printStackTrace(new PrintWriter(r113));
        r100.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, r113.toString());
        r100.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "releaseOutputBuffer err");
        this.dropDecodedFrameCount++;
        return;
    L44:
        if (this.hasDecodedFirstFrame == true) goto L47;
        this.hasDecodedFirstFrame = true;
    L47:
        if (this.surfaceTextureHelper == null) goto L52;
        if (this.texturePlayoutMode != 0) goto L52;
        deliverTextureFrame(r111, r110);
        return;
    L52:
        if (this.outSideSurfaceTextureHelper != null) goto L54;
    L56:
        deliverByteFrame(r111, r110);
        return;
    L54:
        if (1 != this.texturePlayoutMode) goto L56;
        deliverTextureFrameOutSide(r111, r110);
    }

    private VideoCodecStatus initDecodeInternal(int r110, int r111) {
        if (this.callback != null) goto L6;
        RXLogging.d(TAG, "callback uninitalized");
        return VideoCodecStatus.UNINITIALIZED;
    L6:
        long r100 = SystemClock.elapsedRealtime();
        VideoCodecStatus r101 = VideoCodecStatus.OK;
        if (1 != this.texturePlayoutMode) goto L9;
        VideoCodecStatus r102 = initOutSideSurfaceTextureHelper(r110, r111);
    L11:
        if (r102 == VideoCodecStatus.OK) goto L13;
        return r102;
    L13:
        RXLogging.w(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + r110 + " height: " + r111 + " sharedContext:" + this.sharedContext + " outputByDts:" + this.settings.outputByDts + ", external surface:" + this.exSurface + ", internal surface:" + this.surface + " smoothOutput:" + this.settings.enableSmoothOutput + " yuv mode:" + this.settings.enableYUVOutput + " mustUseYUVoutput:" + this.mustUseYUVoutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", useAsyncMode:" + this.useAsyncMode + ", texturePlayoutMode:" + this.texturePlayoutMode + ", directRenderMode:" + this.directRenderMode + ", curEglContextNum:" + curEglContextNum);
        if (this.outputThread == null) goto L17;
        RXLogging.e(TAG, "initDecodeInternal called while the codec is already running");
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L17:
        this.width = r110;
        this.height = r111;
        this.stride = r110;
        this.sliceHeight = r111;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.dropDecodedFrameCount = 0;
        this.callbackDecodedFrameCount = 0;
        this.minFrameCache = -1;
        this.currentFrameCache = -1;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.isError.set(false);
        Object r103 = this.callbackLock;
        monitor-enter(r103);
        this.inputBuffers.clear();     // Catch: Throwable -> L90
        monitor-exit(r103);     // Catch: Throwable -> L90
        this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);     // Catch: Throwable -> L88
        updateCheckSysResolutionStatus();
        if (this.enableCheckSysResolutionSupport == false) goto L93;
        if (this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).getVideoCapabilities().isSizeSupported(r110, r111) == true) goto L93;
        this.codec.release();
        releaseSurface();
        RXLogging.w(TAG, "isSizeSupported return false with the resolution:" + r110 + "xheight, fallback software");
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "isSizeSupported return false with the resolution:" + r110 + "x" + r111);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L93:
        MediaFormat r104 = MediaFormat.createVideoFormat(this.codecType.mimeType(), r110, r111);     // Catch: Throwable -> L46
        initMediaFormat(r104);     // Catch: Throwable -> L46
        if (this.useAsyncMode == false) goto L32;
        PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2("asyncOutput");     // Catch: Throwable -> L46
        this.asyncOutputThread = r105;     // Catch: Throwable -> L46
        ThreadMethodProxy.start(r105);     // Catch: Throwable -> L46
        this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());     // Catch: Throwable -> L46
        this.running = true;     // Catch: Throwable -> L46
        this.outputThreadChecker.detachThread();     // Catch: Throwable -> L46
        this.codec.setCallback(this, this.asyncHandler);     // Catch: Throwable -> L46
    L32:
        int r106 = this.maxExSurfaceRecreateDecoderCount;     // Catch: Throwable -> L46
        if (r106 < (-1)) goto L36;
        this.exSurface = null;     // Catch: Throwable -> L46
    L36:
        if (this.outSideSurfaceTextureHelper == null) goto L40;
        Surface r112 = this.surface;     // Catch: Throwable -> L46
        if (r112 == null) goto L40;
        this.codec.configure(r104, r112, null, 0);     // Catch: Throwable -> L46
        RXLogging.w(TAG, "init codec done control by outside with internal surface:" + this.surface);     // Catch: Throwable -> L46
    L44:
        this.codec.start();     // Catch: Throwable -> L46
    L57:
        this.maxExSurfaceRecreateDecoderCount = 0;
        if (this.useAsyncMode == true) goto L66;
        this.running = true;
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L62
        Thread r113 = createOutputThread();     // Catch: Exception -> L62
        this.outputThread = r113;     // Catch: Exception -> L62
        ThreadMethodProxy.start(r113);     // Catch: Exception -> L62
    L62:
        e = move-exception;
        this.codec.release();
        releaseSurface();
        RXLogging.e(TAG, "outputThread create err, fallback software:", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L66:
        if (this.directRenderMode != 2) goto L68;
        createDirectRenderVSyncThread();
    L68:
        RXLogging.w(TAG, "initDecodeInternal done,init video decoder cost time:" + (SystemClock.elapsedRealtime() - r100));
        Surface r114 = this.exSurface;
        if (r114 != null) goto L71;
    L73:
        if (r114 == null) goto L75;
    L80:
        return VideoCodecStatus.OK;
    L75:
        if (this.surface == null) goto L80;
        if (this.usingInternalSurfaceLast == true) goto L80;
        this.usingInternalSurfaceLast = true;
        this.callback.onMediaCodecStatus(VideoCodecStatus.USING_INTERNAL_SURFACE, "using internal surface");
        goto L80
    L71:
        if (this.surface != null) goto L73;
        this.usingInternalSurfaceLast = false;
    L40:
        Surface r107 = this.exSurface;     // Catch: Throwable -> L46
        if (r107 == null) goto L43;
        this.maxExSurfaceRecreateDecoderCount = r106 + 1;     // Catch: Throwable -> L46
        this.codec.configure(r104, r107, null, 0);     // Catch: Throwable -> L46
        RXLogging.w(TAG, "init codec done with external surface:" + this.exSurface);     // Catch: Throwable -> L46
        goto L44
    L43:
        this.codec.configure(r104, this.surface, null, 0);     // Catch: Throwable -> L46
        RXLogging.w(TAG, "init codec done with internal surface:" + this.surface);     // Catch: Throwable -> L46
    L46:
        MediaCodecInfo.CodecCapabilities r108 = this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType());
        RXLogging.w(TAG, "current decoder SupportedHeights:" + r108.getVideoCapabilities().getSupportedHeights());
        RXLogging.w(TAG, "current decoder SupportedWidths:" + r108.getVideoCapabilities().getSupportedWidths());
        RXLogging.w(TAG, "current decoder SupportedFrameRates:" + r108.getVideoCapabilities().getSupportedFrameRates());
        if (r108.getVideoCapabilities().getSupportedHeights().contains(Integer.valueOf(r111)) == true) goto L49;
    L86:
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "hardware decoder not support the resolution:" + r110 + "x" + r111);
        this.codec.release();
        releaseSurface();
        RXLogging.w(TAG, "initDecodeInternal err,decoder not support the resolution:" + r110 + "xheight, fallback software");
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L49:
        if (r108.getVideoCapabilities().getSupportedWidths().contains(Integer.valueOf(r110)) == false) goto L86;
        RXLogging.e(TAG, "initDecode Argument err, try reset Argument and reconfig");
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, "initDecode Argument err, try reset Argument and reconfig");
        MediaFormat r115 = MediaFormat.createVideoFormat(this.codecType.mimeType(), r110, r111);
        if (this.sharedContext != null) goto L54;
    L55:
        r115.setInteger("color-format", this.colorFormat);
    L101:
        this.codec.configure(r115, this.surface, null, 0);     // Catch: IllegalArgumentException -> L81 Throwable -> L83
        this.codec.start();     // Catch: IllegalArgumentException -> L81 Throwable -> L83
    L83:
        e = move-exception;
        RXLogging.e(TAG, "initDecode failed when retry config:" + e);
        StringWriter r116 = new StringWriter();
        e.printStackTrace(new PrintWriter(r116));
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, r116.toString());
        this.codec.release();
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L54:
        if (this.settings.enableYUVOutput == false) goto L101;
    L88:
        RXLogging.e(TAG, "Cannot create media decoder " + this.codecName);
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L90:
        th = move-exception;
        throw th;
    L9:
        r102 = initSurfaceTextureHelper();
        goto L11
    }

    private VideoCodecStatus initOutSideSurfaceTextureHelper(int r100, int r101) {
    L11:
        e = move-exception;
        RXLogging.e(TAG, "err when create surface:" + e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L3:
        if (this.settings.enableYUVOutput == true) goto L10;
        if (curEglContextNum >= maxEglContextNum) goto L10;
        if (this.outSideSurfaceTextureHelper != null) goto L10;
        SurfaceTextureHelper r102 = createSurfaceTextureHelper();     // Catch: Exception -> L11
        this.outSideSurfaceTextureHelper = r102;     // Catch: Exception -> L11
        initSurfaceTextureHelper(r102, true);     // Catch: Exception -> L11
    L10:
        return VideoCodecStatus.OK;
    }

    private VideoCodecStatus reinitDecode(int r100, int r101) {
        VideoCodecStatus r102 = releaseInternal();
        if (this.settings.enableSurfaceTextureReuse == true) goto L6;
        releaseSurface();
    L6:
        if (r102 == VideoCodecStatus.OK) goto L9;
        RXLogging.e(TAG, "releaseInternal err");
        return r102;
    L9:
        VideoCodecStatus r103 = VideoCodecStatus.FALLBACK_SOFTWARE;
        int r104 = 0;
    L11:
        if (r104 >= 2) goto L16;
        r103 = initDecodeInternal(r100, r101);
        if (VideoCodecStatus.OK == r103) goto L16;
        releaseSurface();
        r104 = r104 + 1;
    L16:
        return r103;
    }

    public NativeRXByteMemory allocateI420Buffer(int r100, int r101) {
        return NativeRXByteMemory.createRXByteMemory(r100, r101, RXPixelFormat.kI420, 0);
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings r100, VideoDecoder.Callback r101) {
        this.callback = r101;
        this.settings = r100;
        EglBase.Context r102 = r100.sharedContext;
        if (r102 == null) goto L6;
        this.sharedContext = r102;
    L6:
        if (r100.enableAsyncMode == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        this.useAsyncMode = r103;
        int r104 = r100.directRenderMode;
        this.directRenderMode = r104;
        if (r104 != 2) goto L14;
        this.texturePlayoutMode = 0;
    L16:
        return VideoCodecStatus.OK;
    L14:
        this.texturePlayoutMode = r100.texturePlayoutMode;
        goto L16
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r103 = true;
        goto L11
    }

    public void initSurfaceTextureHelper(SurfaceTextureHelper r100, boolean r101) {
        if (r100 != null) goto L5;
        RXLogging.w(TAG, "surfaceTextureHelper create fail,egl context maybe is full, the hw decoder should use yuvoutput mode");
        this.mustUseYUVoutput = true;
        return;
    L5:
        RXLogging.w(TAG, "surfaceTextureHelper create successful.");
        if (this.settings.enableAGFXSurfaceTextureHelper == true) goto L8;
        curEglContextNum++;
    L8:
        r100.setTextureMemoryReuse(this.enableTextureMemoryReuse);
        r100.setEnableOutsideControlTextureMemory(r101);
        this.surface = new Surface(r100.getSurfaceTexture());
        r100.startListening(this);
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec r100, MediaCodec.CodecException r101) {
        if (this.running == false) goto L11;
        MediaCodecWrapper r102 = this.codec;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getRealCodec() != r100) goto L13;
        this.isError.set(true);
        return;
    L13:
        return;
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec r100, int r101) {
        if (this.running == false) goto L17;
        MediaCodecWrapper r102 = this.codec;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getRealCodec() != r100) goto L21;
        Object r103 = this.callbackLock;
        monitor-enter(r103);
        this.inputBuffers.addLast(Integer.valueOf(r101));     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L21:
        return;
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec r100, MediaFormat r101) {
        RXLogging.e(TAG, "onOutputFormatChanged ");
        if (this.running == false) goto L11;
        MediaCodecWrapper r102 = this.codec;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getRealCodec() != r100) goto L13;
        reformat(r101);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus setPrivateParam(String r100, String r101) {
        RXLogging.w(TAG, "got android hardware decoder setPrivateParam key:" + r100 + " value:" + r101);
        if (r100.equals(DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE) == false) goto L10;
        if (isNumeric(r101) == false) goto L8;
        maxDirectRenderCacheSize = CastIntegerProtector.parseInt(r101);
    L8:
        return VideoCodecStatus.OK;
    L10:
        if (r100.equals(MAX_EGL_NUM) == false) goto L17;
        if (isNumeric(r101) == false) goto L14;
        maxEglContextNum = CastIntegerProtector.parseInt(r101);
    L14:
        RXLogging.w(TAG, "this is not a param set to HW Decoder, only for control.");
        return VideoCodecStatus.OK;
    L17:
        if (r100.equals(FLAG_CHECK_TEXTURE_SIZE) == false) goto L21;
        this.enableTextureSizeCheck = "true".equalsIgnoreCase(r101);
        RXLogging.w(TAG, "set FLAG_CHECK_TEXTURE_SIZE to " + this.enableTextureSizeCheck);
        return VideoCodecStatus.OK;
    L21:
        if (r100.equals(FLAG_TEXTURE_MEMORY_REUSE) == false) goto L24;
        this.enableTextureMemoryReuse = "true".equalsIgnoreCase(r101);
        RXLogging.w(TAG, "set FLAG_TEXTURE_MEMORY_REUSE to " + this.enableTextureMemoryReuse);
        return VideoCodecStatus.OK;
    L24:
        boolean r102 = false;
        if (r100.equals(NEW_INPUT_BUFFER_API) == false) goto L35;
        if (isNumeric(r101) == true) goto L29;
    L32:
        RXLogging.w(TAG, "this is not a param set to HW Decoder, only for control. useNewInputBufferAPI:" + this.useNewInputBufferAPI);
        return VideoCodecStatus.OK;
    L29:
        if (CastIntegerProtector.parseInt(r101) < 1) goto L31;
        r102 = true;
    L31:
        this.useNewInputBufferAPI = r102;
        goto L32
    L35:
        if (r100.equals(NEW_OUTPUT_BUFFER_API) == true) goto L37;
        this.vpassPrivateParams.put(r100, r101);
        return VideoCodecStatus.OK;
    L37:
        if (isNumeric(r101) == true) goto L39;
    L42:
        RXLogging.w(TAG, "this is not a param set to HW Decoder, only for control. useNewOutputBufferAPI:" + this.useNewOutputBufferAPI);
        return VideoCodecStatus.OK;
    L39:
        if (CastIntegerProtector.parseInt(r101) < 1) goto L41;
        r102 = true;
    L41:
        this.useNewOutputBufferAPI = r102;
        goto L42
    }

    private /* synthetic */ int lambda$deliverTextureFrameOutSide$1(int r100, MediaCodec.BufferInfo r101, boolean r102) {
    L8:
        e = move-exception;
        RXLogging.w(TAG, "releaseOutputBuffer failed", e);
        return 0;
    L3:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        if (r102 == false) goto L6;
        this.codec.releaseOutputBuffer(r100, r101.presentationTimeUs * 1000);     // Catch: Exception -> L8
    L12:
        return 0;
    L6:
        this.codec.releaseOutputBuffer(r100, r102);     // Catch: Exception -> L8
        goto L12
    }

    private boolean setAdaptivePlaybackParam(MediaFormat r100, String r101, Integer r110) {
        Iterator<Map.Entry<String, String>> r102 = this.privateParams.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey().equals(r101) == false) goto L4;
        if (isNumeric(r103.getValue()) == false) goto L4;
        int r104 = Math.max(CastIntegerProtector.parseInt(r103.getValue()), r110.intValue());
        if (r104 > 9000) goto L14;
        if (r104 <= 0) goto L14;
        r100.setInteger(r103.getKey(), r104);
        RXLogging.w(TAG, "setAdaptivePlaybackParam params key: " + r103.getKey() + ", value:" + Math.max(CastIntegerProtector.parseInt(r103.getValue()), r110.intValue()) + " {privateConfig: " + CastIntegerProtector.parseInt(r103.getValue()) + ", resoluion: " + r110 + com.alipay.sdk.m.u.i.f25855d);
        return true;
    L14:
        RXLogging.w(TAG, "setAdaptivePlaybackParam failed! exceeding the valid range(0, 10000], key: " + r103.getKey() + ", value: " + r104 + " {privateConfig: " + CastIntegerProtector.parseInt(r103.getValue()) + ", resoluion: " + r110 + com.alipay.sdk.m.u.i.f25855d);
        return false;
    L16:
        RXLogging.w(TAG, "setAdaptivePlaybackParam, but private key isn't setted, params: " + r101);
        return false;
    }

    private void setIntegerParam(MediaFormat r100, String r101, Integer r102) {
        Iterator<Map.Entry<String, String>> r103 = this.privateParams.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getKey().equals(r101) == false) goto L4;
        if (isNumeric(r104.getValue()) == true) goto L9;
        this.privateParams.remove(r101);
        if (r104.getValue().length() <= 0) goto L14;
        RXLogging.w(TAG, "the decoder params " + r104.getKey() + " set by vpaas is invalid with value:" + r104.getValue() + ",skip it");
        goto L4
    L14:
        RXLogging.w(TAG, "the decoder params " + r104.getKey() + " is disabled by vpaas,skip it");
        return;
    L9:
        r100.setInteger(r104.getKey(), CastIntegerProtector.parseInt(r104.getValue()));
        RXLogging.w(TAG, "the decoder params " + r104.getKey() + " is coverd by vpaas with value:" + r104.getValue());
        this.privateParams.remove(r101);
        return;
    L16:
        RXLogging.w(TAG, "decoder int params has been set with Key:" + r101 + " Value:" + r102);
        r100.setInteger(r101, r102.intValue());
    }

    private void setStringParam(MediaFormat r100, String r101, String r102) {
        Iterator<Map.Entry<String, String>> r103 = this.privateParams.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getKey().equals(r101) == false) goto L4;
        if (r104.getValue().length() <= 0) goto L10;
        r100.setString(r104.getKey(), r104.getValue());
        RXLogging.w(TAG, "the decoder params " + r104.getKey() + " is coverd by vpaas with value:" + r104.getValue());
    L11:
        this.privateParams.remove(r101);
        return;
    L10:
        RXLogging.w(TAG, "the decoder params " + r104.getKey() + " is disabled by vpaas,skip it");
        goto L11
    L13:
        RXLogging.w(TAG, "decoder string params has been set with Key:" + r101 + " Value:" + r102);
        r100.setString(r101, r102);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec r100, int r101, MediaCodec.BufferInfo r102) {
        if (this.running == false) goto L16;
        MediaCodecWrapper r103 = this.codec;
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getRealCodec() != r100) goto L18;
        drainOutputFrame(r102, r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        RXLogging.e(TAG, "" + e);
        return;
    L18:
        return;
    }

    public AndroidVideoDecoder(MediaCodecWrapperFactory r100, String r101, RXVideoCodecStandard r102, int r103) {
        this.enableHisiEndCode = true;
        this.enableCheckSysResolutionSupport = false;
        this.enableTextureSizeCheck = true;
        this.enableTextureMemoryReuse = false;
        this.maxExSurfaceRecreateDecoderCount = 0;
        this.directRenderThread = null;
        this.outputBufferQueueLock = new Object();
        this.outputBufferQueue = new LinkedBlockingQueue();
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.dimensionLock = new Object();
        this.encoded_width = 0;
        this.encoded_height = 0;
        this.surfaceTextureHelperLock = new Object();
        this.lastOutputTime = 0;
        this.currentOutputTime = 0;
        this.lastInputTime = 0;
        this.currentInputTimeDelta = 0;
        this.packetCount2s = 0;
        this.timeForAvg = 0;
        this.avgInputTimeDelta = 0;
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.dropDecodedFrameCount = 0;
        this.callbackDecodedFrameCount = 0;
        this.minFrameCache = -1;
        this.currentFrameCache = -1;
        this.smoothOutputLock = new Object();
        this.usingInternalSurfaceLast = true;
        this.privateParams = new HashMap();
        this.vpassPrivateParams = new HashMap();
        this.mustUseYUVoutput = false;
        this.useNewInputBufferAPI = true;
        this.useNewOutputBufferAPI = true;
        this.enable_adaptive_playback = false;
        this.adaptive_playback_max_width = 0;
        this.adaptive_playback_max_height = 0;
        this.enableRetryDeliver = false;
        this.maxTryCount = 16;
        this.minAccelerateRatio = 0.0f;
        this.maxDeaccelerateRatio = 1.0f;
        this.frameCacheThreshold = 2;
        this.directRenderMode = 2;
        this.texturePlayoutMode = 0;
        this.renderedTextureMetadataLock = new Object();
        this.useAsyncMode = false;
        this.inputBuffers = new LinkedList();
        this.callbackLock = new Object();
        this.isError = new AtomicBoolean(false);
        if (isSupportedColorFormat(r103) == false) goto L7;
        RXLogging.w(TAG, "ctor name: " + r101 + " type: " + r102 + " color format(19:I420 21:NV12): " + r103);
        this.mediaCodecWrapperFactory = r100;
        this.codecName = r101;
        this.codecType = r102;
        this.colorFormat = r103;
        this.width = 0;
        this.height = 0;
        return;
    L7:
        throw new IllegalArgumentException("Unsupported color format: " + r103);
    }

    private NativeRXByteMemory copyI420Buffer(ByteBuffer r210, int r211, int r212, int r213, int r214) {
        if ((r211 % 2) == 0) goto L6;
        RXLogging.e(TAG, "Stride is not divisible by two: " + r211);
        return null;
    L6:
        int r110 = (r213 + 1) / 2;
        if ((r212 % 2) != 0) goto L9;
        int r100 = (r214 + 1) / 2;
    L10:
        int r111 = r100;
        int r215 = r211 / 2;
        int r101 = (r211 * r214) + 0;
        int r112 = (r211 * r212) + 0;
        int r102 = r215 * r111;
        int r113 = r112 + r102;
        int r114 = r112 + ((r215 * r212) / 2);
        int r115 = r114 + r102;
        NativeRXByteMemory r103 = allocateI420Buffer(r213, r214);
        if (r103 != null) goto L14;
        return null;
    L14:
        if (r103.getNumberOfPlanes() == 3) goto L32;
        r103.release();
        return null;
    L32:
        r210.limit(r101);     // Catch: Exception -> L28
        r210.position(0);     // Catch: Exception -> L28
        NativeRXByteMemory r116 = r103;
        copyPlane(r210.slice(), r211, r103.getPlaneData(0), r103.getPlaneLineSize(0), r213, r214);     // Catch: Exception -> L26
        r210.limit(r113);     // Catch: Exception -> L26
        r210.position(r112);     // Catch: Exception -> L26
        copyPlane(r210.slice(), r215, r116.getPlaneData(1), r116.getPlaneLineSize(1), r110, r111);     // Catch: Exception -> L26
        if ((r212 % 2) != 1) goto L22;
        r210.position(r112 + ((r111 - 1) * r215));     // Catch: Exception -> L26
        ByteBuffer r104 = r116.getPlaneData(1);     // Catch: Exception -> L26
        r104.position(r116.getPlaneLineSize(1) * r111);     // Catch: Exception -> L26
        r104.put(r210);     // Catch: Exception -> L26
    L22:
        r210.limit(r115);     // Catch: Exception -> L26
        r210.position(r114);     // Catch: Exception -> L26
        copyPlane(r210.slice(), r215, r116.getPlaneData(2), r116.getPlaneLineSize(2), r110, r111);     // Catch: Exception -> L26
        if ((r212 % 2) != 1) goto L25;
        r210.position(r114 + (r215 * (r111 - 1)));     // Catch: Exception -> L26
        ByteBuffer r105 = r116.getPlaneData(2);     // Catch: Exception -> L26
        r105.position(r116.getPlaneLineSize(2) * r111);     // Catch: Exception -> L26
        r105.put(r210);     // Catch: Exception -> L26
    L25:
        return r116;
    L26:
        e = e;
    L30:
        RXLogging.e(TAG, "buffer err:", e);
        r116.release();
        return null;
    L28:
        e = e;
        r116 = r103;
        goto L30
    L9:
        r100 = r214 / 2;
        goto L10
    }

    private NativeRXByteMemory copyNV12Buffer(ByteBuffer r110, int r111, int r112, int r113, int r114) {
        int r100 = (r114 + 1) / 2;
        int r101 = (r111 * r114) + 0;
        int r102 = (r111 * r112) + 0;
        int r115 = r102 + (r111 * r100);
        NativeRXByteMemory r116 = NativeRXByteMemory.createRXByteMemory(r113, r114, RXPixelFormat.kNv12, 0);
        if (r116 != null) goto L6;
        return null;
    L6:
        if (r116.getNumberOfPlanes() == 2) goto L14;
        r116.release();
        return null;
    L14:
        r110.limit(r101);     // Catch: Exception -> L11
        r110.position(0);     // Catch: Exception -> L11
        copyPlane(r110.slice(), r111, r116.getPlaneData(0), r116.getPlaneLineSize(0), r113, r114);     // Catch: Exception -> L11
        r110.limit(r115);     // Catch: Exception -> L11
        r110.position(r102);     // Catch: Exception -> L11
        copyPlane(r110.slice(), r111, r116.getPlaneData(1), r116.getPlaneLineSize(1), r113, r100);     // Catch: Exception -> L11
        return r116;
    L11:
        e = move-exception;
        RXLogging.e(TAG, "copyNV12Buffer err:", e);
        r116.release();
        return null;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus setDeliverParams(boolean r100, int r101, float r102, float r103, int r104) {
        RXLogging.w(TAG, "got android hardware decoder setDeliverParams enable:" + r100 + ", maxTryCount:" + r101 + ", minAccelerateRatio:" + r102 + ", maxDeaccelerateRatio:" + r103 + ", frameCacheThreshold:" + r104);
        this.enableRetryDeliver = r100;
        this.maxTryCount = r101;
        this.minAccelerateRatio = r102;
        this.maxDeaccelerateRatio = r103;
        this.frameCacheThreshold = r104;
        return VideoCodecStatus.OK;
    }

    public void copyPlane(ByteBuffer r100, int r101, ByteBuffer r102, int r103, int r104, int r105) {
        YuvHelper.copyPlane(r100, r101, r102, r103, r104, r105);
    }
}
