package com.bytedance.android.shopping.store.hybridproduct;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements com.bytedance.android.shopping.store.restore.k {
    public final int a;
    public final /* synthetic */ ECShopHybridProductListPresenter b;
    public final /* synthetic */ int c;

    @Override // com.bytedance.android.shopping.store.restore.k
    public final com.bytedance.android.shopping.store.restore.j a() {
        ECShopHybridProductListPresenter r0 = this.b;
        ECHybridListEngine r1 = r0.n;
        if (r1 == null) goto L6;
        com.bytedance.android.ec.hybrid.list.entity.k r2 = r1.c.g;
        if (r2 == null) goto L6;
    L7:
        ECHybridListEngine r3 = this.b.n;
        if (r3 == null) goto L29;
        ECHybridRecyclerView r4 = r3.b;
        if (r4 == null) goto L29;
        boolean r5 = false;
        View r6 = r4.getChildAt(0);
        if (r6 == null) goto L19;
        Integer r7 = Integer.valueOf(r4.getChildAdapterPosition(r6));
        if (r7.intValue() == (-1)) goto L17;
        r5 = true;
    L17:
        if (r5 == false) goto L19;
    L20:
        if (r6 == null) goto L22;
        Integer r8 = Integer.valueOf(r6.getTop());
    L23:
        com.bytedance.android.shopping.store.restore.f r9 = new com.bytedance.android.shopping.store.restore.f(r7, r8);
        if (r2 != null) goto L28;
        return new com.bytedance.android.shopping.store.restore.j(null, r9);
    L28:
        return new com.bytedance.android.shopping.store.restore.j(r2, r9);
    L22:
        r8 = null;
    L19:
        r7 = null;
    L29:
        return null;
    L6:
        r2 = r0.m0().getHybridListVO();
        goto L7
    }

    @Override // com.bytedance.android.shopping.store.restore.k
    public final int getTabType() {
        return this.a;
    }

    public final void b(com.bytedance.android.shopping.store.restore.j r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        com.bytedance.android.ec.hybrid.list.entity.k r0 = r4.a;
        com.bytedance.android.shopping.store.restore.f r5 = r4.b;
        if (r0 == null) goto L19;
        ECShopHybridProductListPresenter r1 = this.b;
        r1.D = r0;
        r1.m0().setHybridListVO(r0);
        this.b.m0().setRestoredData(true);
        ECShopHybridProductListPresenter r2 = this.b;
        r2.E = r5;
        ECHybridListEngine r6 = r2.n;
        if (r6 == null) goto L10;
        ECHybridRecyclerView r7 = r6.b;
        if (r7 == null) goto L10;
        r7.post(new z(r2, r7, r0));
    L10:
        ECShopHybridProductListPresenter r8 = this.b;
        StringBuilder r3 = new StringBuilder("product_import_list tabId=");
        r3.append(this.c);
        r3.append(" sections=");
        ArrayList r9 = r0.c;
        Integer r10 = null;
        if (r9 == null) goto L13;
        Integer r11 = Integer.valueOf(r9.size());
    L14:
        r3.append(r11);
        r8.o0(r3.toString());
        ECShopHybridProductListPresenter r12 = this.b;
        StringBuilder r13 = new StringBuilder("product_import_scroll tabId=");
        r13.append(this.c);
        r13.append(" pos=");
        com.bytedance.android.shopping.store.restore.f r14 = this.b.E;
        if (r14 == null) goto L17;
        r10 = r14.a;
    L17:
        r13.append(r10);
        r12.o0(r13.toString());
        return;
    L13:
        r11 = null;
        goto L14
    }

    public t(ECShopHybridProductListPresenter r1, int r2) {
        this.b = r1;
        this.c = r2;
        this.a = r2;
    }
}
