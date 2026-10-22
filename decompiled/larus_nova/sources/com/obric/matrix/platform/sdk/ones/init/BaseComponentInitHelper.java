package com.obric.matrix.platform.sdk.ones.init;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class BaseComponentInitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaseComponentInitHelper f396992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f396993b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f396994c = null;

    public BaseComponentInitHelper() {
    }

    static {
        f396992a = new BaseComponentInitHelper();
        new AtomicBoolean(false);
        f396993b = new AtomicBoolean(false);
        new AtomicBoolean(true);
        new AtomicBoolean(false);
        f396994c = LazyKt.lazy(BaseComponentInitHelper$initExecutor$2.INSTANCE);
    }
}
