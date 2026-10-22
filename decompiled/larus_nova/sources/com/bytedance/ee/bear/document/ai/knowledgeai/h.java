package com.bytedance.ee.bear.document.ai.knowledgeai;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<com.ss.android.lark.inline.ai.api.knowledgeai.f> f218850a;

    public h(kotlinx.coroutines.j r100) {
        this.f218850a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f218850a.resumeWith(Result.m9449constructorimpl((com.ss.android.lark.inline.ai.api.knowledgeai.f) r100));
    }
}
