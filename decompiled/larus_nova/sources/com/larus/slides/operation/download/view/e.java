package com.larus.slides.operation.download.view;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes31.dex */
public final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public e(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        FLogger.f375446a.e("SlidesExportChooseDialog", "error from coroutine, " + r101);
    }
}
