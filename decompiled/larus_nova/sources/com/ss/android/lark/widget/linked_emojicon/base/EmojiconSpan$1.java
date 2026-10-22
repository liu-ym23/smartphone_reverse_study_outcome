package com.ss.android.lark.widget.linked_emojicon.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes38.dex */
class EmojiconSpan$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ a this$0;
    final /* synthetic */ WeakReference val$wrListener;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(Boolean r100) {
        if (this.val$wrListener.get() == null) goto L6;
        ((a.InterfaceC5401a) this.val$wrListener.get()).a();
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }

    public EmojiconSpan$1(a r100, WeakReference r101) {
        this.this$0 = r100;
        this.val$wrListener = r101;
    }
}
