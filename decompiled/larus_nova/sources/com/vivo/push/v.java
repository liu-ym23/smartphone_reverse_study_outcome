package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462612b;

    public static long c() {
        return 0;
    }

    public abstract void c(d r100);

    public abstract void d(d r100);

    public boolean d() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final String a() {
        return this.f462612b;
    }

    public final int b() {
        return this.f462611a;
    }

    public v(int r100) {
        this.f462611a = -1;
        if (r100 < 0) goto L7;
        this.f462611a = r100;
        return;
    L7:
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(d r100) {
        r100.a("command", this.f462611a);
        r100.a("client_pkgname", this.f462612b);
        c(r100);
    }

    public final void a(Intent r100) {
        d r101 = d.a(r100);
        if (r101 != null) goto L6;
        com.vivo.push.util.t.b("PushCommand", "bundleWapper is null");
        return;
    L6:
        a(r101);
        Bundle r102 = r101.b();
        if (r102 == null) goto L10;
        r100.putExtras(r102);
        return;
    }

    public final void b(Intent r100) {
        d r101 = d.a(r100);
        if (r101 != null) goto L6;
        com.vivo.push.util.t.b("PushCommand", "bundleWapper is null");
        return;
    L6:
        r101.a(com.alipay.sdk.m.p.e.f25671s, this.f462611a);
        e(r101);
        Bundle r102 = r101.b();
        if (r102 == null) goto L10;
        r100.putExtras(r102);
        return;
    }

    public final void a(d r100) {
        String r101 = x.a(this.f462611a);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.a(com.alipay.sdk.m.p.e.f25671s, r101);
        e(r100);
    }

    public final void b(d r100) {
        String r101 = r100.a();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f462612b = r101;
    L6:
        d(r100);
        return;
    L5:
        this.f462612b = r100.a("client_pkgname");
        goto L6
    }

    public final void a(String r100) {
        this.f462612b = r100;
    }
}
