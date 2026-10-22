package com.bytedance.ee.bear.more.rename;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.more.itemv2.RenameItemV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f235008a;

    public b(RenameItemV2.a r100) {
        this.f235008a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        tt5.a.e("RenameSheetExecutor", "rename: ", r101, false);
        if ((r101 instanceof NetService.ServerErrorException) == false) goto L8;
        if (k0.b(((NetService.ServerErrorException) r101).getCode()) == false) goto L8;
        return;
    L8:
        if (((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).g(r101) == false) goto L10;
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.a(com.bytedance.ee.bear.review.a.class)).f(eu5.b.f474075a);
        return;
    L10:
        ((RenameItemV2.a) this.f235008a).a();
    }
}
