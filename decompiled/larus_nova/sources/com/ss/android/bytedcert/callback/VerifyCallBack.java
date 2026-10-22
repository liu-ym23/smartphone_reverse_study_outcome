package com.ss.android.bytedcert.callback;

import com.ss.android.bytedcert.net.BDResponse;

/* JADX INFO: loaded from: classes34.dex */
public interface VerifyCallBack {

    public interface UploadCallback {
        void onUploadFinish(BDResponse r100);
    }

    void doUploadVideo(String r100, int r101);

    void doVerify(int r100);

    void onRecordFinish(UploadCallback r100);
}
