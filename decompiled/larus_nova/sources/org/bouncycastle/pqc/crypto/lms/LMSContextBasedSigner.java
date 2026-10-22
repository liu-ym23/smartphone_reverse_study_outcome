package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes42.dex */
public interface LMSContextBasedSigner {
    LMSContext generateLMSContext();

    byte[] generateSignature(LMSContext r100);

    long getUsagesRemaining();
}
