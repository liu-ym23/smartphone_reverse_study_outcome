package com.bytedance.live.datacontext;

import io.reactivex.Maybe;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public interface h<T> {
    Maybe<?> b();

    boolean d(T r100);

    boolean e(Function0<? extends T> r100);

    T getValue();

    boolean hasValue();
}
