package com.bytedance.android.shopping.new_cart.widgets;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CardListCartLoadingView a;

    public a(CardListCartLoadingView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.getViewAction().b.invoke();
    }
}
