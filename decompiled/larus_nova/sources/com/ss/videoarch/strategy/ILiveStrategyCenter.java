package com.ss.videoarch.strategy;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface ILiveStrategyCenter {
    public static final int CommandAppGetPerformanceStrategy = 3;
    public static final int DISABLE = 0;
    public static final double DOUBLE_INITIAL_VALUE = -1.0d;
    public static final int ENABLE = 1;
    public static final int ENABLE_PULL_DOMAIN_HTTP_DNS = 1;
    public static final int ENABLE_PUSH_AND_PULL_HTTP_DNS = 2;
    public static final int ENABLE_PUSH_DOMAIN_HTTP_DNS = 0;
    public static final float FLOAT_INITIAL_VALUE = -1.0f;
    public static final int INT_INITIAL_VALUE = -1;
    public static final int INT_MAX_VALUE = Integer.MAX_VALUE;
    public static final int IPV4_ONLY = 0;
    public static final int IPV6_ONLY = 1;
    public static final int IP_DUAL = 2;
    public static final int LIVE_ABR_SWITCH_STRATEGY = 23;
    public static final int LIVE_ENABLE_SUGGEST_QUIC = 26;
    public static final int LIVE_GET_IPLIST_BY_KEY = 24;
    public static final int LIVE_GET_MULTI_PATH_METRICS = 404;
    public static final int LIVE_GET_REQUEST_ID = 28;
    public static final int LIVE_GET_RETRY_BUFFER = 27;
    public static final int LIVE_GET_STARTUP_GEAR = 2;
    public static final int LIVE_IO_MULTI_PATH_GET_INFO = 402;
    public static final int LIVE_IO_MULTI_PATH_SET_INFO = 403;
    public static final int LIVE_IO_NOTIFY_LOADED = 405;
    public static final int LIVE_IO_SOCKET_ACCELERATE = 406;
    public static final int LIVE_NET_EFFECTIVE_CONNECTIONTYPE_STRATEGY = 14;
    public static final int LIVE_NET_IPV6_PROBE = 16;
    public static final int LIVE_NET_NQE_INFO = 18;
    public static final int LIVE_NET_UDP_PROBE = 17;
    public static final int LIVE_OPEN_OPTIMIZER = 13;
    public static final int LIVE_OPEN_PRECONNECT = 15;
    public static final int LIVE_PROBE_STARTUP_BITRATE = 21;
    public static final int LIVE_PULL_EVENT_OF_FIRST_FRAME = 61;
    public static final int LIVE_PULL_EVENT_OF_PLAY_STOP = 63;
    public static final int LIVE_PULL_EVENT_OF_STALL = 62;
    public static final int LIVE_PULL_EVENT_OF_START_PLAY = 60;
    public static final String LIVE_PULL_PROJECT_KEY = "2";
    public static final String LIVE_PUSH_PROJECT_KEY = "1";
    public static final int LIVE_SET_DEVICE_FEATURE = 408;
    public static final int LIVE_SET_MULTI_PATH = 401;
    public static final int LIVE_SET_PLAYER_INFO = 407;
    public static final int LIVE_SET_PULLSTREAM_QUALITY = 411;
    public static final int LIVE_SMOOTH_SWITCH_STRATEGY = 22;
    public static final int LIVE_SOCKET_BUFFER = 25;
    public static final int LIVE_SR_PREDICT_RESULT = 19;
    public static final int LIVE_START_PLAY_BUFFER = 12;
    public static final int LIVE_STRATEGY_CALLER_OF_APP_PLAY = 4;
    public static final int LIVE_STRATEGY_CALLER_OF_APP_PUSH = 5;
    public static final int LIVE_STRATEGY_CHARACTER_FETCH = 52;
    public static final int LIVE_STRATEGY_CONFIG = 51;
    public static final int LIVE_STRATEGY_DEFAULT_IP_TYPE = -1;
    public static final int LIVE_STRATEGY_FS_TIME = 11;
    public static final int LIVE_STRATEGY_IPV4_TYPE = 0;
    public static final int LIVE_STRATEGY_IPV6_TYPE = 1;
    public static final int LIVE_STRATEGY_IP_ALL_TYPE = 2;
    public static final int LIVE_STRATEGY_IS_HTTPDNS_READY = 55;
    public static final int LIVE_STRATEGY_OF_LIVE_CORE_SDK = 1;
    public static final int LIVE_STRATEGY_OF_LIVE_IO_SDK = 2;
    public static final int LIVE_STRATEGY_OF_LIVE_PLAYER_SDK = 0;
    public static final int LIVE_STRATEGY_OF_RTS_PLAYER_SDK = 3;
    public static final int LIVE_STRATEGY_SEND_DNS_REQUEST = 57;
    public static final int LIVE_STRATEGY_SEND_DNS_REQUEST_BY_HOST = 58;
    public static final int LIVE_STRATEGY_SET_CONFIG_TO_LIVEIO = 54;
    public static final int LIVE_STRATEGY_SET_PRE_PROCESSOR_TOGGLE = 103;
    public static final int LIVE_STRATEGY_SET_ROOM_INFO_WITH_RESOLUTION = 104;
    public static final int LIVE_STREAM_PREPROCESS = 50;
    public static final int LIVE_TRANS_PARAMS = 20;
    public static final long LONG_INITIAL_VALUE = -1;
    public static final int LiveStrategyCallerAppGeneral = 6;
    public static final int LiveStrategyCallerAppPlay = 4;
    public static final int LiveStrategyCallerAppPush = 5;
    public static final int LiveStrategyCallerInnerPlatformBridge = 1001;
    public static final int LiveStrategyCallerInnerStart = 1000;
    public static final int LiveStrategyCallerLiveCore = 1;
    public static final int LiveStrategyCallerLiveIO = 2;
    public static final int LiveStrategyCallerLivePlayer = 0;
    public static final int LiveStrategyCallerRTSPlayer = 3;
    public static final int LiveStrategyCommandAppGetStartupGear = 2;
    public static final int LiveStrategyCommandAppRefreshRoomList = 409;
    public static final int LiveStrategyCommandAppSetDeviceFeature = 408;
    public static final int LiveStrategyCommandAppSetPlayerInfo = 407;
    public static final int LiveStrategyCommandAppSetPreprocessor = 1;
    public static final int LiveStrategyCommandAppSocketAccelerate = 406;
    public static final int LiveStrategyCommandAppStart = 0;
    public static final int LiveStrategyCommandGetProjectSettings = 30005;
    public static final int LiveStrategyCommandInnerStart = 30000;
    public static final int LiveStrategyCommandLiveIOGetNeptuneReqInfo = 30001;
    public static final int LiveStrategyCommandMakeABRDecisionAsync = 10006;
    public static final int LiveStrategyCommandPlayerGetNodeOptimizeInfo = 10001;
    public static final int LiveStrategyCommandPlayerStart = 10000;
    public static final int LiveStrategyCommandPusherStart = 20000;
    public static final int LiveStrategyCommandUpdateAppForegroundState = 30004;
    public static final int LiveStrategyCommandUpdateCellularProvider = 30003;
    public static final int LiveStrategyCommandUpdateNetworkType = 30002;
    public static final int NETWORK_Type_MOBILE = 1;
    public static final int NETWORK_Type_MOBILE_2G = 2;
    public static final int NETWORK_Type_MOBILE_3G = 3;
    public static final int NETWORK_Type_MOBILE_4G = 5;
    public static final int NETWORK_Type_NONE = 0;
    public static final int NETWORK_Type_UNKNOWN = -1;
    public static final int NETWORK_Type_WIFI = 4;
    public static final int NOTIFY_MSG_BLACK_IP = 500;
    public static final int NOTIFY_MSG_PRECONN_RESULT = 0;
    public static final int NativeNetworkTypeCellular = 3;
    public static final int NativeNetworkTypeEthernet = 4;
    public static final int NativeNetworkTypeUnknown = 0;
    public static final int NativeNetworkTypeUnreachable = 1;
    public static final int NativeNetworkTypeWifi = 2;
    public static final int PLAYER_COMMAND_START = 10000;
    public static final int PLAYER_GET_HOST_IP_LIST = 10002;
    public static final int PLAYER_GET_NODE_OPTIMIZE_INFO = 10001;
    public static final int PLAYER_GET_STRATEGY_CONFIG = 10004;
    public static final int PLAYER_NOTIFY_IP_ERROR = 10003;
    public static final String SDK_APP_ID = "330361";
    public static final String SDK_APP_ID_OVERSEA = "330360";

    JSONObject PreProcessor(String r100, String r101, JSONObject r102);

    void doLocalDnsOperator(Context r100);

    JSONObject executeCommand(int r100, int r101, int r102, JSONObject r103);

    String getConfigAndStrategyBundle(int r100, JSONObject r101);

    <T> T getConfigAndStrategyByKeyInt(int r100, int r101, T r102, JSONObject r103);

    <T> T getConfigAndStrategyByKeyStr(int r100, String r101, T r102, JSONObject r103);

    JSONObject getConfigAndStrategyJson(int r100, JSONObject r101);

    <T> T getInfo(String r100, T r101);

    String getPreconnResult(String r100);

    String getStrategyCenterABTraceInfo();

    String getStrategyCenterCommonTraceInfo();

    void notifyInfo(int r100, int r101, String r102);

    void notifyInfo(int r100, int r101, JSONObject r102);

    void releaseFeatureDataBundle(String r100);

    void setAppInfoBundle(IAppInfoBundle r100);

    void setEventInfo(int r100, JSONObject r101);

    void setFeatureDataBundle(String r100, IAppInfoBundle r101);

    void setFunctionStartPTYInit(IFunctionStartPTYInit r100);

    void setIFunctionCalledByStrategyEngine(IFunctionCalledByStrategyEngine r100);

    void setRoomInfo(String r100, int r101, long r102);

    void setStreamInfo(String r100, String r101, String r102);

    void setSupportSRScene(boolean r100);

    void start();

    void stop();

    void stopSession(JSONObject r100);

    void triggerSRPredict(JSONObject r100);
}
