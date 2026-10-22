package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes42.dex */
public class LMSParameters {
    private final LMOtsParameters lmOTSParam;
    private final LMSigParameters lmSigParam;

    public LMSParameters(LMSigParameters r100, LMOtsParameters r101) {
        this.lmSigParam = r100;
        this.lmOTSParam = r101;
    }

    public LMOtsParameters getLMOTSParam() {
        return this.lmOTSParam;
    }

    public LMSigParameters getLMSigParam() {
        return this.lmSigParam;
    }
}
