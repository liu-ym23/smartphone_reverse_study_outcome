package com.bytedance.android.shopping.store.shopfeed;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g extends com.bytedance.android.shopping.store.slicecard.d {
    public final ECShopFeedViewModel c;
    public final r d;

    public void e(IAction r1, View r2) {
        throw null;
    }

    public g(ECShopFeedViewModel r2, r r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        super(r2);
        this.c = r2;
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.d
    public final void c(IAction r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "targetView");
        String r0 = r4.getType();
        SliceActionType r1 = SliceActionType.UPDATE_ITEM_STATES;
        if (Intrinsics.areEqual(r0, r1.getType()) == true) goto L5;
        SliceActionType r2 = SliceActionType.SHARE;
        if (Intrinsics.areEqual(r0, r2.getType()) == true) goto L11;
        e(r4, r5);
        return;
    L11:
        if ((!Intrinsics.areEqual(r4.getType(), r2.getType())) == true) goto L28;
        ECShopInnerFlowShareHelper r6 = this.c.getShareHelper();
        if (r6 == null) goto L25;
        Map r7 = r4.getParams();
        if (r7 == null) goto L20;
        Object r8 = r7.get("sec_shop_id");
        if (r8 == null) goto L20;
        String r9 = r8.toString();
    L21:
        r6.f(r9);
        return;
    L20:
        r9 = null;
        goto L21
    L25:
        return;
    L28:
        return;
    L5:
        if ((!Intrinsics.areEqual(r4.getType(), r1.getType())) == true) goto L27;
        int r3 = h.a;
        this.c.getSliceService().c(h.a(r4, r5, this.d));
        return;
    }
}
