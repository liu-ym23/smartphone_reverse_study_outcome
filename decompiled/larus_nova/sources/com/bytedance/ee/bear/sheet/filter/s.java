package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseSubFilterFragment f237871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f237872b;

    public s(OfficeBaseSubFilterFragment r100, int r101) {
        this.f237871a = r100;
        this.f237872b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f237871a.aa0(this.f237872b - 1);
    }
}
