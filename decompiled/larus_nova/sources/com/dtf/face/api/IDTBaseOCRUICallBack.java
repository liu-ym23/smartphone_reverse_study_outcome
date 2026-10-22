package com.dtf.face.api;

/* JADX INFO: loaded from: classes22.dex */
public interface IDTBaseOCRUICallBack {
    boolean onBackPressed();

    boolean onMessageBoxShow(String r100, String r101, String r102, String r103, String r104, IDTUICallBack.MessageBoxCallBack r105);

    void onVerifyBegin();

    void onVerifyEnd();
}
