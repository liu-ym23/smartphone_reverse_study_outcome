package com.bytedance.crypto.modeldist;

/* JADX INFO: loaded from: classes15.dex */
public class ModelInitResult {
    private String attestCertChain;
    private int errorCode;

    public ModelInitResult(int r100, String r101) {
        this.errorCode = r100;
        this.attestCertChain = r101;
    }

    public String getAttestCertChain() {
        return this.attestCertChain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
