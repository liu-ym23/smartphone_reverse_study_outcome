package com.ss.ttvideoengine.log;

import android.os.Bundle;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.metrics.IMediaMetrics;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.utils.Error;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IVideoEventLogger {
    public static final String CAST_INFO_IS_CAST_LIVE = "is_cast_live";
    public static final String CAST_INFO_PROTOCAL = "cast_protocal";
    public static final String CAST_INFO_SCENE_ID = "cast_scene_id";
    public static final String CAST_INFO_SOURCE_APP_ID = "cast_source_app_id";
    public static final int EXPIRE_PLAY_CODE_URL = 1;
    public static final int EXPIRE_PLAY_CODE_VM = 2;
    public static final int EXPIRE_PLAY_CODE_VM_RETRY = 3;
    public static final String FEATURE_KEY_ABR = "abr";
    public static final String FEATURE_KEY_ABR_STARTUP = "abr_startup";
    public static final String FEATURE_KEY_AI_BARRAGE = "ai_barrage";
    public static final String FEATURE_KEY_ASYNC_INIT = "async_init";
    public static final String FEATURE_KEY_ASYNC_MANAGE_RESOURCE = "async_res";
    public static final String FEATURE_KEY_ASYNC_POSITION = "async_pos";
    public static final String FEATURE_KEY_ASYNC_SET_SURFACE = "async_set_surface";
    public static final String FEATURE_KEY_AUDIO_HW = "a_hw";
    public static final String FEATURE_KEY_AUDIO_RENDER_TYPE = "audio_render_type";
    public static final String FEATURE_KEY_AUDIO_USE_DIRECTBUFFER = "a_directbuf";
    public static final String FEATURE_KEY_AUTO_DISCONNECTED_CPU = "auto_disconnect_cpu";
    public static final String FEATURE_KEY_AUTO_RANGE = "auto_range";
    public static final String FEATURE_KEY_AV_INTERLACED_CHECK = "av_interlaced_check";
    public static final String FEATURE_KEY_BASH = "bash";
    public static final String FEATURE_KEY_BUFFER_DIRECTLY = "buffer_directly";
    public static final String FEATURE_KEY_BUFFER_TIMEOUT = "buffer_timeout";
    public static final String FEATURE_KEY_BYTEVC1 = "bytevc1";
    public static final String FEATURE_KEY_BYTEVC2 = "bytevc2";
    public static final String FEATURE_KEY_CACHE = "cache";
    public static final String FEATURE_KEY_CHANGE_REC_BUFFER_SPEED = "change_rec_buf_speed";
    public static final String FEATURE_KEY_CLEAR_MDL_CACHE = "clear_mdl_cache";
    public static final String FEATURE_KEY_CODECPOOL_SUPPORT_DYNAMIC_EXTEND = "codecpool_extend";
    public static final String FEATURE_KEY_CODEC_AND_SURFACE_REUSE = "codec_surface_reuse";
    public static final String FEATURE_KEY_CODEC_FRC_LEVEL = "frc_level";
    public static final String FEATURE_KEY_CODEC_POOL = "codec_pool";
    public static final String FEATURE_KEY_CREATE_AUDIO_TRACK_EARLY = "create_audiotrack_early";
    public static final String FEATURE_KEY_DECODER_DROP = "decoder_drop";
    public static final String FEATURE_KEY_DEMUX_NONBLOCK_READ = "demux_nonblock_read";
    public static final String FEATURE_KEY_DISABLE_SHORT_SEEK = "dis_short_seek";
    public static final String FEATURE_KEY_DISABLE_SPLIT_VOICE = "disable_split_voice";
    public static final String FEATURE_KEY_ENABLE_ASYNC_PREPARE = "async_prepare";
    public static final String FEATURE_KEY_ENABLE_AUDIOMEM_INTERGRATION = "audiomem_intergration";
    public static final String FEATURE_KEY_ENABLE_BUFFERING_LOWERCAPACITY = "lower_buffering_capacity";
    public static final String FEATURE_KEY_ENABLE_BYTEVC1_DECODER_OPTIMIZE = "bytevc1_decoder_opt";
    public static final String FEATURE_KEY_ENABLE_CPPBYTEVC2CODEC_OPT = "bytevc2_opt";
    public static final String FEATURE_KEY_ENABLE_DOWNGRADE_ASYNCCODEC = "downgrade_asynccodec";
    public static final String FEATURE_KEY_ENABLE_LOAD_CONTROL = "enable_loadcontrol";
    public static final String FEATURE_KEY_ENABLE_MEDIACODEC_SYNC_CLOSE = "mediacodec_sync_clode";
    public static final String FEATURE_KEY_ENABLE_OPTIMIZE_HWDEC2SWDEC = "opti_hwdec2swdec";
    public static final String FEATURE_KEY_ENABLE_OUTLET_DROP_LIMIT = "drop_limit";
    public static final String FEATURE_KEY_ENABLE_OUT_THREAD_OPTIMIZE = "out_thread_optimize";
    public static final String FEATURE_KEY_ENABLE_PCDN_AUTO = "enable_pcdn_auto";
    public static final String FEATURE_KEY_ENABLE_SEEK_BUFFERING = "seek_buffering";
    public static final String FEATURE_KEY_ENABLE_STRATEGY_CENTER = "strategy_center";
    public static final String FEATURE_KEY_ENABLE_VIDEO_SECOND_FRAME = "v_2nd_frame";
    public static final String FEATURE_KEY_ENABLE_xHEAAC = "xHEAAC_audio_support";
    public static final String FEATURE_KEY_ENGINE_LOOPER = "engine_looper";
    public static final String FEATURE_KEY_ENGINE_STRATEGY_VERSION = "engine_strategy_version";
    public static final String FEATURE_KEY_FALLBACK_API = "fallback_api";
    public static final String FEATURE_KEY_FIRST_BUFFER_END_MS = "first_buf_end_ms";
    public static final String FEATURE_KEY_FORCE_DISABLE_OES_RENDER = "force_disable_oes_render";
    public static final String FEATURE_KEY_GEAR_STRATEGY = "gear_strategy";
    public static final String FEATURE_KEY_GIVEBACK_CODEC_EARLY = "giveback_codec_early";
    public static final String FEATURE_KEY_HDR_HLG = "hdr_hlg";
    public static final String FEATURE_KEY_HDR_PQ = "hdr_pq";
    public static final String FEATURE_KEY_HEAACV2 = "heaacv2";
    public static final String FEATURE_KEY_HIJACK = "enable_hijack";
    public static final String FEATURE_KEY_HIJACK_RETRY = "hijack_retry";
    public static final String FEATURE_KEY_HTTPS = "enable_https";
    public static final String FEATURE_KEY_HW_DECODER_DROP = "hw_decoder_drop";
    public static final String FEATURE_KEY_HW_DROP = "hw_drop";
    public static final String FEATURE_KEY_IMAGE_SCALE = "image_scale";
    public static final String FEATURE_KEY_KEEP_FORMAT_THREAD_ALIVE = "keep_formater_alive";
    public static final String FEATURE_KEY_LAZY_SEEK = "lazy_seek";
    public static final String FEATURE_KEY_LOADCONTROL_REBUF = "loadcontrol_rebuf";
    public static final String FEATURE_KEY_LOADCONTROL_START = "loadcontrol_start";
    public static final String FEATURE_KEY_MASK_DELAY_LOADING = "mask_delay_loading";
    public static final String FEATURE_KEY_MASK_ENABLE_DATALOADER = "mask_loader";
    public static final String FEATURE_KEY_MASK_ENABLE_RANGE_REQUEST = "mask_range_req";
    public static final String FEATURE_KEY_MASK_THREAD = "mask_thread_enable";
    public static final String FEATURE_KEY_MC_MONITOR = "mc_monitor";
    public static final String FEATURE_KEY_MC_RENDER = "mc_render";
    public static final String FEATURE_KEY_MDL_BACKUP_IP = "mdl_backip";
    public static final String FEATURE_KEY_MDL_DNS_PARALLEL_PARSE = "mdl_dns_parallel";
    public static final String FEATURE_KEY_MDL_DNS_REFRESH = "mdl_dns_refresh";
    public static final String FEATURE_KEY_MDL_ENABLE_EXTERN_DNS = "mdl_externdns";
    public static final String FEATURE_KEY_MDL_HTTPDNS = "mdl_httpdns";
    public static final String FEATURE_KEY_MDL_PREPARSE_DNS = "mdl_predns";
    public static final String FEATURE_KEY_MDL_PRE_CONNECT = "mdl_preconn";
    public static final String FEATURE_KEY_MDL_SEEK_REOPEN = "mdl_seek_reopen";
    public static final String FEATURE_KEY_MDL_SESSION_REUSE = "mdl_session_reuse";
    public static final String FEATURE_KEY_MDL_SOCKET_MONITOR = "mdl_socket_monitor";
    public static final String FEATURE_KEY_MDL_SOCKET_REUSE = "mdl_socket_reuse";
    public static final String FEATURE_KEY_MDL_TLS_VERSION = "mdl_tls_ver";
    public static final String FEATURE_KEY_MDL_TYPE = "mdl_type";
    public static final String FEATURE_KEY_MEDIACODEC_ASYNC = "mediacodec_async";
    public static final String FEATURE_KEY_METRICS_ABILITY = "metrics";
    public static final String FEATURE_KEY_MOV_PREFER_NEAR_SAMPLE = "pref_near_sample";
    public static final String FEATURE_KEY_MULTI_BITRATE_REFACTOR = "mb_refactor";
    public static final String FEATURE_KEY_NATIVE_YV12_RENDER = "yv12";
    public static final String FEATURE_KEY_NETWORK_TIMEOUT = "network_timeout";
    public static final String FEATURE_KEY_NO_BUFFER_UPDATE = " no_buffer_update";
    public static final String FEATURE_KEY_OES_TEXTURE = "oes_texture";
    public static final String FEATURE_KEY_PRECISE_CACHE = "precise_cache";
    public static final String FEATURE_KEY_PRECISE_PAUSE = "precise_pause";
    public static final String FEATURE_KEY_PRELOAD = "preload";
    public static final String FEATURE_KEY_PRELOAD_GEAR = "preload_gear";
    public static final String FEATURE_KEY_PREPARE_DECODE_ONLY = "pre_decode";
    public static final String FEATURE_KEY_PRERENDER_START_REASON = "prerender_start_reason";
    public static final String FEATURE_KEY_PRERENDER_STOP_REASON = "prerender_stop_reason";
    public static final String FEATURE_KEY_PRE_DEMUX = "pre_demux";
    public static final String FEATURE_KEY_QUERY_ADAPTIVE_PLAYBACK = "query_adapt_playback";
    public static final String FEATURE_KEY_QUERY_WIN = "query_win";
    public static final String FEATURE_KEY_RENDER_TYPE = "render_type";
    public static final String FEATURE_KEY_REUSE_CODEC_FROM_POOL = "reuse_codec";
    public static final String FEATURE_KEY_SC_VOLUME_BALANCE = "sc_volume_balance";
    public static final String FEATURE_KEY_SELECT_BITRATE = "select";
    public static final String FEATURE_KEY_SETTINGS_HARDWARE = "st_hw";
    public static final String FEATURE_KEY_SET_OPEN_VOICE_EARLY = "open_voice_early";
    public static final String FEATURE_KEY_SKIP_AUDIO_OUT = "skip_audio_out";
    public static final String FEATURE_KEY_SKIP_FIND_STREAM_INFO = "skip_find_stream";
    public static final String FEATURE_KEY_SMOOTH_CLOCK = "smooth_clock";
    public static final String FEATURE_KEY_SOCKET_REUSE = "socket_reuse";
    public static final String FEATURE_KEY_SOURCE_REFRESH = "source_refresh";
    public static final String FEATURE_KEY_SPEED_PREDICT = "speed_predict";
    public static final String FEATURE_KEY_SR = "sr";
    public static final String FEATURE_KEY_SR_STRATEGY = "sr_strategy";
    public static final String FEATURE_KEY_SUB_THREAD = "sub_thread_enable";
    public static final String FEATURE_KEY_THREAD_PRIORITY = "thread_priority";
    public static final String FEATURE_KEY_VIDEO_HW = "v_hw";
    public static final String FEATURE_KEY_VOLUME_BALANCE = "volume_balance";
    public static final String FEATURE_KEY_VOLUME_BALANCEV2 = "volume_balancev2";
    public static final String FEATURE_KEY_VOLUME_BALANCE_TOB = "volume_balance_tob";
    public static final float FLOAT_EMPTY_VALUE = Float.MIN_VALUE;
    public static final float FLOAT_INVALID_VALUE = -1.0f;
    public static final String GEAR_STRATEGY_KEY_BITRATE = "gs_bitrate";
    public static final String GEAR_STRATEGY_KEY_ERROR = "gs_error";
    public static final String GEAR_STRATEGY_KEY_HEADERS = "headers";
    public static final String GEAR_STRATEGY_KEY_ON_AFTER_BEGIN = "gs_on_after_begin";
    public static final String GEAR_STRATEGY_KEY_ON_AFTER_END = "gs_on_after_end";
    public static final String GEAR_STRATEGY_KEY_ON_BEFORE_BEGIN = "gs_on_before_begin";
    public static final String GEAR_STRATEGY_KEY_ON_BEFORE_END = "gs_on_before_end";
    public static final String GEAR_STRATEGY_KEY_REASON = "gs_reason";
    public static final String GEAR_STRATEGY_KEY_SELECT_BEGIN = "gs_select_begin";
    public static final String GEAR_STRATEGY_KEY_SELECT_END = "gs_select_end";
    public static final String GEAR_STRATEGY_KEY_SPEED = "gs_speed";
    public static final int INTEGER_EMPTY_VALUE = Integer.MIN_VALUE;
    public static final int INTEGER_INVALID_VALUE = -1;
    public static final String LOGGER_DNS_TYPE_CUSTOM = "customDNS";
    public static final String LOGGER_DNS_TYPE_CUSTOM_INNER_BYTEDANCE_HTTPDNS = "customDNSInnerByteDanceHTTPDNS";
    public static final String LOGGER_DNS_TYPE_HTTP = "httpDNS";
    public static final String LOGGER_DNS_TYPE_HTTP_GOOGLE = "httpDNS_google";
    public static final String LOGGER_DNS_TYPE_HTTP_OWN = "httpDNS_own";
    public static final String LOGGER_DNS_TYPE_LOCAL = "localDNS";
    public static final int LOGGER_LEAVE_METHOD_FINISH_ERROR = 4;
    public static final int LOGGER_LEAVE_METHOD_FINISH_NORMAL = 3;
    public static final int LOGGER_LEAVE_METHOD_FINISH_STATUS_EXCP = 5;
    public static final int LOGGER_LEAVE_METHOD_RELEASE = 1;
    public static final int LOGGER_LEAVE_METHOD_RELEASE_ASYNC = 2;
    public static final int LOGGER_LEAVE_METHOD_RESET = 6;
    public static final int LOGGER_LEAVE_METHOD_STOP = 0;
    public static final int LOGGER_OPTION_ABR_STARTUP = 91;
    public static final int LOGGER_OPTION_AE_TYPE = 54;
    public static final int LOGGER_OPTION_AUDIO_BITRATE = 56;
    public static final int LOGGER_OPTION_AUDIO_HW = 16;
    public static final int LOGGER_OPTION_AUDIO_RENDER_TYPE = 39;
    public static final int LOGGER_OPTION_AUDIO_STREAM_DISABLED = 13;
    public static final int LOGGER_OPTION_AUDIO_STREAM_DURATION = 99;
    public static final int LOGGER_OPTION_BITRATE = 21;
    public static final int LOGGER_OPTION_BITRATE_AFTER_DOWNGRADE = 137;
    public static final int LOGGER_OPTION_BITRATE_BEFORE_DOWNGRADE = 136;
    public static final int LOGGER_OPTION_BUFFERING_DIRECTLY = 26;
    public static final int LOGGER_OPTION_BUFFERING_TIMEOUT = 24;
    public static final int LOGGER_OPTION_CODEC_FRC_LEVEL = 42;
    public static final int LOGGER_OPTION_COLOR_TRC = 89;
    public static final int LOGGER_OPTION_CUSTOM_SET_RADIO_MODE = 45;
    public static final int LOGGER_OPTION_DISABLE_EVENTV3_ASYNC = 10;
    public static final int LOGGER_OPTION_DISABLE_SPLIT_VOICE = 94;
    public static final int LOGGER_OPTION_DNS_TYPE = 86;
    public static final int LOGGER_OPTION_ENABLE_ABR_SR = 134;
    public static final int LOGGER_OPTION_ENABLE_ASYNC_POSITION = 35;
    public static final int LOGGER_OPTION_ENABLE_ASYNC_PREPARE = 41;
    public static final int LOGGER_OPTION_ENABLE_AUTO_RANGE = 31;
    public static final int LOGGER_OPTION_ENABLE_ENGINE_LOOPER = 30;
    public static final int LOGGER_OPTION_ENABLE_FALLBACK_API = 34;
    public static final int LOGGER_OPTION_ENABLE_GEAR_STRATEGY = 127;
    public static final int LOGGER_OPTION_ENABLE_HTTPS = 33;
    public static final int LOGGER_OPTION_ENABLE_HW_DROP_NON_REF = 32;
    public static final int LOGGER_OPTION_ENABLE_LOADCONTROL = 36;
    public static final int LOGGER_OPTION_ENABLE_MASK = 48;
    public static final int LOGGER_OPTION_ENABLE_MASK_THREAD = 46;
    public static final int LOGGER_OPTION_ENABLE_MDL_ON_FIRST_PLAY = 173;
    public static final int LOGGER_OPTION_ENABLE_NATIVE_YV12 = 55;
    public static final int LOGGER_OPTION_ENABLE_OPT_SUB_LOAD = 50;
    public static final int LOGGER_OPTION_ENABLE_OUTLET_DROP_LIMIT = 97;
    public static final int LOGGER_OPTION_ENABLE_PLAYER_DEGRADE = 51;
    public static final int LOGGER_OPTION_ENABLE_POWER_STATISTICS = 126;
    public static final int LOGGER_OPTION_ENABLE_SMOOTH_CLOCK = 93;
    public static final int LOGGER_OPTION_ENABLE_SPEED_REPORT = 18;
    public static final int LOGGER_OPTION_ENABLE_SR = 28;
    public static final int LOGGER_OPTION_ENABLE_SR_STRATEGY = 133;
    public static final int LOGGER_OPTION_ENABLE_STRATEGY_CENTER = 96;
    public static final int LOGGER_OPTION_ENABLE_SUB = 49;
    public static final int LOGGER_OPTION_ENABLE_SUB_THREAD = 47;
    public static final int LOGGER_OPTION_ENABLE_THREAD_PRIORITY = 92;
    public static final int LOGGER_OPTION_ENABLE_TMP_LOG = 112;
    public static final int LOGGER_OPTION_ENABLE_VOLUME_ABLANCE = 29;
    public static final int LOGGER_OPTION_ENGINE_CODE_OPTIMIZATION = 168;
    public static final int LOGGER_OPTION_ENGINE_HASHCODE = 132;
    public static final int LOGGER_OPTION_EVENT_REPORT_LEVEL = 100;
    public static final int LOGGER_OPTION_EXPIRE_PLAY_CODE = 142;
    public static final int LOGGER_OPTION_FIRST_BUF_END_MS = 27;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_BITRATE = 101;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_ERROR = 104;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_HEADERS = 141;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_ON_AFTER_BEGIN = 109;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_ON_AFTER_END = 110;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_ON_BEFORE_BEGIN = 107;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_ON_BEFORE_END = 108;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_REASON = 102;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_SELECT_BEGIN = 105;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_SELECT_END = 106;
    public static final int LOGGER_OPTION_GEAR_STRATEGY_SPEED = 103;
    public static final int LOGGER_OPTION_HARDWARE_CONF_TYPE = 95;
    public static final int LOGGER_OPTION_HDR_TYPE = 90;
    public static final int LOGGER_OPTION_IMAGE_SCALE = 38;
    public static final int LOGGER_OPTION_IS_DEGRADE_RELEASE = 52;
    public static final int LOGGER_OPTION_IS_REPLAY = 14;
    public static final int LOGGER_OPTION_KEEP_FORMAT_THREAD_ALIVE = 44;
    public static final int LOGGER_OPTION_LARGE_SPL_TARGET_LOUDNESS = 191;
    public static final int LOGGER_OPTION_LAZY_SEEK = 43;
    public static final int LOGGER_OPTION_LOADTYPE_WHEN_SEEKING = 155;
    public static final int LOGGER_OPTION_LOG_ID = 15;
    public static final int LOGGER_OPTION_MASK_DELAY_LOADING = 145;
    public static final int LOGGER_OPTION_MASK_ENABLE_DATALOADER = 144;
    public static final int LOGGER_OPTION_MASK_FILE_HASH = 146;
    public static final int LOGGER_OPTION_MASK_FILE_SIZE = 147;
    public static final int LOGGER_OPTION_MASK_RANGE_OPT = 143;
    public static final int LOGGER_OPTION_MDL_GROUP_ID = 156;
    public static final int LOGGER_OPTION_MDL_INITIALIZE_ERROR = 176;
    public static final int LOGGER_OPTION_MDL_INITIALIZE_STATE = 175;
    public static final int LOGGER_OPTION_MDL_INVALID_CODE = 174;
    public static final int LOGGER_OPTION_MEDIA_ID = 154;
    public static final int LOGGER_OPTION_MEDIUM_SPL_TARGET_LOUDNESS = 190;
    public static final int LOGGER_OPTION_NETLEVEL_MAX_SAMPLE_COUNT = 23;
    public static final int LOGGER_OPTION_NETLEVEL_SAMPLE_INTERVAL = 22;
    public static final int LOGGER_OPTION_NETLEVEL_SPEED_FOR_AUDIO = 177;
    public static final int LOGGER_OPTION_NETWORK_QUALITY_VAR_STRING = 113;
    public static final int LOGGER_OPTION_NETWORK_TIMEOUT = 25;
    public static final int LOGGER_OPTION_NNSR = 79;
    public static final int LOGGER_OPTION_NOSURFACE_WHENAUDIORENDERSTART = 111;
    public static final int LOGGER_OPTION_ORIGIN_VIDEOID = 53;
    public static final int LOGGER_OPTION_OVERLAY_SHOWN = 58;
    public static final int LOGGER_OPTION_OVERLAY_TYPE = 57;
    public static final int LOGGER_OPTION_PRELOAD_MISS_REASON = 181;
    public static final int LOGGER_OPTION_PRELOAD_MISS_REASON_DASH_AUDIO = 183;
    public static final int LOGGER_OPTION_PRELOAD_MISS_REASON_DASH_VIDEO = 182;
    public static final int LOGGER_OPTION_PRE_RANGE_OFF = 81;
    public static final int LOGGER_OPTION_PROJECT_MODEL = 186;
    public static final int LOGGER_OPTION_RADIO_MODE = 11;
    public static final int LOGGER_OPTION_READ_CACHE_MODE = 80;
    public static final int LOGGER_OPTION_RENDER_TYPE = 37;
    public static final int LOGGER_OPTION_SEEKCOMPLETETIME = 169;
    public static final int LOGGER_OPTION_SEEKLOADINGBEGINTIME = 170;
    public static final int LOGGER_OPTION_SEEKLOADINGENDTIME = 171;
    public static final int LOGGER_OPTION_SET_AUDIO_FILE_HASH = 153;
    public static final int LOGGER_OPTION_SET_VIDEO_FILE_HASH = 152;
    public static final int LOGGER_OPTION_SKIP_FIND_STREAM_INFO = 40;
    public static final int LOGGER_OPTION_SMALL_SPL_TARGET_LOUDNESS = 189;
    public static final int LOGGER_OPTION_SPEED_INTERVAL = 17;
    public static final int LOGGER_OPTION_SPEED_REPORT_SAMPLING_RATE = 20;
    public static final int LOGGER_OPTION_SPEED_REPORT_WINDOW_SIZE = 19;
    public static final int LOGGER_OPTION_SR_FAIL_REASON = 139;
    public static final int LOGGER_OPTION_SR_MEDIA_INFO = 151;
    public static final int LOGGER_OPTION_SR_OPEN = 150;
    public static final int LOGGER_OPTION_SR_PROCESS_COST_TIME = 166;
    public static final int LOGGER_OPTION_SR_PROCESS_SUCCESS_RATE = 167;
    public static final int LOGGER_OPTION_SR_SATISFIED = 148;
    public static final int LOGGER_OPTION_SR_STATUS = 138;
    public static final int LOGGER_OPTION_SR_STRATEGY_CONFIG = 135;
    public static final int LOGGER_OPTION_SR_STRATEGY_MODE = 140;
    public static final int LOGGER_OPTION_SR_USE_TEXTURE = 149;
    public static final int LOGGER_OPTION_TARGET_LOUDNESS = 188;
    public static final int LOGGER_OPTION_TIME_AUDIO_DNS_START = 66;
    public static final int LOGGER_OPTION_TIME_AVFORMAT_OPEN = 68;
    public static final int LOGGER_OPTION_TIME_A_DEC_OPENED = 75;
    public static final int LOGGER_OPTION_TIME_A_DEC_START = 73;
    public static final int LOGGER_OPTION_TIME_A_HTTP_OPEN = 121;
    public static final int LOGGER_OPTION_TIME_A_RENDER_F = 77;
    public static final int LOGGER_OPTION_TIME_A_SOCK_CREATE = 125;
    public static final int LOGGER_OPTION_TIME_A_TRAN_OPEN = 123;
    public static final int LOGGER_OPTION_TIME_DEC_CREATE = 70;
    public static final int LOGGER_OPTION_TIME_DEMUXER_BEGIN = 78;
    public static final int LOGGER_OPTION_TIME_DEMUXER_CREATE = 69;
    public static final int LOGGER_OPTION_TIME_FORMATER_CREATE = 67;
    public static final int LOGGER_OPTION_TIME_HTTP_RESPONSE = 87;
    public static final int LOGGER_OPTION_TIME_MASK_OPEN = 84;
    public static final int LOGGER_OPTION_TIME_MASK_OPENED = 85;
    public static final int LOGGER_OPTION_TIME_OUTLET_CREATE = 71;
    public static final int LOGGER_OPTION_TIME_PLAYER_PREPARED = 88;
    public static final int LOGGER_OPTION_TIME_PREPARE_CALL = 65;
    public static final int LOGGER_OPTION_TIME_PT_NEW = 64;
    public static final int LOGGER_OPTION_TIME_SET_DATASOURCE = 63;
    public static final int LOGGER_OPTION_TIME_SUB_LOAD_FINISH = 82;
    public static final int LOGGER_OPTION_TIME_SUB_REQ_FINISH = 83;
    public static final int LOGGER_OPTION_TIME_V_DEC_OPENED = 74;
    public static final int LOGGER_OPTION_TIME_V_DEC_START = 72;
    public static final int LOGGER_OPTION_TIME_V_HTTP_OPEN = 120;
    public static final int LOGGER_OPTION_TIME_V_RENDER_F = 76;
    public static final int LOGGER_OPTION_TIME_V_SOCK_CREATE = 124;
    public static final int LOGGER_OPTION_TIME_V_TRAN_OPEN = 122;
    public static final int LOGGER_OPTION_TR_EFFECT_CHAIN_AVERAGE_TIME = 164;
    public static final int LOGGER_OPTION_TR_ERROR_CODE = 165;
    public static final int LOGGER_OPTION_TR_FPS = 162;
    public static final int LOGGER_OPTION_TR_PER_EFFECT_AVERAGE_TIME = 163;
    public static final int LOGGER_OPTION_TR_VERSION = 161;
    public static final int LOGGER_OPTION_VIDEO_ABNORMAL_CODE = 178;
    public static final int LOGGER_OPTION_VIDEO_ABNORMAL_INTERVAL = 179;
    public static final int LOGGER_OPTION_VIDEO_ABNORMAL_STRATEGY = 180;
    public static final int LOGGER_OPTION_VIDEO_DIMENSION = 185;
    public static final int LOGGER_OPTION_VIDEO_STREAM_DISABLED = 12;
    public static final int LOGGER_OPTION_VIDEO_STREAM_DURATION = 98;
    public static final int LOGGER_OPTION_VIDEO_STYLE = 184;
    public static final int LOGGER_OPTION_VIEW_SIZE = 187;
    public static final int LOGGER_OPTION_VMODEL_HAS_FALLBACK_API = 172;
    public static final int LOGGER_OPTION_VOLUME_BALANCE_SC = 192;
    public static final String LOG_CALLBACK_BEGIN_POS = "begin_pos";
    public static final String LOG_CALLBACK_CLOCK_DIFF = "clock_diff";
    public static final String LOG_CALLBACK_CODEC = "codec";
    public static final String LOG_CALLBACK_CONTAINER_FPS = "container_fps";
    public static final String LOG_CALLBACK_DECODE_HARDWARE = "hw";
    public static final String LOG_CALLBACK_DECODE_TIME = "decode_time";
    public static final String LOG_CALLBACK_ENABLE_NNSR = "enable_nnsr";
    public static final String LOG_CALLBACK_END_POS = "end_pos";
    public static final String LOG_CALLBACK_FIRST_FRAME_COST = "first_frame_cost";
    public static final String LOG_CALLBACK_LAST_SEEK_TIME = "seek_t";
    public static final String LOG_CALLBACK_LAST_SWITCH_RESOLUTION_TIME = "switch_resolution_t";
    public static final String LOG_CALLBACK_PLAY_START_TIME = "ps_t";
    public static final String LOG_CALLBACK_RENDER_DROP_COUNT = "render_drop_cnt";
    public static final String LOG_CALLBACK_TEXTURE_RENDER_ERROR = "surface_error_code";
    public static final String LOG_CALLBACK_TIME = "t";
    public static final String LOG_CALLBACK_TYPE = "type";
    public static final String LOG_CALLBACK_VIDEO_OUT_FPS = "video_out_fps";
    public static final String LOG_CALLBCK_QUALITY_DESC = "quality_desc";
    public static final String LOG_CALLBCK_RESOLUTION = "resolution";
    public static final int MDL_MODE_LOCAL_SERVER = 1;
    public static final int MDL_MODE_PROTOCOL = 2;
    public static final int PLAYER_DECODER_DROP_DYNAMIC = 2;
    public static final int PLAYER_DECODER_DROP_MAX_FPS = 1;
    public static final int PLAYER_HW_DECODER_DROP_DYNAMICDROP = 3;
    public static final int PLAYER_HW_DECODER_DROP_WHENAVOUTSYNCING = 2;
    public static final int PLAYER_HW_DECODER_DROP_WHENVOISINDROPSTATE = 1;
    public static final String SET_SURFACE_TYPE_EXTERNAL = "external";
    public static final String SET_SURFACE_TYPE_INTERNAL = "internal";
    public static final String SET_SURFACE_TYPE_SURFACE_CREATED = "surface created";
    public static final String SET_SURFACE_TYPE_SURFACE_DESTROYED = "surface destroyed";
    public static final int SPEED_IS_FIRST_FRAME = 0;
    public static final int SPEED_IS_PLAY_END = 1;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.log.IVideoEventLogger$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getIntOption(IVideoEventLogger r100, int r101) {
            return -1;
        }

        public static void $default$updateMultiNetworkSpeed(IVideoEventLogger r100, String r101) {
        }
    }

    public static final enum MdlInitializeState extends Enum<MdlInitializeState> {
        private static final /* synthetic */ MdlInitializeState[] $VALUES = null;
        public static final MdlInitializeState Default = null;
        public static final MdlInitializeState InitializeComplete = null;
        public static final MdlInitializeState InitializeError = null;
        public static final MdlInitializeState Initializing = null;

        static {
            MdlInitializeState r100 = new MdlInitializeState("Default", 0);
            Default = r100;
            MdlInitializeState r101 = new MdlInitializeState("Initializing", 1);
            Initializing = r101;
            MdlInitializeState r102 = new MdlInitializeState("InitializeComplete", 2);
            InitializeComplete = r102;
            MdlInitializeState r103 = new MdlInitializeState("InitializeError", 3);
            InitializeError = r103;
            $VALUES = new MdlInitializeState[]{r100, r101, r102, r103};
        }

        public static MdlInitializeState[] values() {
            return (MdlInitializeState[]) $VALUES.clone();
        }

        public static MdlInitializeState valueOf(String r100) {
            return (MdlInitializeState) r27.a.a(MdlInitializeState.class, r100);
        }

        private MdlInitializeState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MdlInvalidCode extends Enum<MdlInvalidCode> {
        private static final /* synthetic */ MdlInvalidCode[] $VALUES = null;
        public static final MdlInvalidCode EmptyFilepath = null;
        public static final MdlInvalidCode EmptyKey = null;
        public static final MdlInvalidCode None = null;
        public static final MdlInvalidCode OptionNotSet = null;
        public static final MdlInvalidCode ParamsWrong = null;
        public static final MdlInvalidCode ProxyNotSupport = null;
        public static final MdlInvalidCode StateError = null;

        static {
            MdlInvalidCode r100 = new MdlInvalidCode("None", 0);
            None = r100;
            MdlInvalidCode r101 = new MdlInvalidCode("EmptyKey", 1);
            EmptyKey = r101;
            MdlInvalidCode r102 = new MdlInvalidCode("EmptyFilepath", 2);
            EmptyFilepath = r102;
            MdlInvalidCode r103 = new MdlInvalidCode("OptionNotSet", 3);
            OptionNotSet = r103;
            MdlInvalidCode r104 = new MdlInvalidCode("StateError", 4);
            StateError = r104;
            MdlInvalidCode r105 = new MdlInvalidCode("ProxyNotSupport", 5);
            ProxyNotSupport = r105;
            MdlInvalidCode r110 = new MdlInvalidCode("ParamsWrong", 6);
            ParamsWrong = r110;
            $VALUES = new MdlInvalidCode[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static MdlInvalidCode[] values() {
            return (MdlInvalidCode[]) $VALUES.clone();
        }

        public static MdlInvalidCode valueOf(String r100) {
            return (MdlInvalidCode) r27.a.a(MdlInvalidCode.class, r100);
        }

        private MdlInvalidCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VideoEventCustomInfo extends Enum<VideoEventCustomInfo> {
        private static final /* synthetic */ VideoEventCustomInfo[] $VALUES = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_CAST_OBJECT = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_COMPANY_ID = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_CUSTOM_PLAY_SESSION_ID = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_FFTIME_CLICK = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_FFTIME_CUSTOMPLAY = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_FFTIME_INITENGINE = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_FFTIME_PLAYENGINE = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_FFTIME_VIDEOMODEL = null;
        public static final VideoEventCustomInfo VIDEOEVENT_CUSTOM_INFO_OTT_PLUGIN_VERSION = null;

        static {
            VideoEventCustomInfo r100 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_FFTIME_CLICK", 0);
            VIDEOEVENT_CUSTOM_INFO_FFTIME_CLICK = r100;
            VideoEventCustomInfo r101 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_FFTIME_VIDEOMODEL", 1);
            VIDEOEVENT_CUSTOM_INFO_FFTIME_VIDEOMODEL = r101;
            VideoEventCustomInfo r102 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_FFTIME_CUSTOMPLAY", 2);
            VIDEOEVENT_CUSTOM_INFO_FFTIME_CUSTOMPLAY = r102;
            VideoEventCustomInfo r103 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_FFTIME_INITENGINE", 3);
            VIDEOEVENT_CUSTOM_INFO_FFTIME_INITENGINE = r103;
            VideoEventCustomInfo r104 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_FFTIME_PLAYENGINE", 4);
            VIDEOEVENT_CUSTOM_INFO_FFTIME_PLAYENGINE = r104;
            VideoEventCustomInfo r105 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_CAST_OBJECT", 5);
            VIDEOEVENT_CUSTOM_INFO_CAST_OBJECT = r105;
            VideoEventCustomInfo r110 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_OTT_PLUGIN_VERSION", 6);
            VIDEOEVENT_CUSTOM_INFO_OTT_PLUGIN_VERSION = r110;
            VideoEventCustomInfo r111 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_COMPANY_ID", 7);
            VIDEOEVENT_CUSTOM_INFO_COMPANY_ID = r111;
            VideoEventCustomInfo r112 = new VideoEventCustomInfo("VIDEOEVENT_CUSTOM_INFO_CUSTOM_PLAY_SESSION_ID", 8);
            VIDEOEVENT_CUSTOM_INFO_CUSTOM_PLAY_SESSION_ID = r112;
            $VALUES = new VideoEventCustomInfo[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static VideoEventCustomInfo[] values() {
            return (VideoEventCustomInfo[]) $VALUES.clone();
        }

        public static VideoEventCustomInfo valueOf(String r100) {
            return (VideoEventCustomInfo) r27.a.a(VideoEventCustomInfo.class, r100);
        }

        private VideoEventCustomInfo(String r100, int r101) {
            super(r100, r101);
        }
    }

    void AVNoRenderEnd(int r100);

    void AVNoRenderStart(int r100, int r101);

    void AVOutSyncEnd(int r100);

    void AVOutSyncStart(int r100);

    void abrEventEnd(long r100);

    void abrEventStart(long r100, long r101);

    void accuBuffingTime(long r100);

    void accumulateSize();

    void addFeature(String r100, Object r101);

    void addLabelUsage(Map<String, Object> r100);

    void addSubtitleSwitchTime();

    void addWatchedDuration(int r100);

    void beginToPlay(String r100, long r101, String r102);

    void bufferDataSeconds(int r100);

    IMediaMetrics buildMetrics(int r100);

    void clockDiff(long r100);

    void codecName(int r100, int r101);

    void configResolution(String r100, String r101);

    void containerFps(float r100);

    void crosstalkHappen(int r100, ArrayList r101);

    void curAudioDecodeError(int r100);

    void curPlayBackTime(int r100);

    void curVideoDecodeError(int r100);

    void curVideoDecoderFps(int r100);

    void curVideoOutputFps(float r100);

    void curVideoRenderError(int r100);

    void deviceStartTime(int r100, long r101);

    void devicedOpenedTime(int r100, long r101);

    void didSentEvent(int r100);

    void dropCount(int r100);

    void enableSharp(int r100);

    void enableStartPlayAutomatically(boolean r100);

    void engineState(int r100);

    void fetchInfoComplete(IVideoModel r100, Error r101);

    void fetchInfoComplete(VideoModel r100, Error r101);

    void fetchedAndLeaveByUser(int r100);

    void firstDNSFailed(Error r100);

    int getAsyncInit();

    Map<String, Object> getCoreEventParam();

    long getCurDecoderBufferAccuT();

    int getCurDecoderBufferCount();

    String getEncryptKey();

    String getExtraInfo();

    Error getFirstError();

    int getIntOption(int r100);

    long getLeaveWaitTime();

    int getMovieStalledType();

    long getStalledAudioBufferTime();

    long getStalledVideoBufferTime();

    String getStringOption(int r100);

    String getTraceID();

    void hwCodecException(int r100);

    void hwCodecName(String r100);

    void initContentReporterIfNeeded(String r100);

    boolean isUploadLogEnabled();

    void logFirstError(Error r100);

    void logMessage(String r100);

    void logPluginException(String r100);

    void loopAgain();

    void mdlRetryResult(int r100, String r101, Error r102);

    void movieBufferDidReachEnd();

    void movieFinish(int r100);

    void movieFinish(int r100, String r101);

    void movieFinish(Error r100, int r101);

    void moviePreStalled(int r100);

    void movieShouldRetry(Error r100, int r101, int r102);

    void movieStallEnd(int r100);

    void movieStalled(int r100, int r101);

    void needRetryToFetch(Error r100, int r101);

    void onAVBadInterlaced(long r100);

    void onVideoInfoIdChanged(int r100);

    void pause();

    void play(boolean r100);

    void playbackBufferEnd();

    void playbackBufferStart();

    void prepareEnd();

    void prepareStart();

    void recordBlockReason(int r100, boolean r101);

    void renderSeekCompleted(int r100);

    void reportBufferingMetrics();

    void reset();

    void retryFinish();

    void saveEvent();

    void seekCompleted();

    void seekTo(int r100, int r101, boolean r102);

    void setAbrGeneralInfo(Map<String, Object> r100);

    void setAbrInfo(Map<String, Object> r100);

    void setAudioBufferLength(long r100);

    void setAudioDNSParseTime(long r100, int r101);

    void setAudioTranConnectTime(long r100);

    void setAudioTranFirstPacketTime(long r100);

    void setCDNTuningParam(String r100);

    void setCheckHijack(int r100);

    void setCurHost(String r100);

    void setCurIP(String r100);

    void setCurQuality(String r100);

    void setCurResolution(String r100);

    void setCurURL(String r100);

    void setCurrentQualityDesc(String r100);

    void setCustomInfo(VideoEventCustomInfo r100, Object r101);

    void setCustomP2PCDNType(int r100);

    void setCustomStr(String r100);

    void setDNSEndTime(long r100);

    void setDNSParseTime(long r100, int r101);

    void setDNSStartTime(long r100, int r101);

    void setDashAudioCacheSize(long r100);

    void setDashVideoCacheSize(long r100);

    void setDecodeFirstAudioFrameTime(long r100);

    void setDecodeFirstVideoFrameTime(long r100);

    void setDisableAccurateStart(int r100);

    void setDnsMode(int r100);

    void setDrmTokenUrl(String r100);

    void setDrmType(int r100);

    void setDuration(int r100);

    void setEffect(Bundle r100);

    void setEnableBash(int r100);

    void setEnableBmfSr(int r100);

    void setEnableMDL(int r100);

    void setEncryptKey(String r100);

    void setFeed(IVideoModel r100);

    void setFeed(VideoModel r100);

    void setFirstPlayerFirstFrameTime(long r100);

    void setFloatOption(int r100, float r101);

    void setFramesDropNum(int r100);

    void setGearStrategyEvent(Map<String, Object> r100);

    void setHijackCode(int r100);

    void setHijackRetry(int r100);

    void setInitialHost(String r100);

    void setInitialIP(String r100);

    void setInitialQuality(String r100);

    void setInitialQualityType(int r100);

    void setInitialResolution(String r100);

    void setInitialURL(String r100, String r101);

    void setIntOption(int r100, int r101);

    void setIsEnableABR(int r100);

    void setIsEnableSelectBitrate(int r100);

    void setIsMultiDimensionsInput(int r100);

    void setIsMultiDimensionsOut(int r100);

    void setIsVideoModelCache(int r100);

    void setLoggerTimes(int r100);

    void setLongOption(int r100, long r101);

    void setLooping(boolean r100);

    void setMaskErrorCode(int r100);

    void setMaskUrl(String r100);

    void setMediaCodecRender(int r100);

    void setNetWorkTryCount(int r100);

    void setNetworkSpeedFrom(double r100, int r101);

    void setP2PCDNType(int r100);

    void setP2PSDKVersion(String r100);

    void setP2PUrl(String r100);

    void setPlayAPIVersion(int r100, String r101);

    void setPlayType(int r100);

    void setPlaybackParams(PlaybackParams r100);

    void setPlayerCreatedT(long r100);

    void setPlayerHostAddr(String r100);

    void setPlayerSurface(String r100);

    void setPlayerViewSize(int r100, int r101);

    void setPrivateFieldFlag(Map<String, String> r100);

    void setProxyUrl(String r100);

    void setReceiveFirstAudioFrameTime(long r100);

    void setReceiveFirstVideoFrameTime(long r100);

    void setSRPreloadInfo(Map<String, Object> r100);

    void setSRStrategyInfo(SRStrategy r100);

    void setSelectResult(Map<String, String> r100);

    void setSourceRefreshLog(JSONObject r100);

    void setSourceType(int r100, String r101);

    void setSpeedPredictorAlgoType(int r100);

    void setSrAlgorithm(int r100);

    void setSrScaleType(int r100);

    void setStartPlayHeight(int r100);

    void setStartPlayWidth(int r100);

    void setStartTime(int r100);

    void setStringOption(int r100, String r101);

    void setSubTag(String r100);

    void setSubtitleError(String r100);

    void setSubtitleIdsCount(int r100);

    void setSubtitleRequestUrl(String r100);

    void setSurface(String r100);

    void setSurfaceBegin();

    void setSurfaceEnd();

    void setSurfaceSourceType(String r100);

    void setTag(String r100);

    void setTextureRenderError(String r100);

    void setTraceID(String r100);

    void setTranConnectTime(long r100);

    void setTranFirstPacketTime(long r100);

    void setUploadLogEnabled(boolean r100);

    void setVUArray(ArrayList r100);

    void setVideoBufferLength(long r100);

    void setVideoCacheSize(long r100);

    void setVrDisplayDistance(float r100);

    void setVrDisplayFrameRate(float r100);

    void setVrHeadMovementDelay(long r100);

    void setVrScreenRefreshRate(int r100);

    void showedFirstAVSyncVideoFrame(long r100);

    void showedFirstFrame();

    void showedOneFrame();

    void stop(int r100);

    void switchResolution();

    void switchResolution(String r100, String r101, boolean r102);

    void switchResolutionEnd(boolean r100);

    void updateGlobalNetworkSpeed(long r100, long r101, int r102);

    void updateMultiNetworkSpeed(String r100);

    void updateNetworkSpeedPredictorSampleMutiValue(SpeedPredictorResultCollection r100, SpeedPredictorResultCollection r101, long r102);

    void updateNetworkSpeedPredictorSampleValue(String r100, String r101, float r102, float r103, float r104, float r105, long r106, Map<String, String> r107, Map<String, String> r110);

    void updateVideoInfo(IVideoModel r100);

    void updateVideoInfo(VideoModel r100);

    void useAsyncInit(int r100, int r101);

    void useCodecPool(int r100);

    void useHardwareDecode(int r100);

    void useTextureRender(int r100);

    void validateVideoMetaInfoFail(Error r100);

    void watchFinish();
}
