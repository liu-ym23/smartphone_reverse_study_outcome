package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<KnowledgeAIControlInfoResponse> f218848a;

    public f(kotlinx.coroutines.j r100) {
        this.f218848a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f218848a.resumeWith(Result.m9449constructorimpl((KnowledgeAIControlInfoResponse) r100));
    }
}
