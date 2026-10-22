package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public abstract class PBKDFConfig {
    private final ASN1ObjectIdentifier algorithm;

    public PBKDFConfig(ASN1ObjectIdentifier r100) {
        this.algorithm = r100;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }
}
