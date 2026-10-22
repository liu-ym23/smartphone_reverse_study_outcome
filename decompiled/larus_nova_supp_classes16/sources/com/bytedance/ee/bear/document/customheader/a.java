package com.bytedance.ee.bear.document.customheader;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CustomHeaderFragment a;
    public final /* synthetic */ String b;

    public a(CustomHeaderFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CustomHeaderViewModel r4 = this.a.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r4 = null;
    L5:
        CustomHeaderViewModel.a r5 = r4.getDelegate();
        if (r5 == null) goto L9;
        r5.a(this.b, "");
        return;
    }
}
