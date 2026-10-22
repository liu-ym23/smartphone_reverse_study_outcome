package com.ss.android.lark.threaddetail;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
class ThreadDetailModel$9 implements IGetDataCallback<Integer> {
    final /* synthetic */ b this$0;
    final /* synthetic */ String val$reactionType;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.e("ThreadDetailModel", "Reaction failed:", r100);
    }

    public void onSuccess(Integer r100) {
        Log.d("ThreadDetailModel", "Add reaction success， key is:" + this.val$reactionType);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Integer) r100);
    }

    public ThreadDetailModel$9(b r100, String r101) {
        this.val$reactionType = r101;
    }
}
