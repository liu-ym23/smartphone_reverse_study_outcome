package com.larus.dora.impl.core;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraSyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f332165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Job f332166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static w0 f332167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f332168d = null;

    public DoraSyncManager() {
    }

    static {
        f332165a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f332168d = new AtomicBoolean(false);
    }

    public static final void a() {
        boolean r100 = false;
        if (f332168d.compareAndSet(false, true) == false) goto L13;
        Job r101 = f332166b;
        if (r101 != null) goto L7;
    L9:
        if (r100 == false) goto L11;
        g49.d.d("DoraSyncManager", "startHeartbeat: job is active");
        return;
    L11:
        f332166b = BuildersKt.launch$default(f332165a, null, null, new DoraSyncManager$startHeartbeat$1(null), 3, null);
        return;
    L7:
        if (r101.isActive() != true) goto L9;
        r100 = true;
        goto L9
    }

    public static void c(String r100) {
        BuildersKt.launch$default(f332165a, null, null, new DoraSyncManager$syncCurrent$1(r100, null), 3, null);
    }

    public static final void b(String r100, int r101, String r102) {
        BuildersKt.launch$default(f332165a, null, null, new DoraSyncManager$sync$1(r100, r101, r102, null), 3, null);
    }
}
