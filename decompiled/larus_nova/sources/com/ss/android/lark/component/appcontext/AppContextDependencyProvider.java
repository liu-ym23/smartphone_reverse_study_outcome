package com.ss.android.lark.component.appcontext;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes35.dex */
public final class AppContextDependencyProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f417275a = null;

    static {
        f417275a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AppContextDependencyProvider$contextInitDependency$2.INSTANCE);
    }
}
