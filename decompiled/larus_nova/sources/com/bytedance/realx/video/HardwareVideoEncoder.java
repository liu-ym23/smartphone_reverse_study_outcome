package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.realx.RXVideoSurfaceController;
import com.bytedance.realx.base.RXDeviceInfoAndroid;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.memory.NativeRXOpenGLMemory;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import com.bytedance.realx.video.memory.RXVideoMemoryInterface;
import com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
class HardwareVideoEncoder extends MediaCodec.Callback implements VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US_RELEASE_ASYNC = 40000;
    private static final int DTS_OFFSET_FRAME_NUM = 7;
    private static final String KEY_HISI_EXT_CODEC_MAX_QP = "vendor.hisi.hisi-ext-codec-max-qp";
    private static final String KEY_HISI_EXT_CODEC_MIN_QP = "vendor.hisi.hisi-ext-codec-min-qp";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES = "vendor.hisi.hisi-ext-codec-non-ref-p-frames";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED = "vendor.hisi.hisi-ext-codec-non-ref-p-frames-supported";
    private static final String KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD = "vendor.hisi.hisi-ext-codec-qp-regulation-supported";
    private static final String KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE = "vendor.hisi.hisi-ext-codec-vendor-configure";
    private static final String KEY_PRIVATE_PARAM_CHECK_SVC_LAYER = "realx.check.svc.layer";
    private static final String KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT = "realx.force.surface.input";
    private static final String KEY_PRIVATE_PARAM_GLCLEAR = "realx.glclear";
    private static final String KEY_PRIVATE_PARAM_NATIVE_RENDER = "realx.native.render";
    private static final String KEY_PRIVATE_PARAM_RELEASE_ASYNC = "realx.release.async";
    private static final int MAX_VIDEO_FRAMERATE = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final int MIN_CODEC_HEIGHT_ALIGN = 4;
    private static final int MIN_CODEC_WIDTH_ALIGN = 16;
    private static final int RESTART_ENCODER_TIME_THRESHOLD_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private int actualHeight;
    private int actualWidth;
    private int adjustedBitrate;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private boolean automaticResizeOn;
    private VideoEncoder.BitrateMode bitrateMode;
    private VideoEncoder.Callback callback;
    private final Object callbackLock;
    private MediaCodecInfo.CodecCapabilities capabilities;
    private boolean checkSVCLayer;
    private MediaCodecWrapper codec;
    private final RXVideoCodecDesc codecDesc;
    private int codecHeightAlign;
    private final String codecName;
    private int codecWidthAlign;
    private ByteBuffer configBuffer;
    private final Deque<Long> dtsQueue;
    private boolean enableGlClear;
    private boolean enableNativeRender;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private boolean encodedFirstFrame;
    private long firstFrameDiffUs;
    private Boolean forceSurfaceInput;
    private final long forcedKeyFrameNs;
    private int height;
    private LinkedList<Integer> inputBuffers;
    private boolean isError;
    private boolean isNeedSurfaceInputWorkaround;
    private boolean isStatisticsEnabled;
    private Boolean isTextureBuffer;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private HashMap<String, String> privateParams;
    private int queriedGLESVersion;
    private boolean releaseAsync;
    private volatile boolean running;
    private VideoEncoder.ScaleMode scaleMode;
    private VideoEncoder.Settings settings;
    private EglBase14.Context sharedContext;
    private volatile Exception shutdownException;
    private final Integer surfaceColorFormat;
    private int svcRealLayerNum;
    private GlRectDrawer textureDrawer;
    private EglBase14 textureEglBase;
    private Surface textureInputSurface;
    private int updateBitrate;
    private long updateBitrateTimestamp;
    private boolean useAsyncMode;
    private boolean useSurfaceMode;
    private VideoFrameDrawer videoFrameDrawer;
    private long videoFrameDrawerHandler;
    private HashMap<String, String> vpassPrivateParams;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;

    /* JADX INFO: renamed from: com.bytedance.realx.video.HardwareVideoEncoder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile = null;

        static {
            int[] r100 = new int[RXVideoCodecProfile.values().length];
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile = r100;
            r100[RXVideoCodecProfile.ProfileHigh.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedHigh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileBaseline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedBaseline.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileMain.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10HDR10.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static abstract enum YuvFormat extends Enum<YuvFormat> {
        private static final /* synthetic */ YuvFormat[] $VALUES = null;
        public static final YuvFormat I420 = null;
        public static final YuvFormat NV12 = null;

        public abstract void fillBuffer(ByteBuffer r100, RXVideoFrameInterface r101, int r102, int r103);

        static {
            final String r100 = "I420";
            final int r101 = 0;
            YuvFormat r102 = new AnonymousClass1(r100, r101);
            I420 = r102;
            final String r103 = "NV12";
            final int r104 = 1;
            YuvFormat r105 = new AnonymousClass2(r103, r104);
            NV12 = r105;
            $VALUES = new YuvFormat[]{r102, r105};
        }

        public static YuvFormat[] values() {
            return (YuvFormat[]) $VALUES.clone();
        }

        public static YuvFormat valueOf(int r100) {
            if (r100 == 19) goto L16;
            if (r100 == 21) goto L14;
            if (r100 == 2141391872) goto L14;
            if (r100 == 2141391876) goto L14;
            throw new IllegalArgumentException("Unsupported colorFormat: " + r100);
        L14:
            return NV12;
        L16:
            return I420;
        }

        public static YuvFormat valueOf(String r100) {
            return (YuvFormat) r27.a.a(YuvFormat.class, r100);
        }

        private YuvFormat(String r100, int r101) {
            super(r100, r101);
        }

        public /* synthetic */ YuvFormat(String r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static /* synthetic */ void a(HardwareVideoEncoder r100, HandlerThread r101) {
        r100.lambda$release$0(r101);
    }

    public static /* synthetic */ void b(HardwareVideoEncoder r100, MediaCodecWrapper r101) {
        r100.lambda$releaseCodecOnOutputThread$1(r101);
    }

    public static native long nativeCreateDrawer();

    public static native void nativeDestroyDrawer(long r100);

    public static native int nativeDrawFrame(long r100, long r101, int r102, int r103, int r104, int r105);

    private int queryCurerentRunningGlesVersion() {
        int[] r100 = new int[1];
        EGLContext r101 = EGL14.eglGetCurrentContext();
        EGL14.eglQueryContext(EGL14.eglGetCurrentDisplay(), r101, 12440, r100, 0);
        return r100[0];
    }

    private void alignResolutionIfNeeded() {
        if (this.settings.enableAlignment == true) goto L5;
        this.width = this.actualWidth;
        this.height = this.actualHeight;
    L15:
        RXLogging.i(TAG, "alignResolutionIfNeeded, actual: " + this.actualWidth + "x" + this.actualHeight + ", align to: " + this.width + "x" + this.height);
        return;
    L5:
        if (this.codecWidthAlign != 0) goto L13;
        MediaCodecInfo.VideoCapabilities r100 = this.capabilities.getVideoCapabilities();
        int r101 = r100.getWidthAlignment();
        int r102 = r100.getHeightAlignment();
        int r103 = 16;
        if (r101 <= 16) goto L9;
        r103 = r101;
    L9:
        this.codecWidthAlign = r103;
        int r104 = 4;
        if (r102 <= 4) goto L12;
        r104 = r102;
    L12:
        this.codecHeightAlign = r104;
        RXLogging.i(TAG, "alignResolutionIfNeeded, capabilities align is: " + r101 + "x" + r102 + ", final codec align is: " + this.codecWidthAlign + "x" + this.codecHeightAlign);
    L13:
        int r105 = this.actualWidth;
        int r106 = this.codecWidthAlign;
        this.width = ((r105 + r106) - 1) & (~(r106 - 1));
        int r107 = this.actualHeight;
        int r108 = this.codecHeightAlign;
        this.height = ((r107 + r108) - 1) & (~(r108 - 1));
        goto L15
    }

    private boolean canUseSurface() {
        if (this.surfaceColorFormat == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Thread createOutputThread() {
        final String r100 = "video_encoded_thread";
        return new AnonymousClass1(this, r100);
    }

    private VideoCodecStatus initEncodeInternal() {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.dtsQueue.clear();
        this.isStatisticsEnabled = false;
        Object r100 = this.callbackLock;
        monitor-enter(r100);
        this.inputBuffers.clear();     // Catch: Throwable -> L40
        this.isError = false;     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);     // Catch: Exception -> L37
        MediaFormat r101 = MediaFormat.createVideoFormat(this.codecDesc.getStandard().mimeType(), this.width, this.height);     // Catch: Exception -> L34
        initMediaFormat(r101);     // Catch: Exception -> L34
        enableEncodingStatistics(r101);     // Catch: Exception -> L34
        RXLogging.w(TAG, "Format: " + r101);     // Catch: Exception -> L34
        if (this.useAsyncMode == false) goto L10;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("asyncOutput");     // Catch: Exception -> L34
        this.asyncOutputThread = r102;     // Catch: Exception -> L34
        ThreadMethodProxy.start(r102);     // Catch: Exception -> L34
        this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());     // Catch: Exception -> L34
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L34
        this.running = true;     // Catch: Exception -> L34
        this.codec.setCallback(this, this.asyncHandler);     // Catch: Exception -> L34
    L10:
        this.codec.configure(r101, null, null, 1);     // Catch: Exception -> L34
        if (isSvcEnabled() == false) goto L16;
        MediaFormat r103 = this.codec.getOutputFormat();     // Catch: Exception -> L34
        if (r103 == null) goto L16;
        this.svcRealLayerNum = parseRealLayerNum(r103);     // Catch: Exception -> L34
        RXLogging.w(TAG, "" + this.svcRealLayerNum + "，output format after configure: " + r103.toString());     // Catch: Exception -> L34
    L16:
        if (RXVideoSurfaceController.getInstance().usePassSurfaceMode() == false) goto L19;
        this.textureInputSurface = this.codec.createInputSurface();     // Catch: Exception -> L34
        RXVideoSurfaceController.getInstance().setSurface(this.textureInputSurface);     // Catch: Exception -> L34
    L21:
        this.codec.start();     // Catch: Exception -> L34
        VideoEncoder.Settings r104 = this.settings;     // Catch: Exception -> L34
        setExtCodecForHisi(r104.maxQp, r104.minQp);     // Catch: Exception -> L34
        VideoEncoder.Settings r105 = this.settings;     // Catch: Exception -> L34
        if (r105.encodeMode != VideoEncoder.EncodeMode.LIVE) goto L25;
        updateBitrate(r105.targetBps);     // Catch: Exception -> L34
    L25:
        if (this.useAsyncMode == true) goto L33;
        this.running = true;
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L29
        Thread r106 = createOutputThread();     // Catch: Exception -> L29
        this.outputThread = r106;     // Catch: Exception -> L29
        ThreadMethodProxy.start(r106);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        RXLogging.e(TAG, "output thread err", e);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L33:
        return VideoCodecStatus.OK;
    L19:
        if (this.useSurfaceMode == false) goto L21;
        this.textureInputSurface = this.codec.createInputSurface();     // Catch: Exception -> L34
        EglBase14 r107 = new EglBase14(this.sharedContext, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));     // Catch: Exception -> L34
        this.textureEglBase = r107;     // Catch: Exception -> L34
        r107.createSurface(this.textureInputSurface);     // Catch: Exception -> L34
        this.textureEglBase.makeCurrent();     // Catch: Exception -> L34
        initFrameDrawer();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        RXLogging.e(TAG, "initEncodeInternal failed", e);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L37:
        e = move-exception;
        RXLogging.e(TAG, "Cannot create media encoder " + this.codecName, e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L40:
        th = move-exception;
        throw th;
    }

    private boolean isBFrameEnabled() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        if (this.settings.bFrameNum <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isEncodingStatisticsSupported() {
        if (this.codecDesc.standard != RXVideoCodecStandard.VP8) goto L5;
        return false;
    L5:
        MediaCodecInfo r100 = this.codec.getCodecInfo();
        if (r100 != null) goto L8;
        return false;
    L8:
        MediaCodecInfo.CodecCapabilities r101 = r100.getCapabilitiesForType(this.codecDesc.standard.mimeType());
        if (r101 != null) goto L12;
        return false;
    L12:
        if (Build.VERSION.SDK_INT >= 33) goto L14;
        return false;
    L14:
        return r101.isFeatureSupported("encoding-statistics");
    }

    private boolean isSvcEnabled() {
        if (this.settings.temporalLayerNum > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: IllegalStateException -> L5
    L6:
        RXLogging.i(TAG, "Releasing MediaCodec on output thread");
        final MediaCodecWrapper r100 = this.codec;
        this.codec = null;
        if (this.releaseAsync == true) goto L23;
        if (r100 != null) goto L25;
    L21:
        this.configBuffer = null;
        RXLogging.i(TAG, "Release on output thread done");
        return;
    L25:
        r100.stop();     // Catch: Exception -> L15
    L29:
        r100.release();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        RXLogging.e(TAG, "Media encoder release failed", e);
        this.shutdownException = e;
    L15:
        e = move-exception;
        RXLogging.e(TAG, "Media encoder stop failed", e);
        goto L29
    L23:
        ThreadMethodProxy.start(new PthreadThreadV2(new l(this, r100), TAG));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        RXLogging.e(TAG, "thread err when release codec", e);
    L5:
        RXLogging.e(TAG, "check thread error.");
        goto L6
    }

    private void releaseFrameDrawer() {
        long r100 = this.videoFrameDrawerHandler;
        if (r100 == 0) goto L5;
        nativeDestroyDrawer(r100);
        RXLogging.i(TAG, "released native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
        this.videoFrameDrawerHandler = 0;
    L5:
        GlRectDrawer r101 = this.textureDrawer;
        if (r101 == null) goto L8;
        r101.release();
        this.textureDrawer = null;
    L8:
        VideoFrameDrawer r102 = this.videoFrameDrawer;
        if (r102 == null) goto L12;
        r102.release();
        RXLogging.i(TAG, "released java frame drawer " + this.videoFrameDrawer);
        this.videoFrameDrawer = null;
        return;
    }

    public void deliverEncodedImage() {
        MediaCodec.BufferInfo r100 = new MediaCodec.BufferInfo();     // Catch: Exception -> L22
        if (this.releaseAsync == false) goto L6;
        long r101 = ShareImageDataPlugin.TRANSFER_TIMEOUT;
    L7:
        int r102 = this.codec.dequeueOutputBuffer(r100, r101);     // Catch: Exception -> L22
        if (r102 != (-2)) goto L12;
        RXLogging.i(TAG, "output format changed: " + this.codec.getOutputFormat().toString());     // Catch: Exception -> L22
        return;
    L12:
        if (r102 != (-1)) goto L15;
        return;
    L15:
        if (r102 == (-3)) goto L20;
        if (r102 >= 0) goto L20;
        RXLogging.e(TAG, "should not be here: index:" + r102);     // Catch: Exception -> L22
        return;
    L20:
        drainOutputData(r102, r100, this.codec.getOutputBuffers()[r102]);     // Catch: Exception -> L22
        return;
    L6:
        r101 = 100000;
    L22:
        e = move-exception;
        RXLogging.e(TAG, "deliverOutput failed", e);
    }

    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn == false) goto L13;
        RXVideoCodecStandard r100 = this.codecDesc.getStandard();
        RXVideoCodecStandard r101 = RXVideoCodecStandard.VP8;
        if (r100 != r101) goto L9;
        return new VideoEncoder.ScalingSettings(29, 95);
    L9:
        if (this.codecDesc.getStandard() != r101) goto L13;
        return new VideoEncoder.ScalingSettings(24, 37);
    L13:
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus release() {
        this.encodeThreadChecker.checkIsOnValidThread();
        RXLogging.w(TAG, "hardware video encoder release start.");
        VideoCodecStatus r100 = VideoCodecStatus.OK;
        if (this.useAsyncMode == false) goto L11;
        this.running = false;
        final HandlerThread r101 = this.asyncOutputThread;
        if (r101 == null) goto L18;
        this.asyncHandler.post(new k(this, r101));
        if (ThreadUtils.joinUninterruptibly(this.asyncOutputThread, 5000) == true) goto L9;
        RXLogging.e(TAG, "Media encoder release timeout");
        r100 = VideoCodecStatus.TIMEOUT;
    L9:
        this.asyncOutputThread = null;
        this.asyncHandler = null;
    L18:
        RXLogging.w(TAG, "Media encoder release ok.");
        releaseFrameDrawer();
        EglBase14 r102 = this.textureEglBase;
        if (r102 == null) goto L21;
        r102.release();
        this.textureEglBase = null;
    L21:
        RXLogging.w(TAG, "textureEglBase release ok.");
        Surface r103 = this.textureInputSurface;
        if (r103 == null) goto L24;
        r103.release();
        this.textureInputSurface = null;
    L24:
        RXLogging.w(TAG, "textureInputSurface release ok.");
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        RXLogging.w(TAG, "hardware video encoder release end." + r100);
        return r100;
    L11:
        if (this.outputThread == null) goto L18;
        this.running = false;
        if (ThreadUtils.joinUninterruptibly(this.outputThread, 5000) == true) goto L16;
        RXLogging.e(TAG, "Media encoder release timeout");
        r100 = VideoCodecStatus.TIMEOUT;
        goto L18
    L16:
        if (this.shutdownException == null) goto L18;
        RXLogging.e(TAG, "Media encoder release exception", this.shutdownException);
        r100 = VideoCodecStatus.ERROR;
        goto L18
    }

    private void initFrameDrawer() {
        this.queriedGLESVersion = queryCurerentRunningGlesVersion();
        if (this.enableNativeRender == false) goto L5;
        this.videoFrameDrawerHandler = nativeCreateDrawer();
        RXLogging.i(TAG, "created native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
        return;
    L5:
        this.textureDrawer = new GlRectDrawer();
        this.videoFrameDrawer = new VideoFrameDrawer();
        RXLogging.i(TAG, "created java frame drawer " + this.videoFrameDrawer);
    }

    private boolean isDeviceSupportResetBitrate() {
        if ("M2007J17C".equalsIgnoreCase(RXDeviceInfoAndroid.GetDeviceModel()) == false) goto L6;
        return false;
    L6:
        return true;
    }

    private void resetCodecWhenBitrateChange() {
        if (isDeviceSupportResetBitrate() == false) goto L5;
    L9:
        boolean r100 = false;
    L10:
        if (r100 == false) goto L13;
        resetCodec(this.useSurfaceMode);
        return;
    L13:
        return;
    L5:
        if (this.updateBitrate == this.settings.targetBps) goto L9;
        if ((SystemClock.elapsedRealtime() - this.updateBitrateTimestamp) < 5000) goto L9;
        r100 = true;
        goto L10
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus requestKeyFrame() {
        requestKeyFrame(System.currentTimeMillis());
        return VideoCodecStatus.OK;
    }

    public static /* synthetic */ boolean access$000(HardwareVideoEncoder r100) {
        return r100.running;
    }

    public static /* synthetic */ void access$100(HardwareVideoEncoder r100) {
        r100.releaseCodecOnOutputThread();
    }

    private void enableEncodingStatistics(MediaFormat r100) {
        if (isEncodingStatisticsSupported() == true) goto L5;
        return;
    L5:
        if (this.settings.isStatisticsEnabled == false) goto L9;
        r100.setInteger("video-encoding-statistics-level", 1);
        this.isStatisticsEnabled = true;
        return;
    }

    private VideoCodecStatus encodeByteBuffer(RXVideoFrameInterface r100) {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode == false) goto L41;
        Object r101 = this.callbackLock;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.inputBuffers.size() > 0) goto L9;
        int r102 = -1;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L19
        if (r102 != (-1)) goto L37;
        RXLogging.i(TAG, "Dropped frame, no input buffers available");
        return VideoCodecStatus.NO_OUTPUT;
    L37:
        ByteBuffer r103 = this.codec.getInputBuffer(r102);     // Catch: Exception -> L16
    L28:
        return drainInputData(r102, r103, r100);
    L16:
        e = move-exception;
        RXLogging.e(TAG, "getInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L9:
        r102 = this.inputBuffers.removeFirst().intValue();     // Catch: Throwable -> L19
        goto L10
    L41:
        r102 = this.codec.dequeueInputBuffer(0);     // Catch: Exception -> L32
        if (r102 != (-1)) goto L39;
        RXLogging.i(TAG, "Dropped frame, no input buffers available");
        return VideoCodecStatus.NO_OUTPUT;
    L39:
        r103 = this.codec.getInputBuffers()[r102];     // Catch: Exception -> L29
    L29:
        e = move-exception;
        RXLogging.e(TAG, "getInputBuffers failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L32:
        e = move-exception;
        RXLogging.e(TAG, "dequeueInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private VideoCodecStatus encodeTextureBuffer(RXVideoFrameInterface r110) {
        this.encodeThreadChecker.checkIsOnValidThread();
        int r100 = GLES20.glGetError();     // Catch: Exception -> L31
        if (r100 == 0) goto L7;
        RXLogging.e(TAG, "got egl err:" + r100);     // Catch: Exception -> L31
    L7:
        if (this.enableGlClear == false) goto L10;
        GLES20.glClear(16384);     // Catch: Exception -> L31
    L10:
        if (this.queriedGLESVersion != 3) goto L25;
        RXVideoMemoryInterface r101 = r110.getAndRetainVideoFrameMemory();     // Catch: Exception -> L31
        if (r101 != null) goto L16;
        RXLogging.e(TAG, "encodeTexture got empty frame, skip this frame");     // Catch: Exception -> L31
        return VideoCodecStatus.OK;
    L16:
        if (r101.getMemoryType() != RXVideoMemoryType.kOPENGL_TEXTURE) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == false) goto L23;
        long r103 = ((RXVideoOpenGLMemoryInterface) r101).getGLSync();     // Catch: Exception -> L31
        if (r103 == 0) goto L23;
        GLES30.glWaitSync(r103, 0, -1);     // Catch: Exception -> L31
    L23:
        r101.release();     // Catch: Exception -> L31
        goto L25
    L18:
        r102 = false;
    L25:
        if (this.enableNativeRender == false) goto L27;
        nativeDrawFrame(this.videoFrameDrawerHandler, r110.getNativeHandle(), this.width, this.height, r110.getWidth(), r110.getHeight());     // Catch: Exception -> L31
    L28:
        this.textureEglBase.swapBuffers(r110.getTimestampNs());     // Catch: Exception -> L31
        return VideoCodecStatus.OK;
    L27:
        r110.setRotation(RXVideoRotation.VIDEO_ROTATION_0);     // Catch: Exception -> L31
        VideoFrameDrawer r104 = this.videoFrameDrawer;     // Catch: Exception -> L31
        GlRectDrawer r105 = this.textureDrawer;     // Catch: Exception -> L31
        int r111 = this.width;     // Catch: Exception -> L31
        int r112 = this.height;     // Catch: Exception -> L31
        r104.drawFrame(r110, r105, null, 0, 0, r111, r112, r111, r112);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        RXLogging.e(TAG, "encodeTexture failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private void initMediaFormat(MediaFormat r100) {
        if (this.useSurfaceMode == false) goto L5;
        Integer r101 = this.surfaceColorFormat;
    L6:
        int r102 = r101.intValue();
        RXVideoCodecStandard r103 = this.codecDesc.getStandard();
        setIntegerParam(r100, "bitrate", Integer.valueOf(this.settings.targetBps));
        setIntegerParam(r100, "color-format", Integer.valueOf(r102));
        setIntegerParam(r100, com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, Integer.valueOf(this.settings.targetFps));
        int r104 = this.settings.targetKeyFrameIntervalMs;
        if (r104 > 0) goto L9;
        setIntegerParam(r100, "i-frame-interval", Integer.valueOf(this.keyFrameIntervalSec));
    L14:
        setBitrateMode(r100);
        if (this.settings.encodeMode != VideoEncoder.EncodeMode.LIVE) goto L17;
        setProfileForLive(r100);
    L18:
        setBFrameNumber(r100);
        setSVCNumber(r100);
        if (r103 != RXVideoCodecStandard.VP8) goto L21;
    L28:
        Iterator<Map.Entry<String, String>> r105 = this.privateParams.entrySet().iterator();
    L30:
        if (r105.hasNext() == false) goto L37;
        Map.Entry<String, String> r106 = r105.next();
        RXLogging.w(TAG, "set android hardware encoder private param with Key:" + r106.getKey() + " Value:" + r106.getValue());
        if (isNumeric(r106.getValue()) == true) goto L33;
        if (r106.getValue().length() <= 0) goto L30;
        r100.setString(r106.getKey(), r106.getValue());
        goto L30
    L33:
        r100.setInteger(r106.getKey(), CastIntegerProtector.parseInt(r106.getValue()));
        goto L30
    L37:
        return;
    L21:
        if (this.settings.enableQpSetting == false) goto L28;
        if (this.codecName.contains("OMX.hisi.") == false) goto L25;
        setIntegerParam(r100, KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE, 1);
    L25:
        setIPFrameMinMaxQP(r100);
        if (isBFrameEnabled() == false) goto L28;
        setBFrameMinMaxQP(r100);
        goto L28
    L17:
        setProfileForRTC(r100);
        setColorSpace(r100);
        goto L18
    L9:
        int r107 = r104 / 1000;
        if (r107 > 1) goto L13;
        r107 = 1;
    L13:
        setIntegerParam(r100, "i-frame-interval", Integer.valueOf(r107));
        goto L14
    L5:
        r101 = this.yuvColorFormat;
        goto L6
    }

    private boolean isForceUseSurfaceInput(int r100) {
        if (this.codecName.toLowerCase().contains("qti") == true) goto L7;
        if (this.codecName.toLowerCase().contains("qcom") == true) goto L7;
    L9:
        Boolean r101 = this.forceSurfaceInput;
        if (r101 != null) goto L12;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return true;
    L19:
        if (this.isNeedSurfaceInputWorkaround == true) goto L21;
    L23:
        return false;
    L21:
        if ((r100 % 16) == 0) goto L23;
        return true;
    L12:
        if (r101.booleanValue() == false) goto L16;
        if (this.isNeedSurfaceInputWorkaround == true) goto L16;
        r102 = true;
    L7:
        if (isBFrameEnabled() == false) goto L9;
        return true;
    }

    private boolean isNumeric(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.matches("[0-9]+") == false) goto L6;
        return true;
    }

    private /* synthetic */ void lambda$release$0(HandlerThread r100) {
        releaseCodecOnOutputThread();
        if (r100 == null) goto L6;
        r100.quit();
        return;
    }

    private /* synthetic */ void lambda$releaseCodecOnOutputThread$1(MediaCodecWrapper r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        RXLogging.e(TAG, "mediacodec release start!");
        r100.stop();     // Catch: Exception -> L7
    L17:
        r100.release();     // Catch: Exception -> L11
    L13:
        RXLogging.e(TAG, "mediacodec release end!");
        return;
    L11:
        e = move-exception;
        RXLogging.e(TAG, "Media encoder release failed", e);
        this.shutdownException = e;
    L7:
        e = move-exception;
        RXLogging.e(TAG, "Media encoder stop failed", e);
        goto L17
    }

    private int parseRealLayerNum(MediaFormat r100) {
        String r101 = r100.getString("ts-schema");
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L17:
        RXLogging.w(TAG, "output temporal str is: " + r101);
        return 1;
    L5:
        if (r101.length() < 17) goto L17;
        String r102 = r101.substring(16, 17);
        if (isNumeric(r102) == true) goto L19;
    L15:
        RXLogging.e(TAG, "temporal layer invalid: ".concat(r101));
        return 1;
    L19:
        int r103 = CastIntegerProtector.parseInt(r102);     // Catch: NumberFormatException -> L13
        if (r103 > this.settings.temporalLayerNum) goto L15;
        if (r103 <= 0) goto L15;
        return r103;
    L13:
        e = move-exception;
        RXLogging.e(TAG, e.toString());
        goto L15
    }

    private void requestKeyFrame(long r100) {
        this.encodeThreadChecker.checkIsOnValidThread();
        Bundle r101 = new Bundle();     // Catch: Exception -> L6
        r101.putInt("request-sync", 0);     // Catch: Exception -> L6
        this.codec.setParameters(r101);     // Catch: Exception -> L6
        this.lastKeyFrameNs = r100;
        return;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "requestKeyFrame failed", e);
    }

    private VideoCodecStatus resetCodec(boolean r100) {
        this.encodeThreadChecker.checkIsOnValidThread();
        RXLogging.w(TAG, "resetCodec: " + this.width + " " + this.height + " " + r100);
        VideoCodecStatus r101 = release();
        if (r101 == VideoCodecStatus.OK) goto L5;
        return r101;
    L5:
        this.useSurfaceMode = r100;
        this.settings.targetBps = this.updateBitrate;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.callback.onEncodedEvent(VideoEncoder.EncodeEvent.RESET);
        return initEncodeInternal();
    }

    private void setBFrameMinMaxQP(MediaFormat r100) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        setIntegerParam(r100, "video-qp-b-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r100, "video-qp-b-min", Integer.valueOf(this.settings.minQp));
    L6:
        if (this.codecName.toLowerCase().contains("qti") == false) goto L9;
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-b-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-b-max", Integer.valueOf(this.settings.maxQp));
        return;
    }

    private void setBFrameNumber(MediaFormat r100) {
        if (isBFrameEnabled() == true) goto L5;
        setIntegerParam(r100, "max-bframes", 0);
        return;
    L5:
        if (this.codecDesc.getStandard() != RXVideoCodecStandard.H264) goto L11;
        RXVideoCodecProfile r101 = this.codecDesc.getProfile();
        if (r101 == RXVideoCodecProfile.ProfileHigh) goto L11;
        if (r101 == RXVideoCodecProfile.ProfileConstrainedHigh) goto L11;
        RXLogging.w(TAG, "enabel b frame, set high profile explicitly");
        setIntegerParam(r100, "profile", 8);
        setIntegerParam(r100, "level", 256);
    L11:
        setIntegerParam(r100, "max-bframes", 1);
    }

    private void setBitrateMode(MediaFormat r100) {
        this.codec.getCodecInfo();
        VideoEncoder.BitrateMode r101 = VideoEncoder.BitrateMode.CBR;
        VideoEncoder.BitrateMode r102 = this.settings.bitrateMode;
        if (r101 != r102) goto L5;
    L8:
        setIntegerParam(r100, "bitrate-mode", 2);
        return;
    L5:
        if (VideoEncoder.BitrateMode.AUTO == r102) goto L8;
        setIntegerParam(r100, "bitrate-mode", 1);
    }

    private void setIPFrameMinMaxQP(MediaFormat r100) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        setIntegerParam(r100, "video-qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r100, "video-qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r100, "video-qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r100, "video-qp-p-max", Integer.valueOf(this.settings.maxQp));
    L5:
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r100, "vendor.qti-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r100, "vendor.rtc-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r100, "vendor.rtc-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r100, "vendor.rtc-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r100, "vendor.rtc-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r100, "vendor.rtc-ext-enc-low-latency.enable", 1);
        if (this.codecName.toLowerCase().contains("exynos") == false) goto L9;
        setIntegerParam(r100, "vendor.sec-ext-enc-qp-range.I-minQP", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r100, "vendor.sec-ext-enc-qp-range.I-maxQP", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r100, "vendor.sec-ext-enc-qp-range.P-maxQP", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r100, "vendor.sec-ext-enc-qp-range.P-minQP", Integer.valueOf(this.settings.minQp));
    L9:
        if (this.codecName.toLowerCase().contains("mtk") == false) goto L12;
        setIntegerParam(r100, "vendor.mtk.venc.dynamic.qpbound.min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r100, "vendor.mtk.venc.dynamic.qpbound.max", Integer.valueOf(this.settings.maxQp));
        return;
    }

    private void setProfileForLive(MediaFormat r110) {
        RXVideoCodecStandard r100 = this.codecDesc.getStandard();
        MediaCodecInfo r101 = this.codec.getCodecInfo();
        RXVideoCodecProfile r102 = this.codecDesc.getProfile();
        int r103 = 1;
        if (r100 != RXVideoCodecStandard.H264) goto L19;
        r103 = r102.toSystemProfile();     // Catch: Exception -> L6
    L8:
        MediaCodecInfo.CodecProfileLevel[] r104 = r101.getCapabilitiesForType(r100.mimeType()).profileLevels;
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L14;
        MediaCodecInfo.CodecProfileLevel r107 = r104[r106];
        if (r103 == r107.profile) goto L15;
        r106 = r106 + 1;
    L15:
        if (r107 == null) goto L17;
        r110.setInteger("profile", r107.profile);
        r110.setInteger("level", r107.level);
        return;
    L17:
        RXLogging.w(TAG, "not set profile");
        return;
    L14:
        r107 = null;
    L6:
        e = move-exception;
        RXLogging.w(TAG, "" + e);
        goto L8
    L19:
        if (r100 != RXVideoCodecStandard.ByteVC1) goto L34;
        r103 = r102.toSystemProfile();     // Catch: Exception -> L22
    L24:
        r110.setInteger("profile", r103);
        r110.setInteger("level", 256);
        return;
    L22:
        e = move-exception;
        RXLogging.w(TAG, "" + e);
        goto L24
    }

    private void setProfileForRTC(MediaFormat r110) {
        RXLogging.w(TAG, "close setting profile:" + this.settings.closeSetProfile);
        RXVideoCodecStandard r100 = this.codecDesc.getStandard();
        if (this.settings.closeSetProfile == false) goto L5;
        return;
    L5:
        if (r100 != RXVideoCodecStandard.H264) goto L19;
        RXVideoCodecProfile r101 = this.codecDesc.getProfile();
        int r102 = AnonymousClass2.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[r101.ordinal()];
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L17;
        if (r102 != 3) goto L12;
    L16:
        RXLogging.w(TAG, "setting baseline profile ");
        setIntegerParam(r110, "profile", 1);
        setIntegerParam(r110, "level", 256);
        return;
    L12:
        if (r102 == 4) goto L16;
        if (r102 == 5) goto L16;
        RXLogging.w(TAG, "Unknown profile level id: " + r101 + "default to baseline profile");
        setIntegerParam(r110, "profile", 1);
        setIntegerParam(r110, "level", 256);
        return;
    L17:
        RXLogging.w(TAG, "setting high profile ");
        setIntegerParam(r110, "profile", 8);
        setIntegerParam(r110, "level", 256);
        return;
    L19:
        if (r100 != RXVideoCodecStandard.ByteVC1) goto L30;
        RXVideoCodecProfile r103 = this.codecDesc.getProfile();
        int r104 = AnonymousClass2.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[r103.ordinal()];
        if (r104 != 6) goto L23;
        setIntegerParam(r110, "profile", 1);
        setIntegerParam(r110, "level", 8);
        return;
    L23:
        if (r104 == 7) goto L27;
        if (r104 == 8) goto L26;
        RXLogging.w(TAG, "Unknown profile level id: " + r103 + "default to Main profile");
        setIntegerParam(r110, "profile", 1);
        setIntegerParam(r110, "level", 8);
        return;
    L26:
        setIntegerParam(r110, "profile", 4096);
        setIntegerParam(r110, "level", 8);
        return;
    L27:
        setIntegerParam(r110, "profile", 2);
        setIntegerParam(r110, "level", 8);
        return;
    L30:
        if (r100 != RXVideoCodecStandard.VP8) goto L41;
        setIntegerParam(r110, "profile", 1);
        return;
    }

    private void setSVCNumber(MediaFormat r100) {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return;
    L5:
        if (isSvcEnabled() == false) goto L9;
        setStringParam(r100, "ts-schema", "android.generic." + this.settings.temporalLayerNum);
        return;
    }

    private boolean shouldForceKeyFrame(long r100) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long r101 = this.forcedKeyFrameNs;
        if (r101 > 0) goto L5;
    L7:
        return false;
    L5:
        if (r100 <= (this.lastKeyFrameNs + r101)) goto L7;
        return true;
    }

    private VideoCodecStatus updateBitrate(int r100) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.updateBitrate = r100;
        Bundle r101 = new Bundle();     // Catch: Exception -> L5
        r101.putInt("video-bitrate", r100);     // Catch: Exception -> L5
        this.codec.setParameters(r101);     // Catch: Exception -> L5
        return VideoCodecStatus.OK;
    L5:
        e = move-exception;
        RXLogging.e(TAG, "updateBitrate failed", e);
        return VideoCodecStatus.ERROR;
    }

    public void setColorSpace(MediaFormat r100) {
        if (this.useSurfaceMode == true) goto L14;
        if (this.codecName.contains("OMX.hisi.") == false) goto L14;
        if (this.settings.rangeId != 0) goto L14;
        if (this.yuvColorFormat.intValue() != 19) goto L11;
    L12:
        RXLogging.w(TAG, "kirin chips skip setting MediaFormat COLOR_RANGE");
    L17:
        setIntegerParam(r100, "color-standard", 4);
        setIntegerParam(r100, "color-transfer", 3);
        return;
    L11:
        if (this.yuvColorFormat.intValue() == 21) goto L12;
    L14:
        if (this.settings.rangeId != 1) goto L16;
        RXLogging.w(TAG, "setting MediaFormat COLOR_RANGE_FULL");
        setIntegerParam(r100, "color-range", 1);
        goto L17
    L16:
        RXLogging.w(TAG, "setting MediaFormat COLOR_RANGE_LIMITED");
        setIntegerParam(r100, "color-range", 2);
        goto L17
    }

    private void caculateDts(long r100, EncodedImage.Builder r110) {
        if (isBFrameEnabled() == false) goto L21;
        Long r101 = this.dtsQueue.pollLast();
        if (r101 != null) goto L9;
        RXLogging.e(TAG, "dtsQueue is empty.");
        return;
    L9:
        if (this.encodedFirstFrame == true) goto L11;
        this.encodedFirstFrame = true;
        this.firstFrameDiffUs = r100 - r101.longValue();
        RXLogging.w(TAG, "firstFrameDiffUs: " + this.firstFrameDiffUs + " " + r100);
    L11:
        Long r102 = Long.valueOf((r101.longValue() + this.firstFrameDiffUs) - ((long) ((1000000 / this.settings.targetFps) * 7)));
        long r103 = r100 - r102.longValue();
        if (r102.longValue() >= 0) goto L14;
    L19:
        RXLogging.e(TAG, "ctsUs < 0; " + r103 + " " + r102);
        return;
    L14:
        if (r103 < 0) goto L19;
        if (r103 != 0) goto L18;
        r103 = 1;
    L18:
        r110.setCompositionTimeUs(r103);
        return;
    }

    private void setExtCodecForHisi(int r100, int r101) {
        if (this.codecName.contains("OMX.hisi.") == false) goto L44;
        MediaCodecWrapper r102 = this.codec;
        if (r102 == null) goto L46;
        MediaFormat r103 = r102.getOutputFormat();     // Catch: Exception -> L9
    L11:
        if (r103 != null) goto L13;
        return;
    L13:
        RXLogging.i(TAG, "output format before start: " + r103.toString());
        boolean r104 = false;
        if (r103.containsKey(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) == true) goto L16;
    L18:
        boolean r105 = false;
    L20:
        if (r103.containsKey(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) == true) goto L22;
    L24:
        Bundle r106 = new Bundle();
        if (r104 == true) goto L27;
    L31:
        if (r105 == false) goto L33;
        r106.putInt(KEY_HISI_EXT_CODEC_MAX_QP, r100);
        r106.putInt(KEY_HISI_EXT_CODEC_MIN_QP, r101);
    L33:
        if (r104 == true) goto L42;
        if (r105 == true) goto L42;
        return;
    L42:
        this.codec.setParameters(r106);     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        RXLogging.e(TAG, "setExtCodecForHisi failed", e);
        return;
    L27:
        if (isSvcEnabled() == false) goto L31;
        if (this.svcRealLayerNum > 1) goto L31;
        r106.putInt(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES, 1);
        this.svcRealLayerNum = 2;
        RXLogging.w(TAG, "support Non Ref PFrame.");
        goto L31
    L22:
        if (r103.getInteger(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) != 1) goto L24;
        r104 = true;
        goto L24
    L16:
        if (r103.getInteger(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) != 1) goto L18;
        r105 = true;
    L9:
        e = move-exception;
        RXLogging.e(TAG, "getOutputFormat failed", e);
        r103 = null;
        goto L11
    L46:
        return;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus encode(RXVideoFrameInterface r110, boolean r111) {
        this.encodeThreadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error(TAG);
        if (this.codec == null) goto L5;
        Object r100 = this.callbackLock;
        monitor-enter(r100);
    L92:
        th = move-exception;
        throw th;
    L9:
        if (this.isError == false) goto L13;
        VideoCodecStatus r112 = VideoCodecStatus.FALLBACK_SOFTWARE;     // Catch: Throwable -> L92
        monitor-exit(r100);     // Catch: Throwable -> L92
        return r112;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L92
        RXVideoMemoryInterface r101 = r110.getAndRetainVideoFrameMemory();
        if (r101 == null) goto L17;
        boolean r102 = r101 instanceof NativeRXOpenGLMemory;
        Boolean r103 = this.isTextureBuffer;
        if (r103 != null) goto L21;
    L22:
        this.isTextureBuffer = Boolean.valueOf(r102);
        RXLogging.e(TAG, "isTextureBuffer: " + this.isTextureBuffer);
    L23:
        int r104 = r110.getWidth();
        int r105 = r110.getHeight();
        boolean r106 = true;
        boolean r107 = false;
        if (this.actualWidth == r104) goto L26;
    L29:
        boolean r108 = true;
    L30:
        if (r108 == false) goto L32;
        this.actualWidth = r104;
        this.actualHeight = r105;
        alignResolutionIfNeeded();
    L32:
        boolean r109 = isForceUseSurfaceInput(this.width);
        if (canUseSurface() == false) goto L37;
        if (r102 == true) goto L36;
        if (r109 == false) goto L37;
    L36:
        boolean r113 = true;
    L38:
        if (r113 == false) goto L45;
        if (r102 == false) goto L45;
        EglBase14.Context r114 = new EglBase14.Context(((NativeRXOpenGLMemory) r101).getEGLContext(), EglBase.EglVersion.getPreferredEglVersion());
        if (this.sharedContext != null) goto L43;
    L44:
        this.sharedContext = r114;
    L46:
        r101.release();
        if (r113 != this.useSurfaceMode) goto L51;
        if (r108 == true) goto L51;
        r107 = r106;
    L54:
        if (r107 == true) goto L56;
    L67:
        resetCodecWhenBitrateChange();
        if (r111 == false) goto L70;
        RXLogging.i(TAG, "Request key frame");
    L70:
        if (r111 == false) goto L72;
    L73:
        requestKeyFrame(r110.getTimestampNs());
    L75:
        if (isBFrameEnabled() == false) goto L78;
        this.dtsQueue.push(Long.valueOf(r110.getTimestampUs()));
    L78:
        if (this.useSurfaceMode == true) goto L80;
        VideoCodecStatus r115 = encodeByteBuffer(r110);
    L87:
        if (r115 != VideoCodecStatus.OK) goto L89;
    L91:
        return r115;
    L89:
        if (isBFrameEnabled() == false) goto L91;
        this.dtsQueue.pollFirst();
        goto L91
    L80:
        if (this.enableGlClear == false) goto L84;
        EglBase14 r116 = this.textureEglBase;
        if (r116 == null) goto L84;
        r116.makeCurrent();
    L84:
        r115 = encodeTextureBuffer(r110);
        goto L87
    L72:
        if (shouldForceKeyFrame(r110.getTimestampNs()) == false) goto L75;
    L56:
        if (this.useSurfaceMode == false) goto L67;
        if (RXVideoSurfaceController.getInstance().usePassSurfaceMode() == true) goto L67;
        RXLogging.w(TAG, "egl env changed, create new shared context from the new videoframe egl context");
        releaseFrameDrawer();
        EglBase14 r117 = this.textureEglBase;
        if (r117 == null) goto L96;
        r117.release();
        this.textureEglBase = null;
    L96:
        EglBase14 r118 = new EglBase14(this.sharedContext, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));     // Catch: Exception -> L64
        this.textureEglBase = r118;     // Catch: Exception -> L64
        r118.createSurface(this.textureInputSurface);     // Catch: Exception -> L64
        this.textureEglBase.makeCurrent();     // Catch: Exception -> L64
        initFrameDrawer();     // Catch: Exception -> L64
    L64:
        e = move-exception;
        RXLogging.e(TAG, "egl failed, fallback software:", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L51:
        VideoCodecStatus r119 = resetCodec(r113);
        if (r119 == VideoCodecStatus.OK) goto L54;
        return r119;
    L43:
        if (r114.getNativeEglContext() != this.sharedContext.getNativeEglContext()) goto L44;
    L45:
        r106 = false;
    L37:
        r113 = false;
        goto L38
    L26:
        if (this.actualHeight != r105) goto L29;
        r108 = false;
        goto L30
    L21:
        if (r103.booleanValue() == r102) goto L23;
    L17:
        return VideoCodecStatus.MEMORY;
    L5:
        return VideoCodecStatus.UNINITIALIZED;
    }

    public void fillInputBuffer(ByteBuffer r100, RXVideoFrameInterface r101) {
        this.yuvFormat.fillBuffer(r100, r101, this.width, this.height);
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings r100, VideoEncoder.Callback r101) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.sharedContext = r100.sharedContext;
        this.callback = r101;
        this.automaticResizeOn = true;
        this.actualWidth = r100.width;
        this.actualHeight = r100.height;
        this.scaleMode = r100.scaleMode;
        this.bitrateMode = r100.bitrateMode;
        this.updateBitrate = r100.targetBps;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.settings = r100;
        boolean r102 = false;
        if (r100.enableAsyncMode == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.useAsyncMode = r103;
        alignResolutionIfNeeded();
        if (RXVideoSurfaceController.getInstance().usePassSurfaceMode() == false) goto L12;
        RXLogging.e(TAG, "using pass surface mode");
        this.useSurfaceMode = true;
    L21:
        RXLogging.w(TAG, "initEncode, codec name:" + this.codecName + ", with resolution:" + this.width + " x " + this.height + ". @ " + r100.targetBps + "bps. Fps: " + r100.targetFps + " Use surface mode: " + this.useSurfaceMode + " initUseSurfaceMode: " + r100.useSurfaceMode + " enableAlignment:" + r100.enableAlignment + " settings.bitrateMode:" + r100.bitrateMode + " qp_min:" + r100.minQp + " qp_max:" + r100.maxQp + " qp_i_min:" + r100.minIQp + " qp_i_max:" + r100.maxIQp + " useAsyncMode:" + this.useAsyncMode + " surfaceColorFormat: " + this.surfaceColorFormat + " yuvColorFormat: " + this.yuvColorFormat);
        return initEncodeInternal();
    L12:
        if (canUseSurface() == true) goto L14;
    L18:
        this.useSurfaceMode = r102;
        if (isForceUseSurfaceInput(this.width) == false) goto L21;
        this.useSurfaceMode = true;
        goto L21
    L14:
        if (r100.useSurfaceMode == false) goto L18;
        if (this.sharedContext == null) goto L18;
        r102 = true;
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec r100, MediaCodec.CodecException r101) {
        RXLogging.w(TAG, "mediacodec error: " + r101.getDiagnosticInfo() + " " + r101);
        if (this.running == false) goto L18;
        MediaCodecWrapper r102 = this.codec;
        if (r102 == null) goto L18;
        if (r102.getRealCodec() != r100) goto L18;
        Object r103 = this.callbackLock;
        monitor-enter(r103);
        this.isError = true;     // Catch: Throwable -> L15
        monitor-exit(r103);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        RXLogging.e(TAG, "onError not same codec " + r101);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec r100, int r101) {
        if (this.running == false) goto L17;
        MediaCodecWrapper r102 = this.codec;
        if (r102 == null) goto L17;
        if (r102.getRealCodec() != r100) goto L17;
        Object r103 = this.callbackLock;
        monitor-enter(r103);
        this.inputBuffers.addLast(Integer.valueOf(r101));     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        RXLogging.e(TAG, "onInputBufferAvailable not same codec");
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec r100, MediaFormat r101) {
        if (this.running == false) goto L11;
        MediaCodecWrapper r102 = this.codec;
        if (r102 == null) goto L11;
        if (r102.getRealCodec() != r100) goto L11;
        RXLogging.i(TAG, "output format changed: " + r101.toString());
        return;
    L11:
        RXLogging.e(TAG, "onOutputFormatChanged not same codec");
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setPrivateParam(String r100, String r101) {
        RXLogging.w(TAG, "got android hardware encoder setPrivateParam with key:" + r100 + " value:" + r101);
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -449636302: goto L22;
            case -365977292: goto L18;
            case 232994177: goto L14;
            case 775490441: goto L10;
            case 1064378105: goto L6;
            default: goto L26;
        };
    L6:
        if (r100.equals(KEY_PRIVATE_PARAM_NATIVE_RENDER) == false) goto L26;
        r102 = 4;
        goto L26
    L10:
        if (r100.equals(KEY_PRIVATE_PARAM_CHECK_SVC_LAYER) == false) goto L26;
        r102 = 3;
        goto L26
    L14:
        if (r100.equals(KEY_PRIVATE_PARAM_RELEASE_ASYNC) == false) goto L26;
        r102 = 2;
        goto L26
    L18:
        if (r100.equals(KEY_PRIVATE_PARAM_GLCLEAR) == false) goto L26;
        r102 = 1;
        goto L26
    L22:
        if (r100.equals(KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT) == false) goto L26;
        r102 = 0;
    L26:
        switch(r102) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            default: goto L27;
        };
    L27:
        this.vpassPrivateParams.put(r100, r101);
    L34:
        return VideoCodecStatus.OK;
    L28:
        this.enableNativeRender = "true".equalsIgnoreCase(r101);
        goto L34
    L29:
        this.checkSVCLayer = "true".equalsIgnoreCase(r101);
        goto L34
    L30:
        this.releaseAsync = "true".equalsIgnoreCase(r101);
        goto L34
    L31:
        this.enableGlClear = "true".equalsIgnoreCase(r101);
        goto L34
    L32:
        this.forceSurfaceInput = Boolean.valueOf("true".equalsIgnoreCase(r101));
        goto L34
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setRateAllocation(int r100, int r101) {
        this.encodeThreadChecker.checkIsOnValidThread();
        updateBitrate(r100);
        return VideoCodecStatus.OK;
    }

    private VideoCodecStatus drainInputData(int r100, ByteBuffer r110, RXVideoFrameInterface r111) {
        int r101 = ((this.width * this.height) * 3) / 2;
        long r102 = r111.getTimestampNs() / 1000;
        fillInputBuffer(r110, r111);
        this.codec.queueInputBuffer(r100, 0, r101, r102, 0);     // Catch: Exception -> L6
        return VideoCodecStatus.OK;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private void drainOutputData(int r100, MediaCodec.BufferInfo r110, ByteBuffer r111) {
        r111.position(r110.offset);
        r111.limit(r110.offset + r110.size);
        int r101 = r110.flags;
        if ((r101 & 2) == 0) goto L5;
        RXLogging.i(TAG, "Config frame generated. Offset: " + r110.offset + ". Size: " + r110.size);
        ByteBuffer r112 = ByteBuffer.allocateDirect(r110.size);
        this.configBuffer = r112;
        r112.put(r111);
    L45:
        this.codec.releaseOutputBuffer(r100, false);
        return;
    L5:
        boolean r102 = true;
        if ((r101 & 1) != 0) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L11;
        RXLogging.i(TAG, "Sync frame generated");
    L11:
        Integer r103 = null;
        if (this.isStatisticsEnabled == false) goto L22;
        MediaFormat r104 = this.codec.getOutputFormat(r100);
        if (r104 == null) goto L22;
        if (r104.containsKey("video-qp-average") == false) goto L18;
        Integer r105 = Integer.valueOf(r104.getInteger("video-qp-average"));
    L20:
        if (r104.containsKey("picture-type") == false) goto L23;
        r103 = Integer.valueOf(r104.getInteger("picture-type"));
    L23:
        if (r102 == true) goto L25;
    L29:
        ByteBuffer r106 = r111.slice();
    L30:
        if (r102 == false) goto L32;
        EncodedImage.FrameType r113 = EncodedImage.FrameType.kIntra;
    L33:
        if (r103 == null) goto L35;
        r113 = EncodedImage.FrameType.valueOf(r103.intValue());
    L35:
        EncodedImage.Builder r107 = EncodedImage.builder().setEncodedWidth(this.width).setEncodedHeight(this.height).setActualWidth(this.actualWidth).setActualHeight(this.actualHeight).setCaptureTimeNs(r110.presentationTimeUs * 1000).setBuffer(r106);
        if (this.checkSVCLayer == false) goto L38;
        int r108 = this.svcRealLayerNum;
    L39:
        EncodedImage.Builder r114 = r107.setSvcLayerNum(r108).setFrameType(r113);
        if (r105 != null) goto L42;
    L44:
        caculateDts(r110.presentationTimeUs, r114);
        this.callback.onEncodedFrame(r114.createEncodedImage(), new VideoEncoder.CodecSpecificInfo(this.codecDesc.getStandard()));
        goto L45
    L42:
        if (r105.intValue() <= 0) goto L44;
        r114.setQp(r105);
        goto L44
    L38:
        r108 = this.settings.temporalLayerNum;
        goto L39
    L32:
        r113 = EncodedImage.FrameType.kPredicted;
        goto L33
    L25:
        if (this.codecDesc.getStandard() != RXVideoCodecStandard.H264) goto L27;
    L28:
        RXLogging.i(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + r110.offset + ", size " + r110.size);
        r106 = ByteBuffer.allocateDirect(r110.size + this.configBuffer.capacity());
        this.configBuffer.rewind();
        r106.put(this.configBuffer);
        r106.put(r111);
        r106.rewind();
        goto L30
    L27:
        if (this.codecDesc.getStandard() != RXVideoCodecStandard.ByteVC1) goto L29;
    L18:
        r105 = null;
    L22:
        r105 = null;
        goto L23
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
        RXLogging.w(TAG, "the encoder params " + r104.getKey() + " set by vpaas is invalid with value:" + r104.getValue() + ",skip it");
        goto L4
    L14:
        RXLogging.w(TAG, "the encoder params " + r104.getKey() + " is disabled by vpaas,skip it");
        return;
    L9:
        r100.setInteger(r104.getKey(), CastIntegerProtector.parseInt(r104.getValue()));
        RXLogging.w(TAG, "the encoder params " + r104.getKey() + " is coverd by vpaas with value:" + r104.getValue());
        this.privateParams.remove(r101);
        return;
    L16:
        RXLogging.w(TAG, "encoder int params has been set with Key:" + r101 + " Value:" + r102);
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
        RXLogging.w(TAG, "the encoder params " + r104.getKey() + " is coverd by vpaas with value:" + r104.getValue());
    L11:
        this.privateParams.remove(r101);
        return;
    L10:
        RXLogging.w(TAG, "the encoder params " + r104.getKey() + " is disabled by vpaas,skip it");
        goto L11
    L13:
        RXLogging.w(TAG, "encoder string params has been set with Key:" + r101 + " Value:" + r102);
        r100.setString(r101, r102);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec r100, int r101, MediaCodec.BufferInfo r102) {
        if (this.running == false) goto L14;
        MediaCodecWrapper r103 = this.codec;
        if (r103 == null) goto L14;
        if (r103.getRealCodec() != r100) goto L14;
        drainOutputData(r101, r102, r100.getOutputBuffer(r101));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        RXLogging.e(TAG, "onOutputBufferAvailable failed", e);
        return;
    L14:
        RXLogging.e(TAG, "onOutputBufferAvailable not same codec");
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory r100, String r101, RXVideoCodecDesc r102, Integer r103, Integer r110, int r111, int r112, MediaCodecInfo.CodecCapabilities r113) {
        this.queriedGLESVersion = 2;
        this.textureDrawer = null;
        this.videoFrameDrawer = null;
        this.videoFrameDrawerHandler = 0;
        ThreadUtils.ThreadChecker r104 = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = r104;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.privateParams = new HashMap();
        this.vpassPrivateParams = new HashMap();
        this.forceSurfaceInput = null;
        this.isNeedSurfaceInputWorkaround = false;
        boolean r105 = true;
        this.svcRealLayerNum = 1;
        this.checkSVCLayer = false;
        this.encodedFirstFrame = false;
        this.firstFrameDiffUs = 0;
        this.dtsQueue = new LinkedBlockingDeque();
        this.releaseAsync = true;
        this.enableGlClear = false;
        this.useAsyncMode = false;
        this.inputBuffers = new LinkedList();
        this.isError = false;
        this.callbackLock = new Object();
        this.enableNativeRender = false;
        this.isStatisticsEnabled = false;
        this.mediaCodecWrapperFactory = r100;
        this.codecName = r101;
        this.codecDesc = r102;
        this.surfaceColorFormat = r103;
        this.yuvColorFormat = r110;
        this.yuvFormat = YuvFormat.valueOf(r110.intValue());
        this.keyFrameIntervalSec = r111;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(r112);
        String r106 = RXDeviceInfoAndroid.GetCpuModel();
        String r107 = RXDeviceInfoAndroid.GetDeviceModel();
        if (r106 != null) goto L5;
    L19:
        this.capabilities = r113;
        this.codecWidthAlign = 0;
        this.codecHeightAlign = 0;
        r104.detachThread();
        return;
    L5:
        if (r106.contains("MT6785V/CC") == false) goto L7;
    L18:
        this.isNeedSurfaceInputWorkaround = r105;
        goto L19
    L7:
        if (r106.contains("MT6833V/ZA") == false) goto L11;
        if ("RMX3610".equalsIgnoreCase(r107) == false) goto L18;
    L11:
        if (r106.contains("MT6833V/PNZA") == true) goto L18;
        if (r106.contains("MT6853V/ZA") == true) goto L18;
        if (r106.contains("MT6893Z_C/CZA") == true) goto L18;
        r105 = false;
        goto L18
    }
}
