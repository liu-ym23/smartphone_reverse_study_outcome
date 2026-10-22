package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r f464337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<String> f1126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f464338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f464339c;

    private r(Context r100) {
        this.f1126a = new ArrayList();
        this.f464338b = new ArrayList();
        this.f464339c = new ArrayList();
        Context r101 = r100.getApplicationContext();
        this.f1125a = r101;
        if (r101 != null) goto L5;
        this.f1125a = r100;
    L5:
        int r102 = 0;
        SharedPreferences r103 = this.f1125a.getSharedPreferences("mipush_app_info", 0);
        String[] r104 = r103.getString("unregistered_pkg_names", "").split(",");
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        String r107 = r104[r106];
        if (TextUtils.isEmpty(r107) == false) goto L10;
        this.f1126a.add(r107);
    L10:
        r106 = r106 + 1;
        goto L6
    L11:
        String[] r108 = r103.getString("disable_push_pkg_names", "").split(",");
        int r109 = r108.length;
        int r110 = 0;
    L12:
        if (r110 >= r109) goto L17;
        String r111 = r108[r110];
        if (TextUtils.isEmpty(r111) == true) goto L16;
        this.f464338b.add(r111);
    L16:
        r110 = r110 + 1;
        goto L12
    L17:
        String[] r112 = r103.getString("disable_push_pkg_names_cache", "").split(",");
        int r113 = r112.length;
    L18:
        if (r102 >= r113) goto L23;
        String r114 = r112[r102];
        if (TextUtils.isEmpty(r114) == true) goto L22;
        this.f464339c.add(r114);
    L22:
        r102 = r102 + 1;
        goto L18
    }

    public void a(String r100) {
        List<String> r101 = this.f1126a;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f1126a.contains(r100) == true) goto L7;
        this.f1126a.add(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f1126a, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void b(String r100) {
        List<String> r101 = this.f464338b;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f464338b.contains(r100) == true) goto L7;
        this.f464338b.add(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f464338b, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void c(String r100) {
        List<String> r101 = this.f464339c;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f464339c.contains(r100) == true) goto L7;
        this.f464339c.add(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f464339c, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void d(String r100) {
        List<String> r101 = this.f1126a;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f1126a.contains(r100) == false) goto L7;
        this.f1126a.remove(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f1126a, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void e(String r100) {
        List<String> r101 = this.f464338b;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f464338b.contains(r100) == false) goto L7;
        this.f464338b.remove(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f464338b, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void f(String r100) {
        List<String> r101 = this.f464339c;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f464339c.contains(r100) == false) goto L7;
        this.f464339c.remove(r100);     // Catch: Throwable -> L9
        String r102 = com.xiaomi.push.ba.a(this.f464339c, ",");     // Catch: Throwable -> L9
        this.f1125a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", r102).commit();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public static r a(Context r100) {
        if (f464337a != null) goto L6;
        f464337a = new r(r100);
    L6:
        return f464337a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9414b(String r100) {
        List<String> r101 = this.f464338b;
        monitor-enter(r101);
        boolean r102 = this.f464338b.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9415c(String r100) {
        List<String> r101 = this.f464339c;
        monitor-enter(r101);
        boolean r102 = this.f464339c.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9413a(String r100) {
        List<String> r101 = this.f1126a;
        monitor-enter(r101);
        boolean r102 = this.f1126a.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
