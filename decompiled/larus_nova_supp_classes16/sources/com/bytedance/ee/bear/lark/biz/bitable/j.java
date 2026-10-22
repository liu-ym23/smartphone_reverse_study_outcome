package com.bytedance.ee.bear.lark.biz.bitable;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ BitableTabFragmentV2 b;

    public j(d r1, BitableTabFragmentV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        this.a.onClick(r11);
        lc5.f.a r12 = lc5.f.a;
        BitableTabFragmentV2 r0 = this.b;
        int r1 = BitableTabFragmentV2.t;
        r0.getClass();
        String r2 = this.b.m6();
        String r5 = this.b.m6();
        this.b.getClass();
        this.b.getClass();
        this.b.getClass();
        p r9 = new p("lark_workspace_bitable_landing", r2, "search", "search_main_view", r5, "ccm_base_homepage_landing_click", "larktab_bitable", "lark_tab");
        Intrinsics.checkNotNullParameter(r9, "param");
        r12.I(r9);
    }
}
