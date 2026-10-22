package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ECNamedCurveSpec extends java.security.spec.ECParameterSpec {
    private String name;

    public ECNamedCurveSpec(String r100, EllipticCurve r101, ECPoint r102, BigInteger r103) {
        super(r101, r102, r103, 1);
        this.name = r100;
    }

    public ECNamedCurveSpec(String r100, EllipticCurve r101, ECPoint r102, BigInteger r103, BigInteger r104) {
        super(r101, r102, r103, r104.intValue());
        this.name = r100;
    }

    public ECNamedCurveSpec(String r100, ECCurve r101, org.bouncycastle.math.ec.ECPoint r102, BigInteger r103) {
        super(convertCurve(r101, null), EC5Util.convertPoint(r102), r103, 1);
        this.name = r100;
    }

    public ECNamedCurveSpec(String r100, ECCurve r101, org.bouncycastle.math.ec.ECPoint r102, BigInteger r103, BigInteger r104) {
        super(convertCurve(r101, null), EC5Util.convertPoint(r102), r103, r104.intValue());
        this.name = r100;
    }

    public ECNamedCurveSpec(String r100, ECCurve r101, org.bouncycastle.math.ec.ECPoint r102, BigInteger r103, BigInteger r104, byte[] r105) {
        super(convertCurve(r101, r105), EC5Util.convertPoint(r102), r103, r104.intValue());
        this.name = r100;
    }

    private static EllipticCurve convertCurve(ECCurve r100, byte[] r101) {
        return new EllipticCurve(convertField(r100.getField()), r100.getA().toBigInteger(), r100.getB().toBigInteger(), r101);
    }

    private static ECField convertField(FiniteField r100) {
        if (ECAlgorithms.isFpField(r100) == true) goto L5;
        Polynomial r101 = ((PolynomialExtensionField) r100).getMinimalPolynomial();
        int[] r102 = r101.getExponentsPresent();
        int[] r103 = Arrays.reverse(Arrays.copyOfRange(r102, 1, r102.length - 1));
        return new ECFieldF2m(r101.getDegree(), r103);
    L5:
        return new ECFieldFp(r100.getCharacteristic());
    }

    public String getName() {
        return this.name;
    }
}
