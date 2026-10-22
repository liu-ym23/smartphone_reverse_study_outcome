package com.bytedance.navigation.kmp;

import d37.i;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public f(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        i r102 = i.f466749a;
        i.e("CoroutineScope exception", r101);
    }
}
