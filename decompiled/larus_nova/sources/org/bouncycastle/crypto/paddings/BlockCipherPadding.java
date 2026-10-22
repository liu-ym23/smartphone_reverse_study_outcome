package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public interface BlockCipherPadding {
    int addPadding(byte[] r100, int r101);

    String getPaddingName();

    void init(SecureRandom r100) throws IllegalArgumentException;

    int padCount(byte[] r100) throws InvalidCipherTextException;
}
