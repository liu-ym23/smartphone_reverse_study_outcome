package com.vivo.push.f;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;
import com.vivo.push.util.aa;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Boolean f462324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Boolean f462325b;

    public a() {
        this.f462324a = null;
        this.f462325b = null;
    }

    private synchronized boolean c(Context r100) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f462325b == null) goto L8;
        boolean r101 = this.f462325b.booleanValue();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r101;
    L8:
        boolean r102 = true;
        if (r100 != null) goto L12;
        monitor-exit(this);
        return true;
    L12:
        boolean r103 = aa.d(r100, r100.getPackageName());     // Catch: Throwable -> L20
        if (aa.c(r100, r100.getPackageName()) == true) goto L17;
        if (r103 == true) goto L17;
        r102 = false;
    L17:
        this.f462325b = Boolean.valueOf(r102);     // Catch: Throwable -> L20
        boolean r104 = this.f462325b.booleanValue();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r104;
    }

    private synchronized boolean d(Context r100) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (this.f462324a == null) goto L8;
        boolean r101 = this.f462324a.booleanValue();     // Catch: Throwable -> L35
        monitor-exit(this);
        return r101;
    L8:
        if (r100 != null) goto L38;
        t.c("ConfigSecureUtil", "checkHasService paramContext is empty ");     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L38:
    L30:
        e = move-exception;
        t.a("ConfigSecureUtil", "checkHasService error " + e.getMessage());     // Catch: Throwable -> L35
        this.f462324a = Boolean.TRUE;     // Catch: Throwable -> L35
    L32:
        boolean r102 = this.f462324a.booleanValue();     // Catch: Throwable -> L35
        monitor-exit(this);
        return r102;
    L14:
        if (aa.c(r100, r100.getPackageName()) == false) goto L16;
        String r103 = "com.vivo.push.sdk.service.CommandClientService";
    L17:
        ServiceInfo[] r104 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 4).services;     // Catch: Exception -> L30 Throwable -> L35
        if (r104 != null) goto L20;
        t.c("ConfigSecureUtil", "checkHasService serviceInfos is empty ");     // Catch: Exception -> L30 Throwable -> L35
        this.f462324a = Boolean.TRUE;     // Catch: Exception -> L30 Throwable -> L35
    L20:
        int r105 = r104.length;     // Catch: Exception -> L30 Throwable -> L35
        int r106 = 0;
    L21:
        if (r106 >= r105) goto L28;
        if (r103.equals(((ComponentInfo) r104[r106]).name) == true) goto L24;
        r106 = r106 + 1;
        goto L21
    L24:
        this.f462324a = Boolean.TRUE;     // Catch: Exception -> L30 Throwable -> L35
        boolean r107 = this.f462324a.booleanValue();     // Catch: Exception -> L30 Throwable -> L35
        monitor-exit(this);
        return r107;
    L28:
        this.f462324a = Boolean.FALSE;     // Catch: Exception -> L30 Throwable -> L35
        goto L32
    L16:
        r103 = "com.vivo.push.sdk.service.CommandService";
        goto L17
    }

    public final synchronized byte[] a(Context r100) {
        monitor-enter(this);
        byte[] r101 = new byte[16];     // Catch: Throwable -> L12
        r101[0] = 34;     // Catch: Throwable -> L12
        r101[1] = 32;     // Catch: Throwable -> L12
        r101[2] = 33;     // Catch: Throwable -> L12
        r101[3] = 37;     // Catch: Throwable -> L12
        if (d(r100) == false) goto L7;
        r101[4] = 33;     // Catch: Throwable -> L12
        r101[5] = 34;     // Catch: Throwable -> L12
        r101[6] = 32;     // Catch: Throwable -> L12
        r101[7] = 33;     // Catch: Throwable -> L12
    L7:
        r101[8] = 33;     // Catch: Throwable -> L12
        r101[9] = 33;     // Catch: Throwable -> L12
        r101[10] = 34;     // Catch: Throwable -> L12
        r101[11] = 41;     // Catch: Throwable -> L12
        if (c(r100) == false) goto L10;
        r101[12] = 35;     // Catch: Throwable -> L12
        r101[13] = 32;     // Catch: Throwable -> L12
        r101[14] = 32;     // Catch: Throwable -> L12
        r101[15] = 32;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized byte[] b(Context r110) {
        monitor-enter(this);
        byte[] r100 = new byte[16];     // Catch: Throwable -> L12
        r100[0] = 33;     // Catch: Throwable -> L12
        r100[1] = 34;     // Catch: Throwable -> L12
        r100[2] = 35;     // Catch: Throwable -> L12
        r100[3] = 36;     // Catch: Throwable -> L12
        if (d(r110) == false) goto L7;
        r100[4] = 37;     // Catch: Throwable -> L12
        r100[5] = 38;     // Catch: Throwable -> L12
        r100[6] = 39;     // Catch: Throwable -> L12
        r100[7] = 40;     // Catch: Throwable -> L12
    L7:
        r100[8] = 41;     // Catch: Throwable -> L12
        r100[9] = 32;     // Catch: Throwable -> L12
        r100[10] = 38;     // Catch: Throwable -> L12
        r100[11] = 37;     // Catch: Throwable -> L12
        if (c(r110) == false) goto L10;
        r100[12] = 36;     // Catch: Throwable -> L12
        r100[13] = 35;     // Catch: Throwable -> L12
        r100[14] = 34;     // Catch: Throwable -> L12
        r100[15] = 33;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r100;
    L12:
        th = move-exception;
        throw th;
    }
}
