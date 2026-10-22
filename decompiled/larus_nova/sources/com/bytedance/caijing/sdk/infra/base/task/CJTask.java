package com.bytedance.caijing.sdk.infra.base.task;

import com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CJTask<V> extends FutureTask<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<CJThreadService> f202763b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f202764a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f202763b = LazyKt.lazy(CJTask$Companion$service$2.INSTANCE);
    }

    public CJTask(Callable<V> r100) {
        Intrinsics.checkNotNullParameter(r100, "callable");
        super(r100);
    }
}
