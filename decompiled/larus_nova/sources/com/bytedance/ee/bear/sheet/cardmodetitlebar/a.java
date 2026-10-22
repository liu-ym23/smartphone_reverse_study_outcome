package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SheetCardTitleBarFragment f237410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ NavBarItem f237411l;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        SheetCardTitleBarViewModel r101 = this.f237410k.f237402f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        SheetCardTitleBarViewModel.a r102 = r101.getDelegate();
        if (r102 == null) goto L12;
        String r103 = this.f237411l.getId();
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r102.a(r103);
        return;
    }

    public a(int r100, SheetCardTitleBarFragment r101, NavBarItem r102) {
        this.f237410k = r101;
        this.f237411l = r102;
        super(r100);
    }
}
