package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public class ZeroBytePadding implements BlockCipherPadding {
    public ZeroBytePadding() {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] r100, int r101) {
        int r102 = r100.length - r101;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ZeroByte";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom r100) throws IllegalArgumentException {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] r100) throws InvalidCipherTextException {
        int r101 = r100.length;
    L3:
        if (r101 <= 0) goto L9;
        if (r100[r101 - 1] != 0) goto L9;
        r101 = r101 - 1;
    L9:
        return r100.length - r101;
    }
}
