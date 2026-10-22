package com.ss.android.lark.qrcode.ui;

import android.content.Intent;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2c.a f439073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BarcodeFormat[] f439074b;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.ss.android.lark.qrcode.ui.b
    public final BarcodeFormat[] getFormats() {
        return this.f439074b;
    }

    public j(Intent r100) {
        a2c.a r101 = z1c.a.f569729a;
        this.f439073a = r101;
        r101.otherOpenCamera();
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L17;
        int[] r103 = r100.getIntArrayExtra("key_code_format");
        if (r103 != null) goto L7;
        r102.add(BarcodeFormat.QR_CODE);
        goto L17
    L7:
        int r104 = 0;
    L9:
        if (r104 >= r103.length) goto L17;
        int r105 = r103[r104];
        if (r105 != 0) goto L14;
        r102.add(BarcodeFormat.QR_CODE);
    L16:
        r104 = r104 + 1;
        goto L9
    L14:
        if (r105 != 1) goto L16;
        r102.add(BarcodeFormat.EAN_8);
        r102.add(BarcodeFormat.EAN_13);
        r102.add(BarcodeFormat.UPC_EAN_EXTENSION);
        r102.add(BarcodeFormat.CODE_39);
        r102.add(BarcodeFormat.CODE_93);
        r102.add(BarcodeFormat.CODE_128);
        r102.add(BarcodeFormat.CODABAR);
    L17:
        this.f439074b = (BarcodeFormat[]) r102.toArray(new BarcodeFormat[0]);
    }
}
