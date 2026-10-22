package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f464129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f966a;

    private n(Context r100) {
        this.f964a = r100;
        this.f965a = new Handler(Looper.getMainLooper());
        this.f966a = new HashMap();
    }

    public static n a(Context r100) {
        if (f464129a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464129a != null) goto L9;
        f464129a = new n(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f464129a;
    }

    public static /* synthetic */ Context a(n r100) {
        return r100.f964a;
    }

    private synchronized String a(String r100, String r101) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.f966a == null) goto L22;
        if (TextUtils.isEmpty(r100) == true) goto L22;
        if (TextUtils.isEmpty(r101) == true) goto L22;
        Map<String, String> r102 = this.f966a.get(r100);     // Catch: Throwable -> L18
        if (r102 == null) goto L16;
        String r103 = r102.get(r101);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r103;
    L16:
        monitor-exit(this);
        return "";
    L18:
        return "";
    L22:
        monitor-exit(this);
        return "";
    }

    private synchronized void b(String r100, String r101, String r102) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f966a != null) goto L6;
        this.f966a = new HashMap();     // Catch: Throwable -> L12
    L6:
        Map<String, String> r103 = this.f966a.get(r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L9;
        r103 = new HashMap();     // Catch: Throwable -> L12
    L9:
        r103.put(r101, r102);     // Catch: Throwable -> L12
        this.f966a.put(r100, r103);     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public synchronized String a(String r100, String r101, String r102) {
        monitor-enter(this);
        String r103 = a(r100, r101);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r103) == true) goto L7;
        monitor-exit(this);
        return r103;
    L7:
        String r104 = this.f964a.getSharedPreferences(r100, 4).getString(r101, r102);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r104;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9303a(final String r100, final String r101, final String r102) {
        monitor-enter(this);
        b(r100, r101, r102);     // Catch: Throwable -> L6
        this.f965a.post(new AnonymousClass1(this, r100, r101, r102));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
