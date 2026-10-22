package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes22.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a0 f268939a;

    public static void a() {
        if (f268939a == null) goto L5;
        return;
    L5:
        monitor-enter(a0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f268939a != null) goto L9;
        f268939a = new a0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a0.class);     // Catch: Throwable -> L11
    }

    public a0() {
        com.ss.android.account.k.d().getApplicationContext();
    }
}
