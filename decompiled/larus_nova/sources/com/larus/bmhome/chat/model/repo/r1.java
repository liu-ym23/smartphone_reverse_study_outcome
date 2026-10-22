package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes25.dex */
public final class r1 implements IIMCallback<wc9.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<wc9.k> f307854a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public r1(CompletableDeferred<wc9.k> r100) {
        this.f307854a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f307854a.complete(null);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(wc9.k r100) {
        wc9.k r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f307854a.complete(r101);
    }
}
