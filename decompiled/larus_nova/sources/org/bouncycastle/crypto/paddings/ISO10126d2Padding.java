package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public class ISO10126d2Padding implements BlockCipherPadding {
    SecureRandom random;

    public ISO10126d2Padding() {
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] r100, int r101) {
        byte r102 = (byte) (r100.length - r101);
    L4:
        if (r101 >= (r100.length - 1)) goto L6;
        r100[r101] = (byte) this.random.nextInt();
        r101 = r101 + 1;
        goto L4
    L6:
        r100[r101] = r102;
        return r102;
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO10126-2";
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom r100) throws IllegalArgumentException {
        this.random = CryptoServicesRegistrar.getSecureRandom(r100);
    }

    @Override // org.bouncycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] r100) throws InvalidCipherTextException {
        int r101 = r100[r100.length - 1] & UByte.MAX_VALUE;
        if (r101 > r100.length) goto L6;
        return r101;
    L6:
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
