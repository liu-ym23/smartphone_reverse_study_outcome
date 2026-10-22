package com.bytedance.ee.bear.bitable.homepage.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageFragment f212313a;

    public f(BitableMessageFragment r100) {
        this.f212313a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableMessageViewModel r101 = this.f212313a.f212281n;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.fetchHomePageData();
    }
}
