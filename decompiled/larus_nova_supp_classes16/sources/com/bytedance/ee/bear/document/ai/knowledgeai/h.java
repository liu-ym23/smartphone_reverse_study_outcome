package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> a;

    public h(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.resumeWith(Result.constructor-impl((com.ss.android.lark.inline.ai.api.knowledgeai.f) r2));
    }
}
