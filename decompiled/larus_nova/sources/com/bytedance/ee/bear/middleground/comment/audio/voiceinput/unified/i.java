package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public i(CoroutineExceptionHandler.Key r100) {
        super(r100);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext r100, Throwable r101) {
        tt5.a.e("CommentVoice", "[flowObserver] coroutine failed", r101, false);
    }
}
