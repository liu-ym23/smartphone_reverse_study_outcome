package com.bytedance.android.shopping.prepurchase.business.pdp.services.sku;

import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ PdpSKUService$onAttach$1.d c;

    @Override // java.lang.Runnable
    public final void run() {
        CommonMeta r0 = this.c.b.getData().a().a();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.c.a.this$0, "update sku select info:" + r0);
        Integer r1 = null;
        if (r0 == null) goto L7;
        List r2 = r0.getSkuSpecInfo();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.size());
    L8:
        SkuRestoreState r4 = this.c.a.this$0.j;
        if (r4 == null) goto L14;
        String[] r5 = r4.getSelectSkuKeys();
        if (r5 == null) goto L14;
        r1 = Integer.valueOf(r5.length);
    L14:
        if (Intrinsics.areEqual(r3, r1) == false) goto L32;
        if (r0 == null) goto L38;
        List r6 = r0.getSkuSpecInfo();
        if (r6 == null) goto L39;
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L20:
        if (r7.hasNext() == false) goto L40;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        SkuSpecInfo r11 = (SkuSpecInfo) r9;
        if (com.bytedance.android.shopping.anchorv3.a.b(r11.getSelectSpecId()) == false) goto L31;
        SkuRestoreState r12 = this.c.a.this$0.j;
        if (r12 == null) goto L31;
        String[] r13 = r12.getSelectSkuKeys();
        if (r13 == null) goto L31;
        r13[r8] = r11.getSelectSpecId();
    L31:
        r8 = r10;
        goto L20
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L32:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public a(PdpSKUService$onAttach$1.d r1) {
        this.c = r1;
        super("update_sku_select_info");
    }
}
