package com.larus.bmhome.chat.cotdetail.component;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b0 implements IIMCallback<Boolean> {
    public b0() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return !y0.a();
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("CotDetailMessageListComponent", "interruptMessage onFailure error: " + r100);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Boolean r100) {
        r100.booleanValue();
        FLogger.f375446a.d("CotDetailMessageListComponent", "interruptMessage onSuccess");
    }
}
