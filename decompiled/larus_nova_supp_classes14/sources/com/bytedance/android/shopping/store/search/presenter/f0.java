package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public f0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = this.a.f;
        if (r3 == null) goto L6;
        r3.setText("");
        return;
    }
}
