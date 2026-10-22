package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public class ABRConfig {
    public static final int ABR_4G_MAX_BITRATE_KEY = 2;
    public static final int ABR_BANDWIDTH_PARAMETER_KEY = 11;
    public static final int ABR_DEFAULT_WIFI_BITRATE = 12;
    public static final int ABR_FIXED_LEVEL = 4;
    public static final int ABR_FIXED_LEVEL_DEFAULT = 2;
    public static final int ABR_FIXED_LEVEL_HIGH = 3;
    public static final int ABR_FIXED_LEVEL_HIGHER = 4;
    public static final int ABR_FIXED_LEVEL_LOW = 1;
    public static final int ABR_FIXED_LEVEL_LOWER = 0;
    public static final int ABR_FIXED_LEVEL_NORMAL = 2;
    public static final int ABR_LOG_LEVEL_KEY = 0;
    public static final int ABR_ONCE_TYPE_B2BMODEL = 0;
    public static final int ABR_ONCE_TYPE_BABBONCE = 1;
    public static final int ABR_ONCE_TYPE_BWONCE = 2;
    public static final int ABR_ONCE_TYPE_CSONCE = 3;
    public static final int ABR_ONCE_TYPE_DEFAULT = 0;
    public static final int ABR_PLAYER_DISPLAY_HEIGHT_KEY = 7;
    public static final int ABR_PLAYER_DISPLAY_WIDTH_KEY = 6;
    public static final int ABR_SELECT_SCENE = 14;
    public static final int ABR_STALL_PENALTY_PARAMETER_KEY = 9;
    public static final int ABR_STARTUP_BANDWIDTH_PARAMETER_KEY = 8;
    public static final int ABR_STARTUP_MAX_BITRATE = 13;
    public static final int ABR_STARTUP_MODEL_AVGNET = 6;
    public static final int ABR_STARTUP_MODEL_AVGSENET = 7;
    public static final int ABR_STARTUP_MODEL_CACHE = 5;
    public static final int ABR_STARTUP_MODEL_COMPATIBLE = 4;
    public static final int ABR_STARTUP_MODEL_DEFAULT = 0;
    public static final int ABR_STARTUP_MODEL_DYNAMIC = 3;
    public static final int ABR_STARTUP_MODEL_HIGH = 1;
    public static final int ABR_STARTUP_MODEL_HIGHER = 2;
    public static final int ABR_STARTUP_MODEL_KEY = 5;
    public static final int ABR_STARTUP_MODEL_NORMAL = 0;
    public static final int ABR_SWITCH_MODEL_DEFAULT = 1;
    public static final int ABR_SWITCH_MODEL_DYNAMIC = 5;
    public static final int ABR_SWITCH_MODEL_FIXED = 0;
    public static final int ABR_SWITCH_MODEL_KEY = 3;
    public static final int ABR_SWITCH_MODEL_NORMAL = 1;
    public static final int ABR_SWITCH_MODEL_SLOW = 2;
    public static final int ABR_SWITCH_MODEL_SLOWER = 3;
    public static final int ABR_SWITCH_MODEL_VERYSLOW = 4;
    public static final int ABR_SWITCH_PENALTY_PARAMETER_KEY = 10;
    public static final int ABR_SWITCH_SENSITIVITY_DEFAULT = 0;
    public static final int ABR_SWITCH_SENSITIVITY_HIGH = 1;
    public static final int ABR_SWITCH_SENSITIVITY_HIGHER = 2;
    public static final int ABR_SWITCH_SENSITIVITY_KEY = 1;
    public static final int ABR_SWITCH_SENSITIVITY_NORMAL = 0;
    public static final int AVERAGE_DOWNLOAD_SPEED = 1;
    public static final int AVERAGE_EMA_DOWNLOAD_SPEED = 2;
    public static final int AVERAGE_EMA_STARTUP_DOWNLOAD_SPEED = 3;
    public static final int AVERAGE_EMA_STARTUP_END_DOWNLOAD_SPEED = 4;
    public static final int AVERAGE_WINDOW_DOWNLOAD_SPEED = 0;
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_DEFAULT = 3;
    public static final int LOG_LEVEL_ERROR = 4;
    public static final int LOG_LEVEL_FATAL = 5;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_VERBOSE = 0;
    public static final int LOG_LEVEL_WARN = 3;
    private static String sAbrFlowJson = null;
    private static String sAbrPreloadJson = null;
    private static String sAbrStartupJson = null;
    private static float sBandwidthParameter = 1.0f;
    private static int sFixedLevel = 2;
    private static int sLogLevel = 3;
    private static int sNarrowScreenUseWidth = 0;
    private static float sStallPenaltyParameter = 9.0f;
    private static float sStartupBandwidthParameter = 0.9f;
    private static int sStartupModel = 0;
    private static double sStartupModelFirstParam = 0.0d;
    private static double sStartupModelFourthParam = 69.0106422d;
    private static double sStartupModelSecondParam = 2.67952228E-5d;
    private static double sStartupModelThirdParam = 0.151840652d;
    private static int sStartupUseCache = 0;
    private static int sSwitchModel = 1;
    private static float sSwitchPenaltyParameter = 2.0f;
    private static int sSwitchSensitivity;

    public ABRConfig() {
    }

    public static String getAbrFlowJson() {
        return sAbrFlowJson;
    }

    public static String getAbrPreloadJson() {
        return sAbrPreloadJson;
    }

    public static String getAbrStartupJson() {
        return sAbrStartupJson;
    }

    public static float getBandwidthParameter() {
        return sBandwidthParameter;
    }

    public static int getFixedLevel() {
        return sFixedLevel;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static int getNarrowScreenUseWidth() {
        return sNarrowScreenUseWidth;
    }

    public static float getStallPenaltyParameter() {
        return sStallPenaltyParameter;
    }

    public static float getStartupBandwidthParameter() {
        return sStartupBandwidthParameter;
    }

    public static int getStartupModel() {
        return sStartupModel;
    }

    public static double getStartupModelFirstParam() {
        return sStartupModelFirstParam;
    }

    public static double getStartupModelFourthParam() {
        return sStartupModelFourthParam;
    }

    public static double getStartupModelSecondParam() {
        return sStartupModelSecondParam;
    }

    public static double getStartupModelThirdParam() {
        return sStartupModelThirdParam;
    }

    public static int getStartupUseCache() {
        return sStartupUseCache;
    }

    public static int getSwitchModel() {
        return sSwitchModel;
    }

    public static float getSwitchPenaltyParameter() {
        return sSwitchPenaltyParameter;
    }

    public static int getSwitchSensitivity() {
        return sSwitchSensitivity;
    }

    public static void setAbrFlowJson(String r100) {
        sAbrFlowJson = r100;
    }

    public static void setAbrPreloadJson(String r100) {
        sAbrPreloadJson = r100;
    }

    public static void setAbrStartupJson(String r100) {
        sAbrStartupJson = r100;
    }

    public static void setBandwidthParameter(float r100) {
        sBandwidthParameter = r100;
    }

    public static void setFixedLevel(int r100) {
        sFixedLevel = r100;
    }

    public static void setLoglevel(int r100) {
        sLogLevel = r100;
    }

    public static void setNarrowScreenUseWidth(int r100) {
        sNarrowScreenUseWidth = r100;
    }

    public static void setStallPenaltyParameter(float r100) {
        sStallPenaltyParameter = r100;
    }

    public static void setStartupBandwidthParameter(float r100) {
        sStartupBandwidthParameter = r100;
    }

    public static void setStartupModel(int r100) {
        sStartupModel = r100;
    }

    public static void setStartupModelFirstParam(double r100) {
        sStartupModelFirstParam = r100;
    }

    public static void setStartupModelFourthParam(double r100) {
        sStartupModelFourthParam = r100;
    }

    public static void setStartupModelSecondParam(double r100) {
        sStartupModelSecondParam = r100;
    }

    public static void setStartupModelThirdParam(double r100) {
        sStartupModelThirdParam = r100;
    }

    public static void setStartupUseCache(int r100) {
        sStartupUseCache = r100;
    }

    public static void setSwitchModel(int r100) {
        sSwitchModel = r100;
    }

    public static void setSwitchPenaltyParameter(float r100) {
        sSwitchPenaltyParameter = r100;
    }

    public static void setSwitchSensitivity(int r100) {
        sSwitchSensitivity = r100;
    }
}
