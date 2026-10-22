package com.tencent.mm.opensdk.diffdev;

/* JADX INFO: loaded from: classes40.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode r100, String r101);

    void onAuthGotQrcode(String r100, byte[] r101);

    void onQrcodeScanned();
}
