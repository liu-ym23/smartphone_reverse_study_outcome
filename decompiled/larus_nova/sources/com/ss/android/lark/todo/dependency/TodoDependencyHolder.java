package com.ss.android.lark.todo.dependency;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDependencyHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f441361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f441362b = null;

    static {
        f441361a = LazyKt.lazy(TodoDependencyHolder$dependency$2.INSTANCE);
        f441362b = LazyKt.lazy(TodoDependencyHolder$featureGating$2.INSTANCE);
    }

    public static a a() {
        return (a) f441361a.getValue();
    }

    public static a8c.a b() {
        return (a8c.a) f441362b.getValue();
    }
}
