package com.bytedance.ies.sve_core;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BaseEffect implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Store f248666a;

    public BaseEffect(Store r100) {
        this.f248666a = r100;
    }

    public final <C extends e> C b(f<C> r100) {
        return (C) Store.useConstant$default(this.f248666a, r100, null, 2, null);
    }

    public final <S extends s> Pair<o<S>, Function1<s, Unit>> c(final u<S> r100) {
        Function1<s, Unit> r101 = new BaseEffect$useState$modify$1(this, r100);
        return new Pair(this.f248666a.useState(r100, null, null), r101);
    }
}
