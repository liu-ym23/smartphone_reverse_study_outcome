package com.ss.android.lark.cameraview;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class g0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410981a;

    public g0(CaptureLayout r100) {
        this.f410981a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d0b.f r101 = this.f410981a.f410808b;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f410981a.b();
    }
}
