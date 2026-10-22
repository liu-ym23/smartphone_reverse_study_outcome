package com.obric.sva.sdk.data;

import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public interface ISettingsModel {
    public static final String NAME_OF_GLOBAL_PREFERENCES = "global_settings";
    public static final String PREFIX_OF_SOUND_MODEL_PREFERENCES = "settings_";

    int get1stKeyphraseConfidenceLevel();

    int get1stUserConfidenceLevel();

    int get2ndKeyphraseConfidenceLevel();

    int get2ndUserConfidenceLevel();

    Intent getActionIntent();

    String getActionName();

    String getBaseSoundModel();

    String getCurrentSoundModel();

    int getGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r100);

    int getGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r100);

    int getGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r100);

    int getGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r100);

    boolean getGlobalDetectionToneEnabled();

    int getGlobalGMMTrainingConfidenceLevel();

    boolean getGlobalIsDisplayAdvancedDetails();

    int getGlobalTrainingPath();

    int getHistBufferTime();

    boolean getOpaqueDataTransferEnabled();

    int getPreRollDuration();

    boolean getUserVerificationEnabled();

    boolean getVoiceRequestEnabled();

    int getVoiceRequestLength();

    void set1stKeyphraseConfidenceLevel(int r100);

    void set1stUserConfidenceLevel(int r100);

    void set2ndKeyphraseConfidenceLevel(int r100);

    void set2ndUserConfidenceLevel(int r100);

    void setActionIntent(Intent r100);

    void setActionName(String r100);

    void setBaseSoundModel(String r100);

    void setCurrentSoundModel(String r100);

    void setGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r100, int r101);

    void setGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r100, int r101);

    void setGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r100, int r101);

    void setGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r100, int r101);

    void setGlobalDetectionToneEnabled(boolean r100);

    void setGlobalGMMTrainingConfidenceLevel(int r100);

    void setGlobalIsDisplayAdvancedDetails(boolean r100);

    void setGlobalTrainingPath(int r100);

    void setHistBufferTime(int r100);

    void setOpaqueDataTransferEnabled(boolean r100);

    void setPreRollDuration(int r100);

    void setUserVerificationEnabled(boolean r100);

    void setVoiceRequestEnabled(boolean r100);

    void setVoiceRequestLength(int r100);
}
