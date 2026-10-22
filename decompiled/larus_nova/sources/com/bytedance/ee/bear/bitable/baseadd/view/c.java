package com.bytedance.ee.bear.bitable.baseadd.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFastAddTipsFragment f207038c;

    public c(BitableFastAddTipsFragment r100) {
        this.f207038c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BitableFastAddTipsFragment.b r101 = this.f207038c.f207035r;
        if (r101 == null) goto L5;
        r101.N0();
    L5:
        BitableFastAddTipsFragment.b r102 = this.f207038c.f207035r;
        if (r102 == null) goto L11;
        BitableAnalytic r103 = r102.q0();
        if (r103 == null) goto L12;
        r103.h("add_another");
        return;
    L12:
        return;
    }
}
