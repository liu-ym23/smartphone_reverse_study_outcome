package com.bytedance.memory.heap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import gs3.e;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import r17.g;
import r17.h;
import s17.c;
import w17.j;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f265495e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f265496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f265497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile HeapDump f265498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile SharedPreferences f265499d;

    public final void a() {
        this.f265498c = null;
        c.b().a();
    }

    public static a b() {
        if (f265495e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f265495e != null) goto L9;
        f265495e = new a(q17.a.e().getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f265495e;
    }

    public final SharedPreferences d() {
        if (this.f265499d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f265499d != null) goto L8;
        this.f265499d = e.b(this.f265496a, "MemoryWidgetSp");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f265499d;
    }

    public final void j() {
        if (this.f265497b == false) goto L6;
        return;
    L6:
        if (b().d().getBoolean("hasShrink", false) == false) goto L10;
        r17.c.b("HeapSaver shrink hasShrinked", new Object[0]);
        com.bytedance.memory.upload.c.f();
        return;
    L10:
        if (c.b().c() == false) goto L62;
        String r100 = b().d().getString("updateVersionCode", "");
        if (c.b().f540159a.length() > 31457280) goto L14;
    L58:
        r17.c.b("HeapSaver shrink return deleteCache. updateVersionCode:" + r100, new Object[0]);
        b().a();
        x17.a.f562123j.c("shrink_error_dumpInvalid");
        return;
    L14:
        if (TextUtils.isEmpty(r100) == true) goto L58;
        this.f265497b = true;
        Process.setThreadPriority(10);
        if (b().f265498c == null) goto L19;
        long r101 = b().f265498c.currentTime;
    L20:
        PolarisFileWrapper r102 = c.b().f540159a;
        String r103 = r102.getName().substring(0, r102.getName().lastIndexOf("."));
        if (t17.a.a("performance_modules", "memory", "memory_upload_origin") == false) goto L29;
        PolarisFileWrapper r104 = new PolarisFileWrapper(c.b().f540163e, "dump.hprof");
        if (r102.getPath().contains("jpg") == false) goto L25;
        r102.renameTo(r104);
    L25:
        PolarisFileWrapper r105 = new PolarisFileWrapper(c.b().f540161c, r103.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r101))) + "_" + r100 + "_origin.zip");
        long r106 = System.currentTimeMillis();
        HashMap<String, Object> r107 = new HashMap();
        r107.put("before_hprof_compress_size", Long.valueOf(r104.length()));
        x17.a r108 = x17.a.f562123j;
        r108.b("compress_begin", r107);
        h.b(r104, r105);
        r17.c.b("compress origin file succeed", new Object[0]);
        t17.a.d("origin_compress_time", System.currentTimeMillis() - r106);
        t17.a.d("origin_compress_size", r105.length() / 1024);
        HashMap<String, Object> r109 = new HashMap();
        r108.f562128e = r105.length();
        r108.b("compress_end", r109);
        if (r104.exists() == false) goto L28;
        r104.delete();
    L28:
        b().f(1);
        b().h(true);
        b().g(r105.getAbsolutePath());
    L54:
        c r110 = c.b();
        if (r110.f540159a.exists() == false) goto L57;
        r110.f540159a.delete();
    L57:
        this.f265497b = false;
        Process.setThreadPriority(0);
        com.bytedance.memory.upload.c.f();
        return;
    L29:
        r17.c.b("shrink begin with path %s, length %s ", new Object[]{r102.getPath(), Long.valueOf(r102.length())});
    L37:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "realShrink failed");
        th.printStackTrace();
    L39:
        PolarisFileWrapper r111 = null;
    L40:
        if (r111 != null) goto L42;
    L53:
        r17.c.b("shrink failed deleteCache", new Object[0]);
        x17.a.f562123j.c("shrink_failed");
        b().a();
        goto L54
    L42:
        if (r111.length() < 31457280) goto L44;
    L46:
        r17.c.b("shrink succeed", new Object[0]);
        long r112 = System.currentTimeMillis();
        x17.a.f562123j.c("compressFile");
        PolarisFileWrapper r113 = new PolarisFileWrapper(r111.getParentFile(), r111.getName().substring(0, r111.getName().lastIndexOf(".")) + ".zip");
        h.b(r111, r113);
        if (r113.exists() == false) goto L49;
        r111.delete();
    L49:
        t17.a.d("shrink_compress_time", System.currentTimeMillis() - r112);
        t17.a.d("shrink_compress_size", r113.length() / 1024);
        PolarisFileWrapper r114 = new PolarisFileWrapper(r113.getParent(), new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r101)) + "_" + r100 + "_shrink.zip");
        if (r113.exists() == false) goto L52;
        r113.renameTo(r114);
    L52:
        b().h(true);
        b().g(r114.getAbsolutePath());
        goto L54
    L44:
        if (b().d().getInt("hprof_type", 1) != 2) goto L46;
    L31:
        if (r102.exists() == false) goto L39;
        PolarisFileWrapper r115 = c.b().f540162d;     // Catch: Throwable -> L37
        if (r115.exists() == true) goto L35;
        r115.mkdirs();     // Catch: Throwable -> L37
    L35:
        r111 = j.a(r102, new PolarisFileWrapper(r115, "dump.hprof"));     // Catch: Throwable -> L37
        goto L40
    L19:
        r101 = System.currentTimeMillis();
        goto L20
    }

    public final String c() {
        return d().getString("latestFilePath", "");
    }

    public a(Context r100) {
        this.f265499d = null;
        this.f265496a = r100.getApplicationContext();
    }

    public final void e(HeapDump r100) {
        this.f265498c = r100;
        PolarisFileWrapper r101 = c.b().f540160b;
        if (r101.exists() == false) goto L5;
        r101.delete();
    L5:
        r17.c.b("analyzedHeapFile.getHeapDumpFilePath() %s", new Object[]{r101.getPath()});
        d().edit().putString("filePath", r101.getPath()).commit();
        JSONObject r102 = new JSONObject();
        PolarisFileOutputStreamWrapper r103 = null;
        k(r100, r102);     // Catch: Throwable -> L14 Exception -> L16
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L14 Exception -> L16
        r104.write(r102.toString().getBytes());     // Catch: Throwable -> L10 Exception -> L12
        r104.close();     // Catch: IOException -> L27
        return;
    L42:
        return;
    L12:
        Exception e100 = e;
        r103 = r104;
    L34:
        r17.c.a(e100, "Could not save leak analysis result to disk.", new Object[0]);     // Catch: Throwable -> L22
        if (r103 == null) goto L43;
        r103.close();     // Catch: IOException -> L29
        return;
    L44:
        return;
    L43:
        return;
    L22:
        Throwable th10 = th;
    L23:
        th = th10;
    L24:
        if (r103 != null) goto L36;
    L26:
        throw th;
    L36:
        r103.close();     // Catch: IOException -> L28
    L10:
        th10 = th;
        r103 = r104;
        goto L23
    L16:
        e = move-exception;
        e100 = e;
    L14:
        th = th;
        goto L24
    }

    public final void f(int r100) {
        d().edit().putInt("hprof_type", r100).commit();
    }

    public final void g(String r100) {
        d().edit().putString("latestFilePath", r100).commit();
    }

    public final void h(boolean r100) {
        d().edit().putBoolean("hasShrink", r100).commit();
    }

    public final void i(String r100) {
        d().edit().putString("updateVersionCode", r100).commit();
    }

    public static void k(HeapDump r100, JSONObject r101) throws JSONException {
        r101.put("heapDumpFilePath", r100.heapDumpFile.getPath());
        r101.put("shrinkFilePath", r100.shrinkFilePath);
        r101.put("heapDumpFileSize", r100.heapDumpFile.length());
        r101.put("referenceName", r100.referenceName);
        r101.put("isDebug", r100.isDebug);
        r101.put("gcDurationMs", r100.gcDurationMs);
        r101.put("watchDurationMs", r100.watchDurationMs);
        r101.put("dumpDurationMs", r100.heapDumpDurationMs);
        r101.put("currentTime", r100.currentTime);
    }

    public static HeapDump l(JSONObject r100, PolarisFileWrapper r101) {
        HeapDump.b r102 = HeapDump.newBuilder();
        r102.getClass();
        r102.f265486b = r101;
        r102.f265494j = r100.optLong("currentTime");
        r100.optLong("heapDumpFileSize");
        String r103 = r100.optString("referenceName");
        g.a(r103, "referenceName");
        r102.f265489e = r103;
        r102.f265485a = r100.optBoolean("isDebug");
        r102.f265491g = r100.optLong("gcDurationMs");
        r102.f265490f = r100.optLong("watchDurationMs");
        r102.f265492h = r100.optLong("dumpDurationMs");
        r102.f265487c = r100.optString("shrinkFilePath");
        g.a(r102.f265486b, "heapDumpFile");
        return new HeapDump(r102, null);
    }
}
