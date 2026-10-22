package com.ss.android.lark.threaddetail;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;

/* JADX INFO: loaded from: classes38.dex */
class ThreadDetailModel$29 implements IGetDataCallback<ThreadTopic> {
    final /* synthetic */ b this$0;
    final /* synthetic */ a val$initData;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        if (r100.getErrorCode() != 4008) goto L5;
        throw null;
    L5:
        throw null;
    }

    public void onSuccess(ThreadTopic r100) {
        if (r100 != null) goto L5;
        throw null;
    L5:
        if (r100.isNoTraceDelete() == false) goto L7;
        throw null;
    L7:
        if (r100.isVisible() == false) goto L12;
        throw null;
    L12:
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((ThreadTopic) r100);
    }

    public ThreadDetailModel$29(b r100, a r101) {
    }
}
