package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements HorizontalWeightedGroupView.d {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    public d(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView.d
    public final void a(WindowChildCategoryVO.ChildCategoryVO r9) {
        com.bytedance.android.ec.hybrid.list.entity.k r0 = this.a.e0().c.g;
        if (r0 != null) goto L5;
        return;
    L5:
        this.a.k0().b(com.bytedance.android.ec.window.base.status.c.d.a);
        com.bytedance.android.window.shop.holder.footer.a r1 = this.a.h;
        if (r1 == null) goto L8;
        r1.J1(FooterStatus.LOADING);
    L8:
        ECHybridListEngine r2 = this.a.e0();
        com.bytedance.android.ec.hybrid.list.entity.k r3 = this.a.e0().c.g;
        String r4 = null;
        if (r3 == null) goto L18;
        ArrayList r5 = r3.c;
        if (r5 == null) goto L18;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r8).a, "tool_bar") == false) goto L14;
        r6.add(r8);
    L19:
        ECHybridListEngine.p(r2, c0.g(r0, r6), 4);
        this.a.l0().refreshAndLoadData(r9, this.a.h0());
        ECWindowHybridTabPresenter r10 = this.a;
        if (r9 != null) goto L22;
        r10.getClass();
    L23:
        WindowHybridTabViewModel r11 = this.a.l0();
        if (r9 == null) goto L26;
        r4 = r9.getId();
    L26:
        r11.setLastChildCategory(r4);
        this.a.l0().doAnyEventActionWithBtm("c68164.d520689", PageFinder.via(((QFragmentPresenter) this.a).e), "moments_card_click", null, new Pair[0]);
        return;
    L22:
        r10.l0().appendEventParams(new Pair[]{TuplesKt.to("tab_name_second", r9.getId())});
    L18:
        r6 = null;
        goto L19
    }
}
