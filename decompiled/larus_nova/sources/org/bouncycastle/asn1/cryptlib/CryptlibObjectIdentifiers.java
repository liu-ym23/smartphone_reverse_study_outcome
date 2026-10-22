package org.bouncycastle.asn1.cryptlib;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CryptlibObjectIdentifiers {
    public static final ASN1ObjectIdentifier cryptlib = null;
    public static final ASN1ObjectIdentifier curvey25519 = null;

    /* JADX INFO: renamed from: ecc, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525033ecc = null;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        cryptlib = r100;
        ASN1ObjectIdentifier r101 = r100.branch("1").branch("5");
        f525033ecc = r101;
        curvey25519 = r101.branch("1");
    }

    public CryptlibObjectIdentifiers() {
    }
}
