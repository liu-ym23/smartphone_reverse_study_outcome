package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Xof extends ExtendedDigest {
    int doFinal(byte[] r100, int r101, int r102);

    int doOutput(byte[] r100, int r101, int r102);
}
