package com.dtf.face.api;

/* JADX INFO: loaded from: classes22.dex */
public interface IDTUICallBack {

    public interface MessageBoxCallBack {
        void onCancel();

        void onOK();
    }

    boolean hasShowMessageBox();

    void hideMessageBox();

    boolean onBackPressed();

    boolean onMessageBoxShow(String r100, String r101, String r102, String r103, String r104, MessageBoxCallBack r105);

    void onRetry(int r100);

    void onTimeChanged(int r100, int r101);

    void onVerifyBegin();

    void onVerifyEnd();
}
