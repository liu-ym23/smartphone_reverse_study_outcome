package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements hi5.y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApplyPermissionPanel f233066a;

    public q(ApplyPermissionPanel r100) {
        this.f233066a = r100;
    }

    @Override // hi5.y.a
    public final /* synthetic */ void QF() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = null;
        com.bytedance.ee.bear.docshost.k r102 = (com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6);
        String r103 = this.f233066a.f232889l;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ownerId");
    L6:
        r102.e(r101, "");
        return;
    L5:
        r101 = r103;
        goto L6
    }
}
