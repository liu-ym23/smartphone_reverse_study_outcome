package com.dtf.face.api;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes22.dex */
public interface IDTLoadingFragment {

    public interface IMessageBoxCB {
        void onCancel();

        void onOK();
    }

    FrameLayout getAuthorizationViewContainer();

    void hideAuthorizationView();

    void hideLoadingView();

    void initTitleBar(boolean r100);

    void onUILoadSuccess();

    void setCloseCallBack(IDTFragment.ICloseCallBack r100);

    void showAuthorizationView();

    void showLoadingView();

    void showMessageBox(String r100, String r101, String r102, String r103, String r104, IMessageBoxCB r105);
}
