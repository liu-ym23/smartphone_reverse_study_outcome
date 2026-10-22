package org.bouncycastle.pqc.crypto.rainbow;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;

    public RainbowPublicKeyParameters(int r100, short[][] r101, short[][] r102, short[] r103) {
        super(false, r100);
        this.coeffquadratic = r101;
        this.coeffsingular = r102;
        this.coeffscalar = r103;
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return this.coeffscalar;
    }

    public short[][] getCoeffSingular() {
        return this.coeffsingular;
    }
}
