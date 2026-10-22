package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes42.dex */
public class ComputeInField {
    private short[][] A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    short[] f525591x;

    public ComputeInField() {
    }

    private void computeZerosAbove() throws RuntimeException {
        int r100 = this.A.length - 1;
    L3:
        if (r100 <= 0) goto L16;
        int r101 = r100 - 1;
    L5:
        if (r101 < 0) goto L15;
        short[][] r102 = this.A;
        short r103 = r102[r101][r100];
        short r104 = GF2Field.invElem(r102[r100][r100]);
        if (r104 == 0) goto L14;
        int r105 = r100;
    L9:
        short[][] r106 = this.A;
        if (r105 >= (r106.length * 2)) goto L12;
        short r107 = GF2Field.multElem(r103, GF2Field.multElem(r106[r100][r105], r104));
        short[] r108 = this.A[r101];
        r108[r105] = GF2Field.addElem(r108[r105], r107);
        r105 = r105 + 1;
        goto L9
    L12:
        r101 = r101 - 1;
        goto L5
    L14:
        throw new RuntimeException("The matrix is not invertible");
    L15:
        r100 = r100 - 1;
        goto L3
    }

    private void computeZerosUnder(boolean r110) throws RuntimeException {
        if (r110 == false) goto L4;
        int r111 = this.A.length * 2;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= (this.A.length - 1)) goto L20;
        int r101 = r100 + 1;
        int r102 = r101;
    L9:
        short[][] r103 = this.A;
        if (r102 >= r103.length) goto L19;
        short r104 = r103[r102][r100];
        short r105 = GF2Field.invElem(r103[r100][r100]);
        if (r105 == 0) goto L18;
        int r106 = r100;
    L14:
        if (r106 >= r111) goto L16;
        short r107 = GF2Field.multElem(r104, GF2Field.multElem(this.A[r100][r106], r105));
        short[] r108 = this.A[r102];
        r108[r106] = GF2Field.addElem(r108[r106], r107);
        r106 = r106 + 1;
        goto L14
    L16:
        r102 = r102 + 1;
        goto L9
    L18:
        throw new IllegalStateException("Matrix not invertible! We have to choose another one!");
    L19:
        r100 = r101;
        goto L7
    L20:
        return;
    L4:
        r111 = this.A.length + 1;
        goto L5
    }

    private void substitute() throws IllegalStateException {
        short[][] r100 = this.A;
        short r101 = GF2Field.invElem(r100[r100.length - 1][r100.length - 1]);
        if (r101 == 0) goto L16;
        short[] r102 = this.f525591x;
        short[][] r103 = this.A;
        r102[r103.length - 1] = GF2Field.multElem(r103[r103.length - 1][r103.length], r101);
        int r104 = this.A.length - 2;
    L5:
        if (r104 < 0) goto L14;
        short[][] r105 = this.A;
        short r106 = r105[r104][r105.length];
        int r107 = r105.length - 1;
    L7:
        if (r107 <= r104) goto L9;
        r106 = GF2Field.addElem(r106, GF2Field.multElem(this.A[r104][r107], this.f525591x[r107]));
        r107 = r107 - 1;
        goto L7
    L9:
        short r108 = GF2Field.invElem(this.A[r104][r104]);
        if (r108 == 0) goto L13;
        this.f525591x[r104] = GF2Field.multElem(r106, r108);
        r104 = r104 - 1;
        goto L5
    L13:
        throw new IllegalStateException("Not solvable equation system");
    L14:
        return;
    L16:
        throw new IllegalStateException("The equation system is not solvable");
    }

    public short[][] addSquareMatrix(short[][] r100, short[][] r101) {
        if (r100.length != r101.length) goto L16;
        if (r100[0].length != r101[0].length) goto L16;
        short[][] r102 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r100.length});
        int r103 = 0;
    L8:
        if (r103 >= r100.length) goto L14;
        int r104 = 0;
    L11:
        if (r104 >= r101.length) goto L13;
        r102[r103][r104] = GF2Field.addElem(r100[r103][r104], r101[r103][r104]);
        r104 = r104 + 1;
        goto L11
    L13:
        r103 = r103 + 1;
        goto L8
    L14:
        return r102;
    L16:
        throw new RuntimeException("Addition is not possible!");
    }

    public short[] addVect(short[] r100, short[] r101) {
        if (r100.length != r101.length) goto L9;
        int r102 = r100.length;
        short[] r103 = new short[r102];
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L7;
        r103[r104] = GF2Field.addElem(r100[r104], r101[r104]);
        r104 = r104 + 1;
        goto L5
    L7:
        return r103;
    L9:
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[][] inverse(short[][] r100) {
        int r101 = 0;
        this.A = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r100.length * 2});     // Catch: RuntimeException -> L35
        if (r100.length != r100[0].length) goto L34;
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L16;
        int r103 = 0;
    L9:
        if (r103 >= r100.length) goto L11;
        this.A[r102][r103] = r100[r102][r103];     // Catch: RuntimeException -> L35
        r103 = r103 + 1;     // Catch: RuntimeException -> L35
        goto L9
    L11:
        int r104 = r100.length;     // Catch: RuntimeException -> L35
    L13:
        if (r104 >= (r100.length * 2)) goto L15;
        this.A[r102][r104] = 0;     // Catch: RuntimeException -> L35
        r104 = r104 + 1;     // Catch: RuntimeException -> L35
        goto L13
    L15:
        short[][] r105 = this.A;     // Catch: RuntimeException -> L35
        r105[r102][r105.length + r102] = 1;     // Catch: RuntimeException -> L35
        r102 = r102 + 1;     // Catch: RuntimeException -> L35
        goto L6
    L16:
        computeZerosUnder(true);     // Catch: RuntimeException -> L35
        int r106 = 0;
    L17:
        short[][] r107 = this.A;     // Catch: RuntimeException -> L35
        if (r106 >= r107.length) goto L24;
        short r108 = GF2Field.invElem(r107[r106][r106]);     // Catch: RuntimeException -> L35
        int r109 = r106;
    L20:
        short[][] r110 = this.A;     // Catch: RuntimeException -> L35
        if (r109 >= (r110.length * 2)) goto L23;
        short[] r111 = r110[r106];     // Catch: RuntimeException -> L35
        r111[r109] = GF2Field.multElem(r111[r109], r108);     // Catch: RuntimeException -> L35
        r109 = r109 + 1;     // Catch: RuntimeException -> L35
        goto L20
    L23:
        r106 = r106 + 1;     // Catch: RuntimeException -> L35
        goto L17
    L24:
        computeZerosAbove();     // Catch: RuntimeException -> L35
        short[][] r112 = this.A;     // Catch: RuntimeException -> L35
        short[][] r113 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r112.length, r112.length});     // Catch: RuntimeException -> L35
    L25:
        short[][] r114 = this.A;     // Catch: RuntimeException -> L35
        if (r101 >= r114.length) goto L32;
        int r115 = r114.length;     // Catch: RuntimeException -> L35
    L28:
        short[][] r116 = this.A;     // Catch: RuntimeException -> L35
        if (r115 >= (r116.length * 2)) goto L31;
        r113[r101][r115 - r116.length] = r116[r101][r115];     // Catch: RuntimeException -> L35
        r115 = r115 + 1;     // Catch: RuntimeException -> L35
        goto L28
    L31:
        r101 = r101 + 1;     // Catch: RuntimeException -> L35
        goto L25
    L32:
        return r113;
    L34:
        throw new RuntimeException("The matrix is not invertible. Please choose another one!");     // Catch: RuntimeException -> L35
    L35:
        return null;
    }

    public short[][] multMatrix(short r100, short[][] r101) {
        short[][] r102 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r101.length, r101[0].length});
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L10;
        int r104 = 0;
    L7:
        if (r104 >= r101[0].length) goto L9;
        r102[r103][r104] = GF2Field.multElem(r100, r101[r103][r104]);
        r104 = r104 + 1;
        goto L7
    L9:
        r103 = r103 + 1;
        goto L4
    L10:
        return r102;
    }

    public short[] multVect(short r100, short[] r101) {
        int r102 = r101.length;
        short[] r103 = new short[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = GF2Field.multElem(r100, r101[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public short[][] multVects(short[] r100, short[] r101) {
        if (r100.length != r101.length) goto L14;
        short[][] r102 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r101.length});
        int r103 = 0;
    L6:
        if (r103 >= r100.length) goto L12;
        int r104 = 0;
    L9:
        if (r104 >= r101.length) goto L11;
        r102[r103][r104] = GF2Field.multElem(r100[r103], r101[r104]);
        r104 = r104 + 1;
        goto L9
    L11:
        r103 = r103 + 1;
        goto L6
    L12:
        return r102;
    L14:
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[] multiplyMatrix(short[][] r100, short[] r101) throws RuntimeException {
        if (r100[0].length != r101.length) goto L14;
        short[] r102 = new short[r100.length];
        int r103 = 0;
    L6:
        if (r103 >= r100.length) goto L12;
        int r104 = 0;
    L9:
        if (r104 >= r101.length) goto L11;
        short r105 = GF2Field.multElem(r100[r103][r104], r101[r104]);
        r102[r103] = GF2Field.addElem(r102[r103], r105);
        r104 = r104 + 1;
        goto L9
    L11:
        r103 = r103 + 1;
        goto L6
    L12:
        return r102;
    L14:
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[][] multiplyMatrix(short[][] r100, short[][] r101) throws RuntimeException {
        if (r100[0].length != r101.length) goto L19;
        this.A = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r101[0].length});
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L17;
        int r103 = 0;
    L9:
        if (r103 >= r101.length) goto L15;
        int r104 = 0;
    L12:
        if (r104 >= r101[0].length) goto L14;
        short r105 = GF2Field.multElem(r100[r102][r103], r101[r103][r104]);
        short[] r106 = this.A[r102];
        r106[r104] = GF2Field.addElem(r106[r104], r105);
        r104 = r104 + 1;
        goto L12
    L14:
        r103 = r103 + 1;
        goto L9
    L15:
        r102 = r102 + 1;
        goto L6
    L17:
        return this.A;
    L19:
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[] solveEquation(short[][] r100, short[] r101) {
        if (r100.length == r101.length) goto L20;
        return null;
    L20:
        this.A = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r100.length + 1});     // Catch: RuntimeException -> L19
        this.f525591x = new short[r100.length];     // Catch: RuntimeException -> L19
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L13;
        int r103 = 0;
    L10:
        if (r103 >= r100[0].length) goto L12;
        this.A[r102][r103] = r100[r102][r103];     // Catch: RuntimeException -> L19
        r103 = r103 + 1;     // Catch: RuntimeException -> L19
        goto L10
    L12:
        r102 = r102 + 1;     // Catch: RuntimeException -> L19
        goto L7
    L13:
        int r104 = 0;
    L15:
        if (r104 >= r101.length) goto L17;
        short[] r105 = this.A[r104];     // Catch: RuntimeException -> L19
        r105[r101.length] = GF2Field.addElem(r101[r104], r105[r101.length]);     // Catch: RuntimeException -> L19
        r104 = r104 + 1;     // Catch: RuntimeException -> L19
        goto L15
    L17:
        computeZerosUnder(false);     // Catch: RuntimeException -> L19
        substitute();     // Catch: RuntimeException -> L19
        return this.f525591x;
    L19:
        return null;
    }
}
