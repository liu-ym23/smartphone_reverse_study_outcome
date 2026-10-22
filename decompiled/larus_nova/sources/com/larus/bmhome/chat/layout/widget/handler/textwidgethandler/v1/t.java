package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes25.dex */
public final class t extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public t(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        FLogger.f375446a.e("MarkdownTextViewWidgetHandlerV2", "handler exception：" + r101);
    }
}
