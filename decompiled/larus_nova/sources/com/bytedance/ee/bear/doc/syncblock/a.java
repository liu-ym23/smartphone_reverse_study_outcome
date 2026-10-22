package com.bytedance.ee.bear.doc.syncblock;

import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.functions.Consumer;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SyncBlockFragment f218284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BearUrl f218285b;

    public a(SyncBlockFragment r100, BearUrl r101) {
        this.f218284a = r100;
        this.f218285b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        SyncBlockFragment r103 = this.f218284a;
        int r104 = SyncBlockFragment.f218266q;
        r103.stopLoading();
        SyncBlockLoadingLayout r105 = this.f218284a.f218268h;
        if (r105 == null) goto L15;
        r105.a(-1);
        return;
    L15:
        return;
    L13:
        tt5.a.h("SyncBlockFragment", "fetchSourceToken success");
        SyncBlockFragment r106 = this.f218284a;
        BearUrl r107 = this.f218285b;
        int r108 = SyncBlockFragment.f218266q;
        r106.getClass();
        r107.f222561b = r101;
        r107.f222560a = e.f541304o.getType();
        r107.f222577r = "601";
        r106.V90(r107);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
