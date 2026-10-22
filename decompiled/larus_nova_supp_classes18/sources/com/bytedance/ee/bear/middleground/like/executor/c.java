package com.bytedance.ee.bear.middleground.like.executor;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Consumer<ClearLikeExecutor.ClearLikeResult> {
    public final /* synthetic */ ClearLikeExecutor a;

    public c(ClearLikeExecutor r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        ClearLikeExecutor.ClearLikeResult r5 = (ClearLikeExecutor.ClearLikeResult) r4;
        tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor doAction accept  result=" + r5);
        if (this.a.a == null) goto L6;
        tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor accept: ref is not null ");
        this.a.a.a(r5.getCode(), ((Result) r5).msg, r5.getId());
        return;
    }
}
