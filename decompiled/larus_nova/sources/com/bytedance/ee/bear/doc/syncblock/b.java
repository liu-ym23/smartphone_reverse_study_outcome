package com.bytedance.ee.bear.doc.syncblock;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.functions.Consumer;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SyncBlockFragment f218286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BearUrl f218287b;

    public b(SyncBlockFragment r100, BearUrl r101) {
        this.f218286a = r100;
        this.f218287b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.f("SyncBlockFragment", r101, false);
        SyncBlockFragment r102 = this.f218286a;
        int r103 = SyncBlockFragment.f218266q;
        r102.stopLoading();
        if ((r101 instanceof NetService.ServerErrorException) == false) goto L27;
        SyncBlockFragment r104 = this.f218286a;
        BearUrl r105 = this.f218287b;
        NetService.ServerErrorException r106 = (NetService.ServerErrorException) r101;
        r104.getClass();
        int r107 = r106.getCode();
        if (r107 == 4) goto L24;
        if (r107 != 1002) goto L9;
        r106.getMessage();
        SyncBlockLoadingLayout r108 = r104.f218268h;
        if (r108 == null) goto L20;
        r108.setOnClickListener(null);
        r108.setVisibility(0);
    L20:
        SyncBlockLoadingLayout r109 = r104.f218268h;
        if (r109 == null) goto L37;
        r109.a(1002);
        return;
    L37:
        return;
    L9:
        if (r107 == 10051) goto L16;
        r106.getMessage();
        SyncBlockLoadingLayout r110 = r104.f218268h;
        if (r110 == null) goto L13;
        r110.setOnClickListener(null);
        r110.setVisibility(0);
    L13:
        SyncBlockLoadingLayout r111 = r104.f218268h;
        if (r111 == null) goto L34;
        r111.a(-1);
        return;
    L34:
        return;
    L16:
        r104.W90(r105);
        return;
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docs.synced_block.permission.authorise") == false) goto L26;
        r105.f222561b = "";
        r105.f222560a = e.f541304o.getType();
        r105.f222577r = "601";
        r104.V90(r105);
        return;
    L26:
        r104.W90(r105);
        return;
    L27:
        SyncBlockFragment r112 = this.f218286a;
        r101.getMessage();
        SyncBlockLoadingLayout r113 = r112.f218268h;
        if (r113 == null) goto L30;
        r113.setOnClickListener(null);
        r113.setVisibility(0);
    L30:
        SyncBlockLoadingLayout r114 = r112.f218268h;
        if (r114 == null) goto L41;
        r114.a(-1);
        return;
    }
}
