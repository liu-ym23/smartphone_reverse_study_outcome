package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public class TBCPadding implements BlockCipherPadding {
    public TBCPadding() {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] r100, int r101) {
        int r102 = r100.length - r101;
        int r103 = 255;
        if (r101 <= 0) goto L8;
        if ((r100[r101 - 1] & 1) == 0) goto L11;
    L10:
        r103 = 0;
    L11:
        byte r104 = (byte) r103;
    L13:
        if (r101 >= r100.length) goto L15;
        r100[r101] = r104;
        r101 = r101 + 1;
        goto L13
    L15:
        return r102;
    L8:
        if ((r100[r100.length - 1] & 1) != 0) goto L10;
        goto L10
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "TBC";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom r100) throws IllegalArgumentException {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] r100) throws InvalidCipherTextException {
        byte r101 = r100[r100.length - 1];
        int r102 = r100.length - 1;
    L3:
        if (r102 <= 0) goto L8;
        if (r100[r102 - 1] != r101) goto L8;
        r102 = r102 - 1;
    L8:
        return r100.length - r102;
    }
}
