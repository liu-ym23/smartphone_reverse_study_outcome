package com.ss.videoarch.strategy.dataCenter.config.model;

import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class CommonConfigInfo {
    public String TAG;
    public LSStrategySDKSettings mLSStrategySDKSettings;
    public JSONObject mLSStrategySDKSettingsJSON;
    public JSONObject mLivePlayerSettingsJSON;
    public JSONObject mRTMPlayerSettingsJSON;

    public CommonConfigInfo() {
        this.TAG = "CommonConfigInfo";
        this.mLSStrategySDKSettingsJSON = new JSONObject();
        this.mLivePlayerSettingsJSON = new JSONObject();
        this.mRTMPlayerSettingsJSON = null;
        this.mLSStrategySDKSettings = new LSStrategySDKSettings();
    }

    public void initSettingsConfig() {
        if (LSSettings.inst().mCommonConfigJSON != null) goto L5;
    L13:
        Objects.toString(this.mLSStrategySDKSettingsJSON);
        Objects.toString(this.mLivePlayerSettingsJSON);
        Objects.toString(this.mRTMPlayerSettingsJSON);
        return;
    L5:
        if (LSSettings.inst().mCommonConfigJSON.has("LSStrategySDKSettings") == false) goto L8;
        JSONObject r100 = LSSettings.inst().mCommonConfigJSON.optJSONObject("LSStrategySDKSettings");
        this.mLSStrategySDKSettingsJSON = r100;
        this.mLSStrategySDKSettings = new LSStrategySDKSettings(r100);
    L8:
        if (LSSettings.inst().mCommonConfigJSON.has("LivePlayerSettings") == false) goto L11;
        this.mLivePlayerSettingsJSON = LSSettings.inst().mCommonConfigJSON.optJSONObject("LivePlayerSettings");
    L11:
        if (LSSettings.inst().mCommonConfigJSON.has("RTMPlayer") == false) goto L13;
        this.mRTMPlayerSettingsJSON = LSSettings.inst().mCommonConfigJSON.optJSONObject("RTMPlayer");
        goto L13
    }
}
