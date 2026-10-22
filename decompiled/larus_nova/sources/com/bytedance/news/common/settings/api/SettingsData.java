package com.bytedance.news.common.settings.api;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsData {
    private JSONObject appSettings;
    private boolean fromServer;
    private String token;
    private JSONObject userSettings;

    public JSONObject getAppSettings() {
        return this.appSettings;
    }

    public String getToken() {
        return this.token;
    }

    public JSONObject getUserSettings() {
        return this.userSettings;
    }

    public boolean isFromServer() {
        return this.fromServer;
    }

    public SettingsData(JSONObject r100, JSONObject r101) {
        this(r100, r101, UUID.randomUUID().toString(), true);
    }

    public SettingsData(JSONObject r100, JSONObject r101, String r102, boolean r103) {
        this.appSettings = r100;
        this.userSettings = r101;
        this.token = r102;
        this.fromServer = r103;
    }
}
