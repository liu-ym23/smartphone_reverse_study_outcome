package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Committer {
    Commitment commit(byte[] r100);

    boolean isRevealed(Commitment r100, byte[] r101);
}
