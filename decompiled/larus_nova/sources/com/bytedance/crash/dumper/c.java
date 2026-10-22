package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f203151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f203152f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f203153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f203154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f203155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f203156d;

    public static c b() {
        if (f203151e != null) goto L6;
        f203151e = new c();
    L6:
        return f203151e;
    }

    public c() {
        Context r100 = com.bytedance.crash.i.getContext();     // Catch: Throwable -> L21
        if (r100 == null) goto L7;
        this.f203154b = Settings.Global.getString(r100.getContentResolver(), "bytest_automation_info");     // Catch: Throwable -> L21
        JSONObject r101 = new JSONObject(this.f203154b);     // Catch: Throwable -> L21
    L9:
        if (r101.length() == 0) goto L11;
        this.f203153a = r101.optJSONObject("slardar_filter");
    L12:
        JSONObject r102 = this.f203153a;
        if (r102 == null) goto L15;
        "true".equals(r102.optString("gwp_asan_switch"));
        "true".equals(this.f203153a.optString("core_dump_switch"));
        this.f203155c = "true".equals(this.f203153a.optString("is_all_exception_collected"));
        zg4.i.f572087c = true;
    L16:
        String r103 = r101.optString("bytrace_id_prefix");
        if (TextUtils.isEmpty(r103) == false) goto L19;
        r103 = UUID.randomUUID() + "-" + Process.myPid();
    L19:
        this.f203156d = r103;
        return;
    L15:
        this.f203155c = false;
        goto L16
    L11:
        this.f203153a = null;
    L7:
        r101 = new JSONObject();
        goto L9
    }

    public static void a(JSONObject r100) {
        JSONObject r101 = b().f203153a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() == 0) goto L9;
        com.bytedance.crash.util.j.d(r100, r101);
        return;
    }

    public static void c(JSONObject r100, JSONObject r101) {
        if (r100 != null) goto L19;
        return;
    L19:
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L16
    L6:
        if (r102.hasNext() == false) goto L27;
        String r103 = r102.next();     // Catch: Exception -> L16
        if ("slardar_filter".equals(r103) == true) goto L6;
        Object r104 = r100.opt(r103);     // Catch: Exception -> L16
        if (r104 == null) goto L6;
        r101.put(r103, r104);     // Catch: JSONException -> L15 Exception -> L16
    L27:
        return;
    }
}
