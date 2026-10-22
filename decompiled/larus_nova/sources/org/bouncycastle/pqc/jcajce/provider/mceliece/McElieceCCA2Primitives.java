package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes42.dex */
public final class McElieceCCA2Primitives {
    private McElieceCCA2Primitives() {
    }

    public static GF2Vector[] decryptionPrimitive(McElieceCCA2PrivateKeyParameters r100, GF2Vector r101) {
        int r102 = r100.getK();
        Permutation r103 = r100.getP();
        GF2mField r104 = r100.getField();
        PolynomialGF2mSmallM r105 = r100.getGoppaPoly();
        GF2Matrix r106 = r100.getH();
        PolynomialGF2mSmallM[] r107 = r100.getQInv();
        GF2Vector r108 = (GF2Vector) r101.multiply(r103.computeInverse());
        GF2Vector r109 = GoppaCode.syndromeDecode((GF2Vector) r106.rightMultiply(r108), r104, r105, r107);
        GF2Vector r110 = (GF2Vector) ((GF2Vector) r108.add(r109)).multiply(r103);
        GF2Vector r111 = (GF2Vector) r109.multiply(r103);
        return new GF2Vector[]{r110.extractRightVector(r102), r111};
    }

    public static GF2Vector[] decryptionPrimitive(BCMcElieceCCA2PrivateKey r100, GF2Vector r101) {
        int r102 = r100.getK();
        Permutation r103 = r100.getP();
        GF2mField r104 = r100.getField();
        PolynomialGF2mSmallM r105 = r100.getGoppaPoly();
        GF2Matrix r106 = r100.getH();
        PolynomialGF2mSmallM[] r107 = r100.getQInv();
        GF2Vector r108 = (GF2Vector) r101.multiply(r103.computeInverse());
        GF2Vector r109 = GoppaCode.syndromeDecode((GF2Vector) r106.rightMultiply(r108), r104, r105, r107);
        GF2Vector r110 = (GF2Vector) ((GF2Vector) r108.add(r109)).multiply(r103);
        GF2Vector r111 = (GF2Vector) r109.multiply(r103);
        return new GF2Vector[]{r110.extractRightVector(r102), r111};
    }

    public static GF2Vector encryptionPrimitive(McElieceCCA2PublicKeyParameters r100, GF2Vector r101, GF2Vector r102) {
        return (GF2Vector) r100.getG().leftMultiplyLeftCompactForm(r101).add(r102);
    }

    public static GF2Vector encryptionPrimitive(BCMcElieceCCA2PublicKey r100, GF2Vector r101, GF2Vector r102) {
        return (GF2Vector) r100.getG().leftMultiplyLeftCompactForm(r101).add(r102);
    }
}
