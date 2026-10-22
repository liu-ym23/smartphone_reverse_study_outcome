package com.ss.android.lark.threaddetail;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes38.dex */
class ThreadDetailModel$7 implements IGetDataCallback<x4b.a<MessageInfo>> {
    final /* synthetic */ b this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        this.val$callback.onError(r100);
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((x4b.a) r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(x4b.a<MessageInfo> r100) {
        throw null;
    }

    public ThreadDetailModel$7(b r100, IGetDataCallback r101) {
        this.val$callback = r101;
    }
}
