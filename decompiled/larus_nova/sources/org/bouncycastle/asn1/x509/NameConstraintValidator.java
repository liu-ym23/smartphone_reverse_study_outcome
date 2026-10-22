package org.bouncycastle.asn1.x509;

/* JADX INFO: loaded from: classes42.dex */
public interface NameConstraintValidator {
    void addExcludedSubtree(GeneralSubtree r100);

    void checkExcluded(GeneralName r100) throws NameConstraintValidatorException;

    void checkPermitted(GeneralName r100) throws NameConstraintValidatorException;

    void intersectEmptyPermittedSubtree(int r100);

    void intersectPermittedSubtree(GeneralSubtree r100);

    void intersectPermittedSubtree(GeneralSubtree[] r100);
}
