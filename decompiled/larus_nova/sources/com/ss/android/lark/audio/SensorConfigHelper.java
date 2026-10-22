package com.ss.android.lark.audio;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes34.dex */
public final class SensorConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f408965a;

    public static final class a {
    }

    static {
    }

    public SensorConfigHelper() {
        this.f408965a = LazyKt.lazy(LazyThreadSafetyMode.NONE, SensorConfigHelper$config$2.INSTANCE);
    }
}
