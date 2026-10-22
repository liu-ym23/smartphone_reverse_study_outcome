package com.bytedance.iesgurd.utils;

import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class GeckoExecutors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f250868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f250869b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f250870c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f250871d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f250872e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f250873f = null;

    public static Executor a() {
        return (Executor) f250872e.getValue();
    }

    static {
        f250868a = LazyKt.lazy(GeckoExecutors$checkUpdateExecutor$2.INSTANCE);
        f250869b = LazyKt.lazy(GeckoExecutors$delayHandler$2.INSTANCE);
        f250870c = LazyKt.lazy(GeckoExecutors$updateExecutor$2.INSTANCE);
        f250871d = LazyKt.lazy(GeckoExecutors$accessExecutor$2.INSTANCE);
        f250872e = LazyKt.lazy(GeckoExecutors$callbackExecutor$2.INSTANCE);
        f250873f = LazyKt.lazy(GeckoExecutors$ioExecutor$2.INSTANCE);
    }
}
