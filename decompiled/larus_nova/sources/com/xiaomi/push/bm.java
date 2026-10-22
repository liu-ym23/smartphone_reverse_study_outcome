package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bm f463196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ad.a f271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bw f272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bx f273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ad.a f463197b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ad.a f463198c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final String f276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f463199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f463200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f463201f;

    private boolean a() {
        return com.xiaomi.push.service.ah.a(this.f270a).a(gj.f463752bn.a(), true);
    }

    private String c() {
        return this.f270a.getDatabasePath(bn.f278a).getAbsolutePath();
    }

    public String b() {
        return this.f463201f;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8859a() {
        return this.f463200e;
    }

    private bm(Context r100) {
        this.f274a = "push_stat_sp";
        this.f275b = "upload_time";
        this.f276c = "delete_time";
        this.f463199d = "check_time";
        this.f271a = new AnonymousClass1(this);
        this.f463197b = new AnonymousClass2(this);
        this.f463198c = new AnonymousClass3(this);
        this.f270a = r100;
    }

    private void b(String r100) {
        SharedPreferences.Editor r101 = this.f270a.getSharedPreferences("push_stat_sp", 0).edit();
        r101.putLong(r100, System.currentTimeMillis());
        o.a(r101);
    }

    public void a(gi r100) {
        if (a() == true) goto L6;
        return;
    L6:
        if (com.xiaomi.push.service.az.a(r100.e()) == true) goto L8;
        return;
    L8:
        String r101 = c();
        a(bs.a(this.f270a, r101, r100));
    }

    public static bm a(Context r100) {
        if (f463196a != null) goto L15;
        monitor-enter(bm.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463196a != null) goto L9;
        f463196a = new bm(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(bm.class);     // Catch: Throwable -> L11
    L15:
        return f463196a;
    }

    public void a(String r100) {
        if (a() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        a(by.a(this.f270a, r100));
    }

    public void a(bv.a r100) {
        bv.a(this.f270a).a(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ String m8858a(bm r100) {
        return r100.c();
    }

    public static /* synthetic */ Context a(bm r100) {
        return r100.f270a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ bx m8857a(bm r100) {
        return r100.f273a;
    }

    public static /* synthetic */ void a(bm r100, String r101) {
        r100.b(r101);
    }

    public void a(String r100, String r101, Boolean r102) {
        if (this.f272a != null) goto L5;
        return;
    L5:
        if (r102.booleanValue() == false) goto L7;
        this.f272a.a(this.f270a, r101, r100);
        return;
    L7:
        this.f272a.b(this.f270a, r101, r100);
    }
}
