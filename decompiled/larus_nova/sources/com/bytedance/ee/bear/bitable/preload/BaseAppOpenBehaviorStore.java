package com.bytedance.ee.bear.bitable.preload;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes15.dex */
public final class BaseAppOpenBehaviorStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaseAppOpenBehaviorStore f214964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f214965b = null;

    public BaseAppOpenBehaviorStore() {
    }

    static {
        f214964a = new BaseAppOpenBehaviorStore();
        f214965b = LazyKt.lazy(LazyThreadSafetyMode.NONE, BaseAppOpenBehaviorStore$sp$2.INSTANCE);
    }
}
