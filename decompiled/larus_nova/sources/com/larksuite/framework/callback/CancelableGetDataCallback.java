package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes24.dex */
public class CancelableGetDataCallback<Data> extends CancelableCallback<IGetDataCallback<Data>> implements IGetDataCallback<Data> {
    public CancelableGetDataCallback(IGetDataCallback r100) {
        super(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        T r101 = this.callback;
        if (r101 == 0) goto L6;
        ((IGetDataCallback) r101).onError(r100);
        cancel();
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(Data r100) {
        T r101 = this.callback;
        if (r101 == 0) goto L6;
        ((IGetDataCallback) r101).onSuccess(r100);
        cancel();
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
