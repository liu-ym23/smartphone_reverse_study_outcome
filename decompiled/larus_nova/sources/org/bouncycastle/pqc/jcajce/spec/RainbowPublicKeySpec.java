package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPublicKeySpec implements KeySpec {
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;

    public RainbowPublicKeySpec(int r100, short[][] r101, short[][] r102, short[] r103) {
        this.docLength = r100;
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

    public int getDocLength() {
        return this.docLength;
    }
}
