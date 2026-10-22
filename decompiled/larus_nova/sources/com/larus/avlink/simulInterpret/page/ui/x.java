package com.larus.avlink.simulInterpret.page.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleView f294594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f294595b;

    public x(TitleView r100, boolean r101) {
        this.f294594a = r100;
        this.f294595b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        ViewGroup.LayoutParams r109 = this.f294594a.f294543a.f293352e.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r109;
        if (this.f294595b == false) goto L5;
        r110.setMarginStart(this.f294594a.f294543a.f293351d.getLeft());
        ((ViewGroup.MarginLayoutParams) r110).width = this.f294594a.f294543a.f293351d.getWidth();
    L6:
        this.f294594a.f294543a.f293352e.setLayoutParams(r110);
        return;
    L5:
        r110.setMarginStart(this.f294594a.f294543a.f293350c.getLeft());
        ((ViewGroup.MarginLayoutParams) r110).width = this.f294594a.f294543a.f293350c.getWidth();
        goto L6
    }
}
