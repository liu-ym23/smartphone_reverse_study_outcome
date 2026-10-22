package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Promotion b;
    public final /* synthetic */ WindowNodeView c;

    public s(int r1, Promotion r2, WindowNodeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        WindowNodeView r6 = this.c;
        rd3.a r0 = r6.c;
        if (r0 == null) goto L6;
        r6.a(r0, "pic", String.valueOf(this.a), this.b);
        return;
    }
}
