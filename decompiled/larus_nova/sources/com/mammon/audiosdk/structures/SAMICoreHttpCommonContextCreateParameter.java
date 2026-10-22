package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreHttpPayloadType;
import com.mammon.audiosdk.enums.SAMICoreTokenType;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreHttpCommonContextCreateParameter {
    public String apiNamespace;
    public String appKey;
    public int connectTimeoutMs;
    public String customBodyItem;
    public byte[] data;
    public String header;
    public long mixedTokenTimestamp;
    public Object requestPayload;
    public SAMICoreHttpPayloadType requestPayloadType;
    public SAMICoreHttpPayloadType responsePayloadType;
    public String token;
    public SAMICoreTokenType tokenType;
    public String url;
    public String version;

    public SAMICoreHttpCommonContextCreateParameter() {
    }

    public int getRequestPayloadType() {
        SAMICoreHttpPayloadType r100 = this.requestPayloadType;
        if (r100 != null) goto L5;
        System.out.println("requestPayloadType is null, return 0 as fallback!");
        return 0;
    L5:
        return r100.getValue();
    }

    public int getResponsePayloadType() {
        SAMICoreHttpPayloadType r100 = this.responsePayloadType;
        if (r100 != null) goto L5;
        System.out.println("responsePayloadType is null, return 0 as fallback!");
        return 0;
    L5:
        return r100.getValue();
    }

    public int getTokenType() {
        SAMICoreTokenType r100 = this.tokenType;
        if (r100 != null) goto L5;
        System.out.println("tokenType is null, return 0 as fallback!");
        return 0;
    L5:
        return r100.getValue();
    }
}
