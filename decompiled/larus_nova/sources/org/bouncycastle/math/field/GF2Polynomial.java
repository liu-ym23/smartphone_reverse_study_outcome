package org.bouncycastle.math.field;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class GF2Polynomial implements Polynomial {
    protected final int[] exponents;

    public GF2Polynomial(int[] r100) {
        this.exponents = Arrays.clone(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GF2Polynomial) == true) goto L10;
        return false;
    L10:
        return Arrays.areEqual(this.exponents, ((GF2Polynomial) r100).exponents);
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public int getDegree() {
        int[] r100 = this.exponents;
        return r100[r100.length - 1];
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public int[] getExponentsPresent() {
        return Arrays.clone(this.exponents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.exponents);
    }
}
