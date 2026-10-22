package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.im.bean.message.MessageQueryResponse;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t implements IIMCallback<MessageQueryResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<MessageQueryResponse> f324280a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    public t(SafeContinuation r100) {
        this.f324280a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("PreviewMessageDataSource", "queryMessages failed: " + r100);
        this.f324280a.resumeWith(Result.m9449constructorimpl(null));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(MessageQueryResponse r100) {
        MessageQueryResponse r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f324280a.resumeWith(Result.m9449constructorimpl(r101));
    }
}
