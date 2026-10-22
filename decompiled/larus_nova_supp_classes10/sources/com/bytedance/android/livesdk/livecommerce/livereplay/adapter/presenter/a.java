package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QPresenter {
    public a() {
    }

    public final void A(QModel r2) {
        if ((r2 instanceof ni2.a) == true) goto L5;
        r2 = null;
    L5:
        ni2.a r3 = (ni2.a) r2;
        if (r3 != null) goto L8;
    L12:
        ViewGroup.LayoutParams r4 = w().f().getLayoutParams();
        if (r4 == null) goto L18;
        r4.width = -2;
        return;
    L18:
        return;
    L8:
        if (r3.m != true) goto L12;
        ViewGroup.LayoutParams r5 = w().f().getLayoutParams();
        if (r5 == null) goto L16;
        r5.width = 0;
        return;
    }
}
