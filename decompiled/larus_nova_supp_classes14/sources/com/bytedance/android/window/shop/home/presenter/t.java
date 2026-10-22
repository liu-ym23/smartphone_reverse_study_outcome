package com.bytedance.android.window.shop.home.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

    public t(ECWindowCroppedStyleRootPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (r1.getVisibility() == 0) goto L6;
        this.a.D();
        return;
    }
}
