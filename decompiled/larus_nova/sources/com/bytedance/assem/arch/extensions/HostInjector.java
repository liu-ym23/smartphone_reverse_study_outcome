package com.bytedance.assem.arch.extensions;

import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class HostInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f192919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f192920b = null;

    static {
        f192919a = LazyKt.lazy(HostInjector$_defaultExecutor$2.INSTANCE);
        f192920b = LazyKt.lazy(HostInjector$_reusedExecutor$2.INSTANCE);
    }

    public static Executor a() {
        return (Executor) f192919a.getValue();
    }
}
