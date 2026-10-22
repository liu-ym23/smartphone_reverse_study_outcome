package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> f208720b;

    public e(StageDataViewHolder r100, Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> r101) {
        this.f208719a = r100;
        this.f208720b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f208719a.f208670a.getView();
        if (r101 == null) goto L5;
        r101.GY(r100);
    L5:
        com.larksuite.component.universe_design.menu.c r102 = this.f208720b.element;
        Intrinsics.checkNotNull(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        r102.c(r100);
    }
}
