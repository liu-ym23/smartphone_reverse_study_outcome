package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes24.dex */
public interface IGetDataCallback<Data> extends IRequestCallback<Data, ErrorResult> {

    /* JADX INFO: renamed from: com.larksuite.framework.callback.IGetDataCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<Data> {
        public static /* bridge */ /* synthetic */ void $default$onError(IGetDataCallback r100, Object r101) {
            r100.onError((ErrorResult) r101);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    void onError(ErrorResult r100);

    @Override // com.larksuite.framework.callback.IRequestCallback
    /* bridge */ /* synthetic */ void onError(ErrorResult r100);

    @Override // com.larksuite.framework.callback.IRequestCallback
    void onSuccess(Data r100);
}
