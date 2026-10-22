package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f269002a;

    public static i a() {
        if (f269002a != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269002a != null) goto L9;
        f269002a = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f269002a;
    }

    public i() {
    }
}
