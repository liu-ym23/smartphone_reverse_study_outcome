package com.bytedance.kmp.performance.api;

import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes19.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutexImpl f252683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MemoryThresholdGcController f252684b = null;

    static {
        f252683a = kotlinx.coroutines.sync.b.a();
        f252684b = new MemoryThresholdGcController();
    }
}
