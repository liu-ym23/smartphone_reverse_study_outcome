package com.cmic.sso.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.e.k;

/* JADX INFO: loaded from: classes22.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f273293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f273294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f273295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f273296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f273297e;

    private void c() {
        com.cmic.sso.sdk.e.c.b("UmcConfigManager", "delete localConfig");
        this.f273296d.c();
    }

    public a a() {
        return this.f273294b.m();
    L5:
        return this.f273295c;
    }

    private void b() {
        String r100 = k.b("sdk_config_version", "");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        b r101 = b.a(true);
        this.f273296d = r101;
        this.f273294b = r101.a();
        if (TextUtils.isEmpty(r100) == true) goto L10;
        c();
    L10:
        this.f273296d.a(this);
        this.f273295c = this.f273296d.a();
        return;
    L5:
        if (AuthnHelper.SDK_VERSION.equals(r100) == false) goto L7;
        b r102 = b.a(false);
        this.f273296d = r102;
        this.f273294b = r102.b();
        goto L10
    }

    private c(Context r100) {
        this.f273297e = r100;
        b();
    }

    public static c a(Context r100) {
        if (f273293a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273293a != null) goto L9;
        f273293a = new c(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f273293a;
    }

    public void a(com.cmic.sso.sdk.a r100) {
        this.f273296d.a(r100);
    }

    @Override // com.cmic.sso.sdk.a.b.a
    public void a(a r100) {
        this.f273294b = r100;
    }
}
