package com.ss.ttvideoengine.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResult;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultItem;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEventSampleRecord {
    private static final String TAG = "VideoEventSampleRecord";
    public static final boolean enableBitrateMap = true;
    public static final String monitorName = "videoplayer_sample";
    public VideoEventBase mEventBase;
    private EventContext mEventContext;
    public boolean mIsStarted;
    private long mLastAudioDownBytes;
    private long mLastAudioTotalCachedLen;
    private long mLastVideoDownBytes;
    private long mLastVideoTotalCachedLen;
    private final ReentrantLock mLock;
    public int mMaxWindowSize;
    public float mSampingRate;
    public int mSampleInterval;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.log.VideoEventSampleRecord$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AsyncGetLogDataRunnable implements Runnable {
        private Context rContext;
        private VideoEventSampleRecord rEvent;
        private VideoEventBase rEventBase;
        private EventContext rEventContext;
        private Handler rHandler;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_VideoEventSampleRecord$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_VideoEventSampleRecord$AsyncGetLogDataRunnable__run$___twin___() {
            VideoEventSampleRecord r100 = this.rEvent;
            if (r100 != null) goto L5;
            return;
        L5:
            final JSONObject r101 = VideoEventSampleRecord.access$100(r100, this.rEventContext);
            Handler r102 = this.rHandler;
            if (r102 != null) goto L8;
        L12:
            VideoEventManager.instance.addEventV2(true, r101, VideoEventSampleRecord.monitorName);
            return;
        L8:
            if (r102.getLooper() == null) goto L12;
            this.rHandler.post(new AnonymousClass1(this, r101));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_VideoEventSampleRecord$AsyncGetLogDataRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AsyncGetLogDataRunnable r100) {
            r100.com_ss_ttvideoengine_log_VideoEventSampleRecord$AsyncGetLogDataRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AsyncGetLogDataRunnable(Context r100, VideoEventSampleRecord r101, VideoEventBase r102, EventContext r103) {
            this.rEvent = r101;
            this.rEventBase = r102;
            this.rContext = r100;
            this.rEventContext = r103;
            this.rHandler = new Handler(Looper.getMainLooper());
        }
    }

    public class EventContext {
        public ArrayList<Integer> audio_biterate_set;
        public ArrayList<Long> audio_downLoad_cost_time_set;
        public ArrayList<Integer> audio_download_bitrate_set;
        public ArrayList<Float> audio_download_size_set;
        public ArrayList<Integer> audio_play_bitrate_set;
        public ArrayList<String> audio_predict_speed_load_type_set;
        public ArrayList<Float> audio_predict_speed_set;
        public ArrayList<String> audio_protocol_set;
        public int audio_sample_count;
        public ArrayList<Integer> audio_sample_interval;
        public ArrayList<String> audio_speed_load_type_set;
        public ArrayList<Float> audio_speed_set;
        public ArrayList<Long> audio_tcpinfo_lastRevDate;
        public ArrayList<Long> audio_tcpinfo_rtt_set;
        public JSONObject bitrate_compress_table;
        public ArrayList<Long> buffer_len_set;
        public int index;
        public int is_abr;
        public int is_multi_dimensions;
        public int is_multi_dimensions_input;
        public int is_select;
        public long local_time_ms;
        public ArrayList<Integer> play_pos_set;
        public ArrayList<Float> play_speed_set;
        public String player_sessionid;
        public int sample_interval;
        final /* synthetic */ VideoEventSampleRecord this$0;
        public String url;
        public ArrayList<Integer> video_biterate_set;
        public ArrayList<Long> video_downLoad_cost_time_set;
        public ArrayList<Integer> video_download_bitrate_set;
        public ArrayList<Float> video_download_size_set;
        public String video_id;
        public ArrayList<Integer> video_play_bitrate_set;
        public ArrayList<String> video_predict_speed_load_type_set;
        public ArrayList<Float> video_predict_speed_set;
        public ArrayList<String> video_protocol_set;
        public int video_sample_count;
        public ArrayList<Integer> video_sample_interval;
        public ArrayList<String> video_speed_load_type_set;
        public ArrayList<Float> video_speed_set;
        public ArrayList<Long> video_tcpinfo_lastRevDate;
        public ArrayList<Long> video_tcpinfo_rtt_set;
        public String vtype;

        private EventContext(VideoEventSampleRecord r100) {
            this.this$0 = r100;
            this.local_time_ms = SieveCacheKt.NodeMetaAndPreviousMask;
            this.is_abr = -1;
            this.is_select = -1;
            this.sample_interval = Integer.MIN_VALUE;
            this.video_sample_count = 0;
            this.video_sample_interval = new ArrayList();
            this.video_speed_set = new ArrayList();
            this.video_speed_load_type_set = new ArrayList();
            this.video_predict_speed_set = new ArrayList();
            this.video_predict_speed_load_type_set = new ArrayList();
            this.video_play_bitrate_set = new ArrayList();
            this.video_download_bitrate_set = new ArrayList();
            this.video_download_size_set = new ArrayList();
            this.video_downLoad_cost_time_set = new ArrayList();
            this.video_tcpinfo_rtt_set = new ArrayList();
            this.video_tcpinfo_lastRevDate = new ArrayList();
            this.video_protocol_set = new ArrayList();
            this.audio_sample_count = 0;
            this.audio_sample_interval = new ArrayList();
            this.audio_speed_set = new ArrayList();
            this.audio_speed_load_type_set = new ArrayList();
            this.audio_predict_speed_set = new ArrayList();
            this.audio_predict_speed_load_type_set = new ArrayList();
            this.audio_play_bitrate_set = new ArrayList();
            this.audio_download_bitrate_set = new ArrayList();
            this.audio_download_size_set = new ArrayList();
            this.audio_downLoad_cost_time_set = new ArrayList();
            this.audio_tcpinfo_rtt_set = new ArrayList();
            this.audio_tcpinfo_lastRevDate = new ArrayList();
            this.audio_protocol_set = new ArrayList();
            this.buffer_len_set = new ArrayList();
            this.play_speed_set = new ArrayList();
            this.play_pos_set = new ArrayList();
            this.index = 0;
            this.player_sessionid = "";
            this.video_id = "";
            this.url = "";
            this.video_biterate_set = new ArrayList();
            this.audio_biterate_set = new ArrayList();
            this.vtype = "";
            this.is_multi_dimensions = -1;
            this.is_multi_dimensions_input = -1;
        }

        public /* synthetic */ EventContext(VideoEventSampleRecord r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private void _popHead() {
        EventContext r100 = this.mEventContext;
        int r101 = r100.video_sample_count;
        int r102 = this.mMaxWindowSize;
        if (r101 > r102) goto L7;
        if (r100.audio_sample_count > r102) goto L7;
        return;
    L7:
        if (r100.play_pos_set.isEmpty() == true) goto L10;
        ListProtector.remove(this.mEventContext.play_pos_set, 0);
    L10:
        if (this.mEventContext.buffer_len_set.isEmpty() == true) goto L13;
        ListProtector.remove(this.mEventContext.buffer_len_set, 0);
    L13:
        if (this.mEventContext.play_speed_set.isEmpty() == true) goto L16;
        ListProtector.remove(this.mEventContext.play_speed_set, 0);
    L16:
        if (this.mEventContext.video_sample_interval.isEmpty() == true) goto L19;
        ListProtector.remove(this.mEventContext.video_sample_interval, 0);
    L19:
        if (this.mEventContext.video_speed_set.isEmpty() == true) goto L22;
        ListProtector.remove(this.mEventContext.video_speed_set, 0);
    L22:
        if (this.mEventContext.video_speed_load_type_set.isEmpty() == true) goto L25;
        ListProtector.remove(this.mEventContext.video_speed_load_type_set, 0);
    L25:
        if (this.mEventContext.video_predict_speed_set.isEmpty() == true) goto L28;
        ListProtector.remove(this.mEventContext.video_predict_speed_set, 0);
    L28:
        if (this.mEventContext.video_predict_speed_load_type_set.isEmpty() == true) goto L31;
        ListProtector.remove(this.mEventContext.video_predict_speed_load_type_set, 0);
    L31:
        if (this.mEventContext.video_download_bitrate_set.isEmpty() == true) goto L34;
        ListProtector.remove(this.mEventContext.video_download_bitrate_set, 0);
    L34:
        if (this.mEventContext.video_play_bitrate_set.isEmpty() == true) goto L37;
        ListProtector.remove(this.mEventContext.video_play_bitrate_set, 0);
    L37:
        if (this.mEventContext.video_download_size_set.isEmpty() == true) goto L40;
        ListProtector.remove(this.mEventContext.video_download_size_set, 0);
    L40:
        if (this.mEventContext.video_downLoad_cost_time_set.isEmpty() == true) goto L43;
        ListProtector.remove(this.mEventContext.video_downLoad_cost_time_set, 0);
    L43:
        if (this.mEventContext.video_tcpinfo_rtt_set.isEmpty() == true) goto L46;
        ListProtector.remove(this.mEventContext.video_tcpinfo_rtt_set, 0);
    L46:
        if (this.mEventContext.video_tcpinfo_lastRevDate.isEmpty() == true) goto L49;
        ListProtector.remove(this.mEventContext.video_tcpinfo_lastRevDate, 0);
    L49:
        if (this.mEventContext.video_protocol_set.isEmpty() == true) goto L51;
        ListProtector.remove(this.mEventContext.video_protocol_set, 0);
    L51:
        EventContext r103 = this.mEventContext;
        r103.video_sample_count--;
        if (r103.audio_sample_interval.isEmpty() == true) goto L55;
        ListProtector.remove(this.mEventContext.audio_sample_interval, 0);
    L55:
        if (this.mEventContext.audio_speed_set.isEmpty() == true) goto L58;
        ListProtector.remove(this.mEventContext.audio_speed_set, 0);
    L58:
        if (this.mEventContext.audio_speed_load_type_set.isEmpty() == true) goto L61;
        ListProtector.remove(this.mEventContext.audio_speed_load_type_set, 0);
    L61:
        if (this.mEventContext.audio_predict_speed_set.isEmpty() == true) goto L64;
        ListProtector.remove(this.mEventContext.audio_predict_speed_set, 0);
    L64:
        if (this.mEventContext.audio_predict_speed_load_type_set.isEmpty() == true) goto L67;
        ListProtector.remove(this.mEventContext.audio_predict_speed_load_type_set, 0);
    L67:
        if (this.mEventContext.audio_play_bitrate_set.isEmpty() == true) goto L70;
        ListProtector.remove(this.mEventContext.audio_play_bitrate_set, 0);
    L70:
        if (this.mEventContext.audio_download_bitrate_set.isEmpty() == true) goto L73;
        ListProtector.remove(this.mEventContext.audio_download_bitrate_set, 0);
    L73:
        if (this.mEventContext.audio_download_size_set.isEmpty() == true) goto L76;
        ListProtector.remove(this.mEventContext.audio_download_size_set, 0);
    L76:
        if (this.mEventContext.audio_downLoad_cost_time_set.isEmpty() == true) goto L79;
        ListProtector.remove(this.mEventContext.audio_downLoad_cost_time_set, 0);
    L79:
        if (this.mEventContext.audio_tcpinfo_rtt_set.isEmpty() == true) goto L82;
        ListProtector.remove(this.mEventContext.audio_tcpinfo_rtt_set, 0);
    L82:
        if (this.mEventContext.audio_tcpinfo_lastRevDate.isEmpty() == true) goto L85;
        ListProtector.remove(this.mEventContext.audio_tcpinfo_lastRevDate, 0);
    L85:
        if (this.mEventContext.audio_protocol_set.isEmpty() == true) goto L87;
        ListProtector.remove(this.mEventContext.audio_protocol_set, 0);
    L87:
        this.mEventContext.audio_sample_count--;
    }

    private void _updateEventBaseInfo() {
        VideoEventBase r100 = this.mEventBase;
        if (r100 == null) goto L30;
        EventLoggerSource r101 = r100.mDataSource;
        if (r101 == null) goto L28;
        this.mEventContext.play_pos_set.add(Integer.valueOf(r101.getLogValueInt(67)));
        this.mEventContext.buffer_len_set.add(Long.valueOf(this.mEventBase.mDataSource.getLogValueLong(68)));
        Map r102 = this.mEventBase.getVideoInfo();
        if (r102 == null) goto L28;
        Map r103 = (Map) r102.get("bitrate");
        if (r103 == null) goto L17;
        Integer r104 = (Integer) r103.get(this.mEventBase.mCurrentResolution);
        if (r104 != null) goto L14;
        this.mEventContext.video_play_bitrate_set.add(-1);
        goto L17
    L14:
        if (r104.intValue() != 0) goto L16;
        this.mEventContext.video_play_bitrate_set.add(-1);
        goto L17
    L16:
        this.mEventContext.video_play_bitrate_set.add(_doBitrateMap(r104));
    L17:
        ArrayList r105 = (ArrayList) r102.get(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE);
        if (r105 == null) goto L28;
        if (r105.isEmpty() == true) goto L28;
        if (ListProtector.get(r105, 0) != null) goto L25;
        this.mEventContext.audio_play_bitrate_set.add(-1);
        goto L28
    L25:
        if (((Integer) ListProtector.get(r105, 0)).intValue() != 0) goto L27;
        this.mEventContext.audio_play_bitrate_set.add(-1);
        goto L28
    L27:
        this.mEventContext.audio_play_bitrate_set.add(_doBitrateMap((Integer) ListProtector.get(r105, 0)));
    L28:
        this.mEventContext.play_speed_set.add(Float.valueOf(this.mEventBase.mPlaySpeed));
        return;
    }

    private boolean checkCurrentPlayBackVideoIsLegal() {
        Map r100 = this.mEventBase.getVideoInfo();
        if (r100 != null) goto L5;
        return false;
    L5:
        Map r101 = (Map) r100.get("fileKey");
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L17;
        Iterator r103 = r101.values().iterator();
    L9:
        if (r103.hasNext() == false) goto L17;
        String r104 = (String) r103.next();
        if (r104.equals("") == true) goto L16;
        if (r104.equals("0") == true) goto L16;
        r102.add(r104);
    L16:
        return false;
    L17:
        int r105 = 0;
    L19:
        if (r105 >= r102.size()) goto L27;
        String r106 = (String) ListProtector.get(r102, r105);
        r105 = r105 + 1;
        int r107 = r105;
    L22:
        if (r107 >= r102.size()) goto L19;
        if (r106.equals(ListProtector.get(r102, r107)) == true) goto L25;
        r107 = r107 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    }

    public void stopRecord() {
        this.mLock.lock();
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mIsStarted == false) goto L6;
        this.mIsStarted = false;     // Catch: Throwable -> L8
        _sendEvent(1);     // Catch: Throwable -> L8
    L6:
        this.mLock.unlock();
    }

    public void startRecord() {
        if (Math.random() <= this.mSampingRate) goto L5;
        this.mIsStarted = false;
        return;
    L5:
        this.mIsStarted = true;
    }

    public VideoEventSampleRecord(VideoEventBase r100) {
        this.mMaxWindowSize = 200;
        this.mSampingRate = 0.0f;
        this.mIsStarted = false;
        this.mSampleInterval = Integer.MIN_VALUE;
        this.mLastVideoDownBytes = 0;
        this.mLastAudioDownBytes = 0;
        this.mLastVideoTotalCachedLen = 0;
        this.mLastAudioTotalCachedLen = 0;
        this.mEventContext = null;
        this.mEventBase = null;
        this.mLock = new ReentrantLock();
        this.mEventContext = new EventContext(this, null);
        this.mEventBase = r100;
    }

    private Integer _doBitrateMap(Integer r100) {
        VideoEventBase r101 = this.mEventBase;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Map r102 = r101.getVideoInfo();
        if (r102 != null) goto L8;
        return r100;
    L8:
        Map r103 = (Map) r102.get("bitrateMapTable");
        if (r103 != null) goto L11;
        return r100;
    L11:
        if (((Integer) r103.get(r100)) != null) goto L15;
        return -1;
    L15:
        return (Integer) r103.get(r100);
    }

    private void _sendEvent(int r100) {
        EventContext r101 = this.mEventContext;
        if (r101.video_sample_count == 0) goto L5;
    L9:
        EventContext r102 = this.mEventContext;
        r102.local_time_ms = System.currentTimeMillis();
        EventContext r103 = this.mEventContext;
        r103.sample_interval = this.mSampleInterval;
        VideoEventBase r104 = this.mEventBase;
        if (r104 == null) goto L37;
        r103.is_abr = r104.is_enable_abr;
        r103.is_select = r104.is_enable_select_bitrate;
        r103.is_multi_dimensions = r104.is_multi_dimensions;
        r103.is_multi_dimensions_input = r104.is_multi_dimensionsInput;
        r103.player_sessionid = r104.mSessionID;
        r103.video_id = r104.mVid;
        r103.url = r104.mCurURL;
        r103.vtype = r104.vtype;
        Map r105 = r104.getVideoInfo();
        if (r105 != null) goto L14;
    L23:
        if (r105 != null) goto L25;
    L30:
        if (r105 == null) goto L37;
        if (r105.get(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE) == null) goto L37;
        Iterator r106 = ((ArrayList) r105.get(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE)).iterator();
    L35:
        if (r106.hasNext() == false) goto L37;
        Integer r107 = (Integer) r106.next();
        this.mEventContext.audio_biterate_set.add(r107);
        goto L35
    L25:
        if (r105.get(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE) == null) goto L30;
        Iterator r108 = ((ArrayList) r105.get(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE)).iterator();
    L28:
        if (r108.hasNext() == false) goto L30;
        Integer r109 = (Integer) r108.next();
        this.mEventContext.video_biterate_set.add(r109);
        goto L28
    L14:
        if (r105.get("bitrateMapTable") == null) goto L23;
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L21
        Iterator r111 = ((Map) r105.get("bitrateMapTable")).entrySet().iterator();     // Catch: Exception -> L21
    L17:
        if (r111.hasNext() == false) goto L19;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: Exception -> L21
        r110.put(((Integer) r112.getKey()).toString(), r112.getValue());     // Catch: Exception -> L21
        goto L17
    L19:
        this.mEventContext.bitrate_compress_table = r110;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L37:
        VideoEventBase r113 = this.mEventBase;
        EngineThreadPool.addExecuteTask(new AsyncGetLogDataRunnable(r113.mContext, this, r113, this.mEventContext));
        EventContext r114 = new EventContext(this, null);
        this.mEventContext = r114;
        if (r100 != 0) goto L46;
        r114.index = 1;
        return;
    L46:
        return;
    L5:
        if (r101.audio_sample_count != 0) goto L9;
        if (checkCurrentPlayBackVideoIsLegal() == true) goto L9;
    }

    private JSONObject toJsonObject(EventContext r100) {
        HashMap r101 = new HashMap();
        LoggerUtils.putToMap(r101, "local_time_ms", r100.local_time_ms);
        LoggerUtils.putToMap(r101, "is_abr", r100.is_abr);
        LoggerUtils.putToMap(r101, "is_select", r100.is_select);
        LoggerUtils.putToMap(r101, "vtype", r100.vtype);
        LoggerUtils.putToMap(r101, "sample_interval", r100.sample_interval);
        LoggerUtils.putToMap(r101, "video_sample_count", r100.video_sample_count);
        LoggerUtils.putToMap(r101, "video_sample_interval", r100.video_sample_interval);
        LoggerUtils.putToMap(r101, "video_network_speed_sampling_set", r100.video_speed_set);
        LoggerUtils.putToMap(r101, "video_network_speed_sampling_load_types", r100.video_speed_load_type_set);
        LoggerUtils.putToMap(r101, "video_network_speed_predict_set", r100.video_predict_speed_set);
        LoggerUtils.putToMap(r101, "video_network_speed_predict_load_types", r100.video_predict_speed_load_type_set);
        LoggerUtils.putToMap(r101, "video_play_bitrate_set", r100.video_play_bitrate_set);
        LoggerUtils.putToMap(r101, "video_download_bitrate_set", r100.video_download_bitrate_set);
        LoggerUtils.putToMap(r101, "video_download_size_set", r100.video_download_size_set);
        LoggerUtils.putToMap(r101, "video_download_costtime_set", r100.video_downLoad_cost_time_set);
        LoggerUtils.putToMap(r101, "video_tcpInfo_rtt_set", r100.video_tcpinfo_rtt_set);
        LoggerUtils.putToMap(r101, "video_tcpInfo_lastRecvDate", r100.video_tcpinfo_lastRevDate);
        LoggerUtils.putToMap(r101, "video_mdl_loader_type", r100.video_protocol_set);
        LoggerUtils.putToMap(r101, "audio_sample_count", r100.audio_sample_count);
        LoggerUtils.putToMap(r101, "audio_sample_interval", r100.audio_sample_interval);
        LoggerUtils.putToMap(r101, "audio_network_speed_sampling_set", r100.audio_speed_set);
        LoggerUtils.putToMap(r101, "audio_network_speed_sampling_load_types", r100.audio_speed_load_type_set);
        LoggerUtils.putToMap(r101, "audio_network_speed_predict_set", r100.audio_predict_speed_set);
        LoggerUtils.putToMap(r101, "audio_network_speed_predict_load_types", r100.audio_predict_speed_load_type_set);
        LoggerUtils.putToMap(r101, "audio_play_bitrate_set", r100.audio_play_bitrate_set);
        LoggerUtils.putToMap(r101, "audio_download_bitrate_set", r100.audio_download_bitrate_set);
        LoggerUtils.putToMap(r101, "audio_download_size_set", r100.audio_download_size_set);
        LoggerUtils.putToMap(r101, "audio_download_costtime_set", r100.audio_downLoad_cost_time_set);
        LoggerUtils.putToMap(r101, "audio_tcpInfo_rtt_set", r100.audio_tcpinfo_rtt_set);
        LoggerUtils.putToMap(r101, "audio_tcpInfo_lastRecvDate", r100.audio_tcpinfo_lastRevDate);
        LoggerUtils.putToMap(r101, "audio_mdl_loader_type", r100.audio_protocol_set);
        LoggerUtils.putToMap(r101, "buffer_len_set", r100.buffer_len_set);
        LoggerUtils.putToMap(r101, "play_speed_set", r100.play_speed_set);
        LoggerUtils.putToMap(r101, "play_pos_set", r100.play_pos_set);
        LoggerUtils.putToMap(r101, "index", r100.index);
        LoggerUtils.putToMap(r101, "player_sessionid", r100.player_sessionid);
        LoggerUtils.putToMap(r101, "video_id", r100.video_id);
        LoggerUtils.putToMap(r101, "video_bitrate_set", r100.video_biterate_set);
        LoggerUtils.putToMap(r101, "audio_bitrate_set", r100.audio_biterate_set);
        LoggerUtils.putToMap(r101, "is_multi_dimensions", r100.is_multi_dimensions);
        LoggerUtils.putToMap(r101, "is_multi_dimensions_input", r100.is_multi_dimensions_input);
        JSONObject r102 = new JSONObject(r101);
        r102.put("bitrate_map_table", r100.bitrate_compress_table);     // Catch: Exception -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setInterval(int r100) {
        if (r100 <= 0) goto L5;
        this.mSampleInterval = r100;
        return;
    }

    public void setMaxWindowSize(int r100) {
        if (r100 <= 0) goto L5;
        this.mMaxWindowSize = r100;
        return;
    }

    public void setSamplingRate(float r100) {
        this.mSampingRate = r100;
    }

    private void _addResultItemToPredictorSet(SpeedPredictorResult r100, Integer r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<SpeedPredictorResultItem> r102 = r100.getResultItems().iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        SpeedPredictorResultItem r103 = r102.next();
        String r104 = String.format("%s|%s|%s|%s", new Object[]{r103.getLoadType(), r103.getHost(), String.valueOf(r101), String.valueOf(this.mEventBase.speed_predict_type)});
        if (r103.getTrackType() == 0) goto L9;
        if (r103.getTrackType() != 1) goto L6;
        this.mEventContext.audio_predict_speed_set.add(Float.valueOf(r103.getBandwidth()));
        this.mEventContext.audio_predict_speed_load_type_set.add(r104);
        goto L6
    L9:
        this.mEventContext.video_predict_speed_set.add(Float.valueOf(r103.getBandwidth()));
        this.mEventContext.video_predict_speed_load_type_set.add(r104);
        goto L6
    }

    public static /* synthetic */ JSONObject access$100(VideoEventSampleRecord r100, EventContext r101) {
        return r100.toJsonObject(r101);
    }

    public void addExtraMapInfoForTrackType(Map<String, String> r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() > 0) goto L6;
        return;
    L6:
        if (r101 <= 1) goto L9;
        return;
    L9:
        if (r101 != 0) goto L21;
        String r102 = r100.get(TTDelegateActivity.DOWNLOAD_SIZE);
        String r103 = r100.get("download_time");
        String r104 = r100.get("rtt");
        String r105 = r100.get("last_data_recv");
        String r106 = r100.get("mdl_loader_type");
        if (r102 == null) goto L13;
        this.mEventContext.video_download_size_set.add(Float.valueOf(CastFloatProtector.parseFloat(r102)));
    L13:
        if (r103 == null) goto L15;
        this.mEventContext.video_downLoad_cost_time_set.add(Long.valueOf(CastLongProtector.parseLong(r103)));
    L15:
        if (r104 == null) goto L17;
        this.mEventContext.video_tcpinfo_rtt_set.add(Long.valueOf(CastLongProtector.parseLong(r104)));
    L17:
        if (r105 == null) goto L19;
        this.mEventContext.video_tcpinfo_lastRevDate.add(Long.valueOf(CastLongProtector.parseLong(r105)));
    L19:
        if (r106 == null) goto L36;
        this.mEventContext.video_protocol_set.add(r106);
        return;
    L36:
        return;
    L21:
        if (r101 != 1) goto L38;
        String r107 = r100.get(TTDelegateActivity.DOWNLOAD_SIZE);
        String r108 = r100.get("download_time");
        String r109 = r100.get("rtt");
        String r110 = r100.get("last_data_recv");
        String r111 = r100.get("mdl_loader_type");
        if (r107 == null) goto L25;
        this.mEventContext.audio_download_size_set.add(Float.valueOf(CastFloatProtector.parseFloat(r107)));
    L25:
        if (r108 == null) goto L27;
        this.mEventContext.audio_downLoad_cost_time_set.add(Long.valueOf(CastLongProtector.parseLong(r108)));
    L27:
        if (r109 == null) goto L29;
        this.mEventContext.audio_tcpinfo_rtt_set.add(Long.valueOf(CastLongProtector.parseLong(r109)));
    L29:
        if (r110 == null) goto L31;
        this.mEventContext.audio_tcpinfo_lastRevDate.add(Long.valueOf(CastLongProtector.parseLong(r110)));
    L31:
        if (r111 == null) goto L39;
        this.mEventContext.audio_protocol_set.add(r111);
        return;
    L39:
        return;
    }

    public void updateNetworkMutiSpeed(SpeedPredictorResultCollection r110, SpeedPredictorResultCollection r111, long r112) {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        if (this.mEventBase == null) goto L70;
        if (r110 == null) goto L71;
        if (r111 == null) goto L75;
        _updateEventBaseInfo();
        Map r100 = this.mEventBase.getVideoInfo();
        if (r100 != null) goto L12;
        return;
    L12:
        Map r101 = (Map) r100.get("fileKey");
        if (r101 != null) goto L15;
        return;
    L15:
        if (r101.isEmpty() == true) goto L76;
        Boolean r102 = Boolean.FALSE;
        Boolean[] r103 = {r102};
        Boolean[] r113 = {r102};
        Iterator r114 = r101.entrySet().iterator();
    L19:
        if (r114.hasNext() == false) goto L50;
        Map.Entry r115 = (Map.Entry) r114.next();
        String r116 = (String) r115.getValue();
        Iterator<SpeedPredictorResult> r117 = r110.getResultCollection().iterator();
    L22:
        if (r117.hasNext() == false) goto L44;
        SpeedPredictorResult r104 = r117.next();
        if (r104.getFileId().equals(r116) == false) goto L22;
        if (r104.getResultItems().isEmpty() == false) goto L28;
    L43:
        _addResultItemToSampleSet(r104, (Integer) r115.getKey(), r112, r103, r113);
        goto L22
    L28:
        if (((SpeedPredictorResultItem) ListProtector.get(r104.getResultItems(), 0)).getTrackType() != 0) goto L37;
        if (r115.getKey() != null) goto L33;
        this.mEventContext.video_download_bitrate_set.add(-1);
        goto L43
    L33:
        if (((Integer) r115.getKey()).intValue() != 0) goto L35;
        this.mEventContext.video_download_bitrate_set.add(-1);
        goto L43
    L35:
        this.mEventContext.video_download_bitrate_set.add(_doBitrateMap((Integer) r115.getKey()));
        goto L43
    L37:
        if (r115.getKey() != null) goto L40;
        this.mEventContext.audio_download_bitrate_set.add(-1);
        goto L43
    L40:
        if (((Integer) r115.getKey()).intValue() != 0) goto L42;
        this.mEventContext.audio_download_bitrate_set.add(-1);
        goto L43
    L42:
        this.mEventContext.audio_download_bitrate_set.add(_doBitrateMap((Integer) r115.getKey()));
        goto L43
    L44:
        Iterator<SpeedPredictorResult> r105 = r111.getResultCollection().iterator();
    L46:
        if (r105.hasNext() == false) goto L19;
        SpeedPredictorResult r106 = r105.next();
        if (r106.getFileId().equals(r116) == false) goto L46;
        _addResultItemToPredictorSet(r106, (Integer) r115.getKey());
        goto L46
    L50:
        EventContext r107 = this.mEventContext;
        int r108 = r107.video_sample_count + 1;
        r107.video_sample_count = r108;
        int r109 = r107.audio_sample_count + 1;
        r107.audio_sample_count = r109;
        int r118 = this.mMaxWindowSize;
        if (r108 >= r118) goto L54;
        if (r109 >= r118) goto L54;
        return;
    L54:
        if (r107.index != 0) goto L56;
        _sendEvent(0);
        return;
    L56:
        _popHead();
        return;
    L76:
        return;
    L75:
        return;
    L71:
        return;
    }

    private void _addResultItemToSampleSet(SpeedPredictorResult r100, Integer r101, long r102, Boolean[] r110, Boolean[] r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<SpeedPredictorResultItem> r103 = r100.getResultItems().iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        SpeedPredictorResultItem r104 = r103.next();
        String r105 = String.format("%s|%s|%s", new Object[]{r104.getLoadType(), r104.getHost(), String.valueOf(r101)});
        if (r104.getTrackType() == 0) goto L9;
        if (r104.getTrackType() != 1) goto L6;
        this.mEventContext.audio_speed_set.add(Float.valueOf(r104.getBandwidth()));
        this.mEventContext.audio_speed_load_type_set.add(r105);
        if (r111[0].booleanValue() == false) goto L17;
        this.mEventContext.audio_sample_interval.add(0);
        goto L6
    L17:
        this.mEventContext.audio_sample_interval.add(Integer.valueOf((int) r102));
        r111[0] = Boolean.TRUE;
        goto L6
    L9:
        this.mEventContext.video_speed_set.add(Float.valueOf(r104.getBandwidth()));
        this.mEventContext.video_speed_load_type_set.add(r105);
        if (r110[0].booleanValue() == false) goto L11;
        this.mEventContext.video_sample_interval.add(0);
        goto L6
    L11:
        this.mEventContext.video_sample_interval.add(Integer.valueOf((int) r102));
        r110[0] = Boolean.TRUE;
        goto L6
    }

    public void updateNetworkSpeed(String r110, String r111, float r112, float r113, float r114, float r115, long r210, Map<String, String> r211, Map<String, String> r212) {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        if (this.mEventBase == null) goto L65;
        _updateEventBaseInfo();
        String r100 = String.valueOf(this.mEventBase.speed_predict_type);
        if (this.mEventBase != null) goto L10;
    L47:
        EventContext r101 = this.mEventContext;
        r101.video_sample_count++;
        r101.audio_sample_count++;
        TTVideoEngineLog.d(TAG, "brian video count:" + this.mEventContext.video_sample_count + ",audio count:" + this.mEventContext.audio_sample_count);
        EventContext r102 = this.mEventContext;
        int r103 = r102.video_sample_count;
        int r104 = this.mMaxWindowSize;
        if (r103 >= r104) goto L52;
        if (r102.audio_sample_count >= r104) goto L52;
        return;
    L52:
        if (r102.index != 0) goto L54;
        _sendEvent(0);
        return;
    L54:
        _popHead();
        return;
    L10:
        if (TextUtils.isEmpty(r110) == true) goto L47;
        if (TextUtils.isEmpty(r111) == true) goto L47;
        Map r105 = this.mEventBase.getVideoInfo();
        if (r105 == null) goto L47;
        if (r110.equals("-1") == true) goto L47;
        if (r111.equals("-1") == true) goto L47;
        Map r106 = (Map) r105.get("fileKey");
        if (r106 != null) goto L22;
        r106 = new HashMap();
    L22:
        Iterator r107 = r106.entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L47;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (((String) r108.getValue()).equals(r110) == false) goto L37;
        if (r108.getKey() != null) goto L31;
        this.mEventContext.video_download_bitrate_set.add(-1);
    L34:
        this.mEventContext.video_sample_interval.add(Integer.valueOf((int) r210));
        this.mEventContext.video_speed_set.add(Float.valueOf(r112));
        this.mEventContext.video_predict_speed_set.add(Float.valueOf(r114));
        this.mEventContext.video_predict_speed_load_type_set.add(r100);
        addExtraMapInfoForTrackType(r211, 0);
        goto L37
    L31:
        if (((Integer) r108.getKey()).intValue() != 0) goto L33;
        this.mEventContext.video_download_bitrate_set.add(-1);
        goto L34
    L33:
        this.mEventContext.video_download_bitrate_set.add(_doBitrateMap((Integer) r108.getKey()));
    L37:
        if (((String) r108.getValue()).equals(r111) == false) goto L24;
        if (r108.getKey() != null) goto L42;
        this.mEventContext.audio_download_bitrate_set.add(-1);
    L45:
        this.mEventContext.audio_sample_interval.add(Integer.valueOf((int) r210));
        this.mEventContext.audio_speed_set.add(Float.valueOf(r113));
        this.mEventContext.audio_predict_speed_set.add(Float.valueOf(r115));
        this.mEventContext.audio_predict_speed_load_type_set.add(r100);
        addExtraMapInfoForTrackType(r212, 1);
        goto L24
    L42:
        if (((Integer) r108.getKey()).intValue() != 0) goto L44;
        this.mEventContext.audio_download_bitrate_set.add(-1);
        goto L45
    L44:
        this.mEventContext.audio_download_bitrate_set.add(_doBitrateMap((Integer) r108.getKey()));
        goto L45
    }
}
