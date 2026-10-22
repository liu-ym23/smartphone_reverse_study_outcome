package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> a;

    public i(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> r5 = this.a;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(new com.ss.android.lark.inline.ai.api.knowledgeai.f(0)));
    }
}
