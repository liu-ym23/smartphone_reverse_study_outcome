package com.bytedance.navigation.kmp.listener;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes21.dex */
public final class o extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public o(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        d37.i r102 = d37.i.f466749a;
        d37.i.e("CoroutineScope exception", r101);
    }
}
