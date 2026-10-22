package com.bytedance.retrofit2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface LegacyLogRecorder {
    void generateOldFormatLog(JSONObject r100) throws JSONException;

    void setAccountRetryCallbackDuration(long r100);

    void setBdTuringCallbackDuration(long r100);

    void setKernelDns(long r100);

    void setKernelPush(long r100);

    void setKernelReceiveBody(long r100);

    void setKernelSend(long r100);

    void setKernelTCPConnect(long r100);

    void setKernelTTFB(long r100);

    void setKernelTls(long r100);

    void setKernelTotal(long r100);

    void setNetworkKernelRawRequestLog(String r100);

    void setRequestEnd(long r100);

    void setRequestEndAppResumeState(long r100);
}
