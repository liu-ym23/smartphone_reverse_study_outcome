package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

/* JADX INFO: loaded from: classes42.dex */
public class X9IntegerConverter {
    public X9IntegerConverter() {
    }

    public int getByteLength(ECCurve r100) {
        return (r100.getFieldSize() + 7) / 8;
    }

    public int getByteLength(ECFieldElement r100) {
        return (r100.getFieldSize() + 7) / 8;
    }

    public byte[] integerToBytes(BigInteger r100, int r101) {
        byte[] r102 = r100.toByteArray();
        if (r101 >= r102.length) goto L7;
        byte[] r103 = new byte[r101];
        System.arraycopy(r102, r102.length - r101, r103, 0, r101);
        return r103;
    L7:
        if (r101 <= r102.length) goto L10;
        byte[] r104 = new byte[r101];
        System.arraycopy(r102, 0, r104, r101 - r102.length, r102.length);
        return r104;
    L10:
        return r102;
    }
}
