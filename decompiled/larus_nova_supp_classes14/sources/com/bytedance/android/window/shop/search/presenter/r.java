package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ t a;

    public r(t r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WindowSearchFragmentProductViewModel r3 = this.a.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r3.refresh();
    }
}
