package com.larus.bmhome.chat.component.title;

import com.bytedance.services.apm.api.EnsureManager;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes25.dex */
public final class s1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public s1(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        EnsureManager.ensureNotReachHere(r101);
    }
}
