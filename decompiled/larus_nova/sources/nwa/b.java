package nwa;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import gwa.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f521015a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f521016a = null;

        static {
            f521016a = new b();
        }
    }

    public b() {
    }

    public final void a(String r100, String r101) {
        d("audit_event", false, r100, r101);
    }

    public final void b(String r100, boolean r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L8
        r102.put("type", "audit_check_cache");     // Catch: JSONException -> L8
        if (r101 == false) goto L5;
        String r103 = "success";
    L6:
        r102.put("result", r103);     // Catch: JSONException -> L8
        r102.put("check_cache_source", r100);     // Catch: JSONException -> L8
        c("audit_sdk_overall", r102, null, null);     // Catch: JSONException -> L8
        return;
    L5:
        r103 = "other";
    L8:
        e = move-exception;
        e.printStackTrace();
        Log.e("Audit_Monitor", e.getMessage(), e);
    }

    public final void c(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        g r104 = this.f521015a;
        if (r104 != null) goto L6;
        Log.e("Audit_Monitor", "Monitor not init!");
        return;
    L6:
        r104.monitorEvent(r100, r101, r102, r103);
    }

    public final void d(String r100, boolean r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L14
        r104.put("type", r100);     // Catch: JSONException -> L14
        if (r101 == false) goto L5;
        String r105 = "success";
    L6:
        r104.put("result", r105);     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r104.put("error_code", r102);     // Catch: JSONException -> L14
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r104.put("error_msg", r103);     // Catch: JSONException -> L14
    L12:
        c("audit_sdk_overall", r104, null, null);     // Catch: JSONException -> L14
        return;
    L5:
        r105 = "other";
    L14:
        e = move-exception;
        e.printStackTrace();
        Log.e("Audit_Monitor", e.getMessage(), e);
    }
}
