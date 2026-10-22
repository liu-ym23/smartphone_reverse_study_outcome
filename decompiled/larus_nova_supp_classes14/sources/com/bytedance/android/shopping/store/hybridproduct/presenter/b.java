package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.widget.TextView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QPresenter {
    public final qj3.b e;

    public b(qj3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dividerView");
        this.e = r2;
    }

    public final void A(QModel r3) {
        String r1 = null;
        if ((r3 instanceof ej3.c) == true) goto L5;
        r3 = null;
    L5:
        ej3.c r4 = (ej3.c) r3;
        TextView r0 = this.e.getTextView();
        if (r4 == null) goto L8;
        r1 = r4.a;
    L8:
        r0.setText(r1);
    }
}
