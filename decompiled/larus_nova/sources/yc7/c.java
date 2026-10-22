package yc7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f567220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f567221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f567222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f567223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f567224e;

    public final String getType() {
        return this.f567220a;
    }

    public c(JSONObject r100, String r101) {
        r100.optInt("JSSDK", 0);
        this.f567220a = r100.optString("__msg_type");
        this.f567221b = r100.optString("__callback_id", "");
        this.f567222c = r101;
        this.f567223d = r100.optJSONObject("params");
        this.f567224e = r100.optString("currentUrl", "");
    }
}
