package com.bytedance.ee.bear.bitable.baseadd.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class k extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFastAddTipsFragment f207046c;

    public k(BitableFastAddTipsFragment r100) {
        this.f207046c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BitableFastAddTipsFragment.U90(this.f207046c, null);
        BitableFastAddTipsFragment.b r101 = this.f207046c.f207035r;
        if (r101 == null) goto L8;
        BitableAnalytic r102 = r101.q0();
        if (r102 == null) goto L9;
        r102.h("open_table");
        return;
    L9:
        return;
    }
}
