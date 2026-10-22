package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f2 implements View.OnClickListener {
    public final /* synthetic */ ECWindowTopInfoBarPresenter.b a;

    public f2(ECWindowTopInfoBarPresenter.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Function3<String, Boolean, String, Unit> r5 = this.a.a.O().getJump2Live();
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke("live_cell_head", Boolean.FALSE, "a1.b7635.c4706.d3124");
        return;
    }
}
