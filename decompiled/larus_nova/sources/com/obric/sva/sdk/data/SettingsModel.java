package com.obric.sva.sdk.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.open.douyin.settings.f;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.Utils;

/* JADX INFO: loaded from: classes6.dex */
public class SettingsModel implements ISettingsModel {
    private final String TAG;
    private SharedPreferences mGlobalPrefs;
    private String mSmName;
    private SharedPreferences mSmPrefs;
    private ISmModel.ModelVersion mSmVersion;

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setCurrentSoundModel(String r100) {
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get1stKeyphraseConfidenceLevel() {
        return SettingsDAO.get1stKeyphraseConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get1stUserConfidenceLevel() {
        return SettingsDAO.get1stUserConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get2ndKeyphraseConfidenceLevel() {
        return SettingsDAO.get2ndKeyphraseConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get2ndUserConfidenceLevel() {
        return SettingsDAO.get2ndUserConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public Intent getActionIntent() {
        return SettingsDAO.getActionIntent(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getActionName() {
        return SettingsDAO.getActionName(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getBaseSoundModel() {
        return SettingsDAO.getBaseSoundModel(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getGlobalDetectionToneEnabled() {
        return SettingsDAO.getGlobalDetectionToneEnabled(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobalGMMTrainingConfidenceLevel() {
        return SettingsDAO.getGlobalGMMTrainingConfidenceLevel(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getGlobalIsDisplayAdvancedDetails() {
        return SettingsDAO.getGlobalIsDisplayAdvancedDetails(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobalTrainingPath() {
        return SettingsDAO.getGlobalTrainingPath(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getHistBufferTime() {
        return SettingsDAO.getHistBufferTime(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getOpaqueDataTransferEnabled() {
        return SettingsDAO.getOpaqueDataTransferEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getPreRollDuration() {
        return SettingsDAO.getPreRollDuration(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getUserVerificationEnabled() {
        return SettingsDAO.getUserVerificationEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getVoiceRequestEnabled() {
        if (TextUtils.isEmpty(this.mSmName) == false) goto L7;
        return false;
    L7:
        return SettingsDAO.getVoiceRequestEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getVoiceRequestLength() {
        return SettingsDAO.getVoiceRequestLength(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getCurrentSoundModel() {
        return this.mSmName;
    }

    private SharedPreferences getGlobalSharedPrefs(Context r100) {
        if (Utils.isAtLeastN() == false) goto L9;
        Context r101 = r100.createDeviceProtectedStorageContext();
        if (r101.moveSharedPreferencesFrom(r100, ISettingsModel.NAME_OF_GLOBAL_PREFERENCES) == true) goto L7;
        LogUtils.e(this.TAG, "Failed to migrate global shared preferences", new Object[0]);
    L7:
        r100 = r101;
    L9:
        return r100.getSharedPreferences(ISettingsModel.NAME_OF_GLOBAL_PREFERENCES, 0);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r100) {
        return SettingsDAO.getGlobal1stKeyphraseConfidenceLevel(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r100) {
        return SettingsDAO.getGlobal1stUserConfidenceLevel(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r100) {
        return SettingsDAO.getGlobal2ndKeyphraseConfidenceLevel(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r100) {
        return SettingsDAO.getGlobal2ndUserConfidenceLevel(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set1stKeyphraseConfidenceLevel(int r100) {
        SettingsDAO.set1stKeyphraseConfidenceLevel(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set1stUserConfidenceLevel(int r100) {
        SettingsDAO.set1stUserConfidenceLevel(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set2ndKeyphraseConfidenceLevel(int r100) {
        SettingsDAO.set2ndKeyphraseConfidenceLevel(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set2ndUserConfidenceLevel(int r100) {
        SettingsDAO.set2ndUserConfidenceLevel(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setActionIntent(Intent r100) {
        SettingsDAO.setActionIntent(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setActionName(String r100) {
        SettingsDAO.setActionName(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setBaseSoundModel(String r100) {
        SettingsDAO.setBaseSoundModel(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalDetectionToneEnabled(boolean r100) {
        SettingsDAO.setGlobalDetectionToneEnabled(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalGMMTrainingConfidenceLevel(int r100) {
        SettingsDAO.setGlobalGMMTrainingConfidenceLevel(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalIsDisplayAdvancedDetails(boolean r100) {
        SettingsDAO.setGlobalIsDisplayAdvancedDetails(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalTrainingPath(int r100) {
        SettingsDAO.setGlobalTrainingPath(this.mGlobalPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setHistBufferTime(int r100) {
        SettingsDAO.setHistBufferTime(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setOpaqueDataTransferEnabled(boolean r100) {
        SettingsDAO.setOpaqueDataTransferEnabled(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setPreRollDuration(int r100) {
        SettingsDAO.setPreRollDuration(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setUserVerificationEnabled(boolean r100) {
        SettingsDAO.setUserVerificationEnabled(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setVoiceRequestEnabled(boolean r100) {
        SettingsDAO.setVoiceRequestEnabled(this.mSmPrefs, r100);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setVoiceRequestLength(int r100) {
        SettingsDAO.setVoiceRequestLength(this.mSmPrefs, r100);
    }

    public SettingsModel(Context r100, String r101) {
        this.TAG = f.f269709f;
        this.mSmVersion = ISmModel.ModelVersion.VERSION_2_0;
        this.mSmName = r101;
        if (r101 != null) goto L5;
        this.mGlobalPrefs = getGlobalSharedPrefs(r100);
    L6:
        IExtendedSmModel r102 = Global.getInstance().getExtendedSmMgr().getSoundModel(r101);
        if (r102 == null) goto L10;
        this.mSmVersion = r102.getSoundModelVersion();
        return;
    L10:
        return;
    L5:
        this.mSmPrefs = getSmSharedPrefs(r100, r101);
        this.mGlobalPrefs = getGlobalSharedPrefs(r100);
        goto L6
    }

    private SharedPreferences getSmSharedPrefs(Context r100, String r101) {
        String r102 = ISettingsModel.PREFIX_OF_SOUND_MODEL_PREFERENCES + r101;
        if (Utils.isAtLeastN() == false) goto L9;
        Context r103 = r100.createDeviceProtectedStorageContext();
        if (r103.moveSharedPreferencesFrom(r100, r102) == true) goto L7;
        LogUtils.e(this.TAG, "Failed to migrate sound model shared preferences", new Object[0]);
    L7:
        r100 = r103;
    L9:
        return r100.getSharedPreferences(r102, 0);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r100, int r101) {
        SettingsDAO.setGlobal1stKeyphraseConfidenceLevel(this.mGlobalPrefs, r100, r101);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r100, int r101) {
        SettingsDAO.setGlobal1stUserConfidenceLevel(this.mGlobalPrefs, r100, r101);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r100, int r101) {
        SettingsDAO.setGlobal2ndKeyphraseConfidenceLevel(this.mGlobalPrefs, r100, r101);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r100, int r101) {
        SettingsDAO.setGlobal2ndUserConfidenceLevel(this.mGlobalPrefs, r100, r101);
    }
}
