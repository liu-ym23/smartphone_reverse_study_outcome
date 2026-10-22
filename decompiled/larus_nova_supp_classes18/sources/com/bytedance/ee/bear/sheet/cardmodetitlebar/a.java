package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseTitleBar.c {
    public final /* synthetic */ SheetCardTitleBarFragment k;
    public final /* synthetic */ NavBarItem l;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        SheetCardTitleBarViewModel r3 = this.k.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        SheetCardTitleBarViewModel.a r4 = r3.getDelegate();
        if (r4 == null) goto L12;
        String r0 = this.l.getId();
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        r4.a(r0);
        return;
    }

    public a(int r1, SheetCardTitleBarFragment r2, NavBarItem r3) {
        this.k = r2;
        this.l = r3;
        super(r1);
    }
}
