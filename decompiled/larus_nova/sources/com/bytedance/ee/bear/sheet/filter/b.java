package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSubFilterFragment f237837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f237838b;

    public b(BaseSubFilterFragment r100, int r101) {
        this.f237837a = r100;
        this.f237838b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f237837a.aa0(this.f237838b + 1);
    }
}
