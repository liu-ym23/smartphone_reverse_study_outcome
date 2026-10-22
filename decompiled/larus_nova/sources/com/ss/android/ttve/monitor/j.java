package com.ss.android.ttve.monitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, a> f449944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, a> f449945b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f449946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f449947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f449948c;

        public a() {
        }
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = ((HashMap) this.f449945b).isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        ((HashMap) this.f449944a).clear();     // Catch: Throwable -> L6
        ((HashMap) this.f449945b).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public j() {
        this.f449944a = new HashMap();
        this.f449945b = new HashMap();
    }

    public final synchronized String d(int r100) {
        monitor-enter(this);
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L22
        if (r100 != 0) goto L7;
        Iterator r102 = ((HashMap) this.f449944a).entrySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r102 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        if (r102.hasNext() == false) goto L19;
        a r103 = (a) ((Map.Entry) r102.next()).getValue();     // Catch: Throwable -> L22
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L25 Throwable -> L22
        r104.put("path", r103.f449946a);     // Catch: JSONException -> L25 Throwable -> L22
        r104.put("start", r103.f449947b);     // Catch: JSONException -> L25 Throwable -> L22
        r104.put("duration", r103.f449948c);     // Catch: JSONException -> L25 Throwable -> L22
        r101.put(r104);     // Catch: JSONException -> L25 Throwable -> L22
        goto L15
    L19:
        String r105 = r101.toString();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r105;
    L7:
        if (r100 != 1) goto L10;
        r102 = ((HashMap) this.f449945b).entrySet().iterator();     // Catch: Throwable -> L22
        goto L11
    L10:
        r102 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r100, a r101) {
        monitor-enter(this);
        Map<Integer, a> r102 = this.f449944a;     // Catch: Throwable -> L6
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L6
        r103.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
