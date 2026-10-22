package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.NameConstraintValidatorException;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXNameConstraintValidator {
    org.bouncycastle.asn1.x509.PKIXNameConstraintValidator validator;

    public PKIXNameConstraintValidator() {
        this.validator = new org.bouncycastle.asn1.x509.PKIXNameConstraintValidator();
    }

    public void addExcludedSubtree(GeneralSubtree r100) {
        this.validator.addExcludedSubtree(r100);
    }

    public void checkExcluded(GeneralName r100) throws PKIXNameConstraintValidatorException {
        this.validator.checkExcluded(r100);     // Catch: NameConstraintValidatorException -> L4
        return;
    L4:
        e = move-exception;
        throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
    }

    public void checkExcludedDN(ASN1Sequence r100) throws PKIXNameConstraintValidatorException {
        this.validator.checkExcludedDN(X500Name.getInstance(r100));     // Catch: NameConstraintValidatorException -> L4
        return;
    L4:
        e = move-exception;
        throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
    }

    public void checkPermitted(GeneralName r100) throws PKIXNameConstraintValidatorException {
        this.validator.checkPermitted(r100);     // Catch: NameConstraintValidatorException -> L4
        return;
    L4:
        e = move-exception;
        throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
    }

    public void checkPermittedDN(ASN1Sequence r100) throws PKIXNameConstraintValidatorException {
        this.validator.checkPermittedDN(X500Name.getInstance(r100));     // Catch: NameConstraintValidatorException -> L4
        return;
    L4:
        e = move-exception;
        throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PKIXNameConstraintValidator) == true) goto L7;
        return false;
    L7:
        return this.validator.equals(((PKIXNameConstraintValidator) r100).validator);
    }

    public int hashCode() {
        return this.validator.hashCode();
    }

    public void intersectEmptyPermittedSubtree(int r100) {
        this.validator.intersectEmptyPermittedSubtree(r100);
    }

    public void intersectPermittedSubtree(GeneralSubtree r100) {
        this.validator.intersectPermittedSubtree(r100);
    }

    public void intersectPermittedSubtree(GeneralSubtree[] r100) {
        this.validator.intersectPermittedSubtree(r100);
    }

    public String toString() {
        return this.validator.toString();
    }
}
