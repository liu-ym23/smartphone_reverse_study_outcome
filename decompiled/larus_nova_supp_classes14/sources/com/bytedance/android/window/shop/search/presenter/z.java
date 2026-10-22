package com.bytedance.android.window.shop.search.presenter;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements TextView.OnEditorActionListener {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    public z(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L6;
        WindowSearchTitlePresenter.F(this.a, WindowSearchBasePresenter.SearchMode.KEYBOARD);
        return true;
    L6:
        return false;
    }
}
