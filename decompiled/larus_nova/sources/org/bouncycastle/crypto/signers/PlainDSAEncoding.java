package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class PlainDSAEncoding implements DSAEncoding {
    public static final PlainDSAEncoding INSTANCE = null;

    static {
        INSTANCE = new PlainDSAEncoding();
    }

    public PlainDSAEncoding() {
    }

    private void encodeValue(BigInteger r100, BigInteger r101, byte[] r102, int r103, int r104) {
        byte[] r105 = checkValue(r100, r101).toByteArray();
        int r106 = Math.max(0, r105.length - r104);
        int r107 = r105.length - r106;
        int r108 = (r104 - r107) + r103;
        Arrays.fill(r102, r103, r108, (byte) 0);
        System.arraycopy(r105, r106, r102, r108, r107);
    }

    public BigInteger checkValue(BigInteger r100, BigInteger r101) {
        if (r101.signum() < 0) goto L8;
        if (r101.compareTo(r100) >= 0) goto L8;
        return r101;
    L8:
        throw new IllegalArgumentException("Value out of range");
    }

    @Override // org.bouncycastle.crypto.signers.DSAEncoding
    public BigInteger[] decode(BigInteger r100, byte[] r101) {
        int r102 = BigIntegers.getUnsignedByteLength(r100);
        if (r101.length != (r102 * 2)) goto L7;
        return new BigInteger[]{decodeValue(r100, r101, 0, r102), decodeValue(r100, r101, r102, r102)};
    L7:
        throw new IllegalArgumentException("Encoding has incorrect length");
    }

    public BigInteger decodeValue(BigInteger r100, byte[] r101, int r102, int r103) {
        return checkValue(r100, new BigInteger(1, Arrays.copyOfRange(r101, r102, r103 + r102)));
    }

    @Override // org.bouncycastle.crypto.signers.DSAEncoding
    public byte[] encode(BigInteger r100, BigInteger r110, BigInteger r111) {
        int r101 = BigIntegers.getUnsignedByteLength(r100);
        byte[] r102 = new byte[r101 * 2];
        encodeValue(r100, r110, r102, 0, r101);
        encodeValue(r100, r111, r102, r101, r101);
        return r102;
    }
}
