package com.bytedance.ies.xelement.viewpager;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends AppBarLayout.BaseBehavior.BaseDragCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomAppBarLayout.Behavior f250500a;

    public a(CustomAppBarLayout.Behavior r100) {
        this.f250500a = r100;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
    public final boolean canDrag(AppBarLayout r100) {
        if ((r100 instanceof BaseCustomAppBarLayout) == true) goto L5;
        return true;
    L5:
        if (((BaseCustomAppBarLayout) r100).f250428a == false) goto L7;
        return true;
    L7:
        if ((this.f250500a.getTopAndBottomOffset() / r100.getTotalScrollRange()) > (-1)) goto L13;
        return false;
    L13:
        return true;
    }
}
