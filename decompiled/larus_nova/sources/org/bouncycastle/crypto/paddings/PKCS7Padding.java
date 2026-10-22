package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS7Padding implements BlockCipherPadding {
    public PKCS7Padding() {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] r100, int r101) {
        byte r102 = (byte) (r100.length - r101);
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "PKCS7";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom r100) throws IllegalArgumentException {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] r100) throws InvalidCipherTextException {
        int r101 = r100[r100.length - 1] & UByte.MAX_VALUE;
        byte r102 = (byte) r101;
        if (r101 <= r100.length) goto L5;
        boolean r103 = true;
    L6:
        if (r101 != 0) goto L8;
        boolean r104 = true;
    L9:
        boolean r105 = r103 | r104;
        int r106 = 0;
    L11:
        if (r106 >= r100.length) goto L21;
        if ((r100.length - r106) > r101) goto L15;
        boolean r107 = true;
    L17:
        if (r100[r106] == r102) goto L19;
        boolean r108 = true;
    L20:
        r105 = r105 | (r107 & r108);
        r106 = r106 + 1;
        goto L11
    L19:
        r108 = false;
        goto L20
    L15:
        r107 = false;
        goto L17
    L21:
        if (r105 == true) goto L24;
        return r101;
    L24:
        throw new InvalidCipherTextException("pad block corrupted");
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
