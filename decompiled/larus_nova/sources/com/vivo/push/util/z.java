package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class z extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f462610b;

    public final String c() {
        Context r100 = this.f462610b;
        String r101 = r100.getPackageName();
        Object r102 = ah.a(r100, r101, "com.vivo.push.app_id");
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        return r103;
    L12:
        return b("APP_APPID", "");
    L5:
        Object r104 = ah.a(r100, r101, "app_id");
        if (r104 == null) goto L8;
        r103 = r104.toString();
        goto L10
    L8:
        r103 = "";
        goto L10
    }

    public final String d() {
        Context r100 = this.f462610b;
        String r101 = r100.getPackageName();
        Object r102 = ah.a(r100, r101, "com.vivo.push.api_key");
        if (r102 == null) goto L5;
        String r103 = r102.toString();
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        return r103;
    L12:
        return b("APP_APIKEY", "");
    L5:
        Object r104 = ah.a(r100, r101, "api_key");
        if (r104 == null) goto L8;
        r103 = r104.toString();
        goto L10
    L8:
        r103 = "";
        goto L10
    }

    public z(Context r100) {
        if (r100 == null) goto L6;
        this.f462610b = r100;
        a(r100);
        return;
    }

    private synchronized void a(Context r100) {
        monitor-enter(this);
        a(r100, "com.vivo.push_preferences.appconfig_v1");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
