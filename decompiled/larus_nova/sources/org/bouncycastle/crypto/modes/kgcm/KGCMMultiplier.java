package org.bouncycastle.crypto.modes.kgcm;

/* JADX INFO: loaded from: classes42.dex */
public interface KGCMMultiplier {
    void init(long[] r100);

    void multiplyH(long[] r100);
}
