package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes25.dex */
public final class s extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public s(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        FLogger.f375446a.e("MarkdownTextViewWidgetHandler", "handler exception：" + r101);
    }
}
