package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f525594b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f525595b2;
    private Layer[] layers;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525596vi;

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters r100) {
        this(r100.getInvA1(), r100.getB1(), r100.getInvA2(), r100.getB2(), r100.getVi(), r100.getLayers());
    }

    public BCRainbowPrivateKey(RainbowPrivateKeySpec r100) {
        this(r100.getInvA1(), r100.getB1(), r100.getInvA2(), r100.getB2(), r100.getVi(), r100.getLayers());
    }

    public BCRainbowPrivateKey(short[][] r100, short[] r101, short[][] r102, short[] r103, int[] r104, Layer[] r105) {
        this.A1inv = r100;
        this.f525594b1 = r101;
        this.A2inv = r102;
        this.f525595b2 = r103;
        this.f525596vi = r104;
        this.layers = r105;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L38:
        return false;
    L5:
        if ((r100 instanceof BCRainbowPrivateKey) == false) goto L38;
        BCRainbowPrivateKey r101 = (BCRainbowPrivateKey) r100;
        if (RainbowUtil.equals(this.A1inv, r101.getInvA1()) == false) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L23;
    L25:
        boolean r105 = false;
    L26:
        if (r105 == true) goto L28;
    L30:
        boolean r106 = false;
    L32:
        if (this.layers.length == r101.getLayers().length) goto L34;
        return false;
    L34:
        int r107 = this.layers.length - 1;
    L35:
        if (r107 < 0) goto L37;
        r106 = r106 & this.layers[r107].equals(r101.getLayers()[r107]);
        r107 = r107 - 1;
        goto L35
    L37:
        return r106;
    L28:
        if (Arrays.equals(this.f525596vi, r101.getVi()) == false) goto L30;
        r106 = true;
        goto L32
    L23:
        if (RainbowUtil.equals(this.f525595b2, r101.getB2()) == false) goto L25;
        r105 = true;
        goto L26
    L18:
        if (RainbowUtil.equals(this.f525594b1, r101.getB1()) == false) goto L20;
        r104 = true;
        goto L21
    L13:
        if (RainbowUtil.equals(this.A2inv, r101.getInvA2()) == false) goto L15;
        r103 = true;
        goto L16
    L10:
        r102 = false;
        goto L11
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[] getB1() {
        return this.f525594b1;
    }

    public short[] getB2() {
        return this.f525595b2;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        RainbowPrivateKey r100 = new RainbowPrivateKey(this.A1inv, this.f525594b1, this.A2inv, this.f525595b2, this.f525596vi, this.layers);
        return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), r100).getEncoded();
    L8:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.f525596vi;
    }

    public int hashCode() {
        int r100 = (((((((((this.layers.length * 37) + org.bouncycastle.util.Arrays.hashCode(this.A1inv)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.f525594b1)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.A2inv)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.f525595b2)) * 37) + org.bouncycastle.util.Arrays.hashCode(this.f525596vi);
        int r101 = this.layers.length - 1;
    L3:
        if (r101 < 0) goto L5;
        r100 = (r100 * 37) + this.layers[r101].hashCode();
        r101 = r101 - 1;
        goto L3
    L5:
        return r100;
    }
}
