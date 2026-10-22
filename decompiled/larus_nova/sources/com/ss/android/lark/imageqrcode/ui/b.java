package com.ss.android.lark.imageqrcode.ui;

import android.view.View;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageQRCodeSelectActivity f426657a;

    public b(ImageQRCodeSelectActivity r100) {
        this.f426657a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StringBuilder r101 = new StringBuilder("cancel scan,");
        QRCodeShowParam r102 = ImageQRCodeSelectActivity.f426641d;
        QRCodeShowParam r103 = ImageQRCodeSelectActivity.f426641d;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getFrom();
    L6:
        r101.append(r105);
        r101.append(',');
        QRCodeShowParam r106 = ImageQRCodeSelectActivity.f426641d;
        if (r106 == null) goto L9;
        String r107 = r106.getScanType();
    L10:
        r101.append(r107);
        Log.i("ImageQRCodeSelectActivity", r101.toString());
        JSONObject r108 = new JSONObject();
        QRCodeShowParam r109 = ImageQRCodeSelectActivity.f426641d;
        if (r109 == null) goto L13;
        String r110 = r109.getFrom();
    L14:
        JSONObject r111 = r108.put("from", r110);
        QRCodeShowParam r112 = ImageQRCodeSelectActivity.f426641d;
        if (r112 == null) goto L17;
        r104 = r112.getScanType();
    L17:
        Statistics.sendEvent("scan_qrcode_multicode_select_cancel", r111.put("ve_scan_type", r104));
        this.f426657a.finish();
        return;
    L13:
        r110 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
