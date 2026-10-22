package com.ss.android.lark.floating.widget.appfloat;

import android.view.WindowManager;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowManagerLayoutParamsInternal f421955a;

    public final int getType() {
        return ((WindowManager.LayoutParams) this.f421955a).type;
    }

    public h() {
        this.f421955a = new WindowManagerLayoutParamsInternal();
    }
}
