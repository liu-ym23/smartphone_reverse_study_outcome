package com.ss.ttvideoengine.selector.strategy;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.vcloud.abrmodule.ABRResult;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictor;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.info.HARInfo;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.selector.SelectedInfo;
import com.ss.ttvideoengine.strategrycenter.StrategyCenter;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class GearStrategy {
    public static final int GEAR_STRATEGY_DOWNGRADE_NARROW_SCREEN = 2;
    public static final int GEAR_STRATEGY_DOWNGRADE_NONE = 0;
    public static final int GEAR_STRATEGY_DOWNGRADE_SR = 1;
    public static final int GEAR_STRATEGY_ERROR_CONFIG_NULL = -6;
    public static final int GEAR_STRATEGY_ERROR_GEAR_STRATEGY_DISABLED = -7;
    public static final int GEAR_STRATEGY_ERROR_JSON_PARSE_FAIL = -1;
    public static final int GEAR_STRATEGY_ERROR_METHOD_CALLBACK_LISTENER_NULL = -5;
    public static final int GEAR_STRATEGY_ERROR_OK = 0;
    public static final int GEAR_STRATEGY_ERROR_STRATEGY_CENTER_NOT_RUNNING = -3;
    public static final int GEAR_STRATEGY_ERROR_STRATEGY_RESULT_NULL = -4;
    public static final int GEAR_STRATEGY_ERROR_VIDEO_INFO_EMPTY = -2;
    public static final String GEAR_STRATEGY_KEY_ABR_MAX_CACHE_BITRATE = "max_cache_bitrate";
    public static final String GEAR_STRATEGY_KEY_ABR_SR_INFO = "sr_info";
    public static final String GEAR_STRATEGY_KEY_ABR_STARTUP_AVERAGE_SPEED = "average_speed";
    public static final String GEAR_STRATEGY_KEY_ABR_STARTUP_BITRATE_BEFORE_FIT_SCREEN = "bitrate_before_fit_screen";
    public static final String GEAR_STRATEGY_KEY_ABR_STARTUP_INFO = "startup_info";
    public static final String GEAR_STRATEGY_KEY_ABR_STARTUP_PREDICT_SPEED = "predict_speed";
    public static final String GEAR_STRATEGY_KEY_ABR_STARTUP_SPEED = "startup_speed";
    public static final String GEAR_STRATEGY_KEY_ABR_VERSION = "abr_ver";
    public static final String GEAR_STRATEGY_KEY_AUDIO_BITRATE = "audio_bitrate";
    public static final String GEAR_STRATEGY_KEY_AUDIO_CALC_BITRATE = "audio_calc_bitrate";
    public static final String GEAR_STRATEGY_KEY_BLOCK_DOWNGRADE_BITRATE = "bdowngrade_bitrate";
    public static final String GEAR_STRATEGY_KEY_CONFIG_QUALITY = "config_quality";
    public static final String GEAR_STRATEGY_KEY_CURVE_ADJUST_FACTOR = "curve_adjust_factor";
    public static final String GEAR_STRATEGY_KEY_CURVE_ADJUST_MODE = "curve_adjust_mode";
    public static final String GEAR_STRATEGY_KEY_DOWNGRADE_TYPE = "downgrade_type";
    public static final String GEAR_STRATEGY_KEY_ERROR_CODE = "error_code";
    public static final String GEAR_STRATEGY_KEY_ERROR_DESC = "error_desc";
    public static final String GEAR_STRATEGY_KEY_EXTRA_CONFIG = "extra_config";
    public static final String GEAR_STRATEGY_KEY_EXTRA_INFO = "extra_info";
    public static final String GEAR_STRATEGY_KEY_INITIAL_SPEED = "initial_speed";
    public static final String GEAR_STRATEGY_KEY_SELECT_REASON = "select_reason";
    public static final String GEAR_STRATEGY_KEY_SPEED = "speed";
    public static final String GEAR_STRATEGY_KEY_SR_GEARS = "sr_gears";
    public static final String GEAR_STRATEGY_KEY_STRATEGY_MODULE = "strategy_module";
    public static final String GEAR_STRATEGY_KEY_STRATEGY_TYPE = "strategy_type";
    public static final String GEAR_STRATEGY_KEY_USER_ENTER_FULLSCREEN = "user_enter_fullscreen";
    public static final String GEAR_STRATEGY_KEY_USER_EXPECTED_BITRATE = "expected_bitrate";
    public static final String GEAR_STRATEGY_KEY_USER_QUALITY_SENSITIVITY = "user_quality_sen";
    public static final String GEAR_STRATEGY_KEY_USE_LAST_NETWORK_SPEED = "use_last_network_speed";
    public static final String GEAR_STRATEGY_KEY_VIDEO_BITRATE = "video_bitrate";
    public static final String GEAR_STRATEGY_KEY_VIDEO_BITRATE_BEFORE_CACHE = "video_bitrate_before";
    public static final String GEAR_STRATEGY_KEY_VIDEO_BITRATE_ORIGIN = "video_bitrarte_origin";
    public static final String GEAR_STRATEGY_KEY_VIDEO_BITRATE_USER_SELECTED = "video_bitrarte_user_selected";
    public static final String GEAR_STRATEGY_KEY_VIDEO_CALC_BITRATE = "video_calc_bitrate";
    public static final String GEAR_STRATEGY_KEY_VIDEO_QUALITY_DESC = "video_quality_desc";
    public static final String GEAR_STRATEGY_KEY_VIDEO_QUALITY_DESC_ORIGIN = "video_quality_desc_origin";
    public static final String GEAR_STRATEGY_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String GEAR_STRATEGY_KEY_VIDEO_RESOLUTION_ORIGIN = "video_resolution_origin";
    public static final int GEAR_STRATEGY_REASON_AUTO_BITRATE_SET = 3;
    public static final int GEAR_STRATEGY_REASON_BANDWIDTH_SET = 4;
    public static final int GEAR_STRATEGY_REASON_BEST_RESOLUTION_MAX_CACHE = 12;
    public static final int GEAR_STRATEGY_REASON_CALLBACK = 13;
    public static final int GEAR_STRATEGY_REASON_CONFIG_QUALITY_LOWEST = 11;
    public static final int GEAR_STRATEGY_REASON_Cache1 = 7;
    public static final int GEAR_STRATEGY_REASON_Cache2 = 8;
    public static final int GEAR_STRATEGY_REASON_DEFAULT_BITRATE = 2;
    public static final int GEAR_STRATEGY_REASON_DEFAULT_GEAR = 1;
    public static final int GEAR_STRATEGY_REASON_FALLBACK = 6;
    public static final int GEAR_STRATEGY_REASON_GEAR_SET = 5;
    public static final int GEAR_STRATEGY_REASON_PRELOAD_CACHE = 10;
    public static final int GEAR_STRATEGY_REASON_USER_SELECTED = 9;
    public static final int GEAR_STRATEGY_SELECT_METHOD_CALLBACK = 2;
    public static final int GEAR_STRATEGY_SELECT_METHOD_NATIVE = 1;
    public static final int GEAR_STRATEGY_SELECT_METHOD_NATIVE_ALL = 3;
    public static final int GEAR_STRATEGY_SELECT_TYPE_PLAY = 1;
    public static final int GEAR_STRATEGY_SELECT_TYPE_PRELOAD = 2;
    public static final String GEAR_STRATEGY_VALUE_CONFIG_QUALITY_DEFAULT = "1";
    public static final String GEAR_STRATEGY_VALUE_CONFIG_QUALITY_HIGH = "2";
    public static final String GEAR_STRATEGY_VALUE_CONFIG_QUALITY_LOW = "3";
    public static final String GEAR_STRATEGY_VALUE_CONFIG_QUALITY_LOW_LITE = "4";
    public static final String GEAR_STRATEGY_VALUE_CURVE_ADJUST_MODE_BITRATE = "2";
    public static final String GEAR_STRATEGY_VALUE_CURVE_ADJUST_MODE_SPEED = "1";
    public static final int KEY_4G_MAX_QUALITY_DESC = 20;
    public static final int KEY_4G_MAX_RESOLUTION = 19;
    public static final int KEY_ABR_AVERAGE_DOWNLOAD_SPEED = 39;
    public static final int KEY_ABR_AVERAGE_STARTUP_END_NETWORK_SPEED = 40;
    public static final int KEY_ABR_DOWNLOAD_SPEED = 36;
    public static final int KEY_ABR_FIXED_LEVEL = 45;
    public static final int KEY_ABR_FLOW_JSON = 53;
    public static final int KEY_ABR_NARROW_SCREEN_USE_WIDTH = 31;
    public static final int KEY_ABR_NETWORK_SPEED = 37;
    public static final int KEY_ABR_NETWORK_SPEED_CONFIDENCE = 38;
    public static final int KEY_ABR_ONCE_TYPE = 16;
    public static final int KEY_ABR_POOL_ENABLE = 56;
    public static final int KEY_ABR_PRELOAD_JSON = 54;
    public static final int KEY_ABR_STARTUP_BANDWIDTH_PARAMETER = 47;
    public static final int KEY_ABR_STARTUP_FIRST_PARAM = 48;
    public static final int KEY_ABR_STARTUP_FOURTH_PARAM = 51;
    public static final int KEY_ABR_STARTUP_JSON = 55;
    public static final int KEY_ABR_STARTUP_MODEL = 46;
    public static final int KEY_ABR_STARTUP_SECOND_PARAM = 49;
    public static final int KEY_ABR_STARTUP_SPEED_TYPE = 9;
    public static final int KEY_ABR_STARTUP_THIRD_PARAM = 50;
    public static final int KEY_ABR_STARTUP_USE_CACHE = 52;
    public static final int KEY_ABR_SWITCH_CS_MODEL = 44;
    public static final int KEY_ABR_USER_ENTER_FULL_SCREEN = 11;
    public static final int KEY_ABR_USER_QUALITY_SENSITIVITY = 10;
    public static final int KEY_ABR_WITH_SR = 12;
    public static final int KEY_CACHE_INFO = 57;
    public static final int KEY_DISPLAY_HEIGHT = 27;
    public static final int KEY_DISPLAY_WIDTH = 26;
    public static final int KEY_DOWNGRADE_QUALITY_DESC = 8;
    public static final int KEY_DOWNGRADE_RESOLUTION = 7;
    public static final int KEY_GEAR_STRATEGY_CONFIG = 3;
    public static final int KEY_GEAR_STRATEGY_MODULE = 2;
    public static final int KEY_GEAR_STRATEGY_SELECT_METHOD = 4;
    public static final int KEY_GEAR_STRATEGY_TYPE = 1;
    public static final int KEY_HAR_SCORE = 42;
    public static final int KEY_HAR_STATUS = 41;
    public static final int KEY_LOG_LEVEL = 33;
    public static final int KEY_QUICK_FILE_CACHE = 32;
    public static final int KEY_QUICK_GET_FILE_CACHE = 23;
    public static final int KEY_SCREEN_HEIGHT = 25;
    public static final int KEY_SCREEN_WIDTH = 24;
    public static final int KEY_SR_BENCHMARK = 15;
    public static final int KEY_SR_ENABLED = 13;
    public static final int KEY_SR_SATISFIED = 14;
    public static final int KEY_SR_STRATEGY_CONFIG = 30;
    public static final int KEY_SR_SUPPORT_BITRATE = 43;
    public static final int KEY_SUB_TAG = 29;
    public static final int KEY_TAG = 28;
    public static final int KEY_USER_DOWNGRADE_BITRATE = 35;
    public static final int KEY_USER_EXPECTED_BITRATE = 34;
    public static final int KEY_USER_EXPECTED_QUALITY_DESC = 6;
    public static final int KEY_USER_EXPECTED_RESOLUTION = 5;
    public static final int KEY_WIFI_DEFAULT_QUALITY_DESC = 18;
    public static final int KEY_WIFI_DEFAULT_RESOLUTION = 17;
    public static final int KEY_WIFI_MAX_RESOLUTION = 21;
    public static final int KEY_WIFI_MAX_RESOLUTION_QUALITY_DESC = 22;
    public static final String TAG = "TTVideoEngine.GearStrategy";
    private static GearStrategyConfig mGlobalConfig;
    private static LruCache<String, Map<Long, Map<String, Object>>> mPreloadCache;
    private static Lock mPreloadCacheLock;

    public GearStrategy() {
    }

    static {
        mGlobalConfig = new GearStrategyConfig();
        mPreloadCacheLock = new ReentrantLock();
        mPreloadCache = new LruCache(100);
    }

    public static GearStrategyConfig getGlobalConfig() {
        return mGlobalConfig;
    }

    public static Map<String, Object> parseABRResult(ABRResult r100) {
        return GearStrategyABR.parseABRResult(r100);
    }

    public static void setGlobalConfig(GearStrategyConfig r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        mGlobalConfig = r100;
        r100.parse();
        int r101 = mGlobalConfig.getIntValue(1, -1);
        int r102 = mGlobalConfig.getIntValue(2, -1);
        if (2 != r101) goto L9;
        if (1 != r102) goto L10;
        GearStrategyABR.setGlobalConfig(r100);
        return;
    L10:
        return;
    }

    public static JSONArray getMediaInfoJson(IVideoModel r100, int r101) {
        JSONArray r102 = new JSONArray();
        if (r100 != null) goto L5;
        return r102;
    L5:
        List<VideoInfo> r103 = r100.getVideoInfoList();
        if (r103 != null) goto L8;
    L35:
        return r102;
    L8:
        if (r103.size() == 0) goto L35;
        Iterator<VideoInfo> r104 = r103.iterator();     // Catch: Exception -> L33
    L11:
        if (r104.hasNext() == false) goto L35;
        VideoInfo r105 = r104.next();     // Catch: Exception -> L33
        if (r105 == null) goto L11;
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L33
        if (r105.getMediatype() != VideoRef.TYPE_VIDEO) goto L30;
        r106.put(GearStrategyConsts.EV_MEDIA_TYPE, r105.getMediatype());     // Catch: Exception -> L33
        r106.put("bitrate", r105.getValueInt(3));     // Catch: Exception -> L33
        Resolution r107 = r105.getResolution();     // Catch: Exception -> L33
        if (r107 == null) goto L22;
        int r108 = r107.getIndex();     // Catch: Exception -> L33
    L23:
        r106.put("res", r108);     // Catch: Exception -> L33
        r106.put(GearStrategyConsts.EV_QUALITY, r105.getValueStr(32));     // Catch: Exception -> L33
        r106.put("width", r105.getValueInt(1));     // Catch: Exception -> L33
        r106.put("height", r105.getValueInt(2));     // Catch: Exception -> L33
        if (r101 == (-1)) goto L31;
        String r109 = r105.getValueStr(15);     // Catch: Exception -> L33
        if (1 != r101) goto L28;
        long r110 = TTVideoEngine.quickGetCacheFileSize(r109);     // Catch: Exception -> L33
    L29:
        r106.put("cache", r110);     // Catch: Exception -> L33
        goto L31
    L28:
        r110 = TTVideoEngine.getCacheFileSize(r109);     // Catch: Exception -> L33
    L31:
        r102.put(r106);     // Catch: Exception -> L33
        goto L11
    L22:
        r108 = -1;
        goto L23
    L30:
        r106.put(GearStrategyConsts.EV_MEDIA_TYPE, r105.getMediatype());     // Catch: Exception -> L33
        r106.put("bitrate", r105.getValueInt(3));     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public static String getMediaInfoString(IVideoModel r100, int r101) {
        JSONArray r102 = getMediaInfoJson(r100, r101);
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.toString();
    }

    public static Map<String, Object> getPreloadInfo(String r100, long r101) {
        Map<String, Object> r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        mPreloadCacheLock.lock();
        Map<Long, Map<String, Object>> r103 = mPreloadCache.get(r100);
        if (r103 == null) goto L8;
        r102 = r103.get(Long.valueOf(r101));
    L8:
        mPreloadCacheLock.unlock();
        return r102;
    }

    public static IVideoInfo getVideoInfo(IVideoModel r100, long r101) {
        List<VideoInfo> r102 = r100.getVideoInfoList();
        if (r101 <= 0) goto L18;
        if (r102 == null) goto L18;
        Iterator<VideoInfo> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L18;
        VideoInfo r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.getMediatype() == VideoRef.TYPE_AUDIO) goto L7;
        if (r104.getResolution() == null) goto L7;
        if (r104.getValueInt(3) != r101) goto L7;
        return r104;
    L18:
        return null;
    }

    private static void speedInfoToStrategyParam(GearStrategyConfig r100, Map<String, String> r110) {
        ISpeedPredictor r101 = StrategyCenter.sNetAbrSpeedPredictor;
        float r102 = 0.0f;
        if (r101 == null) goto L10;
        Map<String, String> r103 = r101.getDownloadSpeed(VideoRef.TYPE_VIDEO);
        if (r103 != null) goto L7;
    L9:
        float r104 = StrategyCenter.sNetAbrSpeedPredictor.getPredictSpeed(0);
        float r105 = StrategyCenter.sNetAbrSpeedPredictor.getLastPredictConfidence();
        float r106 = StrategyCenter.sNetAbrSpeedPredictor.getAverageDownloadSpeed(VideoRef.TYPE_VIDEO, 1, true);
        float r107 = StrategyCenter.sNetAbrSpeedPredictor.getAverageDownloadSpeed(VideoRef.TYPE_VIDEO, r100.getIntValue(9, 4), false);
    L11:
        r110.put(Integer.toString(36), Float.toString(r102));
        r110.put(Integer.toString(37), Float.toString(r104));
        r110.put(Integer.toString(38), Float.toString(r105));
        r110.put(Integer.toString(39), Float.toString(r106));
        r110.put(Integer.toString(40), Float.toString(r107));
        return;
    L7:
        if (r103.get("download_speed") == null) goto L9;
        r102 = CastFloatProtector.parseFloat(r103.get("download_speed"));
        goto L9
    L10:
        r107 = 0.0f;
        r104 = 0.0f;
        r105 = 0.0f;
        r106 = 0.0f;
        goto L11
    }

    private static void srInfoToStrategyParam(GearStrategyConfig r100, Map<String, String> r101) {
        configIntToStrategyParam(r100, 13, r101, 0);
        configIntToStrategyParam(r100, 14, r101, 0);
        Object r102 = r100.getObjectValue(15, null);
        if (r102 == null) goto L20;
        JSONObject r103 = new JSONObject();
        Iterator r104 = ((Map) r102).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L19;
        Map.Entry r105 = (Map.Entry) r104.next();
        JSONArray r106 = new JSONArray();
        Object r107 = r105.getValue();
        if (r107 != null) goto L10;
    L34:
        r103.put(((Integer) r105.getKey()).toString(), r106);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L6
    L10:
        if ((r107 instanceof List) == false) goto L34;
        Iterator r108 = ((List) r107).iterator();
    L13:
        if (r108.hasNext() == false) goto L34;
        r106.put(((Integer) r108.next()).toString());
        goto L13
    L19:
        String r109 = r103.toString();
        r101.put(Integer.toString(15), r109);
    L20:
        Object r110 = r100.getObjectValue(43, null);
        if (r110 == null) goto L40;
        JSONObject r111 = new JSONObject();
        JSONArray r112 = new JSONArray();
        Iterator r113 = ((List) r110).iterator();
    L24:
        if (r113.hasNext() == false) goto L32;
        r112.put((Integer) r113.next());
        goto L24
    L32:
        r111.put("bitrates", r112);     // Catch: JSONException -> L28
    L30:
        r101.put(Integer.toString(43), r111.toString());
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    }

    private static void cacheInfoToStrategyParam(IVideoModel r100, GearStrategyConfig r101, Map<String, String> r110) {
        int r102 = r101.getIntValue(23);
        List<VideoInfo> r103 = r100.getVideoInfoList();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.size() == 0) goto L34;
        JSONObject r104 = new JSONObject();
        JSONArray r105 = new JSONArray();
        Iterator<VideoInfo> r106 = r103.iterator();     // Catch: JSONException -> L21
    L10:
        if (r106.hasNext() == false) goto L19;
        VideoInfo r107 = r106.next();     // Catch: JSONException -> L21
        if (r107 == null) goto L10;
        String r108 = r107.getValueStr(15);     // Catch: JSONException -> L21
        if (r102 != 1) goto L17;
        long r109 = TTVideoEngine.quickGetCacheFileSize(r108);     // Catch: JSONException -> L21
    L18:
        JSONObject r111 = new JSONObject();     // Catch: JSONException -> L21
        r111.put("bitrate", r107.getValueInt(3));     // Catch: JSONException -> L21
        r111.put("fileSize", r109);     // Catch: JSONException -> L21
        r105.put(r111);     // Catch: JSONException -> L21
        goto L10
    L17:
        r109 = TTVideoEngine.getCacheFileSize(r108);     // Catch: JSONException -> L21
        goto L18
    L19:
        r104.put("caches", r105);     // Catch: JSONException -> L21
    L23:
        r110.put(Integer.toString(57), r104.toString());
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private static void checkSRInfo(IVideoModel r100, GearStrategyConfig r101, Map<String, Object> r102) {
        Object r103 = r101.getObjectValue(30, null);
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof SRStrategyConfig) == false) goto L34;
        SRStrategyConfig r104 = (SRStrategyConfig) r103;
        SRStrategy r105 = new SRStrategy();
        boolean r106 = false;
        if (r100.hasFormat(IVideoModel.Format.DASH) == false) goto L9;
        int r107 = 2;
    L11:
        if (r100.hasFormat(IVideoModel.Format.MP4) == false) goto L13;
        r107 = r107 | 1;
    L13:
        r104.setCurrentVideoFormatType(r107);
        r104.setCurrentDuration(r100.getVideoRefInt(3));
        List<VideoInfo> r108 = r100.getVideoInfoList();
        if (r108 != null) goto L16;
    L25:
        r104.setIsHdr(r106);
        r105.updateConfig(r104);
        r101.setIntValue(13, r105.isSREnabled() ? 1 : 0);
        r101.setIntValue(14, r105.isSRSatisfied() ? 1 : 0);
        r101.setObjectValue(15, r105.getSRBenchmark());
        getSrSupportBitrate(r100, r105, r101);
        r102.put(SRStrategy.KEY_ENABLE_SR_STRATEGY, 1);
        r102.put(SRStrategy.KEY_ENABLE_ABR_SR, 1);
        r102.put(SRStrategy.KEY_SR_FAIL_REASON, Integer.valueOf(r105.getSRNotUseReason()));
        r102.put(SRStrategy.KEY_SR_SATISFIED, Integer.valueOf(r105.isSRSatisfied() ? 1 : 0));
        return;
    L16:
        if (r108.size() <= 0) goto L25;
        Iterator<VideoInfo> r109 = r108.iterator();
    L19:
        if (r109.hasNext() == false) goto L25;
        String r110 = r109.next().getValueStr(7);
        if (r110 == null) goto L19;
        if (r110.toLowerCase(Locale.getDefault()).contains("hdr") == false) goto L19;
        r106 = true;
        goto L25
    L9:
        r107 = 0;
        goto L11
    }

    public static void getSrSupportBitrate(IVideoModel r100, SRStrategy r101, GearStrategyConfig r102) {
        LinkedList r103 = new LinkedList();
        List<VideoInfo> r104 = r100.getVideoInfoList();
        if (r104 != null) goto L5;
    L17:
        r102.setObjectValueIfNotExist(43, r103);
        return;
    L5:
        if (r104.size() <= 0) goto L17;
        Iterator<VideoInfo> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L17;
        VideoInfo r106 = r105.next();
        if (r106 == null) goto L8;
        if (r106.getMediatype() != VideoRef.TYPE_VIDEO) goto L8;
        int r107 = r106.getValueInt(3);
        if (r101.videoInfoSupportSR(r106, r104).booleanValue() == false) goto L8;
        r103.add(Integer.valueOf(r107));
        goto L8
    }

    public static IVideoInfo getVideoInfoByBitrate(IVideoModel r100, int r101, int r102) {
        List<VideoInfo> r103 = r100.getVideoInfoList();
        if (r103 == null) goto L24;
        Iterator<VideoInfo> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L24;
        VideoInfo r105 = r104.next();
        if (r105 == null) goto L6;
        if (r105.getMediatype() == VideoRef.TYPE_AUDIO) goto L6;
        if (r105.getResolution() == null) goto L6;
        if (1 != r102) goto L19;
        long r106 = r105.getValueInt(44);
        if (r106 > 0) goto L22;
        int r107 = r105.getValueInt(3);
    L20:
        r106 = r107;
    L22:
        if (r106 != r101) goto L6;
        return r105;
    L19:
        r107 = r105.getValueInt(3);
    L24:
        return null;
    }

    public static int intMapGet(Map<String, Integer> r100, String r101, int r102) {
        Integer r103 = r100.get(r101);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.intValue();
    }

    public static Map<String, String> select(IVideoModel r210, int r211, GearStrategyConfig r212) {
        int r100 = r211;
        TTVideoEngineLog.i(TAG, "[GearStrategy]select selectType=" + r100);
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        int r103 = mGlobalConfig.getIntValue(1, -1);
        int r104 = mGlobalConfig.getIntValue(2, -1);
        r101.put(GEAR_STRATEGY_KEY_STRATEGY_TYPE, Integer.toString(r103));
        r101.put(GEAR_STRATEGY_KEY_STRATEGY_MODULE, Integer.toString(r104));
        r101.put(GEAR_STRATEGY_KEY_VIDEO_BITRATE, Integer.toString(0));
        r101.put(GEAR_STRATEGY_KEY_AUDIO_BITRATE, Integer.toString(0));
        r101.put("error_code", Integer.toString(0));
        if (r212 != null) goto L6;
        r101.put("error_code", Integer.toString(-6));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "config is null");
        return r101;
    L6:
        r212.parse();
        if (r210 != null) goto L10;
        r101.put("error_code", Integer.toString(-2));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "video info empty");
        return r101;
    L10:
        checkSRInfo(r210, r212, r102);
        int r105 = getBitrateFromVideoModel(r210, r212.getIntValue(5, -1), r212.getStringValue(6, ""), EngineGlobalConfig.getInstance().getEnableUseRealBitrate());
        r212.setIntValue(34, r105);
        r101.put(GEAR_STRATEGY_KEY_USER_EXPECTED_BITRATE, Integer.toString(r105));
        int r106 = getBitrateFromVideoModel(r210, r212.getIntValue(7, -1), r212.getStringValue(8, ""), EngineGlobalConfig.getInstance().getEnableUseRealBitrate());
        r212.setIntValue(35, r106);
        r101.put(GEAR_STRATEGY_KEY_BLOCK_DOWNGRADE_BITRATE, Integer.toString(r106));
        if (2 == r103) goto L13;
        int r107 = 0;
        GearStrategyContext r108 = new GearStrategyContext(null);
        Map<String, String> r109 = r212.getParam();
        GearStrategyConfig r110 = r212;
        int r111 = r110.getIntValue(4, -1);
        if (1 == r111) goto L31;
    L33:
        String r112 = mGlobalConfig.getExtraConfig();
        if (TextUtils.isEmpty(r112) == true) goto L36;
        r109.put(GEAR_STRATEGY_KEY_EXTRA_CONFIG, r112);
    L36:
        IVideoModel r113 = r210;
        r108.setVideoModel(r113);
        if (2 != r111) goto L44;
        IGearStrategyListener r114 = r212.getGearStrategyListener();
        if (r114 != null) goto L41;
        r101.put("error_code", Integer.toString(-5));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "select method is callback but listener is null");
        Map<String, Integer> r115 = null;
        r100 = r211;
    L47:
        if (r115 == null) goto L56;
        Integer r116 = r115.get("video");
        if (r116 == null) goto L51;
        int r117 = r116.intValue();
    L52:
        Integer r118 = r115.get("audio");
        if (r118 == null) goto L55;
        r107 = r118.intValue();
    L55:
        int r119 = r117;
    L57:
        r101.put(GEAR_STRATEGY_KEY_VIDEO_BITRATE, Integer.toString(r119));
        r101.put(GEAR_STRATEGY_KEY_AUDIO_BITRATE, Integer.toString(r107));
    L15:
        int r120 = 2;
    L58:
        if (r120 != r100) goto L60;
        setPreloadInfo(r113, r110, r101);
    L60:
        return r101;
    L51:
        r117 = 0;
        goto L52
    L56:
        r119 = 0;
        goto L57
    L41:
        r100 = r211;
        r115 = r114.selectBitrate(r113, r109, r100);
        r101.put(GEAR_STRATEGY_KEY_SELECT_REASON, Integer.toString(13));
        if (r115 != null) goto L47;
        r101.put("error_code", Integer.toString(-4));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "select result null");
        goto L47
    L44:
        r100 = r211;
        r115 = StrategyHelper.helper().selectResolution(r113, r100, r109, r108);
        if (r115 != null) goto L47;
        r101.put("error_code", Integer.toString(-4));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "select result null");
        goto L47
    L31:
        if (StrategyHelper.helper().isRunning() == true) goto L33;
        r101.put("error_code", Integer.toString(-3));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "strategy center not running");
        r120 = 2;
        r113 = r210;
        r100 = r211;
        goto L58
    L13:
        if (1 != r104) goto L16;
        GearStrategyABR.select(r210, r100, r212, r101);
        r113 = r210;
        r110 = r212;
        goto L15
    L16:
        Map<String, String> r121 = r212.getParam();
        configIntToStrategyParam(mGlobalConfig, 33, r121, 5);
        configIntToStrategyParam(r212, 34, r121, -1);
        configIntToStrategyParam(r212, 35, r121, -1);
        configIntToStrategyParam(r212, 24, r121, -1);
        configIntToStrategyParam(r212, 25, r121, -1);
        configIntToStrategyParam(r212, 26, r121, -1);
        configIntToStrategyParam(r212, 27, r121, -1);
        configIntToStrategyParam(r212, 31, r121, -1);
        configStringToStrategyParam(r212, 28, r121, "");
        configStringToStrategyParam(r212, 29, r121, "");
        speedInfoToStrategyParam(r212, r121);
        HARInfo r122 = TTVideoEngine.getHARInfo();
        if (r122 == null) goto L19;
        r121.put(Integer.toString(41), Integer.toString(r122.getHARStatus()));
        r121.put(Integer.toString(42), Integer.toString(r122.getHARScore()));
    L19:
        srInfoToStrategyParam(r212, r121);
        cacheInfoToStrategyParam(r210, r212, r121);
        if (StrategyHelper.helper().isRunning() == true) goto L23;
        r101.put("error_code", Integer.toString(-3));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "strategy center not running");
        return r101;
    L23:
        GearStrategyContext r123 = new GearStrategyContext(null);
        HashMap r124 = new HashMap();
        r123.setGearStrategyListener(new AnonymousClass1());
        TTVideoEngineLog.d(TAG, "[GearStrategy]before selectResolution param=" + new JSONObject(r121).toString());
        r123.setUserData(r124);
        Map<String, Integer> r125 = StrategyHelper.helper().selectResolution(r210, r100, r121, r123);
        if (r125 != null) goto L27;
        r101.put("error_code", Integer.toString(-4));
        r101.put(GEAR_STRATEGY_KEY_ERROR_DESC, "select result null");
        return r101;
    L27:
        TTVideoEngineLog.d(TAG, "[GearStrategy]after selectResolution res=" + new JSONObject(r125).toString());
        TTVideoEngineLog.d(TAG, "[GearStrategy]after selectResolution strategyResult=" + new JSONObject(r124).toString());
        int r126 = intMapGet(r125, "video", 0);
        int r127 = intMapGet(r125, "audio", 0);
        String r128 = stringMapGetString(r124, "video_bitrate_origin", Integer.toString(r126));
        String r129 = stringMapGetString(r124, GEAR_STRATEGY_KEY_DOWNGRADE_TYPE, Integer.toString(0));
        String r130 = stringMapGetString(r124, GEAR_STRATEGY_KEY_USER_QUALITY_SENSITIVITY, "-1.0");
        String r131 = stringMapGetString(r124, PortraitEngine.LABEL_USER_ENGER_FULL_SCREEN, "-1");
        String r132 = stringMapGetString(r124, GEAR_STRATEGY_KEY_ABR_MAX_CACHE_BITRATE, "-1");
        String r133 = stringMapGetString(r124, GEAR_STRATEGY_KEY_ABR_STARTUP_BITRATE_BEFORE_FIT_SCREEN, "-1");
        String r134 = stringMapGetString(r124, GEAR_STRATEGY_KEY_ABR_STARTUP_SPEED, "-1.0");
        String r135 = stringMapGetString(r124, "startup_predict_speed", "-1.0");
        String r136 = stringMapGetString(r124, "startup_average_speed", "-1.0");
        String r137 = stringMapGetString(r124, GEAR_STRATEGY_KEY_ABR_SR_INFO, "");
        String r138 = stringMapGetString(r124, GEAR_STRATEGY_KEY_ABR_STARTUP_INFO, "");
        r101.put(GEAR_STRATEGY_KEY_VIDEO_BITRATE, Integer.toString(r126));
        r101.put(GEAR_STRATEGY_KEY_AUDIO_BITRATE, Integer.toString(r127));
        r101.put(GEAR_STRATEGY_KEY_VIDEO_BITRATE_ORIGIN, r128);
        r101.put(GEAR_STRATEGY_KEY_DOWNGRADE_TYPE, r129);
        r101.put(GEAR_STRATEGY_KEY_USER_QUALITY_SENSITIVITY, r130);
        r101.put(GEAR_STRATEGY_KEY_USER_ENTER_FULLSCREEN, r131);
        r101.put(GEAR_STRATEGY_KEY_ABR_MAX_CACHE_BITRATE, r132);
        r101.put(GEAR_STRATEGY_KEY_ABR_STARTUP_BITRATE_BEFORE_FIT_SCREEN, r133);
        r101.put(GEAR_STRATEGY_KEY_ABR_STARTUP_SPEED, r134);
        r101.put(GEAR_STRATEGY_KEY_ABR_STARTUP_PREDICT_SPEED, r135);
        r101.put(GEAR_STRATEGY_KEY_ABR_STARTUP_AVERAGE_SPEED, r136);
        r101.put(GEAR_STRATEGY_KEY_ABR_SR_INFO, r137);
        r101.put(GEAR_STRATEGY_KEY_ABR_STARTUP_INFO, r138);
        r120 = 2;
        r113 = r210;
        r100 = r211;
        r110 = r212;
        goto L58
    }

    public static SelectedInfo selectBitrate(IVideoModel r110, int r111, Map<String, String> r112) {
        int r100 = 1;
        int r101 = 0;
        TTVideoEngineLog.i(TAG, String.format("[GearStrategy]GearStrategy.selectBitrate selectType=%d", new Object[]{Integer.valueOf(r111)}));
        VideoInfo r102 = null;
        Error r103 = null;
        GearStrategyContext r104 = new GearStrategyContext(null);
        r104.setVideoModel(r110);
        r104.setGearStrategyListener(new AnonymousClass2());
        r104.setUserData(r112);
        if (EngineGlobalConfig.getInstance().getEnableSelectStringMapMethod() != 1) goto L5;
        Map<String, Integer> r105 = StrategyHelper.helper().selectResolutionStringMap(r110, r111, r112, r104);
    L6:
        String r106 = r112.get(GEAR_STRATEGY_KEY_ERROR_DESC);
        if (r106 == null) goto L14;
        if (r106.isEmpty() == true) goto L14;
        r101 = CastIntegerProtector.parseInt(r112.get("error_code"));     // Catch: Exception -> L55
    L12:
        return new SelectedInfo(new Error(Error.Selector, r101, r106));
    L14:
        if (r105 == null) goto L50;
        Integer r107 = r105.get("video");
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L58:
        double r113 = CastDoubleProtector.parseDouble(r112.get(GEAR_STRATEGY_KEY_VIDEO_CALC_BITRATE));     // Catch: Exception -> L21
    L22:
        List<VideoInfo> r109 = r110.getVideoInfoList();
        if (r108 <= 0) goto L46;
        if (r109 == null) goto L46;
        Iterator<VideoInfo> r114 = r109.iterator();
    L27:
        if (r114.hasNext() == false) goto L46;
        VideoInfo r115 = r114.next();
        if (r115 == null) goto L27;
        if (r115.getMediatype() == VideoRef.TYPE_AUDIO) goto L27;
        if (r115.getResolution() == null) goto L27;
        if (r100 != EngineGlobalConfig.getInstance().getEnableUseRealBitrate()) goto L40;
        long r116 = r115.getValueInt(44);
        if (r116 > 0) goto L43;
        int r117 = r115.getValueInt(3);
    L41:
        r116 = r117;
    L43:
        if (r116 == r108) goto L47;
        r100 = 1;
    L47:
        if (r115 != null) goto L49;
        r103 = new Error(Error.Selector, Error.VideoInfoEmpty, "null video info fit bitrate");
    L49:
        Error r118 = r103;
        r102 = r115;
    L51:
        SelectedInfo r119 = new SelectedInfo(r102, r118);
        if (r113 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L54;
        r119.setDoubleValue(0, r113);
    L54:
        return r119;
    L40:
        r117 = r115.getValueInt(3);
    L46:
        r115 = null;
    L21:
        r113 = 0.0d;
        goto L22
    L18:
        r108 = 0;
        goto L58
    L50:
        r118 = new Error(Error.Selector, Error.StartupResultEmpty, "native select result null");
        r113 = 0.0d;
        goto L51
    L5:
        r105 = StrategyHelper.helper().selectResolution(r110, r111, r112, r104);
        goto L6
    }

    private static void setPreloadInfo(IVideoModel r100, GearStrategyConfig r101, Map<String, String> r102) {
        String r103 = r100.getVideoRefStr(2);
        HashMap r104 = new HashMap();
        r104.put("sw", Integer.valueOf(r101.getIntValue(24, -1)));
        r104.put("sh", Integer.valueOf(r101.getIntValue(25, -1)));
        r104.put("dw", Integer.valueOf(r101.getIntValue(26, -1)));
        r104.put("dh", Integer.valueOf(r101.getIntValue(27, -1)));
        r104.put("ue", Integer.valueOf(r101.getIntValue(34, -1)));
        r104.put("ud", Integer.valueOf(r101.getIntValue(35, -1)));
        r104.put("ns", Integer.valueOf(TTNetWorkListener.getInstance().getCurrentAccessType()));
        r104.put(GearStrategyConsts.EV_VIDEO_BITRATE_ORIGIN, Integer.valueOf(stringMapGetInt(r102, GEAR_STRATEGY_KEY_VIDEO_BITRATE_ORIGIN, -1)));
        int r105 = stringMapGetInt(r102, GEAR_STRATEGY_KEY_VIDEO_BITRATE, -1);
        r104.put(GearStrategyConsts.EV_VIDEO_BITRATE, Integer.valueOf(r105));
        r104.put(GearStrategyConsts.EV_DOWNGRADE_TYPE, Integer.valueOf(stringMapGetInt(r102, GEAR_STRATEGY_KEY_DOWNGRADE_TYPE, -1)));
        JSONArray r106 = getMediaInfoJson(r100, -1);
        if (r106 == null) goto L5;
        r104.put(GearStrategyConsts.EV_MEDIA_INFO, r106);
    L5:
        setPreloadInfo(r103, r105, r104);
    }

    public static float stringMapGetFloat(Map<String, String> r100, String r101, float r102) {
        String r103 = r100.get(r101);
        if (r103 == null) goto L9;
        return CastFloatProtector.parseFloat(r103);
    L10:
        return r102;
    L9:
        return r102;
    }

    public static int stringMapGetInt(Map<String, String> r100, String r101, int r102) {
        String r103 = r100.get(r101);
        if (r103 == null) goto L9;
        return CastIntegerProtector.parseInt(r103);
    L10:
        return r102;
    L9:
        return r102;
    }

    public static long stringMapGetLong(Map<String, String> r100, String r101, long r102) {
        String r103 = r100.get(r101);
        if (r103 == null) goto L9;
        return CastLongProtector.parseLong(r103);
    L10:
        return r102;
    L9:
        return r102;
    }

    public static String stringMapGetString(Map<String, String> r100, String r101, String r102) {
        String r103 = r100.get(r101);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103;
    }

    public static void setPreloadInfo(String r100, long r101, Map<String, Object> r102) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r102 == null) goto L12;
        mPreloadCacheLock.lock();
        Map<Long, Map<String, Object>> r103 = mPreloadCache.get(r100);
        if (r103 != null) goto L9;
        r103 = new HashMap();
        mPreloadCache.put(r100, r103);
    L9:
        r103.put(Long.valueOf(r101), r102);
        mPreloadCacheLock.unlock();
        return;
    L12:
        return;
    }

    private static void configIntToStrategyParam(GearStrategyConfig r100, int r101, Map<String, String> r102, int r103) {
        r102.put(Integer.toString(r101), Integer.toString(r100.getIntValue(r101, r103)));
    }

    private static void configStringToStrategyParam(GearStrategyConfig r100, int r101, Map<String, String> r102, String r103) {
        r102.put(Integer.toString(r101), r100.getStringValue(r101, r103));
    }

    public static int getBitrateFromVideoModel(IVideoModel r100, int r101, String r102, int r103) {
        Resolution r104 = Resolution.valueOf(r101);
        if (r104 == Resolution.Undefine) goto L5;
    L6:
        HashMap r105 = new HashMap();
        r105.put(32, r102);
        VideoInfo r106 = r100.getVideoInfo(r104, r105, false);
        if (r106 != null) goto L9;
    L12:
        return -1;
    L9:
        if (1 != r103) goto L15;
        return r106.getValueInt(44);
    L15:
        return r106.getValueInt(3);
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        goto L6
    }
}
