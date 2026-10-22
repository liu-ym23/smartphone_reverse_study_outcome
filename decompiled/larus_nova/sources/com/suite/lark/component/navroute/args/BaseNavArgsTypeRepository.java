package com.suite.lark.component.navroute.args;

import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseNavArgsTypeRepository implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f460275a;

    public abstract void a(Map<KClass<?>, c<?>> r100);

    public BaseNavArgsTypeRepository() {
        this.f460275a = LazyKt.lazy(new BaseNavArgsTypeRepository$argsTypeMap$2(this));
    }

    @Override // com.suite.lark.component.navroute.args.b
    public <T> c<T> getType(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Object r101 = ((HashMap) this.f460275a.getValue()).get(r100);
        if ((r101 instanceof c) == false) goto L5;
        c<T> r102 = (c) r101;
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException("args type not found: " + r100);
    L5:
        r102 = null;
        goto L6
    }
}
