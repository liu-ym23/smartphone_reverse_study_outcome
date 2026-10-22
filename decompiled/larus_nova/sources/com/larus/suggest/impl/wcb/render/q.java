package com.larus.suggest.impl.wcb.render;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface q {
    Object a(l r100, Continuation<? super n> r101);

    Object b(Continuation<? super Unit> r100);

    void c();

    void cancel();

    boolean isActive();
}
