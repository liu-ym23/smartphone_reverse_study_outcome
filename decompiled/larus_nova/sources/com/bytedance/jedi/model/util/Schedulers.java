package com.bytedance.jedi.model.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/util/Schedulers;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class Schedulers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Schedulers f251200a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f251201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f251202c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f251203d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f251204e = null;

    private Schedulers() {
    }

    static {
        f251200a = new Schedulers();
        f251201b = LazyKt.lazy(Schedulers$CPU_COUNT$2.INSTANCE);
        f251202c = LazyKt.lazy(Schedulers$CORE_POOL_SIZE$2.INSTANCE);
        f251203d = LazyKt.lazy(Schedulers$MAXIMUM_POOL_SIZE$2.INSTANCE);
        f251204e = LazyKt.lazy(Schedulers$defaultScheduler$2.INSTANCE);
    }
}
