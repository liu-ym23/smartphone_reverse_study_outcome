package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes41.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bl f463195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f269a;

    private bl(Context r100) {
        this.f269a = r100;
    }

    public static bl a(Context r100) {
        if (f463195a != null) goto L15;
        monitor-enter(bl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463195a != null) goto L9;
        f463195a = new bl(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(bl.class);     // Catch: Throwable -> L11
    L15:
        return f463195a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m8855a(String r100, String r101, long r102) {
        monitor-enter(this);
        SharedPreferences.Editor r103 = this.f269a.getSharedPreferences(r100, 4).edit();     // Catch: Throwable -> L6
        r103.putLong(r101, r102);     // Catch: Throwable -> L6
        r103.commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m8856a(String r100, String r101, String r102) {
        monitor-enter(this);
        SharedPreferences.Editor r103 = this.f269a.getSharedPreferences(r100, 4).edit();     // Catch: Throwable -> L6
        r103.putString(r101, r102);     // Catch: Throwable -> L6
        r103.commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long a(String r100, String r101, long r102) {
        monitor-enter(this);
        long r103 = this.f269a.getSharedPreferences(r100, 4).getLong(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L7:
        return r102;
    }

    public synchronized String a(String r100, String r101, String r102) {
        monitor-enter(this);
        String r103 = this.f269a.getSharedPreferences(r100, 4).getString(r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L7:
        return r102;
    }
}
