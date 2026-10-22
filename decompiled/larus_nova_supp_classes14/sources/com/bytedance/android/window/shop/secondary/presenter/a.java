package com.bytedance.android.window.shop.secondary.presenter;

import android.view.View;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ECWindowCategoryPageHeadPresenter a;

    public a(ECWindowCategoryPageHeadPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ECWindowViewModel r5 = this.a.g;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r5.doEventAction("window_secondary_page_click", new Pair[]{TuplesKt.to("click_area", "103")});
        this.a.u().a().finish();
    }
}
