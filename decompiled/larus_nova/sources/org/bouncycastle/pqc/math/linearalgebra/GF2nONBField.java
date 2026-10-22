package org.bouncycastle.pqc.math.linearalgebra;

import com.obric.miniapp.alarm.AccountType;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes42.dex */
public class GF2nONBField extends GF2nField {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    int[][] mMult;
    private int mType;

    public GF2nONBField(int r100, SecureRandom r101) throws RuntimeException {
        super(r101);
        if (r100 < 3) goto L19;
        this.mDegree = r100;
        int r102 = r100 / 64;
        this.mLength = r102;
        int r103 = r100 & 63;
        this.mBit = r103;
        if (r103 != 0) goto L7;
        this.mBit = 64;
    L8:
        computeType();
        if (this.mType >= 3) goto L17;
        this.mMult = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.mDegree, 2});
        int r104 = 0;
    L12:
        if (r104 >= this.mDegree) goto L14;
        int[] r105 = this.mMult[r104];
        r105[0] = -1;
        r105[1] = -1;
        r104 = r104 + 1;
        goto L12
    L14:
        computeMultMatrix();
        computeFieldPolynomial();
        this.fields = new java.util.Vector();
        this.matrices = new java.util.Vector();
        return;
    L17:
        throw new RuntimeException("\nThe type of this field is " + this.mType);
    L7:
        this.mLength = r102 + 1;
        goto L8
    L19:
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeMultMatrix() {
        int r100 = this.mType;
        if ((r100 & 7) == 0) goto L58;
        int r101 = (this.mDegree * r100) + 1;
        int[] r102 = new int[r101];
        if (r100 != 1) goto L7;
        int r103 = 1;
    L10:
        int r104 = 0;
        int r105 = 1;
    L11:
        int r106 = this.mType;
        if (r104 >= r106) goto L25;
        int r107 = r105;
        int r108 = 0;
    L15:
        if (r108 >= this.mDegree) goto L20;
        r102[r107] = r108;
        r107 = (r107 << 1) % r101;
        if (r107 >= 0) goto L19;
        r107 = r107 + r101;
    L19:
        r108 = r108 + 1;
        goto L15
    L20:
        r105 = (r105 * r103) % r101;
        if (r105 >= 0) goto L23;
        r105 = r105 + r101;
    L23:
        r104 = r104 + 1;
        goto L11
    L25:
        if (r106 != 1) goto L45;
        int r109 = 1;
    L28:
        if (r109 >= (r101 - 1)) goto L34;
        int r110 = r109 + 1;
        int[] r111 = this.mMult[r102[r110]];
        int r112 = r101 - r109;
        if (r111[0] != (-1)) goto L32;
        r111[0] = r102[r112];
    L33:
        r109 = r110;
        goto L28
    L32:
        r111[1] = r102[r112];
        goto L33
    L34:
        int r113 = this.mDegree >> 1;
        int r114 = 1;
    L35:
        if (r114 > r113) goto L54;
        int[][] r115 = this.mMult;
        int r116 = r114 - 1;
        int[] r117 = r115[r116];
        if (r117[0] != (-1)) goto L39;
        r117[0] = (r113 + r114) - 1;
    L40:
        int[] r118 = r115[(r113 + r114) - 1];
        if (r118[0] != (-1)) goto L43;
        r118[0] = r116;
    L44:
        r114 = r114 + 1;
        goto L35
    L43:
        r118[1] = r116;
        goto L44
    L39:
        r117[1] = (r113 + r114) - 1;
        goto L40
    L54:
        return;
    L45:
        if (r106 != 2) goto L56;
        int r119 = 1;
    L48:
        if (r119 >= (r101 - 1)) goto L74;
        int r120 = r119 + 1;
        int[] r121 = this.mMult[r102[r120]];
        int r122 = r101 - r119;
        if (r121[0] != (-1)) goto L52;
        r121[0] = r102[r122];
    L53:
        r119 = r120;
        goto L48
    L52:
        r121[1] = r102[r122];
        goto L53
    L74:
        return;
    L56:
        throw new RuntimeException("only type 1 or type 2 implemented");
    L7:
        if (r100 != 2) goto L9;
        r103 = r101 - 1;
        goto L10
    L9:
        r103 = elementOfOrder(r100, r101);
        goto L10
    L58:
        throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
    }

    private void computeType() throws RuntimeException {
        if ((this.mDegree & 7) == 0) goto L20;
        this.mType = 1;
        int r100 = 0;
    L6:
        if (r100 == 1) goto L11;
        int r101 = (this.mType * this.mDegree) + 1;
        if (IntegerFunctions.isPrime(r101) == false) goto L10;
        int r102 = IntegerFunctions.order(2, r101);
        int r103 = this.mType;
        int r104 = this.mDegree;
        r100 = IntegerFunctions.gcd((r103 * r104) / r102, r104);
    L10:
        this.mType++;
        goto L6
    L11:
        int r105 = this.mType - 1;
        this.mType = r105;
        if (r105 != 1) goto L24;
        int r106 = (this.mDegree << 1) + 1;
        if (IntegerFunctions.isPrime(r106) == false) goto L25;
        int r107 = IntegerFunctions.order(2, r106);
        int r108 = this.mDegree;
        if (IntegerFunctions.gcd((r108 << 1) / r107, r108) != 1) goto L26;
        this.mType++;
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L20:
        throw new RuntimeException("The extension degree is divisible by 8!");
    }

    private int elementOfOrder(int r100, int r101) {
        Random r102 = new Random();
        int r103 = 0;
    L3:
        if (r103 != 0) goto L7;
        int r104 = r101 - 1;
        r103 = r102.nextInt() % r104;
        if (r103 >= 0) goto L3;
        r103 = r103 + r104;
    L7:
        int r105 = IntegerFunctions.order(r103, r101);
        if ((r105 % r100) != 0) goto L15;
        if (r105 == 0) goto L15;
        int r106 = 2;
        int r107 = r103;
    L12:
        if (r106 > (r100 / r105)) goto L14;
        r107 = r107 * r103;
        r106 = r106 + 1;
        goto L12
    L14:
        return r107;
    L15:
        if (r103 != 0) goto L7;
        int r108 = r101 - 1;
        r103 = r102.nextInt() % r108;
        if (r103 >= 0) goto L15;
        r103 = r103 + r108;
        goto L15
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public void computeCOBMatrix(GF2nField r100) {
        int r101 = this.mDegree;
        if (r101 != r100.mDegree) goto L28;
        GF2Polynomial[] r102 = new GF2Polynomial[r101];
        int r103 = 0;
    L6:
        if (r103 >= this.mDegree) goto L8;
        r102[r103] = new GF2Polynomial(this.mDegree);
        r103 = r103 + 1;
    L8:
        GF2nElement r104 = r100.getRandomRoot(this.fieldPolynomial);
        if (r104.isZero() == true) goto L8;
        GF2nElement[] r105 = new GF2nPolynomialElement[this.mDegree];
        r105[0] = (GF2nElement) r104.clone();
        int r106 = 1;
    L12:
        if (r106 >= this.mDegree) goto L14;
        r105[r106] = r105[r106 - 1].square();
        r106 = r106 + 1;
        goto L12
    L14:
        int r107 = 0;
    L16:
        if (r107 >= this.mDegree) goto L25;
        int r108 = 0;
    L19:
        if (r108 >= this.mDegree) goto L24;
        if (r105[r107].testBit(r108) == false) goto L23;
        int r109 = this.mDegree;
        r102[(r109 - r108) - 1].setBit((r109 - r107) - 1);
    L23:
        r108 = r108 + 1;
        goto L19
    L24:
        r107 = r107 + 1;
        goto L16
    L25:
        this.fields.addElement(r100);
        this.matrices.addElement(r102);
        r100.fields.addElement(this);
        r100.matrices.addElement(invertMatrix(r102));
        return;
    L28:
        throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public void computeFieldPolynomial() {
        int r100 = this.mType;
        if (r100 != 1) goto L7;
        GF2Polynomial r101 = new GF2Polynomial(this.mDegree + 1, AccountType.ALL);
    L5:
        this.fieldPolynomial = r101;
        return;
    L7:
        if (r100 != 2) goto L14;
        GF2Polynomial r102 = new GF2Polynomial(this.mDegree + 1, "ONE");
        GF2Polynomial r103 = new GF2Polynomial(this.mDegree + 1, "X");
        r103.addToThis(r102);
        GF2Polynomial r104 = r102;
        r101 = r103;
        int r105 = 1;
    L10:
        if (r105 >= this.mDegree) goto L5;
        GF2Polynomial r106 = r101.shiftLeft();
        r106.addToThis(r104);
        r105 = r105 + 1;
        r104 = r101;
        r101 = r106;
        goto L10
    }

    public int getONBBit() {
        return this.mBit;
    }

    public int getONBLength() {
        return this.mLength;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nField
    public GF2nElement getRandomRoot(GF2Polynomial r100) {
        GF2nPolynomial r101 = new GF2nPolynomial(r100, this);
    L4:
        if (r101.getDegree() <= 1) goto L17;
    L5:
        GF2nONBElement r102 = new GF2nONBElement(this, this.random);
        GF2nPolynomial r103 = new GF2nPolynomial(2, GF2nONBElement.ZERO(this));
        r103.set(1, r102);
        GF2nPolynomial r104 = new GF2nPolynomial(r103);
        int r105 = 1;
    L7:
        if (r105 > (this.mDegree - 1)) goto L9;
        r104 = r104.multiplyAndReduce(r104, r101).add(r103);
        r105 = r105 + 1;
        goto L7
    L9:
        GF2nPolynomial r106 = r104.gcd(r101);
        int r107 = r106.getDegree();
        int r108 = r101.getDegree();
        if (r107 == 0) goto L5;
        if (r107 == r108) goto L5;
        if ((r107 << 1) > r108) goto L14;
        r101 = new GF2nPolynomial(r106);
        goto L4
    L14:
        r101 = r101.quotient(r106);
        goto L4
    L17:
        return r101.at(0);
    }

    public int[][] invMatrix(int[][] r100) {
        int r101 = this.mDegree;
        int[] r102 = {r101, r101};
        int r103 = 0;
        Class r104 = Integer.TYPE;
        int[][] r105 = (int[][]) Array.newInstance(r104, r102);
        int r106 = this.mDegree;
        int[][] r107 = (int[][]) Array.newInstance(r104, new int[]{r106, r106});
        int r108 = 0;
    L4:
        if (r108 >= this.mDegree) goto L7;
        r107[r108][r108] = 1;
        r108 = r108 + 1;
    L7:
        if (r103 >= this.mDegree) goto L13;
        int r109 = r103;
    L9:
        int r110 = this.mDegree;
        if (r109 >= r110) goto L12;
        r100[(r110 - 1) - r103][r109] = r100[r103][r103];
        r109 = r109 + 1;
        goto L9
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        return null;
    }
}
