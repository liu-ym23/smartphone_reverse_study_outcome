package com.bytedance.crash;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.ListMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m0 {
    public static boolean s;
    public final ConcurrentHashMap<String, String> a;
    public final ConcurrentHashMap<Integer, String> b;
    public final ConcurrentHashMap<String, String> c;
    public final ListMap<CrashType, AttachUserData> d;
    public final ListMap<CrashType, ICrashCallback> e;
    public final ListMap<CrashType, b> f;
    public final List<IOOMCallback> g;
    public final List<IOOMCallback> h;
    public final List<l> i;
    public final ListMap<CrashType, v> j;
    public final ListMap<CrashType, y> k;
    public final List<u> l;
    public final List<m> m;
    public final Map<String, LinkedList<String>> n;
    public final Map<String, Integer> o;
    public ICrashFilter p;
    public boolean q;
    public volatile boolean r;

    public m0() {
        this.r = true;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ListMap();
        this.e = new ListMap();
        this.f = new ListMap();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.j = new ListMap();
        this.k = new ListMap();
    }

    public final void c(Map<? extends String, ? extends String> r4) {
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.isEmpty() == true) goto L43;
        Iterator<Map.Entry<? extends String, ? extends String>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L23
    L6:
        if (r5.hasNext() == false) goto L45;
        Map.Entry<? extends String, ? extends String> r0 = r5.next();     // Catch: Throwable -> L23
        String r1 = r0.getKey();     // Catch: Throwable -> L23
        String r2 = r0.getValue();     // Catch: Throwable -> L23
        if (NativeBridge.H() == false) goto L17;
        if (this.q == false) goto L17;
        if (r2 == null) goto L13;
        if (TextUtils.isEmpty(r1) == true) goto L6;
        NativeBridge.O(r1, r2);     // Catch: Throwable -> L23
        goto L6
    L13:
        NativeBridge.P(r1);     // Catch: Throwable -> L23
    L17:
        if (r2 == null) goto L18;
        if (r1 == null) goto L6;
        this.a.put(r1, r2);     // Catch: Throwable -> L23
        goto L6
    L18:
        this.a.remove(r1);     // Catch: Throwable -> L23
        goto L6
    L45:
        return;
    L43:
        return;
    }

    public final List<AttachUserData> d(CrashType r3) {
        ListMap<CrashType, AttachUserData> r0 = this.d;
        monitor-enter(r0);
        List<AttachUserData> r4 = this.d.getList(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final Map<String, String> e(CrashType r4) {
        ListMap<CrashType, AttachUserData> r0 = this.d;
        monitor-enter(r0);
        List<AttachUserData> r1 = this.d.getList(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        HashMap r2 = new HashMap();
        Iterator<AttachUserData> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Map<? extends String, ? extends String> r5 = r3.next().getUserData(r4);
        if (r5 == null) goto L8;
        r2.putAll(r5);
        goto L8
    L12:
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public final List<ICrashCallback> f(CrashType r3) {
        ListMap<CrashType, ICrashCallback> r0 = this.e;
        monitor-enter(r0);
        List<ICrashCallback> r4 = this.e.getList(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<v> g(CrashType r3) {
        ListMap<CrashType, v> r0 = this.j;
        monitor-enter(r0);
        List<v> r4 = this.j.getList(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(AttachUserData r5, CrashType r6) {
        if (r5 == null) goto L14;
        ListMap<CrashType, AttachUserData> r0 = this.d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r6 != CrashType.ALL) goto L8;
        this.d.addMulti(r5, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.d.add(r6, r5);     // Catch: Throwable -> L11
        goto L9
    }

    public final void b(String r2, String r3) {
        if (NativeBridge.H() == true) goto L5;
    L11:
        if (r3 != null) goto L13;
        this.a.remove(r2);
        return;
    L13:
        if (r2 == null) goto L20;
        this.a.put(r2, r3);
        return;
    L20:
        return;
    L5:
        if (this.q == false) goto L11;
        if (r3 != null) goto L9;
        NativeBridge.P(r2);
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        NativeBridge.O(r2, r3);
        return;
    }

    public final boolean h(CrashType r5, JSONObject r6) {
        ICrashFilter r0 = this.p;
        if (r0 != null) goto L19;
        return false;
    L19:
        if (r5 != CrashType.NATIVE) goto L11;
        return !this.p.onNativeCrashFilter(r6.optString("data"), r6.optString("crash_thread_name"));
    L11:
        if (r5 != CrashType.ANR) goto L17;
        if ((r0 instanceof n) == false) goto L17;
        r6.optString("data");     // Catch: Throwable -> L18
        r6.optString("anr_info");     // Catch: Throwable -> L18
        return !this.p.a();
    L17:
        return false;
    }
}
