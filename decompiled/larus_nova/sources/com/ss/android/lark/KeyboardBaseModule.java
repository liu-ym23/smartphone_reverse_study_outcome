package com.ss.android.lark;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes34.dex */
public final class KeyboardBaseModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f408533a = null;

    static {
        f408533a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KeyboardBaseModule$sDependency$2.INSTANCE);
    }

    public static d a() {
        return (d) f408533a.getValue();
    }
}
