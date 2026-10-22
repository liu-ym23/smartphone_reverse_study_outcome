package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private RainbowParameters rainbowParams;

    public BCRainbowPublicKey(int r100, short[][] r101, short[][] r102, short[] r103) {
        this.docLength = r100;
        this.coeffquadratic = r101;
        this.coeffsingular = r102;
        this.coeffscalar = r103;
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters r100) {
        this(r100.getDocLength(), r100.getCoeffQuadratic(), r100.getCoeffSingular(), r100.getCoeffScalar());
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec r100) {
        this(r100.getDocLength(), r100.getCoeffQuadratic(), r100.getCoeffSingular(), r100.getCoeffScalar());
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof BCRainbowPublicKey) == false) goto L22;
        BCRainbowPublicKey r101 = (BCRainbowPublicKey) r100;
        if (this.docLength == r101.getDocLength()) goto L10;
        return false;
    L10:
        if (RainbowUtil.equals(this.coeffquadratic, r101.getCoeffQuadratic()) == true) goto L12;
        return false;
    L12:
        if (RainbowUtil.equals(this.coeffsingular, r101.getCoeffSingular()) == true) goto L14;
        return false;
    L14:
        if (RainbowUtil.equals(this.coeffscalar, r101.getCoeffScalar()) == false) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return Arrays.clone(this.coeffscalar);
    }

    public short[][] getCoeffSingular() {
        short[][] r100 = new short[this.coeffsingular.length][];
        int r101 = 0;
    L3:
        short[][] r102 = this.coeffsingular;
        if (r101 == r102.length) goto L6;
        r100[r101] = Arrays.clone(r102[r101]);
        r101 = r101 + 1;
        goto L3
    L6:
        return r100;
    }

    public int getDocLength() {
        return this.docLength;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        RainbowPublicKey r100 = new RainbowPublicKey(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar);
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), r100);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + Arrays.hashCode(this.coeffquadratic)) * 37) + Arrays.hashCode(this.coeffsingular)) * 37) + Arrays.hashCode(this.coeffscalar);
    }
}
