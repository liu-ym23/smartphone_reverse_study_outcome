package com.larus.xbridge.custom;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes32.dex */
public final class z extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public z(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        FLogger.f375446a.e("AppSaveFileMethod", "error from coroutine, " + r101);
    }
}
