package com.larus.search.impl.combine;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x implements IIMCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f367617a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    public x(String r100) {
        this.f367617a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.w("CombineSearchFragment", "keepConversationOnTop failed, conversationId: " + this.f367617a + " error: " + r100);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Boolean r100) {
        boolean r101 = r100.booleanValue();
        FLogger.f375446a.i("CombineSearchFragment", "keepConversationOnTop success, conversationId: " + this.f367617a + " result: " + r101);
    }
}
