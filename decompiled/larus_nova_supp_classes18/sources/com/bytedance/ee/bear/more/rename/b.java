package com.bytedance.ee.bear.more.rename;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.more.itemv2.RenameItemV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Consumer<Throwable> {
    public final /* synthetic */ c a;

    public b(RenameItemV2.a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        NetService.ServerErrorException r5 = (Throwable) r4;
        tt5.a.e("RenameSheetExecutor", "rename: ", r5, false);
        if ((r5 instanceof NetService.ServerErrorException) == false) goto L8;
        if (k0.b(r5.getCode()) == false) goto L8;
        return;
    L8:
        if (((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).g(r5) == false) goto L10;
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).f(eu5.b.a);
        return;
    L10:
        ((RenameItemV2.a) this.a).a();
    }
}
