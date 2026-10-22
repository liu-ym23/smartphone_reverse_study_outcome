package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ ApplyPermissionController a;

    public i(ApplyPermissionController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ApplyPermissionController r4 = this.a;
        PermApplyViewModel.PermType r0 = PermApplyViewModel.PermType.READ;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "permType");
        PermApplyViewModel r5 = r4.c();
        if (r5 == null) goto L6;
        r5.setPermType(r0);
        return;
    }
}
