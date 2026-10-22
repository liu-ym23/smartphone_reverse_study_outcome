package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> f218851a;

    public i(kotlinx.coroutines.j r100) {
        this.f218851a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> r102 = this.f218851a;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(new com.ss.android.lark.inline.ai.api.knowledgeai.f(0)));
    }
}
