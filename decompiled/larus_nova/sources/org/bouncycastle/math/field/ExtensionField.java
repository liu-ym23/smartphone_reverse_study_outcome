package org.bouncycastle.math.field;

/* JADX INFO: loaded from: classes42.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
