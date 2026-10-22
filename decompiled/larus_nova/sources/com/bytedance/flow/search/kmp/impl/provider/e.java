package com.bytedance.flow.search.kmp.impl.provider;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements IIMCallback<List<? extends Message>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<List<Message>> f243642a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public e(SafeContinuation r100) {
        this.f243642a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Continuation<List<Message>> r101 = this.f243642a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(CollectionsKt.emptyList()));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(List<? extends Message> r100) {
        List<? extends Message> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f243642a.resumeWith(Result.m9449constructorimpl(r101));
    }
}
