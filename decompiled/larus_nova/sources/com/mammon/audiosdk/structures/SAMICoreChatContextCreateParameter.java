package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreTokenType;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreChatContextCreateParameter {
    public String appKey;
    public int channel;
    public int connect_timeout;
    public String format;
    public String header;
    public int sampleRate;
    public String taskId;
    public String token;
    public SAMICoreTokenType tokenType;
    public String url;

    public SAMICoreChatContextCreateParameter() {
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
