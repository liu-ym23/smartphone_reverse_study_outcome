package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements hi5.y.a {
    public final /* synthetic */ ApplyPermissionPanel a;

    public q(ApplyPermissionPanel r1) {
        this.a = r1;
    }

    @Override // hi5.y.a
    public final /* synthetic */ void QF() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        String r0 = null;
        com.bytedance.ee.bear.docshost.k r4 = (com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6);
        String r1 = this.a.l;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ownerId");
    L6:
        r4.e(r0, "");
        return;
    L5:
        r0 = r1;
        goto L6
    }
}
