package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f233045a;

    public m0(g r100) {
        this.f233045a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f233045a.onBackClick();
    }
}
