package com.larus.dora.impl.core;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f332199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f332200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Integer f332201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f332202d;

    static {
        f332199a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void a(boolean r100) {
        f332202d = r100;
        g49.d.d("DoraBatterySyncManager", "updateForceSyncState: connected=" + r100 + ", shouldForceSyncOnNextBatteryChanged=" + f332202d);
    }
}
