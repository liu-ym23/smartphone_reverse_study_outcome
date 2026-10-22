package com.bytedance.ee.bear.doc.syncblock;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import io.reactivex.functions.Consumer;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ SyncBlockFragment a;
    public final /* synthetic */ BearUrl b;

    public b(SyncBlockFragment r1, BearUrl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        tt5.a.f("SyncBlockFragment", r9, false);
        SyncBlockFragment r0 = this.a;
        int r2 = SyncBlockFragment.q;
        r0.stopLoading();
        if ((r9 instanceof NetService.ServerErrorException) == false) goto L27;
        SyncBlockFragment r1 = this.a;
        BearUrl r4 = this.b;
        NetService.ServerErrorException r10 = (NetService.ServerErrorException) r9;
        r1.getClass();
        int r5 = r10.getCode();
        if (r5 == 4) goto L24;
        if (r5 != 1002) goto L9;
        r10.getMessage();
        SyncBlockLoadingLayout r11 = r1.h;
        if (r11 == null) goto L20;
        r11.setOnClickListener(null);
        r11.setVisibility(0);
    L20:
        SyncBlockLoadingLayout r12 = r1.h;
        if (r12 == null) goto L37;
        r12.a(PreviewStatus.OVER_MUCH_NODES_IN_TOTAL);
        return;
    L37:
        return;
    L9:
        if (r5 == 10051) goto L16;
        r10.getMessage();
        SyncBlockLoadingLayout r13 = r1.h;
        if (r13 == null) goto L13;
        r13.setOnClickListener(null);
        r13.setVisibility(0);
    L13:
        SyncBlockLoadingLayout r14 = r1.h;
        if (r14 == null) goto L34;
        r14.a(-1);
        return;
    L34:
        return;
    L16:
        r1.W90(r4);
        return;
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authorise") == false) goto L26;
        r4.b = "";
        r4.a = e.o.getType();
        r4.r = "601";
        r1.V90(r4);
        return;
    L26:
        r1.W90(r4);
        return;
    L27:
        SyncBlockFragment r3 = this.a;
        r9.getMessage();
        SyncBlockLoadingLayout r16 = r3.h;
        if (r16 == null) goto L30;
        r16.setOnClickListener(null);
        r16.setVisibility(0);
    L30:
        SyncBlockLoadingLayout r17 = r3.h;
        if (r17 == null) goto L41;
        r17.a(-1);
        return;
    }
}
