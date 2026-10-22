package com.bytedance.android.shopping.mall.homepage.component;

import android.view.View;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ECMBackTopComponent a;

    public a(ECMBackTopComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ECMallFragment.wa0(this.a.p().z);
        this.a.p().z.Ka0(MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "click_ecom_button"), TuplesKt.to("params", MapsKt.mapOf(TuplesKt.to("module_name", "回到顶部"))), TuplesKt.to("btm", "c29603.d83433")}));
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.g.b, "scroll to top");
    }
}
