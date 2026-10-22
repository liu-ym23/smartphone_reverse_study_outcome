package com.ss.android.lark.qrcode.ui;

import android.view.View;
import com.ss.android.lark.camera_export.CameraParam;

/* JADX INFO: loaded from: classes37.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QRCodeScanView f439095a;

    public w(QRCodeScanView r100) {
        this.f439095a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f439095a.f439013a.b();
        c2c.a r101 = this.f439095a.f439023k;
        h.c.f439070a.getClass();
        if (h.m() == false) goto L5;
        String r102 = CameraParam.TYPE_VE_CAMERA;
    L6:
        boolean r103 = h.l();
        long r104 = System.currentTimeMillis() - this.f439095a.f439024l.longValue();
        r101.getClass();
        c2c.a.a(r102, r103, "myqrcode", r104);
        return;
    L5:
        r102 = "others";
        goto L6
    }
}
