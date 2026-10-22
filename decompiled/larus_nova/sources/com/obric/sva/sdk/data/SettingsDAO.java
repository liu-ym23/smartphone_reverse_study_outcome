package com.obric.sva.sdk.data;

import android.content.Intent;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.sva.framework.wrapper.SystemPropertiesWrapper;
import com.obric.sva.sdk.utils.LogUtils;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes6.dex */
public final class SettingsDAO {
    private static final Intent DEFAULT_ACTION_INTENT = null;
    private static final String DEFAULT_ACTION_NAME = "None";
    private static final boolean DEFAULT_DETECTION_TONE_ENABLED = true;
    private static final int DEFAULT_GLOBAL_GMM_TRAINING_CONFIDENCE_LEVEL = 50;
    private static final int DEFAULT_GLOBAL_SM2_1ST_KEYPHRASE_CONFIDENCE_LEVEL = 69;
    private static final int DEFAULT_GLOBAL_SM2_1ST_USER_CONFIDENCE_LEVEL = 69;
    private static final int DEFAULT_GLOBAL_SM3_1ST_KEYPHRASE_CONFIDENCE_LEVEL = 56;
    private static final int DEFAULT_GLOBAL_SM3_1ST_USER_CONFIDENCE_LEVEL = 69;
    private static final int DEFAULT_GLOBAL_SM3_2ND_KEYPHRASE_CONFIDENCE_LEVEL = 35;
    private static final int DEFAULT_GLOBAL_SM3_2ND_USER_CONFIDENCE_LEVEL = 10;
    private static final int DEFAULT_GLOBAL_TRAINING_PATH = 6;
    private static final int DEFAULT_HIST_BUFFER_TIME = 2000;
    private static final boolean DEFAULT_IS_DISPLAY_ADVANCED_DETAILS = true;
    private static final boolean DEFAULT_OPAQUE_DATA_TRANSFER_ENABLED = false;
    private static final int DEFAULT_PRE_ROLL_DURATION = 500;
    private static final boolean DEFAULT_USER_VERIFICATION_ENABLED = false;
    private static final boolean DEFAULT_VOICE_REQUEST_ENABLED = true;
    private static final int DEFAULT_VOICE_REQUEST_LENGTH = 3000;
    public static final String HARDWARE = "ro.hardware";
    private static final String KEY_1ST_KEYPHRASE_CONFIDENCE_LEVEL = "1st_keyphrase_confidence_level";
    private static final String KEY_1ST_USER_CONFIDENCE_LEVEL = "1st_user_confidence_level";
    private static final String KEY_2ND_KEYPHRASE_CONFIDENCE_LEVEL = "2nd_keyphrase_confidence_level";
    private static final String KEY_2ND_USER_CONFIDENCE_LEVEL = "2nd_user_confidence_level";
    private static final String KEY_ACTION_INTENT = "action_intent";
    private static final String KEY_ACTION_NAME = "action_name";
    private static final String KEY_BASE_SOUND_MODEL = "base_sound_model";
    private static final String KEY_CURRENT_SOUNDMODEL = "current_soundmodel";
    private static final String KEY_GLOBAL_DETECTION_TONE_ENABLED = "global_detection_tone_enabled";
    private static final String KEY_GLOBAL_GMM_TRAINING_CONFIDENCE_LEVEL = "global_gmm_training_confidence_level";
    private static final String KEY_GLOBAL_IS_DISPLAY_ADVANCED_DETAILS = "global_is_display_advanced_details";
    private static final String KEY_GLOBAL_SM2_1ST_KEYPHRASE_CONFIDENCE_LEVEL = "global_sm2_1st_keyphrase_confidence_level";
    private static final String KEY_GLOBAL_SM2_1ST_USER_CONFIDENCE_LEVEL = "global_sm2_1st_user_confidence_level";
    private static final String KEY_GLOBAL_SM3_1ST_KEYPHRASE_CONFIDENCE_LEVEL = "global_sm3_1st_keyphrase_confidence_level";
    private static final String KEY_GLOBAL_SM3_1ST_USER_CONFIDENCE_LEVEL = "global_sm3_1st_user_confidence_level";
    private static final String KEY_GLOBAL_SM3_2ND_KEYPHRASE_CONFIDENCE_LEVEL = "global_sm3_2nd_keyphrase_confidence_level";
    private static final String KEY_GLOBAL_SM3_2ND_USER_CONFIDENCE_LEVEL = "global_sm3_2nd_user_confidence_level";
    private static final String KEY_GLOBAL_TRAINING_PATH = "global_training_path";
    private static final String KEY_HIST_BUFFER_TIME_IN_MILLI_SEC = "hist_buffer_time_in_milli_sec";
    private static final String KEY_OPAQUE_DATA_TRANSFER_ENABLED = "opaque_data_transfer_enabled";
    private static final String KEY_PRE_ROLL_DURATION_IN_MILLI_SEC = "pre_roll_duration_in_milli_sec";
    private static final String KEY_USER_VERIFICATION_ENABLED = "user_verification_enabled";
    private static final String KEY_VOICE_REQUEST_ENABLED = "voice_request_enabled";
    private static final String KEY_VOICE_REQUEST_LENGTH_IN_MILLISEC = "voice_request_len_in_millisec";
    public static final String NAME_HEYSNAPDRAGON_BREATH_MODEL = "lp_engine_res_adsp_breath.uim";
    public static final String NAME_HEYSNAPDRAGON_VOICE_MODEL = "lp_engine_res_adsp_voice.uim";
    private static final String TAG = null;
    private static final int TYPE_1ST_KEYPHRASE = 1;
    private static final int TYPE_1ST_USER = 2;
    private static final int TYPE_2ND_KEYPHRASE = 3;
    private static final int TYPE_2ND_USER = 4;

