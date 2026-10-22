package com.ss.android.lark.contact.base.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes35.dex */
class DefaultOfficeContactRepository$4 implements IGetDataCallback<com.ss.android.lark.contact.base.dto.a> {
    final /* synthetic */ y this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(com.ss.android.lark.contact.base.dto.a r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onSuccess(r100);
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((com.ss.android.lark.contact.base.dto.a) r100);
    }

    public DefaultOfficeContactRepository$4(y r100, IGetDataCallback r101) {
        this.this$0 = r100;
        this.val$callback = r101;
    }
}
