package com.obric.assistant.complex_task;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f387941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Job> f387942b;

    public t() {
        CoroutineScope r100 = CoroutineScopeKt.MainScope();
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        this.f387941a = r100;
        this.f387942b = new ConcurrentHashMap();
    }
}