    public static String getCurrentSoundModel(SharedPreferences r100) {
        return NAME_HEYSNAPDRAGON_VOICE_MODEL;
    }

    private static String getModelkey(int r100) {
        if (r100 != 1) goto L5;
        return KEY_1ST_KEYPHRASE_CONFIDENCE_LEVEL;
    L5:
        if (r100 != 2) goto L7;
        return KEY_1ST_USER_CONFIDENCE_LEVEL;
    L7:
        if (r100 != 3) goto L9;
        return KEY_2ND_KEYPHRASE_CONFIDENCE_LEVEL;
    L9:
        if (r100 == 4) goto L11;
        return null;
    L11:
        return KEY_2ND_USER_CONFIDENCE_LEVEL;
    }

    public static boolean getUserVerificationEnabled(SharedPreferences r100) {
        return false;
    }

    static {
        TAG = "SettingsDAO";
        DEFAULT_ACTION_INTENT = null;
    }

    private SettingsDAO() {
    }

    public static Intent getActionIntent(SharedPreferences r100) {
        if (r100 != null) goto L6;
        LogUtils.d(TAG, "getActionIntent: invalid param", new Object[0]);
        return DEFAULT_ACTION_INTENT;
    L6:
        Intent r101 = null;
        String r102 = r100.getString(KEY_ACTION_INTENT, null);     // Catch: URISyntaxException -> L11
        if (r102 == null) goto L13;
        r101 = Intent.parseUri(r102, 0);     // Catch: URISyntaxException -> L11
    L13:
        LogUtils.d(TAG, "getActionIntent: result = " + r101, new Object[0]);
        return r101;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static String getActionName(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getActionName: invalid param", new Object[0]);
        return DEFAULT_ACTION_NAME;
    L7:
        return r100.getString(KEY_ACTION_NAME, DEFAULT_ACTION_NAME);
    }

    public static String getBaseSoundModel(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getBaseSoundModel: invalid param", new Object[0]);
        return "";
    L7:
        return r100.getString(KEY_BASE_SOUND_MODEL, "");
    }

    public static boolean getGlobalDetectionToneEnabled(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getGlobalDetectionToneEnabled: invalid param", new Object[0]);
        return true;
    L7:
        return r100.getBoolean(KEY_GLOBAL_DETECTION_TONE_ENABLED, true);
    }

    public static int getGlobalGMMTrainingConfidenceLevel(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getGlobalGMMTrainingConfidenceLevel: invalid param", new Object[0]);
        return 50;
    L7:
        return r100.getInt(KEY_GLOBAL_GMM_TRAINING_CONFIDENCE_LEVEL, 50);
    }

    public static boolean getGlobalIsDisplayAdvancedDetails(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getGlobalIsDisplayAdvancedDetails: invalid param", new Object[0]);
        return true;
    L7:
        return r100.getBoolean(KEY_GLOBAL_IS_DISPLAY_ADVANCED_DETAILS, true);
    }

    public static int getGlobalTrainingPath(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getGlobalTrainingPath: invalid param", new Object[0]);
        return 6;
    L7:
        return r100.getInt(KEY_GLOBAL_TRAINING_PATH, 6);
    }

    public static int getHistBufferTime(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getHistBufferTime: invalid param", new Object[0]);
        return 2000;
    L7:
        return r100.getInt(KEY_HIST_BUFFER_TIME_IN_MILLI_SEC, 2000);
    }

    public static boolean getOpaqueDataTransferEnabled(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getOpaqueDataTransferEnabled: invalid param", new Object[0]);
        return false;
    L7:
        return r100.getBoolean(KEY_OPAQUE_DATA_TRANSFER_ENABLED, false);
    }

    public static int getPreRollDuration(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getPreRollDuration: invalid param", new Object[0]);
        return 500;
    L7:
        return r100.getInt(KEY_PRE_ROLL_DURATION_IN_MILLI_SEC, 500);
    }

    public static boolean getVoiceRequestEnabled(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getVoiceRequestEnabled: invalid param", new Object[0]);
        return true;
    L7:
        return r100.getBoolean(KEY_VOICE_REQUEST_ENABLED, true);
    }

    public static int getVoiceRequestLength(SharedPreferences r100) {
        if (r100 != null) goto L7;
        LogUtils.d(TAG, "getVoiceRequestLength: invalid param", new Object[0]);
        return 3000;
    L7:
        return r100.getInt(KEY_VOICE_REQUEST_LENGTH_IN_MILLISEC, 3000);
    }

    private static int getDefaultGlobalConfidenceLevel(int r100, ISmModel.ModelVersion r101) {
        LogUtils.d("getDefaultGlobalConfidenceLevel type:" + r100 + " version:" + r101, new Object[0]);
        int r102 = 69;
        if (r100 == 1) goto L31;
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L9;
        return 35;
    L9:
        if (r100 != 4) goto L44;
        return 10;
    L44:
        return -1;
    L14:
        if (r101 != ISmModel.ModelVersion.VERSION_2_0) goto L17;
        return 69;
    L17:
        if (r101 == ISmModel.ModelVersion.VERSION_3_0) goto L52;
        if (r101 == ISmModel.ModelVersion.VERSION_4_0) goto L52;
        if (r101 == ISmModel.ModelVersion.VERSION_5_0) goto L52;
        if (r101 == ISmModel.ModelVersion.VERSION_6_0) goto L52;
        if (r101 != ISmModel.ModelVersion.VERSION_7_0) goto L44;
    L52:
        r102 = CastIntegerProtector.parseInt(SystemPropertiesWrapper.get("wakeup_1st_user_level", "69"));     // Catch: Exception -> L51
    L29:
        LogUtils.d("getDefaultGlobalConfidenceLevel TYPE_1ST_USER confidenceLevel " + r102, new Object[0]);
        return r102;
    L31:
        if (r101 != ISmModel.ModelVersion.VERSION_2_0) goto L34;
        return 69;
    L34:
        if (r101 == ISmModel.ModelVersion.VERSION_3_0) goto L54;
        if (r101 == ISmModel.ModelVersion.VERSION_4_0) goto L54;
        if (r101 == ISmModel.ModelVersion.VERSION_5_0) goto L54;
        if (r101 == ISmModel.ModelVersion.VERSION_6_0) goto L54;
        if (r101 != ISmModel.ModelVersion.VERSION_7_0) goto L44;
    L54:
        int r103 = CastIntegerProtector.parseInt(SystemPropertiesWrapper.get("wakeup_1st_key_level", BDLocationException.ERROR_SHAKE_UPLOAD));     // Catch: Exception -> L48
    L49:
        LogUtils.d("getDefaultGlobalConfidenceLevel TYPE_1ST_KEYPHRASE confidenceLevel " + r103, new Object[0]);
        return r103;
    L48:
        r103 = 56;
        goto L49
    }

    public static int getGlobal1stKeyphraseConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101) {
        return getGlobalConfidenceLevel(r100, 1, r101);
    }

