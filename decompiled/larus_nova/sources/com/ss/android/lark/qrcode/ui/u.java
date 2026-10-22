package com.ss.android.lark.qrcode.ui;

import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QRCodeScanView f439094a;

    public u(QRCodeScanView r100) {
        this.f439094a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        qqb.c.d("QRCodeScanView flashLight onClick", new t(this));
    }
}
