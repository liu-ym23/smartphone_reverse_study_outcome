package com.ss.android.lark.qrcode.ui;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f439084a;

    @Override // com.ss.android.lark.qrcode.ui.c.a
    public final BarcodeFormat[] getFormats() {
        return this.f439084a.getModel().getFormats();
    }

    public o(p r100) {
        this.f439084a = r100;
    }

    @Override // com.ss.android.lark.qrcode.ui.c.a
    public final void E4(String r100) {
        Log.i("QRCodeScanPresenter", "scan qr code success, result: *");
        this.f439084a.getClass();
        p.H8(this.f439084a, r100, 1);
    }
}
