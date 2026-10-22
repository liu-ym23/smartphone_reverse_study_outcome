package com.bytedance.sdk.account.platform.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IAccountSettingsService extends IAuthorizeService {

    /* JADX INFO: loaded from: classes22.dex */
    public interface SettingsService {
        JSONObject getSettings();
    }

    JSONObject getAccountSettingsConfig();

    JSONObject getLoginInfoConfig();

    JSONObject getOnekeyLoginConfig();

    JSONObject getThirdPartyConfig();

    void setSettingsService(SettingsService r100);

    void updateSettings(JSONObject r100);
}
