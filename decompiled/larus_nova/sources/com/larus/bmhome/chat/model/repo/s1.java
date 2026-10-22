package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes25.dex */
public final class s1 implements IIMCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<Boolean> f307856a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public s1(CompletableDeferred<Boolean> r100) {
        this.f307856a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f307856a.complete(Boolean.FALSE);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Boolean r100) {
        boolean r101 = r100.booleanValue();
        this.f307856a.complete(Boolean.valueOf(r101));
    }
}
