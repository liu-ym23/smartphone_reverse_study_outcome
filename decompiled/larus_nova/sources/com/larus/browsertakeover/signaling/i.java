package com.larus.browsertakeover.signaling;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniDispatchCommandAcceptedResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements IIMCallback<OmniDispatchCommandAcceptedResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalPcSignaling.b f319602a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public i(LocalPcSignaling.b r100) {
        this.f319602a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        final LocalPcSignaling.b r101 = this.f319602a;
        r101.c(new g(r101));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(OmniDispatchCommandAcceptedResponse r100) {
        final OmniDispatchCommandAcceptedResponse r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        final LocalPcSignaling.b r102 = this.f319602a;
        r102.c(new h(r102, r101));
    }
}
