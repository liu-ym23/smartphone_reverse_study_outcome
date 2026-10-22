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

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f203237s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f203238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f203239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f203240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ListMap<CrashType, AttachUserData> f203241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ListMap<CrashType, ICrashCallback> f203242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ListMap<CrashType, b> f203243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<IOOMCallback> f203244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<IOOMCallback> f203245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<l> f203246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ListMap<CrashType, v> f203247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ListMap<CrashType, y> f203248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<u> f203249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<m> f203250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, LinkedList<String>> f203251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Integer> f203252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ICrashFilter f203253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f203254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f203255r;

    public m0() {
        this.f203255r = true;
        this.f203238a = new ConcurrentHashMap();
        this.f203239b = new ConcurrentHashMap();
        this.f203240c = new ConcurrentHashMap();
        this.f203241d = new ListMap();
        this.f203242e = new ListMap();
        this.f203243f = new ListMap();
        this.f203244g = new CopyOnWriteArrayList();
        this.f203245h = new CopyOnWriteArrayList();
        this.f203246i = new CopyOnWriteArrayList();
        this.f203249l = new CopyOnWriteArrayList();
        this.f203250m = new CopyOnWriteArrayList();
        this.f203251n = new ConcurrentHashMap();
        this.f203252o = new ConcurrentHashMap();
        this.f203247j = new ListMap();
        this.f203248k = new ListMap();
    }

    public final void c(Map<? extends String, ? extends String> r100) {
        if (r100 != null) goto L24;
        return;
    L24:
        if (r100.isEmpty() == true) goto L43;
        Iterator<Map.Entry<? extends String, ? extends String>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L23
    L6:
        if (r101.hasNext() == false) goto L45;
        Map.Entry<? extends String, ? extends String> r102 = r101.next();     // Catch: Throwable -> L23
        String r103 = r102.getKey();     // Catch: Throwable -> L23
        String r104 = r102.getValue();     // Catch: Throwable -> L23
        if (NativeBridge.H() == false) goto L17;
        if (this.f203254q == false) goto L17;
        if (r104 == null) goto L13;
        if (TextUtils.isEmpty(r103) == true) goto L6;
        NativeBridge.O(r103, r104);     // Catch: Throwable -> L23
        goto L6
    L13:
        NativeBridge.P(r103);     // Catch: Throwable -> L23
    L17:
        if (r104 == null) goto L18;
        if (r103 == null) goto L6;
        this.f203238a.put(r103, r104);     // Catch: Throwable -> L23
        goto L6
    L18:
        this.f203238a.remove(r103);     // Catch: Throwable -> L23
        goto L6
    L45:
        return;
    L43:
        return;
    }

    public final List<AttachUserData> d(CrashType r100) {
        ListMap<CrashType, AttachUserData> r101 = this.f203241d;
        monitor-enter(r101);
        List<AttachUserData> r102 = this.f203241d.getList(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final Map<String, String> e(CrashType r100) {
        ListMap<CrashType, AttachUserData> r101 = this.f203241d;
        monitor-enter(r101);
        List<AttachUserData> r102 = this.f203241d.getList(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        HashMap r103 = new HashMap();
        Iterator<AttachUserData> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Map<? extends String, ? extends String> r105 = r104.next().getUserData(r100);
        if (r105 == null) goto L8;
        r103.putAll(r105);
        goto L8
    L12:
        return r103;
    L13:
        th = move-exception;
        throw th;
    }

    public final List<ICrashCallback> f(CrashType r100) {
        ListMap<CrashType, ICrashCallback> r101 = this.f203242e;
        monitor-enter(r101);
        List<ICrashCallback> r102 = this.f203242e.getList(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<v> g(CrashType r100) {
        ListMap<CrashType, v> r101 = this.f203247j;
        monitor-enter(r101);
        List<v> r102 = this.f203247j.getList(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(AttachUserData r100, CrashType r101) {
        if (r100 == null) goto L14;
        ListMap<CrashType, AttachUserData> r102 = this.f203241d;
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r101 != CrashType.ALL) goto L8;
        this.f203241d.addMulti(r100, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        this.f203241d.add(r101, r100);     // Catch: Throwable -> L11
        goto L9
    }

    public final void b(String r100, String r101) {
        if (NativeBridge.H() == true) goto L5;
    L11:
        if (r101 != null) goto L13;
        this.f203238a.remove(r100);
        return;
    L13:
        if (r100 == null) goto L20;
        this.f203238a.put(r100, r101);
        return;
    L20:
        return;
    L5:
        if (this.f203254q == false) goto L11;
        if (r101 != null) goto L9;
        NativeBridge.P(r100);
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L17;
        NativeBridge.O(r100, r101);
        return;
    }

    public final boolean h(CrashType r100, JSONObject r101) {
        ICrashFilter r102 = this.f203253p;
        if (r102 != null) goto L19;
        return false;
    L19:
        if (r100 != CrashType.NATIVE) goto L11;
        return !this.f203253p.onNativeCrashFilter(r101.optString("data"), r101.optString("crash_thread_name"));
    L11:
        if (r100 != CrashType.ANR) goto L17;
        if ((r102 instanceof n) == false) goto L17;
        r101.optString("data");     // Catch: Throwable -> L18
        r101.optString("anr_info");     // Catch: Throwable -> L18
        return !((n) this.f203253p).a();
    L17:
        return false;
    }
}
