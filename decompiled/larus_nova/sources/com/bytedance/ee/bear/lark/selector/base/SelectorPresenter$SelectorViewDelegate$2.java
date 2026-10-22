package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
class SelectorPresenter$SelectorViewDelegate$2 implements IGetDataCallback<List<Object>> {
    final /* synthetic */ c.a this$1;

    public SelectorPresenter$SelectorViewDelegate$2(c.a r100) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        tt5.a.d("SelectorPresenter", "onLoadMore() onError=" + r100);
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(List<Object> r100) {
        throw null;
    }
}
