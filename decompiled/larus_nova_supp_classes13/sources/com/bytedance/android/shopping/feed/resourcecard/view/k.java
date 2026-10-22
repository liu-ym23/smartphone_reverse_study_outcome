package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.bytedance.android.shopping.feed.resourcecard.frequency.ResourceCardFreqController;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ yd3.p a;

    public k(yd3.p r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.getType() == 7) goto L10;
        Lazy r3 = ResourceCardFreqController.a;
        yd3.d r4 = this.a.c();
        if (r4 == null) goto L7;
        Integer r5 = r4.b();
    L8:
        ResourceCardFreqController.d(r5);
        return;
    L7:
        r5 = null;
        goto L8
    }
}
