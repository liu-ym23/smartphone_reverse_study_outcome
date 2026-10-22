package com.bytedance.ee.bear.lark.selector.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class SelectorPresenter$1 implements IGetDataCallback<List<Object>> {
    final /* synthetic */ c this$0;

    public SelectorPresenter$1(c r1) {
    }

    public void onError(ErrorResult r3) {
        tt5.a.d("SelectorPresenter", "getRecommendDataAndShow() onError=" + r3);
        throw null;
    }

    public void onSuccess(List<Object> r2) {
        if (r2.isEmpty() == true) goto L5;
        throw null;
    L5:
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }
}
