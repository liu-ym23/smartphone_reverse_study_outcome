package com.obric.assistant.network.restrict;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f390358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f390359b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f390360c = null;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.network.restrict.a] */
    static {
        f390358a = new AtomicBoolean(false);
        f390359b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f390360c = new a();
    }
}
