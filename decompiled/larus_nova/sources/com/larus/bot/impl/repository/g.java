package com.larus.bot.impl.repository;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import uc9.t;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements IIMCallback<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<ub8.b> f319365a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    public g(CompletableDeferred<ub8.b> r100) {
        this.f319365a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f319365a.complete(new ub8.b(null, r100, 3));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(t r100) {
        t r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f319365a.complete(new ub8.b(r101, null, 6));
    }
}
