package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements com.bytedance.android.livesdk.livecommerce.eventcenter.ability.b {
    public final /* synthetic */ LivePromotionListListingPresenter a;

    public w(LivePromotionListListingPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.ability.b
    public final void a(sl.q r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        LivePromotionListListingPresenter r0 = this.a;
        if (r0.m == null) goto L32;
        PromotionLinearLayoutManager r1 = r0.l;
        if (r1 == null) goto L35;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L9:
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = LivePromotionListListingPresenter.i0(this.a).findLastVisibleItemPosition();
        List<ql.a> r4 = this.a.d0().getTotalPromotions();
        Iterator<ql.a> r5 = r4.iterator();
        boolean r6 = false;
        int r7 = 0;
    L11:
        if (r5.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r5.next().getPromotionId(), r9.c()) == true) goto L17;
        r7 = r7 + 1;
    L17:
        Integer r8 = Integer.valueOf(r7);
        if (r8.intValue() < 0) goto L20;
        r6 = true;
    L20:
        if (r6 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L33;
        int r10 = r8.intValue() + (LivePromotionListListingPresenter.h0(this.a).c ? 1 : 0);
        if (r2 > r10) goto L36;
        if (r3 <= r10) goto L34;
        ((ql.a) ListProtector.get(r4, r10)).getClientData().e = r9;
        LivePromotionListListingPresenter.l0(this.a, CollectionsKt.listOf(new cf.x(r10, UpdateLocalViewType.UPDATE_ALL)));
        return;
    L34:
        return;
    L36:
        return;
    L33:
        return;
    L16:
        r7 = -1;
        goto L17
    L35:
        return;
    }
}
