package com.bytedance.reparo.core;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile o f267410f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f267411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c97.a f267412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f267413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f267414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f267415e;

    public o() {
    }

    public static o c() {
        if (f267410f != null) goto L13;
        monitor-enter(o.class);
        f267410f = new o();     // Catch: Throwable -> L9
        monitor-exit(o.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f267410f;
    }

    public final void a() {
        if (this.f267413c == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("has not initialized.");
    }

    public final int b() {
        a();
        c97.b r100 = (c97.b) this.f267412b;
        int r101 = -1;
        if (r100.f22860c != (-1)) goto L27;
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.f22858a.getApplicationInfo().sourceDir));     // Catch: IOException -> L23
        Set r103 = c97.b.a(r102);     // Catch: IOException -> L23
        r102.close();     // Catch: IOException -> L23
        HashSet r104 = (HashSet) r103;     // Catch: IOException -> L23
        boolean r105 = true;
        if (r104.contains("armeabi") == false) goto L8;
    L13:
        int r106 = 1;
    L15:
        if (r104.contains("arm64-v8a") == true) goto L20;
        if (r104.contains("x86_64") == true) goto L20;
        r105 = false;
    L20:
        if (r105 == false) goto L22;
        r101 = r106 | 2;
    L25:
        r100.f22860c = r101;
        goto L27
    L22:
        r101 = r106;
        goto L25
    L8:
        if (r104.contains("armeabi-v7a") == true) goto L13;
        if (r104.contains("x86") == true) goto L13;
        r106 = 0;
    L23:
        e = move-exception;
        e.printStackTrace();
        k.b("AbiHelper", "parse host abi failed. ", e);
    L27:
        return r100.f22860c;
    }

    public final Map<c97.h, d97.d> e() {
        a();
        l r100 = this.f267414d;
        r100.e();
        return r100.f267389h;
    }

    public final void f(l.d r100) {
        a();
        l r101 = this.f267414d;
        if (r101.f267388g != null) goto L6;
        r101.f267388g = new ArrayList();
    L6:
        if (((ArrayList) r101.f267388g).contains(r100) == true) goto L9;
        ((ArrayList) r101.f267388g).add(r100);
        return;
    }

    public void update(p r100) {
        a();
        this.f267414d.update(r100);
    }

    public final void d(Application r100, g r110, String r111, c97.a r112, boolean r113, boolean r114) {
        if (this.f267413c == false) goto L5;
        return;
    L5:
        this.f267411a = r100;
        this.f267412b = r112;
        i r101 = new i(r100);
        r101.f267377g = false;
        r101.f267378h = r114;
        this.f267415e = r101;
        l r115 = new l(this.f267411a, r101, r110, this.f267412b, r111, r113);
        this.f267414d = r115;
        String r116 = r115.f267385d.a();
        if (TextUtils.isEmpty(r116) == true) goto L11;
        if (TextUtils.equals(r115.f267393l, r116) == true) goto L11;
        c97.e r117 = r115.f267385d;
        r117.f22871a = r115.f267393l;
        r115.b(false);
    L14:
        this.f267413c = true;
        return;
    L11:
        if (TextUtils.isEmpty(r115.f267385d.a()) == false) goto L13;
        c97.e r118 = r115.f267385d;
        r118.f22871a = r115.f267393l;
    L13:
        r115.f(false);
        goto L14
    }
}
