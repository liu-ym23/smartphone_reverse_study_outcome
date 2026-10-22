package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements ECTabLayout.OnTabSelectedListener {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r1) {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r1, boolean r2) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r1, r2);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r1) {
    }

    public f(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r12) {
        String r0 = null;
        if (r12 == null) goto L7;
        Object r1 = r12.getTag();
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        ECWindowHybridTabPresenter r3 = this.a;
        r3.i0().scrollToPosition(0);
        if (r2 == null) goto L26;
        com.bytedance.android.ec.hybrid.list.entity.k r4 = r3.e0().c.g;
        if (r4 == null) goto L26;
        r3.q0(FooterStatus.NOTHING);
        WindowLayoutType r5 = r3.h0();
        r3.k0().b(com.bytedance.android.ec.window.base.status.c.d.a);
        ECHybridListEngine r6 = r3.e0();
        com.bytedance.android.ec.hybrid.list.entity.k r7 = r3.e0().c.g;
        if (r7 == null) goto L24;
        ArrayList r8 = r7.c;
        if (r8 == null) goto L24;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L20:
        if (r10.hasNext() == false) goto L25;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r11).a, "tool_bar") == false) goto L20;
        r9.add(r11);
    L25:
        ECHybridListEngine.p(r6, c0.g(r4, r9), 4);
        r3.l0().refreshAndLoadData(r2, r5);
    L24:
        r9 = null;
    L26:
        w1 r13 = this.a.l0().getTabPerformanceWatcher();
        if (r12 == null) goto L31;
        CharSequence r14 = r12.getText();
        if (r14 == null) goto L31;
        r0 = r14.toString();
    L31:
        r13.c(new v1.h.b(r2, r0));
        return;
    L7:
        r2 = null;
        goto L8
    }
}
