package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseSubFilterFragment f237873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f237874b;

    public t(OfficeBaseSubFilterFragment r100, int r101) {
        this.f237873a = r100;
        this.f237874b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f237873a.aa0(this.f237874b + 1);
    }
}
