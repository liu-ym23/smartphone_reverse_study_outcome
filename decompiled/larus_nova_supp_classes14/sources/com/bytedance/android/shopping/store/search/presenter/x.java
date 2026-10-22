package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ z a;

    public x(z r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ShopSearchFragmentProductViewModel r3 = this.a.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r3.refresh();
    }
}
