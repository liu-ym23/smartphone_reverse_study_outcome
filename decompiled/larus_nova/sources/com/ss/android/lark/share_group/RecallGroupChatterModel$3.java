package com.ss.android.lark.share_group;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
class RecallGroupChatterModel$3 implements IGetDataCallback<List<GroupRecallEntity>> {
    final /* synthetic */ e this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        this.val$callback.onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(List<GroupRecallEntity> r100) {
        this.val$callback.onSuccess(r100);
    }

    public RecallGroupChatterModel$3(e r100, IGetDataCallback r101) {
        this.this$0 = r100;
        this.val$callback = r101;
    }
}
