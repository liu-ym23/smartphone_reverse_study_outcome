package com.larus.bmhome.chat.detail.table;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f302846a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public n(AppCompatImageView r100) {
        this.f302846a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f302846a.setEnabled(false);
        this.f302846a.setAlpha(0.5f);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Message r100) {
    }
}
