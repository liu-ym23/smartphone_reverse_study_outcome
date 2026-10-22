package com.ss.android.lark.keyboard.dependency;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardAssemblerModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f428707a = null;

    static {
        f428707a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KeyboardAssemblerModule$sDependency$2.INSTANCE);
    }

    public static a a() {
        return (a) f428707a.getValue();
    }
}
