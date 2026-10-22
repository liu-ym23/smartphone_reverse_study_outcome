package com.ss.android.lark.qrcode.ui;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;

/* JADX INFO: loaded from: classes37.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void E4(String r100);

        BarcodeFormat[] getFormats();
    }

    void J4();

    void K4();

    void f();

    void hideLoading();

    void onResume();

    void showToast(String r100);
}
