package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSubFilterFragment f237834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f237835b;

    public a(BaseSubFilterFragment r100, int r101) {
        this.f237834a = r100;
        this.f237835b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f237834a.aa0(this.f237835b - 1);
    }
}
