package com.ss.android.lark.cameraview;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class h0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410984a;

    public h0(CaptureLayout r100) {
        this.f410984a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d0b.f r101 = this.f410984a.f410808b;
        if (r101 == null) goto L5;
        r101.confirm();
    L5:
        this.f410984a.b();
    }
}
