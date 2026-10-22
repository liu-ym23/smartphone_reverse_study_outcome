package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ BitableProFragment a;

    public i(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        BitableProViewModel r6 = this.a.D;
        com.bytedance.ee.bear.document.bitable.c r1 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L5:
        DefaultAccessConfig r7 = (DefaultAccessConfig) r6.getDefaultAccessConfig().getValue();
        boolean r2 = false;
        if (r7 != null) goto L8;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        BitableProViewModel r8 = this.a.D;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L15:
        Boolean r9 = (Boolean) r8.getIsPro().getValue();
        com.bytedance.ee.bear.document.bitable.c r0 = this.a.B;
        if (r0 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
    L20:
        if (r1.a == false) goto L23;
        BitableProFragment.Y90(this.a, 2131886146, 2131256189);
        return;
    L23:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L27;
        BitableProFragment.W90(this.a);
        return;
    L27:
        return;
    L18:
        r1 = r0;
        goto L20
    L8:
        if (r7.isSystemRole() != true) goto L10;
        r2 = true;
        goto L10
    }
}
