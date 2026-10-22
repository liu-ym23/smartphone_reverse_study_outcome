package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> f213968a;

    public c(Ref.ObjectRef<com.larksuite.component.universe_design.menu.c> r100) {
        this.f213968a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.larksuite.component.universe_design.menu.c r101 = this.f213968a.element;
        Intrinsics.checkNotNull(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        r101.c(r100);
    }
}
