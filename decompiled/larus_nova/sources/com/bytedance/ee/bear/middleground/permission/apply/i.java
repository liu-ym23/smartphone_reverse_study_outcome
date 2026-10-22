package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ApplyPermissionController f233027a;

    public i(ApplyPermissionController r100) {
        this.f233027a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ApplyPermissionController r101 = this.f233027a;
        PermApplyViewModel.PermType r102 = PermApplyViewModel.PermType.READ;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "permType");
        PermApplyViewModel r103 = r101.c();
        if (r103 == null) goto L6;
        r103.setPermType(r102);
        return;
    }
}
