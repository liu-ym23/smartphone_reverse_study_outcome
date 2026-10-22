package com.larus.bmhome.chat.component.share;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes25.dex */
public final class j1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public j1(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        FLogger.f375446a.e("FileExportTypeChooseDialog", "error from coroutine, " + r101);
    }
}
