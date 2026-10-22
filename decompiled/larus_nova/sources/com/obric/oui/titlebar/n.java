package com.obric.oui.titlebar;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements OUnitedTitleBar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f403670a;

    public n(OUnitedTitleBar r100) {
        this.f403670a = r100;
    }

    @Override // com.obric.oui.titlebar.OUnitedTitleBar.c
    public final void a(int r110) {
        ViewGroup r100 = this.f403670a.getLeftAction();
        ViewGroup.MarginLayoutParams r101 = null;
        if (r100 != null) goto L5;
        ViewGroup.LayoutParams r102 = null;
    L7:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L10:
        ViewGroup r104 = this.f403670a.getRightAction();
        if (r104 != null) goto L13;
        ViewGroup.LayoutParams r105 = null;
    L15:
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L18:
        TextView r107 = this.f403670a.getMTvTitle();
        if (r107 != null) goto L21;
        ViewGroup.LayoutParams r108 = null;
    L23:
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r101 = (ViewGroup.MarginLayoutParams) r108;
    L25:
        OUnitedTitleBar r109 = this.f403670a;
        int r111 = OUnitedTitleBar.f403463q;
        int r112 = pla.d.n(r109, 12);
        int r113 = pla.d.n(this.f403670a, 92);
        int r114 = pla.d.n(this.f403670a, 17);
        float r115 = (-r110) / this.f403670a.getTotalScrollRange();
        boolean r116 = true;
        if (this.f403670a.getMCollapsePosition() != 1) goto L38;
        r114 = pla.d.n(this.f403670a, 14);
        int[] r117 = new int[2];
        TextView r118 = this.f403670a.getMTvTitle();
        if (r118 == null) goto L31;
        r118.getLocationOnScreen(r117);
    L31:
        if (r110 != 0) goto L33;
        this.f403670a.setTextInitPos(r117[0]);
    L33:
        float r119 = (this.f403670a.getTextInitPos() + pla.d.n(this.f403670a, 18)) * r115;
        if (r101 == null) goto L37;
        r101.leftMargin = -((int) r119);
    L37:
        float r120 = 20.0f;
    L40:
        if (r115 == 1.0f) goto L43;
        r116 = false;
    L43:
        if (r116 == false) goto L48;
        View r121 = this.f403670a.getDivider();
        if (r121 == null) goto L52;
        pla.j.f(r121);
    L52:
        if (r103 == null) goto L55;
        r103.topMargin = (-r110) + r112;
    L55:
        if (r106 == null) goto L58;
        r106.topMargin = (-r110) + r112;
    L58:
        int r122 = (int) (r113 - ((r113 - r114) * r115));
        float r123 = ((r120 - 40.0f) * new AccelerateDecelerateInterpolator().getInterpolation(r115)) + 40.0f;
        TextView r124 = this.f403670a.getMTvTitle();
        if (r124 == null) goto L62;
        r124.setTextSize(2, r123);
    L62:
        if (r101 == null) goto L65;
        r101.bottomMargin = r122;
    L65:
        ViewGroup r125 = this.f403670a.getLeftAction();
        if (r125 == null) goto L69;
        r125.setLayoutParams(r103);
    L69:
        ViewGroup r126 = this.f403670a.getRightAction();
        if (r126 == null) goto L73;
        r126.setLayoutParams(r106);
    L73:
        TextView r127 = this.f403670a.getMTvTitle();
        if (r127 == null) goto L78;
        r127.setLayoutParams(r101);
        return;
    L78:
        return;
    L48:
        View r128 = this.f403670a.getDivider();
        if (r128 == null) goto L52;
        pla.j.e(r128);
        goto L52
    L38:
        r120 = 16.0f;
        goto L40
    L21:
        r108 = r107.getLayoutParams();
        goto L23
    L17:
        r106 = null;
        goto L18
    L13:
        r105 = r104.getLayoutParams();
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = r100.getLayoutParams();
        goto L7
    }
}
