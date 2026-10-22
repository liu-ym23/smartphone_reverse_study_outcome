package com.ss.android.lark.passportc.internal;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultPassportExecutorsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f438305a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f438306b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f438307c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f438308d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f438309e = null;

    static {
        f438305a = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_WORKER_EXECUTOR$2.INSTANCE);
        f438306b = LazyKt.lazy(DefaultPassportExecutorsKt$BACKGROUND_WORKER_EXECUTOR$2.INSTANCE);
        f438307c = CoreThreadPool.getDefault().getUIExecutor();
        f438308d = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_PARALLEL_EXECUTOR$2.INSTANCE);
        f438309e = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_PARALLEL_SCHEDULER$2.INSTANCE);
    }
}
