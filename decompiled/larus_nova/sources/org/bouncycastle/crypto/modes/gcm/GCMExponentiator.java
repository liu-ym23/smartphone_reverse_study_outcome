package org.bouncycastle.crypto.modes.gcm;

/* JADX INFO: loaded from: classes42.dex */
public interface GCMExponentiator {
    void exponentiateX(long r100, byte[] r101);

    void init(byte[] r100);
}
