package com.larus.kmp.voice_setting.voice.bridge;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements IIMCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<Boolean> f351866a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    public h(CompletableDeferred<Boolean> r100) {
        this.f351866a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f351866a.complete(Boolean.FALSE);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Boolean r100) {
        boolean r101 = r100.booleanValue();
        this.f351866a.complete(Boolean.valueOf(r101));
    }
}
