package com.bytedance.assem.arch.extensions;

import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HostInjector {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(HostInjector$_defaultExecutor$2.INSTANCE);
        b = LazyKt.lazy(HostInjector$_reusedExecutor$2.INSTANCE);
    }

    public static Executor a() {
        return (Executor) a.getValue();
    }
}
