package com.larus.bmhome.chat.component.list;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k6 implements IIMCallback<String> {
    public k6() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.larus.im.callback.IIMCallback
    public final /* bridge */ /* synthetic */ void onSuccess(String r100) {
    }
}
