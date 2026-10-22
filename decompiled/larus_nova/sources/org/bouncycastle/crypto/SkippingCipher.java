package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface SkippingCipher {
    long getPosition();

    long seekTo(long r100);

    long skip(long r100);
}
