package com.bytedance.ee.bear.bitable.baseadd.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.t;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFastAddTipsFragment f207037c;

    public b(BitableFastAddTipsFragment r100) {
        this.f207037c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BitableFastAddTipsFragment.U90(this.f207037c, MapsKt.mapOf(TuplesKt.to("ccm_open_type", "record_upgrade_warning")));
        BitableFastAddTipsFragment.b r101 = this.f207037c.f207035r;
        if (r101 == null) goto L8;
        BitableAnalytic r102 = r101.q0();
        if (r102 == null) goto L9;
        r102.x("open_table");
        return;
    L9:
        return;
    }
}
