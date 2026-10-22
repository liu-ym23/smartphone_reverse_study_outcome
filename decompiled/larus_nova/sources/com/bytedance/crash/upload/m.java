package com.bytedance.crash.upload;

import com.bytedance.crash.util.p;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f203393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f203394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f203395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f203396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static m f203397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f203398i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f203399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f203400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f203401c;

    static {
        f203394e = 100;
        f203395f = 2;
        f203396g = 5;
    }

    public static m b() {
        if (f203397h != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f203397h != null) goto L9;
        f203397h = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f203397h;
    }

    public final void d() {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L8
        r100.append(this.f203399a);     // Catch: Exception -> L8
        r100.append('\n');     // Catch: Exception -> L8
        Iterator<Map.Entry<String, Long>> r101 = this.f203400b.entrySet().iterator();     // Catch: Exception -> L8
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Long> r102 = r101.next();     // Catch: Exception -> L8
        r100.append(r102.getKey());     // Catch: Exception -> L8
        r100.append(' ');     // Catch: Exception -> L8
        r100.append(r102.getValue());     // Catch: Exception -> L8
        r100.append('\n');     // Catch: Exception -> L8
        goto L4
    L6:
        p.e("writeUploadTimesFile:" + r100);     // Catch: Exception -> L8
        com.bytedance.crash.util.h.h(this.f203401c, r100.toString(), false);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ch4.c.b("NPTH_ANR_ERROR_AppMonitor", e);
    }

    public m() {
        this.f203399a = 0;
        String r100 = com.bytedance.crash.util.b.c().replace(".", "_").replace(":", "-") + ".times";
        PolarisFileWrapper r101 = new PolarisFileWrapper(com.bytedance.crash.i.d(), "uploadLimits");
        com.bytedance.crash.util.g.c(r101);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, r100);
        this.f203401c = r102;
        HashMap<String, Long> r103 = new HashMap();
        if (r102.exists() == true) goto L28;
        this.f203399a = System.currentTimeMillis();
    L26:
        this.f203400b = r103;
        p.e("upload_times:" + r103);
        f203398i = true;
        return;
    L28:
        JSONArray r104 = com.bytedance.crash.util.h.e(r102);     // Catch: Throwable -> L25
        if (r104.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L26;
        Long r106 = Long.decode(r104.optString(0, null));     // Catch: Exception -> L14 Throwable -> L25
    L16:
        if ((System.currentTimeMillis() - r106.longValue()) < 86400000) goto L18;
        p.e("limit file exceed 1 day");     // Catch: Throwable -> L25
        this.f203399a = System.currentTimeMillis();     // Catch: Throwable -> L25
        com.bytedance.crash.util.h.b(this.f203401c);     // Catch: Throwable -> L25
        goto L26
    L18:
        this.f203399a = r106.longValue();     // Catch: Throwable -> L25
        int r107 = 1;
    L20:
        if (r107 >= r104.length()) goto L26;
        String[] r108 = r104.optString(r107, "").split(" ");     // Catch: Throwable -> L25
        if (r108.length != 2) goto L24;
        r103.put(r108[0], Long.decode(r108[1]));     // Catch: Throwable -> L25
    L24:
        r107 = r107 + 1;
    L14:
        r106 = 0L;     // Catch: Throwable -> L25
        goto L16
    L8:
        r105 = false;
    L25:
        this.f203399a = System.currentTimeMillis();
        com.bytedance.crash.util.h.b(this.f203401c);
        goto L26
    }

    public final synchronized void c(String r100) {
        monitor-enter(this);
        p.e("updateTimes:".concat(r100));     // Catch: Throwable -> L10
        Long r101 = this.f203400b.get(r100);     // Catch: Throwable -> L10
        long r102 = 1;
        if (r101 == null) goto L7;
        r102 = 1 + r101.longValue();     // Catch: Throwable -> L10
    L7:
        Long r103 = Long.valueOf(r102);     // Catch: Throwable -> L10
        this.f203400b.put(r100, r103);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r100, long r101) {
        monitor-enter(this);
        boolean r102 = false;
        if (r100 != null) goto L19;
        monitor-exit(this);
        return false;
    L19:
        Long r103 = this.f203400b.get(r100);     // Catch: Throwable -> L16
        if (r103 != null) goto L10;
        r103 = 0L;     // Catch: Throwable -> L16
    L10:
        if (r103.longValue() < r101) goto L14;
        r102 = true;
    L14:
        monitor-exit(this);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }
}
