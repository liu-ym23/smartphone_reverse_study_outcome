package com.bytedance.ee.bear.document.customheader;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomHeaderFragment f219485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219486b;

    public c(OfficeCustomHeaderFragment r100, String r101) {
        this.f219485a = r100;
        this.f219486b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeCustomHeaderViewModel r101 = this.f219485a.f219448e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("officeCustomHeaderViewModel");
        r101 = null;
    L5:
        OfficeCustomHeaderViewModel.a r102 = r101.getDelegate();
        if (r102 == null) goto L9;
        r102.a(this.f219486b, "");
        return;
    }
}
