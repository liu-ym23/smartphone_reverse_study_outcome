package com.bytedance.crash;

import com.bytedance.crash.runtime.ConfigManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConfigManager f203096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static wh4.e f203097b;

    public a0() {
    }

    static {
        f203096a = new ConfigManager();
        new AppDataCenter();
    }

    public static wh4.e a() {
        if (f203097b != null) goto L13;
        monitor-enter(a0.class);
        f203097b = new wh4.e();     // Catch: Throwable -> L9
        monitor-exit(a0.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f203097b;
    }
}
