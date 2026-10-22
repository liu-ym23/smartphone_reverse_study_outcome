package com.larus.tts.impl;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes31.dex */
public final class m extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public m(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r101);
    }
}
