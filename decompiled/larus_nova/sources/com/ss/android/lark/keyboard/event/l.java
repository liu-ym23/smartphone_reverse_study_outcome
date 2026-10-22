package com.ss.android.lark.keyboard.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes36.dex */
public interface l {
    void a();

    void b(Function2<? super g, ? super j, Boolean> r100);

    <E extends q> void c(Class<E> r100, Function2<? super g, ? super E, Unit> r101);

    <S extends m> void d(Class<S> r100, Function3<? super g, ? super S, ? super S, Unit> r101);
}
