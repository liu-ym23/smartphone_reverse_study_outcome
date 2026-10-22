package com.ss.android.bytedcert.face;

import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class x implements SDKCallBack.CommonRequestCallback {
    public x() {
    }

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
    public final void onRequestFinish(BDResponse r100) {
        CertLog.d("FaceDetectFlow", "reportFailedLog response = " + r100.jsonBody);
    }
}
