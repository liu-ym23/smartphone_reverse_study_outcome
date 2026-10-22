package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements IIMCallback<Message> {
    public g() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.larus.im.callback.IIMCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Message r100) {
    }
}
