package com.bytedance.ee.bear.middleground.like.executor;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Consumer<AddLikeExecutor.AddLikeResult> {
    public final /* synthetic */ AddLikeExecutor a;

    public a(AddLikeExecutor r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        AddLikeExecutor.AddLikeResult r5 = (AddLikeExecutor.AddLikeResult) r4;
        tt5.a.b("AddLikeExecutor", "AddLikeExecutor doAction accept  result=" + r5);
        if (this.a.a == null) goto L6;
        tt5.a.b("AddLikeExecutor", "AddLikeExecutor accept: ref is not null ");
        this.a.a.a(r5.getCode(), ((Result) r5).msg, r5.getId());
        return;
    }
}
