package com.ss.android.lark.qrcode.ui;

import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.qrcode.utils.QRScanUtils;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes37.dex */
public final class p extends BasePresenter<b, c, c.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QRCodeScanView f439085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f439086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f439087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f439088d;

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new o(this);
    }

    public final void J8(final QRScanUtils.ProcessSuffix r100) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new m(this, r100));
    }

    public static void I8(p r100, String r101) {
        r100.getView().showToast(y9c.d.i(r100.f439086b, R.string.Lark_Legacy_QrCodeNotFound));
        Log.i("QRCodeScanPresenter", "handle selected photo failed, path: " + r101);
    }

    public p(FragmentActivity r100, QRCodeScanFragment.b r101, Intent r102) {
        this.f439087c = new AtomicLong(0);
        QRCodeScanView r103 = new QRCodeScanView(r101, r100);
        this.f439085a = r103;
        r103.f439015c = new o(this);
        setView(r103);
        setModel(new j(r102));
        this.f439086b = r100;
        n r104 = new n(this);
        a0b.h r105 = a0b.h.f1349a;
        Log.i("MediaResourceController", "injectInterruptCallback");
        a0b.h.f1352d = r104;
    }

    public static void H8(final p r100, final String r101, final int r102) {
        r100.getClass();
        if (r101 != null) goto L5;
        Log.e("QRCodeScanPresenter", "preHandleParseResult input result is null");
        r100.getView().showToast(y9c.d.i(r100.f439086b, R.string.Lark_Legacy_QrCodeNotFound));
        r100.f439086b.finish();
        return;
    L5:
        a2c.a r103 = z1c.a.f569729a;
        if (r103 != null) goto L8;
    L22:
        new Handler().post(new k(r100, r101, r102));
        return;
    L8:
        if (r103.canOpenAppLink(r101, r100.f439086b, r102) == false) goto L13;
        int r104 = QRScanUtils.f439101a;
        QRScanUtils.ProcessSuffix r105 = QRScanUtils.ProcessSuffix.SUFFIX_P0;
        if (QRScanUtils.a(r105) == true) goto L22;
        r100.J8(r105);
        goto L22
    L13:
        if (r103.canOpenAppBrand(r101) == false) goto L18;
        int r106 = QRScanUtils.f439101a;
        QRScanUtils.ProcessSuffix r107 = QRScanUtils.ProcessSuffix.SUFFIX_MINI_APP;
        if (QRScanUtils.a(r107) == true) goto L22;
        r100.J8(r107);
        goto L22
    L18:
        if (r103.isMatchUrl(r101) == false) goto L22;
        int r108 = QRScanUtils.f439101a;
        QRScanUtils.ProcessSuffix r109 = QRScanUtils.ProcessSuffix.SUFFIX_P0;
        if (QRScanUtils.a(r109) == true) goto L22;
        r100.J8(r109);
        goto L22
    }

    public p(FragmentActivity r100, QRCodeScanFragment.b r101, Intent r102, int[] r103) {
        this.f439087c = new AtomicLong(0);
        QRCodeScanView r104 = new QRCodeScanView(r101, r100, r103);
        this.f439085a = r104;
        r104.f439015c = new o(this);
        setView(r104);
        setModel(new j(r102));
        this.f439086b = r100;
        n r105 = new n(this);
        a0b.h r106 = a0b.h.f1349a;
        Log.i("MediaResourceController", "injectInterruptCallback");
        a0b.h.f1352d = r105;
    }
}
