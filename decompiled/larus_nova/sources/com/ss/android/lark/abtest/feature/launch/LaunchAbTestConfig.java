package com.ss.android.lark.abtest.feature.launch;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes34.dex */
public final class LaunchAbTestConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<iua.a<?>> f408536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f408537b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f408538c = null;

    static {
        ArrayList r100 = new ArrayList();
        f408536a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        f408537b = LazyKt.lazy(r101, LaunchAbTestConfig$strategy$2.INSTANCE);
        f408538c = LazyKt.lazy(r101, LaunchAbTestConfig$isLaunchOptimizationEnable$2.INSTANCE);
        r100.add(new b());
    }
}
