package com.obric.assistant.reporter;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f391353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f391354b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f391355c = null;

    static {
        f391353a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        if (Build.VERSION.SDK_INT < 24) goto L5;
        long r100 = Process.getStartElapsedRealtime();
    L6:
        f391354b = r100;
        f391355c = LazyKt.lazy(new d());
        return;
    L5:
        r100 = SystemClock.elapsedRealtime();
        goto L6
    }
}
