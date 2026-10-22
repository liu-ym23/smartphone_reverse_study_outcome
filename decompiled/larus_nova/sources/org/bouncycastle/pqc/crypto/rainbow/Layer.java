package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Layer {
    private short[][][] coeff_alpha;
    private short[][][] coeff_beta;
    private short[] coeff_eta;
    private short[][] coeff_gamma;

    /* JADX INFO: renamed from: oi, reason: collision with root package name */
    private int f525579oi;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int f525580vi;
    private int viNext;

    public Layer(byte r100, byte r101, short[][][] r102, short[][][] r103, short[][] r104, short[] r105) {
        int r106 = r100 & UByte.MAX_VALUE;
        this.f525580vi = r106;
        int r107 = r101 & UByte.MAX_VALUE;
        this.viNext = r107;
        this.f525579oi = r107 - r106;
        this.coeff_alpha = r102;
        this.coeff_beta = r103;
        this.coeff_gamma = r104;
        this.coeff_eta = r105;
    }

    public Layer(int r100, int r101, SecureRandom r102) {
        this.f525580vi = r100;
        this.viNext = r101;
        int r103 = r101 - r100;
        this.f525579oi = r103;
        int r104 = 0;
        this.coeff_alpha = (short[][][]) Array.newInstance(Short.TYPE, new int[]{r103, r103, r100});
        int r105 = this.f525579oi;
        int r106 = this.f525580vi;
        this.coeff_beta = (short[][][]) Array.newInstance(Short.TYPE, new int[]{r105, r106, r106});
        this.coeff_gamma = (short[][]) Array.newInstance(Short.TYPE, new int[]{this.f525579oi, this.viNext});
        int r107 = this.f525579oi;
        this.coeff_eta = new short[r107];
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L13;
        int r109 = 0;
    L6:
        if (r109 >= this.f525579oi) goto L12;
        int r110 = 0;
    L9:
        if (r110 >= this.f525580vi) goto L11;
        this.coeff_alpha[r108][r109][r110] = (short) (r102.nextInt() & 255);
        r110 = r110 + 1;
        goto L9
    L11:
        r109 = r109 + 1;
        goto L6
    L12:
        r108 = r108 + 1;
        goto L3
    L13:
        int r111 = 0;
    L14:
        if (r111 >= r107) goto L24;
        int r112 = 0;
    L17:
        if (r112 >= this.f525580vi) goto L23;
        int r113 = 0;
    L20:
        if (r113 >= this.f525580vi) goto L22;
        this.coeff_beta[r111][r112][r113] = (short) (r102.nextInt() & 255);
        r113 = r113 + 1;
        goto L20
    L22:
        r112 = r112 + 1;
        goto L17
    L23:
        r111 = r111 + 1;
        goto L14
    L24:
        int r114 = 0;
    L25:
        if (r114 >= r107) goto L31;
        int r115 = 0;
    L28:
        if (r115 >= this.viNext) goto L30;
        this.coeff_gamma[r114][r115] = (short) (r102.nextInt() & 255);
        r115 = r115 + 1;
        goto L28
    L30:
        r114 = r114 + 1;
    L31:
        if (r104 >= r107) goto L33;
        this.coeff_eta[r104] = (short) (r102.nextInt() & 255);
        r104 = r104 + 1;
        goto L31
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof Layer) == false) goto L31;
        Layer r101 = (Layer) r100;
        if (this.f525580vi == r101.getVi()) goto L10;
        return false;
    L10:
        if (this.viNext == r101.getViNext()) goto L12;
        return false;
    L12:
        if (this.f525579oi == r101.getOi()) goto L14;
        return false;
    L14:
        if (RainbowUtil.equals(this.coeff_alpha, r101.getCoeffAlpha()) == true) goto L16;
        return false;
    L16:
        if (RainbowUtil.equals(this.coeff_beta, r101.getCoeffBeta()) == true) goto L18;
        return false;
    L18:
        if (RainbowUtil.equals(this.coeff_gamma, r101.getCoeffGamma()) == true) goto L20;
        return false;
    L20:
        if (RainbowUtil.equals(this.coeff_eta, r101.getCoeffEta()) == false) goto L30;
        return true;
    L30:
        return false;
    L31:
        return false;
    }

    public short[][][] getCoeffAlpha() {
        return this.coeff_alpha;
    }

    public short[][][] getCoeffBeta() {
        return this.coeff_beta;
    }

    public short[] getCoeffEta() {
        return this.coeff_eta;
    }

    public short[][] getCoeffGamma() {
        return this.coeff_gamma;
    }

    public int getOi() {
        return this.f525579oi;
    }

    public int getVi() {
        return this.f525580vi;
    }

    public int getViNext() {
        return this.viNext;
    }

    public int hashCode() {
        return (((((((((((this.f525580vi * 37) + this.viNext) * 37) + this.f525579oi) * 37) + Arrays.hashCode(this.coeff_alpha)) * 37) + Arrays.hashCode(this.coeff_beta)) * 37) + Arrays.hashCode(this.coeff_gamma)) * 37) + Arrays.hashCode(this.coeff_eta);
    }

    public short[][] plugInVinegars(short[] r110) {
        int r100 = this.f525579oi;
        int r101 = 0;
        short[][] r102 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100, r100 + 1});
        short[] r103 = new short[this.f525579oi];
        int r104 = 0;
    L4:
        if (r104 >= this.f525579oi) goto L14;
        int r105 = 0;
    L7:
        if (r105 >= this.f525580vi) goto L13;
        int r106 = 0;
    L10:
        if (r106 >= this.f525580vi) goto L12;
        r103[r104] = GF2Field.addElem(r103[r104], GF2Field.multElem(GF2Field.multElem(this.coeff_beta[r104][r105][r106], r110[r105]), r110[r106]));
        r106 = r106 + 1;
        goto L10
    L12:
        r105 = r105 + 1;
        goto L7
    L13:
        r104 = r104 + 1;
        goto L4
    L14:
        int r107 = 0;
    L16:
        if (r107 >= this.f525579oi) goto L26;
        int r108 = 0;
    L19:
        if (r108 >= this.f525579oi) goto L25;
        int r109 = 0;
    L22:
        if (r109 >= this.f525580vi) goto L24;
        short r111 = GF2Field.multElem(this.coeff_alpha[r107][r108][r109], r110[r109]);
        short[] r112 = r102[r107];
        r112[r108] = GF2Field.addElem(r112[r108], r111);
        r109 = r109 + 1;
        goto L22
    L24:
        r108 = r108 + 1;
        goto L19
    L25:
        r107 = r107 + 1;
        goto L16
    L26:
        int r113 = 0;
    L28:
        if (r113 >= this.f525579oi) goto L34;
        int r114 = 0;
    L31:
        if (r114 >= this.f525580vi) goto L33;
        r103[r113] = GF2Field.addElem(r103[r113], GF2Field.multElem(this.coeff_gamma[r113][r114], r110[r114]));
        r114 = r114 + 1;
        goto L31
    L33:
        r113 = r113 + 1;
        goto L28
    L34:
        int r115 = 0;
    L36:
        if (r115 >= this.f525579oi) goto L42;
        int r116 = this.f525580vi;
    L39:
        if (r116 >= this.viNext) goto L41;
        short[] r117 = r102[r115];
        int r118 = this.f525580vi;
        r117[r116 - r118] = GF2Field.addElem(this.coeff_gamma[r115][r116], r117[r116 - r118]);
        r116 = r116 + 1;
        goto L39
    L41:
        r115 = r115 + 1;
        goto L36
    L42:
        int r119 = 0;
    L44:
        if (r119 >= this.f525579oi) goto L46;
        r103[r119] = GF2Field.addElem(r103[r119], this.coeff_eta[r119]);
        r119 = r119 + 1;
    L46:
        int r120 = this.f525579oi;
        if (r101 >= r120) goto L49;
        r102[r101][r120] = r103[r101];
        r101 = r101 + 1;
        goto L46
    L49:
        return r102;
    }
}
