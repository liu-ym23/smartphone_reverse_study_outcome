package com.ss.ttvideoengine;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.vcloud.strategy.IPreloadTaskCallbackListener;
import com.bytedance.vcloud.strategy.ISelectBitrateListener;
import com.bytedance.vcloud.vctrace.VCTrace;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.bduploader.UploadKeys;
import com.ss.mediakit.medialoader.AVMDLCopyOperation;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLDataLoaderListener;
import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.ss.mediakit.medialoader.AVMDLLibraryManagerWrapper;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.medialoader.AVMDLStartCompleteListener;
import com.ss.mediakit.medialoader.AVMDLTaskEventListener;
import com.ss.mediakit.medialoader.LoaderListener;
import com.ss.mediakit.net.AVMDLDNSParser;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.ss.ttm.vcshared.VCBaseKitLoader;
import com.ss.ttvideoengine.cache.CopyCacheItem;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.IVideoEventUploader;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.log.VideoEventBase;
import com.ss.ttvideoengine.log.VideoEventEngineUploader;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.MediaBitrateFitterInfo;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.net.NetUtils;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.portrait.PortraitChangeListener;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preload.PreloadConfig;
import com.ss.ttvideoengine.preload.PreloadLoadProgressCenter;
import com.ss.ttvideoengine.preload.PreloadMedia;
import com.ss.ttvideoengine.preload.PreloadModelMedia;
import com.ss.ttvideoengine.preload.PreloadScene;
import com.ss.ttvideoengine.preload.PreloadTaskConfig;
import com.ss.ttvideoengine.preload.PreloadURLMedia;
import com.ss.ttvideoengine.preload.PreloadUtil;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.selector.strategy.GearStrategyContext;
import com.ss.ttvideoengine.selector.strategy.GearStrategySC;
import com.ss.ttvideoengine.selector.strategy.IGearStrategyListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.strategy.CodecStrategyAdapter;
import com.ss.ttvideoengine.source.strategy.SmartUrlFetcher;
import com.ss.ttvideoengine.strategrycenter.ISelectBitrateCallback;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.strategy.StrategyManager;
import com.ss.ttvideoengine.utils.ABLock;
import com.ss.ttvideoengine.utils.ABLockWrapper;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.FormatProvider;
import com.ss.ttvideoengine.utils.MDLExtraInfoHelper;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.ss.ttvideoengine.utils.ValueWeakReference;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener, PortraitChangeListener {
    public static final int DATALOADER_KEY_CHECK_CONTENT_TYPE_METHOD = 1168;
    public static final int DATALOADER_KEY_DEVICE_SCORE = 123;
    public static final int DATALOADER_KEY_DISABLE_THREAD_POOL = 1169;
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_ENABLE_CENTER_PRELOAD_PROGRESS = 9017;
    public static final int DATALOADER_KEY_ENABLE_CUSTOMDIR_SEARCH_ALL_PATH = 2037;
    public static final int DATALOADER_KEY_ENABLE_ENGINE_PORTRAIT = 2036;
    public static final int DATALOADER_KEY_ENABLE_FILECACHE_V2 = 1007;
    public static final int DATALOADER_KEY_ENABLE_FILE_RING_BUFFER = 1009;
    public static final int DATALOADER_KEY_ENABLE_HLS_PROXY = 9016;
    public static final int DATALOADER_KEY_ENABLE_HLS_PROXY_VV_CONTROL_CHECK = 80001;
    public static final int DATALOADER_KEY_ENABLE_LOADER_LOG_EXTRACT_URLS = 1166;
    public static final int DATALOADER_KEY_ENABLE_LOAD_MDLV2_FULLLIB = 9030;
    public static final int DATALOADER_KEY_ENABLE_LOAD_P2P_ASYNC = 9015;
    public static final int DATALOADER_KEY_ENABLE_MUTLI_DOWNLOAD_PATH = 9014;
    public static final int DATALOADER_KEY_ENABLE_NOTIFY_ERROR = 9018;
    public static final int DATALOADER_KEY_ENABLE_NOTIFY_NOT_ONLY_NETWORK_ERROR = 9019;
    public static final int DATALOADER_KEY_ENABLE_PRELOAD_ALL_TS = 9023;
    public static final int DATALOADER_KEY_ENABLE_PRELOAD_FIRST_TS = 9021;
    public static final int DATALOADER_KEY_ENABLE_PRELOAD_REUSE = 60;
    public static final int DATALOADER_KEY_ENABLE_UPDATE_NET_STATUS = 1170;
    public static final int DATALOADER_KEY_ENABLE_USE_ORIGINAL_URL = 1164;
    public static final int DATALOADER_KEY_FILE_EXTEND_BUFFER = 1010;
    public static final int DATALOADER_KEY_GET_ACCESS_TYPE = 1008;
    public static final int DATALOADER_KEY_GET_MDL_PROTOCOL_HANDLE = 1003;
    public static final int DATALOADER_KEY_GLOBAL_OPTION_END = 59999;
    public static final int DATALOADER_KEY_GLOBAL_OPTION_START = 50000;
    public static final int DATALOADER_KEY_HEART_BEAT_INTERVAL = 61;
    public static final int DATALOADER_KEY_INT64_P2P_STRAGETY_VALUE = 1142;
    public static final int DATALOADER_KEY_INT_ACCESS_CHECK_LEVEL = 1102;
    public static final int DATALOADER_KEY_INT_ALLOW_TRY_THE_LAST_URL = 1133;
    public static final int DATALOADER_KEY_INT_AUDIO_PRELOAD_FIRST = 1113;
    public static final int DATALOADER_KEY_INT_BACKUP_DNS_TYPE = 91;
    public static final int DATALOADER_KEY_INT_BLOCK_HOST_ERR_IP_COUNT = 1148;
    public static final int DATALOADER_KEY_INT_CHECKSUM_LEVEL = 13;
    public static final int DATALOADER_KEY_INT_CHECK_CACHE_DIR = 2025;
    public static final int DATALOADER_KEY_INT_CHECK_PRELOAD_LEVEL = 1111;
    public static final int DATALOADER_KEY_INT_CONNECT_POOL_STRAGETY_VALUE = 1144;
    public static final int DATALOADER_KEY_INT_COOKIE_TOKEN_CHECK_LEVEL = 1514;
    public static final int DATALOADER_KEY_INT_CURRENT_ACCESS_TYPE = 1104;
    public static final int DATALOADER_KEY_INT_CUR_DISK_SIZE_MB = 2103;
    public static final int DATALOADER_KEY_INT_CUR_MEMORY_SIZE_MB = 2105;
    public static final int DATALOADER_KEY_INT_DASH_AUDIO_PRELOAD_RATIO = 1504;
    public static final int DATALOADER_KEY_INT_DASH_MIN_AUDIO_PRELOAD_SIZE = 1503;
    public static final int DATALOADER_KEY_INT_DEFAULT_DNS_EXPIRED_TIME = 1141;
    public static final int DATALOADER_KEY_INT_DEV_DISK_SIZE_MB = 2102;
    public static final int DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB = 2104;
    public static final int DATALOADER_KEY_INT_DISABLE_DNS_PARALLEL_FOR_EXPIRED_CACHE_PARSE = 80004;
    public static final int DATALOADER_KEY_INT_DISABLE_FILEPATH_CHECK = 9022;
    public static final int DATALOADER_KEY_INT_DISABLE_RECENT_CACHE = 2027;
    public static final int DATALOADER_KEY_INT_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 92;
    public static final int DATALOADER_KEY_INT_ENABLE_BACKUP_IP = 115;
    public static final int DATALOADER_KEY_INT_ENABLE_BENCHMARK_IO = 93;
    public static final int DATALOADER_KEY_INT_ENABLE_BUFFER_PRELOAD = 1163;
    public static final int DATALOADER_KEY_INT_ENABLE_BYTEMEDIANETLOADER = 1701;
    public static final int DATALOADER_KEY_INT_ENABLE_CACHE_REQRANGE = 1134;
    public static final int DATALOADER_KEY_INT_ENABLE_DNS_BACKUP_IP = 104;
    public static final int DATALOADER_KEY_INT_ENABLE_DNS_LOG = 106;
    public static final int DATALOADER_KEY_INT_ENABLE_DNS_PARALLEL_PARSE = 103;
    public static final int DATALOADER_KEY_INT_ENABLE_DNS_REFRESH = 105;
    public static final int DATALOADER_KEY_INT_ENABLE_DOWNLOADER_LOG = 21;
    public static final int DATALOADER_KEY_INT_ENABLE_DUMPLIBMD5 = 9000;
    public static final int DATALOADER_KEY_INT_ENABLE_DYNAMIC_SOCKET_TIMEOUT = 1137;
    public static final int DATALOADER_KEY_INT_ENABLE_EARLY_DATA = 1160;
    public static final int DATALOADER_KEY_INT_ENABLE_EVENTINFO = 200;
    public static final int DATALOADER_KEY_INT_ENABLE_EXTERN_DNS = 7;
    public static final int DATALOADER_KEY_INT_ENABLE_FILE_MUTEX_OPTIMIZE = 2017;
    public static final int DATALOADER_KEY_INT_ENABLE_FIRST_VIDEO_NATIVEMDL = 1012;
    public static final int DATALOADER_KEY_INT_ENABLE_HLS = 9008;
    public static final int DATALOADER_KEY_INT_ENABLE_IOMANAGER = 1150;
    public static final int DATALOADER_KEY_INT_ENABLE_IP_BUCKET = 64;
    public static final int DATALOADER_KEY_INT_ENABLE_LAZY_BUFFERPOOL = 1118;
    public static final int DATALOADER_KEY_INT_ENABLE_LIBMANAGER = 9013;
    public static final int DATALOADER_KEY_INT_ENABLE_LOADER_PREEMPT = 1101;
    public static final int DATALOADER_KEY_INT_ENABLE_LOADER_SEEK = 1135;
    public static final int DATALOADER_KEY_INT_ENABLE_LOG_OPTIMIZATION = 80002;
    public static final int DATALOADER_KEY_INT_ENABLE_MDLV2 = 1154;
    public static final int DATALOADER_KEY_INT_ENABLE_MISS_REASON = 2031;
    public static final int DATALOADER_KEY_INT_ENABLE_MULTI_NETWORK = 1501;
    public static final int DATALOADER_KEY_INT_ENABLE_NETSCHEDULER = 1128;
    public static final int DATALOADER_KEY_INT_ENABLE_NETWORK_CHANGED_LISTEN = 1011;
    public static final int DATALOADER_KEY_INT_ENABLE_NEW_BUFFERPOOL = 1120;
    public static final int DATALOADER_KEY_INT_ENABLE_OKHTTPLOADER = 31;
    public static final int DATALOADER_KEY_INT_ENABLE_OWN_VDP_PRELOAD_NOTIFY = 1151;
    public static final int DATALOADER_KEY_INT_ENABLE_P2P_STRAGETY_CONTROL = 95;
    public static final int DATALOADER_KEY_INT_ENABLE_P2P_UPLOAD = 2100;
    public static final int DATALOADER_KEY_INT_ENABLE_PLAYINFO_CACHE = 1124;
    public static final int DATALOADER_KEY_INT_ENABLE_PLAY_LOG = 1127;
    public static final int DATALOADER_KEY_INT_ENABLE_PRECONNECT = 1001;
    public static final int DATALOADER_KEY_INT_ENABLE_PREPARSE_HOST = 114;
    public static final int DATALOADER_KEY_INT_ENABLE_REPORT_SPEED = 1100;
    public static final int DATALOADER_KEY_INT_ENABLE_SESSION_REUSE = 101;
    public static final int DATALOADER_KEY_INT_ENABLE_SOCKET_IDLE_TIMEOUT = 9;
    public static final int DATALOADER_KEY_INT_ENABLE_SOCKET_REUSE = 8;
    public static final int DATALOADER_KEY_INT_ENABLE_SPEED_ENGINE = 1171;
    public static final int DATALOADER_KEY_INT_ENABLE_SPEED_PREDICT = 1162;
    public static final int DATALOADER_KEY_INT_ENABLE_SPEED_REPORT = 1172;
    public static final int DATALOADER_KEY_INT_ENABLE_SPLIT_PRELOAD_WITH_DATALOADER = 1155;
    public static final int DATALOADER_KEY_INT_ENABLE_STORAGE_MODULE = 2000;
    public static final int DATALOADER_KEY_INT_ENABLE_STRATEGY_CENTER_CANCEL_ALL = 1505;
    public static final int DATALOADER_KEY_INT_ENABLE_SYNDNS_P2P = 1108;
    public static final int DATALOADER_KEY_INT_ENABLE_THREADPOOL_CHECK_IDLE = 2010;
    public static final int DATALOADER_KEY_INT_ENABLE_TRACEID_PRELOAD_LOG = 2033;
    public static final int DATALOADER_KEY_INT_ENABLE_TTNETLOADER = 22;
    public static final int DATALOADER_KEY_INT_ENABLE_TTQUICHELOADER = 24;
    public static final int DATALOADER_KEY_INT_ENABLE_TTQUICHELOADER_CHECK_WITH_NETWORK_TYPE = 25;
    public static final int DATALOADER_KEY_INT_ENABLE_USE_GROUP_ID = 2026;
    public static final int DATALOADER_KEY_INT_ENABLE_VIDEOMDOEL_HIT_CACHE_CALLBACK = 12002;
    public static final int DATALOADER_KEY_INT_ENABLE_WAIT_NET_REACHABLE = 2016;
    public static final int DATALOADER_KEY_INT_ENCRYPT_VERSION = 30;
    public static final int DATALOADER_KEY_INT_ERROR_STATE_TRUST_TIME = 65;
    public static final int DATALOADER_KEY_INT_FILEMANAGER_INTERVAL = 2035;
    public static final int DATALOADER_KEY_INT_FILE_EXTEND_SIZE = 1146;
    public static final int DATALOADER_KEY_INT_FIRSTRANGE_LEFT_THRESHOLD = 1132;
    public static final int DATALOADER_KEY_INT_FORBID_BYPASS_COOKIE = 1117;
    public static final int DATALOADER_KEY_INT_FORBID_NATIVE_MDL_FOR_ORIGINAL_URL = 32;
    public static final int DATALOADER_KEY_INT_FORCE_DNS_EXPIRED_TIME = 1140;
    public static final int DATALOADER_KEY_INT_GLOBAL_SPEED_SAMPLE_INTERVAL = 113;
    public static final int DATALOADER_KEY_INT_HEADER_DATA_MEM_CACHE = 1114;
    public static final int DATALOADER_KEY_INT_IGNOREPLAYINFO = 9001;
    public static final int DATALOADER_KEY_INT_IGNORE_PLAYER_STALL = 18;
    public static final int DATALOADER_KEY_INT_IGNORE_TEXT_PLAIN_SPEED_TEST = 2022;
    public static final int DATALOADER_KEY_INT_INITIAL_SOCKET_TIMEOUT = 1138;
    public static final int DATALOADER_KEY_INT_IPV4_NUM = 1116;
    public static final int DATALOADER_KEY_INT_IPV6_NUM = 1115;
    public static final int DATALOADER_KEY_INT_IS_CLOSE_FILE_CACHE = 50;
    public static final int DATALOADER_KEY_INT_IS_ENABLE_MAX_CACHE_AGE_FOR_ALL_DIR = 56;
    public static final int DATALOADER_KEY_INT_LIMIT_IP_NUM = 2012;
    public static final int DATALOADER_KEY_INT_LOADER_TYPE = 5;
    public static final int DATALOADER_KEY_INT_MAIN_DNS_TYPE = 90;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_MAX_ALIVE_HOST_NUM = 1145;
    public static final int DATALOADER_KEY_INT_MAX_CACHE_AGE = 55;
    public static final int DATALOADER_KEY_INT_MAX_FILE_MEM_CACHE_NUM = 1159;
    public static final int DATALOADER_KEY_INT_MAX_FILE_MEM_CACHE_SIZE = 1158;
    public static final int DATALOADER_KEY_INT_MAX_IP_COUNT = 63;
    public static final int DATALOADER_KEY_INT_MAX_SOCKET_REUSE_NUM = 1139;
    public static final int DATALOADER_KEY_INT_MAX_TLS_VEERSION = 100;
    public static final int DATALOADER_KEY_INT_MDL_CLOSE_LOCAL_SERVER = 1013;
    public static final int DATALOADER_KEY_INT_MIN_ALLOW_SPEED = 1147;
    public static final int DATALOADER_KEY_INT_MULTI_SPEED_SAMPL_INTERVAL = 112;
    public static final int DATALOADER_KEY_INT_NEED_DL_LOAD_P2P_LIB = 15;
    public static final int DATALOADER_KEY_INT_NEED_MDL_LOAD_MDLV2_LIB = 33;
    public static final int DATALOADER_KEY_INT_NEED_SPEED_TEST_BY_TIMEINTERNAL = 1112;
    public static final int DATALOADER_KEY_INT_NETSCHEDULER_BLOCK_ALL_NETERR = 1129;
    public static final int DATALOADER_KEY_INT_NETSCHEDULER_BLOCK_DURATION_MS = 1131;
    public static final int DATALOADER_KEY_INT_NETSCHEDULER_BLOCK_ERR_COUNT = 1130;
    public static final int DATALOADER_KEY_INT_NETWORK_CHANGED = 1000;
    public static final int DATALOADER_KEY_INT_NET_LOG_MAX_SIZE = 2024;
    public static final int DATALOADER_KEY_INT_NET_UNREACHABLE_STOP_RETRY = 2015;
    public static final int DATALOADER_KEY_INT_NET_UNREACHABLE_TIMEOUT = 2019;
    public static final int DATALOADER_KEY_INT_NEW_BUFFERPOOL_BLOCK_SIZE = 1121;
    public static final int DATALOADER_KEY_INT_NEW_BUFFERPOOL_GROWCOUNT = 1123;
    public static final int DATALOADER_KEY_INT_NEW_BUFFERPOOL_RESIDENT_SIZE = 1122;
    public static final int DATALOADER_KEY_INT_NON_BLOCK_RANGE_MAX_KB = 2014;
    public static final int DATALOADER_KEY_INT_NON_BLOCK_RANGE_MODE = 2013;
    public static final int DATALOADER_KEY_INT_ONLY_USE_CDN = 66;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_OPTIMIZE_RANGE = 2023;
    public static final int DATALOADER_KEY_INT_P2P_COST_TAG_1 = 2020;
    public static final int DATALOADER_KEY_INT_P2P_COST_TAG_2 = 2021;
    public static final int DATALOADER_KEY_INT_P2P_FIRSTRANGE_LOADER_TYPE = 1143;
    public static final int DATALOADER_KEY_INT_P2P_FIRSTRANGE_TYPE = 1125;
    public static final int DATALOADER_KEY_INT_P2P_LEVEL = 16;
    public static final int DATALOADER_KEY_INT_P2P_PREDOWN = 1126;
    public static final int DATALOADER_KEY_INT_P2P_PREDOWN_PEER_COUNT = 1136;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_EXPIRED_TIME = 99;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_MAX_BUFFERING_TIME = 98;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_MAX_LEAVE_WAIT_TIME = 97;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_MIN_NET_NETWORK_LEVEL = 110;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_MIN_NET_SPEED = 109;
    public static final int DATALOADER_KEY_INT_P2P_STRAGETY_MIN_PLAYNUM = 96;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_PCDN_AUTO = 34;
    public static final int DATALOADER_KEY_INT_PLAY_LOG = 10;
    public static final int DATALOADER_KEY_INT_PRECONNECT_NUM = 1002;
    public static final int DATALOADER_KEY_INT_PRELOAD_CHECK_URL = 1513;
    public static final int DATALOADER_KEY_INT_PRELOAD_FLOAT_SIZE = 19;
    public static final int DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT = 2032;
    public static final int DATALOADER_KEY_INT_PRELOAD_LOWER_BOUND_BUFFER_MS = 1156;
    public static final int DATALOADER_KEY_INT_PRELOAD_PRE_CONNECT = 20;
    public static final int DATALOADER_KEY_INT_PRELOAD_STRAGETY = 12;
    public static final int DATALOADER_KEY_INT_PRELOAD_UPPER_BOUND_BUFFER_MS = 1157;
    public static final int DATALOADER_KEY_INT_PRELOAD_WAIT_LIST_TYPE = 80;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_SESSION_CACHE_INTERVAL = 2034;
    public static final int DATALOADER_KEY_INT_SESSION_TIMEOUT = 1119;
    public static final int DATALOADER_KEY_INT_SETTINGS_ENABLE = 119;
    public static final int DATALOADER_KEY_INT_SET_BACKUP_LOADERTYPE = 1109;
    public static final int DATALOADER_KEY_INT_SKIP_CDN_BEFORE_EXPIRED_SEC = 2018;
    public static final int DATALOADER_KEY_INT_SOCKET_BUFF_KB = 1105;
    public static final int DATALOADER_KEY_INT_SOCKET_RECV_BUFF_BYTES = 1161;
    public static final int DATALOADER_KEY_INT_SPEED_COEFFICIENTVALUE = 94;
    public static final int DATALOADER_KEY_INT_START_NEXT_DOWNLOAD_THRESHOLD = 1103;
    public static final int DATALOADER_KEY_INT_STO_IO_WRITE_LIMIT_KB_TH1 = 2004;
    public static final int DATALOADER_KEY_INT_STO_IO_WRITE_LIMIT_KB_TH2 = 2005;
    public static final int DATALOADER_KEY_INT_STO_MAX_IDLE_TIME_SEC = 2006;
    public static final int DATALOADER_KEY_INT_STO_PLAY_DLD_WIN_SIZE_KB_LS = 2002;
    public static final int DATALOADER_KEY_INT_STO_PLAY_DLD_WIN_SIZE_KB_NM = 2001;
    public static final int DATALOADER_KEY_INT_STO_RING_BUFFER_SIZE_KB = 2003;
    public static final int DATALOADER_KEY_INT_TEST_SPEED_VERSION = 14;
    public static final int DATALOADER_KEY_INT_THREADPOOL_IDLE_TTL_SECOND = 2011;
    public static final int DATALOADER_KEY_INT_THREADPOOL_MIN_COUNT = 2009;
    public static final int DATALOADER_KEY_INT_THREAD_STACK_SIZE_LEVEL = 2008;
    public static final int DATALOADER_KEY_INT_TRACE_HOST = 122;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_INT_TTNETLOADER_CRONET_BUF_SIZE_KB = 23;
    public static final int DATALOADER_KEY_INT_UPDATE_FILE_INTERNAL = 2028;
    public static final int DATALOADER_KEY_INT_USE_NEW_SPEED_TEST_SINGLE = 121;
    public static final int DATALOADER_KEY_INT_VERSION_INFO = 6;
    public static final int DATALOADER_KEY_INT_WRITEFILENOTIFY_INTERVALMS = 17;
    public static final int DATALOADER_KEY_INT_XY_LIB_VALUE = 1110;
    public static final int DATALOADER_KEY_IS_SUPPORT_HLS = 9009;
    public static final int DATALOADER_KEY_LIVE_CACHE_HTTP_TO_P2P = 506;
    public static final int DATALOADER_KEY_LIVE_CAHCE_P2P_TO_HTTP = 507;
    public static final int DATALOADER_KEY_LIVE_CONTAINER_STRING = 514;
    public static final int DATALOADER_KEY_LIVE_ENEBALE_P2P = 500;
    public static final int DATALOADER_KEY_LIVE_LOADER_ENABLE = 502;
    public static final int DATALOADER_KEY_LIVE_LOADER_TYPE = 501;
    public static final int DATALOADER_KEY_LIVE_MOBILE_DOWNLOAD_ALLOW = 511;
    public static final int DATALOADER_KEY_LIVE_MOBILE_UPLOAD_ALLOW = 510;
    public static final int DATALOADER_KEY_LIVE_RECV_DATA_TIMEOUT = 513;
    public static final int DATALOADER_KEY_LIVE_TRY_SWITCH_P2P_TIMES = 508;
    public static final int DATALOADER_KEY_LIVE_WAIT_P2P_THREDTHOLD = 509;
    public static final int DATALOADER_KEY_LIVE_WATCH_DURATION_THRESHOLD = 505;
    public static final int DATALOADER_KEY_LONG_DOWNLOAD_MONITOR_MIN_LOAD_SIZE = 1153;
    public static final int DATALOADER_KEY_LONG_DOWNLOAD_MONITOR_TIME_INTERNAL = 1152;
    public static final int DATALOADER_KEY_LONG_MAXCACHESIZE_FOR_DEFAULTDIR = 80003;
    public static final int DATALOADER_KEY_MAX_LOADER_LOG_NUM = 1167;
    public static final int DATALOADER_KEY_MDL_OPTION_END = 89999;
    public static final int DATALOADER_KEY_MDL_OPTION_START = 80000;
    public static final int DATALOADER_KEY_NOTIFY_DNSLOG = 6;
    public static final int DATALOADER_KEY_NOTIFY_DOWNLOADERLOG = 7;
    public static final int DATALOADER_KEY_NOTIFY_FILE_DELETE_SIZE_BY_USEDTIME = 31;
    public static final int DATALOADER_KEY_NOTIFY_HEARTBEATLOG = 3;
    public static final int DATALOADER_KEY_NOTIFY_INVALID = -1;
    public static final int DATALOADER_KEY_NOTIFY_IOSPEEDINFO = 20;
    public static final int DATALOADER_KEY_NOTIFY_MDL_STARTED = 11;
    public static final int DATALOADER_KEY_NOTIFY_NEWLOG = 10;
    public static final int DATALOADER_KEY_NOTIFY_OWNLIVEMDLLOG = 4;
    public static final int DATALOADER_KEY_NOTIFY_OWNLIVEMDLLOG_SAMPLE = 5;
    public static final int DATALOADER_KEY_NOTIFY_OWNVDPLOG = 1;
    public static final int DATALOADER_KEY_NOTIFY_PRELOADEND = 21;
    public static final int DATALOADER_KEY_NOTIFY_PRELOAD_CANCLLED = 8;
    public static final int DATALOADER_KEY_NOTIFY_SPEEDINFO = 2;
    public static final int DATALOADER_KEY_NOTIFY_SPEEDINFO_BY_TIMEINTERNAL = 32;
    public static final int DATALOADER_KEY_NOTIFY_TASKLOG = 0;
    public static final int DATALOADER_KEY_NOTIFY_TASKOPEN = 30;
    public static final int DATALOADER_KEY_NOTIFY_TRIGGER_PRELOAD = 9;
    public static final int DATALOADER_KEY_PLAY_INFO_BUFFERING_END = 26;
    public static final int DATALOADER_KEY_PLAY_INFO_BUFFERING_START = 25;
    public static final int DATALOADER_KEY_PLAY_INFO_CURRENT_BUFFER = 27;
    public static final int DATALOADER_KEY_PLAY_INFO_LOAD_PERCENT = 24;
    public static final int DATALOADER_KEY_PLAY_INFO_PLAYING_POS = 23;
    public static final int DATALOADER_KEY_PLAY_INFO_RENDER_START = 22;
    public static final int DATALOADER_KEY_PLAY_INFO_SEEK_ACTION = 28;
    public static final int DATALOADER_KEY_SET_ALOG_WRITE_PTR = 62;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_STATUS = 1004;
    public static final int DATALOADER_KEY_SET_RINGBUFFER_SIZE_KB = 1006;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int DATALOADER_KEY_STRING_DM_DOMAIN = 9003;
    public static final int DATALOADER_KEY_STRING_DOWNLOAD_DIR = 111;
    public static final int DATALOADER_KEY_STRING_DYNAMIC_PRECONNECT_CONFIG_STR = 1165;
    public static final int DATALOADER_KEY_STRING_FILE_RINGBUFFER_OPT_STR = 1510;
    public static final int DATALOADER_KEY_STRING_FORESIGHT_DOMAIN = 9004;
    public static final int DATALOADER_KEY_STRING_GET_CUSTON_UA = 1509;
    public static final int DATALOADER_KEY_STRING_GOOGLE_DNS_HOST = 108;
    public static final int DATALOADER_KEY_STRING_IS_CACHE_DIR_LIST_STR = 9011;
    public static final int DATALOADER_KEY_STRING_IS_P2P_CONFIG_STR = 9012;
    public static final int DATALOADER_KEY_STRING_IS_SOCKET_TRAIN_CENTER_CONFIG = 9010;
    public static final int DATALOADER_KEY_STRING_KEYSERVICE_DOMAINS = 9006;
    public static final int DATALOADER_KEY_STRING_KEY_TOKEN = 9007;
    public static final int DATALOADER_KEY_STRING_MDL_EXTENSION_OPTS = 1500;
    public static final int DATALOADER_KEY_STRING_MDL_TEMP_OPTS = 1502;
    public static final int DATALOADER_KEY_STRING_N80_OPTS = 1511;
    public static final int DATALOADER_KEY_STRING_NETSCHEDULER_CONFIG_STR = 1149;
    public static final int DATALOADER_KEY_STRING_NET_CACHE_DIR = 102;
    public static final int DATALOADER_KEY_STRING_OWN_DNS_HOST = 107;
    public static final int DATALOADER_KEY_STRING_P2P_DOMAINS = 9005;
    public static final int DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG = 2029;
    public static final int DATALOADER_KEY_STRING_SETTINGS_DOMAIN = 9002;
    public static final int DATALOADER_KEY_STRING_SETTINGS_REGION_CN_HOST = 116;
    public static final int DATALOADER_KEY_STRING_SETTINGS_REGION_SG_HOST = 117;
    public static final int DATALOADER_KEY_STRING_SETTINGS_REGION_US_HOST = 118;
    public static final int DATALOADER_KEY_STRING_SET_CUSTON_UA_1 = 1506;
    public static final int DATALOADER_KEY_STRING_SET_CUSTON_UA_2 = 1507;
    public static final int DATALOADER_KEY_STRING_SET_CUSTON_UA_3 = 1508;
    public static final int DATALOADER_KEY_STRING_STO_STRATEGY_CONFIG = 2007;
    public static final int DATALOADER_KEY_STRING_TTQUICHE_OPTS = 1512;
    public static final int DATALOADER_KEY_STRING_UPDATE_CACHE_DIR = 2030;
    public static final int DATALOADER_KEY_STRING_VDP_EXT_DYNAMIC_INFO = 2106;
    public static final int DATALOADER_KEY_STRING_VDP_EXT_GLOBAL_INFO = 2101;
    public static final int DATALOADER_KEY_STRING_VDP_FILE_KEY_REGULAR_EXPRESSION = 12003;
    public static final int DATALOADER_KEY_STR_NOTIFY_NOT_ONLY_NETWORK_ERROR_CODES = 9020;
    public static final int DATALOADER_KEY_STR_SPEED_ENGINE_SETTING = 1173;
    public static final int DATALOADER_KEY_STR_VDP_ABGROUP_ID = 1107;
    public static final int DATALOADER_KEY_STR_VDP_ABTEST_ID = 1106;
    public static final int DATALOADER_PRELOADER_PRIORITY_DEFAULT = 0;
    public static final int DATALOADER_PRELOADER_PRIORITY_HIGH = 100;
    public static final int DATALOADER_PRELOADER_PRIORITY_HIGHEST = 10000;
    public static final int DATALOADER_PRELOADER_PRIORITY_IDLE = 10;
    public static final int DATALOADER_PRELOAD_STRAGETY_ALLOW_PRELOAD_WHEN_PLAY = 0;
    public static final int DATALOADER_PRELOAD_STRAGETY_CENTER = 200;
    public static final int DATALOADER_PRELOAD_STRAGETY_NEW = 100;
    public static final int DATALOADER_PRELOAD_STRAGETY_NOT_ALLOW_PLAYING_KEY_PRELOAD = 1;
    public static final int DATALOADER_PRELOAD_STRAGETY_NOT_ALLOW_PRELOAD_WHEN_PLAY = 2;
    public static final int DATALOADER_PRELOAD_WAIT_LIST_IS_QUEUE = 1;
    public static final int DATALOADER_PRELOAD_WAIT_LIST_IS_STACK = 0;
    public static final int DATALOADER_SPEED_TEST_BY_TIMEINTERNAL_NOTIFY_BY_GENERAL_SPEEDINFO = 1;
    public static final int DATALOADER_SPEED_TEST_BY_TIMEINTERNAL_NOTIFY_BY_TIMEINTERNAL_SPEEDINFO = 2;
    public static final int ERROR_TYPE_FETCHDATA = 3;
    public static final int ERROR_TYPE_FETCHVIDEOMODEL = 1;
    public static final int ERROR_TYPE_FILEOPERATION = 4;
    public static final int ERROR_TYPE_MODULESTART = 2;
    public static final int ERROR_TYPE_NONE = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    private static final int MAX_URL_LENGTH = 3096;
    public static final String MDL_PREFIX = "mdl://";
    private static final String PLAYER_CLASS_NAME = "com.ss.ttm.player.TTPlayer";
    public static final String PRELOAD_DEFAULT_SCENE = "default";
    public static final int PRELOAD_PROBETYPE_INTERVAL = 0;
    public static final int PRELOAD_PROBETYPE_PLAYTASKPROGRESS = 1;
    private static final int PRIVATE_MESSAGE_ADD_MEDIA_CENTER = 111;
    private static final int PRIVATE_MESSAGE_ADD_PRIORITY_PRELOAD_TASK = 115;
    private static final int PRIVATE_MESSAGE_FOCUS_MEDIA = 114;
    private static final int PRIVATE_MESSAGE_REMOVE_MEDIA_CENTER = 112;
    private static final int PRIVATE_MESSAGE_REMOVE_MEDIA_LIST_CENTER = 113;
    private static final int PRIVATE_MESSAGE_REMOVE_PRIORITY_PRELOAD_TASK = 116;
    public static final int STRATEGY_INTERACTION_BLOCK_DURATION_NON_PRELOADED = 121;
    public static final int STRATEGY_INTERACTION_BLOCK_DURATION_PRELOADED = 120;
    private static final String TAG = "DataLoaderHelper";
    public static final String monitorName = "videoplayer_mdl_sample";
    private volatile boolean isProxyLibraryLoaded;
    private DataLoaderTaskQueue mAllPlayTasks;
    private DataLoaderTaskQueue mAllPreloadTasks;
    private final HashMap<String, ArrayList<WeakReference<TTVideoEngine>>> mAllUsingEngies;
    private boolean mAudioPreloadFirst;
    private int mBackupLoaderType;
    private ClassLoader mClasssLoader;
    private boolean mCloseLocalServer;
    private AVMDLDataLoaderConfigure mConfigure;
    private Context mContext;
    private int mCurrentAccessType;
    private int mDashAudioPreloadMinSize;
    private int mDashAudioPreloadRatio;
    private DataLoaderHelperAdapter mDataLoaderHelperAdapter;
    private long mDemuxerHandle;
    private boolean mDidConfigMdlV2;
    private int mDisableFilePathCheck;
    private int mEnableBackupIP;
    private int mEnableBufferPreload;
    private int mEnableCenterPreloadProgressCallback;
    private int mEnableCheckHLSProxyVVCtrl;
    private int mEnableCheckPreloadUrls;
    private int mEnableDumpLibMd5;
    private int mEnableFirstNativeMDL;
    private int mEnableHLSProxy;
    private int mEnableHls;
    private int mEnableLibManager;
    private int mEnableLoadMdlv2Fulllib;
    private boolean mEnableMdlProtocol;
    private int mEnableMdlV2;
    private int mEnableNetworkChangedListen;
    private int mEnableNotOnlyNotifyNetError;
    private int mEnableNotifyError;
    private int mEnablePreParseHost;
    private int mEnablePreloadAllTs;
    private int mEnablePreloadFirstTs;
    private int mEnableReportSpeed;
    private int mEnableSetMDLNetStatus;
    private int mEnableSplitPreload;
    private int mEnableStrategyCenterCancelAll;
    private int mEnableVideoModelHitCacheCallback;
    private final ReentrantLock mEngineLock;
    private VideoEventEngineUploader mEngineUploader;
    private Exception mException;
    private DataLoaderTaskQueue mExecuteTasks;
    private int mFloatSize;
    private boolean mForbidNativeMDLForOriUrl;
    private boolean mHLSProxyValid;
    private DataLoaderHeartBeat mHeartBeat;
    private int mHeartBeatInterval;
    private String mInitializeErrorString;
    private int mInitializeState;
    private AVMDLDataLoader mInnerDataLoader;
    private volatile boolean mInnerDataloaderStartComplete;
    private int mInvalidCode;
    private boolean mInvalidMdlProcotol;
    private final DataLoaderListenerWrapper mListener;
    private final ABLockWrapper mLock;
    private int mMdlDataSourceId;
    private int mMdlOldPreloadStrategy;
    private int mMdlPreloadStrategy;
    private long mMdlProtocolHandle;
    private VideoModelCache mModelCache;
    private int mNeedDLLoadP2PLib;
    private boolean mNeedMDLLoadMDLV2Lib;
    private int mNeedSpeedTestByTimeInternal;
    private TTNetworkStateCallback mNetWorkChangeCb;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr;
    private ArrayList<Integer> mNotifyNetErrors;
    private int mPreloadPreConnect;
    private int mPreloadTaskIgnorePlayerStall;
    private DataLoaderTaskQueue mPreloadTasks;
    private final PreloadUtil mPreloadUtil;
    private volatile LibraryLoaderProxy mProxy;
    private volatile boolean mReportLogEnable;
    private volatile int mState;
    private boolean mSupportHls;
    private TestSpeedListener mTestSpeedListener;
    private String mUpdatePlaySourceId;
    private IVideoEventUploader mUploader;
    private VCTrace mVCTrace;
    private String mVersionInfo;
    private PreloadMediaThread mediaOperateThread;

    public class DataLoaderCacheFileInfo {
        public long mCacheSizeFromZero;
        public String mLocalFilePath;
        public long mMediaSize;
        final /* synthetic */ DataLoaderHelper this$0;

        public DataLoaderCacheFileInfo(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mLocalFilePath = null;
            this.mMediaSize = 0;
            this.mCacheSizeFromZero = 0;
        }
    }

    public class DataLoaderCacheInfo {
        public long mCacheSizeFromZero;
        public String mLocalFilePath;
        public long mMediaSize;
        final /* synthetic */ DataLoaderHelper this$0;

        public DataLoaderCacheInfo(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mMediaSize = 0;
            this.mCacheSizeFromZero = 0;
            this.mLocalFilePath = null;
        }
    }

    public class DataLoaderHeartBeat {
        private MyHeartBeatTask mHbTask;
        private Timer mHbTimer;
        final /* synthetic */ DataLoaderHelper this$0;

        public class MyHeartBeatTask extends TimerTask {
            private AVMDLDataLoader mDataLoader;
            final /* synthetic */ DataLoaderHeartBeat this$1;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                com_ss_ttvideoengine_DataLoaderHelper$DataLoaderHeartBeat$MyHeartBeatTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_ss_ttvideoengine_DataLoaderHelper$DataLoaderHeartBeat$MyHeartBeatTask__run$___twin___() {
                AVMDLDataLoader r100 = this.mDataLoader;     // Catch: Exception -> L6
                if (r100 == null) goto L13;
                r100.onLogInfo(70, 0, r100.getStringValue(1011));     // Catch: Exception -> L6
                return;
            L13:
                return;
            L6:
                e = move-exception;
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L14;
                TTVideoEngineLog.d(e);
                return;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_ss_ttvideoengine_DataLoaderHelper$DataLoaderHeartBeat$MyHeartBeatTask_com_larus_apm_impl_protector_RunnableLancet_run(MyHeartBeatTask r100) {
                r100.com_ss_ttvideoengine_DataLoaderHelper$DataLoaderHeartBeat$MyHeartBeatTask__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public MyHeartBeatTask(DataLoaderHeartBeat r100, AVMDLDataLoader r101) {
                this.this$1 = r100;
                this.mDataLoader = r101;
            }
        }

        public void stop() {
            Timer r100 = this.mHbTimer;
            if (r100 == null) goto L6;
            r100.cancel();
            return;
        }

        private DataLoaderHeartBeat(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mHbTimer = null;
            this.mHbTask = null;
        }

        public /* synthetic */ DataLoaderHeartBeat(DataLoaderHelper r100, AnonymousClass1 r101) {
            this(r100);
        }

        public void start(AVMDLDataLoader r100, int r101) {
            if (this.mHbTask == null) goto L5;
            return;
        L5:
            if (this.mHbTimer != null) goto L11;
            if (r101 <= 0) goto L12;
            this.mHbTask = new MyHeartBeatTask(this, r100);
            PthreadTimer r102 = new PthreadTimer("DataLoaderHelper$DataLoaderHeartBeat");
            this.mHbTimer = r102;
            long r103 = r101;
            r102.schedule(this.mHbTask, r103, r103);
            return;
        L12:
            return;
        }
    }

    public static class DataLoaderTaskItem {
        public String mApiString;
        public long mDashAudioPreloadSize;
        public long mDashVideoPreloadSize;
        public boolean mDidCanceled;
        public VideoInfoFetcher mFetcher;
        public String mGroupId;
        public TaskListener mListener;
        public int mPlayIndexGap;
        public List<TrackItem> mPreloadEndTracks;
        public PreloadMedia mPreloadMedia;
        public long mPreloadMilliSecondOffset;
        public float mPreloadSecond;
        public long mPreloadSize;
        public int mPriorityLevel;
        public IVideoModel mResponseData;
        public Error mResponseError;
        public Resolution mSetResolution;
        public String mSubTag;
        public String mTag;
        public long mTimePreloadLowerLimitSize;
        public long mTimePreloadUpperLimitSize;
        public List<TrackItem> mTracks;
        public PreloaderURLItem mURLItem;
        public PreloaderVidItem mVidItem;
        public String mVideoId;
        public PreloaderVideoModelItem mVideoModelItem;

        public class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
            private final WeakReference<DataLoaderTaskItem> mTaskItemRef;
            final /* synthetic */ DataLoaderTaskItem this$0;

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onLog(String r100) {
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onRetry(Error r100) {
            }

            public MyFetcherListener(DataLoaderTaskItem r100, DataLoaderTaskItem r101) {
                this.this$0 = r100;
                this.mTaskItemRef = new WeakReference(r101);
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onCompletion(VideoModel r100, Error r101) {
                DataLoaderTaskItem r102 = this.mTaskItemRef.get();
                if (r102 != null) goto L5;
                return;
            L5:
                r102.mResponseData = r100;
                r102.mResponseError = r101;
                TaskListener r103 = r102.mListener;
                if (r103 == null) goto L9;
                r103.taskFinished(r102);
                return;
            }

            @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
            public void onStatusException(int r100, String r101) {
                DataLoaderTaskItem r102 = this.mTaskItemRef.get();
                if (r102 != null) goto L5;
                return;
            L5:
                if (r100 != 0) goto L7;
            L9:
                TaskListener r103 = r102.mListener;
                if (r103 == null) goto L13;
                r103.taskFinished(r102);
                return;
            L13:
                return;
            L7:
                if (r100 == 10) goto L9;
                r102.mResponseError = new Error(Error.FetchingInfo, Error.VideoInfoStatusInvalid);
                goto L9
            }
        }

        public static class MySmartUrlFetcherListener implements SmartUrlFetcher.Callback {
            private final WeakReference<DataLoaderTaskItem> mTaskItemRef;

            public MySmartUrlFetcherListener(DataLoaderTaskItem r100) {
                this.mTaskItemRef = new WeakReference(r100);
            }

            @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
            public void onError(SmartUrlFetcher.RequestParams r100, Error r101) {
                DataLoaderTaskItem r102 = this.mTaskItemRef.get();
                if (r102 != null) goto L5;
                return;
            L5:
                PreloaderURLItem r103 = r102.mURLItem;
                if (r103 != null) goto L8;
                return;
            L8:
                CodecStrategyAdapter r104 = r103.mAdapter;
                if (r104 != null) goto L11;
                return;
            L11:
                r102.mResponseError = r101;
                r104.fallbackToDirectUrl();
                TaskListener r105 = r102.mListener;
                if (r105 == null) goto L15;
                r105.taskFinished(r102);
                return;
            }

            @Override // com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.Callback
            public void onComplete(SmartUrlFetcher.RequestParams r100, int r101, SmartUrlFetcher.Result r102) {
                DataLoaderTaskItem r103 = this.mTaskItemRef.get();
                if (r103 != null) goto L6;
                return;
            L6:
                if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L8;
                TTVideoEngineLog.d(DataLoaderHelper.TAG, "fetchSmartUrlInfo success " + r102);
            L8:
                r103.mResponseData = r102.videoModel;
                TaskListener r104 = r103.mListener;
                if (r104 == null) goto L12;
                r104.taskFinished(r103);
                return;
            }
        }

        public class TrackItem {
            public long mCacheSize;
            public String mCustomHeader;
            public String mDecryptionKey;
            public String mExternalInfo;
            public boolean mIsFooterPreloaded;
            public String mLocalFilePath;
            public long mMediaSize;
            public long mPreSize;
            public long mPreloadFooterSize;
            public long mPreloadHeaderSize;
            public long mPreloadOffset;
            public String mProxyUrl;
            public String mTaskKey;
            public String[] mUrlExpireTimes;
            public String[] mUrls;
            public Resolution mUsingResolution;
            public VideoInfo mVideoInfo;
            final /* synthetic */ DataLoaderTaskItem this$0;

            public TrackItem(DataLoaderTaskItem r100) {
                this.this$0 = r100;
                this.mTaskKey = null;
                this.mProxyUrl = null;
                this.mUsingResolution = Resolution.Undefine;
                this.mDecryptionKey = null;
                this.mVideoInfo = null;
                this.mUrls = null;
                this.mUrlExpireTimes = null;
                this.mExternalInfo = null;
                this.mPreloadHeaderSize = 0;
                this.mPreloadOffset = 0;
                this.mPreSize = 0;
                this.mMediaSize = 0;
                this.mCacheSize = 0;
                this.mLocalFilePath = null;
                this.mCustomHeader = null;
                this.mPreloadFooterSize = 0;
                this.mIsFooterPreloaded = false;
            }
        }

        public IPreLoaderItemCallBackListener getCallBackListener() {
            PreloaderURLItem r100 = this.mURLItem;
            if (r100 != null) goto L5;
        L8:
            PreloaderVidItem r101 = this.mVidItem;
            if (r101 != null) goto L11;
            PreloaderVideoModelItem r102 = this.mVideoModelItem;
            if (r102 != null) goto L15;
            PreloadMedia r103 = this.mPreloadMedia;
            if (r103 != null) goto L19;
            return null;
        L19:
            return r103.getCallBackListener();
        L15:
            return r102.getCallBackListener();
        L11:
            return r101.getCallBackListener();
        L5:
            if (r100.getCallBackListener() == null) goto L8;
            return this.mURLItem.getCallBackListener();
        }

        public int getNotEndTrackItemCount() {
            return this.mTracks.size() - this.mPreloadEndTracks.size();
        }

        public void removeVidPlaceholderTrack() {
            if (this.mVidItem != null) goto L15;
            return;
        L15:
        L10:
            e = move-exception;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L18;
            TTVideoEngineLog.d(e);
            return;
        L18:
            return;
        L7:
            if (this.mTracks.size() != 1) goto L17;
            ListProtector.remove(this.mTracks, 0);     // Catch: Exception -> L10
            return;
        }

        public void setFetchListener() {
            VideoInfoFetcher r100 = this.mFetcher;
            if (r100 == null) goto L6;
            r100.setListener(new MyFetcherListener(this, this));
            return;
        }

        public DataLoaderTaskItem() {
            this.mVideoId = null;
            this.mResponseData = null;
            this.mResponseError = null;
            this.mPreloadSize = 0;
            this.mDashVideoPreloadSize = -1;
            this.mDashAudioPreloadSize = -1;
            this.mPreloadMilliSecondOffset = 0;
            this.mPreloadSecond = 0.0f;
            this.mTimePreloadLowerLimitSize = 0;
            this.mTimePreloadUpperLimitSize = 0;
            this.mPriorityLevel = 0;
            this.mSetResolution = Resolution.Undefine;
            this.mFetcher = null;
            this.mListener = null;
            this.mVidItem = null;
            this.mApiString = null;
            this.mGroupId = "";
            this.mVideoModelItem = null;
            this.mURLItem = null;
            this.mDidCanceled = false;
            this.mPreloadMedia = null;
            this.mTag = null;
            this.mSubTag = null;
            this.mPlayIndexGap = -1;
            this.mTracks = new CopyOnWriteArrayList();
            this.mPreloadEndTracks = new CopyOnWriteArrayList();
        }

        public void _notifyError(int r100) {
            if (getCallBackListener() == null) goto L6;
            PreLoaderItemCallBackInfo r101 = new PreLoaderItemCallBackInfo(3);
            r101.preloadError = new Error(Error.DataLoaderPreload, r100);
            getCallBackListener().preloadItemInfo(r101);
            return;
        }

        public TrackItem addTrackItemByKey(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return null;
        L6:
            TrackItem r101 = getTrackItem(r100);
            if (r101 != null) goto L10;
            TrackItem r102 = new TrackItem(this);
            r102.mTaskKey = r100;
            this.mTracks.add(r102);
            return r102;
        L10:
            return r101;
        }

        public TrackItem getTrackItem(String r100) {
            Iterator<TrackItem> r101 = this.mTracks.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            TrackItem r102 = r101.next();
            if (r102.mTaskKey.equals(r100) == false) goto L4;
            return r102;
        L8:
            return null;
        }

        public void setListener(TaskListener r100) {
            this.mListener = r100;
        }

        public void trackItemPreloadEnd(String r100) {
            Iterator<TrackItem> r101 = this.mTracks.iterator();
        L4:
            if (r101.hasNext() == false) goto L15;
            TrackItem r102 = r101.next();
            if (r102.mTaskKey.equals(r100) == false) goto L4;
            if (this.mPreloadEndTracks.contains(r102) == true) goto L14;
            this.mPreloadEndTracks.add(r102);
            return;
        L14:
            return;
        }

        public void setUp(String r100, Resolution r101, long r102) {
            if (this.mTracks.size() != 0) goto L5;
            TrackItem r103 = new TrackItem(this);
            r103.mTaskKey = r100;
            r103.mUsingResolution = r101;
            r103.mPreSize = r102;
            this.mTracks.add(r103);
        L6:
            this.mSetResolution = r101;
            this.mPreloadSize = r102;
            return;
        L5:
            TTVideoEngineLog.e(DataLoaderHelper.TAG, "[preload] DataLoaderTaskItem setup fail");
            goto L6
        }
    }

    public class DataLoaderTaskLoadProgress {
        public List<CacheInfo> mCacheInfos;
        protected boolean mSeparateAudioVideo;
        public int mTaskType;
        public String mVideoId;
        final /* synthetic */ DataLoaderHelper this$0;

        public class CacheInfo {
            public List<CacheRange> mCacheRanges;
            public Error mError;
            public String mKey;
            public String mLocalFilePath;
            public long mMediaSize;
            public long mPreloadSize;
            public Resolution mResolution;
            final /* synthetic */ DataLoaderTaskLoadProgress this$1;

            public class CacheRange {
                public long mOffset;
                public long mSize;
                final /* synthetic */ CacheInfo this$2;

                public CacheRange(CacheInfo r100) {
                    this.this$2 = r100;
                    this.mOffset = 0;
                    this.mSize = 0;
                }
            }

            public boolean finished() {
                long r100 = this.mPreloadSize;
                if (r100 <= 0) goto L5;
                long r101 = Math.min(r100, this.mMediaSize);
            L6:
                List<CacheRange> r102 = this.mCacheRanges;
                if (r102 == null) goto L9;
                CacheRange r103 = (CacheRange) ListProtector.get(r102, r102.size() - 1);
            L11:
                if (this.mError != null) goto L19;
                if (r103 != null) goto L14;
            L17:
                return false;
            L14:
                if (this.mMediaSize <= 0) goto L17;
                if ((r103.mOffset + r103.mSize) < r101) goto L17;
                return true;
            L19:
                return true;
            L9:
                r103 = null;
                goto L11
            L5:
                r101 = this.mMediaSize;
                goto L6
            }

            public long getCacheSize() {
                List<CacheRange> r100 = this.mCacheRanges;
                if (r100 != null) goto L5;
                return 0;
            L5:
                if (r100.size() <= 0) goto L10;
                List<CacheRange> r101 = this.mCacheRanges;
                return ((CacheRange) ListProtector.get(r101, r101.size() - 1)).mSize;
            L10:
                return 0;
            }

            public CacheInfo(DataLoaderTaskLoadProgress r100) {
                this.this$1 = r100;
                this.mKey = null;
                this.mMediaSize = 0;
                this.mPreloadSize = 0;
                this.mResolution = Resolution.Undefine;
                this.mCacheRanges = null;
                this.mLocalFilePath = null;
                this.mError = null;
            }

            public void setCacheSize(long r100) {
                if (this.mCacheRanges != null) goto L6;
                this.mCacheRanges = new ArrayList();
            L6:
                if (this.mCacheRanges.size() != 0) goto L8;
                this.mCacheRanges.add(new CacheRange(this));
            L8:
                ((CacheRange) ListProtector.get(this.mCacheRanges, 0)).mOffset = 0;
                ((CacheRange) ListProtector.get(this.mCacheRanges, 0)).mSize = r100;
            }
        }

        public long getTotalCacheSize() {
            long r100 = 0;
            if (this.mCacheInfos == null) goto L8;
            int r101 = 0;
        L6:
            if (r101 >= this.mCacheInfos.size()) goto L8;
            r100 = r100 + ((CacheInfo) ListProtector.get(this.mCacheInfos, r101)).getCacheSize();
            r101 = r101 + 1;
        L8:
            return r100;
        }

        public boolean isCacheEnd() {
            if (this.mCacheInfos == null) goto L14;
            int r100 = 0;
            boolean r101 = true;
            int r102 = 0;
        L6:
            if (r100 >= this.mCacheInfos.size()) goto L16;
            CacheInfo r103 = (CacheInfo) ListProtector.get(this.mCacheInfos, r100);
            if (r103 != null) goto L10;
        L12:
            r102 = r102 + 1;
        L13:
            r100 = r100 + 1;
            goto L6
        L10:
            if (r103.finished() == true) goto L12;
            r101 = false;
        L16:
            if (this.mSeparateAudioVideo == true) goto L24;
            if (r101 == true) goto L35;
            if (r102 >= 1) goto L20;
        L22:
            return false;
        L20:
            if (this.mTaskType != 1) goto L22;
            return true;
        L35:
            return true;
        L24:
            if (r101 == false) goto L26;
            return true;
        L26:
            if (r102 >= 2) goto L28;
        L30:
            return false;
        L28:
            if (this.mTaskType != 1) goto L30;
            return true;
        L14:
            r101 = true;
            r102 = 0;
            goto L16
        }

        public boolean isPreloadComplete() {
            if (this.mTaskType == 2) goto L7;
            TTVideoEngineLog.d(DataLoaderHelper.TAG, "task is not a preload task");
            return false;
        L7:
            if (this.mCacheInfos == null) goto L17;
            int r100 = 0;
        L10:
            if (r100 >= this.mCacheInfos.size()) goto L17;
            CacheInfo r101 = (CacheInfo) ListProtector.get(this.mCacheInfos, r100);
            if (r101 == null) goto L16;
            if (r101.finished() == true) goto L16;
            return false;
        L16:
            r100 = r100 + 1;
        L17:
            return true;
        }

        public DataLoaderTaskLoadProgress(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mVideoId = null;
            this.mTaskType = 0;
            this.mCacheInfos = null;
            this.mSeparateAudioVideo = false;
        }

        private CacheInfo getCacheInfo(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L12;
            List<CacheInfo> r101 = this.mCacheInfos;
            if (r101 == null) goto L12;
            Iterator<CacheInfo> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L12;
            CacheInfo r103 = r102.next();
            if (r103.mKey.equals(r100) == false) goto L8;
            return r103;
        L12:
            return null;
        }

        public void setUp(DataLoaderTaskItem r100) {
            this.mVideoId = r100.mVideoId;
            if (this.mCacheInfos != null) goto L5;
            this.mCacheInfos = new ArrayList();
        L5:
            Iterator<DataLoaderTaskItem.TrackItem> r101 = r100.mTracks.iterator();
            int r102 = 0;
            int r103 = 0;
        L6:
            boolean r104 = true;
            if (r101.hasNext() == false) goto L21;
            DataLoaderTaskItem.TrackItem r105 = r101.next();
            CacheInfo r106 = getCacheInfo(r105.mTaskKey);
            if (r106 != null) goto L11;
            r106 = new CacheInfo(this);
            r104 = false;
        L11:
            r106.mKey = r105.mTaskKey;
            r106.mMediaSize = r105.mMediaSize;
            r106.mResolution = r105.mUsingResolution;
            r106.setCacheSize(r105.mCacheSize);
            r106.mLocalFilePath = r105.mLocalFilePath;
            r106.mPreloadSize = r105.mPreSize;
            VideoInfo r107 = r105.mVideoInfo;
            if (r107 != null) goto L14;
        L19:
            if (r104 == true) goto L6;
            this.mCacheInfos.add(r106);
            goto L6
        L14:
            if (r107.getMediatype() != VideoRef.TYPE_VIDEO) goto L17;
            r103 = r103 + 1;
            goto L19
        L17:
            if (r105.mVideoInfo.getMediatype() != VideoRef.TYPE_AUDIO) goto L19;
            r102 = r102 + 1;
            goto L19
        L21:
            if (r102 <= 0) goto L30;
            if (r103 <= 0) goto L31;
            this.mSeparateAudioVideo = true;
            return;
        L31:
            return;
        }

        public void onError(String r100, Error r101) {
            CacheInfo r102 = getCacheInfo(r100);
            if (r102 == null) goto L6;
            r102.mError = r101;
            return;
        }
    }

    public class DataLoaderTaskProgressInfo {
        public long mCacheSizeFromZero;
        public String mDecryptionKey;
        public String mKey;
        public String mLocalFilePath;
        public long mMediaSize;
        public Resolution mResolution;
        public int mTaskType;
        public VideoInfo mUsingVideoInfo;
        public String mVideoId;
        final /* synthetic */ DataLoaderHelper this$0;

        public DataLoaderTaskProgressInfo(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mKey = null;
            this.mVideoId = null;
            this.mLocalFilePath = null;
            this.mMediaSize = 0;
            this.mCacheSizeFromZero = 0;
            this.mResolution = Resolution.Undefine;
            this.mDecryptionKey = null;
            this.mUsingVideoInfo = null;
            this.mTaskType = 0;
        }
    }

    public class DataLoaderTaskQueue {
        private final ReentrantLock mLock;
        private long mMaxCount;
        private final ArrayList<DataLoaderTaskItem> mTaskItems;
        final /* synthetic */ DataLoaderHelper this$0;

        private Boolean _enoughItems() {
            if (this.mMaxCount < 1) goto L11;
            if (this.mTaskItems.size() < this.mMaxCount) goto L7;
            boolean r100 = true;
        L9:
            return Boolean.valueOf(r100);
        L7:
            r100 = false;
            goto L9
        L11:
            return Boolean.FALSE;
        }

        public DataLoaderTaskItem backItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() != 0) goto L6;
            this.mLock.unlock();
            return null;
        L6:
            ArrayList<DataLoaderTaskItem> r100 = this.mTaskItems;
            DataLoaderTaskItem r101 = (DataLoaderTaskItem) ListProtector.get(r100, r100.size() - 1);
            this.mLock.unlock();
            return r101;
        }

        public long count() {
            this.mLock.lock();
            long r100 = this.mTaskItems.size();
            this.mLock.unlock();
            return r100;
        }

        public DataLoaderTaskItem frontItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() != 0) goto L6;
            this.mLock.unlock();
            return null;
        L6:
            DataLoaderTaskItem r100 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, 0);
            this.mLock.unlock();
            return r100;
        }

        public DataLoaderTaskItem popBackItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() != 0) goto L6;
            this.mLock.unlock();
            return null;
        L6:
            ArrayList<DataLoaderTaskItem> r100 = this.mTaskItems;
            DataLoaderTaskItem r101 = (DataLoaderTaskItem) ListProtector.get(r100, r100.size() - 1);
            this.mTaskItems.remove(r101);
            this.mLock.unlock();
            return r101;
        }

        public DataLoaderTaskItem popFrontItem() {
            this.mLock.lock();
            if (this.mTaskItems.size() != 0) goto L6;
            this.mLock.unlock();
            return null;
        L6:
            DataLoaderTaskItem r100 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, 0);
            this.mTaskItems.remove(r100);
            this.mLock.unlock();
            return r100;
        }

        public void removeAll() {
            this.mLock.lock();     // Catch: Throwable -> L5
            this.mTaskItems.clear();     // Catch: Throwable -> L5
            this.mLock.unlock();
            return;
        L5:
            th = move-exception;
            this.mLock.unlock();
            throw th;
        }

        public ArrayList<DataLoaderTaskItem> toArray() {
            this.mLock.lock();     // Catch: Throwable -> L5
            ArrayList<DataLoaderTaskItem> r100 = new ArrayList();     // Catch: Throwable -> L5
            r100.addAll(this.mTaskItems);     // Catch: Throwable -> L5
            this.mLock.unlock();
            return r100;
        L5:
            th = move-exception;
            this.mLock.unlock();
            throw th;
        }

        private DataLoaderTaskQueue(DataLoaderHelper r100) {
            this.this$0 = r100;
            this.mLock = new ReentrantLock();
            this.mTaskItems = new ArrayList();
            this.mMaxCount = 0;
        }

        public boolean containItem(String r100) {
            int r101 = 0;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return false;
        L5:
            Boolean r102 = Boolean.FALSE;
            this.mLock.lock();
        L7:
            if (r101 >= this.mTaskItems.size()) goto L12;
            if (((DataLoaderTaskItem) ListProtector.get(this.mTaskItems, r101)).getTrackItem(r100) != null) goto L10;
            r101 = r101 + 1;
            goto L7
        L10:
            r102 = Boolean.TRUE;
        L12:
            this.mLock.unlock();
            return r102.booleanValue();
        }

        public boolean enqueueItem(DataLoaderTaskItem r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.mTracks.size() != 0) goto L8;
            return false;
        L8:
            this.mLock.lock();
            if (_enoughItems().booleanValue() == false) goto L11;
            Boolean r101 = Boolean.FALSE;
        L12:
            this.mLock.unlock();
            return r101.booleanValue();
        L11:
            this.mTaskItems.add(r100);
            r101 = Boolean.TRUE;
            goto L12
        }

        public DataLoaderTaskItem itemForKey(String r100) {
            DataLoaderTaskItem r101 = null;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            this.mLock.lock();
            int r102 = 0;
        L7:
            if (r102 >= this.mTaskItems.size()) goto L12;
            DataLoaderTaskItem r103 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, r102);
            if (r103.getTrackItem(r100) != null) goto L10;
            r102 = r102 + 1;
            goto L7
        L10:
            r101 = r103;
        L12:
            this.mLock.unlock();
            return r101;
        }

        public DataLoaderTaskItem itemForVideoId(String r100) {
            DataLoaderTaskItem r101 = null;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            this.mLock.lock();
            int r102 = 0;
        L7:
            if (r102 >= this.mTaskItems.size()) goto L14;
            DataLoaderTaskItem r103 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, r102);
            if (TextUtils.isEmpty(r103.mVideoId) == true) goto L13;
            if (r103.mVideoId.equals(r100) == false) goto L13;
            r101 = r103;
        L13:
            r102 = r102 + 1;
        L14:
            this.mLock.unlock();
            return r101;
        }

        public DataLoaderTaskItem popItem(String r100) {
            DataLoaderTaskItem r101 = null;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            this.mLock.lock();
            int r102 = 0;
        L7:
            if (r102 >= this.mTaskItems.size()) goto L12;
            DataLoaderTaskItem r103 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, r102);
            if (r103.getTrackItem(r100) != null) goto L10;
            r102 = r102 + 1;
            goto L7
        L10:
            r101 = r103;
        L12:
            if (r101 == null) goto L14;
            this.mTaskItems.remove(r101);
        L14:
            this.mLock.unlock();
            return r101;
        }

        public DataLoaderTaskItem popItemForVideoId(String r100) {
            DataLoaderTaskItem r101 = null;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return null;
        L5:
            this.mLock.lock();
            int r102 = 0;
        L7:
            if (r102 >= this.mTaskItems.size()) goto L14;
            DataLoaderTaskItem r103 = (DataLoaderTaskItem) ListProtector.get(this.mTaskItems, r102);
            if (TextUtils.isEmpty(r103.mVideoId) == true) goto L13;
            if (r103.mVideoId.equals(r100) == false) goto L13;
            r101 = r103;
        L13:
            r102 = r102 + 1;
        L14:
            if (r101 == null) goto L16;
            this.mTaskItems.remove(r101);
        L16:
            this.mLock.unlock();
            return r101;
        }

        public void setMaxCount(long r100) {
            this.mMaxCount = r100;
        }

        public DataLoaderTaskItem popItem(DataLoaderTaskItem r100) {
            if (TextUtils.isEmpty(r100.mVideoId) == true) goto L7;
            DataLoaderTaskItem r101 = popItemForVideoId(r100.mVideoId);
            if (r101 == null) goto L8;
            return r101;
        L8:
            Iterator<DataLoaderTaskItem.TrackItem> r102 = r100.mTracks.iterator();
        L10:
            if (r102.hasNext() == false) goto L13;
            r101 = popItem(r102.next().mTaskKey);
            if (r101 == null) goto L10;
        L13:
            return r101;
        L7:
            r101 = null;
            goto L8
        }

        public /* synthetic */ DataLoaderTaskQueue(DataLoaderHelper r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class Holder {
        private static DataLoaderHelper instance;

        private Holder() {
        }

        static {
            instance = new DataLoaderHelper(null);
        }

        public static /* synthetic */ DataLoaderHelper access$200() {
            return instance;
        }
    }

    public class MyPreloadTaskCallbackListener implements IPreloadTaskCallbackListener {
        private IPreLoaderItemCallBackListener mCallBackListener;
        final /* synthetic */ DataLoaderHelper this$0;

        public MyPreloadTaskCallbackListener(DataLoaderHelper r100, IPreLoaderItemCallBackListener r101) {
            this.this$0 = r100;
            this.mCallBackListener = r101;
        }

        public void preloadItemInfo(int r100, String r110, String r111) {
            if (this.mCallBackListener != null) goto L5;
            return;
        L5:
            if (r100 != 4) goto L7;
            int r101 = 3;
        L18:
            PreLoaderItemCallBackInfo r102 = new PreLoaderItemCallBackInfo(r101);
            if (TextUtils.isEmpty(r111) == true) goto L25;
            r102.businessContext = new JSONObject(r111).optString("businessContext");     // Catch: JSONException -> L22
        L22:
            e = move-exception;
            TTVideoEngineLog.d(DataLoaderHelper.TAG, "[originPreload] preloadItemInfo, json error:" + e.toString());
        L25:
            if (TextUtils.isEmpty(r110) == false) goto L27;
        L35:
            if (r101 != 8) goto L37;
            r102.fileHash = r110;
        L37:
            this.mCallBackListener.preloadItemInfo(r102);
            return;
        L27:
            if (r110.contains(",") == false) goto L35;
            String[] r112 = r110.split(",");
            if (r112.length < 3) goto L37;
            long r103 = CastLongProtector.valueOf(r112[0]).longValue();
            long r104 = CastLongProtector.valueOf(r112[1]).longValue();
            String r113 = r112[2];
            if (r112.length < 4) goto L33;
            String r114 = r112[3];
        L34:
            DataLoaderTaskProgressInfo r105 = new DataLoaderTaskProgressInfo(this.this$0);
            r102.preloadDataInfo = r105;
            r105.mKey = r113;
            r105.mCacheSizeFromZero = r103;
            r105.mMediaSize = r104;
            r105.mLocalFilePath = r114;
            goto L37
        L33:
            r114 = "";
            goto L34
        L7:
            r101 = 5;
            if (r100 == 5) goto L18;
            if (r100 != 2) goto L12;
            r101 = 8;
            goto L18
        L12:
            if (r100 != 1) goto L15;
            r101 = 7;
            goto L18
        L15:
            if (r100 != 6) goto L17;
            r101 = 9;
            goto L18
        L17:
            r101 = 2;
            goto L18
        }
    }

    public class MySelectBitrateListener implements ISelectBitrateListener {
        private ISelectBitrateCallback mCallback;
        final /* synthetic */ DataLoaderHelper this$0;

        public MySelectBitrateListener(DataLoaderHelper r100, ISelectBitrateCallback r101) {
            this.this$0 = r100;
            this.mCallback = r101;
        }

        public String selectBitrateJsonString(String r100, int r101) {
            ISelectBitrateCallback r102 = this.mCallback;
            if (r102 == null) goto L8;
            Map<String, Integer> r103 = r102.selectBitrate(r101);
            if (r103 != null) goto L7;
            return null;
        L7:
            return new JSONObject(r103).toString();
        L8:
            return null;
        }
    }

    public class MyTaskListener implements TaskListener {
        private final WeakReference<DataLoaderHelper> mDataLoader;
        final /* synthetic */ DataLoaderHelper this$0;

        @Override // com.ss.ttvideoengine.DataLoaderHelper.TaskListener
        public void taskFinished(DataLoaderTaskItem r100) {
            DataLoaderHelper r101 = this.mDataLoader.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100 != null) goto L7;
            return;
        L7:
            IVideoModel r102 = r100.mResponseData;
            if (r102 == null) goto L17;
            PreloaderVidItem r103 = r100.mVidItem;
            if (r103.mGearStrategyEnabled != 3) goto L17;
            if (r103.mResolution != Resolution.Auto) goto L17;
            IVideoInfo r104 = GearStrategySC.selectBitrate(r102, 2, r103.mGearStrategyExtraParams, null);
            if (r104 == null) goto L17;
            PreloaderVidItem r105 = r100.mVidItem;
            r105.mResolution = r104.getResolution();
            r100.mSetResolution = r100.mVidItem.mResolution;
        L17:
            if (r100.mResponseData != null) goto L19;
        L23:
            PreloaderVidItem r106 = r100.mVidItem;
            if (r106 != null) goto L26;
        L28:
            PreloaderVidItem r107 = r100.mVidItem;
            if (r107 == null) goto L34;
            if (r107.getOnlyFetchVideoModel() == true) goto L34;
            DataLoaderHelper.access$700(r101, r100);
        L34:
            if (r100.mResponseError != null) goto L36;
            return;
        L36:
            if (DataLoaderHelper.access$400(r101) == null) goto L39;
            DataLoaderHelper.access$400(r101).dataLoaderError(r100.mVideoId, 1, r100.mResponseError);
        L39:
            if (r100.getCallBackListener() == null) goto L43;
            PreLoaderItemCallBackInfo r108 = new PreLoaderItemCallBackInfo(3);
            r108.preloadError = r100.mResponseError;
            r100.getCallBackListener().preloadItemInfo(r108);
            return;
        L43:
            return;
        L26:
            if (r106.getFetchEndListener() == null) goto L28;
            r100.mVidItem.getFetchEndListener().fetchEnd((VideoModel) r100.mResponseData, r100.mResponseError);
            r100.mSetResolution = r100.mVidItem.mResolution;
            goto L28
        L19:
            if (r100.getCallBackListener() == null) goto L23;
            PreLoaderItemCallBackInfo r109 = new PreLoaderItemCallBackInfo(4);
            r109.fetchVideoModel = (VideoModel) r100.mResponseData;
            r100.getCallBackListener().preloadItemInfo(r109);
            PreloaderVidItem r110 = r100.mVidItem;
            if (r110 == null) goto L23;
            r100.mSetResolution = r110.mResolution;
            goto L23
        }

        public MyTaskListener(DataLoaderHelper r100, DataLoaderHelper r101) {
            this.this$0 = r100;
            this.mDataLoader = new WeakReference(r101);
        }
    }

    public static class PreloadMediaThread {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        public PreloadMediaThread() {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("vclould.engine.preload.media");     // Catch: Throwable -> L5
            this.mHandlerThread = r100;     // Catch: Throwable -> L5
            ThreadMethodProxy.start(r100);     // Catch: Throwable -> L5
            final Looper r101 = this.mHandlerThread.getLooper();     // Catch: Throwable -> L5
            this.mHandler = new AnonymousClass1(this, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L9;
            TTVideoEngineLog.d(th);
        L9:
            this.mHandlerThread = null;
            this.mHandler = null;
        }

        public void postMessage(ArrayList<Object> r100, int r101) {
            if (this.mHandler != null) goto L5;
            return;
        L5:
            if (this.mHandlerThread == null) goto L9;
            Message r102 = Message.obtain();
            r102.what = r101;
            r102.obj = r100;
            this.mHandler.sendMessage(r102);
            return;
        }
    }

    public interface TaskListener {
        void taskFinished(DataLoaderTaskItem r100);
    }

    private String _apiStringForVid(PreloaderVidItem r100) {
        return null;
    }

    private void startVCTrace() {
    }

    public void addPreloadUrlMedia(PreloadURLMedia r100) {
    }

    public void clearAllCaches() {
        clearAllCaches(false);
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int r100, long r101) {
        return 0;
    }

    public String getNetworkName(long r100) {
        int r101 = (int) r100;
        if (r101 != 0) goto L5;
        return "default";
    L5:
        if (r101 != 1) goto L7;
        return OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR;
    L7:
        if (r101 == 2) goto L10;
        return null;
    L10:
        return "wifi";
    }

    public int getProbeIntervalMS() {
        return -1;
    }

    public int getProbeType() {
        return 0;
    }

    @Override // com.ss.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
        this.mInnerDataloaderStartComplete = true;
        if (this.mInitializeState != IVideoEventLogger.MdlInitializeState.Initializing.ordinal()) goto L5;
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeComplete.ordinal();
    L5:
        TTVideoEngineLog.d(TAG, "MediaDataLoader start complete");
        int r100 = TTNetWorkListener.getInstance().getCurrentAccessType();
        this.mCurrentAccessType = r100;
        AVMDLDataLoader r101 = this.mInnerDataLoader;
        if (r101 == null) goto L13;
        r101.setIntValue(AVMDLDataLoader.KeyIsNetworkAccessType, r100);
        if (StrategyHelper.helper().isRunning() == true) goto L13;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L12;
        TTVideoEngineLog.d(TAG, "strategy center running failed, set mdl preload strategy back " + this.mMdlOldPreloadStrategy);
    L12:
        this.mInnerDataLoader.setIntValue(1030, this.mMdlOldPreloadStrategy);
    L13:
        DataLoaderListenerWrapper r102 = this.mListener;
        if (r102 == null) goto L16;
        r102.onNotify(11, 0, 0, "mdl start complete");
    L16:
        this.mListener.onStartComplete();
    }

    public void p2pPredown(String r100) {
    }

    public float playTaskProgress() {
        return -1.0f;
    }

    public void removePreloadMedia(PreloadMedia r100, String r101) {
    }

    public void setNetworkClient(TTVNetClient r100) {
    }

    public void setPlayTaskProgress(float r100) {
    }

    public void setProbeIntervalMS(int r100) {
    }

    public void setProbeType(int r100) {
    }

    public void setTaskConfigs(List<PreloadTaskConfig> r100) {
    }

    private void _startExecuteTask() {
        if (this.mInnerDataLoader != null) goto L6;
        TTVideoEngineLog.e(TAG, "[preload] need load mdl first.");
        return;
    L6:
        DataLoaderTaskItem r100 = this.mPreloadTasks.backItem();
        if (r100 != null) goto L10;
        return;
    L10:
        if (this.mExecuteTasks.enqueueItem(r100) == false) goto L20;
        this.mPreloadTasks.popBackItem();
        if (r100.mResponseData == null) goto L14;
    L18:
        _exectTask(r100);
        return;
    L14:
        if (r100.mURLItem != null) goto L18;
        _startFetchVideoInfo(r100);
        return;
    }

    private void _tryToSetDefaultCacheDir() {
        if (this.mContext != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir) == true) goto L8;
        return;
    L8:
        String r100 = TTHelper.getAppFilesPath(this.mContext) + File.separator + "mdlcache";
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L11;
        r101.mkdir();
    L11:
        this.mConfigure.mCacheDir = r100;
    }

    private void dumpLibMd5() {
        if (this.mEnableDumpLibMd5 == 1) goto L6;
        return;
    L6:
        if (this.mContext != null) goto L19;
        return;
    L19:
        String r100 = this.mContext.getApplicationInfo().dataDir + "/lib";     // Catch: Exception -> L10
    L11:
        if (r100 != null) goto L13;
        return;
    L13:
        String r101 = TTHelper.getFileMd5(new PolarisFileWrapper(r100 + File.separatorChar + "libavmdl.so"));
        if (r101 != null) goto L16;
        return;
    L16:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L22;
        TTVideoEngineLog.e(TAG, "libavmdl md5: ".concat(r101));
        return;
    L22:
        return;
    L10:
        r100 = null;
        goto L11
    }

    private boolean initInternal() {
        if (this.mInnerDataLoader == null) goto L5;
        return true;
    L5:
        VCBaseKitLoader.loadLibrary();
        if (this.mEnableLibManager == 1) goto L8;
    L18:
        boolean r100 = false;
    L20:
        if (r100 == false) goto L22;
    L82:
        boolean r101 = false;
    L84:
        if (this.mConfigure.mEnableByteMediaNetLoader > 0) goto L86;
    L107:
        AVMDLDataLoader r102 = AVMDLDataLoader.getInstance();     // Catch: Exception -> L102
        this.mInnerDataLoader = r102;     // Catch: Exception -> L102
        r102.setConfigure(this.mConfigure);     // Catch: Exception -> L102
        this.mInnerDataLoader.setListener(this);     // Catch: Exception -> L102
        this.mInnerDataLoader.setStartCompleteListener(this);     // Catch: Exception -> L102
        if (r101 == true) goto L96;
    L98:
        this.mHeartBeat = new DataLoaderHeartBeat(this, null);     // Catch: Exception -> L102
        if (this.mConfigure.mEnableEnginePortrait <= 0) goto L101;
        Map<String, Object> r103 = PortraitEngine.getInstance().getAllLabels();     // Catch: Exception -> L102
        PortraitEngine.getInstance().addPortraitListener(this);     // Catch: Exception -> L102
        this.mConfigure.mEnginePortraitStr = _constructEnginePortaint(r103);     // Catch: Exception -> L102
    L101:
        return true;
    L96:
        if (this.mListener == null) goto L98;
        this.mInnerDataLoader.setPluginLibraryLoader(new AnonymousClass2(this));     // Catch: Exception -> L102
    L102:
        e = move-exception;
        this.mInitializeErrorString = "mInnerDataloader create error:" + e.toString();
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L106;
        TTVideoEngineLog.d(e);
    L106:
        return false;
    L86:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L89;
        TTVideoEngineLog.d("ByteMediaNet", "enable byte media try init env, context:" + this.mContext + "  classloader:" + this.mClasssLoader);
    L89:
        if (this.mContext == null) goto L107;
        if (this.mClasssLoader == null) goto L107;
        AVMDLDataLoader.initByteMediaNetEnv(this.mContext, this.mClasssLoader);
        TTVideoEngineLog.d("ByteMediaNet", "init byte media env end");
        goto L107
    L22:
        if (loadLibrary() == true) goto L28;
        this.mInitializeErrorString = "proxy load library failed";
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L26;
        TTVideoEngineLog.e(TAG, String.format("library load fail", new Object[0]));
    L26:
        return false;
    L28:
        if (this.mProxy == null) goto L30;
    L38:
        DataLoaderListenerWrapper r104 = this.mListener;
        if (r104 != null) goto L41;
    L45:
        if (r100 == true) goto L82;
        if (this.mProxy == null) goto L49;
        boolean r105 = true;
    L51:
        if (this.mNeedDLLoadP2PLib == 0) goto L53;
        boolean r106 = true;
    L55:
        if (this.mEnableMdlV2 == 1) goto L57;
    L59:
        boolean r107 = false;
    L61:
        if (AVMDLDataLoader.init(r105, r106, r107) == 0) goto L67;
        this.mInitializeErrorString = "library has not been loaded";
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L65;
        TTVideoEngineLog.e(TAG, String.format("library has not been loaded", new Object[0]));
    L65:
        return false;
    L67:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L70;
        TTVideoEngineLog.e("P2PLIB", String.format("loadertype:%d NeedDLLoadP2PLib:%d, liveloaderType: %d", new Object[]{Integer.valueOf(this.mConfigure.mLoaderType), Integer.valueOf(this.mNeedDLLoadP2PLib), Integer.valueOf(this.mConfigure.mLiveLoaderType)}));
    L70:
        if (this.mNeedDLLoadP2PLib != 0) goto L82;
        if (this.mListener == null) goto L82;
        AVMDLDataLoaderConfigure r108 = this.mConfigure;
        if (r108.mEnablePcdnAuto != 1) goto L76;
    L81:
        TTVideoEngineLog.e("P2PLIB", "delay to load p2p lib");
        r101 = true;
        goto L84
    L76:
        if (r108.mLoaderType > 0) goto L81;
        int r109 = r108.mLiveLoaderType;
        if (r109 == 10000) goto L82;
        if (r109 < 7) goto L82;
    L57:
        if (this.mNeedMDLLoadMDLV2Lib == false) goto L59;
        r107 = true;
        goto L61
    L53:
        r106 = false;
        goto L55
    L49:
        r105 = false;
        goto L51
    L41:
        if (this.mConfigure.mEnableTTQuicHeLoader != 1) goto L45;
        boolean r110 = r104.loadLibrary("mdlttquicheloader");
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L45;
        TTVideoEngineLog.d(TAG, "load ttquiche: " + r110);
        goto L45
    L30:
        if (this.mEnableLoadMdlv2Fulllib != 1) goto L38;
        if (this.mListener == null) goto L38;
        if (this.mNeedMDLLoadMDLV2Lib == true) goto L38;
        TTVideoEngineLog.d(TAG, "try to load mdls");
        AVMDLDataLoader.loadAVMDLBaseLibrary();
        r100 = this.mListener.loadLibrary("avmdls");
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L38;
        TTVideoEngineLog.d(TAG, "load avmdls: " + r100);
        goto L38
    L8:
        if (this.mProxy == null) goto L10;
    L11:
        AVMDLLibraryManagerWrapper.setLibraryLoader(new AnonymousClass1(this));
    L13:
        if (this.mEnableMdlV2 != 1) goto L16;
        AVMDLLibraryManagerWrapper.setEnableV2(true);
    L16:
        if (AVMDLDataLoader.initWithLibraryManager() != 0) goto L18;
        r100 = true;
        goto L20
    L10:
        if (this.mListener == null) goto L13;
        goto L11
    }

    private boolean isMDLPrecisePreloadEnable() {
        AVMDLDataLoaderConfigure r100 = this.mConfigure;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100.mPrecisePreloadConfigStr) == true) goto L15;
        if (JSONObjectProtectorUtils.getInt(new JSONObject(this.mConfigure.mPrecisePreloadConfigStr), "enable") > 0) goto L17;
        return false;
    L17:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        return false;
    }

    private boolean loadLibrary() {
        if (this.mProxy != null) goto L5;
        return true;
    L5:
        dumpLibMd5();
        if (this.mProxy == null) goto L21;
        if (this.isProxyLibraryLoaded == true) goto L21;
        if (this.mEnableMdlV2 != 1) goto L15;
        this.mProxy.loadLibrary("avmdlbase");     // Catch: Exception -> L13
        this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdlv2");     // Catch: Exception -> L13
    L13:
        this.isProxyLibraryLoaded = false;
    L15:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L18;
        TTVideoEngineLog.d(TAG, "try to load avmdl: " + this.isProxyLibraryLoaded);
    L18:
        if (this.isProxyLibraryLoaded == true) goto L21;
        this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdl");
    L21:
        return this.isProxyLibraryLoaded;
    }

    public void cancelAllTasks() {
        if (this.mInnerDataLoader != null) goto L5;
    L24:
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L5:
        if (this.mState != 0) goto L24;
        if (this.mEnableStrategyCenterCancelAll == 1) goto L10;
    L12:
        this.mLock.lock(ABLock.TYPE_READ);
        cancelAllTasksInternal();     // Catch: Throwable -> L15
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L15:
        th = move-exception;
    L21:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L17:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L14;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L21
        goto L14
    L10:
        if (StrategyHelper.helper().isRunning() == false) goto L12;
        StrategyHelper.helper().getCenter().e(31205, 1);
        goto L12
    }

    public void cancelAllTasksInternal() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        if (this.mExecuteTasks.count() <= 0) goto L19;
    L4:
        DataLoaderTaskItem r102 = this.mExecuteTasks.popBackItem();
        if (r102 == null) goto L13;
        if (r102.mPriorityLevel >= 10000) goto L8;
        VideoInfoFetcher r103 = r102.mFetcher;
        if (r103 == null) goto L12;
        r103.cancel();
    L12:
        _notifyPreloadCancel(r102);
        goto L4
    L8:
        r100.add(r102);
        goto L4
    L13:
        int r104 = 0;
    L15:
        if (r104 >= r100.size()) goto L17;
        DataLoaderTaskItem r105 = (DataLoaderTaskItem) ListProtector.get(r100, r104);
        this.mExecuteTasks.enqueueItem(r105);
        r104 = r104 + 1;
        goto L15
    L17:
        r100.clear();
    L19:
        if (this.mPreloadTasks.count() <= 0) goto L35;
    L20:
        DataLoaderTaskItem r106 = this.mPreloadTasks.popBackItem();
        if (r106 == null) goto L29;
        if (r106.mPriorityLevel >= 10000) goto L24;
        VideoInfoFetcher r107 = r106.mFetcher;
        if (r107 == null) goto L28;
        r107.cancel();
    L28:
        _notifyPreloadCancel(r106);
        goto L20
    L24:
        r100.add(r106);
        goto L20
    L29:
        int r108 = 0;
    L31:
        if (r108 >= r100.size()) goto L33;
        DataLoaderTaskItem r109 = (DataLoaderTaskItem) ListProtector.get(r100, r108);
        this.mPreloadTasks.enqueueItem(r109);
        r108 = r108 + 1;
        goto L31
    L33:
        r100.clear();
    L35:
        if (this.mAllPreloadTasks.count() <= 0) goto L72;
        boolean r110 = false;
    L37:
        DataLoaderTaskItem r111 = this.mAllPreloadTasks.popBackItem();
        if (r111 == null) goto L43;
        if (r111.mPriorityLevel >= 10000) goto L41;
        _notifyPreloadCancel(r111);
        r110 = true;
        goto L37
    L41:
        r100.add(r111);
        goto L37
    L43:
        if (r110 == false) goto L46;
        this.mInnerDataLoader.cancelAll();
    L46:
        if (r101 >= r100.size()) goto L48;
        DataLoaderTaskItem r112 = (DataLoaderTaskItem) ListProtector.get(r100, r101);
        this.mAllPreloadTasks.enqueueItem(r112);
        r101 = r101 + 1;
        goto L46
    L48:
        r100.clear();
        return;
    }

    public void cancelAllWaitReqs() {
        TTVideoEngineLog.d(TAG, "start do cancel all wait reqs");
        if (this.mInnerDataLoader != null) goto L5;
    L20:
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L5:
        if (this.mState != 0) goto L20;
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.cancelAllPreloadWaitReqs();     // Catch: Throwable -> L10
    L9:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L10:
        th = move-exception;
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L13:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L9;
        TTVideoEngineLog.d(TAG, "do cancel all wait reqs exception:" + th.toString());     // Catch: Throwable -> L17
        goto L9
    }

    public void clearNetinfoCache() {
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r100 = this.mInnerDataLoader;     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L7:
        r100.clearNetinfoCache();     // Catch: Throwable -> L9
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void close() {
        this.mLock.lock(ABLock.TYPE_READ);
    L11:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L4:
        if (this.mState != 1) goto L8;
        TTVideoEngineLog.e(TAG, "DataLoader not started, not need close");     // Catch: Throwable -> L11
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L8:
        this.mListener.clearListeners();     // Catch: Throwable -> L11
        this.mInnerDataLoader.close();     // Catch: Throwable -> L11
        cancelAllTasksInternal();     // Catch: Throwable -> L11
        removeAllPreloadMedia(null, 1);     // Catch: Throwable -> L11
        this.mState = 1;     // Catch: Throwable -> L11
        TTNetWorkListener.getInstance().stopListen(this.mNetWorkChangeCbr);     // Catch: Throwable -> L11
        TTNetWorkListener.getInstance().unregisterListener(this.mContext);     // Catch: Throwable -> L11
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public long getAllCacheSize() {
        long r100 = 0;
        if (this.mState == 0) goto L6;
        return 0;
    L6:
        if (this.mLock.tryLock(ABLock.TYPE_READ) == true) goto L22;
    L19:
        return r100;
    L22:
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L12:
        this.mLock.unlock(ABLock.TYPE_READ);
    L16:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L8:
        if (this.mInnerDataLoader != null) goto L10;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L13
    L10:
        r100 = 0 + this.mInnerDataLoader.getAllCacheSize();
        goto L12
    }

    public String getMdlInitializeErrorString() {
        String r100 = this.mInitializeErrorString;
        if (r100 != null) goto L5;
        return null;
    L5:
        this.mInitializeErrorString = null;
        return r100;
    }

    public int getMdlInvalidCode() {
        int r100 = this.mInvalidCode;
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.None.ordinal();
        return r100;
    }

    public long getPreloadTaskCount() {
        return (this.mExecuteTasks.count() + this.mAllPreloadTasks.count()) + this.mPreloadTasks.count();
    }

    public boolean isNeedPlayInfo() {
        if (this.mEnableBufferPreload > 0) goto L5;
        return false;
    L5:
        PreloadUtil r100 = this.mPreloadUtil;
        if (r100.mPlayBufferLowerBound > 0) goto L8;
    L11:
        return false;
    L8:
        if (r100.mPlayBufferUpperBound <= 0) goto L11;
        return true;
    }

    public boolean isReportLogEnable() {
        this.mLock.lock(ABLock.TYPE_VOID);
        boolean r100 = this.mReportLogEnable;     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_VOID);
        return r100;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_VOID);
        throw th;
    }

    public boolean isRunning() {
        this.mLock.lock(ABLock.TYPE_VOID);
        if (this.mState != 0) goto L6;
        boolean r100 = true;
    L7:
        this.mLock.unlock(ABLock.TYPE_VOID);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_VOID);
        throw th;
    }

    public void resumeFileWriteIO() {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r100 = this.mInnerDataLoader;     // Catch: Throwable -> L11
        if (r100 == null) goto L9;
        r100.resumeFileWriteIO();     // Catch: Throwable -> L11
    L9:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void resumePreconnect() {
        if (this.mInnerDataLoader != null) goto L6;
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.resumePreConnect();
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void start() throws Exception {
        this.mLock.lock(ABLock.TYPE_WRITE);
    L105:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        if (EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 <= 0) goto L109;
        this.mLock.updateLockType(ABLock.LOCK_IMPL_VOID);
    L109:
        throw th;
    L5:
        if (this.mState != 0) goto L11;
        TTVideoEngineLog.e(TAG, "DataLoader has started not need start");     // Catch: Throwable -> L105
        this.mLock.unlock(ABLock.TYPE_WRITE);
        if (EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 <= 0) goto L115;
        this.mLock.updateLockType(ABLock.LOCK_IMPL_VOID);
        return;
    L115:
        return;
    L11:
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.Initializing.ordinal();     // Catch: Throwable -> L105
        if (initInternal() == false) goto L103;
        this.mExecuteTasks.setMaxCount(4);     // Catch: Throwable -> L105
        this.mPreloadTasks.setMaxCount(20);     // Catch: Throwable -> L105
        if (this.mConfigure != null) goto L16;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();     // Catch: Throwable -> L105
    L16:
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L105
    L38:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L43;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L105
    L43:
        if (this.mEngineUploader == null) goto L46;
        this.mConfigure.mEnableReportTaskLog = 1;     // Catch: Throwable -> L105
    L46:
        if (this.mCloseLocalServer == false) goto L48;
        this.mConfigure.mCloseLocalServer = 1;     // Catch: Throwable -> L105
    L48:
        this.mInnerDataLoader.setConfigure(this.mConfigure);     // Catch: Throwable -> L105
        if (this.mInnerDataLoader.start() < 0) goto L101;
        startVCTrace();     // Catch: Throwable -> L105
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L53;
        TTVideoEngineLog.i(TAG, "[preload] preload strategy " + this.mMdlPreloadStrategy);     // Catch: Throwable -> L105
    L53:
        tryStartStrategyCenter();     // Catch: Throwable -> L105
        long r101 = this.mInnerDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);     // Catch: Throwable -> L105
        this.mMdlProtocolHandle = r101;     // Catch: Throwable -> L105
        if (r101 != (-1)) goto L57;
        this.mInvalidMdlProcotol = true;     // Catch: Throwable -> L105
    L57:
        if (this.mEnableFirstNativeMDL != 1) goto L79;
        if (this.mEnableMdlProtocol == false) goto L79;
        if (r101 <= 0) goto L79;
        Class<?> r102 = TTHelper.getClzUsingPluginLoader(200, PLAYER_CLASS_NAME);     // Catch: Throwable -> L66
        Method r103 = r102.getDeclaredMethod("registerNativeMdl", new Class[]{Long.TYPE});     // Catch: Throwable -> L66
        r103.setAccessible(true);     // Catch: Throwable -> L66
        if (((Integer) r103.invoke(r102, new Object[]{Long.valueOf(this.mMdlProtocolHandle)})).intValue() != 0) goto L79;
        TTVideoEngineLog.i(TAG, "firstNativeMDL effect");     // Catch: Throwable -> L66
        TTVideoEngineImpl.setNativeMDLRegister();     // Catch: Throwable -> L66
        this.mInvalidMdlProcotol = false;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L72;
        TTVideoEngineLog.e(TAG, th.toString());     // Catch: Throwable -> L105
    L72:
        if ((th instanceof InvocationTargetException) == false) goto L79;
        Throwable r104 = th.getTargetException();     // Catch: Throwable -> L105
        if (r104 == null) goto L79;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L79;
        TTVideoEngineLog.e(TAG, r104.toString());     // Catch: Throwable -> L105
    L79:
        if (this.mInnerDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetEnableHls) != 1) goto L81;
        boolean r105 = true;
    L82:
        this.mSupportHls = r105;     // Catch: Throwable -> L105
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L85;
        TTVideoEngineLog.i(TAG, "start: get mdlprotocolHandle: " + this.mMdlProtocolHandle);     // Catch: Throwable -> L105
    L85:
        this.mHeartBeat.start(this.mInnerDataLoader, this.mHeartBeatInterval);     // Catch: Throwable -> L105
        this.mState = 0;     // Catch: Throwable -> L105
        if (this.mInnerDataloaderStartComplete == true) goto L88;
    L90:
        this.mNetWorkChangeCb = new AnonymousClass3(this);     // Catch: Throwable -> L105
        this.mNetWorkChangeCbr = new WeakReference(this.mNetWorkChangeCb);     // Catch: Throwable -> L105
        TTNetWorkListener.getInstance().startListen(this.mNetWorkChangeCbr);     // Catch: Throwable -> L105
        int r106 = (int) this.mInnerDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetDemuxerVersion);     // Catch: Throwable -> L105
        this.mDemuxerHandle = MediaPlayerWrapper.getDemuxerFactory(r106);     // Catch: Throwable -> L105
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L94;
        TTVideoEngineLog.d(TAG, "KeyIsGetDemuxerVersion: " + r106 + ", handle: " + this.mDemuxerHandle);     // Catch: Throwable -> L105
    L94:
        if (this.mDemuxerHandle == 0) goto L96;
        TTVideoEngineLog.d(TAG, "set KeyIsSetDemuxerHandle");     // Catch: Throwable -> L105
        this.mInnerDataLoader.setLongValue(AVMDLDataLoader.KeyIsSetDemuxerHandle, this.mDemuxerHandle);     // Catch: Throwable -> L105
    L96:
        TTVideoEngineLog.d(TAG, "DataLoader start.");     // Catch: Throwable -> L105
        this.mLock.unlock(ABLock.TYPE_WRITE);
        if (EngineGlobalConfig.getInstance().enableMdlLockOptimizeV2 <= 0) goto L116;
        this.mLock.updateLockType(ABLock.LOCK_IMPL_VOID);
        return;
    L116:
        return;
    L88:
        if (this.mInitializeState != IVideoEventLogger.MdlInitializeState.Initializing.ordinal()) goto L90;
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeComplete.ordinal();     // Catch: Throwable -> L105
        goto L90
    L81:
        r105 = false;
        goto L82
    L101:
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeError.ordinal();     // Catch: Throwable -> L105
        this.mInitializeErrorString = "start data loader fail";     // Catch: Throwable -> L105
        throw new Exception("start data loader fail");     // Catch: Throwable -> L105
    L19:
        if (TextUtils.isEmpty(BaseAppInfo.mAppChannel) == true) goto L22;
        r100.put("app_channel", BaseAppInfo.mAppChannel);     // Catch: JSONException -> L38 Throwable -> L105
    L22:
        if (TextUtils.isEmpty(BaseAppInfo.mAppName) == true) goto L25;
        r100.put("app_name", BaseAppInfo.mAppName);     // Catch: JSONException -> L38 Throwable -> L105
    L25:
        if (TextUtils.isEmpty(BaseAppInfo.mDeviceId) == true) goto L28;
        r100.put("device_id", BaseAppInfo.mDeviceId);     // Catch: JSONException -> L38 Throwable -> L105
    L28:
        if (TextUtils.isEmpty(BaseAppInfo.mAppVersion) == true) goto L30;
        r100.put("app_version", BaseAppInfo.mAppVersion);     // Catch: JSONException -> L38 Throwable -> L105
    L30:
        int r107 = BaseAppInfo.mAppID;     // Catch: JSONException -> L38 Throwable -> L105
        if (r107 < 0) goto L35;
        r100.put("app_id", r107);     // Catch: JSONException -> L38 Throwable -> L105
    L35:
        if (r100.has("app_id") == false) goto L43;
        this.mConfigure.mAppInfo = r100.toString();     // Catch: JSONException -> L38 Throwable -> L105
        this.mConfigure.mAppID = BaseAppInfo.mAppID;     // Catch: JSONException -> L38 Throwable -> L105
    L103:
        String r108 = "initMdlFail:" + AVMDLDataLoader.getLoadFailMsg();     // Catch: Throwable -> L105
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.InitializeError.ordinal();     // Catch: Throwable -> L105
        throw new Exception(r108);     // Catch: Throwable -> L105
    }

    public void suspendPreconnect() {
        if (this.mInnerDataLoader != null) goto L6;
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.suspendPreconnect();
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void tryStartStrategyCenter() {
        if (this.mConfigure.mEnableIOManager == 0) goto L33;
        long r100 = this.mInnerDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetIOManagerHandle);
        long r101 = this.mInnerDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetIOManagerInterfaceVersion);
        if (r100 == 0) goto L30;
        if (r100 == (-1)) goto L30;
        if (r100 == (-998)) goto L30;
        if (r101 < 0) goto L30;
        this.mediaOperateThread = new PreloadMediaThread();
        StrategyHelper.helper().setIOManager(r100, r101);
        StrategyHelper.helper().setContext(this.mContext);
        if (this.mProxy == null) goto L16;
        boolean r102 = StrategyHelper.helper().loadPluginLibrary(this.mProxy);
    L17:
        StrategyHelper.helper().start(!r102);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L20;
        TTVideoEngineLog.d(TAG, "after start strategy center running=" + StrategyHelper.helper().isRunning());
    L20:
        StrategyHelper.helper().configAppInfo(BaseAppInfo.toJsonString(), null);
        StrategyHelper.helper().getCenter().h(31211, VideoEventBase.appSessionId);
        StrategyHelper.helper().getCenter().h(31209, this.mConfigure.mCacheDir);
        if (this.mInnerDataLoader.isRunning() == true) goto L23;
        return;
    L23:
        if (StrategyHelper.helper().isRunning() == false) goto L25;
        this.mInnerDataLoader.setIntValue(1030, this.mMdlPreloadStrategy);
        return;
    L25:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L27;
        TTVideoEngineLog.d(TAG, "strategy center start failed, set mdl preload strategy back " + this.mMdlOldPreloadStrategy);
    L27:
        this.mInnerDataLoader.setIntValue(1030, this.mMdlOldPreloadStrategy);
        return;
    L16:
        r102 = false;
    L30:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L37;
        TTVideoEngineLog.d(TAG, "tryStartStrategyCenter iomanagerHandle or iomanagerVersion is not validiomanagerHandle=" + r100 + " iomanagerVersion=" + r101);
        return;
    L37:
        return;
    }

    public void updateCurrentNetStatus() {
        if (this.mState == 0) goto L7;
        TTVideoEngineLog.d(TAG, "dataloader not started, not allow set play info");
        return;
    L7:
        if (this.mEnableSetMDLNetStatus > 0) goto L9;
        return;
    L9:
        this.mLock.lock(ABLock.TYPE_READ);
        int r100 = TTNetWorkListener.getInstance().getCurrentAccessStrength();
        this.mInnerDataLoader.setIntValue(AVMDLDataLoader.KeyIsUpdateNetworkStrength, r100);
        int r101 = PortraitNetworkScore.getInstance().getPortraitResult();
        this.mInnerDataLoader.setIntValue(AVMDLDataLoader.KeyIsUpdateNetworkScore, r101);
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    private DataLoaderHelper() {
        this.isProxyLibraryLoaded = false;
        AnonymousClass1 r100 = null;
        this.mProxy = null;
        this.mListener = new DataLoaderListenerWrapper();
        this.mTestSpeedListener = null;
        this.mState = 1;
        this.mPreloadTasks = new DataLoaderTaskQueue(this, r100);
        this.mExecuteTasks = new DataLoaderTaskQueue(this, r100);
        this.mAllPreloadTasks = new DataLoaderTaskQueue(this, r100);
        this.mAllPlayTasks = new DataLoaderTaskQueue(this, r100);
        this.mAllUsingEngies = new HashMap();
        this.mEngineLock = new ReentrantLock();
        this.mInnerDataLoader = null;
        this.mConfigure = null;
        this.mVCTrace = null;
        this.mDataLoaderHelperAdapter = new DataLoaderHelperAdapter();
        this.mContext = null;
        this.mClasssLoader = null;
        this.mModelCache = null;
        this.mException = null;
        this.mVersionInfo = null;
        this.mHeartBeat = null;
        this.mUploader = null;
        this.mEngineUploader = null;
        this.mNeedDLLoadP2PLib = 0;
        this.mNeedMDLLoadMDLV2Lib = false;
        this.mMdlProtocolHandle = -1;
        this.mDemuxerHandle = 0;
        this.mInvalidMdlProcotol = true;
        this.mMdlDataSourceId = 0;
        this.mEnableMdlProtocol = false;
        this.mHeartBeatInterval = 0;
        this.mEnableReportSpeed = 0;
        this.mEnableNetworkChangedListen = 0;
        this.mNetWorkChangeCb = null;
        this.mNetWorkChangeCbr = null;
        this.mCurrentAccessType = -1;
        this.mEnableDumpLibMd5 = 0;
        this.mNeedSpeedTestByTimeInternal = 0;
        this.mAudioPreloadFirst = false;
        this.mPreloadTaskIgnorePlayerStall = 1;
        this.mUpdatePlaySourceId = null;
        this.mFloatSize = 0;
        this.mPreloadPreConnect = 0;
        this.mEnablePreParseHost = 0;
        this.mEnableBackupIP = 0;
        this.mEnableFirstNativeMDL = 0;
        this.mCloseLocalServer = false;
        this.mEnableHls = 0;
        this.mSupportHls = false;
        this.mediaOperateThread = null;
        this.mReportLogEnable = true;
        this.mBackupLoaderType = 0;
        this.mMdlPreloadStrategy = 1;
        this.mMdlOldPreloadStrategy = 0;
        this.mEnableMdlV2 = 0;
        this.mDidConfigMdlV2 = false;
        this.mEnableBufferPreload = 0;
        this.mEnableSetMDLNetStatus = 0;
        this.mEnableStrategyCenterCancelAll = 0;
        this.mEnableCheckPreloadUrls = 0;
        this.mEnableSplitPreload = 0;
        this.mDashAudioPreloadMinSize = 0;
        this.mDashAudioPreloadRatio = 0;
        this.mForbidNativeMDLForOriUrl = false;
        this.mPreloadUtil = new PreloadUtil();
        this.mEnableLibManager = 0;
        this.mEnableHLSProxy = 0;
        this.mEnableCheckHLSProxyVVCtrl = 0;
        this.mEnablePreloadFirstTs = 0;
        this.mEnablePreloadAllTs = 0;
        this.mEnableLoadMdlv2Fulllib = 0;
        this.mEnableVideoModelHitCacheCallback = 0;
        this.mHLSProxyValid = false;
        this.mEnableCenterPreloadProgressCallback = 0;
        this.mEnableNotifyError = 0;
        this.mEnableNotOnlyNotifyNetError = 0;
        this.mDisableFilePathCheck = 0;
        this.mNotifyNetErrors = new ArrayList();
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.None.ordinal();
        this.mInitializeState = IVideoEventLogger.MdlInitializeState.Default.ordinal();
        this.mInnerDataloaderStartComplete = false;
        this.mInitializeErrorString = null;
        this.mModelCache = VideoModelCache.getInstance();
        this.mState = 1;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.mVCTrace = new VCTrace();
        this.mLock = new ABLockWrapper(EngineGlobalConfig.getInstance().dataLoaderHelperLockType);
    }

    public static DataLoaderHelper getDataLoader() {
        return Holder.access$200();
    }

    public void switchToCellularNetwork() {
        TTVideoEngineLog.d("multinetwork", "start do switch to cellular");
        AVMDLMultiNetwork.switchToCellularNetwork();
        TTVideoEngineLog.d("multinetwork", "end do switch to cellular");
    }

    public void switchToDefaultNetwork() {
        TTVideoEngineLog.d("multinetwork", "start do switch to default");
        AVMDLMultiNetwork.switchToDefaultNetwork();
        TTVideoEngineLog.d("multinetwork", "end do switch to default");
    }

    public int getMdlInitializeState() {
        return this.mInitializeState;
    }

    public /* synthetic */ DataLoaderHelper(AnonymousClass1 r100) {
        this();
    }

    private String _constructEnginePortaint(Map<String, Object> r100) {
        JSONObject r101 = new JSONObject();
        r101.put("enable_engineportaint", this.mConfigure.mEnableEnginePortrait);     // Catch: JSONException -> L9
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L9
        goto L5
    L7:
        return r101.toString();
    L9:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L13;
        TTVideoEngineLog.d(e);
    L13:
        return "";
    }

    private void _doMl_addPriorityTask(PreloadModelMedia r100) {
        MyPreloadTaskCallbackListener r101 = null;
        if (r100.getSelectCallback() == null) goto L5;
        MySelectBitrateListener r102 = new MySelectBitrateListener(this, r100.getSelectCallback());
    L7:
        if (r100.getCallBackListener() == null) goto L9;
        r101 = new MyPreloadTaskCallbackListener(this, r100.getCallBackListener());
    L9:
        StrategyHelper.helper().getCenter().d(r100.toStrategyInfo(), r102, r101);
        return;
    L5:
        r102 = null;
        goto L7
    }

    private void _doMl_removePriorityTask(String r100) {
        StrategyHelper.helper().getCenter().x(r100);
    }

    private void _exectTask(DataLoaderTaskItem r510) {
        if (r510 != null) goto L7;
        _startExecuteTask();
        return;
    L7:
        if (this.mInnerDataLoader != null) goto L10;
        TTVideoEngineLog.e(TAG, "[preload] need load mdl first.");
        return;
    L10:
        PreloaderVidItem r100 = r510.mVidItem;
        if (r100 == null) goto L15;
        Map<Integer, String> r101 = r100.mParams;
        if (r101 == null) goto L15;
    L16:
        PreloaderVideoModelItem r102 = r510.mVideoModelItem;
        if (r102 == null) goto L21;
        Map<Integer, String> r103 = r102.mParams;
        if (r103 == null) goto L21;
        r101 = r103;
    L21:
        this.mExecuteTasks.popItem(r510);
        long r104 = r510.mPreloadSize;
        if (r510.mResponseData == null) goto L316;
        ArrayList r105 = new ArrayList();
        boolean r106 = r510.mResponseData.hasFormat(IVideoModel.Format.DASH);
        long r110 = WsConstants.DEFAULT_IO_LIMIT;
        String r111 = "[preload] preload videoOffset ";
        if (r106 == true) goto L26;
        VideoInfo r107 = r510.mResponseData.getVideoInfo(r510.mSetResolution, r101, true);
        if (r107 == null) goto L300;
        String r108 = r107.getValueStr(15);
        if (TextUtils.isEmpty(r108) == true) goto L300;
        r105.add(r107);
        DataLoaderTaskItem.TrackItem r109 = r510.addTrackItemByKey(r108);
        MediaBitrateFitterInfo r112 = r107.getBitrateFitterInfo();
        PreloaderVideoModelItem r113 = r510.mVideoModelItem;
        if (r113 == null) goto L230;
        long r114 = r113.mPreloadMilliSecondOffset;
        long r310 = r113.mVideoHeaderExtraSize;
        long r115 = r114;
        long r210 = r113.mVideoPacketExtraOffset;
    L232:
        if (isMDLPrecisePreloadEnable() == false) goto L244;
        PreloaderVideoModelItem r116 = r510.mVideoModelItem;
        if (r116 != null) goto L236;
    L243:
        ArrayList r410 = r105;
        long r311 = r104;
        long r211 = 0;
    L252:
        long r117 = r211;
        long r118 = r117;
    L254:
        if (r115 <= r211) goto L272;
        HashMap<Double, Long> r119 = r107.mPacketOffset;
        if (r119 == null) goto L270;
        Long r120 = r119.get(Double.valueOf(r115 / 1000.0d));
        if (r120 == null) goto L264;
        long r121 = r120.longValue();
        if (r210 <= r211) goto L265;
        r121 = r121 - r210;
        if (r121 >= r211) goto L265;
        int r122 = 2;
        r121 = 0;
    L267:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(r122) == false) goto L273;
        TTVideoEngineLog.i(TAG, "[preload] preload millisecondOffset " + r115);
        TTVideoEngineLog.i(TAG, "[preload] preload videoOffset " + r121);
    L273:
        long r123 = r510.mPreloadSize;
        float r124 = r510.mPreloadSecond;
        if (r124 <= 0.0f) goto L294;
        if (r112 == null) goto L294;
        int r125 = r112.calculateSizeBySecond(r124);
        if (r125 <= 0) goto L279;
        r123 = r125;
        int r126 = 1;
    L280:
        long r127 = r510.mTimePreloadLowerLimitSize;
        long r128 = 0;
        if (r127 > 0) goto L283;
    L285:
        long r129 = r510.mTimePreloadUpperLimitSize;
        if (r129 > 0) goto L288;
    L290:
        int r130 = r126;
        int r131 = 2;
    L292:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(r131) == false) goto L296;
        TTVideoEngineLog.i(TAG, "[preload] preload second" + r510.mPreloadSecond + " ,video size = " + r123);
    L296:
        if (r107.getMediatype() != VideoRef.TYPE_VIDEO) goto L298;
        long r132 = r123;
    L299:
        r109.mPreSize = r123;
        r109.mPreloadOffset = r121;
        r109.mPreloadHeaderSize = r117;
        _prepareUrlInfo(r107, r510);
        _startMDLPreloadTask(r510, r109);
        long r133 = r128;
    L303:
        if (r410.size() != 0) goto L306;
        TTVideoEngineLog.i(TAG, "invalid videoModel");
        _startExecuteTask();
        return;
    L306:
        PreloaderVidItem r134 = r510.mVidItem;
        if (r134 == null) goto L311;
        PreloaderVidItemListener r135 = r134.mListener;
        if (r135 == null) goto L311;
        ArrayList r136 = r410;
        r135.onUsingUrlInfos(r136);
    L313:
        if (r510.getCallBackListener() == null) goto L315;
        PreLoaderItemCallBackInfo r137 = new PreLoaderItemCallBackInfo(1);
        r137.usingUrlInfos = r136;
        r510.getCallBackListener().preloadItemInfo(r137);
    L315:
        long r138 = r133;
    L333:
        if (r510.getCallBackListener() == null) goto L337;
        PreLoaderItemCallBackInfo r139 = new PreLoaderItemCallBackInfo(6);
        r139.preloadType = r130;
        r139.videoPreloadSize = r132;
        r139.audioPreloadSize = r138;
        r510.getCallBackListener().preloadItemInfo(r139);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L337;
        TTVideoEngineLog.i(TAG, "[preload] notify info. type = " + r130);
    L337:
        _startExecuteTask();
        return;
    L311:
        r136 = r410;
        goto L313
    L298:
        r128 = r123;
        r132 = r311;
        goto L299
    L288:
        if (r123 <= r129) goto L290;
        r123 = r129;
        r131 = 2;
        r130 = 0;
        goto L292
    L283:
        if (r123 >= r127) goto L285;
        r123 = r127;
        r126 = 0;
        goto L285
    L279:
        r126 = 0;
    L294:
        r128 = 0;
        r130 = 0;
    L265:
        r122 = 2;
        goto L267
    L264:
        r121 = r118;
        goto L265
    L270:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L272;
        TTVideoEngineLog.i(TAG, "[preload] packet offset info not avaiable preload" + r115);
    L272:
        r121 = r118;
        goto L273
    L236:
        if (r116.getStartTimestamp() <= 0) goto L243;
        if (r112 == null) goto L243;
        r311 = r104;
        long r140 = r112.getHeaderSize();
        r410 = r105;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L242;
        TTVideoEngineLog.i(TAG, "[preload] preload video header size " + r140 + ",timeStamp:" + r510.mVideoModelItem.getStartTimestamp());
    L242:
        r117 = r140;
        r118 = 0;
        r211 = 0;
        goto L254
    L244:
        r410 = r105;
        r311 = r104;
        r211 = 0;
        if (r115 <= 0) goto L252;
        if (r112 == null) goto L252;
        long r141 = r112.calculateSizeBySecond(r115 / 1000.0f);
        if (r310 == 0) goto L251;
        r110 = r310;
    L251:
        r118 = r141;
        r117 = ((long) r112.getHeaderSize()) + r110;
        goto L254
    L230:
        r115 = 0;
        r210 = 0;
        r310 = 0;
    L300:
        r410 = r105;
    L301:
        r133 = 0;
        r132 = r104;
        r130 = 0;
        goto L303
    L26:
        if (r510.mResponseData.getDynamicType().equals(TTVideoEngineInterface.DYNAMIC_TYPE_SEGMENTBASE) == false) goto L222;
        VideoInfo r142 = r510.mResponseData.getVideoInfo(r510.mSetResolution, VideoRef.TYPE_VIDEO, r101, true);
        VideoInfo r143 = r510.mResponseData.getVideoInfo(r510.mSetResolution, VideoRef.TYPE_AUDIO, r101, true);
        long r144 = r510.mPreloadSize;
        if (r142 == null) goto L198;
        if (r143 == null) goto L198;
        MediaBitrateFitterInfo r145 = r143.getBitrateFitterInfo();
        MediaBitrateFitterInfo r146 = r142.getBitrateFitterInfo();
        PreloaderVideoModelItem r147 = r510.mVideoModelItem;
        if (r147 == null) goto L33;
        long r148 = r147.mPreloadMilliSecondOffset;
        long r312 = r147.mAudioHeaderExtraSize;
        long r313 = r147.mAudioPacketExtraOffset;
        long r314 = r147.mVideoHeaderExtraSize;
        long r149 = r148;
        long r315 = r147.mVideoPacketExtraOffset;
    L34:
        HashMap<Double, Long> r150 = r143.mPacketOffset;
        ArrayList r411 = r105;
        if (r150 == null) goto L53;
        MediaBitrateFitterInfo r412 = r145;
        String r413 = "[preload] preload size  audio = ";
        double r151 = r149 / 1000.0d;
        if (r150.get(Double.valueOf(r151)) == null) goto L54;
        HashMap<Double, Long> r152 = r142.mPacketOffset;
        if (r152 == null) goto L54;
        if (r152.get(Double.valueOf(r151)) == null) goto L54;
        Long r153 = r143.mPacketOffset.get(Double.valueOf(r151));
        Long r154 = r142.mPacketOffset.get(Double.valueOf(r151));
        if (r153 == null) goto L45;
        long r155 = r153.longValue();
    L46:
        if (r154 == null) goto L48;
        long r156 = r154.longValue();
    L49:
        r143 = r143;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L56;
        TTVideoEngineLog.i(TAG, "[preload] preload millisecondOffset " + r149);
        TTVideoEngineLog.i(TAG, "[preload] preload audioOffset " + r155);
        TTVideoEngineLog.i(TAG, "[preload] preload videoOffset " + r156);
    L56:
        if (isMDLPrecisePreloadEnable() == false) goto L85;
        PreloaderVideoModelItem r157 = r510.mVideoModelItem;
        if (r157 != null) goto L60;
    L84:
        String r414 = "[preload] preload audioOffset ";
        VideoInfo r415 = r142;
        String r416 = "[preload] preload second";
        r111 = "[preload] preload videoOffset ";
        MediaBitrateFitterInfo r158 = r412;
        long r159 = r156;
        long r160 = 0;
        long r161 = 0;
    L125:
        float r162 = r510.mPreloadSecond;
        if (r162 <= 0.0f) goto L150;
        if (r158 == null) goto L150;
        if (r146 == null) goto L150;
        long r163 = r146.calculateSizeBySecond(r162);
        long r164 = r160;
        long r165 = r158.calculateSizeBySecond(r510.mPreloadSecond);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L132;
        StringBuilder r166 = new StringBuilder(r416);
        r166.append(r510.mPreloadSecond);
        r166.append(" preload size audio = ");
        r166.append(r165);
        String r167 = " ,video = ";
        r166.append(r167);
        r166.append(r163);
        TTVideoEngineLog.i(TAG, r166.toString());
        TTVideoEngineLog.i(TAG, r414 + r155);
        TTVideoEngineLog.i(TAG, r111 + r159);
    L133:
        long r168 = r510.mTimePreloadLowerLimitSize;
        if (r168 > 0) goto L136;
    L141:
        long r169 = r510.mTimePreloadUpperLimitSize;
        if (r169 > 0) goto L144;
    L149:
        long r170 = r165;
        int r171 = 1;
    L151:
        long r172 = 0;
    L153:
        if (r149 <= r172) goto L163;
        long r173 = r510.mPreloadSize;
        int r174 = this.mDashAudioPreloadRatio;
        if (r174 <= 0) goto L162;
        long r175 = (((long) r174) * r173) / 100;
        int r176 = this.mDashAudioPreloadMinSize;
        long r212 = r159;
        if (r176 > 0) goto L159;
    L161:
        int r177 = r171;
        r163 = r173;
        String r178 = r413;
        VideoInfo r179 = r415;
        VideoInfo r180 = r143;
        long r213 = r175;
    L182:
        long r181 = r510.mDashAudioPreloadSize;
        if (r181 != (-1)) goto L188;
        long r214 = r163;
        if (r510.mDashVideoPreloadSize != (-1)) goto L188;
        int r182 = r177;
        long r183 = r164;
        long r184 = r213;
        long r185 = r214;
        long r417 = r212;
        long r186 = r161;
        int r187 = 2;
    L200:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(r187) == false) goto L203;
        TTVideoEngineLog.i(TAG, r178 + r184 + r167 + r185);
    L203:
        if (r180 == null) goto L207;
        String r188 = r180.getValueStr(15);
        if (TextUtils.isEmpty(r188) == true) goto L207;
        ArrayList r189 = r411;
        r189.add(r180);
        DataLoaderTaskItem.TrackItem r190 = r510.addTrackItemByKey(r188);
        r190.mPreSize = r184;
        r190.mPreloadHeaderSize = r186;
        r190.mPreloadOffset = r155;
    L208:
        if (r179 == null) goto L212;
        String r191 = r179.getValueStr(15);
        if (TextUtils.isEmpty(r191) == true) goto L212;
        r189.add(r179);
        DataLoaderTaskItem.TrackItem r192 = r510.addTrackItemByKey(r191);
        r192.mPreSize = r185;
        r192.mPreloadHeaderSize = r183;
        r192.mPreloadOffset = r417;
    L214:
        if (this.mAudioPreloadFirst == false) goto L217;
        if (r190 == null) goto L217;
        _prepareUrlInfo(r180, r510);
        _startMDLPreloadTask(r510, r190);
    L217:
        if (r192 == null) goto L219;
        _prepareUrlInfo(r179, r510);
        _startMDLPreloadTask(r510, r192);
    L219:
        if (r190 == null) goto L221;
        _prepareUrlInfo(r180, r510);
        _startMDLPreloadTask(r510, r190);
    L221:
        r410 = r189;
        r133 = r184;
        r130 = r182;
        r132 = r185;
    L212:
        r192 = null;
    L207:
        r189 = r411;
        r190 = null;
    L188:
        long r193 = r510.mDashVideoPreloadSize;
        if (r181 != (-1)) goto L192;
        r181 = r510.mPreloadSize - r193;
    L192:
        if (r193 != (-1)) goto L195;
        r193 = r510.mPreloadSize - r181;
    L195:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L197;
        TTVideoEngineLog.i(TAG, "[preload] user preset preload size  audio = " + r181 + r167 + r193);
    L197:
        r182 = r177;
        r183 = r164;
        r417 = r212;
        r186 = r161;
        r187 = 2;
        long r511 = r181;
        r185 = r193;
        r184 = r511;
        goto L200
    L159:
        if (r175 >= r176) goto L161;
        long r194 = r176;
        r177 = r171;
        r163 = r173;
        r180 = r143;
        r213 = r194;
        r178 = r413;
        r179 = r415;
        goto L182
    L162:
        r212 = r159;
        r177 = r171;
        r163 = r173;
        r180 = r143;
        r178 = r413;
        r179 = r415;
        r213 = r163;
        goto L182
    L163:
        r212 = r159;
        if (r163 <= 0) goto L174;
        if (r170 <= 0) goto L174;
        long r195 = r510.mPreloadSize;
        if (r163 == r195) goto L170;
    L172:
        r177 = r171;
        r180 = r143;
        r178 = r413;
        r179 = r415;
        r213 = r170;
        goto L182
    L170:
        if (r170 != r195) goto L172;
    L174:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L176;
        r178 = r413;
        TTVideoEngineLog.i(TAG, r178 + r170 + r167 + r163);
    L177:
        r179 = r415;
        int r196 = r179.getValueInt(3);
        r180 = r143;
        int r197 = r180.getValueInt(3);
        if (r196 <= 0) goto L181;
        if (r197 <= 0) goto L181;
        long r198 = r510.mPreloadSize;
        r163 = (long) (r198 * (r196 / (r196 + r197)));
        r170 = r198 - r163;
    L181:
        r213 = r170;
        r177 = 0;
        goto L182
    L176:
        r178 = r413;
        goto L177
    L144:
        if ((r163 + r165) <= r169) goto L149;
        r510.mPreloadSize = r169;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L148;
        TTVideoEngineLog.i(TAG, "[preload] preload size limit to" + r510.mTimePreloadUpperLimitSize);
    L148:
        r171 = 1;
        r170 = 0;
        r172 = 0;
        r163 = 0;
        goto L153
    L136:
        if ((r163 + r165) >= r168) goto L141;
        r510.mPreloadSize = r168;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L140;
        TTVideoEngineLog.i(TAG, "[preload] preload size limit to" + r510.mTimePreloadLowerLimitSize);
    L140:
        r165 = 0;
        r163 = 0;
        goto L141
    L132:
        r167 = " ,video = ";
    L150:
        r164 = r160;
        r167 = " ,video = ";
        r161 = r161;
        r170 = r144;
        r163 = r170;
        r171 = 0;
        goto L151
    L60:
        if (r157.getStartTimestamp() <= 0) goto L84;
        if (r412 == null) goto L63;
        long r199 = r412.getHeaderSize();
    L64:
        String r200 = r142.getValueStr(47);
        if (TextUtils.isEmpty(r200) == true) goto L74;
        r415 = r142;
        String[] r201 = r200.split("-");
        r414 = "[preload] preload audioOffset ";
        r416 = "[preload] preload second";
        if (r201.length != 2) goto L72;
        long r202 = CastLongProtector.parseLong(r201[1]) + 1;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L73;
        TTVideoEngineLog.i(TAG, "[preload] first moof range: " + r200 + "header size: " + r202);
    L73:
        long r203 = r202;
    L81:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L83;
        TTVideoEngineLog.i(TAG, "[preload] preload video header size:" + r203 + ",audio header size:" + r199 + r1 + r510.mVideoModelItem.getStartTimestamp());
    L83:
        r160 = r203;
        r161 = r199;
        r158 = r412;
        r159 = r156;
        goto L125
    L72:
        r202 = 0;
        goto L73
    L74:
        r156 = r156;
        r414 = "[preload] preload audioOffset ";
        r415 = r142;
        r416 = "[preload] preload second";
        if (r146 == null) goto L79;
        r203 = r146.getHeaderSize();
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L81;
        TTVideoEngineLog.i(TAG, "[preload] fitter info header size: " + r203);
        goto L81
    L79:
        TTVideoEngineLog.i(TAG, "[preload] header size = 0");
        r203 = 0;
        goto L81
    L63:
        r199 = 0;
        goto L64
    L85:
        long r418 = r156;
        r414 = "[preload] preload audioOffset ";
        r415 = r142;
        r416 = "[preload] preload second";
        r111 = "[preload] preload videoOffset ";
        if (r149 <= 0) goto L106;
        if (r412 == null) goto L106;
        if (r155 != 0) goto L91;
        r158 = r412;
        r155 = r158.calculateSizeBySecond(r149 / 1000.0f);
    L93:
        if (r312 == 0) goto L96;
        r110 = r312;
    L96:
        r161 = ((long) r158.getHeaderSize()) + r110;
        if (r155 <= 0) goto L102;
        long r1100 = r155 - r313;
        if (r1100 >= 0) goto L101;
        int r204 = 2;
        r155 = 0;
    L104:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(r204) == false) goto L107;
        TTVideoEngineLog.i(TAG, "[preload] preload audio header size " + r161);
    L107:
        if (r149 <= 0) goto L124;
        if (r146 == null) goto L124;
        if (r418 != 0) goto L112;
        r159 = r146.calculateSizeBySecond(r149 / 1000.0f);
    L113:
        long r205 = r146.getHeaderSize();
        long r1101 = r510.mPreloadSize;
        if (r205 <= r1101) goto L116;
        r1101 = r146.getHeaderSize();
    L116:
        r160 = r1101 + r314;
        if (r159 <= 0) goto L122;
        r159 = r159 - r315;
        if (r159 >= 0) goto L122;
        r159 = 0;
    L122:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L125;
        TTVideoEngineLog.i(TAG, "[preload] preload video header size " + r160);
        goto L125
    L112:
        r159 = r418;
    L124:
        r159 = r418;
        r160 = 0;
        goto L125
    L101:
        r155 = r1100;
    L102:
        r204 = 2;
        goto L104
    L91:
        r158 = r412;
    L106:
        r158 = r412;
        r161 = 0;
        goto L107
    L48:
        r156 = 0;
        goto L49
    L45:
        r155 = 0;
    L54:
        r156 = 0;
        r155 = 0;
        goto L56
    L53:
        r412 = r145;
        r413 = "[preload] preload size  audio = ";
        goto L54
    L33:
        r149 = 0;
        r315 = 0;
        r312 = 0;
        r313 = 0;
        r314 = 0;
    L198:
        r411 = r105;
        r167 = " ,video = ";
        r178 = "[preload] preload size  audio = ";
        r180 = r143;
        r179 = r142;
        r185 = r144;
        r184 = r185;
        r186 = 0;
        r183 = 0;
        r155 = 0;
        r182 = 0;
        r187 = 2;
        r417 = 0;
        goto L200
    L222:
        r410 = r105;
        goto L301
    L316:
        PreloaderURLItem r206 = r510.mURLItem;
        if (r206 != null) goto L319;
    L323:
        PreloaderURLItem r207 = r510.mURLItem;
        if (r207 != null) goto L326;
    L331:
        r138 = 0;
        r132 = r104;
        r130 = 0;
        goto L333
    L326:
        if (r207.getProvider() == null) goto L331;
        DataLoaderTaskItem.TrackItem r208 = (DataLoaderTaskItem.TrackItem) ListProtector.get(r510.mTracks, 0);
        r208.mProxyUrl = proxyQueryProvideMode(r208.mTaskKey, r510.mVideoId, r510.mPriorityLevel, 1, r510.mGroupId);
        r208.mPreSize = r510.mPreloadSize;
        r208.mUsingResolution = r510.mSetResolution;
        r208.mUrls = r510.mURLItem.getUrls();
        r208.mLocalFilePath = r510.mURLItem.getFilePath();
        r208.mCustomHeader = _headerString(r510.mURLItem.customHeaders());
        r208.mUrlExpireTimes = r510.mURLItem.getUrlExpireTimes();
        _startMDLPreloadTask(r510, r208);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L331;
        TTVideoEngineLog.i(TAG, String.format("exect preload task by provider mode, key is %s; videoId = %s proxyurl:%s", new Object[]{r208.mTaskKey, r510.mVideoId, r208.mProxyUrl}));
        goto L331
    L319:
        if (r206.getUrls() == null) goto L323;
        if (r510.mURLItem.getUrls().length <= 0) goto L323;
        DataLoaderTaskItem.TrackItem r209 = (DataLoaderTaskItem.TrackItem) ListProtector.get(r510.mTracks, 0);
        r209.mUrls = r510.mURLItem.getUrls();
        r209.mPreSize = r510.mPreloadSize;
        r209.mUsingResolution = r510.mSetResolution;
        r209.mLocalFilePath = r510.mURLItem.getFilePath();
        r209.mCustomHeader = _headerString(r510.mURLItem.customHeaders());
        r209.mPreloadFooterSize = r510.mURLItem.getPreloadFooterSize();
        r209.mUrlExpireTimes = r510.mURLItem.getUrlExpireTimes();
        _startMDLPreloadTask(r510, r209);
    L15:
        r101 = null;
        goto L16
    }

    private ArrayList<WeakReference<TTVideoEngine>> _getEnginesByRawKey(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L17;
        return null;
    L17:
        this.mEngineLock.lock();     // Catch: Throwable -> L14
        ArrayList<WeakReference<TTVideoEngine>> r101 = this.mAllUsingEngies.get(r100);     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        ArrayList<WeakReference<TTVideoEngine>> r102 = new ArrayList();     // Catch: Throwable -> L14
        r102.addAll(r101);     // Catch: Throwable -> L14
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L10;
        TTVideoEngineLog.i(TAG, "get engine ref,rawKey = " + r100 + " engine ref count: " + r102.size());     // Catch: Throwable -> L14
    L10:
        this.mEngineLock.unlock();
        return r102;
    L12:
        this.mEngineLock.unlock();
        return null;
    L14:
        th = move-exception;
        this.mEngineLock.unlock();
        throw th;
    }

    private void _notifyPreloadCancel(DataLoaderTaskItem r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.mDidCanceled == false) goto L7;
        return;
    L7:
        r100.mDidCanceled = true;
        if (r100.getCallBackListener() == null) goto L11;
        PreLoaderItemCallBackInfo r101 = new PreLoaderItemCallBackInfo(5);
        r100.getCallBackListener().preloadItemInfo(r101);
        return;
    }

    private JSONObject _onHeartBeatFire(JSONObject r100) {
        long r101 = VideoInfoCollector.getInstance().getPlayWastDataSize();     // Catch: Exception -> L9
        if (r101 <= 0) goto L5;
        r100.put("_play_waste_data", r101);     // Catch: Exception -> L9
    L5:
        long r102 = VideoInfoCollector.getInstance().getPlayConsumedSize();     // Catch: Exception -> L9
        if (r102 <= 0) goto L8;
        r100.put("_play_consumed_data", r102);     // Catch: Exception -> L9
    L8:
        return r100;
    }

    private DataLoaderCacheInfo _processCacheInfo(String r100) {
        DataLoaderCacheInfo r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        String[] r102 = r100.split(",");
        if (r102.length < 4) goto L13;
        r101 = new DataLoaderCacheInfo(this);
        r101.mLocalFilePath = r102[3];
        if (TextUtils.isEmpty(r102[0]) == true) goto L11;
        r101.mCacheSizeFromZero = CastLongProtector.valueOf(r102[0]).longValue();
    L11:
        if (TextUtils.isEmpty(r102[1]) == true) goto L13;
        r101.mMediaSize = CastLongProtector.valueOf(r102[1]).longValue();
    L13:
        return r101;
    }

    private String[] _removeRepeatUrls(String[] r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length <= 1) goto L27;
        ArrayList r101 = new ArrayList();
        r101.add(r100[0]);
        int r102 = 1;
    L8:
        if (r102 >= r100.length) goto L19;
        String r103 = r100[r102];
        Boolean r104 = Boolean.TRUE;
        int r105 = r101.size() - 1;
    L10:
        if (r105 < 0) goto L16;
        if (((String) ListProtector.get(r101, r105)).equals(r103) == true) goto L13;
        r105 = r105 - 1;
        goto L10
    L13:
        r104 = Boolean.FALSE;
    L16:
        if (r104.booleanValue() == false) goto L18;
        r101.add(r103);
    L18:
        r102 = r102 + 1;
        goto L8
    L19:
        String[] r106 = new String[r101.size()];
        r101.toArray(r106);
        return r106;
    L27:
        return r100;
    }

    private void _startFetchSmartUrlInfo(DataLoaderTaskItem r100) {
        PreloaderURLItem r101 = r100.mURLItem;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.mAdapter != null) goto L8;
        return;
    L8:
        r101.mAdapter.fetchSmartUrlInfo(new DataLoaderTaskItem.MySmartUrlFetcherListener(r100));
    }

    private void _startFetchVideoInfo(DataLoaderTaskItem r110) {
        r110.removeVidPlaceholderTrack();
        HashMap r100 = new HashMap();
        PreloaderVidItem r101 = r110.mVidItem;
        if (r101 != null) goto L5;
    L7:
        PreloaderVidItem r102 = r110.mVidItem;
        if (r102 != null) goto L10;
    L12:
        PreloaderVidItem r103 = r110.mVidItem;
        if (r103 != null) goto L15;
    L17:
        PreloaderVidItem r104 = r110.mVidItem;
        if (r104 != null) goto L20;
    L22:
        PreloaderVidItem r105 = r110.mVidItem;
        String r106 = null;
        if (r105 == null) goto L30;
        PreloaderVidItemListener r107 = r105.mListener;
        if (r107 == null) goto L30;
        String r108 = r107.apiString(r100, r110.mVideoId, r105.mApiVersion);
        PreloaderVidItem r109 = r110.mVidItem;
        String r111 = r109.mListener.authString(r110.mVideoId, r109.mApiVersion);
        if (r110.mVidItem.mBoeEnable == false) goto L29;
        r108 = TTHelper.buildBoeUrl(r108);
    L29:
        r110.mApiString = r108;
    L32:
        if (this.mListener != null) goto L34;
    L39:
        int r112 = PortraitNetworkScore.getInstance().getLastPortraitResult();
        if (r112 == (-1)) goto L42;
        r108 = r108 + String.format("&%s=%s", new Object[]{TTVideoEngineInterface.PLAY_API_KEY_NETWORKCORE, Integer.valueOf(r112)});
        r110.mApiString = TTVideoEngineUtils.BuildHttpsApi(r108);
    L42:
        String r113 = TTVideoEngineUtils.BuildHttpsApi(r108);
        monitor-enter(PreloaderVidItem.class);
        VideoModelCache.VideoModelCacheInfo r114 = this.mModelCache.get(r110.mVideoId, r113);     // Catch: Throwable -> L86
        monitor-exit(PreloaderVidItem.class);     // Catch: Throwable -> L86
        if (r114 == null) goto L78;
        if (r114.isExpired == true) goto L78;
        r110.mResponseData = r114.model;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L53;
        TTVideoEngineLog.i(TAG, String.format("[preload] get videoModel , videoId = %s", new Object[]{r110.mVideoId}));
    L53:
        PreloaderVidItem r115 = r110.mVidItem;
        if (r115 == null) goto L63;
        if (r115.mGearStrategyEnabled != 3) goto L63;
        if (r115.mResolution != Resolution.Auto) goto L63;
        IVideoInfo r116 = GearStrategySC.selectBitrate(r114.model, 2, r115.mGearStrategyExtraParams, null);
        if (r116 == null) goto L63;
        r110.mVidItem.mResolution = r116.getResolution();
        r110.mSetResolution = r110.mVidItem.mResolution;
    L63:
        if (this.mEnableVideoModelHitCacheCallback == 1) goto L65;
    L76:
        _exectTask(r110);
        return;
    L65:
        if (r110.mResponseData != null) goto L67;
    L71:
        PreloaderVidItem r117 = r110.mVidItem;
        if (r117 == null) goto L76;
        if (r117.getFetchEndListener() == null) goto L76;
        r110.mVidItem.getFetchEndListener().fetchEnd((VideoModel) r110.mResponseData, r110.mResponseError);
        r110.mSetResolution = r110.mVidItem.mResolution;
        goto L76
    L67:
        if (r110.getCallBackListener() == null) goto L71;
        PreLoaderItemCallBackInfo r118 = new PreLoaderItemCallBackInfo(4);
        r118.fetchVideoModel = (VideoModel) r110.mResponseData;
        r110.getCallBackListener().preloadItemInfo(r118);
        PreloaderVidItem r119 = r110.mVidItem;
        if (r119 == null) goto L71;
        r110.mSetResolution = r119.mResolution;
    L78:
        if (r110.mVidItem == null) goto L92;
        r110.mFetcher = new VideoInfoFetcher(this.mContext, r110.mVidItem.getNetClient());
        r110.setFetchListener();
        r110.mFetcher.setResolutionMap(r110.mVidItem.mResolutionMap);
        r110.mFetcher.setVideoID(r110.mVidItem.mVideoId);
        r110.mFetcher.setUseVideoModelCache(true);
        VideoInfoFetcher r120 = r110.mFetcher;
        int r121 = r110.mVidItem.mApiVersion;
        if (r121 == 2) goto L84;
        if (r121 == 4) goto L84;
        r106 = r111;
    L84:
        r120.fetchInfo(r113, r106, r121);
        return;
    L92:
        return;
    L86:
        th = move-exception;
        throw th;
    L34:
        if (TextUtils.isEmpty(r110.mApiString) == false) goto L39;
        String r122 = this.mListener.apiStringForFetchVideoModel(r100, r110.mVideoId, r110.mSetResolution);
        r111 = this.mListener.authStringForFetchVideoModel(r110.mVideoId, r110.mSetResolution);
        if (r110.mVidItem.mBoeEnable == false) goto L38;
        r122 = TTHelper.buildBoeUrl(r122);
    L38:
        r108 = r122;
        r110.mApiString = TTVideoEngineUtils.BuildHttpsApi(r108);
    L30:
        r108 = null;
        r111 = null;
        goto L32
    L20:
        if (r104.mHttpsEnable == false) goto L22;
        r100.put(TTVideoEngineInterface.PLAY_API_KEY_SSL, "1");
        goto L22
    L15:
        if (r103.mDashEnable == false) goto L17;
        r100.put("format_type", "dash");
        goto L17
    L10:
        if (r102.mCodecType.equals("bytevc1") == false) goto L12;
        r100.put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, "3");
        goto L12
    L5:
        if (r101.mCodecType.equals("bytevc2") == false) goto L7;
        r100.put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, "4");
        goto L12
    }

    private boolean _supportProxy(String r100) {
        return _supportProxy(r100, 0);
    }

    public static /* synthetic */ LibraryLoaderProxy access$300(DataLoaderHelper r100) {
        return r100.mProxy;
    }

    public static /* synthetic */ DataLoaderListenerWrapper access$400(DataLoaderHelper r100) {
        return r100.mListener;
    }

    private void asyncCopyOperation(AVMDLCopyOperation r100) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L10:
        r101.asyncCopyOperation(r100);     // Catch: Throwable -> L12
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L12:
        th = move-exception;
    L19:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L15:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L17;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L19
        goto L17
    }

    private void changeConfigWithPermission(AVMDLDataLoaderConfigure r100) {
        if (FeatureManager.hasPermission(FeatureManager.HTTP_DNS) == true) goto L6;
        r100.mEnableExternDNS = 0;
    L6:
        if (FeatureManager.hasPermission(FeatureManager.NATIVE_MDL) == true) goto L8;
    L10:
        StrategyManager.instance().mdlStart(r100);
        return;
    L8:
        if (InfoWrapper.getNativeMdlEnable() != 1) goto L10;
        this.mEnableMdlProtocol = true;
        goto L10
    }

    public static final String encodeUrlByQuery(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L17;
        TTVideoEngineLog.d("TTHelperEncode", "before encode:" + r100);
    L17:
        String r101 = AVMDLDataLoader.queryComponentEncode(r100);     // Catch: UnsupportedEncodingException -> L15
        if (TextUtils.isEmpty(r101) == false) goto L12;
        TTVideoEngineLog.d("TTHelperEncode", "call native encode fail,try java");     // Catch: UnsupportedEncodingException -> L15
        r101 = URLEncoder.encode(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L15
    L12:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L19;
        TTVideoEngineLog.d("TTHelperEncode", "after encode:" + r101);     // Catch: UnsupportedEncodingException -> L15
        return r101;
    L19:
        return r101;
    L15:
        return null;
    }

    private void notifyUrlChange(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        String[] r101 = r100.split(",");
        if (r101.length < 3) goto L33;
        String r102 = r101[0];
        int r103 = CastIntegerProtector.parseInt(r101[1]);     // Catch: Exception -> L10
    L15:
        String r104 = r101[2];
        ArrayList<WeakReference<TTVideoEngine>> r105 = _getEnginesByRawKey(r102);
        if (r105 != null) goto L36;
        TTVideoEngineLog.d(TAG, "notifyUrlChange weakReferences is null");
        return;
    L36:
        r104 = URLDecoder.decode(r104, "UTF-8");     // Catch: Exception -> L21
    L25:
        Iterator<WeakReference<TTVideoEngine>> r106 = r105.iterator();
    L27:
        if (r106.hasNext() == false) goto L45;
        WeakReference<TTVideoEngine> r107 = r106.next();
        if (r107 == null) goto L27;
        TTVideoEngine r108 = r107.get();
        if (r108 == null) goto L27;
        r108.playUrlChanged(r103, r104, r102);
        goto L27
    L45:
        return;
    L21:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L25;
        TTVideoEngineLog.e(TAG, "notifyUrlChange " + e);
    L10:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L14;
        TTVideoEngineLog.d(TAG, "notifyUrlChange " + e);
    L14:
        r103 = -1;
        goto L15
    }

    private void reportSpeed(AVMDLDataLoaderNotifyInfo r100) {
        if (this.mEnableReportSpeed != 0) goto L5;
        return;
    L5:
        long r101 = r100.code;
    }

    public String _getProxyUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (r100.startsWith(MDL_PREFIX) == true) goto L9;
        return r100;
    L9:
        int r101 = r100.indexOf("?");     // Catch: Exception -> L19
        if (r101 != (-1)) goto L12;
        return null;
    L12:
        String r102 = this.mInnerDataLoader.getLocalAddr();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return null;
    L15:
        StringBuffer r103 = new StringBuffer("http://");     // Catch: Exception -> L19
        r103.append(r102);     // Catch: Exception -> L19
        r103.append(r100.substring(r101));     // Catch: Exception -> L19
        String r104 = r103.toString();     // Catch: Exception -> L19
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L25;
        TTVideoEngineLog.e(TAG, "_proxyUrl: " + r104);     // Catch: Exception -> L19
    L25:
        return r104;
    L20:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L26;
        TTVideoEngineLog.e(TAG, "get proxy url failed: " + r100);
        return r100;
    L26:
        return r100;
    }

    public String _headerString(HashMap<String, String> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() < 1) goto L15;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.keySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        r101.append(r103);
        r101.append(": ");
        r101.append(r100.get(r103));
        r101.append("\r\n");
        goto L8
    L11:
        return r101.toString();
    L15:
        return null;
    }

    public void _removePlayTask(String r100) {
        this.mAllPlayTasks.popItem(r100);
    }

    public void addListener(DataLoaderListener2 r100) {
        this.mListener.addListener(r100);
    }

    public void addPreloadModelMedia(PreloadModelMedia r100) {
        if (FeatureManager.hasPermission("preload") == true) goto L6;
        return;
    L6:
        if (r100 == null) goto L20;
        IVideoModel r101 = r100.mVideoModel;
        if (r101 == null) goto L20;
        if (r100.mResolution == null) goto L20;
        if (TextUtils.isEmpty(r101.getVideoRefStr(2)) == false) goto L18;
        TTVideoEngineLog.e(TAG, "[preload] videoId invalid.");
        if (r100.getCallBackListener() == null) goto L26;
        PreLoaderItemCallBackInfo r102 = new PreLoaderItemCallBackInfo(3);
        r102.preloadError = new Error(Error.DataLoaderPreload, -100001);
        r100.getCallBackListener().preloadItemInfo(r102);
        return;
    L26:
        return;
    L18:
        _ml_addMedia(r100, r100.mSceneId);
        return;
    L20:
        TTVideoEngineLog.e(TAG, "[preload] addTask videoModel input invalid");
        if (r100 != null) goto L23;
        return;
    L23:
        if (r100.getCallBackListener() == null) goto L28;
        PreLoaderItemCallBackInfo r103 = new PreLoaderItemCallBackInfo(3);
        r103.preloadError = new Error(Error.DataLoaderPreload, -100001);
        r100.getCallBackListener().preloadItemInfo(r103);
        return;
    }

    public void addPriorityPreloadTask(PreloadModelMedia r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mediaOperateThread == null) goto L6;
        ArrayList<Object> r101 = new ArrayList();
        r101.add(this);
        r101.add(r100);
        this.mediaOperateThread.postMessage(r101, 115);
        return;
    L6:
        _doMl_addPriorityTask(r100);
    }

    public void addTask(PreloaderVideoModelItem r110) {
        if (r110 != null) goto L5;
    L126:
        TTVideoEngineLog.e(TAG, "[preload] addTask videoModel input invalid");
        if (r110 == null) goto L147;
        r110._notifyError(-100001);
        return;
    L147:
        return;
    L5:
        if (r110.mVideoModel == null) goto L126;
        if (r110.mResolution == null) goto L126;
        GearStrategyConfig r100 = TTVideoEngine.getGearStrategyConfig();
        int r101 = r110.mGearStrategyEnabled;
        String r102 = null;
        if (r101 == 3) goto L12;
    L16:
        if (r101 <= 0) goto L108;
        String r103 = r110.mVideoModel.toMediaInfoJsonString();
        if (TextUtils.isEmpty(r103) == true) goto L108;
        if (this.mEnableCheckPreloadUrls != 1) goto L36;
        IVideoModel r111 = r110.mVideoModel;
        if (r111 == null) goto L36;
        List<VideoInfo> r112 = r111.getVideoInfoList();
        if (r112 == null) goto L36;
        if (r112.isEmpty() == true) goto L36;
        Iterator<VideoInfo> r113 = r112.iterator();
    L29:
        if (r113.hasNext() == false) goto L36;
        String[] r114 = r113.next().getValueStrArr(16);
        int r115 = r114.length;
        int r116 = 0;
    L31:
        if (r116 >= r115) goto L29;
        if (_supportProxy(r114[r116]) == false) goto L34;
        r116 = r116 + 1;
        goto L31
    L34:
        return;
    L36:
        StrategyHelper.helper().getCenter().a(r103);
        HashMap r104 = new HashMap();
        GearStrategyContext r117 = new GearStrategyContext(null);
        if (r100 == null) goto L39;
        IGearStrategyListener r105 = r100.getGearStrategyListener();
    L41:
        if (1 != r110.mGearStrategyEnabled) goto L48;
        if (StrategyHelper.helper().isRunning() == true) goto L48;
        TTVideoEngineLog.w(TAG, "[GearStrategy] addTask strategy center not running");
        if (r105 == null) goto L108;
        r105.onBeforeSelect(r110.mVideoModel, r104, 2, r117.getUserData());
        r104.put("error_code", "-3");
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "strategy center not running");
        r105.onAfterSelect(r110.mVideoModel, r104, 2, r117.getUserData());
    L48:
        if (TTVideoEngine.getGearStrategyConfig() == null) goto L50;
        String r118 = TTVideoEngine.getGearStrategyConfig().getExtraConfig();
    L52:
        if (TextUtils.isEmpty(r118) == true) goto L54;
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG, r118);
    L54:
        r117.setVideoModel(r110.mVideoModel);
        if (2 != r110.mGearStrategyEnabled) goto L66;
        if (r105 == null) goto L58;
        r105.onBeforeSelect(r110.mVideoModel, r104, 2, r117.getUserData());
        Map<String, Integer> r106 = r105.selectBitrate(r110.mVideoModel, null, 2);
        if (r106 == null) goto L64;
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE, "" + r106.get("video"));
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE, "" + r106.get("audio"));
    L65:
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_SELECT_REASON, "13");
        r105.onAfterSelect(r110.mVideoModel, r104, 2, r117.getUserData());
    L67:
        if (r106 == null) goto L107;
        Integer r107 = r106.get("video");
        if (r107 == null) goto L71;
        int r108 = r107.intValue();
    L72:
        Integer r109 = r106.get("audio");
        if (r109 == null) goto L75;
        int r119 = r109.intValue();
    L77:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L79;
        TTVideoEngineLog.i(TAG, "[GearStrategy] gear strategy addTask mGearStrategyEnabled=" + r110.mGearStrategyEnabled + " videoBitrate=" + r108 + " audioBitrate=" + r119);
    L79:
        List<VideoInfo> r120 = r110.mVideoModel.getVideoInfoList();
        if (r108 <= 0) goto L103;
        if (r120 == null) goto L103;
        Iterator<VideoInfo> r121 = r120.iterator();
    L84:
        if (r121.hasNext() == false) goto L103;
        VideoInfo r122 = r121.next();
        if (r122 == null) goto L84;
        if (r122.getMediatype() == VideoRef.TYPE_AUDIO) goto L84;
        if (r122.getResolution() == null) goto L84;
        if (1 != EngineGlobalConfig.getInstance().getEnableUseRealBitrate()) goto L98;
        long r123 = r122.getValueInt(44);
        if (r123 > 0) goto L101;
        int r124 = r122.getValueInt(3);
    L99:
        r123 = r124;
    L101:
        if (r123 != r108) goto L84;
    L104:
        Map<Integer, String> r125 = TTVideoEngineHelper.paramsFromVideoInfo(r122);
        if (r122 == null) goto L108;
        r110.mResolution = r122.getResolution();
        r110.mParams = r125;
        goto L108
    L98:
        r124 = r122.getValueInt(3);
    L103:
        r122 = null;
        goto L104
    L75:
        r119 = 0;
        goto L77
    L71:
        r108 = 0;
        goto L72
    L107:
        TTVideoEngineLog.d(TAG, "[GearStrategy]add task result is null");
        goto L108
    L64:
        r104.put("error_code", OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT);
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "select result null");
        goto L65
    L58:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(5) == false) goto L60;
        TTVideoEngineLog.w(TAG, "[GearStrategy] add task select method callback but listener is null");
    L60:
        r106 = null;
        goto L67
    L66:
        r106 = StrategyHelper.helper().selectResolution(r110.mVideoModel, 2, r104, r117);
        goto L67
    L50:
        r118 = "";
        goto L52
    L39:
        r105 = null;
    L108:
        VideoInfo r126 = r110.mVideoModel.getVideoInfo(r110.mResolution, r110.mParams, true);
        if (r126 == null) goto L112;
        r102 = r126.getValueStr(15);
    L112:
        if (TextUtils.isEmpty(r102) == false) goto L115;
        TTVideoEngineLog.e(TAG, "[preload] key invalid.");
        r110._notifyError(-100001);
        return;
    L115:
        String r127 = r110.mVideoModel.getVideoRefStr(2);
        if (TextUtils.isEmpty(r127) == false) goto L119;
        TTVideoEngineLog.e(TAG, "[preload] videoId invalid.");
        r110._notifyError(-100001);
        return;
    L119:
        this.mLock.lock(ABLock.TYPE_READ);
        _addTask(r102, r127, r110.mPreloadSize, null, r110, null);     // Catch: Throwable -> L123
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L123:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L12:
        if (r110.mResolution != Resolution.Auto) goto L16;
        IVideoInfo r128 = GearStrategySC.selectBitrate(r110.mVideoModel, 2, r110.mGearStrategyExtraParams, null);
        if (r128 == null) goto L108;
        r110.mResolution = r128.getResolution();
        r110.mParams = TTVideoEngineHelper.paramsFromVideoInfo(r128);
        goto L108
    }

    public DataLoaderCacheFileInfo cacheFileInfo(String r100) {
        DataLoaderCacheInfo r101 = getCacheInfo(r100);
        if (r101 == null) goto L6;
        DataLoaderCacheFileInfo r102 = new DataLoaderCacheFileInfo(this);
        r102.mMediaSize = r101.mMediaSize;
        r102.mCacheSizeFromZero = r101.mCacheSizeFromZero;
        r102.mLocalFilePath = r101.mLocalFilePath;
        return r102;
    L6:
        return null;
    }

    public void cancelTask(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.mInnerDataLoader != null) goto L8;
    L44:
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L8:
        if (this.mState != 0) goto L44;
        this.mLock.lock(ABLock.TYPE_READ);
        DataLoaderTaskItem r101 = this.mPreloadTasks.popItem(r100);     // Catch: Throwable -> L34
        if (r101 == null) goto L14;
        _notifyPreloadCancel(r101);     // Catch: Throwable -> L34
    L31:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L39;
        TTVideoEngineLog.i(TAG, "[preload] cancel preload task. key = " + r100);     // Catch: Throwable -> L34
    L39:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        DataLoaderTaskItem r102 = this.mExecuteTasks.popItem(r100);     // Catch: Throwable -> L34
        if (r102 == null) goto L27;
        VideoInfoFetcher r103 = r102.mFetcher;     // Catch: Throwable -> L34
        if (r103 == null) goto L19;
        r103.cancel();     // Catch: Throwable -> L34
    L19:
        PreloaderURLItem r104 = r102.mURLItem;     // Catch: Throwable -> L34
        if (r104 == null) goto L26;
        CodecStrategyAdapter r105 = r104.mAdapter;     // Catch: Throwable -> L34
        if (r105 == null) goto L26;
        if (r105.isFetchSmartUrl() == false) goto L26;
        r102.mURLItem.mAdapter.cancelFetchSmartUrlInfo();     // Catch: Throwable -> L34
    L26:
        _notifyPreloadCancel(r102);     // Catch: Throwable -> L34
        goto L31
    L27:
        DataLoaderTaskItem r106 = this.mAllPreloadTasks.popItem(r100);     // Catch: Throwable -> L34
        if (r106 == null) goto L31;
        this.mInnerDataLoader.cancel(r100);     // Catch: Throwable -> L34
        _notifyPreloadCancel(r106);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
    L41:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L37:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L39;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L41
        goto L39
    }

    public void cancelTaskByFilePath(String r100) {
        cancelTask(TTHelper.keyFromFilePath(this.mContext, r100));
    }

    public void cancelTaskByVideoId(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return;
    L6:
        if (this.mInnerDataLoader != null) goto L8;
    L74:
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L8:
        if (this.mState != 0) goto L74;
        ArrayList r100 = new ArrayList();
        this.mLock.lock(ABLock.TYPE_READ);
        int r101 = 0;
    L60:
        th = move-exception;
    L71:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L63:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L65;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L71
    L65:
        this.mLock.unlock(ABLock.TYPE_READ);
        if (r100.size() > 0) goto L68;
        return;
    L68:
        if (r101 >= r100.size()) goto L105;
        cancelTask((String) ListProtector.get(r100, r101));
        r101 = r101 + 1;
        goto L68
    L105:
        return;
    L12:
        if (this.mPreloadTasks.count() <= 0) goto L28;
        ArrayList<DataLoaderTaskItem> r102 = this.mPreloadTasks.toArray();     // Catch: Throwable -> L60
        int r103 = 0;
    L15:
        if (r103 >= r102.size()) goto L28;
        DataLoaderTaskItem r104 = r102.get(r103);     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r104.mVideoId) == true) goto L26;
        if (r110.equals(r104.mVideoId) == false) goto L26;
        Iterator<DataLoaderTaskItem.TrackItem> r105 = r104.mTracks.iterator();     // Catch: Throwable -> L60
    L22:
        if (r105.hasNext() == false) goto L26;
        DataLoaderTaskItem.TrackItem r106 = r105.next();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r106.mTaskKey) == true) goto L22;
        r100.add(r106.mTaskKey);     // Catch: Throwable -> L60
    L26:
        r103 = r103 + 1;     // Catch: Throwable -> L60
    L28:
        if (this.mExecuteTasks.count() <= 0) goto L44;
        ArrayList<DataLoaderTaskItem> r107 = this.mExecuteTasks.toArray();     // Catch: Throwable -> L60
        int r108 = 0;
    L31:
        if (r108 >= r107.size()) goto L44;
        DataLoaderTaskItem r109 = r107.get(r108);     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r109.mVideoId) == true) goto L42;
        if (r110.equals(r109.mVideoId) == false) goto L42;
        Iterator<DataLoaderTaskItem.TrackItem> r111 = r109.mTracks.iterator();     // Catch: Throwable -> L60
    L38:
        if (r111.hasNext() == false) goto L42;
        DataLoaderTaskItem.TrackItem r112 = r111.next();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r112.mTaskKey) == true) goto L38;
        r100.add(r112.mTaskKey);     // Catch: Throwable -> L60
    L42:
        r108 = r108 + 1;     // Catch: Throwable -> L60
    L44:
        if (this.mAllPreloadTasks.count() <= 0) goto L65;
        ArrayList<DataLoaderTaskItem> r113 = this.mAllPreloadTasks.toArray();     // Catch: Throwable -> L60
        int r114 = 0;
    L46:
        if (r114 >= r113.size()) goto L65;
        DataLoaderTaskItem r115 = r113.get(r114);     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r115.mVideoId) == true) goto L59;
        if (r110.equals(r115.mVideoId) == false) goto L59;
        Iterator<DataLoaderTaskItem.TrackItem> r116 = r115.mTracks.iterator();     // Catch: Throwable -> L60
    L54:
        if (r116.hasNext() == false) goto L59;
        DataLoaderTaskItem.TrackItem r117 = r116.next();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r117.mTaskKey) == true) goto L54;
        r100.add(r117.mTaskKey);     // Catch: Throwable -> L60
    L59:
        r114 = r114 + 1;
        goto L46
    }

    public void checkLoaderType(int r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mConfigure.mLoaderType == r100) goto L19;
        int r101 = this.mBackupLoaderType;
        if (r101 == r100) goto L19;
        if (r101 <= 0) goto L21;
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L21:
        this.mInnerDataLoader.setIntValue(AVMDLDataLoader.KeyIsSetBackupLoaderType, r100);     // Catch: Throwable -> L12 Exception -> L14
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        TTVideoEngineLog.d(TAG, "set backup loader type failed");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L19:
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void cleanCacheDir(long r100) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        r101.cleanCacheDir(r100);     // Catch: Throwable -> L10
    L9:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void clearAllCaches(boolean r100) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L15
        if (r101 != null) goto L11;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L15
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        if (r100 == false) goto L13;
        r101.forceClearAllCaches();     // Catch: Throwable -> L15
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L13:
        r101.clearAllCaches();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void copyCache(final CopyCacheItem r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AVMDLCopyOperation r101 = new AVMDLCopyOperation(r100.mFileKey, r100.mDestPath, r100.mForceCopyUnfinished, r100.mWaitIfCaching, new AnonymousClass4(this, r100));
        r101.mCustomDir = r100.mCustomDir;
        asyncCopyOperation(r101);
    }

    public void createScene(PreloadScene r100) {
        StrategyHelper.helper().getCenter().k(r100.toJsonString());
    }

    public void destroyScene(String r100) {
        StrategyHelper.helper().getCenter().l(r100);
    }

    public void disableAutoTrim(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (this.mInnerDataLoader == null) goto L17;
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.makeFileAutoDeleteFlag(r100, 1);     // Catch: Throwable -> L11
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void doParseHosts(String[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length == 0) goto L9;
        this.mEnablePreParseHost = 1;
        this.mInnerDataLoader.doParseHosts(r100);
        return;
    }

    public void enableAutoTrim(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (this.mInnerDataLoader == null) goto L17;
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.makeFileAutoDeleteFlag(r100, 0);     // Catch: Throwable -> L11
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void forceRemoveCacheFile(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L20:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L22:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L8:
        if (this.mInnerDataLoader != null) goto L14;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L18
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L16;
        TTVideoEngineLog.i(TAG, " force remove mdl file. key " + r100);     // Catch: Throwable -> L18
    L16:
        this.mInnerDataLoader.forceRemoveFileCache(r100);     // Catch: Throwable -> L18
        goto L20
    }

    public JSONObject getCDNLog(String r100) {
        if (this.mState == 0) goto L5;
    L28:
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L28;
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L18 Exception -> L20
        if (r101 == null) goto L17;
        String r102 = r101.getCDNLog(r100);     // Catch: Throwable -> L18 Exception -> L20
        if (r102 == null) goto L17;
        JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L18 Exception -> L20
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L15;
        TTVideoEngineLog.d(TAG, "get cdn log suc" + r103.toString());     // Catch: Throwable -> L18 Exception -> L20
    L15:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r103;
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L18:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L20:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L17;
        TTVideoEngineLog.d(TAG, "get log exception" + e.toString());     // Catch: Throwable -> L18
        goto L17
    }

    public long getCacheFileSize(String r100) {
        return getCacheSize(r100);
    }

    public DataLoaderCacheInfo getCacheInfo(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
    L16:
        th = move-exception;
    L22:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L19:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == true) goto L20;
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L20:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L22
        goto L14
    L7:
        if (this.mInnerDataLoader == null) goto L14;
        if (this.mState != 0) goto L14;
        DataLoaderCacheInfo r101 = _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(r100));     // Catch: Throwable -> L16
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String r100) {
        this.mLock.lock(ABLock.TYPE_READ);
    L10:
        th = move-exception;
    L16:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L13:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == true) goto L14;
    L5:
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L14:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L16
        goto L5
    L4:
        if (this.mInnerDataLoader == null) goto L5;
        String r101 = TTHelper.keyFromFilePath(this.mContext, r100);     // Catch: Throwable -> L10
        DataLoaderCacheInfo r102 = _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(r101, r100));     // Catch: Throwable -> L10
        this.mLock.unlock(ABLock.TYPE_READ);
        return r102;
    }

    public long getCacheSize(String r100) {
        long r101 = 0;
        if (this.mState == 0) goto L5;
        return 0;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
    L8:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L10:
        long r103 = r102.getCacheSize(r100);     // Catch: Throwable -> L14
        if (r103 <= 0) goto L8;
        r101 = r103;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public long getCacheSizeByFilePath(String r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        long r101 = 0;
    L11:
        th = move-exception;
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L14:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == true) goto L15;
    L5:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L15:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L17
        goto L5
    L4:
        if (this.mInnerDataLoader == null) goto L5;
        String r102 = TTHelper.keyFromFilePath(this.mContext, r100);     // Catch: Throwable -> L11
        long r103 = this.mInnerDataLoader.getCacheSize(r102, r100);     // Catch: Throwable -> L11
        if (r103 <= 0) goto L5;
        r101 = r103;
        goto L5
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String r100) {
    L9:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L19;
        TTVideoEngineLog.d(e);
        return null;
    L19:
        return null;
    L4:
        if (this.mListener != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        return this.mListener.getCheckSumInfo(r100);
    L17:
        return null;
    }

    public long getDownloadCountByVid(String r100) {
        long r101 = -1;
        if (this.mState == 0) goto L5;
    L23:
        return -1;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L23;
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L12 Exception -> L14
        if (r102 == null) goto L11;
        r101 = r102.getDownloadCount(r100);     // Catch: Throwable -> L12 Exception -> L14
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L12:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L14:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L11;
        TTVideoEngineLog.d(TAG, "get download count failed:" + e.toString());     // Catch: Throwable -> L12
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v34, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    public int getIntValue(int r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        switch(r100) {
            case 1: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 12: goto L22;
            case 90: goto L21;
            case 100: goto L20;
            case 101: goto L19;
            case 103: goto L18;
            case 105: goto L17;
            case 114: goto L16;
            case 115: goto L15;
            case 1001: goto L14;
            case 1008: goto L13;
            case 1150: goto L12;
            case 9009: goto L11;
            case 9016: goto L10;
            case 9018: goto L9;
            case 9019: goto L8;
            case 9021: goto L7;
            case 9023: goto L6;
            case 80001: goto L5;
            default: goto L4;
        };
    L4:
        ?? r101 = -1;
    L30:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L5:
        r101 = this.mEnableCheckHLSProxyVVCtrl;     // Catch: Throwable -> L27
    L32:
        goto L30
    L6:
        r101 = this.mEnablePreloadAllTs;     // Catch: Throwable -> L27
        goto L32
    L7:
        r101 = this.mEnablePreloadFirstTs;     // Catch: Throwable -> L27
        goto L32
    L8:
        r101 = this.mEnableNotOnlyNotifyNetError;     // Catch: Throwable -> L27
        goto L32
    L9:
        r101 = this.mEnableNotifyError;     // Catch: Throwable -> L27
        goto L32
    L10:
        r101 = this.mEnableHLSProxy;     // Catch: Throwable -> L27
        goto L32
    L11:
        r101 = this.mSupportHls;     // Catch: Throwable -> L27
        goto L32
    L12:
        r101 = this.mConfigure.mEnableIOManager;     // Catch: Throwable -> L27
        goto L32
    L13:
        r101 = this.mCurrentAccessType;     // Catch: Throwable -> L27
        goto L32
    L14:
        r101 = this.mConfigure.mEnablePreconnect;     // Catch: Throwable -> L27
        goto L32
    L15:
        r101 = this.mEnableBackupIP;     // Catch: Throwable -> L27
        goto L32
    L16:
        r101 = this.mEnablePreParseHost;     // Catch: Throwable -> L27
        goto L32
    L17:
        r101 = AVMDLDNSParser.getIntValue(6);     // Catch: Throwable -> L27
        goto L32
    L18:
        r101 = AVMDLDNSParser.getIntValue(4);     // Catch: Throwable -> L27
        goto L32
    L19:
        r101 = this.mConfigure.mEnableSessionReuse;     // Catch: Throwable -> L27
        goto L32
    L20:
        r101 = this.mConfigure.mMaxTlsVersion;     // Catch: Throwable -> L27
        goto L32
    L21:
        r101 = this.mConfigure.mDNSMainType;     // Catch: Throwable -> L27
        goto L32
    L22:
        r101 = this.mMdlPreloadStrategy;     // Catch: Throwable -> L27
        goto L32
    L23:
        r101 = this.mConfigure.mEnableSocketReuse;     // Catch: Throwable -> L27
        goto L32
    L24:
        r101 = this.mConfigure.mEnableExternDNS;     // Catch: Throwable -> L27
        goto L32
    L25:
        r101 = this.mConfigure.mMaxCacheSize;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public long getIoWriteError(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -1;
    L6:
        if (this.mState == 0) goto L8;
        return -1;
    L8:
        this.mLock.lock();
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L19
        if (r101 != null) goto L14;
    L11:
        this.mLock.unlock();
        return -1;
    L14:
        long r102 = r101.getLongValueByStr(r100, 1013);     // Catch: Throwable -> L19
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L17;
        TTVideoEngineLog.d(TAG, "get io write error code = " + r102);     // Catch: Throwable -> L19
    L17:
        this.mLock.unlock();
        return r102;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public long getLongValue(int r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        long r101 = -1;
        if (r100 == 1003) goto L15;
        if (r100 != 1152) goto L7;
        long r102 = this.mConfigure.mMonitorTimeInternal;     // Catch: Throwable -> L19
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r102;
    L7:
        if (r100 == 1153) goto L10;
        this.mLock.unlock(ABLock.TYPE_READ);
        return -1;
    L10:
        r102 = this.mConfigure.mMonitorMinAllowLoadSize;     // Catch: Throwable -> L19
        goto L11
    L15:
        if (this.mEnableMdlProtocol == false) goto L17;
        r101 = this.mMdlProtocolHandle;     // Catch: Throwable -> L19
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L19:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public String getPlayLog(String r100) {
        String r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L12 Exception -> L14
        if (r102 == null) goto L11;
        r101 = r102.getStringValueByStr(r100, 1010);     // Catch: Throwable -> L12 Exception -> L14
        goto L11
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L12:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L14:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L11;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L12
        goto L11
    }

    public String getPreloadTraceId(String r100) {
        String r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L12 Exception -> L14
        if (r102 == null) goto L11;
        r101 = r102.getStringValueByStr(r100, 1012);     // Catch: Throwable -> L12 Exception -> L14
        goto L11
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L12:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L14:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L11;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L12
        goto L11
    }

    public String getStringValue(int r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (r100 != 0) goto L5;
        String r101 = this.mConfigure.mCacheDir;     // Catch: Throwable -> L23 Exception -> L25
    L12:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L5:
        if (r100 == 6) goto L16;
        if (r100 != 1509) goto L9;
        r101 = this.mConfigure.mCustomUA;     // Catch: Throwable -> L23 Exception -> L25
        goto L12
    L9:
        if (r100 == 9010) goto L11;
    L10:
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L11:
        r101 = this.mConfigure.mSocketTraingCenterConfigStr;     // Catch: Throwable -> L23 Exception -> L25
        goto L12
    L16:
        if (this.mVersionInfo != null) goto L20;
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L23 Exception -> L25
        if (r102 == null) goto L20;
        this.mVersionInfo = r102.getStringValue(11);     // Catch: Throwable -> L23 Exception -> L25
    L20:
        r101 = this.mVersionInfo;     // Catch: Throwable -> L23 Exception -> L25
    L23:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L25:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L10;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L23
        goto L10
    }

    public boolean isNotifyNetworkErrorCodes(int r100) {
        if (this.mNotifyNetErrors.contains(Integer.valueOf(r100)) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public void moveToScene(String r100) {
        StrategyHelper.helper().getCenter().M(r100);
    }

    public void notifyTriggerPreload(long r100) {
        DataLoaderListenerWrapper r101 = this.mListener;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onNotify(9, 0, r100, "");
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        JSONObject r100 = r210.jsonLog;
        if (r100 != null) goto L288;
    L13:
        int r101 = r210.what;
        boolean r102 = true;
        if (r101 != 10) goto L16;
        VideoEventEngineUploader r103 = this.mEngineUploader;
        if (r103 == null) goto L280;
        r103.onEvent(r210.logType, r210.jsonLog);
        return;
    L280:
        DataLoaderListenerWrapper r104 = this.mListener;
        if (r104 == null) goto L354;
        r104.onLogInfo(4, r210.logType, r210.jsonLog);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L355;
        TTVideoEngineLog.d(TAG, "live loader log msg: " + r210.logInfo);
        return;
    L355:
        return;
    L354:
        return;
    L16:
        if (r101 != 11) goto L18;
        VideoEventEngineUploader r105 = this.mEngineUploader;
        if (r105 == null) goto L273;
        r105.onEvent(r210.logType, r210.jsonLog);
        return;
    L273:
        DataLoaderListenerWrapper r106 = this.mListener;
        if (r106 == null) goto L352;
        r106.onLogInfo(5, r210.logType, r210.jsonLog);
        TTVideoEngineLog.d(TAG, "live loader log sample msg: " + r210.logInfo);
        return;
    L352:
        return;
    L18:
        if (r101 == 24) goto L264;
        if (r101 != 50) goto L22;
        return;
    L22:
        if (r101 != 70) goto L24;
        JSONObject r107 = _onHeartBeatFire(r210.jsonLog);
        r210.jsonLog = r107;
        VideoEventEngineUploader r108 = this.mEngineUploader;
        if (r108 == null) goto L252;
        r108.onEvent(r210.logType, r107);
        return;
    L252:
        DataLoaderListenerWrapper r109 = this.mListener;
        if (r109 == null) goto L256;
        r109.onLogInfo(3, r210.logType, r107);
    L256:
        if (this.mUploader == null) goto L261;
        if (this.mReportLogEnable == false) goto L261;
        this.mUploader.onUplaod(r210.logType, r210.jsonLog);
    L261:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L348;
        TTVideoEngineLog.d(TAG, "heart beat msg: " + r210.logInfo);
        return;
    L348:
        return;
    L24:
        if (r101 == 700) goto L223;
        if (r101 == 702) goto L216;
        if (r101 != 703) goto L30;
        return;
    L30:
        if (r101 == 901) goto L201;
        if (r101 == 902) goto L195;
        switch(r101) {
            case 0: goto L182;
            case 1: goto L170;
            case 2: goto L163;
            case 3: goto L151;
            case 4: goto L151;
            case 5: goto L147;
            case 6: goto L286;
            case 7: goto L292;
            case 8: goto L90;
            default: goto L35;
        };
    L35:
        switch(r101) {
            case 13: goto L85;
            case 14: goto L83;
            case 15: goto L73;
            case 16: goto L70;
            default: goto L36;
        };
    L36:
        switch(r101) {
            case 19: goto L63;
            case 20: goto L90;
            case 21: goto L61;
            case 22: goto L57;
            default: goto L37;
        };
    L37:
        switch(r101) {
            case 1000: goto L45;
            case 1001: goto L45;
            case 1002: goto L45;
            case 1003: goto L45;
            case 1004: goto L41;
            case 1005: goto L45;
            default: goto L39;
        };
    L41:
        VideoEventEngineUploader r110 = this.mEngineUploader;
        if (r110 == null) goto L295;
        r110.onEventV2(monitorName, r210.jsonLog);
        return;
    L295:
        return;
    L45:
        VideoEventEngineUploader r111 = this.mEngineUploader;
        if (r111 == null) goto L49;
        r111.onEvent(r210.logType, r210.jsonLog);
        return;
    L49:
        DataLoaderListenerWrapper r112 = this.mListener;
        if (r112 == null) goto L53;
        r112.onLogInfo(10, r210.logType, r210.jsonLog);
    L53:
        if (this.mUploader != null) goto L55;
        return;
    L55:
        if (this.mReportLogEnable == false) goto L297;
        this.mUploader.onUplaod(r210.logType, r210.jsonLog);
        return;
    L297:
        return;
    L39:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L293;
        TTVideoEngineLog.d(TAG, "NOT DEAL notify info what =  " + r210.what);
        return;
    L293:
        return;
    L57:
        String r113 = r210.logInfo;
        if (r113 == null) goto L299;
        Downloader.getInstance().downloadDidSuspened(r113);
        return;
    L299:
        return;
    L63:
        VideoEventEngineUploader r114 = this.mEngineUploader;
        if (r114 == null) goto L67;
        r114.onEvent(r210.logType, r210.jsonLog);
        return;
    L67:
        DataLoaderListenerWrapper r115 = this.mListener;
        if (r115 == null) goto L303;
        r115.onLogInfo(7, r210.logType, r210.jsonLog);
        return;
    L303:
        return;
    L61:
        if (r210.logInfo == null) goto L301;
        Downloader.getInstance().progress(r210.logInfo);
        return;
    L301:
        return;
    L70:
        DataLoaderListenerWrapper r116 = this.mListener;
        if (r116 == null) goto L305;
        r116.onLogInfo(0, r210.logType, r210.jsonLog);
        return;
    L305:
        return;
    L73:
        VideoEventEngineUploader r117 = this.mEngineUploader;
        if (r117 == null) goto L77;
        r117.onEvent(r210.logType, r210.jsonLog);
        return;
    L77:
        DataLoaderListenerWrapper r118 = this.mListener;
        if (r118 == null) goto L307;
        JSONObject r119 = r210.jsonLog;
        if (r119 == null) goto L308;
        r118.onLogInfoToMonitor(6, r210.logType, r119);
        return;
    L308:
        return;
    L307:
        return;
    L85:
        DataLoaderListenerWrapper r120 = this.mListener;
        if (r120 == null) goto L312;
        JSONObject r121 = r210.jsonLog;
        if (r121 == null) goto L313;
        r120.onLogInfo(0, r210.logType, r121);
        return;
    L313:
        return;
    L312:
        return;
    L83:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L310;
        TTVideoEngineLog.i(TAG, "MDL Alog: " + r210.logInfo);
        return;
    L310:
        return;
    L90:
        String r122 = r210.logInfo;
        if (r122 != null) goto L93;
    L96:
        if (r122 != null) goto L98;
        return;
    L98:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L100;
        TTVideoEngineLog.i(TAG, " task fail log = " + r210.logInfo + ", code = " + r210.code + ", task type = " + r210.parameter);
    L100:
        String[] r123 = r210.logInfo.split(",");
        if (r123.length >= 1) goto L103;
        return;
    L103:
        String r124 = r123[0];
        DataLoaderTaskItem r125 = this.mAllPreloadTasks.itemForKey(r124);
        if (r125 != null) goto L106;
        return;
    L106:
        DataLoaderTaskQueue r126 = this.mAllPreloadTasks;
        Error r127 = new Error(Error.DataLoaderPreload, (int) r210.code, r210.logInfo);
        if (TextUtils.isEmpty(r125.mVideoId) == false) goto L109;
        String r128 = r124;
    L110:
        DataLoaderTaskLoadProgress r129 = PreloadLoadProgressCenter.center().getLoadProgressByRawKey(r128);
        if (r129 != null) goto L113;
        r129 = new DataLoaderTaskLoadProgress(this);
    L113:
        r129.mVideoId = r125.mVideoId;
        r129.mTaskType = (int) r210.parameter;
        r129.setUp(r125);
        r129.onError(r124, r127);
        DataLoaderListenerWrapper r130 = this.mListener;
        if (r130 == null) goto L116;
        r130.onLoadProgress(r129);
    L116:
        PreloadLoadProgressCenter.center().putByRawKey(r128, r129);
        if (r129.isCacheEnd() == false) goto L119;
    L120:
        r126.popItem(r124);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L123;
        TTVideoEngineLog.i(TAG, "pop all task item. videoId = " + r125.mVideoId + " key = " + r124);
    L123:
        PreloadLoadProgressCenter.center().removeLoadProgressByRawKey(r128);
        if (this.mListener == null) goto L132;
        DataLoaderTaskProgressInfo r131 = new DataLoaderTaskProgressInfo(this);
        r131.mTaskType = (int) r210.parameter;
        r131.mVideoId = r125.mVideoId;
        r131.mKey = r124;
        PreloaderURLItem r132 = r125.mURLItem;
        if (r132 != null) goto L128;
    L130:
        this.mListener.onTaskProgress(r131);
        goto L132
    L128:
        if (r132.getFilePath() == null) goto L130;
        r131.mLocalFilePath = r125.mURLItem.getFilePath();
        r131.mKey = null;
    L132:
        if (r125.getCallBackListener() != null) goto L134;
        return;
    L134:
        if (r210.parameter != 2) goto L318;
        PreLoaderItemCallBackInfo r133 = new PreLoaderItemCallBackInfo(3);
        r133.preloadError = r127;
        r133.loadProgress = r129;
        r133.preloadDataInfo = null;
        r125.getCallBackListener().preloadItemInfo(r133);
        return;
    L318:
        return;
    L119:
        if (r129.isPreloadComplete() == true) goto L120;
        return;
    L109:
        r128 = r125.mVideoId;
        goto L110
    L93:
        if (r210.parameter != 3) goto L96;
        Downloader.getInstance().downloadFail(r122, _errorWithCode((int) r210.code, r210.parameter, r122));
        return;
    L147:
        DataLoaderListenerWrapper r134 = this.mListener;
        if (r134 == null) goto L323;
        r134.onNotify(20, r210.code, r210.parameter, r210.logInfo);
        return;
    L323:
        return;
    L163:
        StrategyHelper.helper().speedInfoUpdate();
        if (FeatureManager.hasPermission(FeatureManager.NET_SPEED) == true) goto L166;
        return;
    L166:
        DataLoaderListenerWrapper r135 = this.mListener;
        if (r135 == null) goto L169;
        r135.onNotify(2, r210.code, r210.parameter, r210.logInfo);
    L169:
        reportSpeed(r210);
        return;
    L170:
        VideoEventEngineUploader r136 = this.mEngineUploader;
        if (r136 == null) goto L174;
        r136.onEvent(r210.logType, r210.jsonLog);
        return;
    L174:
        DataLoaderListenerWrapper r137 = this.mListener;
        if (r137 == null) goto L178;
        r137.onLogInfo(1, r210.logType, r210.jsonLog);
    L178:
        if (this.mUploader != null) goto L180;
        return;
    L180:
        if (this.mReportLogEnable == false) goto L330;
        this.mUploader.onUplaod(r210.logType, r210.jsonLog);
        return;
    L330:
        return;
    L182:
        VideoEventEngineUploader r138 = this.mEngineUploader;
        if (r138 == null) goto L186;
        r138.onEvent(r210.logType, r210.jsonLog);
        return;
    L186:
        DataLoaderListenerWrapper r139 = this.mListener;
        if (r139 == null) goto L190;
        r139.onLogInfo(0, r210.logType, r210.jsonLog);
    L190:
        if (this.mUploader != null) goto L192;
        return;
    L192:
        if (this.mReportLogEnable == false) goto L333;
        this.mUploader.onUplaod(r210.logType, r210.jsonLog);
        return;
    L333:
        return;
    L286:
        JSONObject r140 = DataLoaderCDNLog.process(r210.jsonLog);     // Catch: Exception -> L145
        if (r140 == null) goto L320;
        DataLoaderListenerWrapper r141 = this.mListener;     // Catch: Exception -> L145
        if (r141 == null) goto L142;
        r141.onNotifyCDNLog(r140);     // Catch: Exception -> L145
    L142:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L321;
        TTVideoEngineLog.d("avmdlcdnlog", "receive log:" + r140);     // Catch: Exception -> L145
        return;
    L321:
        return;
    L320:
        return;
    L145:
        e = move-exception;
        e.printStackTrace();
        return;
    L292:
        return;
    L151:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L154;
        TTVideoEngineLog.d(TAG, "KeyIsFileCacheProgress log = " + r210.logInfo + ", task type = " + r210.parameter + " code = " + ((int) r210.code));
    L154:
        if (r210.logInfo == null) goto L325;
        long r142 = r210.parameter;
        if (r142 != 3) goto L159;
        Downloader.getInstance().progress(r210.logInfo);
        return;
    L159:
        if (r142 == 2) goto L162;
        r102 = false;
    L162:
        _progressInfoString(r210, r102);
        return;
    L325:
        return;
    L195:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L197;
        TTVideoEngineLog.d(TAG, "KeyIsFileDeleteSizeByUsedTime size: " + r210.code);
    L197:
        DataLoaderListenerWrapper r143 = this.mListener;
        if (r143 == null) goto L335;
        r143.onNotify(31, 0, r210.code, null);
        return;
    L335:
        return;
    L201:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L203;
        TTVideoEngineLog.d("multinetwork", String.format("target network:%d current network:%d", new Object[]{Long.valueOf(r210.parameter), Long.valueOf(r210.code)}));
    L203:
        String r144 = getNetworkName(r210.parameter);
        String r145 = getNetworkName(r210.code);
        if (TextUtils.isEmpty(r144) == false) goto L206;
        return;
    L206:
        if (TextUtils.isEmpty(r145) == false) goto L208;
        return;
    L208:
        if (this.mListener != null) goto L210;
        return;
    L210:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L212;
        TTVideoEngineLog.d("multinetwork", "do callback target: " + r144 + " current: " + r145);
    L212:
        this.mListener.onMultiNetworkSwitch(r144, r145);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L340;
        TTVideoEngineLog.d("multinetwork", "end do callback target: " + r144 + " current: " + r145);
        return;
    L340:
        return;
    L216:
        if (FeatureManager.hasPermission(FeatureManager.NET_SPEED) == true) goto L218;
        return;
    L218:
        TestSpeedListener r146 = this.mTestSpeedListener;
        if (r146 == null) goto L342;
        if (r146 == null) goto L343;
        r146.onNotify(2, r210.logInfo);
        return;
    L343:
        return;
    L342:
        return;
    L223:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L226;
        TTVideoEngineLog.d(TAG, "KeyIsSpeedTestSampledByTime  mNeedSpeedTestByTimeInternal:" + this.mNeedSpeedTestByTimeInternal + " code:" + r210.code);
    L226:
        if (FeatureManager.hasPermission(FeatureManager.NET_SPEED) == true) goto L228;
        return;
    L228:
        TestSpeedListener r147 = this.mTestSpeedListener;
        if (r147 == null) goto L231;
        r147.onNotify(2, r210.code, r210.parameter, r210.logInfo, r210.logType, r210.logExtraJsonStr);
    L231:
        int r148 = this.mNeedSpeedTestByTimeInternal;
        if (r148 == 1) goto L236;
        if (r148 == 2) goto L235;
        int r149 = -1;
    L238:
        if (this.mListener == null) goto L345;
        if (r149 != (-1)) goto L241;
        return;
    L241:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L247;
        StringBuilder r150 = new StringBuilder("KeyIsSpeedTestSampledByTimenotify by");
        if (r149 != 2) goto L245;
        String r151 = "general";
    L246:
        r150.append(r151);
        r150.append("speed info code:");
        r150.append(r210.code);
        r150.append(" parameter:");
        r150.append(r210.parameter);
        TTVideoEngineLog.d(TAG, r150.toString());
        goto L247
    L245:
        r151 = "timeinternal";
    L247:
        this.mListener.onNotify(r149, r210.code, r210.parameter, r210.logInfo);
        return;
    L345:
        return;
    L235:
        r149 = 32;
        goto L238
    L236:
        r149 = 2;
        goto L238
    L264:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L266;
        TTVideoEngineLog.d(TAG, "KeyIsTaskOpen " + r210.logInfo);
    L266:
        notifyUrlChange(r210.logInfo);
        DataLoaderListenerWrapper r152 = this.mListener;
        if (r152 == null) goto L350;
        r152.onNotify(30, 0, r210.parameter, r210.logInfo);
        return;
    L350:
        return;
    L288:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L8:
        if (r100.has("app_session_id") == true) goto L13;
        r210.jsonLog.put("app_session_id", VideoEventBase.appSessionId);     // Catch: JSONException -> L11
        goto L13
    }

    public void preConnect(String r100) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        this.mLock.lock(ABLock.TYPE_READ);
        Uri r101 = Uri.parse(r100);     // Catch: Throwable -> L19
        int r102 = r101.getPort();     // Catch: Throwable -> L19
        if (r102 == (-1)) goto L11;
    L14:
        AVMDLDataLoader r103 = this.mInnerDataLoader;     // Catch: Throwable -> L19
        if (r103 == null) goto L17;
        r103.preConnectByHost(r101.getHost(), r102);     // Catch: Throwable -> L19
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        if (r100.startsWith("https") == false) goto L13;
        r102 = UploadKeys.KeyIsGetVideoMeta;
        goto L14
    L13:
        r102 = 80;
    L19:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public long quickQueryCacheFileSize(String r100) {
        long r101 = 0;
        if (this.mState == 0) goto L5;
        return 0;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
    L8:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L10:
        long r103 = r102.quickQueryCacheSize(r100);     // Catch: Throwable -> L14
        if (r103 <= 0) goto L8;
        r101 = r103;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void removeCacheFile(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
    L18:
        th = move-exception;
    L25:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L21:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L23;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L25
    L23:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L8:
        if (this.mInnerDataLoader != null) goto L14;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L18
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L16;
        TTVideoEngineLog.i(TAG, "remove mdl file. key " + r100);     // Catch: Throwable -> L18
    L16:
        this.mInnerDataLoader.removeFileCache(r100);     // Catch: Throwable -> L18
        goto L23
    }

    public void removeDownloadFile(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
    L18:
        th = move-exception;
    L25:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L21:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L23;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L25
    L23:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L8:
        if (this.mInnerDataLoader != null) goto L14;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L18
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L16;
        TTVideoEngineLog.i(TAG, "remove mdl file, download key " + r100);     // Catch: Throwable -> L18
    L16:
        this.mInnerDataLoader.removeFileCache(r100);     // Catch: Throwable -> L18
        goto L23
    }

    public void removeListener(DataLoaderListener2 r100) {
        this.mListener.removeListener(r100);
    }

    public void removePriorityPreloadTask(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mediaOperateThread == null) goto L6;
        ArrayList<Object> r101 = new ArrayList();
        r101.add(this);
        r101.add(r100);
        this.mediaOperateThread.postMessage(r101, 116);
        return;
    L6:
        _doMl_removePriorityTask(r100);
    }

    public void resetPreloadTraceId(String r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L7
            return
        L7:
            com.ss.ttvideoengine.utils.ABLockWrapper r0 = r2.mLock
            int r1 = com.ss.ttvideoengine.utils.ABLock.TYPE_READ
            r0.lock(r1)
            com.ss.mediakit.medialoader.AVMDLDataLoader r0 = r2.mInnerDataLoader     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r0 == 0) goto L1d
            int r0 = r2.mState     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            if (r0 == 0) goto L17
            goto L1d
        L17:
            com.ss.mediakit.medialoader.AVMDLDataLoader r0 = r2.mInnerDataLoader     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r0.resetPreloadTraceId(r3)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            goto L32
        L1d:
            com.ss.ttvideoengine.utils.ABLockWrapper r3 = r2.mLock
            int r0 = com.ss.ttvideoengine.utils.ABLock.TYPE_READ
            r3.unlock(r0)
            return
        L25:
            r3 = move-exception
            goto L3a
        L27:
            r3 = move-exception
            r0 = 1
            boolean r0 = com.ss.ttvideoengine.utils.TTVideoEngineLog.isPredicateLoglevelTurnOn(r0)     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L32
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r3)     // Catch: java.lang.Throwable -> L25
        L32:
            com.ss.ttvideoengine.utils.ABLockWrapper r3 = r2.mLock
            int r0 = com.ss.ttvideoengine.utils.ABLock.TYPE_READ
            r3.unlock(r0)
            return
        L3a:
            com.ss.ttvideoengine.utils.ABLockWrapper r0 = r2.mLock
            int r1 = com.ss.ttvideoengine.utils.ABLock.TYPE_READ
            r0.unlock(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.DataLoaderHelper.resetPreloadTraceId(java.lang.String):void");
    }

    public void setClassLoader(ClassLoader r100) {
        if (r100 != null) goto L6;
        TTVideoEngineLog.d(TAG, "class loader null");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_WRITE);
    L14:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        throw th;
    L8:
        if (this.mClasssLoader != null) goto L10;
        this.mClasssLoader = r100;     // Catch: Throwable -> L14
    L10:
        this.mLock.unlock(ABLock.TYPE_WRITE);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L19;
        TTVideoEngineLog.d(TAG, "set class loader end" + r100);
        return;
    }

    public void setContext(Context r100) {
        if (r100 != null) goto L6;
        TTVideoEngineLog.d(TAG, "set context null");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_WRITE);
    L15:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        throw th;
    L8:
        if (this.mContext != null) goto L10;
        SettingsHelper.helper().setContext(r100);     // Catch: Throwable -> L15
        SettingsHelper.helper().loadMDLCache();     // Catch: Throwable -> L15
    L10:
        this.mContext = r100;     // Catch: Throwable -> L15
        this.mLock.unlock(ABLock.TYPE_WRITE);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L20;
        TTVideoEngineLog.d(TAG, "set context end" + r100);
        return;
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader r100) {
        monitor-enter(this);
        this.mEngineUploader = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setListener(DataLoaderListener r100) {
        this.mListener.setListener(r100);
    }

    public void setLoadProxy(LibraryLoaderProxy r100) {
        this.mLock.lock(ABLock.TYPE_WRITE);
        if (r100 != null) goto L11;
    L9:
        this.mLock.unlock(ABLock.TYPE_WRITE);
        return;
    L11:
        this.mProxy = r100;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        throw th;
    }

    public void setLoaderEventListener(LoaderListener r100) {
        this.mLock.lock(ABLock.TYPE_VOID);
        AVMDLDataLoader.getInstance().setEventListener(r100);     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_VOID);
        return;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_VOID);
        throw th;
    }

    public void setPreloadLogLevel(int r100) {
        if (r100 != 1) goto L6;
        r100 = 1;
    L6:
        if (r100 < 4) goto L8;
        r100 = 5;
    L8:
        StrategyHelper.helper().setLogLevel(r100);
    }

    public void setProtectCacheDirsAvoidClear(String[] r100) {
        TTVideoEngineLog.d(TAG, "set protect dirs avoid clear when use clear interface");
        this.mLock.lock(ABLock.TYPE_WRITE);
        this.mConfigure.setProtectCacheDirs(r100);     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_WRITE);
        return;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        throw th;
    }

    public void setReportLogEnable(boolean r100) {
        this.mLock.lock(ABLock.TYPE_VOID);
        this.mReportLogEnable = r100;     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_VOID);
        return;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_VOID);
        throw th;
    }

    public void setTaskEventListener(AVMDLTaskEventListener r100) {
        if (this.mInnerDataLoader != null) goto L6;
        TTVideoEngineLog.e(TAG, "need start mdl first");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_READ);
        this.mInnerDataLoader.setTaskEventListener(r100);
        this.mLock.unlock(ABLock.TYPE_READ);
    }

    public void setTestSpeedListener(TestSpeedListener r100) {
        this.mLock.lock(ABLock.TYPE_VOID);
        this.mTestSpeedListener = r100;     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_VOID);
        return;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_VOID);
        throw th;
    }

    public void setUploader(IVideoEventUploader r100) {
        this.mUploader = r100;
    }

    public boolean startDownload(String r100) {
        return startDownload(r100, false);
    }

    public void suspendedDownload(String r100) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L14
        if (r101 != null) goto L10;
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L10:
        r101.suspendDownload(r100);     // Catch: Throwable -> L14
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L19;
        TTVideoEngineLog.i(TAG, "[downloader] suspended download, key = " + r100);     // Catch: Throwable -> L14
    L19:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        th = move-exception;
    L21:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L17:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L19;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L21
        goto L19
    }

    public long tryQuickGetCacheFileSize(String r100) {
        long r101 = 0;
        if (this.mState == 0) goto L5;
        return 0;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
    L8:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r101;
    L10:
        long r103 = r102.tryQuickGetCacheSize(r100);     // Catch: Throwable -> L14
        if (r103 <= 0) goto L8;
        r101 = r103;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void tryToClearCachesByUsedTime(long r100) {
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r101 = this.mInnerDataLoader;     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L7:
        r101.tryToClearCachesByUsedTime(r100);     // Catch: Throwable -> L9
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L9:
        th = move-exception;
    L16:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L12:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L14;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L16
        goto L14
    }

    public void updateLockType(int r100) {
        this.mLock.updateLockType(r100);
    }

    public void addTask(PreloaderVidItem r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.mState == 0) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r110.mVideoId) == false) goto L11;
        TTVideoEngineLog.e(TAG, "videoId invalid.");
        return;
    L11:
        String r100 = r110.mVideoId + "_" + r110.mResolution.toString(0) + r110.mCodecType + r110.mDashEnable + r110.mHlsEnable + r110.mEncryptEnable;
        this.mLock.lock(ABLock.TYPE_READ);
        _addTask(r100, r110.mVideoId, r110.mPreloadSize, r110, null, null);     // Catch: Throwable -> L15
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L15:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void addTask(PreloaderURLItem r110) {
        if (r110 != null) goto L5;
        TTVideoEngineLog.e(TAG, "[preload] url item invalid");
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        _addTask(r110.getKey(), r110.getVideoId(), r110.getPreloadSize(), null, null, r110);     // Catch: Throwable -> L9
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L9:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    private String[] _addP2pFlag(boolean r100, String[] r101) {
        if (r100 == true) goto L4;
        return r101;
    L4:
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L11;
        if (TextUtils.isEmpty(r101[r102]) == true) goto L10;
        r101[r102] = TTHelper.appendQueryString(r101[r102], "p2p=0");
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        return r101;
    }

    private void _cacheEndNotifyEngine(DataLoaderTaskItem r100, String r101) {
        ArrayList<DataLoaderTaskItem> r102 = this.mAllPlayTasks.toArray();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102.size()) goto L13;
        DataLoaderTaskItem r105 = (DataLoaderTaskItem) ListProtector.get(r102, r104);
        if (TextUtils.isEmpty(r105.mVideoId) == true) goto L12;
        if (TextUtils.isEmpty(r100.mVideoId) == true) goto L12;
        if (r105.mVideoId.equals(r100.mVideoId) == false) goto L12;
        boolean r106 = false;
    L14:
        if (r106 == false) goto L26;
        this.mLock.lock(ABLock.TYPE_VOID);
        this.mPreloadUtil.notifyCacheEnd(r100.mVideoId);
        this.mLock.unlock(ABLock.TYPE_VOID);
        ArrayList<WeakReference<TTVideoEngine>> r107 = _getEnginesByRawKey(r100.mVideoId);
        if (r107 != null) goto L18;
        return;
    L18:
        if (r107.size() != 0) goto L21;
        return;
    L21:
        if (r103 >= r107.size()) goto L37;
        WeakReference r108 = (WeakReference) ListProtector.get(r107, r103);
        if (r108.get() == null) goto L25;
        ((TTVideoEngine) r108.get()).notifyCacheEnd();
    L25:
        r103 = r103 + 1;
        goto L21
    L37:
        return;
    L26:
        return;
    L12:
        r104 = r104 + 1;
        goto L4
    L13:
        r106 = true;
        goto L14
    }

    private void _doMl_addMedia(PreloadModelMedia r110, String r111) {
        if (r110 == null) goto L40;
        MyPreloadTaskCallbackListener r100 = null;
        if (r110.getSelectCallback() == null) goto L6;
        MySelectBitrateListener r101 = new MySelectBitrateListener(this, r110.getSelectCallback());
    L8:
        if (r110.getCallBackListener() == null) goto L10;
        r100 = new MyPreloadTaskCallbackListener(this, r110.getCallBackListener());
    L10:
        MyPreloadTaskCallbackListener r102 = r100;
        String r103 = r110.mVideoModel.toMediaInfoJsonString();
        if (r110.isNeedConvertStrategyInfo() == false) goto L15;
        String r104 = r110.toStrategyInfo();
        if (TextUtils.isEmpty(r104) == true) goto L15;
        String r105 = r104;
    L17:
        if (this.mEnableCheckPreloadUrls != 1) goto L33;
        IVideoModel r106 = r110.mVideoModel;
        if (r106 == null) goto L33;
        List<VideoInfo> r107 = r106.getVideoInfoList();
        if (r107 == null) goto L33;
        if (r107.isEmpty() == true) goto L33;
        Iterator<VideoInfo> r108 = r107.iterator();
    L26:
        if (r108.hasNext() == false) goto L33;
        String[] r109 = r108.next().getValueStrArr(16);
        int r112 = r109.length;
        int r113 = 0;
    L28:
        if (r113 >= r112) goto L26;
        if (_supportProxy(r109[r113]) == false) goto L31;
        r113 = r113 + 1;
        goto L28
    L31:
        return;
    L33:
        StrategyHelper.helper().getCenter().b(r105, r101, r102, r111, r110.isLast);
        return;
    L15:
        r105 = r103;
        goto L17
    L6:
        r101 = null;
        goto L8
    }

    private void _doMl_removeAllMedias(String r100, int r101) {
        StrategyHelper.helper().getCenter().v(r100, r101);
    }

    private void _doMl_removeMedia(String r100, String r101) {
        StrategyHelper.helper().getCenter().w(r100, r101);
    }

    private void _ml_addMedia(PreloadModelMedia r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mediaOperateThread == null) goto L6;
        ArrayList<Object> r102 = new ArrayList();
        r102.add(this);
        r102.add(r100);
        r102.add(r101);
        this.mediaOperateThread.postMessage(r102, 111);
        return;
    L6:
        _doMl_addMedia(r100, r101);
    }

    private void _ml_removeAllMedias(String r100, int r101) {
        if (this.mediaOperateThread == null) goto L5;
        ArrayList<Object> r102 = new ArrayList();
        r102.add(this);
        r102.add(r100);
        r102.add(Integer.valueOf(r101));
        this.mediaOperateThread.postMessage(r102, 113);
        return;
    L5:
        _doMl_removeAllMedias(r100, r101);
    }

    private void _ml_removeMedia(String r100, String r101) {
        if (this.mediaOperateThread == null) goto L5;
        ArrayList<Object> r102 = new ArrayList();
        r102.add(this);
        r102.add(r100);
        r102.add(r101);
        this.mediaOperateThread.postMessage(r102, 112);
        return;
    L5:
        _doMl_removeMedia(r100, r101);
    }

    private void _prepareUrlInfo(VideoInfo r110, DataLoaderTaskItem r111) {
        if (r110 == null) goto L64;
        if (r111 == null) goto L64;
        String[] r100 = r110.getValueStrArr(16);
        String r101 = r110.getValueStr(15);
        DataLoaderTaskItem.TrackItem r102 = r111.addTrackItemByKey(r101);
        if (r100 != null) goto L9;
    L62:
        TTVideoEngineLog.e(TAG, "[preload] url info, urls info invalid");
        r111._notifyError(-100001);
        return;
    L9:
        if (r100.length < 1) goto L62;
        String[] r103 = (String[]) r100.clone();
        PreloaderVidItem r104 = r111.mVidItem;
        if (r104 == null) goto L14;
        boolean r105 = r104.mForbidP2p;
    L18:
        String[] r106 = _addP2pFlag(r105, r103);
        PreloaderVidItem r107 = r111.mVidItem;
        String r108 = null;
        if (r107 != null) goto L21;
    L36:
        PreloaderVideoModelItem r109 = r111.mVideoModelItem;
        if (r109 != null) goto L39;
    L53:
        if (r102 != null) goto L55;
        r102 = r111.addTrackItemByKey(r101);
    L55:
        if (r102 != null) goto L58;
        r111._notifyError(-100001);
        return;
    L58:
        r102.mTaskKey = r101;
        r102.mVideoInfo = r110;
        r102.mDecryptionKey = r110.getValueStr(5);
        r102.mUsingResolution = r110.getResolution();
        r102.mUrls = r106;
        r102.mLocalFilePath = r108;
        r102.mExternalInfo = MDLExtraInfoHelper.createMDLExtraInfo(r110, r111);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L66;
        TTVideoEngineLog.d(TAG, "[preload] prepare url info. videoId = " + r111.mVideoId + ", key is " + r101 + ", resolution = " + r102.mUsingResolution.toString());
        return;
    L66:
        return;
    L39:
        if (r109.getFilePathListener() == null) goto L53;
        if (TextUtils.isEmpty(r101) == true) goto L53;
        String r112 = r111.mVideoModelItem.getFilePathListener().cacheFilePath(r111.mVideoId, r110);
        if (this.mDisableFilePathCheck == 0) goto L45;
    L35:
        r108 = r112;
        goto L53
    L45:
        if (TextUtils.isEmpty(r112) == true) goto L51;
        if (r112.contains(r101) == false) goto L51;
        r108 = r112;
    L51:
        if (TextUtils.isEmpty(r108) == true) goto L53;
        r101 = TTHelper.keyFromFilePath(this.mContext, r108);
        goto L53
    L21:
        if (r107.getFilePathListener() == null) goto L36;
        if (TextUtils.isEmpty(r101) == true) goto L36;
        r112 = r111.mVidItem.getFilePathListener().cacheFilePath(r111.mVideoId, r110);
        if (this.mDisableFilePathCheck != 0) goto L35;
        if (TextUtils.isEmpty(r112) == true) goto L33;
        if (r112.contains(r101) == false) goto L33;
        r108 = r112;
    L33:
        if (TextUtils.isEmpty(r108) == true) goto L53;
        r101 = TTHelper.keyFromFilePath(this.mContext, r108);
        goto L53
    L14:
        PreloaderVideoModelItem r113 = r111.mVideoModelItem;
        if (r113 == null) goto L17;
        r105 = r113.mForbidP2p;
        goto L18
    L17:
        r105 = false;
    L64:
        TTVideoEngineLog.e(TAG, "[preload] prepare url info fail. info or taskItem is null");
    }

    private void _progressInfoString(AVMDLDataLoaderNotifyInfo r210, boolean r211) {
        if (r210 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r210.logInfo) == true) goto L165;
        String[] r110 = r210.logInfo.split(",");
        if (r110.length >= 3) goto L150;
        return;
    L150:
        long r111 = CastLongProtector.valueOf(r110[0]).longValue();     // Catch: Exception -> L145
        long r112 = CastLongProtector.valueOf(r110[1]).longValue();     // Catch: Exception -> L145
        long r113 = 0;
        if (r112 <= 0) goto L15;
    L20:
        String r114 = r110[2];     // Catch: Exception -> L145
        if (r110.length >= 4) goto L23;
        String r100 = "";
    L26:
        if (r211 == false) goto L50;
        DataLoaderTaskItem r101 = this.mAllPreloadTasks.itemForKey(r114);     // Catch: Exception -> L145
        if (r101 == null) goto L30;
        long r115 = r111;
        String r116 = " task progress. cache end. key = ";
        DataLoaderTaskQueue r102 = this.mAllPreloadTasks;     // Catch: Exception -> L145
        DataLoaderTaskItem r103 = r101;
    L57:
        DataLoaderTaskItem.TrackItem r104 = r103.getTrackItem(r114);     // Catch: Exception -> L145
        if (r104 == null) goto L60;
        r104.mMediaSize = r112;     // Catch: Exception -> L145
        r104.mCacheSize = r115;     // Catch: Exception -> L145
        r104.mLocalFilePath = r100;     // Catch: Exception -> L145
    L60:
        if (r104 == null) goto L84;
        if (r211 == false) goto L84;
        String r212 = "[preload] notify vid cache end key: ";
        String r213 = "[preload] pop item return has other task num ";
        if (r104.mPreloadFooterSize <= 0) goto L87;
        if (r104.mIsFooterPreloaded == true) goto L87;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L71;
        TTVideoEngineLog.i(TAG, "[preload] preload footer" + r104.mPreloadFooterSize);     // Catch: Exception -> L145
    L71:
        long r105 = r104.mMediaSize;     // Catch: Exception -> L145
        long r106 = r104.mCacheSize;     // Catch: Exception -> L145
        if (r105 == r106) goto L87;
        long r107 = r104.mPreloadFooterSize;     // Catch: Exception -> L145
        if (r105 <= r107) goto L79;
        r113 = r105 - r107;     // Catch: Exception -> L145
    L79:
        if (r113 < r106) goto L82;
        r106 = r113;
    L82:
        r104.mIsFooterPreloaded = true;     // Catch: Exception -> L145
        r104.mPreloadOffset = r106;     // Catch: Exception -> L145
        r104.mPreSize = r107;     // Catch: Exception -> L145
        _startMDLPreloadTask(r103, r104);     // Catch: Exception -> L145
        return;
    L87:
        if (TextUtils.isEmpty(r103.mVideoId) == false) goto L89;
        String r108 = r114;
    L90:
        DataLoaderTaskLoadProgress r109 = PreloadLoadProgressCenter.center().getLoadProgressByRawKey(r108);     // Catch: Exception -> L145
        if (r109 != null) goto L93;
        r109 = new DataLoaderTaskLoadProgress(this);     // Catch: Exception -> L145
    L93:
        r109.mVideoId = r103.mVideoId;     // Catch: Exception -> L145
        if (r211 == false) goto L96;
        int r117 = 2;
    L97:
        r109.mTaskType = r117;     // Catch: Exception -> L145
        r109.setUp(r103);     // Catch: Exception -> L145
        if (r112 != r115) goto L109;
        if (r104 == null) goto L109;
        if (r104.mVideoInfo == null) goto L109;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L109;
        StringBuilder r118 = new StringBuilder("[preload] ");     // Catch: Exception -> L145
        if (r104.mVideoInfo.getMediatype() != VideoRef.TYPE_AUDIO) goto L107;
        String r119 = ServiceType.AUDIO;
    L108:
        r118.append(r119);     // Catch: Exception -> L145
        r118.append(" cache complete key: ");     // Catch: Exception -> L145
        r118.append(r114);     // Catch: Exception -> L145
        TTVideoEngineLog.i(TAG, r118.toString());     // Catch: Exception -> L145
        goto L109
    L107:
        r119 = "Video";
    L109:
        DataLoaderListenerWrapper r120 = this.mListener;     // Catch: Exception -> L145
        if (r120 == null) goto L112;
        r120.onLoadProgress(r109);     // Catch: Exception -> L145
    L112:
        PreloadLoadProgressCenter.center().putByRawKey(r108, r109);     // Catch: Exception -> L145
        if (r109.isCacheEnd() == true) goto L119;
        if (r211 == false) goto L118;
        if (r109.isPreloadComplete() == true) goto L119;
    L118:
        if (r210.what == 4) goto L119;
        return;
    L119:
        if (r211 == false) goto L126;
        DataLoaderTaskQueue r121 = r102;
        DataLoaderTaskItem r122 = r121.itemForKey(r114);     // Catch: Exception -> L145
        if (r122 == null) goto L127;
        r122.trackItemPreloadEnd(r114);     // Catch: Exception -> L145
        int r123 = r122.getNotEndTrackItemCount();     // Catch: Exception -> L145
        if (r123 <= 0) goto L127;
        TTVideoEngineLog.d(TAG, r213 + r123);     // Catch: Exception -> L145
        return;
    L127:
        r121.popItem(r114);     // Catch: Exception -> L145
        PreloadLoadProgressCenter.center().removeLoadProgressByRawKey(r108);     // Catch: Exception -> L145
        if (r211 == false) goto L130;
    L133:
        DataLoaderTaskProgressInfo r124 = new DataLoaderTaskProgressInfo(this);     // Catch: Exception -> L145
        r124.mCacheSizeFromZero = r115;     // Catch: Exception -> L145
        r124.mMediaSize = r112;     // Catch: Exception -> L145
        r124.mKey = r114;     // Catch: Exception -> L145
        r124.mLocalFilePath = r100;     // Catch: Exception -> L145
        r124.mResolution = r104.mUsingResolution;     // Catch: Exception -> L145
        r124.mDecryptionKey = r104.mDecryptionKey;     // Catch: Exception -> L145
        r124.mUsingVideoInfo = r104.mVideoInfo;     // Catch: Exception -> L145
        r124.mVideoId = r103.mVideoId;     // Catch: Exception -> L145
        r124.mTaskType = r109.mTaskType;     // Catch: Exception -> L145
        if (r103.getCallBackListener() == null) goto L139;
        if (r211 == false) goto L139;
        PreLoaderItemCallBackInfo r125 = new PreLoaderItemCallBackInfo(2);     // Catch: Exception -> L145
        r125.preloadDataInfo = r124;     // Catch: Exception -> L145
        r125.loadProgress = r109;     // Catch: Exception -> L145
        r103.getCallBackListener().preloadItemInfo(r125);     // Catch: Exception -> L145
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L139;
        TTVideoEngineLog.i(TAG, "[preload] notify end cache size = " + r109.getTotalCacheSize());     // Catch: Exception -> L145
    L139:
        DataLoaderListenerWrapper r126 = this.mListener;     // Catch: Exception -> L145
        if (r126 == null) goto L162;
        r126.onTaskProgress(r124);     // Catch: Exception -> L145
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L163;
        TTVideoEngineLog.i(TAG, r116 + r114 + ", rawKey = " + r108);     // Catch: Exception -> L145
        return;
    L163:
        return;
    L162:
        return;
    L130:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L132;
        TTVideoEngineLog.i(TAG, r212 + r108);     // Catch: Exception -> L145
    L132:
        _cacheEndNotifyEngine(r103, r114);     // Catch: Exception -> L145
        goto L133
    L126:
        r121 = r102;
        goto L127
    L96:
        r117 = 1;
        goto L97
    L89:
        r108 = r103.mVideoId;     // Catch: Exception -> L145
    L84:
        r212 = "[preload] notify vid cache end key: ";
        r213 = "[preload] pop item return has other task num ";
        goto L87
    L30:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L32;
        TTVideoEngineLog.i(TAG, "[preload] preload  not found task , temItem == null, loginfo: " + r210.logInfo);     // Catch: Exception -> L145
    L32:
        int r127 = r210.what;     // Catch: Exception -> L145
        if (r127 != 4) goto L40;
        DataLoaderTaskProgressInfo r128 = new DataLoaderTaskProgressInfo(this);     // Catch: Exception -> L145
        r128.mCacheSizeFromZero = r111;     // Catch: Exception -> L145
        r128.mMediaSize = r112;     // Catch: Exception -> L145
        r128.mKey = r114;     // Catch: Exception -> L145
        r128.mTaskType = 2;     // Catch: Exception -> L145
        r128.mLocalFilePath = r100;     // Catch: Exception -> L145
        DataLoaderListenerWrapper r129 = this.mListener;     // Catch: Exception -> L145
        if (r129 == null) goto L152;
        r129.onTaskProgress(r128);     // Catch: Exception -> L145
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L153;
        TTVideoEngineLog.i(TAG, " task progress. cache end. key = " + r114);     // Catch: Exception -> L145
        return;
    L153:
        return;
    L152:
        return;
    L40:
        if (this.mEnableCenterPreloadProgressCallback == 1) goto L42;
        return;
    L42:
        if (r127 != 3) goto L156;
        DataLoaderTaskLoadProgress r130 = new DataLoaderTaskLoadProgress(this);     // Catch: Exception -> L145
        r130.mTaskType = 2;     // Catch: Exception -> L145
        DataLoaderTaskItem r131 = new DataLoaderTaskItem();     // Catch: Exception -> L145
        r131.addTrackItemByKey(r114);     // Catch: Exception -> L145
        DataLoaderTaskItem.TrackItem r132 = r131.getTrackItem(r114);     // Catch: Exception -> L145
        if (r132 == null) goto L157;
        r132.mCacheSize = r111;     // Catch: Exception -> L145
        r132.mPreSize = r111;     // Catch: Exception -> L145
        r132.mMediaSize = r112;     // Catch: Exception -> L145
        r132.mLocalFilePath = r100;     // Catch: Exception -> L145
        r132.mTaskKey = r114;     // Catch: Exception -> L145
        r130.setUp(r131);     // Catch: Exception -> L145
        DataLoaderListenerWrapper r133 = this.mListener;     // Catch: Exception -> L145
        if (r133 == null) goto L158;
        r133.onLoadProgress(r130);     // Catch: Exception -> L145
        return;
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L50:
        r116 = " task progress. cache end. key = ";
        r115 = r111;
        DataLoaderTaskItem r134 = this.mAllPlayTasks.itemForKey(r114);     // Catch: Exception -> L145
        if (r134 == null) goto L53;
        r103 = r134;
        r102 = this.mAllPlayTasks;     // Catch: Exception -> L145
        goto L57
    L53:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L159;
        TTVideoEngineLog.i(TAG, "[preload] play temItem == null return " + r210.logInfo);     // Catch: Exception -> L145
        return;
    L159:
        return;
    L23:
        r100 = r110[3];     // Catch: Exception -> L145
        goto L26
    L15:
        if (r210.what == 4) goto L20;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L151;
        TTVideoEngineLog.i(TAG, "[preload] mediaSize <= 0 return " + r210.logInfo);     // Catch: Exception -> L145
        return;
    L151:
        return;
    L145:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L164;
        TTVideoEngineLog.d(e);
        return;
    L164:
        return;
    }

    private void _startMDLPreloadTask(DataLoaderTaskItem r310, DataLoaderTaskItem.TrackItem r311) {
        if (r310 == null) goto L108;
        if (r311 == null) goto L108;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L9;
        TTVideoEngineLog.i(TAG, "[preload] start mdl preload task.  key = " + r311.mTaskKey);
    L9:
        String r100 = r311.mCustomHeader;
        String r110 = r311.mTaskKey;
        PreloaderURLItem r101 = r310.mURLItem;
        if (r101 != null) goto L12;
    L39:
        String[] r102 = r311.mUrls;
        if (r102 == null) goto L106;
        PreloaderVidItem r103 = r310.mVidItem;
        if (r103 == null) goto L44;
        String r104 = r103.getFormatType();
    L51:
        boolean r105 = TTVideoEngineInterface.FORMAT_TYPE_HLS.equals(r104);
        IVideoModel r106 = r310.mResponseData;
        if (r106 == null) goto L55;
        r105 = r106.hasFormat(IVideoModel.Format.HLS);
    L55:
        if (r102.length > 0) goto L57;
    L61:
        boolean r210 = r105;
    L62:
        MDLExtraInfoHelper.addTags(r310, r311);
        PreloaderURLItem r107 = r310.mURLItem;
        if (r107 == null) goto L66;
        int r108 = r107.getUseOriginalUrlEncode();
    L65:
        int r211 = r108;
    L70:
        String r109 = preloadProxyQuery(r110, r310.mVideoId, r311.mPreloadOffset, 0, r102, r311.mLocalFilePath, r311.mExternalInfo, r310.mPriorityLevel, r100, r210, null, r310.mGroupId, r310.mPlayIndexGap, r211);
        StringBuffer r111 = new StringBuffer();
        r111.append(r109);
        r111.append("&header_size=");
        r111.append(r311.mPreloadHeaderSize);
        PreloaderVidItem r112 = r310.mVidItem;
        if (r112 == null) goto L74;
        long r113 = r112.getStartTimestamp();
    L82:
        if (r113 <= 0) goto L84;
        r111.append("&timestamp=");
        r111.append(r113);
    L84:
        String r114 = r111.toString();
        r311.mProxyUrl = r114;
        if (TextUtils.isEmpty(r114) == true) goto L105;
        this.mAllPreloadTasks.popItem(r110);
        this.mAllPreloadTasks.enqueueItem(r310);
        long r115 = r311.mPreloadOffset;
        if (r115 <= 0) goto L92;
        if (r115 >= (r311.mPreloadHeaderSize + WsConstants.DEFAULT_IO_LIMIT)) goto L92;
        r311.mPreSize += r115;
        r311.mPreloadOffset = 0;
    L92:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L94;
        String r116 = "[preload] preload offset " + r311.mPreloadOffset + " header size = " + r311.mPreloadHeaderSize + " preload size = " + r311.mPreSize;
        String r117 = TAG;
        TTVideoEngineLog.i(r117, r116);
    L96:
        if (r311.mPreloadOffset <= 0) goto L101;
        long r118 = r311.mPreloadHeaderSize;
        if (r118 <= 0) goto L100;
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r118);
    L100:
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r311.mPreloadOffset, r311.mPreSize);
    L103:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L111;
        TTVideoEngineLog.i(r117, String.format("[preload] exect preload task ,key is %s; videoId = %s", new Object[]{r311.mTaskKey, r310.mVideoId}));
        return;
    L111:
        return;
    L101:
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r311.mPreSize);
        goto L103
    L94:
        r117 = TAG;
        goto L96
    L105:
        r310._notifyError(-100001);
        return;
    L74:
        PreloaderVideoModelItem r119 = r310.mVideoModelItem;
        if (r119 == null) goto L77;
        r113 = r119.getStartTimestamp();
        goto L82
    L77:
        PreloaderURLItem r120 = r310.mURLItem;
        if (r120 == null) goto L80;
        r113 = r120.getStartTimestamp();
        goto L82
    L80:
        r113 = 0;
        goto L82
    L66:
        PreloaderVideoModelItem r121 = r310.mVideoModelItem;
        if (r121 == null) goto L69;
        r108 = r121.getUseOriginalUrlEncode();
        goto L65
    L69:
        r211 = -1;
        goto L70
    L57:
        if (TextUtils.isEmpty(r102[0]) == true) goto L61;
        if (FormatProvider.FormatProviderHolder.isM3u8(r102[0]) == false) goto L61;
        r210 = true;
        goto L62
    L44:
        PreloaderVideoModelItem r122 = r310.mVideoModelItem;
        if (r122 == null) goto L47;
        r104 = r122.getFormatType();
        goto L51
    L47:
        PreloaderURLItem r123 = r310.mURLItem;
        if (r123 == null) goto L50;
        r104 = r123.getFormatType();
        goto L51
    L50:
        r104 = null;
        goto L51
    L106:
        r310._notifyError(-100001);
        return;
    L12:
        if (r101.getProvider() == null) goto L39;
        String r124 = proxyQueryProvideMode(r110, r310.mVideoId, r310.mPriorityLevel, 1, r310.mGroupId);
        StringBuffer r125 = new StringBuffer();
        r125.append(r124);
        r125.append("&header_size=");
        r125.append(r311.mPreloadHeaderSize);
        r125.append("&timestamp=");
        r125.append(r310.mURLItem.getStartTimestamp());
        if (r310.mURLItem.getUseOriginalUrlEncode() <= 0) goto L16;
        r125.append("&use_ori_en=1");
    L16:
        String r126 = r125.toString();
        r311.mProxyUrl = r126;
        if (TextUtils.isEmpty(r126) == true) goto L34;
        this.mAllPreloadTasks.popItem(r110);
        this.mAllPreloadTasks.enqueueItem(r310);
        long r127 = r311.mPreloadOffset;
        if (r127 <= 0) goto L24;
        if (r127 >= (r311.mPreloadHeaderSize + WsConstants.DEFAULT_IO_LIMIT)) goto L24;
        r311.mPreSize += r127;
        r311.mPreloadOffset = 0;
    L24:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L26;
        String r128 = "[preload] preload offset " + r311.mPreloadOffset + " header size = " + r311.mPreloadHeaderSize + " preload size = " + r311.mPreSize;
        String r129 = TAG;
        TTVideoEngineLog.i(r129, r128);
    L28:
        if (r311.mPreloadOffset <= 0) goto L33;
        long r130 = r311.mPreloadHeaderSize;
        if (r130 <= 0) goto L32;
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r130);
    L32:
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r311.mPreloadOffset, r311.mPreSize);
    L36:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L110;
        TTVideoEngineLog.i(r129, String.format("[preload] exect preload task by provider mode, key is %s; videoId = %s proxyurl:%s", new Object[]{r110, r310.mVideoId, r311.mProxyUrl}));
    L110:
        return;
    L33:
        this.mInnerDataLoader.preloadResource(r311.mProxyUrl, r311.mPreSize);
        goto L36
    L26:
        r129 = TAG;
        goto L28
    L34:
        r129 = TAG;
        r310._notifyError(-100001);
    L108:
        TTVideoEngineLog.e(TAG, "[preload] start mdl preload task fail. track is null");
    }

    private boolean _supportProxy(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String r102 = r100.toLowerCase();
        if (r102.startsWith(MDL_PREFIX) == false) goto L9;
        return false;
    L9:
        if (r102.startsWith("http://127.0.0.1") == false) goto L11;
    L43:
        return false;
    L11:
        if (r102.startsWith("http://localhost") == true) goto L43;
        if (r102.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L43;
        if (r102.startsWith(HTTP.URL_DEFAULT) == true) goto L43;
        if (FormatProvider.FormatProviderHolder.isMpd(r100) == false) goto L22;
        return false;
    L22:
        if (this.mEnableHLSProxy != 1) goto L28;
        int r103 = this.mEnableCheckHLSProxyVVCtrl;
        if (r103 == 0) goto L27;
        if (r103 != 1) goto L28;
        if (r101 != 1) goto L28;
    L27:
        boolean r104 = true;
    L30:
        if (this.mEnableHls == 1) goto L32;
    L37:
        boolean r105 = false;
    L38:
        if (r105 == false) goto L40;
    L42:
        return true;
    L40:
        if (FormatProvider.FormatProviderHolder.isM3u8(r100) == false) goto L42;
        return false;
    L32:
        if (this.mSupportHls == true) goto L36;
        if (r104 == false) goto L37;
        if (this.mHLSProxyValid == false) goto L37;
    L36:
        r105 = true;
    L28:
        r104 = false;
        goto L30
    }

    public static /* synthetic */ void access$1100(DataLoaderHelper r100, PreloadModelMedia r101) {
        r100._doMl_addPriorityTask(r101);
    }

    public static /* synthetic */ void access$1200(DataLoaderHelper r100, String r101) {
        r100._doMl_removePriorityTask(r101);
    }

    public static /* synthetic */ int access$602(DataLoaderHelper r100, int r101) {
        r100.mCurrentAccessType = r101;
        return r101;
    }

    public static /* synthetic */ void access$700(DataLoaderHelper r100, DataLoaderTaskItem r101) {
        r100._exectTask(r101);
    }

    public void _addEngine(TTVideoEngine r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r100 == null) goto L22;
        this.mEngineLock.lock();     // Catch: Throwable -> L16
        ArrayList<WeakReference<TTVideoEngine>> r102 = this.mAllUsingEngies.get(r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L9;
        r102 = new ArrayList();     // Catch: Throwable -> L16
        this.mAllUsingEngies.put(r101, r102);     // Catch: Throwable -> L16
    L9:
        ValueWeakReference r103 = new ValueWeakReference(r100);     // Catch: Throwable -> L16
        if (r102.contains(r103) == true) goto L14;
        r102.add(r103);     // Catch: Throwable -> L16
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L14;
        TTVideoEngineLog.i(TAG, "add engine ref,rawKey = " + r101 + " engine ref count: " + r102.size());     // Catch: Throwable -> L16
    L14:
        this.mEngineLock.unlock();
        return;
    L16:
        th = move-exception;
        this.mEngineLock.unlock();
        throw th;
    L22:
        return;
    }

    public void _removeEngine(TTVideoEngine r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L23;
        if (r100 == null) goto L26;
        this.mEngineLock.lock();     // Catch: Throwable -> L20
        ArrayList<WeakReference<TTVideoEngine>> r102 = this.mAllUsingEngies.get(r101);     // Catch: Throwable -> L20
        if (r102 == null) goto L18;
        r102.remove(new ValueWeakReference(r100));     // Catch: Throwable -> L20
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L12;
        TTVideoEngineLog.i(TAG, "remove engine ref,rawKey = " + r101 + " engine ref count: " + r102.size());     // Catch: Throwable -> L20
    L12:
        if (r102.size() != 0) goto L18;
        this.mAllUsingEngies.remove(r101);     // Catch: Throwable -> L20
        PreloadUtil r103 = this.mPreloadUtil;     // Catch: Throwable -> L20
        if (r103.mPlayBufferLowerBound <= 0) goto L18;
        if (r103.mPlayBufferUpperBound <= 0) goto L18;
        r103.removePlayInfo(r101);     // Catch: Throwable -> L20
    L18:
        this.mEngineLock.unlock();
        return;
    L20:
        th = move-exception;
        this.mEngineLock.unlock();
        throw th;
    L26:
        return;
    }

    public void addPreloadMedias(List<PreloadMedia> r100, String r101) {
        if (FeatureManager.hasPermission("preload") == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r101 != null) goto L10;
        r101 = PreloadConfig.share().getCurrentSceneId();
    L10:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L12;
        TTVideoEngineLog.i(TAG, "[preload] add preload  mediaList ,size = " + r100.size() + "sceneId = " + r101);
    L12:
        int r102 = 0;
    L14:
        if (r102 >= r100.size()) goto L25;
        PreloadMedia r103 = (PreloadMedia) ListProtector.get(r100, r102);
        r103.mSceneId = r101;
        if ((r103 instanceof PreloadURLMedia) == false) goto L19;
        addPreloadUrlMedia((PreloadURLMedia) r103);
    L24:
        r102 = r102 + 1;
        goto L14
    L19:
        if ((r103 instanceof PreloadModelMedia) == false) goto L24;
        if (r102 != (r100.size() - 1)) goto L23;
        ((PreloadModelMedia) r103).isLast = true;
    L23:
        addPreloadModelMedia((PreloadModelMedia) r103);
        goto L24
    }

    public void addTask(String r110, PreloaderVidItem r111) {
        if (this.mState == 0) goto L6;
        return;
    L6:
        if (r111 != null) goto L8;
    L20:
        TTVideoEngineLog.e(TAG, "videoId invalid.");
        return;
    L8:
        if (TextUtils.isEmpty(r111.mVideoId) == true) goto L20;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L13;
        TTVideoEngineLog.i(TAG, String.format("addTask key is %s; videoId = %s", new Object[]{r110, r111.mVideoId}));
    L13:
        this.mLock.lock(ABLock.TYPE_READ);
        _addTask(r110, r111.mVideoId, r111.mPreloadSize, r111, null, null);     // Catch: Throwable -> L17
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void cleanSpecifiedCacheDir(String r100, int r101) {
        if (this.mState == 0) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        TTVideoEngineLog.e(TAG, "mInnerDataLoader == null");     // Catch: Throwable -> L13
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L11:
        r102.cleanSpecifiedCacheDir(r100, r101);     // Catch: Throwable -> L13
    L15:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void focusMedia(String r100, int r101) {
        if (this.mediaOperateThread == null) goto L5;
        ArrayList<Object> r102 = new ArrayList();
        r102.add(this);
        r102.add(r100);
        r102.add(Integer.valueOf(r101));
        this.mediaOperateThread.postMessage(r102, 114);
        return;
    L5:
        StrategyHelper.helper().getCenter().m(r100, r101);
    }

    public String generateSubUrlKey(String r100, String r101) {
        return AVMDLDataLoader.makeTsFileKey(r100, r101);
    }

    public DataLoaderCacheInfo getOfflineCacheInfo(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
    L16:
        th = move-exception;
    L22:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L19:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == true) goto L20;
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L20:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L22
        goto L14
    L7:
        if (this.mInnerDataLoader == null) goto L14;
        if (this.mState != 0) goto L14;
        DataLoaderCacheInfo r102 = _processCacheInfo(this.mInnerDataLoader.getOfflineCacheInfo(r100, r101));     // Catch: Throwable -> L16
        this.mLock.unlock(ABLock.TYPE_READ);
        return r102;
    }

    public void notifyPreloadCancelled(String r100, String r101) {
        DataLoaderListenerWrapper r102 = this.mListener;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.onNotify(8, 0, 0, r100);
    }

    @Override // com.ss.ttvideoengine.portrait.PortraitChangeListener
    public void onPortraitChange(String r100, Object r101) {
        if (this.mInnerDataLoader != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put(r100, r101);     // Catch: JSONException -> L8
        String r103 = r102.toString();     // Catch: JSONException -> L8
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        return;
    L16:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L18;
        TTVideoEngineLog.d(TAG, "onPortraitChange enginePortait: " + r103);
    L18:
        this.mInnerDataLoader.setStringValue(AVMDLDataLoader.KeyIsEnginePortraitUpdateStr, r103);
        return;
    L8:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L12;
        TTVideoEngineLog.d(e);
    L12:
        r103 = "";
        goto L14
    }

    public String proxyUrl(String r100, String r101) {
        return proxyUrl(r100, r100, new String[]{r101}, null, null);
    }

    public void removeAllPreloadMedia(String r100, int r101) {
        _ml_removeAllMedias(r100, r101);
    }

    public void removeMedia(String r100, String r101) {
        _ml_removeMedia(r100, r101);
    }

    public void setBackUpIP(String r100, String r101) {
        AVMDLDNSParser.getInstance().setBackUpIP(r100, r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.mEnableBackupIP = 1;
        return;
    }

    public void setCacheInfoLists(String[] r100, long[] r101) {
        TTVideoEngineLog.d(TAG, "setcustom paths and maxcaches ");
        this.mLock.lock(ABLock.TYPE_WRITE);
        this.mConfigure.setCacheInfoList(r100, r101);     // Catch: Throwable -> L6
        this.mLock.unlock(ABLock.TYPE_WRITE);
        return;
    L6:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_WRITE);
        throw th;
    }

    public void setIntValue(int r110, int r111) {
        this.mLock.lock(ABLock.TYPE_READ);
        boolean r100 = true;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L331;
        TTVideoEngineLog.d(TAG, "setIntValue key = " + r110 + ", value = " + r111);
    L331:
        if (r110 != 1) goto L7;
        this.mConfigure.mMaxCacheSize = r111;     // Catch: Throwable -> L323 Exception -> L325
    L322:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L7:
        if (r110 != 2) goto L9;
        this.mConfigure.mRWTimeOut = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L9:
        if (r110 != 3) goto L11;
        this.mConfigure.mOpenTimeOut = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L11:
        if (r110 != 4) goto L13;
        this.mConfigure.mTryCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L13:
        if (r110 != 5) goto L15;
        this.mConfigure.mLoaderType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L15:
        if (r110 != 7) goto L17;
        this.mConfigure.mEnableExternDNS = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L17:
        if (r110 != 8) goto L19;
        this.mConfigure.mEnableSocketReuse = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L19:
        if (r110 != 9) goto L21;
        this.mConfigure.mSocketIdleTimeOut = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L21:
        if (r110 != 55) goto L23;
        this.mConfigure.mMaxCacheAge = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L23:
        if (r110 != 56) goto L25;
        this.mConfigure.mEnableMaxCacheAgeForAllDir = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L25:
        if (r110 != 60) goto L27;
        this.mConfigure.mEnablePreloadReUse = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L27:
        if (r110 != 61) goto L29;
        this.mHeartBeatInterval = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L29:
        if (r110 != 100) goto L31;
        this.mConfigure.mMaxTlsVersion = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L31:
        if (r110 == 101) goto L308;
        switch(r110) {
            case 11: goto L305;
            case 12: goto L299;
            case 13: goto L298;
            case 14: goto L297;
            case 15: goto L296;
            default: goto L34;
        };
    L296:
        this.mNeedDLLoadP2PLib = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L297:
        this.mConfigure.mTestSpeedTypeVersion = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L298:
        this.mConfigure.mCheckSumLevel = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L299:
        if (r111 < 100) goto L301;
        AVMDLDataLoaderConfigure r112 = this.mConfigure;     // Catch: Throwable -> L323 Exception -> L325
        this.mMdlOldPreloadStrategy = r112.mPreloadStrategy;     // Catch: Throwable -> L323 Exception -> L325
        r112.mPreloadStrategy = 100;     // Catch: Throwable -> L323 Exception -> L325
    L302:
        this.mMdlPreloadStrategy = r111;     // Catch: Throwable -> L323 Exception -> L325
        if (r111 != 200) goto L322;
        this.mConfigure.mEnableIOManager = 1;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L301:
        AVMDLDataLoaderConfigure r113 = this.mConfigure;     // Catch: Throwable -> L323 Exception -> L325
        this.mMdlOldPreloadStrategy = r113.mPreloadStrategy;     // Catch: Throwable -> L323 Exception -> L325
        r113.mPreloadStrategy = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L302
    L305:
        this.mConfigure.mPreloadParallelNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDataLoader r114 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r114 == null) goto L322;
        r114.setIntValue(102, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L34:
        switch(r110) {
            case 17: goto L293;
            case 18: goto L291;
            case 19: goto L290;
            case 20: goto L289;
            case 21: goto L288;
            case 22: goto L287;
            case 23: goto L286;
            case 24: goto L285;
            case 25: goto L284;
            case 50: goto L283;
            case 80: goto L282;
            case 103: goto L281;
            case 104: goto L280;
            case 105: goto L279;
            case 106: goto L278;
            case 112: goto L277;
            case 113: goto L274;
            case 119: goto L273;
            case 121: goto L272;
            case 123: goto L270;
            case 200: goto L269;
            case 500: goto L268;
            case 501: goto L267;
            case 502: goto L266;
            case 505: goto L265;
            case 506: goto L264;
            case 507: goto L263;
            case 508: goto L262;
            case 509: goto L261;
            case 510: goto L260;
            case 511: goto L259;
            case 512: goto L256;
            case 513: goto L255;
            case 1000: goto L251;
            case 1001: goto L249;
            case 1002: goto L248;
            case 1004: goto L242;
            case 1005: goto L236;
            case 1006: goto L235;
            case 1007: goto L234;
            case 1009: goto L233;
            case 1010: goto L232;
            case 1011: goto L231;
            case 1012: goto L230;
            case 1013: goto L226;
            case 1100: goto L225;
            case 1101: goto L224;
            case 1102: goto L223;
            case 1103: goto L222;
            case 1104: goto L219;
            case 1105: goto L218;
            case 1108: goto L217;
            case 1109: goto L214;
            case 1110: goto L213;
            case 1111: goto L212;
            case 1112: goto L211;
            case 1113: goto L207;
            case 1115: goto L206;
            case 1116: goto L205;
            case 1117: goto L204;
            case 1118: goto L203;
            case 1119: goto L202;
            case 1120: goto L201;
            case 1121: goto L200;
            case 1122: goto L199;
            case 1123: goto L198;
            case 1124: goto L197;
            case 1125: goto L196;
            case 1126: goto L195;
            case 1127: goto L194;
            case 1128: goto L193;
            case 1129: goto L192;
            case 1130: goto L191;
            case 1131: goto L190;
            case 1132: goto L189;
            case 1133: goto L188;
            case 1134: goto L187;
            case 1135: goto L186;
            case 1136: goto L185;
            case 1137: goto L184;
            case 1138: goto L183;
            case 1139: goto L182;
            case 1140: goto L181;
            case 1141: goto L180;
            case 1143: goto L179;
            case 1145: goto L178;
            case 1146: goto L177;
            case 1147: goto L176;
            case 1148: goto L175;
            case 1150: goto L173;
            case 1151: goto L171;
            case 1154: goto L170;
            case 1155: goto L169;
            case 1156: goto L167;
            case 1157: goto L165;
            case 1158: goto L164;
            case 1159: goto L163;
            case 1160: goto L161;
            case 1161: goto L159;
            case 1162: goto L157;
            case 1163: goto L156;
            case 1164: goto L155;
            case 1166: goto L154;
            case 1167: goto L153;
            case 1168: goto L152;
            case 1169: goto L151;
            case 1170: goto L150;
            case 1171: goto L148;
            case 1172: goto L146;
            case 1501: goto L145;
            case 1503: goto L144;
            case 1504: goto L143;
            case 1505: goto L142;
            case 1513: goto L141;
            case 1514: goto L140;
            case 1701: goto L139;
            case 2000: goto L138;
            case 2001: goto L137;
            case 2002: goto L136;
            case 2003: goto L135;
            case 2004: goto L134;
            case 2005: goto L133;
            case 2006: goto L132;
            case 2008: goto L130;
            case 2009: goto L128;
            case 2010: goto L126;
            case 2011: goto L124;
            case 2012: goto L122;
            case 2013: goto L121;
            case 2014: goto L120;
            case 2015: goto L118;
            case 2016: goto L116;
            case 2017: goto L115;
            case 2018: goto L113;
            case 2019: goto L111;
            case 2020: goto L100;
            case 2021: goto L100;
            case 2022: goto L98;
            case 2023: goto L96;
            case 2024: goto L94;
            case 2025: goto L93;
            case 2026: goto L92;
            case 2027: goto L91;
            case 2028: goto L90;
            case 2031: goto L89;
            case 2032: goto L88;
            case 2033: goto L87;
            case 2034: goto L86;
            case 2035: goto L85;
            case 2036: goto L84;
            case 2037: goto L83;
            case 2100: goto L81;
            case 2102: goto L79;
            case 2104: goto L77;
            case 9000: goto L76;
            case 9001: goto L75;
            case 9008: goto L74;
            case 9013: goto L73;
            case 9014: goto L70;
            case 9016: goto L69;
            case 9017: goto L68;
            case 9018: goto L67;
            case 9019: goto L66;
            case 9021: goto L65;
            case 9022: goto L64;
            case 9023: goto L63;
            case 9030: goto L62;
            case 12002: goto L61;
            case 80001: goto L60;
            case 80002: goto L59;
            case 80004: goto L58;
            default: goto L35;
        };
    L35:
        switch(r110) {
            case 30: goto L57;
            case 31: goto L56;
            case 32: goto L52;
            case 33: goto L49;
            case 34: goto L48;
            default: goto L36;
        };
    L36:
        switch(r110) {
            case 63: goto L47;
            case 64: goto L46;
            case 65: goto L45;
            case 66: goto L44;
            default: goto L37;
        };
    L37:
        switch(r110) {
            case 90: goto L43;
            case 91: goto L42;
            case 92: goto L41;
            case 93: goto L40;
            case 94: goto L39;
            default: goto L322;
        };
    L39:
        this.mConfigure.mSpeedCoefficientValue = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L40:
        this.mConfigure.mEnableBenchMarkIOSpeed = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L41:
        this.mConfigure.mMainToBackUpDelayedTime = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDNSParser.setIntValue(3, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L42:
        this.mConfigure.mDNSBackType = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDNSParser.setIntValue(1, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L43:
        this.mConfigure.mDNSMainType = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDNSParser.setIntValue(0, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L44:
        this.mConfigure.mOnlyUseCdn = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L45:
        this.mConfigure.mErrorStateTrustTime = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L46:
        this.mConfigure.mEnableIpBucket = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L47:
        this.mConfigure.mMaxIpCountEachDomain = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L48:
        this.mConfigure.mEnablePcdnAuto = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L49:
        if (r111 != 0) goto L51;
        r100 = false;
    L51:
        this.mNeedMDLLoadMDLV2Lib = r100;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L52:
        if (r111 > 0) goto L55;
        r100 = false;
    L55:
        this.mForbidNativeMDLForOriUrl = r100;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L56:
        this.mConfigure.mEnableOkHttpLoader = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L57:
        this.mConfigure.mEncryptVersion = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L58:
        AVMDLDNSParser.setIntValue(11, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L59:
        AVMDLLog.enableLogOptimization = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L60:
        this.mEnableCheckHLSProxyVVCtrl = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L61:
        this.mEnableVideoModelHitCacheCallback = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L62:
        this.mEnableLoadMdlv2Fulllib = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L63:
        this.mEnablePreloadAllTs = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L64:
        this.mDisableFilePathCheck = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L65:
        this.mEnablePreloadFirstTs = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L66:
        this.mEnableNotOnlyNotifyNetError = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L67:
        this.mEnableNotifyError = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L68:
        this.mEnableCenterPreloadProgressCallback = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L69:
        this.mEnableHLSProxy = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L70:
        if (r111 == 1) goto L72;
        if (r111 != 0) goto L322;
    L72:
        this.mConfigure.mEnableMultiDownloadPath = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L73:
        this.mEnableLibManager = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L74:
        this.mEnableHls = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L75:
        this.mConfigure.mIgnorePlayInfo = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L76:
        this.mEnableDumpLibMd5 = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L77:
        if (r111 < 0) goto L322;
        this.mConfigure.mDevMemorySizeMB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L79:
        if (r111 < 0) goto L322;
        this.mConfigure.mDevDiskSizeMB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L81:
        if (r111 < 0) goto L322;
        this.mConfigure.mEnableP2pUpload = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L83:
        this.mConfigure.mEnableCustomDirSearchAllPath = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L84:
        this.mConfigure.mEnableEnginePortrait = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L85:
        this.mConfigure.mFileManagerInterval = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L86:
        this.mConfigure.mSessionCacheInterval = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L87:
        this.mConfigure.mEnableTraceIdPreloadLog = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L88:
        this.mConfigure.mPreloadInfoRecordMaxCnt = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L89:
        this.mConfigure.mEnableMissReason = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L90:
        this.mConfigure.mUpdateCacheFileInternal = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L91:
        this.mConfigure.mDisableRecentCache = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L92:
        this.mConfigure.mEnableUseGroupId = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L93:
        this.mConfigure.mCheckCacheDir = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L94:
        if (r111 <= 0) goto L322;
        this.mConfigure.mDownLogMaxSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L96:
        if (r111 <= 0) goto L322;
        this.mConfigure.mEnableOptimizeRange = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L98:
        if (r111 <= 0) goto L322;
        this.mConfigure.mIgnoreTextSpeedTest = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L100:
        if (r111 < 1) goto L322;
        if (r111 > 32) goto L322;
        if (TextUtils.isEmpty(this.mConfigure.mP2PCostTag) == true) goto L107;
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDataLoaderConfigure r101 = this.mConfigure;     // Catch: Throwable -> L323 Exception -> L325
        r115.append(r101.mP2PCostTag);     // Catch: Throwable -> L323 Exception -> L325
        r115.append(',');     // Catch: Throwable -> L323 Exception -> L325
        r115.append(Integer.toString(r111));     // Catch: Throwable -> L323 Exception -> L325
        r101.mP2PCostTag = r115.toString();     // Catch: Throwable -> L323 Exception -> L325
    L109:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L322;
        TTVideoEngineLog.d(TAG, "cur p2p cost tag is: " + this.mConfigure.mP2PCostTag);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L107:
        this.mConfigure.mP2PCostTag = Integer.toString(r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L109
    L111:
        if (r111 <= 0) goto L322;
        this.mConfigure.mNetUnreachableTimeout = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L113:
        if (r111 <= 0) goto L322;
        this.mConfigure.mSkipCDNBeforeExpiredSec = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L115:
        this.mConfigure.mEnableFileMutexOptimize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L116:
        if (r111 < 0) goto L322;
        this.mConfigure.mEnableWaitNetReachable = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L118:
        if (r111 < 0) goto L322;
        this.mConfigure.mNetUnreachableStopRetry = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L120:
        this.mConfigure.mNonBlockRangeMaxSizeKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L121:
        this.mConfigure.mNonBlockRangeMode = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L122:
        if (r111 <= 0) goto L322;
        this.mConfigure.mMaxIpNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L124:
        if (r111 <= 0) goto L322;
        this.mConfigure.mThreadPoolTTLSecond = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L126:
        if (r111 <= 0) goto L322;
        this.mConfigure.mEnableThreadPoolCheckIdle = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L128:
        if (r111 <= 0) goto L322;
        this.mConfigure.mThreadPoolMinCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L130:
        if (r111 < 0) goto L322;
        this.mConfigure.mThreadStackSizeLevel = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L132:
        this.mConfigure.mStoMaxIdleTimeSec = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L133:
        this.mConfigure.mStoIoWriteLimitKBTh2 = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L134:
        this.mConfigure.mStoIoWriteLimitKBTh1 = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L135:
        this.mConfigure.mStoRingBufferSizeKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L136:
        this.mConfigure.mStoPlayDldWinSizeKBLS = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L137:
        this.mConfigure.mStoPlayDldWinSizeKBNM = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L138:
        this.mConfigure.mEnableStorageModule = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L139:
        this.mConfigure.mEnableByteMediaNetLoader = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L140:
        this.mConfigure.mGetCookieTokenLevel = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L141:
        this.mEnableCheckPreloadUrls = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L142:
        this.mEnableStrategyCenterCancelAll = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L143:
        this.mDashAudioPreloadRatio = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L144:
        this.mDashAudioPreloadMinSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L145:
        this.mConfigure.mEnableCellularUp = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L146:
        if (r111 <= 0) goto L322;
        this.mConfigure.mEnableSpeedReport = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L148:
        if (r111 <= 0) goto L322;
        this.mConfigure.mEnableSpeedEngine = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L150:
        this.mEnableSetMDLNetStatus = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L151:
        this.mConfigure.mCloseThreadPool = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L152:
        this.mConfigure.mCheckContentTypeMethod = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L153:
        this.mConfigure.mMaxLoaderLogNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L154:
        this.mConfigure.mEnableLoaderLogExtractUrls = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L155:
        this.mConfigure.mEnableUseOriginalUrl = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L156:
        this.mEnableBufferPreload = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L157:
        if (r111 <= 0) goto L322;
        this.mConfigure.mEnableSpeedPredict = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L159:
        if (r111 <= 0) goto L322;
        this.mConfigure.mSocketRecvBufferSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L161:
        if (r111 < 0) goto L322;
        this.mConfigure.mEnableEarlyData = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L163:
        this.mConfigure.mMaxFileMemCacheNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L164:
        this.mConfigure.mMaxFileMemCacheSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L165:
        if (r111 <= 0) goto L322;
        this.mPreloadUtil.mPlayBufferUpperBound = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L167:
        if (r111 <= 0) goto L322;
        this.mPreloadUtil.mPlayBufferLowerBound = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L169:
        this.mEnableSplitPreload = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L170:
        this.mEnableMdlV2 = r111;     // Catch: Throwable -> L323 Exception -> L325
        this.mDidConfigMdlV2 = true;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L171:
        this.mConfigure.mEnableOwnVDPPreloadNotify = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L175:
        this.mConfigure.mNetSchedulerBlockHostIpErrCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L176:
        this.mConfigure.mMinAllowSpeed = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L177:
        this.mConfigure.mFileExtendSizeKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L178:
        this.mConfigure.mMaxAliveHostNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L179:
        this.mConfigure.mP2PFirstRangeLoaderType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L180:
        AVMDLDNSParser.setIntValue(2, r111);     // Catch: Throwable -> L323 Exception -> L325
        this.mConfigure.mDefaultExpiredTime = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L181:
        AVMDLDNSParser.setIntValue(10, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L182:
        this.mConfigure.mMaxSocketReuseCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L183:
        this.mConfigure.mSocketInitialTimeout = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L184:
        this.mConfigure.mEnableDynamicTimeout = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L185:
        this.mConfigure.mP2PPreDownPeerCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L186:
        this.mConfigure.mEnableLoaderSeek = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L187:
        this.mConfigure.mEnableCacheReqRange = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L188:
        this.mConfigure.mIsAllowTryTheLastUrl = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L189:
        this.mConfigure.mFirstRangeLeftThreshold = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L190:
        this.mConfigure.mNetSChedulerBlockDurationMs = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L191:
        this.mConfigure.mNetSchedulerBlockErrCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L192:
        this.mConfigure.mNetSchedulerBlockAllNetErr = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L193:
        this.mConfigure.mEnableNetScheduler = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L194:
        this.mConfigure.mEnablePlayLog = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L195:
        this.mConfigure.mEnableP2PPreDown = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L196:
        this.mConfigure.mControlCDNRangeType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L197:
        this.mConfigure.mEnablePlayInfoCache = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L198:
        this.mConfigure.mNewBufferPoolGrowBlockCount = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L199:
        this.mConfigure.mNewBufferPoolResidentSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L200:
        this.mConfigure.mNewBufferPoolBlockSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L201:
        this.mConfigure.mEnableNewBufferpool = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L202:
        this.mConfigure.mSessionTimeout = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L203:
        this.mConfigure.mEnableLazyBufferpool = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L204:
        this.mConfigure.mForbidByPassCookie = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L205:
        this.mConfigure.mMaxIPV4Num = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L206:
        this.mConfigure.mMaxIPV6Num = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L207:
        if (r111 != 0) goto L210;
        r100 = false;
    L210:
        this.mAudioPreloadFirst = r100;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L211:
        this.mNeedSpeedTestByTimeInternal = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L212:
        this.mConfigure.mCheckPreloadLevel = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L213:
        this.mConfigure.mXYLibValue = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L214:
        AVMDLDataLoader r116 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r116 == null) goto L322;
        r116.setIntValue(AVMDLDataLoader.KeyIsSetBackupLoaderType, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L217:
        this.mConfigure.mEnableSyncDnsForPcdn = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L218:
        this.mConfigure.mSocketSendBufferKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L219:
        AVMDLDataLoader r117 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r117 == null) goto L322;
        r117.setIntValue(AVMDLDataLoader.KeyIsNetworkAccessType, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L222:
        this.mConfigure.mNextDownloadThreshold = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L223:
        this.mConfigure.mAccessCheckLevel = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L224:
        this.mConfigure.mEnableLoaderPreempt = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L225:
        this.mEnableReportSpeed = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L226:
        if (r111 == 1) goto L229;
        r100 = false;
    L229:
        this.mCloseLocalServer = r100;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L230:
        this.mEnableFirstNativeMDL = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L231:
        this.mEnableNetworkChangedListen = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L232:
        this.mConfigure.mEnableUseFileExtendLoaderBuffer = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L233:
        this.mConfigure.mEnableFileRingBuffer = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L234:
        this.mConfigure.mEnableFileCacheV2 = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L235:
        this.mConfigure.mRingBufferSizeKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L236:
        if (r111 == 1) goto L239;
        r100 = false;
    L239:
        this.mEnableMdlProtocol = r100;     // Catch: Throwable -> L323 Exception -> L325
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L322;
        TTVideoEngineLog.i(TAG, "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.mEnableMdlProtocol);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L242:
        if (r111 != 0) goto L245;
        r100 = false;
    L245:
        this.mInvalidMdlProcotol = r100;     // Catch: Throwable -> L323 Exception -> L325
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L322;
        TTVideoEngineLog.i(TAG, "setIntValue: mInvalidMdlProcotol: " + this.mInvalidMdlProcotol);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L248:
        this.mConfigure.mPreconnectNum = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L249:
        this.mConfigure.mEnablePreconnect = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L255:
        this.mConfigure.mLiveRecvDataTimeout = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L256:
        this.mConfigure.mAlogEnable = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDataLoader r118 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r118 == null) goto L322;
        r118.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L259:
        this.mConfigure.mLiveMobileDownloadAllow = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L260:
        this.mConfigure.mLiveMobileUploadAllow = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L261:
        this.mConfigure.mLiveWaitP2pReadyThreshold = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L262:
        this.mConfigure.mLiveMaxTrySwitchP2pTimes = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L263:
        this.mConfigure.mLiveCacheThresholdP2pToHttp = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L264:
        this.mConfigure.mLiveCacheThresholdHttpToP2p = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L265:
        this.mConfigure.mLiveWatchDurationThreshold = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L266:
        this.mConfigure.mLiveLoaderEnable = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L267:
        this.mConfigure.mLiveLoaderType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L268:
        this.mConfigure.mLiveP2pAllow = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L269:
        this.mConfigure.mEnableEventInfo = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L270:
        if (r111 <= 0) goto L322;
        this.mConfigure.mDeviceScoreEx = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L272:
        this.mConfigure.mUseNewSpeedTestForSingle = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L273:
        SettingsHelper.helper().setEnable(r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L274:
        this.mConfigure.mGlobalSpeedSampleInterval = r111;     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDataLoader r119 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r119 == null) goto L322;
        r119.setIntValue(AVMDLDataLoader.KeyIsSetGlobalSpeedSampleInterval, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L277:
        this.mConfigure.mSpeedSampleInterval = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L278:
        AVMDLDNSParser.setIntValue(7, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L279:
        AVMDLDNSParser.setIntValue(6, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L280:
        AVMDLDNSParser.setIntValue(5, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L281:
        AVMDLDNSParser.setIntValue(4, r111);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L282:
        this.mConfigure.mPreloadWaitListType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L283:
        this.mConfigure.mIsCloseFileCache = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L284:
        this.mConfigure.mEnableTTQuicHeLoaderCheckWithNetworkType = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L285:
        this.mConfigure.mEnableTTQuicHeLoader = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L286:
        this.mConfigure.mTTNetLoaderCronetBufSizeKB = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L287:
        this.mConfigure.mEnableTTNetLoader = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L288:
        this.mConfigure.mEnableDownloaderLog = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L289:
        this.mPreloadPreConnect = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L290:
        this.mFloatSize = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L291:
        this.mPreloadTaskIgnorePlayerStall = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L173:
        if (FeatureManager.hasPermission("strategy_center") == false) goto L322;
        this.mConfigure.mEnableIOManager = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L251:
        if (this.mEnableNetworkChangedListen != 1) goto L322;
        clearNetinfoCache();     // Catch: Throwable -> L323 Exception -> L325
        AVMDLDataLoader r120 = this.mInnerDataLoader;     // Catch: Throwable -> L323 Exception -> L325
        if (r120 == null) goto L322;
        r120.setIntValue(AVMDLDataLoader.KeyIsNetworkChanged, 1);     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L293:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L295;
        TTVideoEngineLog.i(TAG, "set write file notify intervalMS " + r111);     // Catch: Throwable -> L323 Exception -> L325
    L295:
        this.mConfigure.mWriteFileNotifyIntervalMS = r111;     // Catch: Throwable -> L323 Exception -> L325
        goto L322
    L308:
        this.mConfigure.mEnableSessionReuse = r111;     // Catch: Throwable -> L323 Exception -> L325
    L323:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L325:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L323
        goto L322
    }

    /* JADX INFO: Removed unreachable split cross block B:33:0x0080 */
    public void setIntValueSync(int r100, int r101) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mInnerDataLoader != null) goto L9;
        this.mLock.unlock(ABLock.TYPE_READ);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L35;
        TTVideoEngineLog.d(TAG, "setIntValueSync failed, key = " + r100 + ", value = " + r101);
        return;
    L35:
        return;
    L9:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L31;
        TTVideoEngineLog.d(TAG, "setIntValueSync key = " + r100 + ", value = " + r101);
    L31:
        if (r100 != 2103) goto L14;
        if (r101 < 0) goto L28;
        this.mInnerDataLoader.setIntValue(11003, r101);     // Catch: Throwable -> L21 Exception -> L23
    L30:
    L28:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L14:
        if (r100 != 2105) goto L28;
        if (r101 < 0) goto L28;
        this.mInnerDataLoader.setIntValue(11005, r101);     // Catch: Throwable -> L21 Exception -> L23
    L21:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L30
    }

    public void setLongValue(int r100, long r101) {
        this.mLock.lock(ABLock.TYPE_READ);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L47;
        TTVideoEngineLog.d(TAG, "setLongValue key = " + r100 + ", value = " + r101);
    L47:
        if (r100 != 62) goto L8;
        int r102 = 1100;
    L33:
        AVMDLDataLoader r103 = this.mInnerDataLoader;     // Catch: Throwable -> L37 Exception -> L39
        if (r103 == null) goto L36;
        r103.setLongValue(r102, r101);     // Catch: Throwable -> L37 Exception -> L39
    L36:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L8:
        if (r100 != 1142) goto L10;
        this.mConfigure.mP2PStragetyLevel = r101;     // Catch: Throwable -> L37 Exception -> L39
    L31:
        r102 = -1;
        goto L33
    L10:
        if (r100 != 1144) goto L12;
        this.mConfigure.mConnectPoolStragetyValue = r101;     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L12:
        if (r100 != 80003) goto L14;
        this.mConfigure.mMaxCacheSize64 = r101;     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L14:
        if (r100 != 1152) goto L16;
        this.mConfigure.mMonitorTimeInternal = r101;     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L16:
        if (r100 == 1153) goto L26;
        switch(r100) {
            case 22: goto L25;
            case 23: goto L24;
            case 24: goto L23;
            case 25: goto L22;
            case 26: goto L21;
            case 27: goto L20;
            case 28: goto L19;
            default: goto L31;
        };
    L19:
        r102 = AVMDLDataLoader.KeyIsSetPlayInfoSeekAction;
        goto L33
    L20:
        r102 = AVMDLDataLoader.KeyIsPlayInfoCurrentBuffer;
        goto L33
    L21:
        r102 = AVMDLDataLoader.KeyIsPlayInfoBufferingEnd;
        goto L33
    L22:
        r102 = AVMDLDataLoader.KeyIsPlayInfoBufferingStart;
        goto L33
    L23:
        r102 = AVMDLDataLoader.KeyIsPlayInfoLoadPercent;
        goto L33
    L24:
        r102 = AVMDLDataLoader.KeyIsPlayInfoPlayingPos;
        goto L33
    L25:
        r102 = AVMDLDataLoader.KeyIsPlayInfoRenderStart;
        goto L33
    L26:
        this.mConfigure.mMonitorMinAllowLoadSize = r101;     // Catch: Throwable -> L37 Exception -> L39
    L37:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L41:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L36;
        TTVideoEngineLog.e(TAG, "setLongValue failed, key: " + r100 + ", value: " + r101);     // Catch: Throwable -> L37
        goto L36
    }

    public void setStringValue(int r100, String r101) {
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L5;
        TTVideoEngineLog.d(TAG, "setStringValue key = " + r100 + ", value = " + r101);
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        switch(r100) {
            case 0: goto L50;
            case 102: goto L49;
            case 107: goto L48;
            case 108: goto L47;
            case 111: goto L46;
            case 514: goto L45;
            case 1106: goto L44;
            case 1107: goto L43;
            case 1149: goto L42;
            case 1165: goto L41;
            case 1173: goto L40;
            case 1500: goto L39;
            case 1502: goto L38;
            case 1506: goto L30;
            case 1507: goto L30;
            case 1508: goto L30;
            case 1510: goto L28;
            case 1511: goto L27;
            case 1512: goto L26;
            case 2007: goto L25;
            case 2029: goto L24;
            case 2101: goto L23;
            case 9002: goto L22;
            case 9003: goto L21;
            case 9004: goto L20;
            case 9005: goto L19;
            case 9006: goto L18;
            case 9007: goto L17;
            case 9010: goto L16;
            case 9012: goto L15;
            case 9020: goto L9;
            case 12003: goto L8;
            default: goto L61;
        };
    L8:
        this.mConfigure.mFileKeyRule = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L9:
        String[] r102 = r101.split(",");     // Catch: Throwable -> L52 Exception -> L54
        int r103 = r102.length;     // Catch: Throwable -> L52 Exception -> L54
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L61;
        String r105 = r102[r104];     // Catch: Throwable -> L52 Exception -> L54
        if (TextUtils.isEmpty(r105) == true) goto L14;
        this.mNotifyNetErrors.add(Integer.valueOf(Integer.parseInt(r105)));     // Catch: Throwable -> L52 Exception -> L54
    L14:
        r104 = r104 + 1;     // Catch: Throwable -> L52 Exception -> L54
        goto L10
    L15:
        this.mConfigure.mP2PConfigStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L16:
        this.mConfigure.mSocketTraingCenterConfigStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L17:
        this.mConfigure.mKeyToken = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L18:
        this.mConfigure.mKeyDomain = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L19:
        this.mConfigure.mDomains = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L20:
        this.mConfigure.mForesightDomain = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L21:
        this.mConfigure.mDmDomain = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L22:
        this.mConfigure.mSettingsDomain = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L23:
        this.mConfigure.mVdpExtGlobalInfo = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L24:
        this.mConfigure.mPrecisePreloadConfigStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L25:
        this.mConfigure.mStoStrategyConfig = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L26:
        this.mConfigure.mMdlTTQuicHeOptsStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L27:
        this.mConfigure.mN80OptsStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L28:
        this.mConfigure.mFileRingBufferOptStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L38:
        this.mConfigure.mTemporaryOptStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L39:
        this.mConfigure.mMdlExtensionOptsStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L40:
        this.mConfigure.mSpeedEngineSetting = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L41:
        this.mConfigure.mDynamicPreconnectConfigStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L42:
        this.mConfigure.mNetSchedulerConfigStr = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L43:
        this.mConfigure.mVdpGroupId = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L44:
        this.mConfigure.mVdpABTestId = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L45:
        this.mConfigure.mLiveContainerString = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L46:
        this.mConfigure.mDownloadDir = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L47:
        AVMDLDNSParser.setStringValue(9, r101);     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L48:
        AVMDLDNSParser.setStringValue(8, r101);     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L49:
        this.mConfigure.mNetCacheDir = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L61
    L50:
        this.mConfigure.mCacheDir = r101;     // Catch: Throwable -> L52 Exception -> L54
    L61:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L30:
        if (TextUtils.isEmpty(r101) == true) goto L36;
        if (TextUtils.isEmpty(this.mConfigure.mCustomUA) == false) goto L34;
        this.mConfigure.mCustomUA = r101;     // Catch: Throwable -> L52 Exception -> L54
        goto L36
    L34:
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L52 Exception -> L54
        AVMDLDataLoaderConfigure r107 = this.mConfigure;     // Catch: Throwable -> L52 Exception -> L54
        r106.append(r107.mCustomUA);     // Catch: Throwable -> L52 Exception -> L54
        r106.append(",");     // Catch: Throwable -> L52 Exception -> L54
        r106.append(r101);     // Catch: Throwable -> L52 Exception -> L54
        r107.mCustomUA = r106.toString();     // Catch: Throwable -> L52 Exception -> L54
    L36:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L61;
        TTVideoEngineLog.d(TAG, "cur custom UA" + this.mConfigure.mCustomUA);     // Catch: Throwable -> L52 Exception -> L54
    L54:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L61;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public void setStringValueSync(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        if (this.mInnerDataLoader != null) goto L12;
        this.mLock.unlock(ABLock.TYPE_READ);
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L34;
        TTVideoEngineLog.d(TAG, "setStringValueSync failed, key = " + r100 + ", value = " + r101);
        return;
    L34:
        return;
    L12:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L31;
        TTVideoEngineLog.d(TAG, "setStringValueSync key = " + r100 + ", value = " + r101);
    L31:
        if (r100 != 2030) goto L17;
        this.mInnerDataLoader.setStringValue(AVMDLDataLoader.KeyIsStoUpdateCacheDir, r101);     // Catch: Throwable -> L22 Exception -> L24
    L30:
    L21:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L17:
        if (r100 != 2106) goto L21;
        this.mInnerDataLoader.setStringValue(AVMDLDataLoader.KeyIsSetVdpExtDynamicInfo, r101);     // Catch: Throwable -> L22 Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public boolean startDownload(String r100, boolean r101) {
        boolean r102 = false;
        if (FeatureManager.hasPermission() == true) goto L6;
        return false;
    L6:
        if (this.mState == 0) goto L8;
        return false;
    L8:
        this.mLock.lock(ABLock.TYPE_READ);
    L20:
        th = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L18;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L25
    L18:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r102;
    L10:
        if (this.mInnerDataLoader == null) goto L18;
        if (TextUtils.isEmpty(r100) == true) goto L18;
        this.mInnerDataLoader.downloadResource(r100);     // Catch: Throwable -> L20
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L17;
        TTVideoEngineLog.i(TAG, "[downloader] start download resource = " + r100);     // Catch: Throwable -> L20
    L17:
        r102 = true;
        goto L18
    }

    public long tryToClearAndGetCachesByUsedTime(long r100, boolean r101) {
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r102 = this.mInnerDataLoader;     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        this.mLock.unlock(ABLock.TYPE_READ);
        return -1;
    L7:
        long r103 = r102.tryToClearAndGetCachesByUsedTime(r100, r101);     // Catch: Throwable -> L9
        this.mLock.unlock(ABLock.TYPE_READ);
        return r103;
    L9:
        th = move-exception;
    L16:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L12:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L14;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L16
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return 0;
    }

    public void updateDnsInfo(JSONObject r100, long r101) {
        if (r100 != null) goto L6;
        TTVideoEngineLog.e(TAG, "ip direct info invalid");
        return;
    L6:
        long r102 = NetUtils.netUpdateTimeMs;
        if (r102 != (-1)) goto L9;
    L12:
        this.mLock.lock(ABLock.TYPE_READ);
        Iterator<String> r103 = r100.keys();     // Catch: Throwable -> L27 Exception -> L29
    L14:
        String r104 = r103.next();     // Catch: Throwable -> L27 Exception -> L29
        JSONArray r105 = r100.optJSONArray(r104);     // Catch: Throwable -> L27 Exception -> L29
        String r106 = "";
        int r107 = 0;
    L17:
        if (r107 >= r105.length()) goto L22;
        r106 = r106 + r105.optString(r107);     // Catch: Throwable -> L27 Exception -> L29
        if (r107 >= (r105.length() - 1)) goto L21;
        r106 = r106 + ",";     // Catch: Throwable -> L27 Exception -> L29
    L21:
        r107 = r107 + 1;     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L22:
        AVMDLDNSParser.updateDNSInfo(r104, r106, r101);     // Catch: Throwable -> L27 Exception -> L29
        if (r103.hasNext() == false) goto L34;
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L34:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L29:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(6) == false) goto L34;
        TTVideoEngineLog.e(TAG, e.toString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L9:
        if ((1000 * r101) >= r102) goto L12;
        TTVideoEngineLog.e(TAG, "network did change, dnsinfo is invalid");
    }

    private Error _errorWithCode(int r100, long r101, String r110) {
        if (r100 != (-5000)) goto L5;
        String r102 = "write file fail.";
        int r103 = Error.SaveTaskWriteFile;
    L28:
        if (r101 != 3) goto L30;
        String r104 = Error.Download;
    L32:
        return new Error(r104, r103, r100, "key = " + r110 + ", reason = " + r102);
    L30:
        r104 = Error.DataLoaderPreload;
        goto L32
    L5:
        if (r100 != (-4000)) goto L7;
        r102 = "request invalid.";
    L25:
        r103 = r100;
        goto L28
    L7:
        if (r100 != (-2000)) goto L9;
        r102 = "media data content length invalid";
        goto L25
    L9:
        if (r100 != (-3001)) goto L11;
        r102 = "server invalid. response status code >= 500";
        r103 = Error.ServiceInaccessible;
        goto L28
    L11:
        if (r100 == (-3000)) goto L18;
        switch(r100) {
            case -1002: goto L16;
            case -1001: goto L15;
            case -1000: goto L14;
            default: goto L13;
        };
    L13:
        r102 = "task fail. reply task error.";
        goto L25
    L14:
        r102 = "create preload task fail.";
        goto L25
    L15:
        r102 = "add the same key task.";
        goto L25
    L16:
        r102 = "Waiting for too many tasks, > 20";
        goto L25
    L18:
        if (NetUtils.isNetAvailable(this.mContext) == true) goto L20;
        int r105 = Error.NetworkNotAvailable;
    L21:
        r103 = r105;
        r102 = "url invalid. response status code >= 400";
        goto L28
    L20:
        r105 = Error.URLUnavailable;
        goto L21
    }

    public static /* synthetic */ void access$1000(DataLoaderHelper r100, String r101, int r102) {
        r100._doMl_removeAllMedias(r101, r102);
    }

    public static /* synthetic */ void access$800(DataLoaderHelper r100, PreloadModelMedia r101, String r102) {
        r100._doMl_addMedia(r101, r102);
    }

    public static /* synthetic */ void access$900(DataLoaderHelper r100, String r101, String r102) {
        r100._doMl_removeMedia(r101, r102);
    }

    public void addTask(IVideoModel r100, Resolution r101, long r102) {
        addTask(r100, r101, null, r102);
    }

    public DataLoaderCacheFileInfo cacheFileInfoByTimeOut(String r100, long r101, TimeUnit r102) {
        DataLoaderCacheInfo r103 = getCacheInfoByTimeOut(r100, r101, r102);
        if (r103 == null) goto L6;
        DataLoaderCacheFileInfo r104 = new DataLoaderCacheFileInfo(this);
        r104.mMediaSize = r103.mMediaSize;
        r104.mCacheSizeFromZero = r103.mCacheSizeFromZero;
        r104.mLocalFilePath = r103.mLocalFilePath;
        return r104;
    L6:
        return null;
    }

    public String downloadUrl(String r110, String r111, String[] r112) {
        if (TextUtils.isEmpty(r110) == true) goto L10;
        if (r112 != null) goto L6;
        return null;
    L6:
        if (r112.length >= 1) goto L9;
        return null;
    L9:
        return downloadProxyQuery(r110, r111, 0, 0, r112, null, null, false, null, -1, -1, 0);
    L10:
        return null;
    }

    public DataLoaderCacheInfo getCacheInfoByTimeOut(String r100, long r101, TimeUnit r110) {
        DataLoaderCacheInfo r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L43;
        return null;
    L43:
    L34:
        e = move-exception;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L38;
        TTVideoEngineLog.d(TAG, "get cacheinfo interrupt exception:" + e.getLocalizedMessage());
    L38:
        TTVideoEngineLog.d(TAG, "get cacheinfo all end");
        return r102;
    L7:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L10;
        TTVideoEngineLog.d(TAG, "****try get cacheinfo lock timeout" + r101);     // Catch: InterruptedException -> L34
    L10:
        if (this.mLock.tryLock(ABLock.TYPE_READ, r101, r110) == false) goto L31;
        TTVideoEngineLog.d(TAG, "####get cacheinfo lock suc");     // Catch: InterruptedException -> L34
    L24:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L27
        ABLockWrapper r103 = this.mLock;     // Catch: InterruptedException -> L34
        int r104 = ABLock.TYPE_READ;     // Catch: InterruptedException -> L34
    L19:
        r103.unlock(r104);     // Catch: InterruptedException -> L34
        goto L38
    L27:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);     // Catch: InterruptedException -> L34
        throw th;     // Catch: InterruptedException -> L34
    L13:
        if (this.mInnerDataLoader != null) goto L15;
    L21:
        TTVideoEngineLog.d(TAG, "get cacheinfo fail mdl not start");     // Catch: Throwable -> L24
        this.mLock.unlock(ABLock.TYPE_READ);     // Catch: InterruptedException -> L34
        return null;
    L15:
        if (this.mState != 0) goto L21;
        r102 = _processCacheInfo(this.mInnerDataLoader.getStringCacheInfo(r100));     // Catch: Throwable -> L24
        TTVideoEngineLog.d(TAG, "get cacheinfo native end");     // Catch: Throwable -> L24
        r103 = this.mLock;     // Catch: InterruptedException -> L34
        r104 = ABLock.TYPE_READ;     // Catch: InterruptedException -> L34
        goto L19
    L31:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L38;
        TTVideoEngineLog.d(TAG, "####not get cacheinfo lock timeout" + r101);     // Catch: InterruptedException -> L34
        goto L38
    }

    public long getContinueCacheSize(String r100, int r101, long r102) {
        long r103 = 0;
        if (this.mState == 0) goto L5;
        return 0;
    L5:
        this.mLock.lock(ABLock.TYPE_READ);
        AVMDLDataLoader r104 = this.mInnerDataLoader;     // Catch: Throwable -> L14
        if (r104 != null) goto L10;
    L8:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r103;
    L10:
        long r105 = r104.getContinueCacheSize(r100, r101, r102);     // Catch: Throwable -> L14
        if (r105 <= 0) goto L8;
        r103 = r105;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    @Override // com.ss.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int r210, long r211, String r212) {
        String r110 = r212;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L5;
        TTVideoEngineLog.i(TAG, "[preload] getStringValue, key = " + r110);
    L5:
        String r100 = null;
        if (r210 != 1506) goto L8;
        DataLoaderTaskQueue r101 = this.mAllPreloadTasks;
        if (r101 == null) goto L36;
        DataLoaderTaskItem r102 = r101.itemForKey(r110);
    L38:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L40;
        TTVideoEngineLog.i(TAG, "[preload] getStringValue, key = " + r110);
    L40:
        if (r102 == null) goto L56;
        PreloaderURLItem r103 = r102.mURLItem;
        if (r103 == null) goto L56;
        if (r103.getProvider() == null) goto L56;
        String r111 = r102.mURLItem.getProvider().getKey();
        String[] r104 = r102.mURLItem.getProvider().getUrls();
        DataLoaderTaskItem.TrackItem r112 = r102.getTrackItem(r110);
        long r105 = r112.mPreSize;
        long r106 = r102.mURLItem.getProvider().getPreloadSize();
        String r107 = r102.mURLItem.getProvider().getCacheDir();
        if (r102.mTag == null) goto L48;
        String r108 = "tag=" + TTHelper.encodeUrl(r102.mTag);
    L49:
        r100 = proxyQuery(r111, r111, r112.mPreloadOffset, r106, r104, r107, r108, false, null, -1, -1);
        if (TextUtils.isEmpty(r111) == true) goto L53;
        r110 = r111;
    L53:
        r112.mTaskKey = r110;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L56;
        TTVideoEngineLog.i(TAG, String.format("[preload] get proxxy url from url: %s", new Object[]{r100}));
        goto L56
    L48:
        r108 = null;
    L56:
        return r100;
    L36:
        r102 = null;
        goto L38
    L8:
        if (r210 != 1509) goto L56;
        if (this.mListener == null) goto L56;
        if (TextUtils.isEmpty(r212) == true) goto L56;
        HashMap<String, String> r109 = this.mListener.getCustomHttpHeaders(r110);
        if (r109 != null) goto L17;
    L32:
        return null;
    L17:
        if (r109.size() == 0) goto L32;
        StringBuilder r113 = new StringBuilder();
        Iterator<String> r114 = r109.keySet().iterator();
    L21:
        if (r114.hasNext() == false) goto L28;
        String r115 = r114.next();
        if (TextUtils.isEmpty(r115) == true) goto L21;
        if (TextUtils.isEmpty(r109.get(r115)) == true) goto L21;
        r113.append(r115);
        r113.append(": ");
        r113.append(r109.get(r115));
        r113.append("\r\n");
        goto L21
    L28:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L31;
        TTVideoEngineLog.i(TAG, String.format("[customheader] get custom header:%s url: %s", new Object[]{r110, r113.toString()}));
    L31:
        return r113.toString();
    }

    public void addTask(VideoModel r100, Resolution r101, long r102) {
        addTask(r100, r101, null, r102);
    }

    public void addTask(String[] r100, String r110, long r111, String r112) {
        if (r100 != null) goto L4;
    L13:
        TTVideoEngineLog.e(TAG, "urls invalid.");
        return;
    L4:
        if (r100.length == 0) goto L13;
        this.mLock.lock(ABLock.TYPE_READ);
        String r101 = TTHelper.keyFromFilePath(this.mContext, r112);     // Catch: Throwable -> L10
        PreloaderURLItem r102 = new PreloaderURLItem(r110, r111, r100, r112);     // Catch: Throwable -> L10
        r102.setKey(r101);     // Catch: Throwable -> L10
        addTask(r102);     // Catch: Throwable -> L10
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L10:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    }

    public String downloadUrl(String r110, String r111, String[] r112, int r210) {
        if (TextUtils.isEmpty(r110) == true) goto L10;
        if (r112 != null) goto L6;
        return null;
    L6:
        if (r112.length >= 1) goto L9;
        return null;
    L9:
        return downloadProxyQuery(r110, r111, 0, 0, r112, null, null, false, null, r210, 0, 0);
    L10:
        return null;
    }

    public long getMissReason(int r100, String r101, String r102, String r103) {
        this.mLock.lock(ABLock.TYPE_READ);
        long r104 = 0;
    L28:
        th = move-exception;
    L33:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L30:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == true) goto L31;
    L5:
        this.mLock.unlock(ABLock.TYPE_READ);
        return r104;
    L31:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L33
        goto L5
    L4:
        if (this.mInnerDataLoader == null) goto L5;
        AVMDLDataLoaderConfigure r105 = this.mConfigure;     // Catch: Throwable -> L28
        if (r105 != null) goto L10;
    L12:
        if (r100 != 0) goto L14;
        r101 = TTHelper.keyFromFilePath(this.mContext, r101);     // Catch: Throwable -> L28
    L17:
        if (r101 == null) goto L5;
        if (this.mConfigure.mEnableUseGroupId > 0) goto L22;
    L24:
        long r106 = this.mInnerDataLoader.getMissReason(r101, r102);     // Catch: Throwable -> L28
        if (r106 <= 0) goto L5;
        r104 = r106;
        goto L5
    L22:
        if (TextUtils.isEmpty(r103) == true) goto L24;
        r102 = r103;
        goto L24
    L14:
        if (r100 == 1) goto L17;
        r101 = null;
        goto L17
    L10:
        if (r105.mEnableMissReason != 0) goto L12;
        goto L12
    }

    public void setPlayInfo(int r100, String r101, String r102, long r103) {
        if (this.mState == 0) goto L6;
        TTVideoEngineLog.d(TAG, "dataloader not started, not allow set play info");
        return;
    L6:
        this.mLock.lock(ABLock.TYPE_READ);
        setPlayInfoOnlyForPreload(r100, r101, r102, r103);
        switch(r100) {
            case 22: goto L15;
            case 23: goto L14;
            case 24: goto L13;
            case 25: goto L12;
            case 26: goto L11;
            case 27: goto L10;
            case 28: goto L9;
            default: goto L8;
        };
    L8:
        int r104 = -1;
    L26:
        this.mInnerDataLoader.setInt64ValueByStrKey(r104, r101, r103);     // Catch: Throwable -> L18 Exception -> L20
    L17:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L9:
        r104 = AVMDLDataLoader.KeyIsSetPlayInfoSeekAction;
        goto L26
    L10:
        r104 = AVMDLDataLoader.KeyIsPlayInfoCurrentBuffer;
        goto L26
    L11:
        r104 = AVMDLDataLoader.KeyIsPlayInfoBufferingEnd;
        goto L26
    L12:
        r104 = AVMDLDataLoader.KeyIsPlayInfoBufferingStart;
        goto L26
    L13:
        r104 = AVMDLDataLoader.KeyIsPlayInfoLoadPercent;
        goto L26
    L14:
        r104 = AVMDLDataLoader.KeyIsPlayInfoPlayingPos;
        goto L26
    L15:
        r104 = AVMDLDataLoader.KeyIsPlayInfoRenderStart;
        goto L26
    }

    public void setPlayInfoOnlyForPreload(int r100, String r110, String r111, long r112) {
        if (this.mState == 0) goto L7;
        TTVideoEngineLog.d(TAG, "dataloader not started, not allow set play info");
        return;
    L7:
        if (this.mEnableBufferPreload > 0) goto L9;
        return;
    L9:
        this.mLock.lock(ABLock.TYPE_READ);
        PreloadUtil r101 = this.mPreloadUtil;
        if (r101.mPlayBufferLowerBound > 0) goto L12;
    L14:
        this.mLock.unlock(ABLock.TYPE_READ);
        return;
    L12:
        if (r101.mPlayBufferUpperBound <= 0) goto L14;
        r101.updatePlayInfo(r100, r110, r111, r112);
        goto L14
    }

    public void addTask(String r100, String r101, String r110, long r111) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        TTVideoEngineLog.e(TAG, "[preload] url invalid.");
        return;
    L6:
        addTask(new PreloaderURLItem(r100, r101, r111, new String[]{r110}));
    }

    public void addTask(String r100, String r101, long r110, String r111) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        TTVideoEngineLog.e(TAG, "url invalid.");
        return;
    L6:
        addTask(new String[]{r100}, r101, r110, r111);
    }

    public void addTask(String r100, String r101, String[] r110, long r111) {
        if (r110 != null) goto L4;
    L8:
        TTVideoEngineLog.e(TAG, "urls invalid.");
        return;
    L4:
        if (r110.length == 0) goto L8;
        addTask(new PreloaderURLItem(r100, r101, r111, r110));
    }

    public void addTask(IVideoModel r100, Resolution r101, Map<Integer, String> r110, long r111) {
        PreloaderVideoModelItem r102 = new PreloaderVideoModelItem(r100, r101, r111, null);
        r102.mParams = r110;
        addTask(r102);
    }

    public void addTask(VideoModel r100, Resolution r101, Map<Integer, String> r110, long r111) {
        PreloaderVideoModelItem r102 = new PreloaderVideoModelItem(r100, r101, r111, null);
        r102.mParams = r110;
        addTask(r102);
    }

    private String proxyQueryProvideMode(String r100, String r101, int r102, int r103, String r104) {
        if (TextUtils.isEmpty(r100) == true) goto L23;
        if (r103 == 0) goto L23;
        String r105 = TTHelper.encodeUrl(r100);
        if (TextUtils.isEmpty(r105) == false) goto L10;
        return null;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        r101 = r100;
    L12:
        String r106 = TTHelper.encodeUrl(r101);
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r100 = r106;
    L16:
        StringBuffer r107 = new StringBuffer("?rk=");
        r107.append(r100);
        r107.append("&k=");
        r107.append(r105);
        r107.append("&pv=1");
        if (TextUtils.isEmpty(r104) == true) goto L19;
        r107.append("&gid=");
        r107.append(r104);
    L19:
        if (r102 <= 0) goto L22;
        r107.append("&l=");
        r107.append(r102);
    L22:
        return r107.toString();
    L23:
        return null;
    }

    public void addTask(String r100, String r110, String[] r111, long r112, String r113) {
        if (r111 != null) goto L4;
    L8:
        TTVideoEngineLog.e(TAG, "urls invalid.");
        return;
    L4:
        if (r111.length == 0) goto L8;
        addTask(new PreloaderURLItem(r100, r110, r112, r111, r113));
    }

    public String getDataLoaderUrl(String r210, String r211, String[] r212, Resolution r213, String r214) {
        return _proxyUrl(r210, r211, 0, r212, r213, r214, null, null, null, false, false, null, 0, null, -1, null, false, -1);
    }

    public String proxyUrl(String r210, String r211, String[] r212, Resolution r213, String r214) {
        return _proxyUrl(r210, r211, 0, r212, r213, r214, null, null, null, false, false, null, 0, null, -1, null, false, -1);
    }

    public int writeDataToFile(String r110, long r111, long r112, int r113, byte[] r114) {
        if (this.mState == 0) goto L6;
        TTVideoEngineLog.e(TAG, "not start");
        return -1;
    L6:
        int r100 = 0;
        if (this.mLock.tryLock(ABLock.TYPE_READ) == false) goto L13;
        if (this.mInnerDataLoader == null) goto L11;
        TTVideoEngineLog.d(TAG, "start write");
        int r101 = this.mInnerDataLoader.writeDataToFile(r110, r111, r112, r113, r114);
        TTVideoEngineLog.d(TAG, "end write");
        r100 = r101;
    L11:
        this.mLock.unlock(ABLock.TYPE_READ);
    L13:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L15;
        TTVideoEngineLog.d(TAG, "write data to file ret:" + r100);
    L15:
        return r100;
    }

    public void addTask(String r100, String r110, long r111, DataLoaderResourceProvider r112, String r113) {
        if (r112 != null) goto L5;
        TTVideoEngineLog.e(TAG, "provider invalid.");
        return;
    L5:
        addTask(new PreloaderURLItem(r100, r110, r111, r112, r113));
    }

    public void addTask(String r100, String r101, VideoModel r102, Resolution r110, long r111) {
        addTask(new PreloaderVideoModelItem(r102, r110, r111, null));
    }

    private void _addTask(String r100, String r101, long r102, PreloaderVidItem r110, PreloaderVideoModelItem r111, PreloaderURLItem r112) {
        if (FeatureManager.hasPermission("preload") == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        TTVideoEngineLog.e(TAG, "[preload] key invalid.");
        return;
    L10:
        if (this.mInnerDataLoader != null) goto L12;
    L82:
        TTVideoEngineLog.e(TAG, "[preload] need load mdl first.");
        return;
    L12:
        if (this.mState != 0) goto L82;
        if (this.mExecuteTasks.containItem(r100) == false) goto L17;
    L80:
        TTVideoEngineLog.d(TAG, "[preload] add the same key task.");
        return;
    L17:
        if (this.mPreloadTasks.containItem(r100) == true) goto L80;
        if (TTVideoEngineLog.d() == false) goto L22;
        TTVideoEngineLog.d(TAG, "[preload] _addTask key=" + r100 + ", videoId=" + r101 + ", preloadSize=" + r102 + ", vidItem=" + r110 + ", videoModelItem=" + r111 + ", urlItem=" + r112);
    L22:
        Resolution r103 = Resolution.Undefine;
        if (r110 == null) goto L27;
        Resolution r104 = r110.mResolution;
        if (r104 == null) goto L27;
    L26:
        r103 = r104;
    L31:
        String r105 = null;
        String r106 = "unknown";
        int r107 = -1;
        if (r112 != null) goto L34;
        if (r111 != null) goto L46;
        if (r110 != null) goto L57;
        String r108 = null;
    L67:
        DataLoaderTaskItem r109 = new DataLoaderTaskItem();
        r109.setUp(r100, r103, r102);
        r109.mVideoId = r101;
        r109.mVidItem = r110;
        r109.mVideoModelItem = r111;
        r109.mURLItem = r112;
        r109.mTag = r105;
        r109.mSubTag = r108;
        r109.mPlayIndexGap = r107;
        if (r112 == null) goto L70;
        r109.mPriorityLevel = r112.getPriorityLevel();
        r109.mGroupId = r112.getGroupId();
    L70:
        if (r111 == null) goto L73;
        r109.mResponseData = r111.mVideoModel;
        r109.mPriorityLevel = r111.getPriorityLevel();
        r109.mPreloadSecond = r111.mPreloadMilliSecond / 1000.0f;
        r109.mTimePreloadLowerLimitSize = r111.mTimePreloadLowerLimitSize;
        r109.mTimePreloadUpperLimitSize = r111.mTimePreloadUpperLimitSize;
        r109.mGroupId = r111.getGroupId();
        r109.mDashVideoPreloadSize = r111.getDashVideoPreloadSize();
        r109.mDashAudioPreloadSize = r111.getDashAudioPreloadSize();
    L73:
        if (r109.mVidItem == null) goto L76;
        r109.setListener(new MyTaskListener(this, this));
        r109.mPriorityLevel = r109.mVidItem.getPriorityLevel();
    L76:
        if (this.mPreloadTasks.enqueueItem(r109) == false) goto L78;
        _startExecuteTask();
        return;
    L78:
        r109._notifyError(-1002);
        return;
    L57:
        if (TextUtils.isEmpty(r110.getTag()) == true) goto L61;
        r106 = r110.getTag();
    L61:
        if (TextUtils.isEmpty(r110.getSubTag()) == true) goto L64;
        r105 = r110.getSubTag();
    L64:
        if (r110.getPlayIndexGap() != (-1)) goto L65;
    L43:
        String r113 = r106;
        r108 = r105;
        r105 = r113;
        goto L67
    L65:
        r107 = r110.getPlayIndexGap();
        goto L43
    L46:
        if (TextUtils.isEmpty(r111.getTag()) == true) goto L50;
        r106 = r111.getTag();
    L50:
        if (TextUtils.isEmpty(r111.getSubTag()) == true) goto L53;
        r105 = r111.getSubTag();
    L53:
        if (r111.getPlayIndexGap() == (-1)) goto L43;
        r107 = r111.getPlayIndexGap();
        goto L43
    L34:
        if (TextUtils.isEmpty(r112.getTag()) == true) goto L38;
        r106 = r112.getTag();
    L38:
        if (TextUtils.isEmpty(r112.getSubTag()) == true) goto L41;
        r105 = r112.getSubTag();
    L41:
        if (r112.getPlayIndexGap() == (-1)) goto L43;
        r107 = r112.getPlayIndexGap();
    L27:
        if (r111 == null) goto L31;
        r104 = r111.mResolution;
        if (r104 == null) goto L31;
        goto L31
    }

    public String downloadUrl(String r110, String r111, String[] r112, int r210, String r211, int r212) {
        if (TextUtils.isEmpty(r110) == true) goto L10;
        if (r112 != null) goto L6;
        return null;
    L6:
        if (r112.length >= 1) goto L9;
        return null;
    L9:
        return downloadProxyQuery(r110, r111, 0, 0, r112, r211, null, false, null, r210, 0, r212);
    L10:
        return null;
    }

    public String proxyUrl(String r210, String r211, String[] r212, Resolution r213, String r214, String r215) {
        return _proxyUrl(r210, r211, 0, r212, r213, r214, null, r215, null, false, false, null, 0, null, -1, null, false, -1);
    }

    private String proxyQuery(String r210, String r211, long r212, long r213, String[] r214, String r215, String r310, boolean r311, String r312, int r313, int r314) {
        return preloadProxyQuery(r210, r211, r212, r213, r214, r215, r310, 0, null, r311, r312, 0, 0, "", -1, r313, r314);
    }

    private String downloadProxyQuery(String r210, String r211, long r212, long r213, String[] r214, String r215, String r310, boolean r311, String r312, int r313, long r314, int r315) {
        return preloadProxyQuery(r210, r211, r212, r213, r214, r215, r310, 0, null, r311, r312, r313, r314, "", -1, -1, r315);
    }

    private String preloadProxyQuery(String r210, String r211, long r212, long r213, String[] r214, String r215, String r310, int r311, String r312, boolean r313, String r314, String r315, int r316, int r317) {
        return preloadProxyQuery(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, 0, 0, r315, r316, -1, r317);
    }

    private String preloadProxyQuery(String r110, String r111, long r112, long r210, String[] r211, String r212, String r213, int r214, String r215, boolean r216, String r217, int r310, long r311, String r312, int r313, int r314, int r315) {
        if (TextUtils.isEmpty(r110) == true) goto L108;
        if (r211 == null) goto L108;
        if (r211.length < 1) goto L108;
        String[] r100 = (String[]) r211.clone();
        if (r210 <= 0) goto L11;
        long r113 = r210;
    L12:
        int r114 = 0;
    L14:
        if (r114 >= r100.length) goto L19;
        if (_supportProxy(r100[r114]) == false) goto L17;
        r114 = r114 + 1;
        goto L14
    L17:
        return null;
    L19:
        String[] r101 = _removeRepeatUrls(r100);
        String r115 = TTHelper.encodeUrl(r110);
        if (TextUtils.isEmpty(r115) == false) goto L23;
        return null;
    L23:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L25;
        StringBuilder r116 = new StringBuilder("preloadProxyQuery: key = ");
        String r102 = r110;
        r116.append(r102);
        r116.append(", rawKey = ");
        String r103 = r111;
        r116.append(r103);
        TTVideoEngineLog.i(TAG, r116.toString());
    L27:
        if (TextUtils.isEmpty(r111) == false) goto L29;
        r103 = r102;
    L29:
        String r104 = TTHelper.encodeUrl(r103);
        if (TextUtils.isEmpty(r104) == false) goto L32;
        r104 = "videoId";
    L32:
        StringBuffer r105 = new StringBuffer();
        r105.append("?rk=");
        r105.append(r104);
        r105.append("&k=");
        r105.append(r115);
        if (r113 <= 0) goto L35;
        r105.append("&s=");
        r105.append(r112 + r113);
    L35:
        if (r214 <= 0) goto L38;
        r105.append("&l=");
        r105.append(r214);
    L38:
        if (TextUtils.isEmpty(r212) == true) goto L43;
        String r106 = TTHelper.encodeUrl(r212);
        if (TextUtils.isEmpty(r106) == true) goto L43;
        r105.append("&p=");
        r105.append(r106);
    L43:
        if (TextUtils.isEmpty(r215) == true) goto L48;
        String r107 = TTHelper.encodeUrl(r215);
        if (TextUtils.isEmpty(r107) == true) goto L48;
        r105.append("&h=");
        r105.append(r107);
    L48:
        if (TextUtils.isEmpty(r312) == true) goto L51;
        r105.append("&gid=");
        r105.append(r312);
    L51:
        if (r216 == false) goto L53;
    L56:
        boolean r108 = true;
    L57:
        if (r108 == false) goto L59;
        r105.append("&ft=1");
    L59:
        if (r310 <= 0) goto L62;
        r105.append("&ev=" + r310);
    L62:
        if (r311 <= 0) goto L65;
        r105.append("&ue=" + r311);
    L65:
        if (TextUtils.isEmpty(r217) == true) goto L69;
        String r109 = TTHelper.encodeUrl(r217);
        if (TextUtils.isEmpty(r109) == true) goto L69;
        r105.append("&dtk=");
        r105.append(r109);
    L69:
        if (r313 <= 0) goto L71;
        r105.append("&play_index_gap=" + r313);
    L71:
        if (r314 <= 0) goto L73;
        r105.append("&retry_err_cnt=" + r314);
    L73:
        if (r315 <= 0) goto L75;
        r105.append("&use_ori_en=1");
    L75:
        StringBuffer r117 = new StringBuffer();
        int r118 = 0;
    L77:
        if (r118 >= r101.length) goto L97;
        if (this.mConfigure.mEnableUseOriginalUrl == 1) goto L109;
        if (r315 > 0) goto L109;
        String r119 = encodeUrlByQuery(r101[r118]);
    L89:
        StringBuffer r120 = new StringBuffer();
        if (TextUtils.isEmpty(r119) == true) goto L93;
        r120.append("&u");
        r120.append(r118);
        r120.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r120.append(r119);
    L93:
        if ((((r105.length() + r117.length()) + r120.length()) + 32) > MAX_URL_LENGTH) goto L97;
        r117.append(r120);
        r118 = r118 + 1;
    L109:
        r119 = URLEncoder.encode(r101[r118], "UTF-8");     // Catch: UnsupportedEncodingException -> L85
    L86:
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(1) == false) goto L88;
        TTVideoEngineLog.d("TTHelperEncode", "encode failed:" + r101[r118]);
    L88:
        r119 = null;
    L97:
        if (r117.length() >= 1) goto L100;
        return null;
    L100:
        r105.append(r117);
        if (TextUtils.isEmpty(r213) == true) goto L106;
        if (((r105.length() + r213.length()) + 33) > MAX_URL_LENGTH) goto L106;
        r105.append("&");
        r105.append(r213);
    L106:
        return r105.toString();
    L53:
        if (FormatProvider.FormatProviderHolder.isM3u8(r101[0]) == true) goto L56;
        r108 = false;
        goto L57
    L25:
        r102 = r110;
        r103 = r111;
        goto L27
    L11:
        r113 = 0;
    L108:
        return null;
    }

    public String _proxyUrl(String r210, String r211, long r212, String[] r213, Resolution r214, String r215, VideoInfo r310, String r311, String r312, boolean r313, boolean r314, String r315, long r316, String[] r317, int r318, String r410, boolean r411, int r412) {
        return _proxyUrl(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, 0);
    }

    public String _proxyUrl(String r210, String r211, long r212, String[] r213, Resolution r310, String r311, VideoInfo r312, String r313, String r314, boolean r315, boolean r316, String r317, long r318, String[] r410, int r411, String r412, boolean r413, int r414, int r415) {
        if (this.mState == 0) goto L7;
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.StateError.ordinal();
        return null;
    L7:
        if (TextUtils.isEmpty(r210) == true) goto L104;
        if (r213 == null) goto L104;
        if (r213.length < 1) goto L104;
        String[] r110 = (String[]) r213.clone();
        int r100 = 0;
    L14:
        if (r100 >= r110.length) goto L21;
        if (_supportProxy(r110[r100], r415) == false) goto L17;
        r100 = r100 + 1;
        goto L14
    L17:
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.ProxyNotSupport.ordinal();
        TTVideoEngineLog.d(TAG, "not support");
        return r110[r100];
    L21:
        if (this.mInnerDataLoader != null) goto L25;
        TTVideoEngineLog.e(TAG, "start mdl first");
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.StateError.ordinal();
        return null;
    L25:
        if (this.mEnableHls != 1) goto L36;
        if (r316 == false) goto L28;
    L31:
        boolean r101 = true;
    L32:
        boolean r111 = r101;
        if (r101 == false) goto L35;
        boolean r102 = true;
    L37:
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.StateError.ordinal();
        this.mLock.lock(ABLock.TYPE_READ);
        String r103 = "";
        if (this.mCloseLocalServer == true) goto L41;
        r103 = this.mInnerDataLoader.getLocalAddr();     // Catch: Throwable -> L101
        if (TextUtils.isEmpty(r103) == true) goto L48;
    L45:
        String r104 = r103;
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L55;
        TTVideoEngineLog.i(TAG, "proxy url, mInvalidMdlProcotol: " + this.mInvalidMdlProcotol);     // Catch: Throwable -> L101
    L55:
        boolean r105 = this.mEnableMdlProtocol;     // Catch: Throwable -> L101
        if (this.mCloseLocalServer == false) goto L58;
    L62:
        if (r102 == false) goto L64;
    L68:
        boolean r112 = true;
    L70:
        if (this.mCloseLocalServer == false) goto L76;
        if (r112 == false) goto L76;
        TTVideoEngineLog.e(TAG, "use local server but local server closed");     // Catch: Throwable -> L101
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L76:
        String r106 = proxyQuery(r210, r211, 0, r212, r110, r313, r314, r111, r317, r411, r414);     // Catch: Throwable -> L101
        if (TextUtils.isEmpty(r106) == false) goto L80;
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L80:
        StringBuffer r107 = new StringBuffer();     // Catch: Throwable -> L101
        int r108 = this.mMdlDataSourceId;     // Catch: Throwable -> L101
        this.mMdlDataSourceId = r108 + 1;     // Catch: Throwable -> L101
        if (this.mEnableHLSProxy != 1) goto L84;
        int r109 = this.mEnableCheckHLSProxyVVCtrl;     // Catch: Throwable -> L101
    L84:
        if (r112 == false) goto L86;
        r107.append("http://");     // Catch: Throwable -> L101
        r107.append(r104);     // Catch: Throwable -> L101
        r107.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L101
        r107.append(r108);     // Catch: Throwable -> L101
    L87:
        r107.append(r106);     // Catch: Throwable -> L101
        StringBuffer r113 = new StringBuffer();     // Catch: Throwable -> L101
        r113.append(r106);     // Catch: Throwable -> L101
        String r114 = this.mInnerDataLoader.getAuth(r106);     // Catch: Throwable -> L101
        if (TextUtils.isEmpty(r114) == true) goto L90;
        r107.append("&ah=");     // Catch: Throwable -> L101
        r107.append(r114);     // Catch: Throwable -> L101
        r113.append("&ah=");     // Catch: Throwable -> L101
    L90:
        String r115 = r107.toString();     // Catch: Throwable -> L101
        if (TTVideoEngineLog.isPredicateLoglevelTurnOn(2) == false) goto L93;
        TTVideoEngineLog.i(TAG, "_proxyUrl: " + r115);     // Catch: Throwable -> L101
    L93:
        this.mLock.unlock(ABLock.TYPE_READ);
        DataLoaderTaskItem r116 = this.mAllPlayTasks.popItemForVideoId(r211);
        if (r116 != null) goto L96;
        r116 = new DataLoaderTaskItem();
    L96:
        DataLoaderTaskItem.TrackItem r117 = r116.addTrackItemByKey(r210);
        if (r117 == null) goto L99;
        r117.mTaskKey = r210;
        r116.mVideoId = r211;
        r117.mProxyUrl = r115;
        r117.mUsingResolution = r310;
        r117.mDecryptionKey = r311;
        r117.mVideoInfo = r312;
        r117.mUrls = r110;
        r117.mLocalFilePath = r313;
        r117.mExternalInfo = r314;
        r117.mUrlExpireTimes = r410;
        this.mAllPlayTasks.enqueueItem(r116);
    L99:
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.None.ordinal();
        return r115;
    L86:
        r107.append(MDL_PREFIX);     // Catch: Throwable -> L101
        r107.append("id");     // Catch: Throwable -> L101
        r107.append(r108);     // Catch: Throwable -> L101
        r107.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L101
        goto L87
    L64:
        if (this.mInvalidMdlProcotol == true) goto L68;
        if (r105 == false) goto L68;
        r112 = false;
        goto L70
    L58:
        if (this.mForbidNativeMDLForOriUrl == false) goto L62;
        if (TTHelper.isTranscodeUrlList(r110) == true) goto L62;
        TTVideoEngineLog.i(TAG, "url not transcode, not use native mdl");     // Catch: Throwable -> L101
        r105 = false;
        goto L62
    L48:
        TTVideoEngineLog.e(TAG, "local host error");     // Catch: Throwable -> L101
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L41:
        if (this.mInnerDataLoader.isRunning() == true) goto L45;
        TTVideoEngineLog.e(TAG, "dataloader is not running");     // Catch: Throwable -> L101
        this.mLock.unlock(ABLock.TYPE_READ);
        return null;
    L101:
        th = move-exception;
        this.mLock.unlock(ABLock.TYPE_READ);
        throw th;
    L35:
        r102 = r315;
        goto L37
    L28:
        if (FormatProvider.FormatProviderHolder.isM3u8(r110[0]) == true) goto L31;
        r101 = false;
        goto L32
    L36:
        r102 = r315;
        r111 = false;
    L104:
        this.mInvalidCode = IVideoEventLogger.MdlInvalidCode.ParamsWrong.ordinal();
        return null;
    }
}
