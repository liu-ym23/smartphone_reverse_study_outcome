package com.ss.android.lark.threaddetail;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
class ThreadDetailModel$31 implements IGetDataCallback<com.ss.android.lark.biz.im.api.b> {
    final /* synthetic */ b this$0;
    final /* synthetic */ IGetDataCallback val$dataCallback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        this.val$dataCallback.onSuccess(0L);
        Log.e("ThreadDetailModel", "getAnonymityLeftCount error : " + r100.getDisplayMsg());
    }

    public void onSuccess(com.ss.android.lark.biz.im.api.b r100) {
        r100.getClass();
        this.val$dataCallback.onSuccess(0L);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((com.ss.android.lark.biz.im.api.b) r100);
    }

    public ThreadDetailModel$31(b r100, IGetDataCallback r101) {
        this.val$dataCallback = r101;
    }
}
