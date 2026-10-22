package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class fa implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f463524a = "wcc-ml-test10.bj";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f463525b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fd f563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f564a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f463526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f463527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f463528e;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo9090a() {
        return null;
    }

    public static final String a() {
        String r100 = f463525b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (w.m9434a() == false) goto L10;
        return "sandbox.xmpush.xiaomi.com";
    L10:
        if (w.b() == false) goto L13;
        return "10.38.162.35";
    L13:
        return "app.chat.xiaomi.net";
    }

    public String c() {
        if (this.f463527d != null) goto L6;
        this.f463527d = a();
    L6:
        return this.f463527d;
    }

    public String b() {
        return this.f463528e;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m9088a() {
        return this.f562a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9089a() {
        return this.f564a;
    }

    public static final void a(String r100) {
        if (w.b() == false) goto L5;
        return;
    L5:
        f463525b = r100;
    }

    public void b(String r100) {
        this.f463528e = r100;
    }

    public void c(String r100) {
        this.f463527d = r100;
    }

    public void a(boolean r100) {
        this.f564a = r100;
    }

    public fa(Map<String, Integer> r100, int r101, String r102, fd r103) {
        this.f564a = ez.f547a;
        this.f565b = true;
        a(r100, r101, r102, r103);
    }

    private void a(Map<String, Integer> r100, int r101, String r102, fd r103) {
        this.f562a = r101;
        this.f463526c = r102;
        this.f563a = r103;
    }
}
