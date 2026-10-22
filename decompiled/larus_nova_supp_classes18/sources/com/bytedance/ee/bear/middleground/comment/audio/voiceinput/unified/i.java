package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public i(CoroutineExceptionHandler.Key r1) {
        super(r1);
    }

    public final void handleException(CoroutineContext r3, Throwable r4) {
        tt5.a.e("CommentVoice", "[flowObserver] coroutine failed", r4, false);
    }
}
