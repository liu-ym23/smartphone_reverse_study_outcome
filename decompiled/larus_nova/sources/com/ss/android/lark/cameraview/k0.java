package com.ss.android.lark.cameraview;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410996a;

    public k0(CaptureLayout r100) {
        this.f410996a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d0b.b r101 = this.f410996a.f410810d;
        if (r101 == null) goto L6;
        r101.onClick();
        return;
    }
}
