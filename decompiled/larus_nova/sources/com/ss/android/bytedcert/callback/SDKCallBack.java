package com.ss.android.bytedcert.callback;

import com.ss.android.bytedcert.net.BDResponse;

/* JADX INFO: loaded from: classes34.dex */
public interface SDKCallBack {

    public interface CommonRequestCallback {
        void onRequestFinish(BDResponse r100);
    }

    public interface DownloadCallback {
        void onFinish(BDResponse r100);
    }

    public interface FaceLiveCallback {
        void onFaceLiveFinish(BDResponse r100);
    }

    public interface VideoRecordCallback {
        void onFinish(BDResponse r100, String r101, String r102);
    }
}
