package com.suite.lark.component.navroute.args;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f460276a;

    static {
    }

    @Override // com.suite.lark.component.navroute.args.b
    public <T> c<T> getType(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        b r101 = f460276a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
        r101 = null;
    L6:
        return r101.getType(r100);
    }
}
