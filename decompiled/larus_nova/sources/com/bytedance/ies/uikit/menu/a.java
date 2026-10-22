package com.bytedance.ies.uikit.menu;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends CustomViewAbove.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomViewAbove f249075a;

    public a(CustomViewAbove r100) {
        this.f249075a = r100;
    }

    @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.b
    public final void onPageSelected(int r100) {
        CustomViewBehind r101 = this.f249075a.f249031f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == 0) goto L11;
        if (r100 != 1) goto L8;
        r101.setChildrenEnabled(false);
        return;
    L8:
        if (r100 == 2) goto L11;
        return;
    L11:
        r101.setChildrenEnabled(true);
    }
}