    public static int getGlobal1stUserConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101) {
        return getGlobalConfidenceLevel(r100, 2, r101);
    }

    public static int getGlobal2ndKeyphraseConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101) {
        return getGlobalConfidenceLevel(r100, 3, r101);
    }

    public static int getGlobal2ndUserConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101) {
        return getGlobalConfidenceLevel(r100, 4, r101);
    }

    private static String getGlobalKey(int r100, ISmModel.ModelVersion r101) {
        if (r100 == 1) goto L28;
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L9;
        return KEY_GLOBAL_SM3_2ND_KEYPHRASE_CONFIDENCE_LEVEL;
    L9:
        if (r100 != 4) goto L41;
        return KEY_GLOBAL_SM3_2ND_USER_CONFIDENCE_LEVEL;
    L41:
        return null;
    L14:
        if (r101 != ISmModel.ModelVersion.VERSION_2_0) goto L17;
        return KEY_GLOBAL_SM2_1ST_USER_CONFIDENCE_LEVEL;
    L17:
        if (r101 != ISmModel.ModelVersion.VERSION_3_0) goto L19;
    L26:
        return KEY_GLOBAL_SM3_1ST_USER_CONFIDENCE_LEVEL;
    L19:
        if (r101 == ISmModel.ModelVersion.VERSION_4_0) goto L26;
        if (r101 == ISmModel.ModelVersion.VERSION_5_0) goto L26;
        if (r101 == ISmModel.ModelVersion.VERSION_6_0) goto L26;
        if (r101 != ISmModel.ModelVersion.VERSION_7_0) goto L41;
    L28:
        if (r101 != ISmModel.ModelVersion.VERSION_2_0) goto L31;
        return KEY_GLOBAL_SM2_1ST_KEYPHRASE_CONFIDENCE_LEVEL;
    L31:
        if (r101 != ISmModel.ModelVersion.VERSION_3_0) goto L33;
    L42:
        return KEY_GLOBAL_SM3_1ST_KEYPHRASE_CONFIDENCE_LEVEL;
    L33:
        if (r101 == ISmModel.ModelVersion.VERSION_4_0) goto L42;
        if (r101 == ISmModel.ModelVersion.VERSION_5_0) goto L42;
        if (r101 == ISmModel.ModelVersion.VERSION_6_0) goto L42;
        if (r101 != ISmModel.ModelVersion.VERSION_7_0) goto L41;
        goto L41
    }

    public static void set1stKeyphraseConfidenceLevel(SharedPreferences r100, int r101) {
        setModelConfidenceLevel(r100, 1, r101);
    }

    public static void set1stUserConfidenceLevel(SharedPreferences r100, int r101) {
        setModelConfidenceLevel(r100, 2, r101);
    }

    public static void set2ndKeyphraseConfidenceLevel(SharedPreferences r100, int r101) {
        setModelConfidenceLevel(r100, 3, r101);
    }

    public static void set2ndUserConfidenceLevel(SharedPreferences r100, int r101) {
        setModelConfidenceLevel(r100, 4, r101);
    }

    public static void setActionIntent(SharedPreferences r100, Intent r101) {
        String r102 = TAG;
        LogUtils.d(r102, "setActionIntent: actionIntent = " + r101, new Object[0]);
        if (r100 != null) goto L7;
        LogUtils.d(r102, "setActionIntent: invalid param", new Object[0]);
        return;
    L7:
        if (r101 == null) goto L9;
        r100.edit().putString(KEY_ACTION_INTENT, r101.toUri(0)).apply();
        return;
    L9:
        r100.edit().putString(KEY_ACTION_INTENT, null).apply();
    }

    public static void setActionName(SharedPreferences r100, String r101) {
        String r102 = TAG;
        LogUtils.d(r102, "setActionName: actionName = " + r101, new Object[0]);
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        r100.edit().putString(KEY_ACTION_NAME, r101).apply();
        return;
    L8:
        LogUtils.d(r102, "setActionName: invalid param", new Object[0]);
    }

    public static void setBaseSoundModel(SharedPreferences r100, String r101) {
        String r102 = TAG;
        LogUtils.d(r102, "setBaseSoundModel: baseSoundModel = " + r101, new Object[0]);
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        r100.edit().putString(KEY_BASE_SOUND_MODEL, r101).apply();
        return;
    L8:
        LogUtils.d(r102, "setBaseSoundModel: invalid param", new Object[0]);
    }

    public static void setCurrentSoundModel(SharedPreferences r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        LogUtils.d(TAG, "============ set current sound model ================= " + r101, new Object[0]);
        r100.edit().putString(KEY_CURRENT_SOUNDMODEL, r101).apply();
    }

    public static void setGlobalDetectionToneEnabled(SharedPreferences r100, boolean r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setGlobalDetectionToneEnabled: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putBoolean(KEY_GLOBAL_DETECTION_TONE_ENABLED, r101).apply();
    }

    public static void setGlobalGMMTrainingConfidenceLevel(SharedPreferences r100, int r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setGlobalGMMTrainingConfidenceLevel: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putInt(KEY_GLOBAL_GMM_TRAINING_CONFIDENCE_LEVEL, r101).apply();
    }

    public static void setGlobalIsDisplayAdvancedDetails(SharedPreferences r100, boolean r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setGlobalIsDisplayAdvancedDetails: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putBoolean(KEY_GLOBAL_IS_DISPLAY_ADVANCED_DETAILS, r101).apply();
    }

    public static void setGlobalTrainingPath(SharedPreferences r100, int r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setGlobalTrainingPath: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putInt(KEY_GLOBAL_TRAINING_PATH, r101).apply();
    }

    public static void setHistBufferTime(SharedPreferences r100, int r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setHistBufferTime: invalid param", new Object[0]);
        return;
    L5:
        if (r101 < 0) goto L8;
        r100.edit().putInt(KEY_HIST_BUFFER_TIME_IN_MILLI_SEC, r101).apply();
        return;
    }

    public static void setOpaqueDataTransferEnabled(SharedPreferences r100, boolean r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setOpaqueDataTransferEnabled: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putBoolean(KEY_OPAQUE_DATA_TRANSFER_ENABLED, r101).apply();
    }

    public static void setPreRollDuration(SharedPreferences r100, int r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setPreRollDuration: invalid param", new Object[0]);
        return;
    L5:
        if (r101 < 0) goto L8;
        r100.edit().putInt(KEY_PRE_ROLL_DURATION_IN_MILLI_SEC, r101).apply();
        return;
    }

    public static void setUserVerificationEnabled(SharedPreferences r100, boolean r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setUserVerificationEnabled: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putBoolean(KEY_USER_VERIFICATION_ENABLED, r101).apply();
    }

    public static void setVoiceRequestEnabled(SharedPreferences r100, boolean r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setVoiceRequestEnabled: invalid param", new Object[0]);
        return;
    L5:
        r100.edit().putBoolean(KEY_VOICE_REQUEST_ENABLED, r101).apply();
    }

    public static void setVoiceRequestLength(SharedPreferences r100, int r101) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setVoiceRequestLength: invalid param", new Object[0]);
        return;
    L5:
        if (r101 <= 0) goto L8;
        r100.edit().putInt(KEY_VOICE_REQUEST_LENGTH_IN_MILLISEC, r101).apply();
        return;
    }

    public static int get1stKeyphraseConfidenceLevel(SharedPreferences r100, SharedPreferences r101, ISmModel.ModelVersion r102) {
        return getModelConfidenceLevel(r100, r101, 1, r102);
    }

    public static int get1stUserConfidenceLevel(SharedPreferences r100, SharedPreferences r101, ISmModel.ModelVersion r102) {
        return getModelConfidenceLevel(r100, r101, 2, r102);
    }

    public static int get2ndKeyphraseConfidenceLevel(SharedPreferences r100, SharedPreferences r101, ISmModel.ModelVersion r102) {
        return getModelConfidenceLevel(r100, r101, 3, r102);
    }

    public static int get2ndUserConfidenceLevel(SharedPreferences r100, SharedPreferences r101, ISmModel.ModelVersion r102) {
        return getModelConfidenceLevel(r100, r101, 4, r102);
    }

    private static int getGlobalConfidenceLevel(SharedPreferences r100, int r101, ISmModel.ModelVersion r102) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "getGlobalConfidenceLevel: invalid param", new Object[0]);
        return getDefaultGlobalConfidenceLevel(r101, r102);
    L5:
        String r103 = getGlobalKey(r101, r102);
        if (r103 != null) goto L10;
        return getDefaultGlobalConfidenceLevel(r101, r102);
    L10:
        return r100.getInt(r103, getDefaultGlobalConfidenceLevel(r101, r102));
    }

    public static void setGlobal1stKeyphraseConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101, int r102) {
        setGlobalConfidenceLevel(r100, 1, r101, r102);
    }

    public static void setGlobal1stUserConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101, int r102) {
        setGlobalConfidenceLevel(r100, 2, r101, r102);
    }

    public static void setGlobal2ndKeyphraseConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101, int r102) {
        setGlobalConfidenceLevel(r100, 3, r101, r102);
    }

    public static void setGlobal2ndUserConfidenceLevel(SharedPreferences r100, ISmModel.ModelVersion r101, int r102) {
        setGlobalConfidenceLevel(r100, 4, r101, r102);
    }

    private static void setModelConfidenceLevel(SharedPreferences r100, int r101, int r102) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setModelConfidenceLevel: invalid param", new Object[0]);
        return;
    L5:
        String r103 = getModelkey(r101);
        if (r103 != null) goto L8;
        return;
    L8:
        r100.edit().putInt(r103, r102).apply();
    }

    private static int getModelConfidenceLevel(SharedPreferences r100, SharedPreferences r101, int r102, ISmModel.ModelVersion r103) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        LogUtils.d(TAG, "setModelConfidenceLevel: invalid param", new Object[0]);
        return getDefaultGlobalConfidenceLevel(r102, r103);
    L6:
        String r104 = getModelkey(r102);
        if (r104 != null) goto L11;
        return getGlobalConfidenceLevel(r101, r102, r103);
    L11:
        return r100.getInt(r104, getGlobalConfidenceLevel(r101, r102, r103));
    }

    private static void setGlobalConfidenceLevel(SharedPreferences r100, int r101, ISmModel.ModelVersion r102, int r103) {
        if (r100 != null) goto L5;
        LogUtils.d(TAG, "setGlobalConfidenceLevel: invalid param", new Object[0]);
        return;
    L5:
        String r104 = getGlobalKey(r101, r102);
        if (r104 != null) goto L8;
        return;
    L8:
        r100.edit().putInt(r104, r103).apply();
    }
}
