package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import androidx.paging.PagedList;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ LivePromotionListListingPresenter a;

    public u(LivePromotionListListingPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r17) {
        PagedList<T> r1 = (PagedList) r17;
        if (r1.size() <= 0) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(this.a.d0(), com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.w.a);
    L5:
        final LivePromotionListListingPresenter r5 = this.a;
        final int r9 = r5.d0().getRequestParam().a;
        int r2 = xh2.c.a;
        if (r9 != 2) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L18;
        LivePromotionListPageAdapter r4 = r5.m;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L16:
        r4.C2();
    L18:
        if (r1.size() <= 0) goto L29;
        if (r9 != 1) goto L21;
    L26:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        boolean r7 = true;
    L30:
        ql.a r10 = null;
        if (r7 == false) goto L109;
        PromotionLinearLayoutManager r8 = r5.l;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L36:
        if (r8.getItemCount() > 0) goto L38;
    L48:
        int r11 = 0;
    L50:
        if (r5.d0().getRequestParam().d == false) goto L52;
        r5.d0().getRequestParam().d = false;
    L103:
        final int r12 = 0;
    L104:
        LivePromotionListPageAdapter r13 = r5.m;
        if (r13 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L107:
        final boolean r14 = r7;
        final int r15 = r11;
        r13.y2(r1, new LivePromotionListListingPresenter$updatePagedList$1(r5, r14, r12, r15, r9));
    L139:
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b r16 = this.a.j;
        if (r16 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("listingViewModel");
    L142:
        mj2.c r18 = (mj2.c) CollectionsKt.firstOrNull(r1);
        if (r18 == null) goto L145;
        r10 = r18.a;
    L145:
        BuyNowPrefetchType r19 = BuyNowPrefetchType.FIRST_SHOW;
        r16.getClass();
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b.k(r10, r19);
        return;
    L52:
        PromotionLinearLayoutManager r20 = r5.l;
        if (r20 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L55:
        int r21 = r20.findFirstVisibleItemPosition();
        LivePromotionListPageAdapter r22 = r5.m;
        if (r22 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L58:
        r12 = r21 - (r22.c ? 1 : 0);
        LivePromotionListPageAdapter r23 = r5.m;
        if (r23 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L61:
        PagedList r24 = r23.getCurrentList();
        if (r24 == null) goto L77;
        if (r12 >= 0) goto L65;
    L67:
        boolean r110 = false;
    L68:
        if (r110 == true) goto L71;
        r24 = null;
    L71:
        if (r24 == null) goto L77;
        mj2.c r25 = (mj2.c) r24.get(r12);
        if (r25 == null) goto L77;
        ql.a r26 = r25.a;
        if (r26 == null) goto L77;
        int r27 = r26.getRealIndex();
    L78:
        int r111 = r5.d0().getRequestParam().u;
        int r112 = RangesKt.coerceAtLeast((r27 / r111) * r111, 0);
        if (r112 == 0) goto L104;
        LivePromotionListPageAdapter r28 = r5.m;
        if (r28 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L84:
        PagedList r29 = r28.getCurrentList();
        if (r29 == null) goto L103;
        ArrayList r113 = new ArrayList();
        Iterator<T> r30 = r29.iterator();
    L88:
        if (r30.hasNext() == false) goto L102;
        T r114 = r30.next();
        mj2.c r115 = (mj2.c) r114;
        if (r115 != null) goto L92;
    L98:
        boolean r31 = false;
    L99:
        if (r31 == false) goto L88;
        r113.add(r114);
        goto L88
    L92:
        if (r115.a.isOnTopExplaining() == true) goto L98;
        int r32 = r115.a.getRealIndex();
        if (r112 > r32) goto L98;
        if (r27 <= r32) goto L98;
        r31 = true;
        goto L99
    L102:
        r12 = r113.size();
        goto L104
    L65:
        if (r12 >= r24.size()) goto L67;
        r110 = true;
    L77:
        r27 = 0;
        goto L78
    L38:
        if (r5.d0().getRequestParam().d == true) goto L48;
        PromotionLinearLayoutManager r33 = r5.l;
        if (r33 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L42:
        PromotionLinearLayoutManager r116 = r5.l;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L45:
        View r34 = r33.findViewByPosition(r116.findFirstVisibleItemPosition());
        if (r34 == null) goto L48;
        r11 = r34.getTop();
        goto L50
    L109:
        if (r9 != 9) goto L135;
        LivePromotionListPageAdapter r35 = r5.m;
        if (r35 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L113:
        r35.submitList(null);
        LivePromotionListPageAdapter r36 = r5.m;
        if (r36 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L117:
        if (r36.b == false) goto L119;
        r36.b = false;
        r36.H2(false);
    L119:
        LivePromotionListPageAdapter r37 = r5.m;
        if (r37 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L122:
        PromotionCategory.a r38 = PromotionCategory.Companion;
        PromotionCategory r39 = r5.d0().getCurrentCategory();
        if (r39 == null) goto L125;
        String r40 = r39.getUniqueIndex();
    L126:
        r38.getClass();
        if (r37.G2(PromotionCategory.a.b(r40)) == false) goto L132;
        if (true == r37.c) goto L134;
        r37.c = true;
        r37.I2(true);
    L134:
        r5.p0(0, 0);
        goto L135
    L132:
        if (r37.c == false) goto L134;
        r37.c = false;
        r37.I2(false);
        goto L134
    L125:
        r40 = null;
    L135:
        LivePromotionListPageAdapter r41 = r5.m;
        if (r41 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L138:
        r41.y2(r1, new LivePromotionListListingPresenter$updatePagedList$2(r5, r9));
        goto L139
    L21:
        if (r9 == 3) goto L26;
        if (r9 == 6) goto L26;
        r6 = false;
    L29:
        r7 = false;
        goto L30
    L8:
        if (r9 == 8) goto L10;
        r3 = true;
        goto L12
    }
}
