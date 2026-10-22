package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes42.dex */
public interface LMSContextBasedVerifier {
    LMSContext generateLMSContext(byte[] r100);

    boolean verify(LMSContext r100);
}
