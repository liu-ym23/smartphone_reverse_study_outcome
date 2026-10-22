package com.lynx.canvas.recorder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.b;
import f06.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonDefaultMediaRecorder implements KryptonMediaRecorder {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final String[] ENCODER_BLACK_LIST = null;
    private static final long MIN_INTERVAL = 8000;
    public static final String TAG = "KryptonMediaRecorder";
    public static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAllTrackCount;
    private int mAudioBPS;
    private MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioChannelCount;
    private MediaCodec mAudioMediaCodecEncoder;
    private long mAudioPresentationTimeUs;
    private int mAudioSampleRate;
    private long mAudioSamples;
    private int mAudioTrackIndex;
    private int mBPS;
    private ArrayList<String> mCachedPaths;
    private long[] mClipTimeArray;
    private final Delegate mDelegate;
    private int mFPS;
    private int mHeight;
    private final Invoker mInvoker;
    private long mLastPauseTime;
    private long mLastVideoTime;
    private KryptonMediaRecorder.Listener mListener;
    private int mMaxDuration;
    private MediaMuxer mMediaMuxer;
    private String mMimeType;
    private boolean mMuxerStarted;
    private boolean mPaused;
    private long mPausedTime;
    private boolean mRunning;
    private long mStartTime;
    private boolean mToAdjustVideoConfig;
    private int mTrackCount;
    private boolean mUseAudio;
    private MediaCodec.BufferInfo mVideoBufferInfo;
    private Surface mVideoInputSurface;
    private MediaCodec mVideoMediaCodecEncoder;
    private String mVideoOutputPath;
    private String mVideoOutputUrl;
    private String mVideoRangeLogString;
    private int mVideoTrackIndex;
    private int mWidth;

    /* JADX INFO: renamed from: com.lynx.canvas.recorder.KryptonDefaultMediaRecorder$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy = null;

        static {
            int[] r100 = new int[VideoFileManagementPolicy.values().length];
            $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy = r100;
            r100[VideoFileManagementPolicy.FORCE_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[VideoFileManagementPolicy.FORCE_KEEP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class ClipVideoTimeRanges {
        public Item[] itemArray;
        final /* synthetic */ KryptonDefaultMediaRecorder this$0;

        public class Item {
            public long end;
            public long offset;
            public long start;
            final /* synthetic */ ClipVideoTimeRanges this$1;

            public Item(ClipVideoTimeRanges r100) {
                this.this$1 = r100;
            }
        }

        public boolean valid() {
            Item[] r100 = this.itemArray;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.length == 0) goto L7;
            return true;
        }

        public ClipVideoTimeRanges(KryptonDefaultMediaRecorder r100, long[] r101) {
            this.this$0 = r100;
            if (r101 == null) goto L10;
            int r102 = 1;
            if (r101.length <= 1) goto L12;
            this.itemArray = new Item[r101.length / 2];
        L8:
            if (r102 >= r101.length) goto L13;
            Item r103 = new Item(this);
            r103.start = r101[r102 - 1];
            r103.end = r101[r102];
            r103.offset = -1;
            this.itemArray[r102 / 2] = r103;
            r102 = r102 + 1;
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public interface Delegate {
        String getVideoDirectory(String r100, boolean r101);

        VideoFileManagementPolicy getVideoFileManagementPolicy();

        VideoPathInfo getVideoPathInfo(String r100, boolean r101);
    }

    public interface Invoker {
        String extractMetadata(MediaMetadataRetriever r100, int r101);
    }

    public static final enum VideoFileManagementPolicy extends Enum<VideoFileManagementPolicy> {
        private static final /* synthetic */ VideoFileManagementPolicy[] $VALUES = null;
        public static final VideoFileManagementPolicy FORCE_DELETE = null;
        public static final VideoFileManagementPolicy FORCE_KEEP = null;
        public static final VideoFileManagementPolicy USER_DEFINED = null;

        static {
            VideoFileManagementPolicy r100 = new VideoFileManagementPolicy("USER_DEFINED", 0);
            USER_DEFINED = r100;
            VideoFileManagementPolicy r101 = new VideoFileManagementPolicy("FORCE_DELETE", 1);
            FORCE_DELETE = r101;
            VideoFileManagementPolicy r102 = new VideoFileManagementPolicy("FORCE_KEEP", 2);
            FORCE_KEEP = r102;
            $VALUES = new VideoFileManagementPolicy[]{r100, r101, r102};
        }

        public static VideoFileManagementPolicy[] values() {
            return (VideoFileManagementPolicy[]) $VALUES.clone();
        }

        public static VideoFileManagementPolicy valueOf(String r100) {
            return (VideoFileManagementPolicy) a.a(VideoFileManagementPolicy.class, r100);
        }

        private VideoFileManagementPolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class VideoPathInfo {
        public String path;
        public String url;

        public VideoPathInfo() {
        }
    }

    private synchronized long getPresentationTimeUs() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mUseAudio == false) goto L11;
        if (this.mAudioSamples == 0) goto L11;
        long r100 = this.mAudioPresentationTimeUs;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    L11:
        long r101 = (currentTimeUs() - this.mStartTime) - this.mPausedTime;
        monitor-exit(this);
        return r101;
    }

    private void initMediaMuxer() throws Exception {
        releaseMediaMuxer(true);
        VideoPathInfo r100 = getOrCreateVideoPathInfo(false);
        this.mVideoOutputPath = r100.path;
        this.mVideoOutputUrl = r100.url;
        this.mMediaMuxer = new MediaMuxer(this.mVideoOutputPath, 0);
    }

    private synchronized boolean isRunning() {
        monitor-enter(this);
        boolean r100 = this.mRunning;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized long lastPresentationTime() {
        monitor-enter(this);
        long r100 = this.mLastVideoTime;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void pauseRecord() {
        monitor-enter(this);
        this.mLastPauseTime = currentTimeUs();     // Catch: Throwable -> L6
        this.mPaused = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void resumeRecord() {
        monitor-enter(this);
        this.mPausedTime += currentTimeUs() - this.mLastPauseTime;     // Catch: Throwable -> L6
        this.mPaused = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void stopRecord() {
        monitor-enter(this);
        this.mPaused = false;     // Catch: Throwable -> L9
        if (this.mRunning == false) goto L7;
        this.mRunning = false;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        ENCODER_BLACK_LIST = new String[]{"c2.android.avc.encoder"};
    }

    private void adjustVideoConfig() {
        MediaCodecInfo.CodecCapabilities r100 = this.mVideoMediaCodecEncoder.getCodecInfo().getCapabilitiesForType(this.mMimeType);
        int r101 = 4;
        if (r100 == null) goto L14;
        MediaCodecInfo.VideoCapabilities r102 = r100.getVideoCapabilities();
        if (r102 == null) goto L14;
        if (r102.getWidthAlignment() <= 4) goto L9;
        int r103 = r102.getWidthAlignment();
    L11:
        if (r102.getHeightAlignment() <= 4) goto L13;
        r101 = r102.getHeightAlignment();
    L13:
        Range<Integer> r104 = r102.getSupportedFrameRates();
        Range<Integer> r105 = r102.getBitrateRange();
        Range<Integer> r106 = r102.getSupportedWidths();
        Range<Integer> r107 = r102.getSupportedHeights();
        int r108 = ((Integer) r106.getLower()).intValue();
        int r109 = ((Integer) r106.getUpper()).intValue();
        int r110 = ((Integer) r107.getLower()).intValue();
        int r111 = ((Integer) r107.getUpper()).intValue();
        this.mVideoRangeLogString = "widthRange(" + r108 + "," + r109 + "),heightRange(" + r110 + "," + r111 + "),frameRateRange(" + r104.getLower() + "," + r104.getUpper() + "),bitRateRange(" + r105.getLower() + "," + r105.getUpper() + ")";
        int r112 = r103;
        int r113 = r101;
        r101 = r112;
    L15:
        int r114 = this.mWidth;
        int r115 = this.mHeight;
        if (r114 >= r115) goto L18;
        int r116 = r110;
        r110 = r108;
        r108 = r116;
    L19:
        if (r114 > r111) goto L21;
        if (r115 > r109) goto L21;
    L32:
        if ((r114 % r101) == 0) goto L35;
        r114 = (r114 / r101) * r101;
    L35:
        if ((r115 % r113) == 0) goto L37;
        r115 = (r115 / r113) * r113;
    L37:
        int r117 = valueInRange(r114, null, r108, r111);
        int r118 = valueInRange(r115, null, r110, r109);
        int r119 = valueInRange(this.mFPS, r104, 0, 960);
        int r120 = valueInRange(this.mBPS, r105, 280000, 30000000);
        if (this.mWidth == r117) goto L40;
    L45:
        KryptonLLog.i("KryptonMediaRecorder", "adjust video config to width: " + r117 + ", height: " + r118 + ", bps: " + r120 + ", fps: " + r119 + " from original width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS + ", range:" + this.mVideoRangeLogString);
        this.mWidth = r117;
        this.mHeight = r118;
        this.mFPS = r119;
        this.mBPS = r120;
        return;
    L40:
        if (this.mHeight != r118) goto L45;
        if (this.mFPS != r119) goto L45;
        if (this.mBPS != r120) goto L45;
        return;
    L21:
        int r121 = r114 * r109;
        int r122 = r115 * r111;
        if (r121 <= r122) goto L27;
        if (r114 > 0) goto L26;
        r114 = 1;
    L26:
        r115 = r122 / r114;
        r114 = r111;
        goto L32
    L27:
        if (r115 > 0) goto L30;
        r115 = 1;
    L30:
        r114 = r121 / r115;
        r115 = r109;
        goto L32
    L18:
        int r123 = r109;
        r109 = r111;
        r111 = r123;
        goto L19
    L9:
        r103 = 4;
    L14:
        r108 = 176;
        r109 = TECameraUtils.CAPTURE_NORMAL;
        r110 = 144;
        r111 = 1080;
        r104 = null;
        r105 = null;
        r113 = 4;
        goto L15
    }

    private void autoAdjustVideoConfig() throws Exception {
        if (this.mToAdjustVideoConfig == true) goto L5;
        return;
    L5:
        this.mVideoMediaCodecEncoder = findEncoderForFormat(MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, 640, 480));
        adjustVideoConfig();
        if (isResolutionSupported(this.mVideoMediaCodecEncoder, this.mWidth, this.mHeight, VIDEO_MIME_TYPE) == true) goto L8;
        KryptonLLog.i("KryptonMediaRecorder", "release encoder which do not supported size (" + this.mWidth + ", " + this.mHeight + ")");
        releaseVideoMediaCodecEncoder(true);
    L8:
        this.mToAdjustVideoConfig = false;
    }

    private void clipThreadRun() {
        ClipVideoTimeRanges r110 = new ClipVideoTimeRanges(this, this.mClipTimeArray);
        if (r110.valid() == true) goto L6;
        notifyClipStopWithError(null, "clip error: no clip time array");
        return;
    L6:
        KryptonLLog.i("KryptonMediaRecorder", "start clip with ranges");
        VideoPathInfo r100 = getOrCreateVideoPathInfo(true);
        String r111 = r100.path;
        String r112 = r100.url;
        if (r111 != null) goto L10;
        notifyClipStopWithError(null, "clip error: create file exception");
        return;
    L10:
        MediaExtractor r113 = new MediaExtractor();
        r113.setDataSource(this.mVideoOutputPath);     // Catch: Exception -> L71
        int r101 = 0;
        MediaMuxer r114 = new MediaMuxer(r111, 0);     // Catch: Exception -> L71
        int r102 = 0;
        int r103 = -1;
        int r104 = -1;
        int r105 = -1;
        int r115 = -1;
    L80:
    L32:
        e = e;
    L33:
        r101 = r103;
    L34:
        notifyClipStopWithError(r111, "clip error: " + e.toString());
        int r106 = r101;
    L35:
        int r107 = r104;
        if (r106 != (-1)) goto L82;
        notifyClipStopWithError(r111, "clip error: no video track found");
        return;
    L82:
        r114.start();     // Catch: Exception -> L68
        ByteBuffer r116 = ByteBuffer.allocate(r102);     // Catch: Exception -> L68
        if (clipTrack(r113, r114, r110, false, r116, r106, r105) == true) goto L43;
        notifyClipStopWithError(r111, "clip error: no video track filled");     // Catch: Exception -> L68
        return;
    L43:
        if (r107 < 0) goto L45;
        clipTrack(r113, r114, r110, true, r116, r107, r115);     // Catch: Exception -> L68
    L45:
        r114.stop();     // Catch: Exception -> L68
        r114.release();     // Catch: Exception -> L68
        r113.release();     // Catch: Exception -> L68
        PolarisFileWrapper r108 = new PolarisFileWrapper(r111);
        if (r108.exists() == true) goto L49;
    L66:
        notifyClipStopWithError(r111, "create video file failed.");
        return;
    L49:
        if (r108.isFile() == false) goto L66;
        MediaMetadataRetriever r109 = new MediaMetadataRetriever();
        r109.setDataSource(r111);     // Catch: Throwable -> L64
        long r117 = r108.length();
        Invoker r118 = this.mInvoker;
        if (r118 == null) goto L56;
        String r119 = r118.extractMetadata(r109, 9);
    L57:
        if (r119 == null) goto L59;
        float r120 = CastFloatProtector.parseFloat(r119);
    L60:
        this.mCachedPaths.add(r111);
        KryptonLLog.i("KryptonMediaRecorder", "clip stop with data: path: " + r111 + ",duration = " + r120 + ", size = " + r117);
        KryptonMediaRecorder.Listener r121 = this.mListener;
        if (r121 == null) goto L91;
        r121.onClipVideoEnd(this, r111, r112, r120 / 1000.0f, r117);
        return;
    L91:
        return;
    L59:
        r120 = 0.0f;
        goto L60
    L56:
        r119 = com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(r109, 9);
    L64:
        notifyClipStopWithError(r111, "video file is empty");
        return;
    L68:
        e = move-exception;
        notifyClipStopWithError(r111, "clip error: clip video data exception " + e.toString());
        return;
    L14:
        if (r101 >= r113.getTrackCount()) goto L31;
        MediaFormat r122 = r113.getTrackFormat(r101);     // Catch: Exception -> L32
        if (r122.getString("mime").startsWith("video/") == true) goto L76;
        if (r122.getString("mime").startsWith("audio/") == false) goto L30;
        r115 = r114.addTrack(r122);     // Catch: Exception -> L28
        r104 = r101;
    L28:
        e = e;
        r104 = r101;
    L30:
        r101 = r101 + 1;
        goto L80
    L76:
        int r123 = r122.getInteger("max-input-size");     // Catch: Exception -> L22
        r105 = r114.addTrack(r122);     // Catch: Exception -> L20
        r103 = r101;
        r102 = r123;
    L20:
        e = e;
        r102 = r123;
    L22:
        e = e;
        goto L34
    L31:
        r106 = r103;
    L71:
        e = move-exception;
        notifyClipStopWithError(r111, "clip error: MediaExtractor exception " + e.toString());
    }

    private void drainAudioEncoder() {
        MediaCodec r100 = this.mAudioMediaCodecEncoder;
        if (r100 != null) goto L5;
        return;
    L5:
        ByteBuffer[] r101 = r100.getOutputBuffers();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = this.mAudioMediaCodecEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0);
        if (r102 >= 0) goto L21;
        if (r102 >= 0) goto L21;
        if (r102 == (-1)) goto L13;
        if (r102 == (-3)) goto L16;
        if (r102 == (-2)) goto L19;
        KryptonLLog.i("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + r102);
        goto L8
    L19:
        resetOutputFormat(true);
        goto L8
    L16:
        r101 = this.mAudioMediaCodecEncoder.getOutputBuffers();
        goto L8
    L13:
        return;
    L21:
        ByteBuffer r103 = r101[r102];
        if (r103 == null) goto L33;
        MediaCodec.BufferInfo r104 = this.mAudioBufferInfo;
        if ((r104.flags & 2) == 0) goto L27;
        r104.size = 0;
    L27:
        if (this.mMuxerStarted == true) goto L29;
    L31:
        this.mAudioMediaCodecEncoder.releaseOutputBuffer(r102, false);
        goto L8
    L29:
        if (r104.size == 0) goto L31;
        r103.position(r104.offset);
        MediaCodec.BufferInfo r105 = this.mAudioBufferInfo;
        r103.limit(r105.offset + r105.size);
        this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex, r103, this.mAudioBufferInfo);
        goto L31
    L33:
        throw new RuntimeException("encoderOutputBuffer " + r102 + " was null");
    }

    private void notifyFlushRecord() {
        KryptonMediaRecorder.Listener r100 = this.mListener;
        if (r100 == null) goto L6;
        r100.onRecordFlush(this);
        return;
    }

    private void prepareAudioEncoder() throws Exception {
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat r100 = new MediaFormat();
        r100.setString("mime", AUDIO_MIME_TYPE);
        r100.setInteger("aac-profile", 2);
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE, this.mAudioSampleRate);
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, this.mAudioChannelCount);
        r100.setInteger("bitrate", this.mAudioBPS);
        r100.setInteger("max-input-size", 32768);
        releaseAudioMediaCodecEncoder(true);
        MediaCodec r101 = findEncoderForFormat(r100);
        this.mAudioMediaCodecEncoder = r101;
        r101.configure(r100, null, null, 1);
        this.mAudioMediaCodecEncoder.start();
    }

    private void prepareVideoEncoder() throws Exception {
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        releaseVideoMediaCodecEncoder(true);
        autoAdjustVideoConfig();
        MediaFormat r100 = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, this.mWidth, this.mHeight);
        r100.setInteger("color-format", 2130708361);
        r100.setInteger("bitrate", this.mBPS);
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, this.mFPS);
        r100.setInteger("i-frame-interval", 1);
        KryptonLLog.i("KryptonMediaRecorder", "create format width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);
        if (this.mVideoMediaCodecEncoder != null) goto L5;
        this.mVideoMediaCodecEncoder = findEncoderForFormat(r100);
        KryptonLLog.i("KryptonMediaRecorder", " find encoder for size (" + this.mWidth + ", " + this.mHeight + ")");
    L6:
        this.mVideoMediaCodecEncoder.configure(r100, null, null, 1);
        this.mVideoInputSurface = this.mVideoMediaCodecEncoder.createInputSurface();
        this.mVideoMediaCodecEncoder.start();
        return;
    L5:
        KryptonLLog.i("KryptonMediaRecorder", " reuse the encoder found with dummy format for size (" + this.mWidth + ", " + this.mHeight + ")");
        goto L6
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized Surface startRecord() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.mWidth > 0) goto L7;
    L33:
        notifyStartError("init param error");     // Catch: Throwable -> L36
        monitor-exit(this);
        return null;
    L7:
        if (this.mHeight <= 0) goto L33;
        this.mPausedTime = 0;     // Catch: Throwable -> L36
        this.mLastPauseTime = 0;     // Catch: Throwable -> L36
        this.mMuxerStarted = false;     // Catch: Throwable -> L36
        this.mLastVideoTime = 0;     // Catch: Throwable -> L36
        this.mAudioTrackIndex = -1;     // Catch: Throwable -> L36
        this.mVideoTrackIndex = -1;     // Catch: Throwable -> L36
        this.mTrackCount = 0;     // Catch: Throwable -> L36
        this.mPaused = false;     // Catch: Throwable -> L36
        this.mAudioPresentationTimeUs = 0;     // Catch: Throwable -> L36
        this.mAudioSamples = 0;     // Catch: Throwable -> L36
        prepareVideoEncoder();     // Catch: Exception -> L29 Throwable -> L36
    L13:
        if (this.mUseAudio == true) goto L41;
        this.mAllTrackCount = 1;     // Catch: Throwable -> L36
    L39:
        initMediaMuxer();     // Catch: Exception -> L25 Throwable -> L36
        this.mRunning = true;     // Catch: Throwable -> L36
        final String r100 = "MediaRecorder";
        ThreadMethodProxy.start(new AnonymousClass1(this, r100));     // Catch: Throwable -> L36
        Surface r101 = this.mVideoInputSurface;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r101;
    L25:
        e = move-exception;
        String r102 = "initMediaMuxer " + e.toString();     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r102);     // Catch: Throwable -> L36
        notifyStartError(r102);     // Catch: Throwable -> L36
        return null;
    L41:
        prepareAudioEncoder();     // Catch: Exception -> L16 Throwable -> L36
        this.mAllTrackCount = 2;     // Catch: Exception -> L16 Throwable -> L36
    L16:
        e = move-exception;
        String r103 = "prepareAudioEncoder " + e.toString();     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r103);     // Catch: Throwable -> L36
        notifyStartError(r103);     // Catch: Throwable -> L36
        return null;
    L29:
        e = move-exception;
        String r104 = "prepareVideoEncoder " + e.toString() + "model:" + Build.MODEL + " width:" + this.mWidth + " height:" + this.mHeight + " bps:" + this.mBPS + "ranges: " + this.mVideoRangeLogString;     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r104);     // Catch: Throwable -> L36
        notifyStartError(r104);     // Catch: Throwable -> L36
        return null;
    }

    private long currentTimeUs() {
        long r100 = System.nanoTime();
        return (System.currentTimeMillis() * 1000) + ((r100 - ((r100 / 1000000) * 1000000)) / 1000);
    }

    private void recorderThreadRun() {
        this.mStartTime = currentTimeUs();     // Catch: Exception -> L35
    L4:
        if (isRunning() == false) goto L10;
        notifyFlushRecord();     // Catch: Exception -> L35
        drainVideoEncoder(false);     // Catch: Exception -> L35
        drainAudioEncoder();     // Catch: Exception -> L35
        int r100 = this.mMaxDuration;     // Catch: Exception -> L35
        if (r100 <= 0) goto L4;
        if (this.mLastVideoTime < (((double) r100) * 1000000.0d)) goto L4;
        this.mRunning = false;     // Catch: Exception -> L35
        this.mPaused = false;     // Catch: Exception -> L35
        goto L4
    L10:
        this.mVideoMediaCodecEncoder.signalEndOfInputStream();     // Catch: Exception -> L35
        drainVideoEncoder(true);     // Catch: Exception -> L35
        drainAudioEncoder();     // Catch: Exception -> L35
        releaseVideoMediaCodecEncoder(false);     // Catch: Exception -> L32
        releaseAudioMediaCodecEncoder(false);     // Catch: Exception -> L32
        releaseMediaMuxer(false);     // Catch: Exception -> L32
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mVideoOutputPath);
        if (r101.exists() == true) goto L15;
    L30:
        notifyStopWithError("create video file failed.");
        return;
    L15:
        if (r101.isFile() == false) goto L30;
        long r102 = r101.length();
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();
        r103.setDataSource(this.mVideoOutputPath);     // Catch: Throwable -> L28
        Invoker r104 = this.mInvoker;
        if (r104 == null) goto L22;
        String r105 = r104.extractMetadata(r103, 9);
    L23:
        if (r105 == null) goto L25;
        float r106 = CastFloatProtector.parseFloat(r105);
    L26:
        this.mCachedPaths.add(this.mVideoOutputPath);
        notifyStopWithData(r106 / 1000.0f, r102);
        return;
    L25:
        r106 = 0.0f;
        goto L26
    L22:
        r105 = com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(r103, 9);
    L28:
        notifyStopWithError("result video file is empty");
        return;
    L32:
        e = move-exception;
        notifyStopWithError("release Encoder error." + e.toString());
        return;
    L35:
        e = move-exception;
        notifyStopWithError("encode error " + e.toString());
    }

    public static /* synthetic */ void access$000(KryptonDefaultMediaRecorder r100) {
        r100.recorderThreadRun();
    }

    public static /* synthetic */ void access$100(KryptonDefaultMediaRecorder r100) {
        r100.clipThreadRun();
    }

    private String createTempVideoFileInDirectory(String r100) {
        if (r100 != null) goto L13;
        return null;
    L13:
        File r101 = File.createTempFile("krypton", ".mp4", new PolarisFileWrapper(r100));     // Catch: Exception -> L10
        if (r101.exists() == false) goto L8;
        r101.delete();     // Catch: Exception -> L10
    L8:
        return r101.getPath();
    L10:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
        return null;
    }

    private boolean deleteFileWithPath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L14
        if (r101.exists() == true) goto L6;
    L12:
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r100 + ", file not exists");     // Catch: Throwable -> L14
    L18:
        return false;
    L6:
        if (r101.isFile() == false) goto L12;
        if (r101.delete() == false) goto L11;
        return true;
    L11:
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r100 + " exception " + th.toString());
        return false;
    }

    private void drainVideoEncoder(boolean r110) {
        MediaCodec r100 = this.mVideoMediaCodecEncoder;
        if (r100 != null) goto L5;
        return;
    L5:
        ByteBuffer[] r101 = r100.getOutputBuffers();
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = this.mVideoMediaCodecEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 0);
        if (r102 < 0) goto L11;
        ByteBuffer r103 = r101[r102];
        if (r103 == null) goto L43;
        MediaCodec.BufferInfo r104 = this.mVideoBufferInfo;
        if ((r104.flags & 2) == 0) goto L27;
        r104.size = 0;
    L27:
        if (this.mMuxerStarted == true) goto L29;
    L37:
        this.mVideoMediaCodecEncoder.releaseOutputBuffer(r102, false);
        if ((this.mVideoBufferInfo.flags & 4) == 0) goto L8;
        if (r110 == true) goto L61;
        KryptonLLog.w("KryptonMediaRecorder", "reached end of stream unexpectedly");
        return;
    L61:
        return;
    L29:
        if (r104.size <= 0) goto L37;
        r103.position(r104.offset);
        MediaCodec.BufferInfo r105 = this.mVideoBufferInfo;
        r103.limit(r105.offset + r105.size);
        this.mVideoBufferInfo.presentationTimeUs = getPresentationTimeUs();
        if (this.mPaused == true) goto L37;
        MediaCodec.BufferInfo r106 = this.mVideoBufferInfo;
        long r107 = r106.presentationTimeUs;
        long r108 = this.mLastVideoTime;
        if (r107 > r108) goto L36;
        r106.presentationTimeUs = r108 + 8000;
    L36:
        this.mLastVideoTime = r106.presentationTimeUs;
        this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex, r103, r106);
        goto L37
    L43:
        throw new RuntimeException("encoderOutputBuffer " + r102 + " was null");
    L11:
        if (r102 != (-3)) goto L13;
        r101 = this.mVideoMediaCodecEncoder.getOutputBuffers();
        KryptonLLog.i("KryptonMediaRecorder", "encoder output buffer length:" + r101.length);
        goto L8
    L13:
        if (r102 != (-2)) goto L15;
        resetOutputFormat(false);
        goto L8
    L15:
        if (r102 != (-1)) goto L16;
        if (r110 == true) goto L8;
        return;
    L16:
        KryptonLLog.w("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + r102);
        goto L8
    }

    private MediaCodec findEncoderForFormat(MediaFormat r100) throws IOException {
        if (Build.VERSION.SDK_INT <= 21) goto L13;
        String r101 = new MediaCodecList(0).findEncoderForFormat(r100);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (isInefficientEncoder(r101) == true) goto L13;
        return MediaCodec.createByCodecName(r101);
    L10:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", "createByCodecName " + r101 + " exception " + e.getMessage());
    L13:
        return MediaCodec.createEncoderByType(r100.getString("mime"));
    }

    private VideoPathInfo getOrCreateVideoPathInfo(boolean r100) {
        VideoPathInfo r101 = this.mDelegate.getVideoPathInfo(this.mMimeType, r100);
        if (r101 != null) goto L25;
        r101 = new VideoPathInfo();
    L25:
    L17:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
        r101.path = null;
    L20:
        if (r101.url != null) goto L24;
        String r102 = r101.path;
        if (r102 == null) goto L24;
        r101.url = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r102);
    L24:
        return r101;
    L6:
        if (r101.path == null) goto L8;
        File r103 = new PolarisFileWrapper(r101.path);     // Catch: Exception -> L17
    L12:
        if (r103.exists() == false) goto L14;
        r103.delete();     // Catch: Exception -> L17
    L14:
        r101.path = r103.getPath();     // Catch: Exception -> L17
        goto L20
    L8:
        String r104 = this.mDelegate.getVideoDirectory(this.mMimeType, r100);     // Catch: Exception -> L17
        if (r104 == null) goto L16;
        r103 = File.createTempFile("krypton", ".mp4", new PolarisFileWrapper(r104));     // Catch: Exception -> L17
        goto L12
    L16:
        throw new Exception("Should specify a video directory with getVideoDirectory method.");     // Catch: Exception -> L17
    }

    private boolean isInefficientEncoder(String r100) {
        String[] r101 = ENCODER_BLACK_LIST;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (TextUtils.equals(r101[r103], r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void notifyStartError(String r100) {
        KryptonMediaRecorder.Listener r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onRecordStartError(this, r100);
        return;
    }

    private void notifyStopWithError(String r100) {
        tryToDeleteFileWithPath(this.mVideoOutputPath);
        KryptonMediaRecorder.Listener r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onRecordStopWithError(this, r100);
        return;
    }

    private void releaseAudioMediaCodecEncoder(boolean r100) {
        MediaCodec r101 = this.mAudioMediaCodecEncoder;
        if (r101 != null) goto L18;
        return;
    L18:
        r101.stop();     // Catch: Throwable -> L8 RuntimeException -> L10
        this.mAudioMediaCodecEncoder.release();     // Catch: Throwable -> L8 RuntimeException -> L10
    L7:
        this.mAudioMediaCodecEncoder = null;
        return;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseAudioMediaCodecEncoder exception " + e.toString());     // Catch: Throwable -> L8
        if (r100 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mAudioMediaCodecEncoder = null;
        throw th;
    }

    private void releaseMediaMuxer(boolean r100) {
        MediaMuxer r101 = this.mMediaMuxer;
        if (r101 != null) goto L18;
        return;
    L18:
        r101.stop();     // Catch: Throwable -> L8 IllegalStateException -> L10
        this.mMediaMuxer.release();     // Catch: Throwable -> L8 IllegalStateException -> L10
    L7:
        this.mMediaMuxer = null;
        return;
    L8:
        th = move-exception;
        this.mMediaMuxer = null;
        throw th;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseMediaMuxer exception " + e.toString());     // Catch: Throwable -> L8
        if (r100 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    }

    private void releaseVideoMediaCodecEncoder(boolean r100) {
        MediaCodec r101 = this.mVideoMediaCodecEncoder;
        if (r101 != null) goto L18;
        return;
    L18:
        r101.stop();     // Catch: Throwable -> L8 RuntimeException -> L10
        this.mVideoMediaCodecEncoder.release();     // Catch: Throwable -> L8 RuntimeException -> L10
    L7:
        this.mVideoMediaCodecEncoder = null;
        return;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseVideoMediaCodecEncoder exception " + e.toString());     // Catch: Throwable -> L8
        if (r100 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mVideoMediaCodecEncoder = null;
        throw th;
    }

    private void resetOutputFormat(boolean r100) {
        if (this.mMuxerStarted == true) goto L12;
        if (r100 == false) goto L6;
        this.mAudioTrackIndex = this.mMediaMuxer.addTrack(this.mAudioMediaCodecEncoder.getOutputFormat());
    L7:
        int r101 = this.mTrackCount + 1;
        this.mTrackCount = r101;
        if (r101 != this.mAllTrackCount) goto L13;
        this.mMediaMuxer.start();
        this.mMuxerStarted = true;
        return;
    L13:
        return;
    L6:
        this.mVideoTrackIndex = this.mMediaMuxer.addTrack(this.mVideoMediaCodecEncoder.getOutputFormat());
        goto L7
    L12:
        throw new IllegalStateException("output format already changed!");
    }

    private synchronized void tryToDeleteFileWithPath(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        deleteFileWithPath(r100);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public boolean clipVideo(long[] r100) {
        this.mClipTimeArray = r100;
        final String r101 = "MediaRecorderClop";
        ThreadMethodProxy.start(new AnonymousClass2(this, r101));
        return true;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void destroy(boolean r100) {
        monitor-enter(this);
        stopRecord();     // Catch: Throwable -> L20
        if (this.mDelegate.getVideoFileManagementPolicy() == null) goto L12;
        int r101 = AnonymousClass3.$SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[this.mDelegate.getVideoFileManagementPolicy().ordinal()];     // Catch: Throwable -> L20
        if (r101 != 1) goto L8;
        r100 = true;
        goto L12
    L8:
        if (r101 != 2) goto L12;
        r100 = false;
    L12:
        if (r100 == false) goto L17;
        KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with video files deleted");     // Catch: Throwable -> L20
        Iterator<String> r102 = this.mCachedPaths.iterator();     // Catch: Throwable -> L20
    L15:
        if (r102.hasNext() == false) goto L18;
        deleteFileWithPath(r102.next());     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L17:
        KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with 1 video files not deleted");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void setListener(KryptonMediaRecorder.Listener r100) {
        monitor-enter(this);
        this.mListener = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public KryptonDefaultMediaRecorder(Delegate r100, Invoker r101) {
        this.mVideoRangeLogString = "";
        this.mRunning = false;
        this.mUseAudio = false;
        this.mLastPauseTime = 0;
        this.mPausedTime = 0;
        this.mLastVideoTime = 0;
        this.mStartTime = 0;
        this.mClipTimeArray = null;
        this.mCachedPaths = new ArrayList();
        if (r100 == null) goto L7;
        this.mDelegate = r100;
        this.mInvoker = r101;
        return;
    L7:
        throw new IllegalArgumentException("KryptonDefaultMediaRecorder delegate must be set.");
    }

    private static String com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private void notifyClipStopWithError(String r100, String r101) {
        tryToDeleteFileWithPath(r100);
        KryptonMediaRecorder.Listener r102 = this.mListener;
        if (r102 == null) goto L6;
        r102.onClipVideoEndWithError(this, r101);
        return;
    }

    private void notifyStopWithData(float r100, long r101) {
        KryptonMediaRecorder.Listener r102 = this.mListener;
        if (r102 == null) goto L6;
        r102.onRecordStop(this, this.mVideoOutputPath, this.mVideoOutputUrl, r100, r101);
        return;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public void onAudioSample(ByteBuffer r110, int r111) {
        MediaCodec r100 = this.mAudioMediaCodecEncoder;
        if (r100 != null) goto L15;
        return;
    L15:
        int r101 = r100.dequeueInputBuffer(0);     // Catch: Exception -> L12
        if (r101 >= 0) goto L10;
        KryptonLLog.w("KryptonMediaRecorder", "no input buffer, audio data dropped");     // Catch: Exception -> L12
        return;
    L10:
        ByteBuffer r102 = this.mAudioMediaCodecEncoder.getInputBuffers()[r101];     // Catch: Exception -> L12
        r102.clear();     // Catch: Exception -> L12
        r110.position(0).limit(r111);     // Catch: Exception -> L12
        r102.put(r110);     // Catch: Exception -> L12
        long r103 = this.mAudioSamples;     // Catch: Exception -> L12
        long r104 = (1000000 * r103) / ((long) this.mAudioSampleRate);     // Catch: Exception -> L12
        this.mAudioPresentationTimeUs = r104;     // Catch: Exception -> L12
        this.mAudioSamples = r103 + ((long) (r111 >> 2));     // Catch: Exception -> L12
        this.mAudioMediaCodecEncoder.queueInputBuffer(r101, 0, r111, r104, 0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", "onAudioSample exception " + e.toString());
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configAudio(int r100, int r101, int r102) {
        monitor-enter(this);
        if (r100 < 0) goto L5;
        this.mAudioChannelCount = r100;     // Catch: Throwable -> L11
        this.mAudioBPS = r101;     // Catch: Throwable -> L11
        this.mAudioSampleRate = r102;     // Catch: Throwable -> L11
        this.mUseAudio = true;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L5:
        this.mUseAudio = false;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isResolutionSupported(MediaCodec r100, int r101, int r102, String r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        MediaCodecInfo.CodecCapabilities r104 = r100.getCodecInfo().getCapabilitiesForType(r103);
        if (r104 != null) goto L8;
        return false;
    L8:
        MediaCodecInfo.VideoCapabilities r105 = r104.getVideoCapabilities();
        if (r105 != null) goto L12;
        return false;
    L12:
        return r105.isSizeSupported(r101, r102);
    }

    private int valueInRange(int r100, Range<Integer> r101, int r102, int r103) {
        if (r101 != null) goto L4;
        if (r100 <= r103) goto L13;
        return r103;
    L13:
        if (r100 >= r102) goto L15;
        return r102;
    L15:
        return r100;
    L4:
        if (r100 <= ((Integer) r101.getUpper()).intValue()) goto L8;
        return ((Integer) r101.getUpper()).intValue();
    L8:
        if (r100 >= ((Integer) r101.getLower()).intValue()) goto L15;
        return ((Integer) r101.getLower()).intValue();
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configVideo(String r100, int r101, int r102, int r103, int r104, int r105) {
        monitor-enter(this);
        this.mMimeType = r100;     // Catch: Throwable -> L7
        this.mMaxDuration = r101;     // Catch: Throwable -> L7
        this.mWidth = r102;     // Catch: Throwable -> L7
        this.mHeight = r103;     // Catch: Throwable -> L7
        this.mBPS = r104;     // Catch: Throwable -> L7
        this.mFPS = r105;     // Catch: Throwable -> L7
        this.mToAdjustVideoConfig = true;     // Catch: Throwable -> L7
        KryptonLLog.i("KryptonMediaRecorder", "configVideo for " + Build.MODEL + ", width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean clipTrack(MediaExtractor r210, MediaMuxer r211, ClipVideoTimeRanges r212, boolean r213, ByteBuffer r310, int r311, int r312) {
        r210.selectTrack(r311);
        MediaCodec.BufferInfo r100 = new MediaCodec.BufferInfo();
        int r101 = 0;
        long r102 = 0;
        long r103 = 0;
        int r110 = 0;
        boolean r111 = false;
    L3:
        ClipVideoTimeRanges.Item[] r112 = r212.itemArray;
        if (r110 >= r112.length) goto L29;
        ClipVideoTimeRanges.Item r113 = r112[r110];
        KryptonLLog.i("KryptonMediaRecorder", "start time " + r113.start + ", end time" + r113.end);
        long r114 = r103;
        r210.seekTo(r113.start, r101);
        long r115 = -1;
    L6:
        int r116 = r210.readSampleData(r310, r101);
        if (r116 < 0) goto L8;
        r102 = r102;
        long r104 = r210.getSampleTime();
        int r105 = r210.getSampleFlags();
        if (r104 > r113.end) goto L12;
        if (r113.offset != (-1)) goto L21;
        r113.start = r104;
        r113.offset = r102;
    L21:
        long r106 = r113.start;
        if (r104 < r106) goto L23;
        long r107 = (r104 - r106) + r113.offset;
        if (r107 < r114) goto L26;
        r101 = 0;
        r100.offset = 0;
        r100.size = r116;
        r100.flags = r105;
        r100.presentationTimeUs = r107;
        r211.writeSampleData(r312, r310, r100);
        r210.advance();
        r111 = true;
        r114 = r107;
        r115 = r104;
        goto L6
    L26:
        r210.advance();
    L27:
        r101 = 0;
        goto L6
    L23:
        r210.advance();
        goto L27
    L12:
        KryptonLLog.i("KryptonMediaRecorder", "presentationTimeUs > endTime " + r104 + " > " + r113.end);
    L14:
        if (r115 == (-1)) goto L16;
        r102 = r102 + (r115 - r113.start);
    L17:
        r110 = r110 + 1;
        r103 = r114;
        r101 = 0;
        goto L3
    L16:
        r113.start = r113.end;
        r102 = r102;
        goto L17
    L8:
        r210.unselectTrack(r311);
        r102 = r102;
        goto L14
    L29:
        return r111;
    }
}
