package e84;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f471327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f471328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f471329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f471330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f471331g;

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        k.f(r100, "id", this.f471325a);
        k.f(r100, "req_id", this.f471326b);
        k.f(r100, "is_track_limited", this.f471327c);
        k.f(r100, "take_ms", this.f471328d);
        k.f(r100, "time", this.f471329e);
        k.f(r100, "query_times", this.f471330f);
        k.f(r100, "hw_id_version_code", this.f471331g);
        return r100;
    }

    public final String toString() {
        return b().toString();
    }

    public static n a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L30;
        return null;
    L30:
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L27
        String r101 = r100.optString("id", null);     // Catch: JSONException -> L27
        String r102 = r100.optString("req_id", null);     // Catch: JSONException -> L27
        if (r100.has("is_track_limited") == false) goto L8;
        Boolean r111 = Boolean.valueOf(r100.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
    L10:
        if (r100.has("take_ms") == false) goto L12;
        Long r112 = Long.valueOf(r100.optLong("take_ms", -1));     // Catch: JSONException -> L27
    L14:
        if (r100.has("time") == false) goto L16;
        Long r103 = Long.valueOf(r100.optLong("time", -1));     // Catch: JSONException -> L27
    L18:
        if (r100.has("query_times") == false) goto L20;
        Integer r113 = Integer.valueOf(r100.optInt("query_times", -1));     // Catch: JSONException -> L27
    L22:
        if (r100.has("hw_id_version_code") == false) goto L24;
        Long r114 = Long.valueOf(r100.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
    L25:
        return new n(r101, r102, r111, r112, r103, r113, r114);
    L24:
        r114 = null;
        goto L25
    L20:
        r113 = null;
        goto L22
    L16:
        r103 = null;
        goto L18
    L12:
        r112 = null;
        goto L14
    L8:
        r111 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public n(String r100, String r101, Boolean r102, Long r103, Long r104, Integer r105, Long r106) {
        this.f471325a = r100;
        this.f471326b = r101;
        this.f471327c = r102;
        this.f471328d = r103;
        this.f471329e = r104;
        this.f471330f = r105;
        this.f471331g = r106;
    }
}
