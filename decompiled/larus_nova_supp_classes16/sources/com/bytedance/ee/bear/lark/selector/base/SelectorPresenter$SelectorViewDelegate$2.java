package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class SelectorPresenter$SelectorViewDelegate$2 implements IGetDataCallback<List<Object>> {
    final /* synthetic */ c.a this$1;

    public SelectorPresenter$SelectorViewDelegate$2(c.a r1) {
    }

    public void onError(ErrorResult r3) {
        tt5.a.d("SelectorPresenter", "onLoadMore() onError=" + r3);
        throw null;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(List<Object> r1) {
        throw null;
    }
}
