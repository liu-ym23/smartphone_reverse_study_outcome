package com.ss.android.bytedcert.net;

import android.util.Pair;
import com.ss.android.cert.manager.utils.net.CertResponse;

/* JADX INFO: loaded from: classes34.dex */
public class BDResponse extends CertResponse {
    public String sdkData;
    public String ticket;
    public String videoPath;

    @Override // com.ss.android.cert.manager.utils.net.CertResponse
    public String toString() {
        return "BDResponse{bcResponse=" + this.bcResponse + ", success=" + this.success + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', detailErrorCode=" + this.detailErrorCode + ", detailErrorMsg='" + this.detailErrorMsg + "', logId='" + this.logId + "', jsonBody=" + this.jsonBody + ", jsonData=" + this.jsonData + ", ticket='" + this.ticket + "', videoPath='" + this.videoPath + "'}";
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public BDResponse(Pair<Integer, String> r100) {
        super(r100);
    }

    public void setVideoPath(String r100) {
        this.videoPath = r100;
    }

    public BDResponse(CertResponse r100) {
        super(r100);
    }
}
