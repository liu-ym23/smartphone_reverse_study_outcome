package com.bytedance.android.window.shop.secondary.presenter;

import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ECWindowSecondaryHeadPresenter a;

    public b(ECWindowSecondaryHeadPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ECWindowSecondaryHeadPresenter.D(this.a).doEventAction("window_secondary_page_click", new Pair[]{TuplesKt.to("click_area", "103")});
        this.a.u().a().finish();
    }
}
