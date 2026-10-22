package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreTokenType;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreVoiceAssistantContextCreateParameter {
    public String appKey;
    public String businessInfo;
    public String connectPoolBusiness;
    public int connectTimeout;
    public String dumpDir;
    public boolean enableConnectPool;
    public boolean enableFallback;
    public boolean enableFrontier;
    public boolean enableHostTransport;
    public boolean enableTransferRetry;
    public int encodeFrameSize;
    public String header;
    public int pingPongInterval;
    public String protoVersion;
    public int retryPingPongTimeout;
    public int[] retryTimeArray;
    public int sendBufferSize;
    public String taskId;
    public String taskInfo;
    public String token;
    public SAMICoreTokenType tokenType;
    public String url;

    public SAMICoreVoiceAssistantContextCreateParameter() {
    }

    public int getTokenType() {
        SAMICoreTokenType r100 = this.tokenType;
        if (r100 == null) goto L7;
        return r100.getValue();
    L7:
        return SAMICoreTokenType.TOKEN_TO_B.getValue();
    }

    public void setTokenType(int r100) {
        this.tokenType = SAMICoreTokenType.fromInt(r100);
    }
}
