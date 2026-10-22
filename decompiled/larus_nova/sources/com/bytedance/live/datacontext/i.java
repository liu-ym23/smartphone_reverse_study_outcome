package com.bytedance.live.datacontext;

import io.reactivex.Maybe;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public interface i<T> extends h<T> {
    @Override // com.bytedance.live.datacontext.h, com.bytedance.live.datacontext.j
    Maybe<T> b();

    void c(Function1<? super T, Unit> r100);
}
