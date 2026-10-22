package com.cmic.ida.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f273099c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f273100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f273101b;

    private d(Context r100) {
        this.f273101b = r100.getApplicationContext();
        this.f273100a = e.a();
    }

    public static d a(Context r100) {
        if (f273099c != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273099c != null) goto L9;
        f273099c = new d(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f273099c;
    }
}
