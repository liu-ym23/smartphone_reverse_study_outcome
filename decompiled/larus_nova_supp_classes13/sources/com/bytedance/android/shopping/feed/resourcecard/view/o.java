package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ WindowNodeView a;
    public final /* synthetic */ rd3.a b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        WindowNodeView r5 = this.a;
        rd3.a r0 = this.b;
        int r1 = WindowNodeView.l;
        r5.a(r0, "else", null, null);
    }

    public o(WindowNodeView r1, rd3.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
