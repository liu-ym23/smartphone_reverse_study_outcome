package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes35.dex */
public class MessageSender$ReSendMessageCallback implements IGetDataCallback<String>, u, m6b.p {
    private final IGetDataCallback<String> originalCallback;

    public MessageSender$ReSendMessageCallback(IGetDataCallback<String> r100) {
        this.originalCallback = r100;
    }

    @Override // m6b.p
    public void onBeginSendMessage(Message r100) {
        IGetDataCallback<String> r101 = this.originalCallback;
        if ((r101 instanceof m6b.p) == false) goto L6;
        ((m6b.p) r101).onBeginSendMessage(r100);
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        com.ss.android.lark.chat.utils.n0.a(r100);
        this.originalCallback.onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((String) r100);
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r100) {
        IGetDataCallback<String> r101 = this.originalCallback;
        if ((r101 instanceof u) == false) goto L6;
        ((u) r101).onUpdateMediaCompressProgress(r100);
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(String r100) {
        this.originalCallback.onSuccess(r100);
    }
}
