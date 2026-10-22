package com.larus.audio.call.record;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public b(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        com.larus.audio.call.util.e.f289645a.e("AVInnerRecordAdapter", "[dispatchScope] exception: " + r101.getMessage(), r101);
    }
}
