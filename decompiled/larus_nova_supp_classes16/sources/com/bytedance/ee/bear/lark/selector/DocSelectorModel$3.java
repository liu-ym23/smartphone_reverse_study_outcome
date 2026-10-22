package com.bytedance.ee.bear.lark.selector;

import com.bytedance.ee.bear.lark.selector.base.UICallback;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.SearchResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class DocSelectorModel$3 implements IGetDataCallback<SearchResponse> {
    final /* synthetic */ b this$0;
    final /* synthetic */ UICallback val$callback;

    public void onError(ErrorResult r3) {
        tt5.a.d("DocSelectorModel", "getCallback()...failed, error = " + r3);
        this.val$callback.onError(r3);
    }

    public void onSuccess(SearchResponse r2) {
        tt5.a.h("DocSelectorModel", "getCallback()...success");
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((SearchResponse) r1);
    }

    public DocSelectorModel$3(b r1, UICallback r2) {
        this.val$callback = r2;
    }
}
