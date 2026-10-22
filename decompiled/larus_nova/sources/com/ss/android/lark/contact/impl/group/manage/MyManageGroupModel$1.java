package com.ss.android.lark.contact.impl.group.manage;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
class MyManageGroupModel$1 implements IGetDataCallback<List<Chat>> {
    final /* synthetic */ d this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(List<Chat> r100) {
        this.this$0.h(r100);
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
        onSuccess((List) r100);
    }

    public MyManageGroupModel$1(d r100, IGetDataCallback r101) {
        this.this$0 = r100;
        this.val$callback = r101;
    }
}
