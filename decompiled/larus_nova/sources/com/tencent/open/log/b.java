package com.tencent.open.log;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes31.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f461788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f461790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f461791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f461792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f461793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f461794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f461795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f461796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f461797j;

    static {
        f461788a = d.C5545d.a("yy.MM.dd.HH");
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File r100 = e();
        if (r100 == null) goto L5;
        r100.mkdirs();
    L5:
        return r100;
    }

    public String c() {
        return this.f461789b;
    }

    public int d() {
        return this.f461792e;
    }

    public File e() {
        return this.f461794g;
    }

    public int f() {
        return this.f461795h;
    }

    public static String a(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        return new SimpleDateFormat("yy.MM.dd.HH").format(r101.getTime());
    }

    private String c(String r100) {
        return "com.tencent.mobileqq_connectSdk." + r100 + ".log";
    }

    private File[] d(long r100) {
        File r101 = b();
        String r102 = c(a(r100));
        r101 = new PolarisFileWrapper(r101, r102);     // Catch: Throwable -> L5
    L7:
        String r103 = m.b();
        if (TextUtils.isEmpty(r103) == false) goto L20;
        if (r103 != null) goto L20;
    L17:
        PolarisFileWrapper r104 = null;
    L19:
        return new File[]{r101, r104};
    L20:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, c.f461812o);     // Catch: Exception -> L15
        if (r105.exists() == true) goto L13;
        r105.mkdirs();     // Catch: Exception -> L15
    L13:
        r104 = new PolarisFileWrapper(r105, r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
    L5:
        th = move-exception;
        SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        goto L7
    }

    public void b(int r100) {
        this.f461791d = r100;
    }

    public void a(int r100) {
        this.f461790c = r100;
    }

    public void b(long r100) {
        this.f461793f = r100;
    }

    public void c(int r100) {
        this.f461792e = r100;
    }

    public void d(int r100) {
        this.f461795h = r100;
    }

    public void a(File r100) {
        this.f461794g = r100;
    }

    public void b(String r100) {
        this.f461796i = r100;
    }

    public void c(long r100) {
        this.f461797j = r100;
    }

    public void a(String r100) {
        this.f461789b = r100;
    }

    public b(File r100, int r101, int r102, int r103, String r104, long r105, int r110, String r111, long r112) {
        this.f461789b = "Tracer.File";
        this.f461790c = Integer.MAX_VALUE;
        this.f461791d = Integer.MAX_VALUE;
        this.f461792e = 4096;
        this.f461793f = 10000;
        this.f461795h = 10;
        this.f461796i = ".log";
        this.f461797j = Long.MAX_VALUE;
        a(r100);
        b(r101);
        a(r102);
        c(r103);
        a(r104);
        b(r105);
        d(r110);
        b(r111);
        c(r112);
    }
}
