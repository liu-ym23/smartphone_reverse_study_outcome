package com.bytedance.android.shopping.store.search.presenter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 implements TextView.OnEditorActionListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public i0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L6;
        ShopSearchTitlePresenter.G(this.a, ShopSearchBasePresenter.SearchMode.KEYBOARD);
        return true;
    L6:
        return false;
    }
}
