package com.heytap.msp.push.callback;

/* JADX INFO: loaded from: classes3.dex */
public interface ICallBackResultService {
    void onError(int r100, String r101, String r102, String r103);

    void onGetNotificationStatus(int r100, int r101);

    void onGetPushStatus(int r100, int r101);

    void onRegister(int r100, String r101, String r102, String r103);

    void onSetPushTime(int r100, String r101);

    void onUnRegister(int r100, String r101, String r102);
}
