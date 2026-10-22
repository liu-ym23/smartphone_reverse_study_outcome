package com.bytedance.ies.sve_core;

import com.bytedance.ies.sve_core.a;
import com.bytedance.ies.sve_core.s;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class ReducerCombineContext<S extends s, A extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<? extends A>, Function2<S, A, S>> f248682a;

    public final Function2<S, A, S> a() {
        return (Function2<S, A, S>) new ReducerCombineContext$build$1(this);
    }

    public ReducerCombineContext() {
        this.f248682a = new LinkedHashMap();
    }
}
