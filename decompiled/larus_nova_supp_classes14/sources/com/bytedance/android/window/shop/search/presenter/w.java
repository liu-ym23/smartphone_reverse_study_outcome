package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    public w(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = this.a.g;
        if (r3 == null) goto L6;
        r3.setText("");
        return;
    }
}
