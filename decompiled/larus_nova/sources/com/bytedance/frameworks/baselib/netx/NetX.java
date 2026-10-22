package com.bytedance.frameworks.baselib.netx;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes19.dex */
public final class NetX {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f244799a = null;

    public static class a {
        public a() {
        }
    }

    static {
        f244799a = LazyKt.lazy(LazyThreadSafetyMode.NONE, NetX$defaultConfig$2.INSTANCE);
    }
}
