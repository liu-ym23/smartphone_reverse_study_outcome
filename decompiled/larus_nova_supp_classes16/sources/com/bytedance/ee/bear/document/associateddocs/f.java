package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.CreateAndAssociatedDocResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public f(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Result r5 = (Result) r4;
        int r0 = r5.code;
        if (r0 != 0) goto L10;
        a.e r1 = this.a;
        CreateAndAssociatedDocResult r6 = (CreateAndAssociatedDocResult) r5.data;
        if (r6 == null) goto L8;
        String r7 = r6.getUrl();
        if (r7 == null) goto L8;
    L9:
        r1.a(r0, r7);
        return;
    L8:
        r7 = "";
        goto L9
    L10:
        this.a.a(-1, null);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, code = " + r5.code + ", msg = " + r5.msg);
    }
}
