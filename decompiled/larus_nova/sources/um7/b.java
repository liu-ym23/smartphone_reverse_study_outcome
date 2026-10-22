package um7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static JSONObject a(JSONObject r100) {
        e.b("checkAppSettingsConfig() on call;");
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        r101.put("app_settings_config_is_empty", false);     // Catch: Throwable -> L16
        JSONObject r102 = r100.optJSONObject("sdk_key_LuckyDog");     // Catch: Throwable -> L16
        if (r102 == null) goto L14;
        JSONObject r103 = r102.optJSONObject("luckyunion_account_sdk");     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        JSONObject r104 = r103.optJSONObject("passport_data");     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        boolean r105 = r104.optBoolean("enable_apply_token", false);     // Catch: Throwable -> L16
        boolean r106 = r104.optBoolean("enable_refresh_act_id", false);     // Catch: Throwable -> L16
        r101.put("enable_apply_token", r105);     // Catch: Throwable -> L16
        r101.put("enable_refresh_act_id", r106);     // Catch: Throwable -> L16
        return r101;
    L14:
        r101.put("enable_apply_token", false);     // Catch: Throwable -> L16
        r101.put("enable_refresh_act_id", false);     // Catch: Throwable -> L16
    L18:
        return r101;
    L5:
        r101.put("app_settings_config_is_empty", true);     // Catch: Throwable -> L16
        r101.put("enable_apply_token", false);     // Catch: Throwable -> L16
        r101.put("enable_refresh_act_id", false);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        e.b(th.getLocalizedMessage());
        goto L18
    }
}
