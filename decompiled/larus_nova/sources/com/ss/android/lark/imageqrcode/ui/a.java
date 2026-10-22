package com.ss.android.lark.imageqrcode.ui;

import android.view.View;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageQRCodeSelectActivity f426655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QRCodeContentInfo f426656b;

    public a(ImageQRCodeSelectActivity r100, QRCodeContentInfo r101) {
        this.f426655a = r100;
        this.f426656b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ImageQRCodeSelectActivity r101 = this.f426655a;
        QRCodeContentInfo r102 = this.f426656b;
        QRCodeShowParam r103 = ImageQRCodeSelectActivity.f426641d;
        r101.z1(r102, "click");
    }
}
