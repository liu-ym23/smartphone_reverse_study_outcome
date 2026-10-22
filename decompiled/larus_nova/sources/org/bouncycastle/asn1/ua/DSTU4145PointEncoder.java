package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DSTU4145PointEncoder {
    public DSTU4145PointEncoder() {
    }

    public static ECPoint decodePoint(ECCurve r100, byte[] r101) {
        ECFieldElement r102 = r100.fromBigInteger(BigInteger.valueOf(r101[r101.length - 1] & 1));
        ECFieldElement r103 = r100.fromBigInteger(new BigInteger(1, r101));
        if (trace(r103).equals(r100.getA()) == true) goto L6;
        r103 = r103.addOne();
    L6:
        if (r103.isZero() == false) goto L8;
        ECFieldElement r104 = r100.getB().sqrt();
    L15:
        if (r104 == null) goto L19;
        return r100.validatePoint(r103.toBigInteger(), r104.toBigInteger());
    L19:
        throw new IllegalArgumentException("Invalid point compression");
    L8:
        ECFieldElement r105 = solveQuadraticEquation(r100, r103.square().invert().multiply(r100.getB()).add(r100.getA()).add(r103));
        if (r105 != null) goto L11;
        r104 = null;
        goto L15
    L11:
        if (trace(r105).equals(r102) == true) goto L13;
        r105 = r105.addOne();
    L13:
        r104 = r103.multiply(r105);
        goto L15
    }

    public static byte[] encodePoint(ECPoint r100) {
        ECPoint r101 = r100.normalize();
        ECFieldElement r102 = r101.getAffineXCoord();
        byte[] r103 = r102.getEncoded();
        if (r102.isZero() == false) goto L5;
    L8:
        return r103;
    L5:
        if (trace(r101.getAffineYCoord().divide(r102)).isOne() == false) goto L7;
        int r104 = r103.length - 1;
        r103[r104] = (byte) (r103[r104] | 1);
        goto L8
    L7:
        int r105 = r103.length - 1;
        r103[r105] = (byte) (r103[r105] & 254);
        goto L8
    }

    private static ECFieldElement solveQuadraticEquation(ECCurve r100, ECFieldElement r101) {
        if (r101.isZero() == false) goto L5;
        return r101;
    L5:
        ECFieldElement r102 = r100.fromBigInteger(ECConstants.ZERO);
        Random r103 = new Random();
        int r104 = r101.getFieldSize();
    L6:
        ECFieldElement r105 = r100.fromBigInteger(new BigInteger(r104, r103));
        int r106 = 1;
        ECFieldElement r107 = r101;
        ECFieldElement r108 = r102;
    L8:
        if (r106 > (r104 - 1)) goto L11;
        ECFieldElement r109 = r107.square();
        r108 = r108.square().add(r109.multiply(r105));
        r107 = r109.add(r101);
        r106 = r106 + 1;
        goto L8
    L11:
        if (r107.isZero() == false) goto L12;
        if (r108.square().add(r108).isZero() == true) goto L6;
        return r108;
    L12:
        return null;
    }

    private static ECFieldElement trace(ECFieldElement r100) {
        int r101 = 1;
        ECFieldElement r102 = r100;
    L4:
        if (r101 >= r100.getFieldSize()) goto L6;
        r102 = r102.square().add(r100);
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }
}
