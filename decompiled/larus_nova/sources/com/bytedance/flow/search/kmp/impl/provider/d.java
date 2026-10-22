package com.bytedance.flow.search.kmp.impl.provider;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements IIMCallback<wc9.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<wc9.j> f243641a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return false;
    }

    public d(SafeContinuation r100) {
        this.f243641a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f243641a.resumeWith(Result.m9449constructorimpl(null));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(wc9.j r100) {
        wc9.j r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f243641a.resumeWith(Result.m9449constructorimpl(r101));
    }
}
