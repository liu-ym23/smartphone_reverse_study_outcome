package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class SelectorPresenter$SelectorViewDelegate$1 implements IGetDataCallback<List<Object>> {
    final /* synthetic */ c.a this$1;

    public SelectorPresenter$SelectorViewDelegate$1(c.a r1) {
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(List<Object> r5) {
        if (hu5.a.f(r5) == false) goto L6;
        tt5.a.h("SelectorPresenter", "onSuccess dataList size is " + r5.size());
        throw null;
    L6:
        tt5.a.h("SelectorPresenter", "onSuccess dataList size is empty");
        throw null;
    }

    public void onError(ErrorResult r1) {
        throw null;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }
}
