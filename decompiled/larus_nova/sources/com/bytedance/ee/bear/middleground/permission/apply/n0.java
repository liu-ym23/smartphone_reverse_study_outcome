package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f233046a;

    public n0(g r100) {
        this.f233046a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        n r101 = this.f233046a;
        Intrinsics.checkNotNull(r100);
        r101.c(r100);
    }
}
