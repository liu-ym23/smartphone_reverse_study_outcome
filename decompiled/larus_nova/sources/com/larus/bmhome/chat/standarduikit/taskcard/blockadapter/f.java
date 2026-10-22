package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements IIMCallback<Boolean> {
    public f() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.larus.im.callback.IIMCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Boolean r100) {
        r100.booleanValue();
    }
}
