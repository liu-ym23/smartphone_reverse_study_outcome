package com.ss.android.lark.integrator.todo;

import e7c.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class TodoModuleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<jnb.a> f428135a = null;

    public static final class a {
    }

    static {
        f428135a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TodoModuleProvider$Companion$instance$2.INSTANCE);
    }

    @JvmStatic
    public static final c a() {
        return f428135a.getValue();
    }
}
