package com.ss.ttvideoengine.log;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.map.api.data.MapInfoConst;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.utils.SessionIDGenerator;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoEventBase {
    private static final String TAG = "VideoEventBase";
    public static String appSessionId = null;
    public static volatile String gNetworkType = "unknown";
    public static volatile String gSigStrength = "unknown";
    private static TTNetWorkListener mTTNetWorkListener;
    public String a_codec_type;
    public Map<String, Object> abrGeneralInfo;
    public Map abrInfo;
    public String abr_version;
    public int audioCodecNameId;
    public String codec_type;
    public String dynamic_type;
    public String ffmpeg_version;
    public int formatType;
    public boolean hasAudioTrackInfo;
    public boolean isUploadLogEnabled;
    public int is_enable_abr;
    public int is_enable_select_bitrate;
    public int is_multi_dimensions;
    public int is_multi_dimensionsInput;
    public String libvcn_version;
    public int mAudioHwUser;
    public Context mContext;
    public volatile int mCurDashAudioInfoId;
    public String mCurHost;
    public String mCurIP;
    public String mCurQuality;
    public String mCurResolution;
    public String mCurURL;
    public int mCurrentConfigBitrate;
    public String mCurrentQualityDesc;
    public String mCurrentResolution;
    public String mDNSType;
    public EventLoggerSource mDataSource;
    public String mDeviceId;
    public String mDrmTokenUrl;
    public int mDrmType;
    public int mEnableMDL;
    public boolean mEnablePowerReport;
    public boolean mEnableTmpLog;
    public ArrayList<String> mGearinfoList;
    public boolean mHasGetPreloadTraceId;
    public String mInitialHost;
    public String mInitialIP;
    public String mInitialQualityDesc;
    public String mInitialURL;
    public String mLastResolution;
    public String mMdlVersion;
    public String mMediaID;
    private TTNetworkStateCallback mNetWorkChangeCb;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr;
    public String mNetworkType;
    public String mOriginVid;
    public int mP2PCDNType;
    public float mPlaySpeed;
    public int mPlayType;
    public int mReuseSocket;
    public String mSessionID;
    public String mSourceTypeStr;
    public String mSubTag;
    public String mTag;
    public String mTraceID;
    public String mVid;
    public int mVideoHW;
    public int mVideoHWUser;
    private Map mVideoInfo;
    public IVideoModel mVideoModel;
    public MDLTrackInfo mdlAudioInfo;
    public Map mdlFeatures;
    public int mdlP2pLoader;
    public MDLTrackInfo mdlVideoInfo;
    public int mdl_conc_count;
    public int mdl_cur_task_num;
    public String mdl_preload_info;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public String f457072pc;
    public String predict_version;
    public String preload_version;

    /* JADX INFO: renamed from: pv, reason: collision with root package name */
    public String f457073pv;
    public String sdk_version;
    public Map selectResultInfo;
    public int speed_predict_type;

    /* JADX INFO: renamed from: sv, reason: collision with root package name */
    public String f457074sv;
    public String texturender_version;

    /* JADX INFO: renamed from: vd, reason: collision with root package name */
    public int f457075vd;
    public int videoCodecNameId;

    /* JADX INFO: renamed from: vs, reason: collision with root package name */
    public long f457076vs;
    public String vtype;

    public class MDLTrackInfo {
        public String mdl_blocked_ips;
        public int mdl_cache_type;
        public String mdl_cdn_cache;
        public int mdl_cdn_type;
        public String mdl_client_info;
        public long mdl_cur_cache_pos;
        public long mdl_cur_end_pos;
        public String mdl_cur_host;
        public String mdl_cur_ip;
        public long mdl_cur_req_pos;
        public int mdl_cur_soure;
        public String mdl_cur_url;
        public int mdl_disable_seek;
        public long mdl_disk_buffer_len;
        public long mdl_dns_t;
        public long mdl_down_pos;
        public int mdl_downloading;
        public long mdl_end_t;
        public int mdl_error_code;
        public String mdl_extra_info;
        public String mdl_file_key;
        public long mdl_fs;
        public int mdl_http_code;
        public long mdl_http_open_end_t;
        public long mdl_httpfb;
        public String mdl_ip_list;
        public int mdl_is_socrf;
        public String mdl_last_ip_list;
        public String mdl_last_msg;
        public long mdl_last_read_time;
        public long mdl_last_req_offset;
        public long mdl_lbs;
        public int mdl_mem_buffer_len;
        public int mdl_mixed_cdn_type;
        public String mdl_n80_host;
        public int mdl_pcdn_full_speed;
        public int mdl_player_wait_num;
        public long mdl_player_wait_time;
        public String mdl_re_url;
        public int mdl_read_src;
        public long mdl_reply_size;
        public int mdl_req_num;
        public long mdl_req_t;
        public int mdl_res_err;
        public int mdl_seek_num;
        public long mdl_send_offset;
        public String mdl_server_timing;
        public int mdl_speed;
        public int mdl_stage;
        public long mdl_tbs;
        public long mdl_tcp_end_t;
        public long mdl_tcp_start_t;
        public long mdl_ttfp;
        public int mdl_url_index;
        public int mdl_v_lt;
        public int mdl_v_p2p_ier;
        final /* synthetic */ VideoEventBase this$0;

        public MDLTrackInfo(VideoEventBase r100) {
            this.this$0 = r100;
            this.mdl_cur_req_pos = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_cur_end_pos = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_cur_cache_pos = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_cache_type = Integer.MIN_VALUE;
            this.mdl_cur_ip = "";
            this.mdl_cur_host = "";
            this.mdl_cur_url = "";
            this.mdl_reply_size = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_down_pos = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_player_wait_time = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_player_wait_num = Integer.MIN_VALUE;
            this.mdl_stage = Integer.MIN_VALUE;
            this.mdl_error_code = Integer.MIN_VALUE;
            this.mdl_speed = Integer.MIN_VALUE;
            this.mdl_file_key = "";
            this.mdl_is_socrf = Integer.MIN_VALUE;
            this.mdl_url_index = Integer.MIN_VALUE;
            this.mdl_re_url = "";
            this.mdl_cur_soure = Integer.MIN_VALUE;
            this.mdl_extra_info = "";
            this.mdl_http_code = Integer.MIN_VALUE;
            this.mdl_req_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_end_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_dns_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_tcp_start_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_tcp_end_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_ttfp = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_httpfb = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_http_open_end_t = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_fs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_pcdn_full_speed = Integer.MIN_VALUE;
            this.mdl_tbs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_lbs = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_res_err = Integer.MIN_VALUE;
            this.mdl_read_src = Integer.MIN_VALUE;
            this.mdl_seek_num = Integer.MIN_VALUE;
            this.mdl_last_msg = "";
            this.mdl_server_timing = "";
            this.mdl_v_lt = Integer.MIN_VALUE;
            this.mdl_v_p2p_ier = Integer.MIN_VALUE;
            this.mdl_ip_list = "";
            this.mdl_blocked_ips = "";
            this.mdl_req_num = Integer.MIN_VALUE;
            this.mdl_cdn_cache = "";
            this.mdl_client_info = "";
            this.mdl_disable_seek = Integer.MIN_VALUE;
            this.mdl_mem_buffer_len = Integer.MIN_VALUE;
            this.mdl_disk_buffer_len = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_send_offset = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_last_req_offset = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_cdn_type = Integer.MIN_VALUE;
            this.mdl_last_read_time = SieveCacheKt.NodeMetaAndPreviousMask;
            this.mdl_last_ip_list = "";
            this.mdl_downloading = Integer.MIN_VALUE;
            this.mdl_n80_host = "";
            this.mdl_mixed_cdn_type = Integer.MIN_VALUE;
        }

        public void update(JSONObject r100) throws Exception {
            if (TTVideoEngine.sBuryDataOptimize == true) goto L5;
            updateOld(r100);
            return;
        L5:
            updateNew(r100);
        }

        public void updateNew(JSONObject r100) throws Exception {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isNull("err_code") == true) goto L7;
            this.mdl_error_code = ((Number) r100.get("err_code")).intValue();
        L7:
            if (r100.isNull("reply_size") == true) goto L10;
            this.mdl_reply_size = ((Number) r100.get("reply_size")).longValue();
        L10:
            if (r100.isNull("cur_host") == true) goto L13;
            this.mdl_cur_host = r100.get("cur_host").toString();
        L13:
            if (r100.isNull("cur_ip") == true) goto L16;
            this.mdl_cur_ip = r100.get("cur_ip").toString();
        L16:
            if (r100.isNull("speed") == true) goto L19;
            this.mdl_speed = ((Number) r100.get("speed")).intValue();
        L19:
            if (r100.isNull(TTVideoEngineInterface.PLAY_API_KEY_CDNTYPE) == true) goto L22;
            this.mdl_cdn_type = ((Number) r100.get(TTVideoEngineInterface.PLAY_API_KEY_CDNTYPE)).intValue();
        L22:
            if (r100.isNull("url") == true) goto L25;
            this.mdl_cur_url = r100.get("url").toString();
        L25:
            if (r100.isNull("file_key") == true) goto L28;
            this.mdl_file_key = r100.get("file_key").toString();
        L28:
            if (r100.isNull("re_url") == true) goto L31;
            this.mdl_re_url = r100.get("re_url").toString();
        L31:
            if (r100.isNull("end_t") == true) goto L34;
            this.mdl_end_t = ((Number) r100.get("end_t")).longValue();
        L34:
            if (r100.isNull("dns_t") == true) goto L37;
            this.mdl_dns_t = ((Number) r100.get("dns_t")).longValue();
        L37:
            if (r100.isNull("tbs") == true) goto L40;
            this.mdl_tbs = ((Number) r100.get("tbs")).longValue();
        L40:
            if (r100.isNull(MapInfoConst.MAP_SHOT_DIR) == true) goto L43;
            this.mdl_lbs = ((Number) r100.get(MapInfoConst.MAP_SHOT_DIR)).longValue();
        L43:
            if (r100.isNull("v_p2p_ier") == true) goto L46;
            this.mdl_v_p2p_ier = ((Number) r100.get("v_p2p_ier")).intValue();
        L46:
            if (r100.isNull("ip_list") == true) goto L49;
            this.mdl_ip_list = r100.get("ip_list").toString();
        L49:
            if (r100.isNull("blocked_ip") == true) goto L52;
            this.mdl_blocked_ips = r100.get("blocked_ip").toString();
        L52:
            if (r100.isNull("cdn_cache") == true) goto L55;
            this.mdl_cdn_cache = r100.get("cdn_cache").toString();
        L55:
            if (r100.isNull("client_info") == true) goto L58;
            this.mdl_client_info = r100.get("client_info").toString();
        L58:
            if (r100.isNull("disable_seek") == true) goto L61;
            this.mdl_disable_seek = ((Number) r100.get("disable_seek")).intValue();
        L61:
            if (r100.isNull("mem_buffer_len") == true) goto L64;
            this.mdl_mem_buffer_len = ((Number) r100.get("mem_buffer_len")).intValue();
        L64:
            if (r100.isNull("disk_buffer_len") == true) goto L67;
            this.mdl_disk_buffer_len = ((Number) r100.get("disk_buffer_len")).longValue();
        L67:
            if (r100.isNull("send_offset") == true) goto L70;
            this.mdl_send_offset = ((Number) r100.get("send_offset")).longValue();
        L70:
            if (r100.isNull("last_req_offset") == true) goto L73;
            this.mdl_last_req_offset = ((Number) r100.get("last_req_offset")).longValue();
        L73:
            if (TTVideoEngine.sBuryDataOptimizeV2 != 0) goto L78;
            if (r100.isNull("last_ip_list") == true) goto L78;
            this.mdl_last_ip_list = r100.get("last_ip_list").toString();
        L78:
            if (r100.isNull("last_read_time") == true) goto L81;
            this.mdl_last_read_time = ((Number) r100.get("last_read_time")).longValue();
        L81:
            if (r100.isNull("downloading") == true) goto L84;
            this.mdl_downloading = ((Number) r100.get("downloading")).intValue();
        L84:
            if (r100.isNull("n80_host") == true) goto L87;
            this.mdl_n80_host = r100.get("n80_host").toString();
        L87:
            if (r100.isNull("mixed_cdn_type") == true) goto L91;
            this.mdl_mixed_cdn_type = ((Number) r100.get("mixed_cdn_type")).intValue();
            return;
        }

        public void updateOld(JSONObject r100) throws Exception {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isNull("cur_req_pos") == true) goto L7;
            this.mdl_cur_req_pos = ((Number) r100.get("cur_req_pos")).longValue();
        L7:
            if (r100.isNull("cur_end_pos") == true) goto L10;
            this.mdl_cur_end_pos = ((Number) r100.get("cur_end_pos")).longValue();
        L10:
            if (r100.isNull("cur_cache_pos") == true) goto L13;
            this.mdl_cur_cache_pos = ((Number) r100.get("cur_cache_pos")).longValue();
        L13:
            if (r100.isNull("cache_type") == true) goto L16;
            this.mdl_cache_type = ((Number) r100.get("cache_type")).intValue();
        L16:
            if (r100.isNull("down_pos") == true) goto L19;
            this.mdl_down_pos = ((Number) r100.get("down_pos")).longValue();
        L19:
            if (r100.isNull("err_code") == true) goto L22;
            this.mdl_error_code = ((Number) r100.get("err_code")).intValue();
        L22:
            if (r100.isNull("player_wait_num") == true) goto L25;
            this.mdl_player_wait_num = ((Number) r100.get("player_wait_num")).intValue();
        L25:
            if (r100.isNull("player_wait_time") == true) goto L28;
            this.mdl_player_wait_time = ((Number) r100.get("player_wait_time")).longValue();
        L28:
            if (r100.isNull("reply_size") == true) goto L31;
            this.mdl_reply_size = ((Number) r100.get("reply_size")).longValue();
        L31:
            if (r100.isNull("stage") == true) goto L34;
            this.mdl_stage = ((Number) r100.get("stage")).intValue();
        L34:
            if (r100.isNull("cur_host") == true) goto L37;
            this.mdl_cur_host = r100.get("cur_host").toString();
        L37:
            if (r100.isNull("cur_ip") == true) goto L40;
            this.mdl_cur_ip = r100.get("cur_ip").toString();
        L40:
            if (r100.isNull("speed") == true) goto L43;
            this.mdl_speed = ((Number) r100.get("speed")).intValue();
        L43:
            if (r100.isNull(TTVideoEngineInterface.PLAY_API_KEY_CDNTYPE) == true) goto L46;
            this.mdl_cdn_type = ((Number) r100.get(TTVideoEngineInterface.PLAY_API_KEY_CDNTYPE)).intValue();
        L46:
            if (r100.isNull("url") == true) goto L49;
            this.mdl_cur_url = r100.get("url").toString();
        L49:
            if (r100.isNull("file_key") == true) goto L52;
            this.mdl_file_key = r100.get("file_key").toString();
        L52:
            if (r100.isNull("is_socrf") == true) goto L55;
            this.mdl_is_socrf = ((Number) r100.get("is_socrf")).intValue();
        L55:
            if (r100.isNull("url_index") == true) goto L58;
            this.mdl_url_index = ((Number) r100.get("url_index")).intValue();
        L58:
            if (r100.isNull("re_url") == true) goto L61;
            this.mdl_re_url = r100.get("re_url").toString();
        L61:
            if (r100.isNull("cur_source") == true) goto L64;
            this.mdl_cur_soure = ((Number) r100.get("cur_source")).intValue();
        L64:
            if (r100.isNull("extra_info") == true) goto L67;
            this.mdl_extra_info = r100.get("extra_info").toString();
        L67:
            if (r100.isNull("status_code") == true) goto L70;
            this.mdl_http_code = ((Number) r100.get("status_code")).intValue();
        L70:
            if (r100.isNull("req_t") == true) goto L73;
            this.mdl_req_t = ((Number) r100.get("req_t")).longValue();
        L73:
            if (r100.isNull("end_t") == true) goto L76;
            this.mdl_end_t = ((Number) r100.get("end_t")).longValue();
        L76:
            if (r100.isNull("dns_t") == true) goto L79;
            this.mdl_dns_t = ((Number) r100.get("dns_t")).longValue();
        L79:
            if (r100.isNull("tcp_con_start_t") == true) goto L82;
            this.mdl_tcp_start_t = ((Number) r100.get("tcp_con_start_t")).longValue();
        L82:
            if (r100.isNull("tcp_con_t") == true) goto L85;
            this.mdl_tcp_end_t = ((Number) r100.get("tcp_con_t")).longValue();
        L85:
            if (r100.isNull("tcp_first_pack_t") == true) goto L88;
            this.mdl_ttfp = ((Number) r100.get("tcp_first_pack_t")).longValue();
        L88:
            if (r100.isNull("http_first_body_t") == true) goto L91;
            this.mdl_httpfb = ((Number) r100.get("http_first_body_t")).longValue();
        L91:
            if (r100.isNull("http_open_end_t") == true) goto L94;
            this.mdl_http_open_end_t = ((Number) r100.get("http_open_end_t")).longValue();
        L94:
            if (r100.isNull("fs") == true) goto L97;
            this.mdl_fs = ((Number) r100.get("fs")).longValue();
        L97:
            if (r100.isNull("full_speed") == true) goto L100;
            this.mdl_pcdn_full_speed = ((Number) r100.get("full_speed")).intValue();
        L100:
            if (r100.isNull("tbs") == true) goto L103;
            this.mdl_tbs = ((Number) r100.get("tbs")).longValue();
        L103:
            if (r100.isNull(MapInfoConst.MAP_SHOT_DIR) == true) goto L106;
            this.mdl_lbs = ((Number) r100.get(MapInfoConst.MAP_SHOT_DIR)).longValue();
        L106:
            if (r100.isNull("req_err") == true) goto L109;
            this.mdl_res_err = ((Number) r100.get("req_err")).intValue();
        L109:
            if (r100.isNull("read_src") == true) goto L112;
            this.mdl_read_src = ((Number) r100.get("read_src")).intValue();
        L112:
            if (r100.isNull("seek_times") == true) goto L115;
            this.mdl_seek_num = ((Number) r100.get("seek_times")).intValue();
        L115:
            if (r100.isNull("last_msg") == true) goto L118;
            this.mdl_last_msg = r100.get("last_msg").toString();
        L118:
            if (r100.isNull("server_timing") == true) goto L121;
            this.mdl_server_timing = r100.get("server_timing").toString();
        L121:
            if (r100.isNull("v_lt") == true) goto L124;
            this.mdl_v_lt = ((Number) r100.get("v_lt")).intValue();
        L124:
            if (r100.isNull("v_p2p_ier") == true) goto L127;
            this.mdl_v_p2p_ier = ((Number) r100.get("v_p2p_ier")).intValue();
        L127:
            if (r100.isNull("req_num") == true) goto L130;
            this.mdl_req_num = ((Number) r100.get("req_num")).intValue();
        L130:
            if (r100.isNull("ip_list") == true) goto L133;
            this.mdl_ip_list = r100.get("ip_list").toString();
        L133:
            if (r100.isNull("blocked_ip") == true) goto L136;
            this.mdl_blocked_ips = r100.get("blocked_ip").toString();
        L136:
            if (r100.isNull("cdn_cache") == true) goto L139;
            this.mdl_cdn_cache = r100.get("cdn_cache").toString();
        L139:
            if (r100.isNull("client_info") == true) goto L142;
            this.mdl_client_info = r100.get("client_info").toString();
        L142:
            if (r100.isNull("disable_seek") == true) goto L145;
            this.mdl_disable_seek = ((Number) r100.get("disable_seek")).intValue();
        L145:
            if (r100.isNull("mem_buffer_len") == true) goto L148;
            this.mdl_mem_buffer_len = ((Number) r100.get("mem_buffer_len")).intValue();
        L148:
            if (r100.isNull("disk_buffer_len") == true) goto L151;
            this.mdl_disk_buffer_len = ((Number) r100.get("disk_buffer_len")).longValue();
        L151:
            if (r100.isNull("send_offset") == true) goto L154;
            this.mdl_send_offset = ((Number) r100.get("send_offset")).longValue();
        L154:
            if (r100.isNull("last_req_offset") == true) goto L157;
            this.mdl_last_req_offset = ((Number) r100.get("last_req_offset")).longValue();
        L157:
            if (TTVideoEngine.sBuryDataOptimizeV2 != 0) goto L162;
            if (r100.isNull("last_ip_list") == true) goto L162;
            this.mdl_last_ip_list = r100.get("last_ip_list").toString();
        L162:
            if (r100.isNull("last_read_time") == true) goto L165;
            this.mdl_last_read_time = ((Number) r100.get("last_read_time")).longValue();
        L165:
            if (r100.isNull("downloading") == true) goto L168;
            this.mdl_downloading = ((Number) r100.get("downloading")).intValue();
        L168:
            if (r100.isNull("n80_host") == true) goto L171;
            this.mdl_n80_host = r100.get("n80_host").toString();
        L171:
            if (r100.isNull("mixed_cdn_type") == true) goto L175;
            this.mdl_mixed_cdn_type = ((Number) r100.get("mixed_cdn_type")).intValue();
            return;
        }
    }

    private static String _switchNetworkStrength(int r100) {
        if (r100 != 1) goto L5;
        return "weak";
    L5:
        if (r100 != 2) goto L7;
        return KryptonCamera.Config.RESOLUTION_MEDIUM;
    L7:
        if (r100 != 3) goto L9;
        return "good";
    L9:
        if (r100 == 4) goto L12;
        return "unknown";
    L12:
        return "excellent";
    }

    private static String _switchNetworkType(int r100) {
        if (r100 != 0) goto L4;
        return "WIFI";
    L4:
        if (r100 != 1) goto L6;
        return "4G";
    L6:
        if (r100 != 2) goto L8;
        return "2G";
    L8:
        if (r100 != 3) goto L10;
        return "3G";
    L10:
        if (r100 == 4) goto L13;
        return "unknown";
    L13:
        return "5G";
    }

    private void initParametersIfNeeded() {
        this.mPlayType = 0;
        this.mVideoHW = 0;
        this.mVideoHWUser = 0;
        this.mAudioHwUser = 0;
        this.mTag = "default";
        this.mSubTag = "default";
        this.mPlaySpeed = 1.0f;
        this.mdlVideoInfo.mdl_cache_type = 0;
        this.mdlAudioInfo.mdl_cache_type = 0;
    }

    public void movieFinish() {
        updateVideoInfo(null);
    }

    public static String getNetType() {
        if (gNetworkType.equals("unknown") == false) goto L8;
        TTNetWorkListener r100 = mTTNetWorkListener;
        if (r100 == null) goto L8;
        gNetworkType = _switchNetworkType(r100.getCurrentAccessType());
    L8:
        return gNetworkType;
    }

    public static String getSignalStrength() {
        if (gNetworkType.equals("unknown") == false) goto L6;
        return "unknown";
    L6:
        if (gSigStrength.equals("unknown") == false) goto L11;
        TTNetWorkListener r100 = mTTNetWorkListener;
        if (r100 == null) goto L11;
        gSigStrength = _switchNetworkStrength(r100.getCurrentAccessStrength());
    L11:
        return gSigStrength;
    }

    public float getBatteryCurrent() {
        if (this.mEnablePowerReport == true) goto L7;
        return -1.0f;
    L7:
        return DeviceMonitorUtils.getGalvanicNow(this.mContext);
    }

    public double getCPURate() {
        if (this.mEnablePowerReport == true) goto L7;
        return -1.0d;
    L7:
        return DeviceMonitorUtils.getCPURate();
    }

    public double getCPUSpeed() {
        if (this.mEnablePowerReport == true) goto L7;
        return -1.0d;
    L7:
        return DeviceMonitorUtils.getCPUSpeed();
    }

    public HashMap<String, Object> getChargingState() {
        if (this.mEnablePowerReport == true) goto L7;
        return null;
    L7:
        return DeviceMonitorUtils.getChargingState(this.mContext);
    }

    public String getCodecType() {
        Map r100 = this.mVideoInfo;
        String r101 = "";
        String r102 = r101;
        if (r100 == null) goto L11;
        Map r103 = (Map) r100.get("codec");
        r102 = r101;
        if (r103 == null) goto L11;
        Object r104 = r101;
        if (r103.get(this.mCurrentResolution) == null) goto L9;
        r104 = r103.get(this.mCurrentResolution);
    L9:
        r102 = (String) r104;
    L11:
        if (this.mDataSource != null) goto L13;
        return r102;
    L13:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        return r102;
    L15:
        return this.mDataSource.getLogValueStr(0);
    }

    public DeviceMonitorUtils.CPUInfo getCurrentCPUInfo() {
        if (this.mEnablePowerReport == true) goto L7;
        return null;
    L7:
        return DeviceMonitorUtils.getCurrentCPUInfo();
    }

    public JSONObject getMDLInfo() {
        if (this.mDataSource == null) goto L16;
        monitor-enter(this);
        String r100 = this.mDataSource.getMediaLoaderInfo();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        TTVideoEngineLog.d(TAG, "update mdl info: " + r100);
        if (TextUtils.isEmpty(r100) == true) goto L21;
        return new JSONObject(r100);
    L11:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.toString());
        return null;
    L21:
        return null;
    L13:
        th = move-exception;
        throw th;
    L16:
        return null;
    }

    public void registerNetwork() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        monitor-enter(TAG);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (mTTNetWorkListener != null) goto L10;
        TTNetWorkListener r100 = TTNetWorkListener.getInstance();     // Catch: Throwable -> L14
        mTTNetWorkListener = r100;     // Catch: Throwable -> L14
        r100.init(this.mContext);     // Catch: Throwable -> L14
    L10:
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 64) == true) goto L12;
        this.mNetWorkChangeCb = new AnonymousClass1(this);     // Catch: Throwable -> L14
        WeakReference<TTNetworkStateCallback> r101 = new WeakReference(this.mNetWorkChangeCb);     // Catch: Throwable -> L14
        this.mNetWorkChangeCbr = r101;     // Catch: Throwable -> L14
        mTTNetWorkListener.startListen(r101);     // Catch: Throwable -> L14
        gNetworkType = _switchNetworkType(mTTNetWorkListener.getCurrentAccessType());     // Catch: Throwable -> L14
        gSigStrength = _switchNetworkStrength(mTTNetWorkListener.getCurrentAccessStrength());     // Catch: Throwable -> L14
    L12:
        monitor-exit(TAG);     // Catch: Throwable -> L14
    }

    public void reset() {
        this.mSessionID = SessionIDGenerator.generateSessionID(this.mDeviceId);
    }

    public void showedOneFrame() {
        EventLoggerSource r100 = this.mDataSource;
        if (r100 == null) goto L7;
        this.codec_type = r100.getLogValueStr(0);
        this.a_codec_type = this.mDataSource.getLogValueStr(146);
        if (this.formatType >= 0) goto L7;
        this.formatType = this.mDataSource.getLogValueInt(49);
    L7:
        Map r101 = this.mVideoInfo;
        if (r101 == null) goto L32;
        Map r102 = (Map) r101.get("size");
        if (r102 != null) goto L12;
        Object r103 = null;
    L13:
        long r104 = 0;
        if (r103 == null) goto L16;
        long r105 = ((Number) r103).longValue();
    L17:
        Map r106 = (Map) this.mVideoInfo.get("audio_size");
        if (r106 != null) goto L20;
    L26:
        this.f457076vs = r105 + r104;
        Map r107 = (Map) this.mVideoInfo.get("vtype");
        if (r107 == null) goto L33;
        Object r108 = r107.get(this.mCurrentResolution);
        if (r108 == null) goto L34;
        this.vtype = (String) r108;
        TTVideoEngineLog.i(TAG, "showedOneFrame vtype:" + this.vtype + ", currentResolution:" + this.mCurrentResolution);
        return;
    L34:
        return;
    L33:
        return;
    L20:
        if (r106.size() <= 0) goto L26;
        if (this.mCurDashAudioInfoId == (-1)) goto L26;
        Object r109 = r106.get(Integer.valueOf(this.mCurDashAudioInfoId));
        if (r109 == null) goto L26;
        r104 = ((Number) r109).longValue();
        goto L26
    L16:
        r105 = 0;
        goto L17
    L12:
        r103 = r102.get(this.mCurrentResolution);
        goto L13
    }

    public void unregisterNetwork() {
        TTNetWorkListener r100 = mTTNetWorkListener;
        if (r100 == null) goto L6;
        r100.stopListen(this.mNetWorkChangeCbr);
        return;
    }

    public void updateMDLInfo() {
        JSONObject r100 = getMDLInfo();
        if (r100 == null) goto L52;
        boolean r101 = false;
        this.hasAudioTrackInfo = false;     // Catch: Exception -> L47
        if (r100.isNull("audio") == true) goto L9;
        this.hasAudioTrackInfo = true;     // Catch: Exception -> L47
        this.mdlAudioInfo.update(JSONObjectProtectorUtils.getJSONObject(r100, "audio"));     // Catch: Exception -> L47
        r101 = true;
    L9:
        if (r100.isNull("video") == true) goto L11;
        TTVideoEngineLog.d(TAG, "found video: " + JSONObjectProtectorUtils.getJSONObject(r100, "video").toString());     // Catch: Exception -> L47
        this.mdlVideoInfo.update(JSONObjectProtectorUtils.getJSONObject(r100, "video"));     // Catch: Exception -> L47
        r101 = true;
    L11:
        if (r101 == true) goto L14;
        this.mdlVideoInfo.update(r100);     // Catch: Exception -> L47
    L14:
        if (r100.isNull("cur_task_num") == true) goto L17;
        this.mdl_cur_task_num = ((Integer) r100.get("cur_task_num")).intValue();     // Catch: Exception -> L47
    L17:
        if (r100.isNull("conc_count") == true) goto L20;
        this.mdl_conc_count = ((Integer) r100.get("conc_count")).intValue();     // Catch: Exception -> L47
    L20:
        if (r100.isNull("mdl_preload_info") == true) goto L23;
        this.mdl_preload_info = r100.get("mdl_preload_info").toString();     // Catch: Exception -> L47
    L23:
        if (r100.isNull("dns_type") == true) goto L25;
        int r102 = ((Integer) r100.get("dns_type")).intValue();     // Catch: Exception -> L47
    L26:
        if (r102 != 0) goto L28;
        this.mDNSType = IVideoEventLogger.LOGGER_DNS_TYPE_LOCAL;     // Catch: Exception -> L47
    L44:
        if (r100.isNull("mdl_features") == true) goto L53;
        updateMdlFeatures(JSONObjectProtectorUtils.getJSONObject(r100, "mdl_features"));     // Catch: Exception -> L47
        return;
    L53:
        return;
    L28:
        if (r102 != 2) goto L30;
        this.mDNSType = IVideoEventLogger.LOGGER_DNS_TYPE_HTTP_OWN;     // Catch: Exception -> L47
        goto L44
    L30:
        if (r102 != 3) goto L32;
        this.mDNSType = IVideoEventLogger.LOGGER_DNS_TYPE_HTTP_GOOGLE;     // Catch: Exception -> L47
        goto L44
    L32:
        if (r102 != 4) goto L44;
        EventLoggerSource r103 = this.mDataSource;     // Catch: Exception -> L47
        if (r103 != null) goto L37;
    L39:
        this.mDNSType = IVideoEventLogger.LOGGER_DNS_TYPE_CUSTOM;     // Catch: Exception -> L47
        goto L44
    L37:
        if (r103.getLogValueInt(85) != 1) goto L39;
        this.mDNSType = IVideoEventLogger.LOGGER_DNS_TYPE_CUSTOM_INNER_BYTEDANCE_HTTPDNS;     // Catch: Exception -> L47
        goto L44
    L25:
        r102 = -1;
    L47:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    }

    public String getCurHost() {
        return this.mCurHost;
    }

    public String getCurIP() {
        return this.mCurIP;
    }

    public String getCurQuality() {
        return this.mCurQuality;
    }

    public String getCurResolution() {
        return this.mCurResolution;
    }

    public String getCurURL() {
        return this.mCurURL;
    }

    public Map getVideoInfo() {
        return this.mVideoInfo;
    }

    private void updateMdlFeatures(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();     // Catch: JSONException -> L12
    L5:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: JSONException -> L12
        int r104 = JSONObjectProtectorUtils.getInt(r100, r103);     // Catch: JSONException -> L12
        r101.put(r103, Integer.valueOf(r104));     // Catch: JSONException -> L12
        if (this.mdlP2pLoader != (-1)) goto L5;
        if (r103.equals("mdl_p2p_loader") == false) goto L5;
        this.mdlP2pLoader = r104;     // Catch: JSONException -> L12
    L15:
        if (r101.isEmpty() == true) goto L27;
        this.mdlFeatures = r101;
        return;
    L27:
        return;
    L12:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L15
    }

    public MDLTrackInfo getMdlTrackInfo(JSONObject r100) throws Exception {
        MDLTrackInfo r101 = new MDLTrackInfo(this);
        r101.update(r100);
        return r101;
    }

    public void setCurHost(String r100) {
        this.mCurHost = r100;
    }

    public void setCurIP(String r100) {
        this.mCurIP = r100;
    }

    public void setCurQuality(String r100) {
        this.mCurQuality = r100;
    }

    public void setCurResolution(String r100) {
        this.mCurResolution = r100;
    }

    public void setCurURL(String r100) {
        this.mCurURL = r100;
    }

    public void setCurrentQualityDesc(String r100) {
        if (TextUtils.isEmpty(this.mInitialQualityDesc) == false) goto L5;
        this.mInitialQualityDesc = r100;
    L5:
        this.mCurrentQualityDesc = r100;
    }

    public void setP2PCDNType(int r100) {
        this.mP2PCDNType = r100;
    }

    public void setTag(String r100) {
        this.mTag = r100;
    }

    public void setVideoInfo(IVideoModel r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        this.mVideoModel = r210;
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        HashMap r104 = new HashMap();
        HashMap r105 = new HashMap();
        HashMap r106 = new HashMap();
        ArrayList r107 = new ArrayList();
        ArrayList r110 = new ArrayList();
        if (r210.hasData() == false) goto L30;
        List<VideoInfo> r111 = r210.getVideoInfoList();
        if (r111 == null) goto L30;
        if (r111.size() <= 0) goto L30;
        Iterator<VideoInfo> r112 = r111.iterator();
        int r113 = 0;
    L13:
        if (r112.hasNext() == false) goto L30;
        VideoInfo r114 = r112.next();
        int r115 = r114.getMediatype();
        Iterator<VideoInfo> r116 = r112;
        long r117 = r114.getValueLong(12);
        String r108 = r114.getValueStr(8);
        HashMap r118 = r101;
        int r109 = r114.getValueInt(3);
        String r119 = r114.getResolution().toString(r115);
        ArrayList r120 = r110;
        String r121 = r114.getValueStr(6);
        ArrayList r211 = r107;
        r100.put(r119, Long.valueOf(r117));
        r102.put(r119, r108);
        r103.put(r119, Integer.valueOf(r109));
        r104.put(Integer.valueOf(r114.getValueInt(3)), r114.getValueStr(15));
        r105.put(Integer.valueOf(r114.getValueInt(3)), Integer.valueOf(r113));
        r106.put(r119, r121);
        if (r115 != 1) goto L17;
        r211.add(Integer.valueOf(r114.getValueInt(3)));
    L18:
        HashMap r212 = r105;
        if (this.mEnableTmpLog == false) goto L21;
        TTVideoEngineLog.i(TAG, "setVideoInfo i:" + r113 + ", resolution:" + r119 + ", size:" + r117 + ",codec_type:" + r108 + ", bitrate:" + r109);
    L21:
        r113 = r113 + 1;
        int r122 = r114.getValueInt(42);
        if (r115 == VideoRef.TYPE_AUDIO) goto L24;
    L28:
        r101 = r118;
    L29:
        r112 = r116;
        r110 = r120;
        r107 = r211;
        r105 = r212;
        goto L13
    L24:
        if ("dash".equals(r121) == false) goto L26;
    L27:
        r101 = r118;
        r101.put(Integer.valueOf(r122), Long.valueOf(r117));
        goto L29
    L26:
        if ("bash".equals(r121) == false) goto L28;
    L17:
        r211 = r211;
        r120.add(Integer.valueOf(r114.getValueInt(3)));
    L30:
        HashMap r123 = new HashMap();
        String r124 = r210.getDynamicType();
        r123.put("duration", Integer.valueOf(r210.getVideoRefInt(3)));
        r123.put("size", r100);
        r123.put("audio_size", r101);
        r123.put("codec", r102);
        r123.put("vtype", r106);
        r123.put("dynamic_type", r124);
        r123.put("bitrate", r103);
        r123.put("fileKey", r104);
        r123.put("bitrateMapTable", r105);
        r123.put(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE, r107);
        r123.put(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE, r110);
        this.mVideoInfo = r123;
        if (TextUtils.isEmpty(this.mCurrentResolution) == true) goto L35;
        Object r125 = r103.get(this.mCurrentResolution);
        if (r125 == null) goto L35;
        this.mCurrentConfigBitrate = ((Integer) r125).intValue();
    L35:
        this.dynamic_type = r124;
    }

    public void updateVideoInfo(VideoModel r100) {
        if (r100 == null) goto L4;
        setVideoInfo(r100);
    L4:
        Map r101 = this.mVideoInfo;
        if (r101 == null) goto L41;
        if (this.f457075vd > 0) goto L10;
        this.f457075vd = ((Integer) r101.get("duration")).intValue() * 1000;
    L10:
        if (this.f457076vs > 0) goto L27;
        Object r102 = ((Map) this.mVideoInfo.get("size")).get(this.mCurrentResolution);
        if (r102 == null) goto L14;
        long r103 = ((Number) r102).longValue();
    L15:
        Map r104 = (Map) this.mVideoInfo.get("audio_size");
        if (r104 != null) goto L18;
    L24:
        long r105 = 0;
    L25:
        this.f457076vs = r103 + r105;
        goto L27
    L18:
        if (r104.size() <= 0) goto L24;
        if (this.mCurDashAudioInfoId == (-1)) goto L24;
        Object r106 = r104.get(Integer.valueOf(this.mCurDashAudioInfoId));
        if (r106 == null) goto L24;
        r105 = ((Number) r106).longValue();
        goto L25
    L14:
        r103 = 0;
    L27:
        if (TextUtils.isEmpty(this.codec_type) == false) goto L34;
        Map r107 = (Map) this.mVideoInfo.get("codec");
        if (r107.get(this.mCurrentResolution) == null) goto L31;
        Object r108 = r107.get(this.mCurrentResolution);
    L32:
        this.codec_type = (String) r108;
        TTVideoEngineLog.i(TAG, "brian codec_type:" + this.codec_type + ", for resolution:" + this.mCurrentResolution + ", quality desc:" + this.mCurrentQualityDesc);
        goto L34
    L31:
        r108 = "";
    L34:
        if (TextUtils.isEmpty(this.vtype) == false) goto L41;
        Map r109 = (Map) this.mVideoInfo.get("vtype");
        if (r109 == null) goto L41;
        Object r110 = r109.get(this.mCurrentResolution);
        if (r110 == null) goto L41;
        this.vtype = (String) r110;
    L41:
        if (this.mDataSource == null) goto L79;
        String r111 = this.f457073pv;
        if (r111 != null) goto L45;
    L46:
        Map<String, String> r112 = this.mDataSource.versionInfo();
        if (r112 == null) goto L50;
        this.f457073pv = r112.get("pv");
        this.f457072pc = r112.get(BackupSeiMessage.SOURCE_PC);
        this.f457074sv = r112.get(com.alipay.sdk.m.s.a.f25762t);
        this.sdk_version = r112.get("sdk_version");
        this.ffmpeg_version = r112.get("ffv");
        this.libvcn_version = r112.get("vcnv");
        this.texturender_version = r112.get("trv");
        this.abr_version = r112.get("abrv");
        this.predict_version = r112.get("prdtv");
        this.preload_version = r112.get("prldv");
    L50:
        if (TextUtils.isEmpty(this.codec_type) == false) goto L53;
        this.codec_type = this.mDataSource.getLogValueStr(0);
    L53:
        if (TextUtils.isEmpty(this.a_codec_type) == false) goto L55;
        this.a_codec_type = this.mDataSource.getLogValueStr(146);
    L55:
        String r113 = this.mDataSource.getLogValueStr(37);
        if (TextUtils.isEmpty(r113) == true) goto L58;
        this.mMdlVersion = r113;
    L58:
        TTVideoEngineLog.i(TAG, "video_type:" + this.vtype);
        if (TextUtils.isEmpty(this.vtype) == false) goto L69;
        String r114 = this.mDataSource.getLogValueStr(65);
        TTVideoEngineLog.i(TAG, "get video_type from player:" + r114);
        if (TextUtils.isEmpty(r114) == true) goto L69;
        if (r114.indexOf("mp4") <= 0) goto L65;
        this.vtype = "mp4";
        goto L69
    L65:
        int r115 = r114.indexOf(",");
        if (r115 >= 0) goto L68;
        this.vtype = r114;
        goto L69
    L68:
        this.vtype = r114.substring(0, r115);
    L69:
        TTVideoEngineLog.i(TAG, "video_size :" + this.f457076vs);
        if (this.f457076vs > 0) goto L72;
        this.f457076vs = this.mDataSource.getLogValueLong(66);
        TTVideoEngineLog.i(TAG, "get video_size from player:" + this.f457076vs);
    L72:
        this.videoCodecNameId = this.mDataSource.getLogValueInt(24);
        this.audioCodecNameId = this.mDataSource.getLogValueInt(25);
        switch(this.videoCodecNameId) {
            case 2: goto L76;
            case 3: goto L75;
            case 4: goto L75;
            case 5: goto L75;
            case 6: goto L75;
            case 7: goto L75;
            case 8: goto L75;
            case 9: goto L75;
            default: goto L77;
        };
    L75:
        this.mVideoHW = 0;
        goto L77
    L76:
        this.mVideoHW = 1;
    L77:
        this.formatType = this.mDataSource.getLogValueInt(49);
        return;
    L45:
        if (r111.isEmpty() == false) goto L50;
    }

    public void useVideoHW(int r100) {
        this.mVideoHW = r100;
        this.mVideoHWUser = r100;
    }

    private void _changeNetworkType(int r100, int r101) {
        String r102 = _switchNetworkType(r100);
        String r103 = _switchNetworkType(r101);
        TTVideoEngineLog.d(TAG, String.format("receive network type changed, from:%s to:%s", new Object[]{r102, r103}));
        gNetworkType = r103;
    }

    private void _changeSignalStrength(int r100, int r101) {
        String r102 = _switchNetworkStrength(r100);
        String r103 = _switchNetworkStrength(r101);
        TTVideoEngineLog.d(TAG, String.format("receive signal strength changed, from:%s to:%s", new Object[]{r102, r103}));
        gSigStrength = r103;
    }

    public void beginToPlay(String r100, String r101) {
        this.mVid = r100;
        this.mDeviceId = r101;
        EventLoggerSource r102 = this.mDataSource;
        if (r102 == null) goto L5;
        String r103 = r102.getLogValueStr(139);
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        this.mSessionID = SessionIDGenerator.generateTrackID(this.mDeviceId);
        this.mHasGetPreloadTraceId = false;
    L10:
        this.mTraceID = this.mSessionID;
        if (TextUtils.isEmpty(appSessionId) == false) goto L14;
        appSessionId = SessionIDGenerator.generateSessionID(this.mDeviceId);
        return;
    L14:
        return;
    L9:
        this.mSessionID = r103;
        this.mHasGetPreloadTraceId = true;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public void configResolution(String r100, String r101) {
        this.mLastResolution = r101;
        this.mCurrentResolution = r100;
        Map r102 = this.mVideoInfo;
        if (r102 == null) goto L11;
        Map r103 = (Map) r102.get("bitrate");
        if (r103 != null) goto L7;
        Object r104 = null;
    L8:
        if (r104 == null) goto L12;
        this.mCurrentConfigBitrate = ((Integer) r104).intValue();
        return;
    L12:
        return;
    L7:
        r104 = r103.get(this.mCurrentResolution);
        goto L8
    }

    public void setSourceType(int r100, String r101) {
        switch(r100) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L12;
        };
    L4:
        this.mSourceTypeStr = "mds";
        goto L12
    L5:
        this.mSourceTypeStr = "fd";
        goto L12
    L6:
        this.mSourceTypeStr = "vid";
        goto L12
    L7:
        this.mSourceTypeStr = "feed";
        goto L12
    L8:
        this.mSourceTypeStr = "preload";
        goto L12
    L9:
        this.mSourceTypeStr = "playitem";
        goto L12
    L10:
        this.mSourceTypeStr = "dir_url";
        goto L12
    L11:
        this.mSourceTypeStr = "local_url";
    L12:
        this.mVid = r101;
    }

    public VideoEventBase(EventLoggerSource r100, boolean r101, Context r102) {
        this.mNetWorkChangeCb = null;
        this.mNetWorkChangeCbr = null;
        this.f457073pv = "";
        this.f457072pc = "";
        this.f457074sv = "";
        this.mGearinfoList = null;
        this.sdk_version = "";
        this.ffmpeg_version = "";
        this.libvcn_version = "";
        this.texturender_version = "";
        this.preload_version = "";
        this.abr_version = "";
        this.predict_version = "";
        this.mDNSType = "";
        this.mPlayType = Integer.MIN_VALUE;
        this.mVid = "";
        this.mMediaID = "";
        this.mSourceTypeStr = "";
        this.mVideoHW = Integer.MIN_VALUE;
        this.mVideoHWUser = Integer.MIN_VALUE;
        this.mAudioHwUser = Integer.MIN_VALUE;
        this.f457075vd = Integer.MIN_VALUE;
        this.f457076vs = SieveCacheKt.NodeMetaAndPreviousMask;
        this.codec_type = "";
        this.a_codec_type = "";
        this.audioCodecNameId = Integer.MIN_VALUE;
        this.videoCodecNameId = Integer.MIN_VALUE;
        this.formatType = Integer.MIN_VALUE;
        this.vtype = "";
        this.dynamic_type = "";
        this.mLastResolution = "";
        this.mCurrentResolution = "";
        this.mCurrentConfigBitrate = Integer.MIN_VALUE;
        this.mP2PCDNType = Integer.MIN_VALUE;
        this.mTag = "";
        this.mSubTag = "";
        this.mReuseSocket = Integer.MIN_VALUE;
        this.mDrmType = Integer.MIN_VALUE;
        this.mDrmTokenUrl = "";
        this.mPlaySpeed = Float.MIN_VALUE;
        this.mTraceID = "";
        this.mNetworkType = "";
        this.mMdlVersion = "";
        this.mInitialQualityDesc = "";
        this.mCurrentQualityDesc = "";
        this.mOriginVid = null;
        this.mEnableTmpLog = false;
        this.mEnablePowerReport = false;
        this.mHasGetPreloadTraceId = false;
        this.mCurDashAudioInfoId = -1;
        this.mdlVideoInfo = new MDLTrackInfo(this);
        this.mdlAudioInfo = new MDLTrackInfo(this);
        this.hasAudioTrackInfo = false;
        this.mdl_cur_task_num = Integer.MIN_VALUE;
        this.mdl_conc_count = Integer.MIN_VALUE;
        this.mdl_preload_info = "";
        this.abrInfo = null;
        this.selectResultInfo = null;
        this.is_enable_abr = Integer.MIN_VALUE;
        this.is_enable_select_bitrate = Integer.MIN_VALUE;
        this.abrGeneralInfo = null;
        this.mEnableMDL = Integer.MIN_VALUE;
        this.mdlFeatures = null;
        this.mdlP2pLoader = -1;
        this.mDataSource = r100;
        this.mSessionID = SessionIDGenerator.generateSessionID(null);
        this.isUploadLogEnabled = r101;
        this.mContext = r102;
        initParametersIfNeeded();
    }

    public static /* synthetic */ void access$000(VideoEventBase r100, int r101, int r102) {
        r100._changeNetworkType(r101, r102);
    }

    public static /* synthetic */ void access$100(VideoEventBase r100, int r101, int r102) {
        r100._changeSignalStrength(r101, r102);
    }
}
