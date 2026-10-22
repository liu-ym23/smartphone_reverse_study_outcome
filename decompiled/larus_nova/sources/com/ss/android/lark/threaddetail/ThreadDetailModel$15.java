package com.ss.android.lark.threaddetail;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
class ThreadDetailModel$15 implements IGetDataCallback<List<MessageInfo>> {
    final /* synthetic */ b this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(List<MessageInfo> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<MessageInfo> r102 = r100.iterator();
        if (r102.hasNext() == true) goto L8;
        IGetDataCallback r103 = this.val$callback;
        if (r103 == null) goto L10;
        r103.onSuccess(r101);
        return;
    L10:
        return;
    L8:
        MessageInfo r104 = r102.next();
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    public ThreadDetailModel$15(b r100, IGetDataCallback r101) {
        this.val$callback = r101;
    }
}
