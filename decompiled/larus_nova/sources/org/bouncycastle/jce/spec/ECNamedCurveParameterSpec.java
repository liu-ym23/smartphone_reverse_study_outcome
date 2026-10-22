package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECNamedCurveParameterSpec extends ECParameterSpec {
    private String name;

    public ECNamedCurveParameterSpec(String r100, ECCurve r101, ECPoint r102, BigInteger r103) {
        super(r101, r102, r103);
        this.name = r100;
    }

    public ECNamedCurveParameterSpec(String r100, ECCurve r101, ECPoint r102, BigInteger r103, BigInteger r104) {
        super(r101, r102, r103, r104);
        this.name = r100;
    }

    public ECNamedCurveParameterSpec(String r100, ECCurve r101, ECPoint r102, BigInteger r110, BigInteger r111, byte[] r112) {
        super(r101, r102, r110, r111, r112);
        this.name = r100;
    }

    public String getName() {
        return this.name;
    }
}
