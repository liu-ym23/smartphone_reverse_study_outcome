package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.android.ec.core.anchorv3.q {
    public final /* synthetic */ HeadLynxAbilityManager e;

    public final void c() {
        AnchorV4HeadV2VO r0 = this.e.d.K10();     // Catch: Throwable -> L18
        if (r0 == null) goto L30;
        List<HeaderContentModel> r1 = r0.getCells();     // Catch: Throwable -> L18
        if (r1 == null) goto L31;
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L18
    L8:
        if (r2.hasNext() == false) goto L32;
        HeaderContentModel r3 = (HeaderContentModel) r2.next();     // Catch: Throwable -> L18
        if (r3.getLynx() == null) goto L8;
        if (r3.getLynx().c() == false) goto L8;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r4 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(this.e.d.getContext(), this.e.d);     // Catch: Throwable -> L18
        r4.l(r3.getLynx(), 0, null);     // Catch: Throwable -> L18
        HeadLynxAbilityManager r5 = this.e;     // Catch: Throwable -> L18
        String r6 = r3.getLynx().a();     // Catch: Throwable -> L18
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r5.d(r6, r4);     // Catch: Throwable -> L18
        goto L8
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L18:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }

    public j(HeadLynxAbilityManager r1) {
        this.e = r1;
        super(3);
    }
}
