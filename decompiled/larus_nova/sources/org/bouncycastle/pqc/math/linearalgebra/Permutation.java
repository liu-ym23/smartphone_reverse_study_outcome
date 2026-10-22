package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Permutation {
    private int[] perm;

    public Permutation(int r100) {
        if (r100 <= 0) goto L9;
        this.perm = new int[r100];
        int r101 = r100 - 1;
    L5:
        if (r101 < 0) goto L7;
        this.perm[r101] = r101;
        r101 = r101 - 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(int r100, SecureRandom r101) {
        if (r100 <= 0) goto L12;
        this.perm = new int[r100];
        int[] r102 = new int[r100];
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r104 >= r100) goto L7;
        r102[r104] = r104;
        r104 = r104 + 1;
        goto L5
    L7:
        int r105 = r100;
    L8:
        if (r103 >= r100) goto L10;
        int r106 = RandUtils.nextInt(r101, r105);
        r105 = r105 - 1;
        this.perm[r103] = r102[r106];
        r102[r106] = r102[r105];
        r103 = r103 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(byte[] r100) {
        if (r100.length <= 4) goto L17;
        int r101 = 0;
        int r102 = LittleEndianConversions.OS2IP(r100, 0);
        int r103 = IntegerFunctions.ceilLog256(r102 - 1);
        if (r100.length != ((r102 * r103) + 4)) goto L15;
        this.perm = new int[r102];
    L7:
        if (r101 >= r102) goto L10;
        this.perm[r101] = LittleEndianConversions.OS2IP(r100, (r101 * r103) + 4, r103);
        r101 = r101 + 1;
        goto L7
    L10:
        if (isPermutation(this.perm) == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("invalid encoding");
    L15:
        throw new IllegalArgumentException("invalid encoding");
    L17:
        throw new IllegalArgumentException("invalid encoding");
    }

    public Permutation(int[] r100) {
        if (isPermutation(r100) == false) goto L7;
        this.perm = IntUtils.clone(r100);
        return;
    L7:
        throw new IllegalArgumentException("array is not a permutation vector");
    }

    private boolean isPermutation(int[] r100) {
        int r101 = r100.length;
        boolean[] r102 = new boolean[r101];
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L13;
        int r104 = r100[r103];
        if (r104 < 0) goto L12;
        if (r104 >= r101) goto L12;
        if (r102[r104] == true) goto L12;
        r102[r104] = true;
        r103 = r103 + 1;
    L12:
        return false;
    L13:
        return true;
    }

    public Permutation computeInverse() {
        Permutation r100 = new Permutation(this.perm.length);
        int r101 = this.perm.length - 1;
    L3:
        if (r101 < 0) goto L5;
        r100.perm[this.perm[r101]] = r101;
        r101 = r101 - 1;
        goto L3
    L5:
        return r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Permutation) == true) goto L7;
        return false;
    L7:
        return IntUtils.equals(this.perm, ((Permutation) r100).perm);
    }

    public byte[] getEncoded() {
        int r100 = this.perm.length;
        int r101 = IntegerFunctions.ceilLog256(r100 - 1);
        byte[] r102 = new byte[(r100 * r101) + 4];
        int r103 = 0;
        LittleEndianConversions.I2OSP(r100, r102, 0);
    L3:
        if (r103 >= r100) goto L5;
        LittleEndianConversions.I2OSP(this.perm[r103], r102, (r103 * r101) + 4, r101);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public int[] getVector() {
        return IntUtils.clone(this.perm);
    }

    public int hashCode() {
        return Arrays.hashCode(this.perm);
    }

    public Permutation rightMultiply(Permutation r100) {
        int r101 = r100.perm.length;
        int[] r102 = this.perm;
        if (r101 != r102.length) goto L9;
        Permutation r103 = new Permutation(r102.length);
        int r104 = this.perm.length - 1;
    L5:
        if (r104 < 0) goto L7;
        r103.perm[r104] = this.perm[r100.perm[r104]];
        r104 = r104 - 1;
        goto L5
    L7:
        return r103;
    L9:
        throw new IllegalArgumentException("length mismatch");
    }

    public String toString() {
        String r100 = "[" + this.perm[0];
        int r101 = 1;
    L4:
        if (r101 >= this.perm.length) goto L7;
        r100 = r100 + ", " + this.perm[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return r100 + "]";
    }
}
