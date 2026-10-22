package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
class SelectorPresenter$1 implements IGetDataCallback<List<Object>> {
    final /* synthetic */ c this$0;

    public SelectorPresenter$1(c r100) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        tt5.a.d("SelectorPresenter", "getRecommendDataAndShow() onError=" + r100);
        throw null;
    }

    public void onSuccess(List<Object> r100) {
        if (r100.isEmpty() == true) goto L5;
        throw null;
    L5:
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
}
