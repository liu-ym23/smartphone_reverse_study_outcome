package org.bouncycastle.math.field;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
class PrimeField implements FiniteField {
    protected final BigInteger characteristic;

    public PrimeField(BigInteger r100) {
        this.characteristic = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrimeField) == true) goto L10;
        return false;
    L10:
        return this.characteristic.equals(((PrimeField) r100).characteristic);
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.characteristic;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.characteristic.hashCode();
    }
}
