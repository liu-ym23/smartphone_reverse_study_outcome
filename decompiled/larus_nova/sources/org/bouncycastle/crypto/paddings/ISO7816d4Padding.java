package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public class ISO7816d4Padding implements BlockCipherPadding {
    public ISO7816d4Padding() {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] r100, int r101) {
        int r102 = r100.length - r101;
        r100[r101] = ByteCompanionObject.MIN_VALUE;
    L3:
        r101 = r101 + 1;
        if (r101 >= r100.length) goto L6;
        r100[r101] = 0;
        goto L3
    L6:
        return r102;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO7816-4";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom r100) throws IllegalArgumentException {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] r100) throws InvalidCipherTextException {
        int r101 = r100.length - 1;
    L3:
        if (r101 <= 0) goto L8;
        if (r100[r101] != 0) goto L8;
        r101 = r101 - 1;
    L8:
        if (r100[r101] != (-128)) goto L12;
        return r100.length - r101;
    L12:
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
