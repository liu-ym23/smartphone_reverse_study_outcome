package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
class GenericPolynomialExtensionField implements PolynomialExtensionField {
    protected final Polynomial minimalPolynomial;
    protected final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField r100, Polynomial r101) {
        this.subfield = r100;
        this.minimalPolynomial = r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GenericPolynomialExtensionField) == true) goto L8;
        return false;
    L8:
        GenericPolynomialExtensionField r101 = (GenericPolynomialExtensionField) r100;
        if (this.subfield.equals(r101.subfield) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.minimalPolynomial.equals(r101.minimalPolynomial) == false) goto L13;
        return true;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    @Override // org.bouncycastle.math.field.ExtensionField
    public int getDegree() {
        return this.minimalPolynomial.getDegree();
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public int getDimension() {
        return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
    }

    @Override // org.bouncycastle.math.field.PolynomialExtensionField
    public Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    @Override // org.bouncycastle.math.field.ExtensionField
    public FiniteField getSubfield() {
        return this.subfield;
    }

    public int hashCode() {
        return this.subfield.hashCode() ^ Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16);
    }
}
