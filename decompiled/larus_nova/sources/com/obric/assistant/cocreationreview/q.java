package com.obric.assistant.cocreationreview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f387657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f387658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, AtomicBoolean> f387659c;

    public q() {
        this.f387657a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f387658b = new AtomicBoolean(false);
        this.f387659c = new ConcurrentHashMap();
    }
}
