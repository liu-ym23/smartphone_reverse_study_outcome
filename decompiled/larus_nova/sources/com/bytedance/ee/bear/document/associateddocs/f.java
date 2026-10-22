package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.CreateAndAssociatedDocResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218994a;

    public f(a.e r100) {
        this.f218994a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        int r102 = r101.code;
        if (r102 != 0) goto L10;
        a.e r103 = this.f218994a;
        CreateAndAssociatedDocResult r104 = (CreateAndAssociatedDocResult) r101.data;
        if (r104 == null) goto L8;
        String r105 = r104.getUrl();
        if (r105 == null) goto L8;
    L9:
        r103.a(r102, r105);
        return;
    L8:
        r105 = "";
        goto L9
    L10:
        this.f218994a.a(-1, null);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, code = " + r101.code + ", msg = " + r101.msg);
    }
}
