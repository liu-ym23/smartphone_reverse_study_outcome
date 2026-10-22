package com.bytedance.ee.bear.lark.selector;

import com.bytedance.ee.bear.lark.selector.base.UICallback;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class DocSelectorModel$1 implements IGetDataCallback<c5b.a> {
    final /* synthetic */ b this$0;
    final /* synthetic */ UICallback val$callback;

    public void onError(ErrorResult r2) {
        this.val$callback.onError(r2);
    }

    public void onSuccess(c5b.a r3) {
        r3.getClass();
        tt5.a.h("DocSelectorModel", "loadDocsHistory()...success, size = " + hu5.a.c(null));
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((c5b.a) r1);
    }

    public DocSelectorModel$1(b r1, UICallback r2) {
        this.val$callback = r2;
    }
}
