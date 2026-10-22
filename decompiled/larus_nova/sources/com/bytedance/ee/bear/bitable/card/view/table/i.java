package com.bytedance.ee.bear.bitable.card.view.table;

import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements hq4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCardViewPager f208868a;

    public i(BitableCardViewPager r100) {
        this.f208868a = r100;
    }

    @Override // hq4.a
    public final void onRetry(int r110) {
        tt5.a.h("BitableCardViewPager_async", "retry: direct " + r110);
        cp4.b r100 = this.f208868a.getMCurrentTable();
        if (r100 == null) goto L22;
        BitableCardViewPager r101 = this.f208868a;
        List<cp4.a> r102 = r100.f464668l;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L18;
        ETableType.a r111 = ETableType.Companion;
        ETableType r104 = r100.f464675s;
        r111.getClass();
        if (ETableType.a.b(r104) == false) goto L17;
        BitableCardViewModel.h r105 = new BitableCardViewModel.h(BitableCardViewModel.e.a(r100.f464658b, r100.f464660d, r100.f464664h.f464684b, null, r100.f464669m, r100.f464670n, r100.f464675s), r100.f464667k, r100.f464671o, !r100.f464677u);
        String r112 = r101.getMBitableCardViewModel().getOpenRecordTraceId();
        if (r112 == null) goto L16;
        long r106 = System.currentTimeMillis();
        Lazy r107 = uu4.b.f551743a;
        Intrinsics.checkNotNullParameter(r112, "traceId");
        uu4.b.a().addNormalPoint(r112, BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_RECORD_RETRY", r106, false, 12));
    L16:
        r101.getMBitableCardViewModel().notifyBaseTableShowing(r105);
        return;
    L17:
        r101.getMBitableCardViewModel().notifyLinkTableShowing(r100.f464658b, r100.f464660d);
        return;
    L18:
        if (r110 != 0) goto L20;
        BitableCardViewPager.a(r101);
        return;
    L20:
        BitableCardViewPager.c(r101);
        return;
    L7:
        if (r102.isEmpty() == true) goto L9;
        r103 = true;
        goto L10
    }
}
