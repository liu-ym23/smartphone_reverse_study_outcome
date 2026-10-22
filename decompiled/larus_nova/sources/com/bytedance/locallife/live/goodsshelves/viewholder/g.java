package com.bytedance.locallife.live.goodsshelves.viewholder;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeGoodsShelvesViewHolder f260401a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int r100 = this.f260401a.f260339l.getLineCount();
        if (this.f260401a.f260346s.getVisibility() != 0) goto L5;
        int r101 = 1;
    L6:
        int r102 = r100 + r101;
        this.f260401a.getClass();
        int r103 = r102 + 0;
        if (this.f260401a.f260351x.getVisibility() != 0) goto L9;
        int r104 = 1;
    L10:
        int r105 = r103 + r104;
        if (this.f260401a.I.getVisibility() != 0) goto L13;
        int r106 = 1;
    L15:
        if ((r105 + r106) <= 4) goto L19;
        this.f260401a.f260351x.setVisibility(8);
        if (this.f260401a.I.getVisibility() != 0) goto L19;
        this.f260401a.f260327J.setVisibility(0);
    L19:
        this.f260401a.f260339l.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L13:
        r106 = 0;
        goto L15
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public g(LiveLocalLifeGoodsShelvesViewHolder r100) {
        this.f260401a = r100;
    }
}
