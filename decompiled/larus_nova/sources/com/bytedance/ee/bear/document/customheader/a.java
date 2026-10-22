package com.bytedance.ee.bear.document.customheader;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomHeaderFragment f219482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219483b;

    public a(CustomHeaderFragment r100, String r101) {
        this.f219482a = r100;
        this.f219483b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomHeaderViewModel r101 = this.f219482a.f219407e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customHeaderViewModel");
        r101 = null;
    L5:
        CustomHeaderViewModel.a r102 = r101.getDelegate();
        if (r102 == null) goto L9;
        r102.a(this.f219483b, "");
        return;
    }
}
