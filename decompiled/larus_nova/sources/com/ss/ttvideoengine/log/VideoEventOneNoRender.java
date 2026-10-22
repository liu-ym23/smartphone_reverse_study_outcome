package com.ss.ttvideoengine.log;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEventOneNoRender {
    public static final String END_TYPE_EXIT = "exit";
    public static final String END_TYPE_WAIT = "wait";
    public static final String EVENT_TYPE = "av_norender";
    public static final int NO_RENDER_DURATION_UPLOAD_THRESHOLD = 1000;
    public static final int REASON_PLAYER = 0;
    public static final int REASON_TEXTURE_RENDER_NO_CALLBACK = 1;
    public static final int REASON_TEXTURE_RENDER_NO_DRAW = 2;
    private static final String TAG = "VideoEventOneNoRender";
    public static final int TYPE_AUDIO = 1;
    public static final int TYPE_VIDEO = 0;
    public static final String monitorName = "videoplayer_oneevent";
    private int index;
    private boolean isStarted;
    private ArrayList<String> mAudioHistoryList;
    private VideoEventBase mEventBase;
    private EventContext mEventContext;
    public long mFirstFrameTime;
    public int mIsAVBadInterlaced;
    private ArrayList<String> mVideoHistoryList;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.log.VideoEventOneNoRender$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AsyncGetLogDataRunnable implements Runnable {
        private final VideoEventOneNoRender event;
        private final VideoEventBase eventBase;
        private final EventContext eventContext;
        private final Handler handler;

        public static /* synthetic */ void a(boolean r100, JSONObject r101) {
            lambda$run$0(r100, r101);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_VideoEventOneNoRender$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_VideoEventOneNoRender$AsyncGetLogDataRunnable__run$___twin___() {
            VideoEventOneNoRender r100 = this.event;
            if (r100 != null) goto L5;
            return;
        L5:
            VideoEventBase r101 = this.eventBase;
            if (r101 != null) goto L8;
        L10:
            final boolean r102 = false;
        L11:
            final JSONObject r103 = r100.toJsonObject(r101, this.eventContext);
            this.handler.post(new q(r102, r103));
            return;
        L8:
            if (r101.isUploadLogEnabled == false) goto L10;
            r102 = true;
            goto L11
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_VideoEventOneNoRender$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncGetLogDataRunnable r100) {
            r100.com_ss_ttvideoengine_log_VideoEventOneNoRender$AsyncGetLogDataRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private static /* synthetic */ void lambda$run$0(boolean r100, JSONObject r101) {
            VideoEventManager.instance.addEventV2(r100, r101, "videoplayer_oneevent");
        }

        public AsyncGetLogDataRunnable(VideoEventOneNoRender r100, VideoEventBase r101, EventContext r102) {
            this.event = r100;
            this.eventBase = r101;
            this.eventContext = r102;
            this.handler = new Handler(Looper.getMainLooper());
        }
    }

    public static class EventContext {
        long audioBaseLengthMs;
        long audioDecoderLengthMs;
        long audioFormatLengthMs;
        long costTime;
        int mBeginPos;
        int mBt;
        double mCpuRate;
        double mCpuSpeed;
        float mCurrent;
        long mDequeueOutputBufferCountInEnd;
        long mDequeueOutputBufferCountInStart;
        int mEnableGloablMuteFeature;
        int mEndPos;
        long mEndT;
        String mEndType;
        int mGlobalMute;
        int mHeadset;
        int mIsABR;
        int mIsBackground;
        int mIsRadioMode;
        long mLastAVSwitchInterval;
        long mLastForebackSwitchInterval;
        long mLastHeadsetSwitchInterval;
        long mLastRebufT;
        long mLastResSwitchInterval;
        long mLastSeekT;
        long mLastSetSurfaceNullInterval;
        int mMcMonitorQueueSizeInEnd;
        int mMcMonitorQueueSizeInStart;
        int mPowerSaveMode;
        String mQualityDescBefore;
        long mQueueInputBufferCountInEnd;
        long mQueueInputBufferCountInStart;
        String mResolutionBefore;
        int mSetValidSurfaceTimeout;
        int noRenderType;
        int reason;
        String stageError;
        long startTime;
        long videoBaseLengthMs;
        long videoDecoderLengthMs;
        long videoFormatLengthMs;

        private EventContext() {
            this.noRenderType = Integer.MIN_VALUE;
            this.reason = Integer.MIN_VALUE;
            this.videoFormatLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.audioFormatLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.videoDecoderLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.audioDecoderLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.videoBaseLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.audioBaseLengthMs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.startTime = SieveCacheKt.NodeMetaAndPreviousMask;
            this.costTime = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mEndT = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mResolutionBefore = null;
            this.mLastRebufT = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mLastSeekT = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mBeginPos = Integer.MIN_VALUE;
            this.mEndPos = Integer.MIN_VALUE;
            this.mEndType = null;
            this.mIsABR = Integer.MIN_VALUE;
            this.mQualityDescBefore = "";
            this.mIsRadioMode = Integer.MIN_VALUE;
            this.mLastAVSwitchInterval = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mLastResSwitchInterval = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mHeadset = Integer.MIN_VALUE;
            this.mBt = Integer.MIN_VALUE;
            this.mLastHeadsetSwitchInterval = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mIsBackground = Integer.MIN_VALUE;
            this.mLastForebackSwitchInterval = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mLastSetSurfaceNullInterval = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mSetValidSurfaceTimeout = Integer.MIN_VALUE;
            this.mEnableGloablMuteFeature = 0;
            this.mGlobalMute = 0;
            this.mCpuRate = 1.401298464324817E-45d;
            this.mCpuSpeed = 1.401298464324817E-45d;
            this.mPowerSaveMode = Integer.MIN_VALUE;
            this.mCurrent = Float.MIN_VALUE;
            this.mQueueInputBufferCountInStart = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mDequeueOutputBufferCountInStart = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mMcMonitorQueueSizeInStart = Integer.MIN_VALUE;
            this.mQueueInputBufferCountInEnd = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mDequeueOutputBufferCountInEnd = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mMcMonitorQueueSizeInEnd = Integer.MIN_VALUE;
        }

        public /* synthetic */ EventContext(AnonymousClass1 r100) {
            this();
        }
    }

    public static class StatisticDataRunnable implements Runnable {
        private final WeakReference<EventContext> rEvent;
        private final WeakReference<VideoEventBase> rEventBase;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_VideoEventOneNoRender$StatisticDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_VideoEventOneNoRender$StatisticDataRunnable__run$___twin___() {
            EventContext r100 = this.rEvent.get();
            VideoEventBase r101 = this.rEventBase.get();
            if (r100 == null) goto L16;
            if (r101 == null) goto L17;
            DeviceMonitorUtils.CPUInfo r102 = r101.getCurrentCPUInfo();
            if (r102 == null) goto L18;
            double r103 = r102.cpuAppRate;
            double r104 = 1.401298464324817E-45d;
            if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
            r103 = 1.401298464324817E-45d;
        L11:
            r100.mCpuRate = r103;
            double r105 = r102.cpuAppSpeed;
            if (r105 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
            r104 = r105;
        L14:
            r100.mCpuSpeed = r104;
            return;
        L18:
            return;
        L17:
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_VideoEventOneNoRender$StatisticDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(StatisticDataRunnable r100) {
            r100.com_ss_ttvideoengine_log_VideoEventOneNoRender$StatisticDataRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public StatisticDataRunnable(EventContext r100, VideoEventBase r101) {
            this.rEvent = new WeakReference(r100);
            this.rEventBase = new WeakReference(r101);
        }
    }

    public static int unifyReason(int r100) {
        if (r100 == 0) goto L4;
        return 2;
    L4:
        return 1;
    }

    public void onAVBadInterlaced() {
        this.mIsAVBadInterlaced = 1;
    }

    private void addToHistory() {
        String r100 = generateHistory(this.mEventContext);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = this.mEventContext.noRenderType;
        if (r101 != 0) goto L12;
        if (this.mVideoHistoryList != null) goto L10;
        this.mVideoHistoryList = new ArrayList();
    L10:
        this.mVideoHistoryList.add(r100);
        return;
    L12:
        if (r101 == 1) goto L14;
        return;
    L14:
        if (this.mAudioHistoryList != null) goto L16;
        this.mAudioHistoryList = new ArrayList();
    L16:
        this.mAudioHistoryList.add(r100);
    }

    private void maybeSendEvent() {
        if (this.mEventContext.costTime >= 1000) goto L6;
        TTVideoEngineLog.d(TAG, "duration less than threshold, abort event");
        return;
    L6:
        this.index++;
        this.mEventBase.updateVideoInfo(null);
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(this, this.mEventBase, this.mEventContext));
    }

    public String getRenderStageError() {
        return this.mEventContext.stageError;
    }

    public int getType() {
        return this.mEventContext.noRenderType;
    }

    public void reset() {
        this.mEventContext = new EventContext(null);
        this.mVideoHistoryList = null;
        this.mAudioHistoryList = null;
        this.isStarted = false;
        this.index = 0;
        this.mFirstFrameTime = SieveCacheKt.NodeMetaAndPreviousMask;
        this.mIsAVBadInterlaced = 0;
    }

    public void showedFirstFrame() {
        this.mFirstFrameTime = System.currentTimeMillis();
    }

    public ArrayList<String> getAudioHistory() {
        return this.mAudioHistoryList;
    }

    public ArrayList<String> getVideoHistory() {
        return this.mVideoHistoryList;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public VideoEventOneNoRender(VideoEventBase r100) {
        this.mFirstFrameTime = SieveCacheKt.NodeMetaAndPreviousMask;
        this.mIsAVBadInterlaced = 0;
        this.mEventBase = r100;
        this.mEventContext = new EventContext(null);
    }

    private static String generateHistory(EventContext r100) {
        HashMap r101 = new HashMap();
        r101.put(Segment.JsonKey.START, Long.valueOf(r100.startTime));
        r101.put("c", Long.valueOf(r100.costTime));
        r101.put("reason", Integer.valueOf(r100.reason));
        return new JSONObject(r101).toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String parseNoRenderError(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        String[] r102 = r100.split(";|=");
        if (r102 != null) goto L8;
    L23:
        return null;
    L8:
        if (r102.length == 0) goto L23;
        int r103 = 0;
    L12:
        if (r103 >= (r102.length - 1)) goto L19;
        r101.put(r102[r103], Integer.valueOf(CastIntegerProtector.parseInt(r102[r103 + 1])));     // Catch: Exception -> L15
    L17:
        r103 = r103 + 2;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        if (r101.isEmpty() == false) goto L22;
        return null;
    L22:
        return new JSONObject(r101).toString();
    }

    public boolean isType(int r100) {
        if (this.mEventContext.noRenderType != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateEventBase(VideoEventBase r100) {
        this.mEventBase = r100;
    }

    public void updateReason(int r100) {
        EventContext r101 = this.mEventContext;
        if (r101.reason == 0) goto L7;
        if (r100 != 0) goto L8;
        r101.reason = 0;
        return;
    L8:
        return;
    }

    public void end(int r100, String r110) {
        if (isStarted() == true) goto L5;
        return;
    L5:
        this.isStarted = false;
        long r101 = System.currentTimeMillis();
        EventContext r102 = this.mEventContext;
        long r103 = r102.startTime;
        if (r103 <= 0) goto L8;
        r102.costTime = r101 - r103;
    L8:
        r102.mEndType = r110;
        r102.mEndPos = r100;
        r102.mEndT = r101;
        VideoEventBase r104 = this.mEventBase;
        if (r104 == null) goto L15;
        EventLoggerSource r105 = r104.mDataSource;
        if (r105 == null) goto L15;
        r102.mSetValidSurfaceTimeout = r105.getLogValueInt(113);
        EventContext r106 = this.mEventContext;
        if (r106.noRenderType != 0) goto L15;
        r106.mQueueInputBufferCountInEnd = this.mEventBase.mDataSource.getLogValueLong(152);
        EventContext r107 = this.mEventContext;
        r107.mDequeueOutputBufferCountInEnd = this.mEventBase.mDataSource.getLogValueLong(153);
        EventContext r108 = this.mEventContext;
        r108.mMcMonitorQueueSizeInEnd = this.mEventBase.mDataSource.getLogValueInt(154);
    L15:
        addToHistory();
        maybeSendEvent();
        this.mEventContext = new EventContext(null);
    }

    public JSONObject toJsonObject(VideoEventBase r100, EventContext r101) {
        HashMap r102 = new HashMap();
        LoggerUtils.putToMap(r102, "event_type", EVENT_TYPE);
        if (r100 == null) goto L5;
        LoggerUtils.putToMap(r102, "player_sessionid", r100.mSessionID);
        LoggerUtils.putToMap(r102, "sdk_version", r100.sdk_version);
    L5:
        LoggerUtils.putToMap(r102, "r_stage_errcs", r101.stageError);
        LoggerUtils.putToMap(r102, "video_len_before", r101.videoFormatLengthMs);
        LoggerUtils.putToMap(r102, "audio_len_before", r101.audioFormatLengthMs);
        LoggerUtils.putToMap(r102, "vlen_dec_before", r101.videoDecoderLengthMs);
        LoggerUtils.putToMap(r102, "alen_dec_before", r101.audioDecoderLengthMs);
        LoggerUtils.putToMap(r102, "vlen_base_before", r101.videoBaseLengthMs);
        LoggerUtils.putToMap(r102, "alen_base_before", r101.audioBaseLengthMs);
        LoggerUtils.putToMap(r102, HiAnalyticsConstant.BI_KEY_COST_TIME, r101.costTime);
        LoggerUtils.putToMap(r102, "index", this.index);
        LoggerUtils.putToMap(r102, "norender_type", r101.noRenderType);
        LoggerUtils.putToMap(r102, "reason", r101.reason);
        if (r100 == null) goto L15;
        String r103 = r100.mCurURL;
        if (r103 != null) goto L10;
    L13:
        LoggerUtils.putToMap(r102, "cdn_url", r100.mInitialURL);
    L14:
        LoggerUtils.putToMap(r102, "source_type", r100.mSourceTypeStr);
        LoggerUtils.putToMap(r102, BaseSwitches.V, r100.mVid);
        LoggerUtils.putToMap(r102, "vtype", r100.vtype);
        LoggerUtils.putToMap(r102, "tag", r100.mTag);
        LoggerUtils.putToMap(r102, ITTVideoEngineEventSource.KEY_SUBTAG, r100.mSubTag);
        LoggerUtils.putToMap(r102, "codec", r100.codec_type);
        LoggerUtils.putToMap(r102, ITTVideoEngineEventSource.KEY_VIDEO_CODEC_NAME_ID, r100.videoCodecNameId);
        LoggerUtils.putToMap(r102, ITTVideoEngineEventSource.KEY_AUDIO_CODEC_NAME_ID, r100.audioCodecNameId);
        LoggerUtils.putToMap(r102, "format_type", r100.formatType);
        LoggerUtils.putToMap(r102, "drm_type", r100.mDrmType);
        LoggerUtils.putToMap(r102, "play_speed", r100.mPlaySpeed);
        LoggerUtils.putToMap(r102, "enable_mdl", r100.mEnableMDL);
        LoggerUtils.putToMap(r102, "video_hw", r100.mVideoHW);
        LoggerUtils.putToMap(r102, "user_hw", r100.mVideoHWUser);
        goto L15
    L10:
        if (r103.isEmpty() == true) goto L13;
        LoggerUtils.putToMap(r102, "cdn_url", r100.mCurURL);
    L15:
        LoggerUtils.putToMap(r102, Segment.JsonKey.START, r101.startTime);
        LoggerUtils.putToMap(r102, "et", r101.mEndT);
        LoggerUtils.putToMap(r102, "end_type", r101.mEndType);
        LoggerUtils.putToMap(r102, "resolution_before", r101.mResolutionBefore);
        LoggerUtils.putToMap(r102, ITTVideoEngineEventSource.KEY_RADIO_MODE, r101.mIsRadioMode);
        LoggerUtils.putToMap(r102, "setvalidsurface_timeout", r101.mSetValidSurfaceTimeout);
        LoggerUtils.putToMap(r102, "last_av_switch_interval", r101.mLastAVSwitchInterval);
        LoggerUtils.putToMap(r102, "last_res_switch_interval", r101.mLastResSwitchInterval);
        LoggerUtils.putToMap(r102, "headset", r101.mHeadset);
        LoggerUtils.putToMap(r102, "bt", r101.mBt);
        LoggerUtils.putToMap(r102, "last_headset_switch_interval", r101.mLastHeadsetSwitchInterval);
        LoggerUtils.putToMap(r102, LocationMonitorConst.IS_BACKGROUND, r101.mIsBackground);
        LoggerUtils.putToMap(r102, "last_foreback_switch_interval", r101.mLastForebackSwitchInterval);
        LoggerUtils.putToMap(r102, "last_setsurfacenull_interval", r101.mLastSetSurfaceNullInterval);
        long r104 = this.mFirstFrameTime;
        if (r104 <= 0) goto L18;
        long r105 = r101.startTime - r104;
    L19:
        LoggerUtils.putToMap(r102, "first_frame_interval", r105);
        LoggerUtils.putToMap(r102, IVideoEventLogger.LOG_CALLBACK_BEGIN_POS, r101.mBeginPos);
        LoggerUtils.putToMap(r102, IVideoEventLogger.LOG_CALLBACK_END_POS, r101.mEndPos);
        long r106 = r101.mLastRebufT;
        if (r106 <= 0) goto L22;
        LoggerUtils.putToMap(r102, "last_rebuf_interval", r101.startTime - r106);
    L22:
        long r107 = r101.mLastSeekT;
        if (r107 <= 0) goto L25;
        LoggerUtils.putToMap(r102, "last_seek_interval", r101.startTime - r107);
    L25:
        LoggerUtils.putToMap(r102, "is_abr", r101.mIsABR);
        LoggerUtils.putToMap(r102, "quality_desc_before", r101.mQualityDescBefore);
        LoggerUtils.putToMap(r102, "bad_interlaced", this.mIsAVBadInterlaced);
        LoggerUtils.putToMap(r102, "enable_global_mute_feature", r101.mEnableGloablMuteFeature);
        LoggerUtils.putToMap(r102, "global_mute", r101.mGlobalMute);
        LoggerUtils.putToMap(r102, "cpu_rate", (float) r101.mCpuRate);
        LoggerUtils.putToMap(r102, "cpu_speed", (float) r101.mCpuSpeed);
        LoggerUtils.putToMap(r102, "power_save_mode", r101.mPowerSaveMode);
        LoggerUtils.putToMap(r102, IPerformanceManager.Battery.battery_current, r101.mCurrent);
        LoggerUtils.putToMap(r102, "queue_input_buffer_in_start", r101.mQueueInputBufferCountInStart);
        LoggerUtils.putToMap(r102, "queue_input_buffer_in_end", r101.mQueueInputBufferCountInEnd);
        LoggerUtils.putToMap(r102, "dequeue_output_buffer_in_start", r101.mDequeueOutputBufferCountInStart);
        LoggerUtils.putToMap(r102, "dequeue_output_buffer_in_end", r101.mDequeueOutputBufferCountInEnd);
        LoggerUtils.putToMap(r102, "mc_monitor_queue_in_start", r101.mMcMonitorQueueSizeInStart);
        LoggerUtils.putToMap(r102, "mc_monitor_queue_in_end", r101.mMcMonitorQueueSizeInEnd);
        return new JSONObject(r102);
    L18:
        r105 = -1;
        goto L19
    }

    public void start(int r100, int r101, int r102, long r103, long r110, long r111) {
        this.isStarted = true;
        long r104 = System.currentTimeMillis();
        EventContext r105 = this.mEventContext;
        r105.startTime = r104;
        r105.noRenderType = r100;
        r105.reason = r101;
        VideoEventBase r106 = this.mEventBase;
        if (r106 == null) goto L27;
        EventLoggerSource r107 = r106.mDataSource;
        if (r107 == null) goto L27;
        Map<String, Long> r108 = LoggerUtils.parsePlayerBufferString(r107.getLogValueStr(55));
        if (r108.get(LoggerUtils.KEY_FORMAT_VIDEO_LENGTH) == null) goto L10;
        this.mEventContext.videoFormatLengthMs = r108.get(LoggerUtils.KEY_FORMAT_VIDEO_LENGTH).longValue();
    L10:
        if (r108.get(LoggerUtils.KEY_FORMAT_AUDIO_LENGTH) == null) goto L13;
        this.mEventContext.audioFormatLengthMs = r108.get(LoggerUtils.KEY_FORMAT_AUDIO_LENGTH).longValue();
    L13:
        if (r108.get(LoggerUtils.KEY_DECODER_VIDEO_LENGTH) == null) goto L16;
        this.mEventContext.videoDecoderLengthMs = r108.get(LoggerUtils.KEY_DECODER_VIDEO_LENGTH).longValue();
    L16:
        if (r108.get(LoggerUtils.KEY_DECODER_AUDIO_LENGTH) == null) goto L19;
        this.mEventContext.audioDecoderLengthMs = r108.get(LoggerUtils.KEY_DECODER_AUDIO_LENGTH).longValue();
    L19:
        if (r108.get(LoggerUtils.KEY_BASE_VIDEO_LENGTH) == null) goto L22;
        this.mEventContext.videoBaseLengthMs = r108.get(LoggerUtils.KEY_BASE_VIDEO_LENGTH).longValue();
    L22:
        if (r108.get(LoggerUtils.KEY_BASE_AUDIO_LENGTH) == null) goto L24;
        this.mEventContext.audioBaseLengthMs = r108.get(LoggerUtils.KEY_BASE_AUDIO_LENGTH).longValue();
    L24:
        String r109 = parseNoRenderError(this.mEventBase.mDataSource.getLogValueStr(110));
        if (TextUtils.isEmpty(r109) == true) goto L27;
        this.mEventContext.stageError = r109;
        TTVideoEngineLog.d(TAG, "stage error: " + this.mEventContext.stageError);
    L27:
        EventContext r112 = this.mEventContext;
        r112.mBeginPos = r102;
        if (r103 != 0) goto L30;
        r112.mLastRebufT = r112.startTime;
    L32:
        if (r110 != 0) goto L34;
        r112.mLastSeekT = r112.startTime;
    L36:
        if (r111 <= 0) goto L38;
        r112.mLastHeadsetSwitchInterval = r104 - r111;
    L38:
        VideoEventBase r113 = this.mEventBase;
        if (r113 == null) goto L78;
        r112.mResolutionBefore = r113.mCurrentResolution;
        r112.mQualityDescBefore = r113.mCurrentQualityDesc;
        Map r114 = r113.abrInfo;
        if (r114 == null) goto L45;
        Object r115 = r114.get("abr_used");
        if (r115 == null) goto L45;
        this.mEventContext.mIsABR = ((Integer) r115).intValue();
    L45:
        EventLoggerSource r116 = this.mEventBase.mDataSource;
        if (r116 == null) goto L63;
        this.mEventContext.mIsRadioMode = r116.getLogValueInt(88);
        this.mEventContext.mHeadset = this.mEventBase.mDataSource.getLogValueInt(89);
        this.mEventContext.mBt = this.mEventBase.mDataSource.getLogValueInt(90);
        this.mEventContext.mIsBackground = this.mEventBase.mDataSource.getLogValueInt(94);
        EventContext r117 = this.mEventContext;
        if (r117.noRenderType != 0) goto L50;
        r117.mQueueInputBufferCountInStart = this.mEventBase.mDataSource.getLogValueLong(152);
        this.mEventContext.mDequeueOutputBufferCountInStart = this.mEventBase.mDataSource.getLogValueLong(153);
        this.mEventContext.mMcMonitorQueueSizeInStart = this.mEventBase.mDataSource.getLogValueInt(154);
    L50:
        long r118 = this.mEventBase.mDataSource.getLogValueLong(91);
        if (r118 <= 0) goto L53;
        this.mEventContext.mLastAVSwitchInterval = r104 - r118;
    L53:
        long r119 = this.mEventBase.mDataSource.getLogValueLong(92);
        if (r119 <= 0) goto L56;
        this.mEventContext.mLastResSwitchInterval = r104 - r119;
    L56:
        long r120 = this.mEventBase.mDataSource.getLogValueLong(95);
        if (r120 <= 0) goto L59;
        this.mEventContext.mLastForebackSwitchInterval = r104 - r120;
    L59:
        long r121 = this.mEventBase.mDataSource.getLogValueLong(112);
        if (r121 <= 0) goto L62;
        this.mEventContext.mLastSetSurfaceNullInterval = r104 - r121;
    L62:
        this.mEventContext.mEnableGloablMuteFeature = this.mEventBase.mDataSource.getLogValueInt(121);
        this.mEventContext.mGlobalMute = this.mEventBase.mDataSource.getLogValueInt(122);
    L63:
        VideoEventBase r122 = this.mEventBase;
        if (r122.mEnablePowerReport == false) goto L73;
        double r123 = r122.getCPURate();
        double r124 = this.mEventBase.getCPUSpeed();
        if (r123 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L68;
    L70:
        EngineThreadPool.addExecuteTask(new StatisticDataRunnable(this.mEventContext, this.mEventBase));
    L71:
        this.mEventContext.mCurrent = this.mEventBase.getBatteryCurrent();
        goto L73
    L68:
        if (r124 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L70;
        EventContext r125 = this.mEventContext;
        r125.mCpuRate = r123;
        r125.mCpuSpeed = r124;
    L73:
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 2) == true) goto L79;
        int r126 = DeviceMonitorUtils.isPowerSaveMode(this.mEventBase.mContext);
        if (r126 < 0) goto L80;
        this.mEventContext.mPowerSaveMode = r126;
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L34:
        r112.mLastSeekT = r110;
        goto L36
    L30:
        r112.mLastRebufT = r103;
        goto L32
    }
}
