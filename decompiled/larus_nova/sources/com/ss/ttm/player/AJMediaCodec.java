package com.ss.ttm.player;

import android.hardware.HardwareBuffer;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceControl;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final int CODEC_TIME_OUT = 3000;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "JAJMediaCodec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private static final Object mAsyncLock = null;
    private static final ArrayList<MediaCodecInfo> mAudioSWDecoderCodecs = null;
    private static int mCodecInstanceNums;
    private static final Object mCodecListLock = null;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround;
    private static int mEnableMediaCodecSyncClose;
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private static boolean mIsByteVC1Blocklist;
    private static int mIsByteVC1BlocklistEnable;
    private static boolean mIsInitDetected;
    private static boolean mNeedByteVC1WorkAround;
    private static final Condition mSingleCodecCond = null;
    private static final ReentrantLock mSingleCodecLock = null;
    private static final ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = null;
    private static final ArrayList<MediaCodecInfo> mVideoSWDecoderCodecs = null;
    private final AJMediaFormat mAJMediaFormat;
    private Handler mAsyncHandler;
    private final Object mAsyncLock2;
    private HandlerThread mAsyncThread;
    private ConcurrentHashMap<Integer, MediaCodec.LinearBlock> mBlockHashMap;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodecInfo mCodecInfo;
    private volatile boolean mCodecIsClosed;
    private String mCodecType;
    private int mCreateCodecTimeoutMs;
    private int mDecoderType;
    private int mDisableAllowFrameDrop;
    private int mDowngradeSw;
    private DummySurface mDummySurface;
    private Surface mDummySurfaceV29;
    private int mEnableBlockMode;
    private boolean mEnableCacheCodecAsync;
    private int mEnableGetCodecInfosOpt;
    private int mEnableHisiLowLatency;
    private int mEnableLowLatency;
    private int mEnableMCVppDebug;
    private int mEnableMCVppLevel;
    private int mEnableQcomCpuAffinityMask;
    private int mEnableQcomEarlyNotify;
    private int mEnableQcomOrder;
    private int mEnableQcomSliceDelivery;
    private int mEnableQcomTimestampReorder;
    private int mEnableSetVideoScalingMode;
    private int mEnableSingleCodec;
    private int mEnableUseCodec2;
    private String mExceptionInfo;
    private int mFixedMemcpyCrash;
    private int mHandleOutputBuffersChanged;
    private int mHandleStopAsync;
    private long mHandler;
    private int mHisiFrequenceValue;
    private int mImportanceValue;
    private ByteBuffer[] mInputBuffers;
    private boolean mInputBuffersValid;
    private int mLowLatencyType;
    private int mMCOperatingRateBeforeOpen;
    private int mMCOperatingRateMode;
    private int mMCPriority;
    private int mMCVppLevel;
    private int mMcMode;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private android.media.MediaFormat mOutputMediaFormat;
    private int mPendingFlushCount;
    private int mQcomCpuAffinityMaskValue;
    private int mQcomEarlyNotifyValue;
    private int mSpecifyMaxInputSize;
    private boolean mStopAsync;
    private int mSupportAdaptivePlayBack;

    private static native void _clearBufferIndex(long r100);

    private static native void _clearBufferIndex2(long r100);

    private static native void _onClosed2(long r100);

    private static native void _onDrawFrame(long r100, HardwareBuffer r101, int[] r102, int r103, int r104);

    private static native void _onEmptyBuffer(long r100, int r101);

    private static native void _onEmptyBuffer2(long r100, int r101);

    private static native void _onError(long r100);

    private static native void _onError2(long r100, int r101, String r102);

    private static native void _onFilledBuffer(long r100, int r101, int r102, int r103, long r104, int r105);

    private static native void _onFilledBuffer2(long r100, int r101, int r102, int r103, long r104, int r105);

    private static native void _onFormatChanged(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110);

    private static native void _onFormatChanged2(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110);

    private static native void _setSurfaceCompleted(long r100);

    private static native void _setSurfaceCompleted2(long r100);

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mVideoHWDecoderCodecs = new ArrayList();
        mVideoSWDecoderCodecs = new ArrayList();
        mAudioSWDecoderCodecs = new ArrayList();
        mCodecListLock = new Object();
        mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
        mDeviceNeedsSetOutputSurfaceWorkaround = false;
        mIsInitDetected = false;
        mIsByteVC1Blocklist = false;
        mNeedByteVC1WorkAround = false;
        mIsByteVC1BlocklistEnable = 1;
        mEnableMediaCodecSyncClose = 0;
        mAsyncLock = new Object();
        mCodecInstanceNums = 0;
        ReentrantLock r100 = new ReentrantLock();
        mSingleCodecLock = r100;
        mSingleCodecCond = r100.newCondition();
    }

    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        monitor-enter(AJMediaCodec.class);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround == true) goto L52;
        int r100 = Util.SDK_INT;     // Catch: Throwable -> L55
        if (r100 <= 27) goto L9;
    L11:
        if (r100 >= 27) goto L51;
        String r101 = Util.DEVICE;     // Catch: Throwable -> L55
        int r102 = r101.hashCode();     // Catch: Throwable -> L55
        byte r103 = 0;
        if (r102 == 99329) goto L27;
        if (r102 == 3351335) goto L24;
        if (r102 == 1865889110) goto L21;
    L29:
        byte r104 = -1;
    L30:
        if (r104 == 0) goto L34;
        if (r104 == 1) goto L34;
        if (r104 == 2) goto L34;
    L35:
        String r105 = Util.MODEL;     // Catch: Throwable -> L55
        int r106 = r105.hashCode();     // Catch: Throwable -> L55
        if (r106 == 2006354) goto L44;
        if (r106 == 2006367) goto L41;
    L46:
        r103 = -1;
    L47:
        if (r103 == 0) goto L50;
        if (r103 != 1) goto L51;
    L50:
        mDeviceNeedsSetOutputSurfaceWorkaround = true;     // Catch: Throwable -> L55
        goto L51
    L41:
        if (r105.equals("AFTN") == false) goto L46;
        r103 = 1;
        goto L47
    L44:
        if (r105.equals("AFTA") == false) goto L46;
    L34:
        mDeviceNeedsSetOutputSurfaceWorkaround = true;     // Catch: Throwable -> L55
        goto L35
    L21:
        if (r101.equals("santoni") == false) goto L29;
        r104 = 2;
        goto L30
    L24:
        if (r101.equals("mido") == false) goto L29;
        r104 = 1;
        goto L30
    L27:
        if (r101.equals("deb") == false) goto L29;
        r104 = 0;
    L51:
        mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;     // Catch: Throwable -> L55
        goto L52
    L9:
        if ("dangal".equals(Util.DEVICE) == false) goto L11;
        mDeviceNeedsSetOutputSurfaceWorkaround = true;     // Catch: Throwable -> L55
    L52:
        monitor-exit(AJMediaCodec.class);     // Catch: Throwable -> L55
        return mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private boolean isAdaptivePlaybackV19() {
        MediaCodecInfo r100 = this.mCodecInfo;
        if (r100 == null) goto L8;
        String r101 = this.mCodecType;
        if (r101 == null) goto L8;
        return r100.getCapabilitiesForType(r101).isFeatureSupported("adaptive-playback");
    L8:
        return true;
    }

    private int isLowLatencyDecode() {
        if (Build.VERSION.SDK_INT < 30) goto L10;
        MediaCodecInfo r100 = this.mCodecInfo;
        if (r100 == null) goto L10;
        String r101 = this.mCodecType;
        if (r101 == null) goto L10;
        return r100.getCapabilitiesForType(r101).isFeatureSupported("low-latency") ? 1 : 0;
    L10:
        return 0;
    }

    private boolean isMtkByteVC1BlockList() {
        String r100 = Util.HARDWARE.toLowerCase(Locale.US);
        if (r100.startsWith("mt6763") == false) goto L5;
    L12:
        return true;
    L5:
        if (r100.startsWith("mt6757") == true) goto L12;
        if (r100.startsWith("mt6739") == true) goto L12;
        if (r100.startsWith("mt6750") == true) goto L12;
        return false;
    }

    private void onSetSurfaceCompleted() {
        if (this.mMcMode != 2) goto L5;
        Object r100 = this.mAsyncLock2;
    L6:
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (this.mCodecIsClosed == false) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L12:
        if (this.mMcMode != 2) goto L14;
        _setSurfaceCompleted2(this.mHandler);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L14:
        _setSurfaceCompleted(this.mHandler);     // Catch: Throwable -> L17
        goto L15
    L5:
        r100 = mAsyncLock;
        goto L6
    }

    private void releaseBlockHashMap() {
        ConcurrentHashMap<Integer, MediaCodec.LinearBlock> r100 = this.mBlockHashMap;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L20;
        Iterator<Map.Entry<Integer, MediaCodec.LinearBlock>> r101 = this.mBlockHashMap.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<Integer, MediaCodec.LinearBlock> r102 = r101.next();
        if (Build.VERSION.SDK_INT < 30) goto L8;
        r102.getValue().recycle();
        goto L8
    L12:
        this.mBlockHashMap.clear();
        return;
    }

    private void releaseDummySurface() {
        AVLogger.Info(TAG, this, "release dummy surface");
        Surface r100 = this.mDummySurfaceV29;
        if (r100 == null) goto L5;
        r100.release();
        this.mDummySurfaceV29 = null;
    L5:
        DummySurface r101 = this.mDummySurface;
        if (r101 == null) goto L9;
        r101.release();
        this.mDummySurface = null;
        return;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public void close() {
        AVLogger.Info(TAG, this, "~JAJMediaCodec#{");
        final MediaCodec r100 = this.mMediaCodec;
        if (r100 != null) goto L5;
    L51:
        AVLogger.InfoTrackLife(TAG, this, "~JAJMediaCodec#}");
        return;
    L5:
        if (this.mHandleStopAsync != 0) goto L8;
        stop();
    L10:
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        int r101 = this.mMcMode;
        if (r101 != 1) goto L26;
        if (Util.SDK_INT < 23) goto L26;
        Object r102 = mAsyncLock;
        monitor-enter(r102);
        HandlerThread r103 = this.mAsyncThread;     // Catch: Throwable -> L22
        if (r103 == null) goto L19;
        r103.quit();     // Catch: Throwable -> L22
    L19:
        _clearBufferIndex(this.mHandler);     // Catch: Throwable -> L22
        this.mCodecIsClosed = true;     // Catch: Throwable -> L22
        this.mMediaCodec = null;     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
    L45:
        if (mEnableMediaCodecSyncClose <= 0) goto L47;
        AVLogger.Info(TAG, this, "sync releaseCodec");
        releaseCodec(r100);
        goto L51
    L47:
        Runnable r104 = new AnonymousClass3(this, r100);
        AVThreadPool.addTask(r104);     // Catch: Throwable -> L50
    L50:
        AVLogger.Warn(TAG, this, "new thread failed");
        r104.run();
    L22:
        th = move-exception;
        throw th;
    L26:
        if (r101 == 2) goto L28;
        this.mMediaCodec = null;
        goto L45
    L28:
        if (Util.SDK_INT < 23) goto L32;
        HandlerThread r105 = this.mAsyncThread;
        if (r105 == null) goto L32;
        r105.quit();
    L32:
        this.mCodecIsClosed = true;
        this.mMediaCodec = null;
        AVThreadPool.addTask(new AnonymousClass2(this));     // Catch: Throwable -> L35
    L35:
        AVLogger.Warn(TAG, this, "onClosed in current thread");
        monitor-enter(this.mAsyncLock2);
        _onClosed2(this.mHandler);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L8:
        if (this.mStopAsync == false) goto L10;
        stopCodec(r100);
        this.mStopAsync = false;
        goto L10
    }

    public int flush() {
        AVLogger.Info(TAG, this, "flush");
        this.mMediaCodec.flush();     // Catch: Exception -> L18
        releaseBlockHashMap();     // Catch: Exception -> L18
        int r100 = this.mMcMode;     // Catch: Exception -> L18
        if (r100 != 1) goto L14;
        Object r101 = mAsyncLock;     // Catch: Exception -> L18
        monitor-enter(r101);     // Catch: Exception -> L18
        this.mPendingFlushCount++;     // Catch: Throwable -> L10
        this.mAsyncHandler.post(new AnonymousClass4(this));     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    L16:
        AVLogger.Info(TAG, this, "flush done");
        return 0;
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L14:
        if (r100 != 2) goto L16;
        this.mPendingFlushCount++;     // Catch: Exception -> L18
        this.mAsyncHandler.post(new AnonymousClass5(this));     // Catch: Exception -> L18
    L18:
        return -1;
    }

    public int getChannelCount() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
    }

    public int getColorFormat() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L16;
    L14:
        return 0;
    L16:
        int r101 = r100.getInteger("color-format");     // Catch: Exception -> L15
        if (r101 != 21) goto L8;
        return 3;
    L8:
        if (r101 != 2130706688) goto L10;
        return 3;
    L10:
        if (r101 == 2141391872) goto L19;
        return 0;
    L19:
        return 3;
    }

    public int getColorTransfer() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L16;
    L14:
        return 0;
    L16:
        int r101 = r100.getInteger("color-transfer");     // Catch: Exception -> L15
        if (r101 != 6) goto L8;
        return 16;
    L8:
        if (r101 == 7) goto L10;
        return 0;
    L10:
        return 18;
    }

    public int getFormatHeight() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L21;
    L19:
        return 0;
    L21:
        if (r100.containsKey(KEY_CROP_RIGHT) == true) goto L8;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L18;
        return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
    L18:
        return this.mOutputMediaFormat.getInteger("height");
    L8:
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) == false) goto L14;
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) == false) goto L14;
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_TOP) == false) goto L14;
        r101 = true;
        goto L15
    }

    public int getFormatWidth() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L21;
    L19:
        return 0;
    L21:
        if (r100.containsKey(KEY_CROP_RIGHT) == true) goto L8;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L18;
        return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
    L18:
        return this.mOutputMediaFormat.getInteger("width");
    L8:
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) == false) goto L14;
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) == false) goto L14;
        if (this.mOutputMediaFormat.containsKey(KEY_CROP_TOP) == false) goto L14;
        r101 = true;
        goto L15
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid == true) goto L5;
        return null;
    L5:
        return this.mInputBuffers;
    }

    public ByteBuffer[] getOutputBuffers() {
        if (this.mInputBuffersValid == true) goto L5;
        return null;
    L5:
        return this.mOutputBuffers;
    }

    public int getSampleRate() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getInteger(MediaFormat.KEY_SAMPLE_RATE);
    }

    public int getSliceHeight() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getInteger("slice-height");
    }

    public int getStride() {
        android.media.MediaFormat r100 = this.mOutputMediaFormat;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getInteger("stride");
    }

    public int isAdaptivePlayback() {
        int r100 = this.mSupportAdaptivePlayBack;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        this.mSupportAdaptivePlayBack = isAdaptivePlaybackV19() ? 1 : 0;
        if ("Q7-G1".equals(Build.MODEL) == false) goto L11;
        if ("kunlun".equals(Build.HARDWARE) == false) goto L11;
        "GK6323V100C".equals(Build.BOARD);
    L11:
        return this.mSupportAdaptivePlayBack;
    }

    public int stop() {
        if (this.mHandleStopAsync != 1) goto L7;
        AVLogger.Info(TAG, this, "stop async");
        this.mInputBuffersValid = false;
        this.mStopAsync = true;
        return 0;
    L7:
        if (this.mInputBuffersValid == false) goto L14;
        AVLogger.Info(TAG, this, "stop");
        this.mInputBuffersValid = false;     // Catch: Exception -> L11
        this.mMediaCodec.stop();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        AVLogger.Error(TAG, this, "stop failed, exception = " + e);
        handleCodecException(e);
        return -1;
    L14:
        return 0;
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals("OPPO") == true) goto L10;
    L8:
        return 1;
    L10:
        return CastIntegerProtector.parseInt(getProperty(VENDOR_OPPO_PROPERTY, "1"));
    L7:
        AVLogger.Warn(TAG, this, "vendor oppo property abnormal");
        goto L8
    }

    public AJMediaCodec() {
        boolean r100 = false;
        this.mInputBuffersValid = false;
        this.mOutputMediaFormat = null;
        this.mAJMediaFormat = new AJMediaFormat();
        this.mMcMode = 0;
        this.mHandler = 0;
        this.mPendingFlushCount = 0;
        this.mAsyncLock2 = new Object();
        this.mCodecIsClosed = false;
        this.mCodecInfo = null;
        this.mCodecType = null;
        this.mSupportAdaptivePlayBack = -1;
        this.mFixedMemcpyCrash = 0;
        this.mEnableSingleCodec = 0;
        this.mDowngradeSw = 0;
        this.mHandleOutputBuffersChanged = 0;
        this.mHandleStopAsync = 0;
        this.mStopAsync = false;
        this.mEnableBlockMode = 0;
        this.mEnableUseCodec2 = 0;
        this.mBlockHashMap = new ConcurrentHashMap();
        this.mMCOperatingRateMode = 0;
        this.mMCPriority = 0;
        this.mEnableMCVppLevel = 0;
        this.mMCVppLevel = 0;
        this.mEnableMCVppDebug = 0;
        this.mHisiFrequenceValue = -1;
        this.mEnableQcomOrder = 0;
        this.mEnableQcomSliceDelivery = 0;
        this.mEnableQcomTimestampReorder = 0;
        this.mEnableQcomCpuAffinityMask = 0;
        this.mQcomCpuAffinityMaskValue = 0;
        this.mEnableQcomEarlyNotify = 0;
        this.mQcomEarlyNotifyValue = 0;
        this.mEnableLowLatency = 0;
        this.mEnableHisiLowLatency = 0;
        this.mDecoderType = 0;
        this.mLowLatencyType = 0;
        this.mEnableSetVideoScalingMode = 0;
        this.mMCOperatingRateBeforeOpen = -1;
        this.mImportanceValue = -1;
        this.mDisableAllowFrameDrop = 0;
        this.mSpecifyMaxInputSize = -1;
        this.mEnableGetCodecInfosOpt = 0;
        this.mCreateCodecTimeoutMs = 0;
        this.mEnableCacheCodecAsync = false;
        if (mIsInitDetected == false) goto L5;
    L14:
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        AVLogger.InfoTrackLife(TAG, this, "JAJMediaCodec#^workaround:" + mDeviceNeedsSetOutputSurfaceWorkaround);
        return;
    L5:
        if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") == true) goto L7;
    L9:
        mNeedByteVC1WorkAround = r100;
        if (isHisiByteVC1BlockList() == false) goto L12;
    L13:
        mIsByteVC1Blocklist = true;
        goto L14
    L12:
        if (isMtkByteVC1BlockList() == false) goto L14;
    L7:
        if (Util.SDK_INT >= 26) goto L9;
        r100 = true;
        goto L9
    }

    private boolean isHisiByteVC1BlockList() {
        String r100 = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26) goto L17;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith("kirin960") == true) goto L19;
        if (r100.startsWith("hi3660") == true) goto L19;
        return false;
    L19:
        double r101 = CastDoubleProtector.parseDouble(getProperty(VERSION_PROPERTY, GLUtils.VERSION_UNKNOWN));     // Catch: NumberFormatException -> L12
    L14:
        if (r101 >= FIX_VERSION) goto L23;
        return true;
    L23:
        return false;
    L12:
        AVLogger.Warn(TAG, this, "vendor property abnormal");
        r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L14
    L17:
        return false;
    }

    public int start() {
        AVLogger.Info(TAG, this, "start");
        this.mMediaCodec.start();     // Catch: Exception -> L12
        if (this.mMcMode != 0) goto L8;
        this.mInputBuffers = this.mMediaCodec.getInputBuffers();     // Catch: Exception -> L12
        if (Util.SDK_INT < 21) goto L9;
        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();     // Catch: Exception -> L12
    L9:
        this.mInputBuffersValid = true;     // Catch: Exception -> L12
        this.mBufferInfo = new MediaCodec.BufferInfo();     // Catch: Exception -> L12
        AVLogger.Info(TAG, this, "start end");
        return 0;
    L8:
        this.mInputBuffers = null;     // Catch: Exception -> L12
        this.mOutputBuffers = null;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        AVLogger.Error(TAG, this, "start failed, exception = " + e);
        handleCodecException(e);
        return -1;
    }

    public static /* synthetic */ Object access$300() {
        return mAsyncLock;
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttm_player_AJMediaCodec_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ MediaCodec access$000(AJMediaCodec r100) {
        return r100.mMediaCodec;
    }

    public static /* synthetic */ int access$100(AJMediaCodec r100) {
        return r100.mMcMode;
    }

    public static /* synthetic */ String access$1000(AJMediaCodec r100) {
        return r100.mExceptionInfo;
    }

    public static /* synthetic */ void access$1200(long r100) {
        _onError(r100);
    }

    public static /* synthetic */ int access$1400(AJMediaCodec r100) {
        return r100.mEnableSetVideoScalingMode;
    }

    public static /* synthetic */ AJMediaFormat access$1500(AJMediaCodec r100) {
        return r100.mAJMediaFormat;
    }

    public static /* synthetic */ void access$1800(long r100) {
        _onClosed2(r100);
    }

    public static /* synthetic */ Object access$200(AJMediaCodec r100) {
        return r100.mAsyncLock2;
    }

    public static /* synthetic */ void access$2100(AJMediaCodec r100) {
        r100.onSetSurfaceCompleted();
    }

    public static /* synthetic */ boolean access$400(AJMediaCodec r100) {
        return r100.mCodecIsClosed;
    }

    public static /* synthetic */ long access$500(AJMediaCodec r100) {
        return r100.mHandler;
    }

    private static boolean codecNeedsFlushWorkaround(String r100) {
        int r101 = Util.SDK_INT;
        if (r101 < 18) goto L19;
        if (r101 != 18) goto L10;
        if ("OMX.SEC.avc.dec".equals(r100) == true) goto L19;
        if ("OMX.SEC.avc.dec.secure".equals(r100) == true) goto L19;
    L10:
        if (r101 == 19) goto L12;
    L18:
        return false;
    L12:
        if (Util.MODEL.startsWith("SM-G800") == false) goto L18;
        if ("OMX.Exynos.avc.dec".equals(r100) == true) goto L19;
        if ("OMX.Exynos.avc.dec.secure".equals(r100) == false) goto L18;
    L19:
        return true;
    }

    private Surface createDummySurface(boolean r100) {
        AVLogger.Info(TAG, this, "create dummy surface, optimize = " + r100);
        if (Util.SDK_INT < 29) goto L9;
        if (r100 == false) goto L9;
        Surface r101 = new Surface(new SurfaceControl.Builder().setName("mc_dummy_surface").setBufferSize(1, 1).build());     // Catch: Exception -> L7
        this.mDummySurfaceV29 = r101;     // Catch: Exception -> L7
        return r101;
    L7:
        e = move-exception;
        AVLogger.Warn(TAG, this, "create dummy surface exp = " + e);
        this.mDummySurfaceV29 = null;
    L9:
        DummySurface r102 = DummySurface.newInstanceV17(false);
        this.mDummySurface = r102;
        return r102;
    }

    private void onFlushCompleted(Runnable r100) {
        if (this.mMcMode != 2) goto L5;
        Object r101 = this.mAsyncLock2;
    L6:
        monitor-enter(r101);
    L34:
        th = move-exception;
        throw th;
    L8:
        if (this.mCodecIsClosed == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L34
        return;
    L11:
        int r102 = this.mPendingFlushCount - 1;     // Catch: Throwable -> L34
        this.mPendingFlushCount = r102;     // Catch: Throwable -> L34
        if (r102 <= 0) goto L15;
        monitor-exit(r101);     // Catch: Throwable -> L34
        return;
    L15:
        if (r102 >= 0) goto L19;
        monitor-exit(r101);     // Catch: Throwable -> L34
        return;
    L19:
        if (this.mMcMode != 2) goto L21;
        _clearBufferIndex2(this.mHandler);     // Catch: Throwable -> L34
    L38:
        r100.run();     // Catch: Exception -> L24 Throwable -> L34
    L32:
        monitor-exit(r101);     // Catch: Throwable -> L34
        return;
    L24:
        e = move-exception;
        if ((e instanceof IllegalStateException) == true) goto L28;
        AVLogger.Error(TAG, this, e.toString());     // Catch: Throwable -> L34
        goto L32
    L28:
        if (this.mMcMode != 2) goto L30;
        _onError2(this.mHandler, -10002, "onFlushCompleted exception");     // Catch: Throwable -> L34
        goto L32
    L30:
        _onError(this.mHandler);     // Catch: Throwable -> L34
        goto L32
    L21:
        _clearBufferIndex(this.mHandler);     // Catch: Throwable -> L34
        goto L38
    L5:
        r101 = mAsyncLock;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    private void releaseCodec(MediaCodec r100) {
        String r101 = "release dummy surface:";
        if (r100 != null) goto L50;
        return;
    L50:
        r100.release();     // Catch: Throwable -> L20 Exception -> L22
        Condition r102 = r101;
        if (this.mDummySurface == null) goto L10;
        StringBuilder r103 = new StringBuilder("release dummy surface:");
        DummySurface r104 = this.mDummySurface;
        r103.append(r104);
        AVLogger.Info(TAG, this, r103.toString());
        this.mDummySurface.release();
        this.mDummySurface = null;
        r102 = r104;
    L10:
        r101 = r102;
        if (this.mEnableSingleCodec == 1) goto L57;
    L19:
        releaseBlockHashMap();
        AVLogger.Info(TAG, this, "codec release end");
        return;
    L57:
        ReentrantLock r105 = mSingleCodecLock;     // Catch: Throwable -> L14 Exception -> L17
        r105.lock();     // Catch: Throwable -> L14 Exception -> L17
        mCodecInstanceNums--;     // Catch: Throwable -> L14 Exception -> L17
        r102 = mSingleCodecCond;     // Catch: Throwable -> L14 Exception -> L17
        r102.signal();     // Catch: Throwable -> L14 Exception -> L17
        ?? r106 = r102;
    L18:
        r105.unlock();
        r101 = r106;
        goto L19
    L17:
        r105 = mSingleCodecLock;
        r106 = r102;
    L14:
        th = move-exception;
        mSingleCodecLock.unlock();
        throw th;
    L20:
        th = move-exception;
        if (this.mDummySurface == null) goto L40;
        AVLogger.Info(TAG, this, r101 + this.mDummySurface);
        this.mDummySurface.release();
        this.mDummySurface = null;
    L40:
        if (this.mEnableSingleCodec == 1) goto L55;
    L48:
        releaseBlockHashMap();
        AVLogger.Info(TAG, this, "codec release end");
        throw th;
    L55:
        ReentrantLock r107 = mSingleCodecLock;     // Catch: Throwable -> L43 Exception -> L46
        r107.lock();     // Catch: Throwable -> L43 Exception -> L46
        mCodecInstanceNums--;     // Catch: Throwable -> L43 Exception -> L46
        mSingleCodecCond.signal();     // Catch: Throwable -> L43 Exception -> L46
    L47:
        r107.unlock();
        goto L48
    L46:
        r107 = mSingleCodecLock;
    L43:
        th = move-exception;
        mSingleCodecLock.unlock();
        throw th;
    L22:
        e = move-exception;
        AVLogger.Warn(TAG, this, "release failed, exception = " + e);     // Catch: Throwable -> L20
        Condition r108 = r101;
        if (this.mDummySurface == null) goto L27;
        StringBuilder r109 = new StringBuilder("release dummy surface:");
        DummySurface r110 = this.mDummySurface;
        r109.append(r110);
        AVLogger.Info(TAG, this, r109.toString());
        this.mDummySurface.release();
        this.mDummySurface = null;
        r108 = r110;
    L27:
        r101 = r108;
        if (this.mEnableSingleCodec != 1) goto L19;
        r105 = mSingleCodecLock;     // Catch: Throwable -> L31 Exception -> L34
        r105.lock();     // Catch: Throwable -> L31 Exception -> L34
        mCodecInstanceNums--;     // Catch: Throwable -> L31 Exception -> L34
        r108 = mSingleCodecCond;     // Catch: Throwable -> L31 Exception -> L34
        r108.signal();     // Catch: Throwable -> L31 Exception -> L34
        r106 = r108;
    L34:
        r105 = mSingleCodecLock;
        r106 = r108;
    L31:
        th = move-exception;
        mSingleCodecLock.unlock();
        throw th;
    }

    private void stopCodec(MediaCodec r100) {
        if (r100 != null) goto L11;
        return;
    L11:
        r100.stop();     // Catch: Exception -> L7
    L9:
        AVLogger.Info(TAG, this, "codec stop end");
        return;
    L7:
        e = move-exception;
        AVLogger.Warn(TAG, this, "stop failed, exception = " + e);
        goto L9
    }

    public int createByCodecName(String r110) {
        AVLogger.Info(TAG, this, "createByCodecName = " + r110);
    L34:
        e = move-exception;
        handleCodecException(e);
        AVLogger.Error(TAG, this, "createByCodecName failed, exception = " + e);
        return -1;
    L4:
        boolean r100 = true;
        if (this.mEnableSingleCodec == 1) goto L38;
        long r101 = this.mCreateCodecTimeoutMs;     // Catch: Exception -> L34
        if (mEnableMediaCodecSyncClose > 0) goto L29;
        r100 = false;
    L29:
        this.mMediaCodec = MediacodecBlockManager.createByCodecName(r110, r101, r100);     // Catch: Exception -> L34
    L31:
        if (this.mMediaCodec != null) goto L33;
        return -1;
    L33:
        return 0;
    L38:
        ReentrantLock r102 = mSingleCodecLock;     // Catch: Throwable -> L22
        r102.lock();     // Catch: Throwable -> L22
        if (mCodecInstanceNums <= 0) goto L10;
        mSingleCodecCond.await(3000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
    L10:
        if (mCodecInstanceNums <= 0) goto L14;
        AVLogger.Warn(TAG, this, "already create a media codec");     // Catch: Throwable -> L22
        r102.unlock();     // Catch: Exception -> L34
        return -1;
    L14:
        long r103 = this.mCreateCodecTimeoutMs;     // Catch: Throwable -> L22
        if (mEnableMediaCodecSyncClose <= 0) goto L17;
        boolean r104 = true;
    L18:
        MediaCodec r111 = MediacodecBlockManager.createByCodecName(r110, r103, r104);     // Catch: Throwable -> L22
        this.mMediaCodec = r111;     // Catch: Throwable -> L22
        if (r111 == null) goto L21;
        mCodecInstanceNums++;     // Catch: Throwable -> L22
    L21:
        r102.unlock();     // Catch: Exception -> L34
        goto L31
    L17:
        r104 = false;
    L22:
        th = move-exception;
        mSingleCodecLock.unlock();     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    }

    public void decodeFRC(int r100) {
        if (this.mMediaCodec != null) goto L5;
        return;
    L5:
        if (this.mInputBuffersValid == true) goto L7;
        return;
    L7:
        if (Util.SDK_INT < 23) goto L18;
        Bundle r101 = new Bundle();
        r101.putInt("vivo.video-dec.dynamic-frc", r100);
        this.mMediaCodec.setParameters(r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        return;
    }

    public int dequeueInputBuffer(long r100) {
        return this.mMediaCodec.dequeueInputBuffer(r100);
    L4:
        e = move-exception;
        AVLogger.Error(TAG, this, "dequeueInputBuffer failed, exception: " + e);
        return handleCodecException(e);
    }

    public String getBestCodecName(String r110) {
        String r100 = r110;
        if (Util.SDK_INT >= 16) goto L7;
        AVLogger.Error(TAG, this, "API < 16");
        return null;
    L7:
        if (TextUtils.isEmpty(r110) == false) goto L11;
        AVLogger.Error(TAG, this, "codecType is empty");
        return null;
    L11:
        if (r100.equals("video/hevc") == true) goto L13;
    L18:
        ArrayList r101 = new ArrayList();
        ArrayList<MediaCodecInfo> r102 = new ArrayList();
        Object r103 = mCodecListLock;
        monitor-enter(r103);
    L210:
        th = move-exception;
        throw th;
    L21:
        if (r100.startsWith("video/") == true) goto L23;
    L27:
        int r104 = 1;
        if (r100.startsWith("video/") == false) goto L35;
        if (this.mDowngradeSw != 1) goto L35;
        ArrayList<MediaCodecInfo> r105 = mVideoSWDecoderCodecs;     // Catch: Throwable -> L210
        if (r105.isEmpty() == true) goto L35;
        r102 = r105;
    L35:
        if (r100.startsWith("audio/") == false) goto L40;
        ArrayList<MediaCodecInfo> r106 = mAudioSWDecoderCodecs;     // Catch: Throwable -> L210
        if (r106.isEmpty() == true) goto L40;
        r102 = r106;
    L40:
        if (r102.isEmpty() == false) goto L46;
        boolean r107 = this.mEnableCacheCodecAsync;     // Catch: Throwable -> L210
        if (this.mEnableGetCodecInfosOpt <= 0) goto L44;
        boolean r108 = true;
    L45:
        ArrayList<MediaCodecInfo> r109 = MediacodecBlockManager.getCodecs(r107, r108);     // Catch: Throwable -> L210
    L47:
        if (r109 != null) goto L49;
    L207:
        monitor-exit(r103);     // Catch: Throwable -> L210
        return null;
    L49:
        if (r109.isEmpty() == true) goto L207;
        int r111 = r109.size();     // Catch: Throwable -> L210
        int r112 = 0;
    L52:
        if (r112 >= r111) goto L139;
        MediaCodecInfo r113 = r109.get(r112);     // Catch: Throwable -> L210
        String r114 = r113.getName();     // Catch: Throwable -> L210
        if (r113.isEncoder() == false) goto L57;
    L137:
        r112 = r112 + 1;     // Catch: Throwable -> L210
        r100 = r110;
        r104 = 1;
        goto L52
    L57:
        if (r114.startsWith("OMX.google") == true) goto L69;
        if (r114.startsWith("c2.android") == true) goto L69;
        if (r100.startsWith("audio/") == true) goto L137;
        if (r100.startsWith("video/") == true) goto L66;
    L73:
        String[] r115 = r113.getSupportedTypes();     // Catch: Throwable -> L210
        if (r115 == null) goto L137;
        int r116 = r115.length;     // Catch: Throwable -> L210
        int r117 = 0;
    L77:
        if (r117 >= r116) goto L137;
        String r118 = r115[r117];     // Catch: Throwable -> L210
        if (TextUtils.isEmpty(r118) == false) goto L82;
    L136:
        r117 = r117 + 1;     // Catch: Throwable -> L210
        r100 = r110;
        r104 = 1;
        goto L77
    L82:
        if (r102.isEmpty() == false) goto L92;
        if (r100.startsWith("video/") == false) goto L92;
        if (r118.startsWith("video/") == false) goto L92;
        if (this.mDowngradeSw != r104) goto L90;
        mVideoSWDecoderCodecs.add(r113);     // Catch: Throwable -> L210
        goto L92
    L90:
        mVideoHWDecoderCodecs.add(r113);     // Catch: Throwable -> L210
    L92:
        if (r102.isEmpty() == false) goto L99;
        if (r100.startsWith("audio/") == false) goto L99;
        if (r118.startsWith("audio/") == false) goto L99;
        mAudioSWDecoderCodecs.add(r113);     // Catch: Throwable -> L210
    L99:
        if (r118.equalsIgnoreCase(r100) == false) goto L136;
        if (r114.startsWith("OMX.") == true) goto L106;
        if (r114.startsWith("c2.") == false) goto L136;
    L106:
        if (r114.startsWith("OMX.pv") == true) goto L136;
        if (r114.startsWith("OMX.ittiam") == true) goto L136;
        if (r114.contains("ffmpeg") == true) goto L136;
        if (r114.contains("avcodec") == true) goto L136;
        if (r114.contains("secure") == true) goto L136;
        if (r114.startsWith("OMX.MTK.") == false) goto L122;
        if (Util.SDK_INT < 18) goto L136;
    L122:
        if (codecNeedsFlushWorkaround(r114) == true) goto L136;
        AJMediaCodecRank r119 = AJMediaCodecRank.setupRank(r113, r100, this.mEnableUseCodec2);     // Catch: Throwable -> L210
        if (r119 == null) goto L136;
        r119.mMediaCodecInfo.getName();     // Catch: Throwable -> L210
        int r120 = r119.mRank;     // Catch: Throwable -> L210
        if (r120 != 40) goto L133;
        if (Util.SDK_INT >= 21) goto L133;
        AVLogger.Warn(TAG, this, "skip vendor mediacodec api impl ambiguous");     // Catch: Throwable -> L210
    L133:
        if (r120 != 20) goto L135;
        AVLogger.Warn(TAG, this, "skip vendor software codec");     // Catch: Throwable -> L210
        goto L136
    L135:
        r101.add(r119);     // Catch: Throwable -> L210
        goto L136
    L66:
        if (this.mDowngradeSw != r104) goto L73;
    L69:
        if (r100.startsWith("video/") == false) goto L73;
        if (this.mDowngradeSw != 0) goto L73;
    L139:
        if (r101.isEmpty() == false) goto L143;
        monitor-exit(r103);     // Catch: Throwable -> L210
        return null;
    L143:
        AJMediaCodecRank r121 = (AJMediaCodecRank) r101.get(0);     // Catch: Throwable -> L210
        AVLogger.InfoTrackLife(TAG, this, "decoderType:" + this.mDecoderType + ", lowLatencyType:" + this.mLowLatencyType);     // Catch: Throwable -> L210
        Iterator r122 = r101.iterator();     // Catch: Throwable -> L210
        AJMediaCodecRank r123 = null;
    L145:
        if (r122.hasNext() == false) goto L202;
        AJMediaCodecRank r124 = (AJMediaCodecRank) r122.next();     // Catch: Throwable -> L210
        int r125 = this.mDecoderType;     // Catch: Throwable -> L210
        if (r125 <= 0) goto L149;
    L152:
        int r126 = -1;
        if (r125 <= 0) goto L155;
        int r127 = -1;
    L157:
        if (this.mLowLatencyType > 0) goto L160;
        r126 = 0;
    L160:
        String r128 = r124.mMediaCodecInfo.getName().toLowerCase(Locale.US);     // Catch: Throwable -> L210
        int r129 = this.mDecoderType;     // Catch: Throwable -> L210
        if (r129 == 1) goto L168;
        if (r129 == 2) goto L165;
    L170:
        int r130 = this.mLowLatencyType;     // Catch: Throwable -> L210
        if (r130 == 1) goto L185;
        if (r130 == 2) goto L182;
        if (r130 == 3) goto L177;
    L187:
        AVLogger.InfoTrackLife(TAG, this, "name:" + r128 + ", decoderTypeMatch:" + r127 + ", lowLatencyMatch:" + r126);     // Catch: Throwable -> L210
        if (r127 > 0) goto L190;
        if (r126 > 0) goto L190;
    L200:
        if (r124.mRank <= r121.mRank) goto L145;
        r121 = r124;
    L190:
        if (r123 == null) goto L197;
        if (r127 <= 0) goto L195;
        if (r126 > 0) goto L197;
    L195:
        if (r124.mRank <= r123.mRank) goto L198;
        AVLogger.InfoTrackLife(TAG, this, "update specify codec name:" + r128 + ", rank:" + r124.mRank + ", specify codec:" + r124.mMediaCodecInfo.getName());     // Catch: Throwable -> L210
    L198:
        AVLogger.InfoTrackLife(TAG, this, "find specify codec:" + r123.mMediaCodecInfo.getName());     // Catch: Throwable -> L210
    L197:
        r123 = r124;
        goto L198
    L177:
        if (MediaCodecHelper.decoderSupportsAndroidRLowLatency(r124.mMediaCodecInfo, r124.mCodecType) == false) goto L179;
    L186:
        r126 = 1;
        goto L187
    L179:
        if (r128.endsWith("low_latency") == false) goto L187;
    L182:
        if (MediaCodecHelper.decoderSupportsAndroidRLowLatency(r124.mMediaCodecInfo, r124.mCodecType) == false) goto L187;
    L185:
        if (r128.endsWith("low_latency") == false) goto L187;
    L165:
        if (r128.startsWith("c2") == false) goto L170;
    L169:
        r127 = 1;
        goto L170
    L168:
        if (r128.startsWith("omx") == false) goto L170;
    L155:
        r127 = 0;
        goto L157
    L149:
        if (this.mLowLatencyType <= 0) goto L200;
    L202:
        if (r123 == null) goto L204;
        AVLogger.InfoTrackLife(TAG, this, "use specify codec:" + r123.mMediaCodecInfo.getName());     // Catch: Throwable -> L210
        r121 = r123;
    L204:
        MediaCodecInfo r131 = r121.mMediaCodecInfo;     // Catch: Throwable -> L210
        this.mCodecInfo = r131;     // Catch: Throwable -> L210
        this.mCodecType = r121.mCodecType;     // Catch: Throwable -> L210
        String r132 = r131.getName();     // Catch: Throwable -> L210
        monitor-exit(r103);     // Catch: Throwable -> L210
        return r132;
    L44:
        r108 = false;
        goto L45
    L46:
        r109 = r102;
        goto L47
    L23:
        if (this.mDowngradeSw != 0) goto L27;
        ArrayList<MediaCodecInfo> r133 = mVideoHWDecoderCodecs;     // Catch: Throwable -> L210
        if (r133.isEmpty() == true) goto L27;
        r102 = r133;
        goto L27
    L13:
        if (mIsByteVC1Blocklist == false) goto L18;
        if (mIsByteVC1BlocklistEnable <= 0) goto L18;
        AVLogger.Warn(TAG, this, "the device is hw decoder blocklist," + Util.HARDWARE);
        return null;
    }

    public ByteBuffer getInputBuffer(int r100) {
        if (this.mInputBuffersValid == true) goto L9;
    L8:
        return null;
    L9:
        return this.mMediaCodec.getInputBuffer(r100);
    L6:
        e = move-exception;
        AVLogger.Error(TAG, this, "getInputBuffer failed, exception = " + e);
        goto L8
    }

    public ByteBuffer getInputBufferByQueueRequest(int r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        if (this.mBlockHashMap.get(Integer.valueOf(r100)) != null) goto L7;
    L10:
        MediaCodec.LinearBlock r101 = MediaCodec.LinearBlock.obtain(1048576, new String[]{this.mMediaCodec.getName()});
        this.mBlockHashMap.put(Integer.valueOf(r100), r101);
        return r101.map();
    L7:
        if (this.mBlockHashMap.get(Integer.valueOf(r100)).isMappable() == false) goto L10;
        return this.mBlockHashMap.get(Integer.valueOf(r100)).map();
    }

    public int handleCodecException(Exception r100) {
        this.mExceptionInfo = r100.toString();
        if (Util.SDK_INT < 21) goto L7;
        return handleCodecExceptionV21(r100);
    L7:
        if ((r100 instanceof IllegalStateException) == false) goto L10;
        return -10002;
    L10:
        return -10000;
    }

    public int handleCodecExceptionV21(Exception r100) {
        if ((r100 instanceof MediaCodec.CodecException) == false) goto L17;
        MediaCodec.CodecException r101 = (MediaCodec.CodecException) r100;
        if (Util.SDK_INT < 23) goto L13;
        r101.isRecoverable();
        r101.getErrorCode();
        if (r101.isRecoverable() == true) goto L17;
        if (r101.getErrorCode() == 1100) goto L17;
        if (r101.getErrorCode() == 1101) goto L17;
        return -10001;
    L13:
        r101.isRecoverable();
        if (r101.isRecoverable() == true) goto L17;
        return -10001;
    L17:
        if ((r100 instanceof IllegalStateException) == false) goto L20;
        return -10002;
    L20:
        return -10000;
    }

    public void hisiFrenquenceChange(int r100) {
        if (this.mMediaCodec != null) goto L5;
        return;
    L5:
        if (this.mInputBuffersValid == true) goto L7;
        return;
    L7:
        if (Util.SDK_INT < 23) goto L18;
        Bundle r101 = new Bundle();
        r101.putInt("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", r100);
        this.mMediaCodec.setParameters(r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        return;
    }

    public void importanceChange(int r100) {
        if (this.mMediaCodec != null) goto L5;
        return;
    L5:
        if (this.mInputBuffersValid == true) goto L7;
        return;
    L7:
        if (Util.SDK_INT < 35) goto L18;
        Bundle r101 = new Bundle();
        r101.putInt("importance", r100);
        this.mMediaCodec.setParameters(r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        return;
    }

    public void setBlockMode(int r100) {
        this.mEnableBlockMode = r100;
    }

    public int setCallback(int r100) {
        if (r100 == 0) goto L16;
        MediaCodec.Callback r101 = new AnonymousClass1(this);     // Catch: Exception -> L11
        if (Util.SDK_INT >= 23) goto L7;
        this.mMediaCodec.setCallback(r101);     // Catch: Exception -> L11
        this.mAsyncHandler = new Handler(Looper.getMainLooper());     // Catch: Exception -> L11
    L8:
        return 0;
    L7:
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("mc_async");     // Catch: Exception -> L11
        this.mAsyncThread = r102;     // Catch: Exception -> L11
        ThreadMethodProxy.start(r102);     // Catch: Exception -> L11
        Handler r103 = new Handler(this.mAsyncThread.getLooper());     // Catch: Exception -> L11
        this.mAsyncHandler = r103;     // Catch: Exception -> L11
        this.mMediaCodec.setCallback(r101, r103);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        AVLogger.Error(TAG, this, "failed to set callback, exception = " + e);
        return -1;
    L16:
        return 0;
    }

    public void setCreateCodecTimeoutMs(int r100) {
        this.mCreateCodecTimeoutMs = r100;
    }

    public void setDowngradeSw(int r100) {
        this.mDowngradeSw = r100;
    }

    public void setEnableCacheCodecAsync(int r100) {
        if (r100 == 0) goto L4;
        boolean r101 = true;
    L5:
        this.mEnableCacheCodecAsync = r101;
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void setEnableMediaCodecSyncClose(int r100) {
        mEnableMediaCodecSyncClose = r100;
    }

    public void setEnableVC1BlockList(int r100) {
        mIsByteVC1BlocklistEnable = r100;
    }

    public void setHandleOutputBuffersChanged(int r100) {
        this.mHandleOutputBuffersChanged = r100;
    }

    public void setHandleStopAsync(int r100) {
        this.mHandleStopAsync = r100;
    }

    public void setHandler(long r100) {
        this.mHandler = r100;
    }

    public int setOutputSurface(Surface r100) {
        AVLogger.Info(TAG, this, "setOutputSurface surface = " + r100);
        if (mDeviceNeedsSetOutputSurfaceWorkaround == false) goto L5;
    L16:
        return -1;
    L5:
        if (this.mInputBuffersValid == false) goto L16;
        if (r100 != null) goto L12;
        if (this.mDummySurface != null) goto L10;
        createDummySurface(false);
    L10:
        AVLogger.Info(TAG, this, "use dummy surface = " + this.mDummySurface);
        r100 = this.mDummySurface;
    L12:
        if (Util.SDK_INT >= 23) goto L15;
        return -1;
    L15:
        return setOutputSurfaceV23(this.mMediaCodec, r100);
    }

    public void setSingleCodec(int r100) {
        this.mEnableSingleCodec = r100;
    }

    public void setUseCodec2(int r100) {
        this.mEnableUseCodec2 = r100;
    }

    public void speedEnhance(float r100) {
        if (this.mMediaCodec != null) goto L5;
        return;
    L5:
        if (this.mInputBuffersValid == true) goto L7;
        return;
    L7:
        if (Util.SDK_INT >= 23) goto L9;
        return;
    L9:
        if (r100 <= 30.0f) goto L11;
    L14:
        Bundle r101 = new Bundle();
        r101.putFloat("operating-rate", r100);
        this.mMediaCodec.setParameters(r101);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
        return;
    L11:
        if (this.mMCOperatingRateMode == 1) goto L13;
        return;
    L13:
        if (r100 >= 0.0f) goto L14;
    }

    public int write(AJMediaCodecFrame r110) {
        if (r110 != null) goto L5;
    L18:
        return -1;
    L5:
        if (r110.data == null) goto L18;
        int r100 = this.mMediaCodec.dequeueInputBuffer(30000);     // Catch: Exception -> L16
        if (r100 < 0) goto L12;
        this.mInputBuffers[r100].put(r110.data);     // Catch: Exception -> L16
        this.mMediaCodec.queueInputBuffer(r100, 0, r110.size, r110.pts, 0);     // Catch: Exception -> L16
        return 0;
    L12:
        if (r100 != (-1)) goto L15;
        return 4;
    L15:
        return -1;
    L16:
        e = move-exception;
        AVLogger.Error(TAG, this, "write meet exception =" + e);
        goto L18
    }

    public static /* synthetic */ android.media.MediaFormat access$1302(AJMediaCodec r100, android.media.MediaFormat r101) {
        r100.mOutputMediaFormat = r101;
        return r101;
    }

    public static /* synthetic */ void access$1900(AJMediaCodec r100, MediaCodec r101) {
        r100.releaseCodec(r101);
    }

    public static /* synthetic */ void access$2000(AJMediaCodec r100, Runnable r101) {
        r100.onFlushCompleted(r101);
    }

    public static /* synthetic */ void access$600(long r100, int r101) {
        _onEmptyBuffer2(r100, r101);
    }

    public static /* synthetic */ void access$700(long r100, int r101) {
        _onEmptyBuffer(r100, r101);
    }

    public static int ceilDivide(int r100, int r101) {
        return ((r100 + r101) - 1) / r101;
    }

    public static String getProperty(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_ss_ttm_player_AJMediaCodec_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4 Throwable -> L7
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});
    L4:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
    L6:
        return r101;
    }

    private int renderOutputBufferV21(int r100, long r101) {
        this.mMediaCodec.releaseOutputBuffer(r100, r101);     // Catch: Exception -> L5
        return 0;
    L5:
        e = move-exception;
        AVLogger.Error(TAG, this, "releaseOutputBufferV21 failed, exception = " + e);
        return handleCodecException(e);
    }

    private int setOutputSurfaceV23(MediaCodec r100, Surface r101) {
        int r102 = 2;
        r100.setOutputSurface(r101);     // Catch: Exception -> L22
        if (this.mMcMode != 1) goto L16;
        if (this.mFixedMemcpyCrash != 1) goto L16;
        Object r103 = mAsyncLock;     // Catch: Exception -> L22
        monitor-enter(r103);     // Catch: Exception -> L22
        this.mAsyncHandler.post(new AnonymousClass6(this));     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L22
    L16:
        if (this.mMcMode == 2) goto L18;
        return 0;
    L18:
        if (this.mFixedMemcpyCrash != 1) goto L38;
        this.mAsyncHandler.post(new AnonymousClass7(this));     // Catch: Exception -> L22
        return 0;
    L38:
        return 0;
    L22:
        e = move-exception;
        AVLogger.Error(TAG, this, "setOutputSurface failed, exception = " + e);
        handleCodecException(e);
        DummySurface r104 = this.mDummySurface;
        if (r104 == null) goto L29;
        if (r101 != r104) goto L27;
        r102 = 1;
    L27:
        r104.addEvent(r102);
    L29:
        if ((e instanceof IllegalArgumentException) == false) goto L32;
        return -10003;
    L32:
        return -1;
    }

    public int read(AJMediaCodecFrame r100, long r101) {
    L44:
        int r102 = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, r101);     // Catch: Exception -> L41
        if (r102 >= 0) goto L5;
        if (r102 != (-3)) goto L20;
        if (this.mEnableSetVideoScalingMode <= 0) goto L12;
        this.mMediaCodec.setVideoScalingMode(2);     // Catch: Exception -> L16
    L12:
        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();     // Catch: Exception -> L16
        if (this.mHandleOutputBuffersChanged != 1) goto L44;
        return -3;
    L16:
        e = move-exception;
        AVLogger.Error(TAG, this, "getOutputBuffers failed, exception = " + e);
        return handleCodecException(e);
    L20:
        if (r102 != (-2)) goto L37;
    L33:
        e = move-exception;
        AVLogger.Error(TAG, this, "getOutputFormat failed, exception =" + e);
        return handleCodecException(e);
    L22:
        if (this.mEnableSetVideoScalingMode <= 0) goto L24;
        this.mMediaCodec.setVideoScalingMode(2);     // Catch: Exception -> L33
    L24:
        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();     // Catch: Exception -> L33
        AVLogger.Info(TAG, this, "getOutputFormat = " + this.mOutputMediaFormat);     // Catch: Exception -> L33
        if (this.mOutputBuffers == null) goto L46;
    L32:
        return r102;
    L46:
        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        AVLogger.Error(TAG, this, "getOutputBuffers failed, exception = " + e);
        return handleCodecException(e);
    L37:
        if (r102 == (-1)) goto L40;
        AVLogger.Error(TAG, this, "error, idx = " + r102);
    L40:
        return -1;
    L5:
        r100.data = this.mOutputBuffers[r102];
        MediaCodec.BufferInfo r103 = this.mBufferInfo;
        r100.pts = r103.presentationTimeUs;
        r100.index = r102;
        r100.size = r103.size;
        r100.flags = r103.flags;
        return 0;
    L41:
        e = move-exception;
        AVLogger.Error(TAG, this, "dequeueOutputBuffer failed, exception = " + e);
        return handleCodecException(e);
    }

    public void setIntOption(int r100, int r101) {
        switch(r100) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L50;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L8;
            case 21: goto L7;
            case 22: goto L6;
            case 23: goto L5;
            case 24: goto L4;
            default: goto L50;
        };
    L4:
        this.mEnableGetCodecInfosOpt = r101;
        return;
    L5:
        this.mSpecifyMaxInputSize = r101;
        return;
    L6:
        this.mDisableAllowFrameDrop = r101;
        return;
    L7:
        this.mImportanceValue = r101;
        return;
    L8:
        this.mMCOperatingRateBeforeOpen = r101;
        return;
    L9:
        this.mEnableSetVideoScalingMode = r101;
        return;
    L10:
        this.mLowLatencyType = r101;
        return;
    L11:
        this.mDecoderType = r101;
        return;
    L12:
        this.mEnableHisiLowLatency = r101;
        return;
    L13:
        this.mEnableLowLatency = r101;
        return;
    L14:
        this.mQcomEarlyNotifyValue = r101;
        return;
    L15:
        this.mEnableQcomEarlyNotify = r101;
        return;
    L16:
        this.mQcomCpuAffinityMaskValue = r101;
        return;
    L17:
        this.mEnableQcomCpuAffinityMask = r101;
        return;
    L18:
        this.mEnableQcomTimestampReorder = r101;
        return;
    L19:
        this.mEnableQcomSliceDelivery = r101;
        return;
    L20:
        this.mEnableQcomOrder = r101;
        return;
    L21:
        this.mHisiFrequenceValue = r101;
        return;
    L22:
        this.mEnableMCVppDebug = r101;
        return;
    L23:
        this.mMCVppLevel = r101;
        return;
    L24:
        this.mEnableMCVppLevel = r101;
        return;
    L25:
        this.mMCPriority = r101;
        return;
    L26:
        this.mMCOperatingRateMode = r101;
        return;
    }

    public void setMode(int r100, int r101) {
        this.mMcMode = r100;
        this.mFixedMemcpyCrash = r101;
    }

    public static /* synthetic */ void access$1100(long r100, int r101, String r102) {
        _onError2(r100, r101, r102);
    }

    private static int getMaxInputSize(String r100, int r101, int r102) {
        if (r101 == (-1)) goto L31;
        if (r102 == (-1)) goto L31;
        if (r100.equals("video/3gpp") == false) goto L9;
    L27:
        int r103 = r101 * r102;
    L28:
        int r104 = 2;
    L30:
        return (r103 * 3) / (r104 * 2);
    L9:
        if (r100.equals("video/mp4v-es") == true) goto L27;
        if (r100.equals(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE) == false) goto L18;
        if ("BRAVIA 4K 2015".equals(Util.MODEL) == false) goto L16;
        return -1;
    L16:
        r103 = ((ceilDivide(r101, 16) * ceilDivide(r102, 16)) * 16) * 16;
        goto L28
    L18:
        if (r100.equals("video/x-vnd.on2.vp8") == true) goto L27;
        if (r100.equals("video/hevc") == false) goto L23;
    L26:
        r103 = r101 * r102;
        r104 = 4;
        goto L30
    L23:
        if (r100.equals("video/x-vnd.on2.vp9") == true) goto L26;
        return -1;
    L31:
        return -1;
    }

    private static void maybeSetCsdBuffers(AJMediaFormat r100, ByteBuffer r101, int r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        r100.setByteBuffer("csd-" + r102, r101);
    }

    private static void maybeSetInteger(AJMediaFormat r100, String r101, int r102) {
        if (r102 == (-1)) goto L6;
        r100.setInteger(r101, r102);
        return;
    }

    public int releaseBuffer(int r100, boolean r101, long r102, boolean r103) {
        if (r101 == false) goto L9;
        if (this.mEnableSetVideoScalingMode <= 0) goto L9;
        if (r103 == false) goto L7;
        this.mMediaCodec.setVideoScalingMode(2);
        goto L9
    L7:
        this.mMediaCodec.setVideoScalingMode(1);
    L9:
        if (Util.SDK_INT < 21) goto L19;
        if (r101 == false) goto L19;
        return renderOutputBufferV21(r100, r102);
    L19:
        this.mMediaCodec.releaseOutputBuffer(r100, r101);     // Catch: Exception -> L16
        return 0;
    L16:
        e = move-exception;
        AVLogger.Error(TAG, this, "releaseOutputBuffer failed, exception = " + e);
        return handleCodecException(e);
    }

    public int queueInputBuffer(int r100, int r101, int r110, long r111, int r112) {
        this.mMediaCodec.queueInputBuffer(r100, r101, r110, r111, r112);     // Catch: Exception -> L5
        return 0;
    L5:
        e = move-exception;
        AVLogger.Error(TAG, this, "queueInputBuffer failed, exception = " + e);
        return handleCodecException(e);
    }

    public int queueInputBufferByQueueRequest(int r100, int r101, int r102, long r103, int r104) {
    L11:
        e = move-exception;
        AVLogger.Error(TAG, this, "queueInputBuffer failed, exception: " + e);
        return handleCodecException(e);
    L3:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        MediaCodec.QueueRequest r105 = this.mMediaCodec.getQueueRequest(r100);     // Catch: Exception -> L11
        ConcurrentHashMap<Integer, MediaCodec.LinearBlock> r106 = this.mBlockHashMap;     // Catch: Exception -> L11
        if (r106 == null) goto L9;
        MediaCodec.LinearBlock r107 = r106.get(Integer.valueOf(r100));     // Catch: Exception -> L11
        if (r107 == null) goto L9;
        r105.setLinearBlock(r107, 0, r102);     // Catch: Exception -> L11
    L9:
        r105.setFlags(r104);     // Catch: Exception -> L11
        r105.setPresentationTimeUs(r103);     // Catch: Exception -> L11
        r105.queue();     // Catch: Exception -> L11
    L10:
        return 0;
    }

    public static /* synthetic */ void access$800(long r100, int r101, int r102, int r103, long r104, int r105) {
        _onFilledBuffer2(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void access$900(long r100, int r101, int r102, int r103, long r104, int r105) {
        _onFilledBuffer(r100, r101, r102, r103, r104, r105);
    }

    public int getOutputFrameByQueueRequest(int r110, int r111, int r112, int r113, RenderTrait r114, int r115, long r116) {
        if (Build.VERSION.SDK_INT < 30) goto L8;
        if (r114 == null) goto L6;
    L7:
        HardwareBuffer r100 = this.mMediaCodec.getOutputFrame(r110).getHardwareBuffer();
    L10:
        if (r100 == null) goto L29;
        android.media.MediaFormat r101 = this.mOutputMediaFormat;
        int r102 = -1;
        if (r101 == null) goto L14;
        int r103 = r101.getInteger("color-standard");
    L16:
        if (r115 != 1) goto L25;
        android.media.MediaFormat r104 = this.mOutputMediaFormat;
        if (r104 == null) goto L20;
        r102 = r104.getInteger("color-range");
        int r105 = this.mOutputMediaFormat.getInteger("color-transfer");
    L21:
        if (r103 <= 0) goto L25;
        if (r102 <= 0) goto L25;
        if (r105 <= 0) goto L25;
        r103 = ((r103 << 16) | (r105 << 22)) | (r102 << 27);
        goto L25
    L20:
        r105 = -1;
    L25:
        AJMediaFormat r106 = this.mAJMediaFormat;
        AJCodecHardwareBuffer r107 = new AJCodecHardwareBuffer(r100, new int[]{0, 0, r106.width, r106.height}, 0, r103);
        if (r114 == null) goto L28;
        r114.onDrawFrame(r107);
        goto L29
    L28:
        _onDrawFrame(r116, r107.hardwareBuffer, r107.roi, r107.rotation, r107.colorSpace);
        goto L29
    L14:
        r103 = -1;
    L29:
        return 0;
    L6:
        if (r116 != 0) goto L7;
    L8:
        r100 = null;
        goto L10
    }

    private int setExtOptions(AJMediaFormat r100, boolean r101, int r102, boolean r103, boolean r110, int r111, int r112, int r113, String r114) {
        if (this.mMCOperatingRateMode != 2) goto L5;
        MediaCodecHelper.setMaxOperatingRate(r100);
    L8:
        MediaCodecHelper.setPriority(r100, this.mMCPriority);
        if (this.mEnableMCVppLevel <= 0) goto L12;
        MediaCodecHelper.setupVpp(r100, this.mMCVppLevel, this.mCodecInfo.getName());
    L12:
        if (this.mEnableMCVppDebug <= 0) goto L14;
        MediaCodecHelper.debugEffect(r100, this.mCodecInfo.getName());
    L14:
        int r104 = this.mHisiFrequenceValue;
        if (r104 < 0) goto L18;
        MediaCodecHelper.setHisiFrequence(r100, r104, this.mCodecInfo.getName());
    L18:
        if (this.mEnableQcomOrder <= 0) goto L21;
        MediaCodecHelper.setQcomOrder(r100, this.mCodecInfo.getName());
    L21:
        if (this.mEnableQcomSliceDelivery <= 0) goto L24;
        MediaCodecHelper.setQcomSliceDeliveryMode(r100, this.mCodecInfo.getName());
    L24:
        if (this.mEnableQcomTimestampReorder <= 0) goto L27;
        MediaCodecHelper.setQcomTimestampReorder(r100, this.mCodecInfo.getName());
    L27:
        if (this.mEnableQcomCpuAffinityMask <= 0) goto L30;
        MediaCodecHelper.setQcomCpuAffinityMask(r100, this.mQcomCpuAffinityMaskValue, this.mCodecInfo.getName());
    L30:
        if (this.mEnableQcomEarlyNotify <= 0) goto L32;
        MediaCodecHelper.setQcomEarlyNotifyValue(r100, this.mQcomEarlyNotifyValue, this.mCodecInfo.getName());
    L32:
        int r105 = this.mEnableLowLatency;
        if (r105 <= 0) goto L36;
        MediaCodecHelper.setLowLatency(r100, this.mCodecInfo, r105);
    L36:
        if (this.mEnableHisiLowLatency <= 0) goto L38;
        MediaCodecHelper.setHisiLowLatency(r100, this.mCodecInfo.getName());
    L38:
        int r106 = this.mImportanceValue;
        if (r106 < 0) goto L42;
        MediaCodecHelper.setImportance(r100, r106);
    L42:
        if (this.mDisableAllowFrameDrop <= 0) goto L44;
        MediaCodecHelper.disableAllowFrameDrop(r100);
    L44:
        if (r101 == false) goto L46;
        VendorQTI.setupVpp(r100, r102);
    L46:
        if (r103 == false) goto L48;
        VendorQTI.debugEffect(r100);
    L48:
        if (r110 == false) goto L51;
        VendorQTI.enableLowLatency(r100);
    L51:
        if (r113 <= 0) goto L56;
        if (isLowLatencyDecode() <= 0) goto L56;
        maybeSetInteger(r100, "low-latency", 1);
    L56:
        if (r112 <= 0) goto L66;
        if (r111 < 0) goto L66;
        String r107 = MediaCodecUtil.getDolbyCodecs(r111, r112);
        if (r107 == null) goto L61;
        String[] r115 = r107.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L62:
        Pair<Integer, Integer> r108 = MediaCodecUtil.getDolbyVisionProfileAndLevel(r107, r115);
        if (r108 == null) goto L66;
        AVLogger.Info(TAG, this, "dv profile & level  = " + r108.toString());
        maybeSetInteger(r100, "profile", ((Integer) r108.first).intValue());
        goto L66
    L61:
        r115 = null;
    L66:
        if (TextUtils.isEmpty(r114) == true) goto L80;
        String[] r109 = r114.split(",");     // Catch: Exception -> L77
        int r116 = r109.length;     // Catch: Exception -> L77
        int r117 = 0;
    L68:
        if (r117 >= r116) goto L80;
        String r118 = r109[r117];     // Catch: Exception -> L77
        String[] r119 = r118.split("_");     // Catch: Exception -> L77
        if (r119.length == 2) goto L81;
        AVLogger.Warn(TAG, this, "unsupported ext config = " + r118);     // Catch: Exception -> L77
    L76:
        r117 = r117 + 1;
        goto L68
    L81:
        maybeSetInteger(r100, r119[0], CastIntegerProtector.parseInt(r119[1]));     // Catch: Exception -> L73
        AVLogger.Info(TAG, this, "ext config " + r119[0] + " = " + r119[1]);     // Catch: Exception -> L73
    L73:
        e = move-exception;
        AVLogger.Warn(TAG, this, "set ext config = " + r118 + " exp = " + e);     // Catch: Exception -> L77
    L77:
        e = move-exception;
        AVLogger.Warn(TAG, this, "parse ext config = " + r114 + " exp = " + e);
    L80:
        return r100.getMap().size();
    L5:
        int r120 = this.mMCOperatingRateBeforeOpen;
        if (r120 < 0) goto L8;
        MediaCodecHelper.setOperatingRateBeforeOpen(r100, r120);
        goto L8
    }

    public static /* synthetic */ void access$1600(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110) {
        _onFormatChanged2(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    public static /* synthetic */ void access$1700(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110) {
        _onFormatChanged(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    public int configure(int r110, int r111, int r112, int r113, int r210, String r211, ByteBuffer r212, ByteBuffer r213, ByteBuffer r214, Surface r215, boolean r216, boolean r217, int r218, int r219, boolean r310, int r311, boolean r312, boolean r313, int r314, int r315, int r316, String r317) {
        Surface r100 = r215;
        int r101 = r218;
        int r102 = r219;
        AVLogger.Info(TAG, this, "configure surface = " + r100 + ", surfaceConfigure = " + r216);
        int r103 = Util.SDK_INT;
        if (r103 >= 21) goto L5;
    L7:
        AJMediaFormat r114 = new AJMediaFormat();
        r114.setString("mime", r211);
        maybeSetInteger(r114, "width", r110);
        maybeSetInteger(r114, "height", r111);
        if (r101 == (-1)) goto L18;
        if (r102 == (-1)) goto L18;
        if (r101 > r110) goto L13;
        r101 = r110;
    L13:
        maybeSetInteger(r114, GXTemplateKey.FLEXBOX_MAX_WIDTH, r101);
        if (r102 > r111) goto L17;
        r102 = r111;
    L17:
        maybeSetInteger(r114, GXTemplateKey.FLEXBOX_MAX_HEIGHT, r102);
    L18:
        maybeSetInteger(r114, MediaFormat.KEY_SAMPLE_RATE, r113);
        maybeSetInteger(r114, MediaFormat.KEY_CHANNEL_COUNT, r210);
        int r104 = this.mSpecifyMaxInputSize;
        if (r104 >= 0) goto L22;
        r104 = getMaxInputSize(r211, r110, r111);
    L22:
        maybeSetInteger(r114, "max-input-size", r104);
        maybeSetCsdBuffers(r114, r212, 0);
        maybeSetCsdBuffers(r114, r213, 1);
        maybeSetCsdBuffers(r114, r214, 2);
        if (r216 == false) goto L41;
        if (r103 < 21) goto L26;
        maybeSetInteger(r114, "rotation-degrees", r112);
    L26:
        if (r100 == null) goto L30;
        if (r215.isValid() == false) goto L30;
    L37:
        if (r100 != null) goto L41;
        this.mExceptionInfo = "Error: configure with null surface";
        AVLogger.Error(TAG, this, "Error: configure with null surface");
        return -10003;
    L30:
        if (r103 < 23) goto L37;
        if (mDeviceNeedsSetOutputSurfaceWorkaround == true) goto L37;
        if (this.mDummySurface != null) goto L36;
        createDummySurface(false);
    L36:
        AVLogger.Info(TAG, this, "use dummy surface = " + this.mDummySurface);
        r100 = this.mDummySurface;
    L41:
        if (this.mCodecInfo != null) goto L43;
    L66:
        this.mCodecInfo = this.mMediaCodec.getCodecInfo();     // Catch: Exception -> L63
        this.mCodecType = r211;     // Catch: Exception -> L63
    L45:
        setExtOptions(r114, r310, r311, r312, r313, r314, r315, r316, r317);
        AVLogger.Info(TAG, this, "format = " + r114.getMediaFormat());
    L58:
        e = move-exception;
        handleCodecException(e);
        AVLogger.Error(TAG, this, "configure failed, codec = " + this.mMediaCodec + ", exception = " + e);
        if ((e instanceof IllegalArgumentException) == false) goto L62;
        return -10003;
    L62:
        return -1;
    L47:
        if (Util.SDK_INT < 30) goto L53;
        AVLogger.Info(TAG, this, "block mode = " + this.mEnableBlockMode);     // Catch: Exception -> L58
        MediaCodec r105 = this.mMediaCodec;     // Catch: Exception -> L58
        android.media.MediaFormat r106 = r114.getMediaFormat();     // Catch: Exception -> L58
        if (this.mEnableBlockMode != 1) goto L51;
        int r107 = 2;
    L52:
        r105.configure(r106, r100, null, r107);     // Catch: Exception -> L58
    L55:
        if (this.mEnableSetVideoScalingMode <= 0) goto L57;
        this.mMediaCodec.setVideoScalingMode(2);     // Catch: Exception -> L58
    L57:
        return 0;
    L51:
        r107 = 0;
        goto L52
    L53:
        this.mMediaCodec.configure(r114.getMediaFormat(), r100, null, 0);     // Catch: Exception -> L58
        goto L55
    L43:
        if (TextUtils.isEmpty(this.mCodecType) == false) goto L45;
    L5:
        if (setCallback(this.mMcMode) != (-1)) goto L7;
        return -1;
    }
}
