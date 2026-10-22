package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreHttpPayloadType;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreHttpCommonContextResponseBody {
    public String apiNamespace;
    public byte[] data;
    public Object payload;
    public SAMICoreHttpPayloadType payloadType;
    public int statusCode;
    public String statusText;
    public String taskId;

    public SAMICoreHttpCommonContextResponseBody() {
    }

    public int getPayloadType() {
        SAMICoreHttpPayloadType r100 = this.payloadType;
        if (r100 != null) goto L5;
        System.out.println("payloadType is null, return 0 as fallback!");
        return 0;
    L5:
        return r100.getValue();
    }

    public void setPayloadType(int r100) {
        this.payloadType = SAMICoreHttpPayloadType.fromInt(r100);
    }
}
