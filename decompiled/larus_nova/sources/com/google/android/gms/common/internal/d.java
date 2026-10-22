package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f274536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f274537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f274538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f274539d;

    static {
        f274536a = new Object();
    }

    public static void a(Context r100) {
        Object r101 = f274536a;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f274537b == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L8:
        f274537b = true;     // Catch: Throwable -> L17
        String r102 = r100.getPackageName();     // Catch: Throwable -> L17
        Bundle r103 = Wrappers.packageManager(r100).getApplicationInfo(r102, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L20 Throwable -> L17
        if (r103 != null) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L14:
        f274538c = r103.getString("com.google.app.id");     // Catch: PackageManager.NameNotFoundException -> L20 Throwable -> L17
        f274539d = r103.getInt("com.google.android.gms.version");     // Catch: PackageManager.NameNotFoundException -> L20 Throwable -> L17
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
    }
}
