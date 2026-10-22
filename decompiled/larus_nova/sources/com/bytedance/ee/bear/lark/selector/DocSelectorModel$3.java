package com.bytedance.ee.bear.lark.selector;

import com.bytedance.ee.bear.lark.selector.base.UICallback;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.SearchResponse;

/* JADX INFO: loaded from: classes16.dex */
class DocSelectorModel$3 implements IGetDataCallback<SearchResponse> {
    final /* synthetic */ b this$0;
    final /* synthetic */ UICallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        tt5.a.d("DocSelectorModel", "getCallback()...failed, error = " + r100);
        this.val$callback.onError(r100);
    }

    public void onSuccess(SearchResponse r100) {
        tt5.a.h("DocSelectorModel", "getCallback()...success");
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((SearchResponse) r100);
    }

    public DocSelectorModel$3(b r100, UICallback r101) {
        this.val$callback = r101;
    }
}
