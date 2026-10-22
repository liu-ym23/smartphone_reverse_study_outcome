package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes24.dex */
public abstract class GetSuccessDataCallback<Data> implements IGetDataCallback<Data> {
    public GetSuccessDataCallback() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public abstract void onSuccess(Data r100);

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
