package com.bytedance.awemeopen.infra.plugs.settings;

import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/IAppSettingsHandler;", "", "onQueryParams", "", "", "bdpAppId", "onUpdateSettings", "", "oldSettings", "Lorg/json/JSONObject;", "newSettings", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAppSettingsHandler {
    Map<String, String> onQueryParams(String r100);

    void onUpdateSettings(JSONObject r100, JSONObject r101);
}
