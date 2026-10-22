package com.huawei.hms.hatool;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g0 f277330c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f277332b;

    private g0() {
        this.f277332b = new Object();
    }

    public static g0 a() {
        if (f277330c != null) goto L6;
        b();
    L6:
        return f277330c;
    }

    private JSONObject a(Map<String, String> r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L11;
    L10:
        return r101;
    L11:
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L9
    L9:
        v.b("hmsSdk", "Exception occured when transferring bundle to json");
        goto L10
    }

    private static synchronized void b() {
        monitor-enter(g0.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f277330c != null) goto L7;
        f277330c = new g0();     // Catch: Throwable -> L9
    L7:
        monitor-exit(g0.class);
    }

    public void a(Context r100) {
        Object r101 = this.f277332b;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f277331a == null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.f277331a = r100;     // Catch: Throwable -> L11
        e.a().a(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void a(String r100, int r101) {
        e.a().a(r100, r101);
    }

    public void a(String r100, int r101, String r102, LinkedHashMap<String, String> r103) {
        JSONObject r104 = a(r103);
        e.a().a(r100, r101, r102, r104);
    }

    public void a(String r100, Context r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("_constants", r103);     // Catch: JSONException -> L6
        e.a().a(r100, 0, r102, r104);
        return;
    L6:
        v.f("hmsSdk", "onEvent():JSON structure Exception!");
    }

    public void b(String r100, int r101, String r110, LinkedHashMap<String, String> r111) {
        JSONObject r102 = a(r111);
        e.a().a(r100, r101, r110, r102, System.currentTimeMillis());
    }
}
