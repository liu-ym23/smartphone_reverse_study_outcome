package com.bytedance.ee.bear.document.customheader;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ OfficeCustomHeaderFragment a;
    public final /* synthetic */ String b;

    public c(OfficeCustomHeaderFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        OfficeCustomHeaderViewModel r4 = this.a.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r4 = null;
    L5:
        OfficeCustomHeaderViewModel.a r5 = r4.getDelegate();
        if (r5 == null) goto L9;
        r5.a(this.b, "");
        return;
    }
}
