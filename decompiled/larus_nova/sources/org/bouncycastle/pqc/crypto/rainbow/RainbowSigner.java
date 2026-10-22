package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowSigner implements MessageSigner {
    private static final int MAXITS = 65536;

    /* JADX INFO: renamed from: cf, reason: collision with root package name */
    private ComputeInField f525589cf;
    RainbowKeyParameters key;
    private SecureRandom random;
    int signableDocumentLength;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private short[] f525590x;

    public RainbowSigner() {
        this.f525589cf = new ComputeInField();
    }

    private short[] initSign(Layer[] r100, short[] r101) {
        short[] r102 = new short[r101.length];
        short[] r103 = this.f525589cf.addVect(((RainbowPrivateKeyParameters) this.key).getB1(), r101);
        short[] r104 = this.f525589cf.multiplyMatrix(((RainbowPrivateKeyParameters) this.key).getInvA1(), r103);
        int r105 = 0;
    L4:
        if (r105 >= r100[0].getVi()) goto L6;
        this.f525590x[r105] = (short) this.random.nextInt();
        short[] r106 = this.f525590x;
        r106[r105] = (short) (r106[r105] & 255);
        r105 = r105 + 1;
        goto L4
    L6:
        return r104;
    }

    private short[] makeMessageRepresentative(byte[] r100) {
        int r101 = this.signableDocumentLength;
        short[] r102 = new short[r101];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L8;
        short r105 = r100[r104];
        r102[r103] = r105;
        r102[r103] = (short) (r105 & 255);
        r104 = r104 + 1;
        r103 = r103 + 1;
        if (r103 < r101) goto L4;
    L8:
        return r102;
    }

    private short[] verifySignatureIntern(short[] r110) {
        short[][] r100 = ((RainbowPublicKeyParameters) this.key).getCoeffQuadratic();
        short[][] r101 = ((RainbowPublicKeyParameters) this.key).getCoeffSingular();
        short[] r102 = ((RainbowPublicKeyParameters) this.key).getCoeffScalar();
        short[] r103 = new short[r100.length];
        int r104 = r101[0].length;
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L12;
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r104) goto L11;
        int r108 = r106;
    L8:
        if (r108 >= r104) goto L10;
        short r111 = GF2Field.multElem(r100[r105][r107], GF2Field.multElem(r110[r106], r110[r108]));
        r103[r105] = GF2Field.addElem(r103[r105], r111);
        r107 = r107 + 1;
        r108 = r108 + 1;
        goto L8
    L10:
        short r109 = GF2Field.multElem(r101[r105][r106], r110[r106]);
        r103[r105] = GF2Field.addElem(r103[r105], r109);
        r106 = r106 + 1;
        goto L6
    L11:
        r103[r105] = GF2Field.addElem(r103[r105], r102[r105]);
        r105 = r105 + 1;
        goto L4
    L12:
        return r103;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r110) {
        Layer[] r100 = ((RainbowPrivateKeyParameters) this.key).getLayers();
        int r101 = r100.length;
        this.f525590x = new short[((RainbowPrivateKeyParameters) this.key).getInvA2().length];
        int r102 = r100[r101 - 1].getViNext();
        byte[] r103 = new byte[r102];
        short[] r111 = makeMessageRepresentative(r110);
        int r104 = 0;
    L32:
        short[] r105 = initSign(r100, r111);     // Catch: Exception -> L23
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r106 >= r101) goto L18;
        short[] r108 = new short[r100[r106].getOi()];     // Catch: Exception -> L23
        short[] r112 = new short[r100[r106].getOi()];     // Catch: Exception -> L23
        int r113 = 0;
    L7:
        if (r113 >= r100[r106].getOi()) goto L9;
        r108[r113] = r105[r107];     // Catch: Exception -> L23
        r107 = r107 + 1;     // Catch: Exception -> L23
        r113 = r113 + 1;     // Catch: Exception -> L23
        goto L7
    L9:
        short[] r109 = this.f525589cf.solveEquation(r100[r106].plugInVinegars(this.f525590x), r108);     // Catch: Exception -> L23
        if (r109 == null) goto L17;
        int r114 = 0;
    L13:
        if (r114 >= r109.length) goto L15;
        this.f525590x[r100[r106].getVi() + r114] = r109[r114];     // Catch: Exception -> L23
        r114 = r114 + 1;     // Catch: Exception -> L23
        goto L13
    L15:
        r106 = r106 + 1;     // Catch: Exception -> L23
        goto L4
    L17:
        throw new Exception("LES is not solveable!");     // Catch: Exception -> L23
    L18:
        short[] r115 = this.f525589cf.multiplyMatrix(((RainbowPrivateKeyParameters) this.key).getInvA2(), this.f525589cf.addVect(((RainbowPrivateKeyParameters) this.key).getB2(), this.f525590x));     // Catch: Exception -> L23
        int r116 = 0;
    L19:
        if (r116 >= r102) goto L22;
        r103[r116] = (byte) r115[r116];     // Catch: Exception -> L23
        r116 = r116 + 1;
        goto L19
    L22:
        boolean r117 = true;
    L25:
        if (r117 == true) goto L28;
        r104 = r104 + 1;
        if (r104 < 65536) goto L32;
    L28:
        if (r104 == 65536) goto L31;
        return r103;
    L31:
        throw new IllegalStateException("unable to generate signature - LES not solvable");
    L23:
        r117 = false;
        goto L25
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        RainbowKeyParameters r102 = (RainbowPublicKeyParameters) r101;
    L8:
        this.key = r102;
    L9:
        this.signableDocumentLength = this.key.getDocLength();
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.random = r103.getRandom();
        this.key = (RainbowPrivateKeyParameters) r103.getParameters();
        goto L9
    L6:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        r102 = (RainbowPrivateKeyParameters) r101;
        goto L8
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        short[] r102 = new short[r101.length];
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L6;
        r102[r103] = (short) (r101[r103] & 255);
        r103 = r103 + 1;
        goto L4
    L6:
        short[] r104 = makeMessageRepresentative(r100);
        short[] r105 = verifySignatureIntern(r102);
        if (r104.length == r105.length) goto L9;
        return false;
    L9:
        int r106 = 0;
        boolean r107 = true;
    L11:
        if (r106 >= r104.length) goto L18;
        if (r107 == true) goto L14;
    L16:
        r107 = false;
    L17:
        r106 = r106 + 1;
        goto L11
    L14:
        if (r104[r106] != r105[r106]) goto L16;
        r107 = true;
        goto L17
    L18:
        return r107;
    }
}
