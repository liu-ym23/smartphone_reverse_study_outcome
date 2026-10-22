package org.bouncycastle.asn1.gnu;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface GNUObjectIdentifiers {
    public static final ASN1ObjectIdentifier CRC = null;
    public static final ASN1ObjectIdentifier CRC32 = null;
    public static final ASN1ObjectIdentifier Ed25519 = null;
    public static final ASN1ObjectIdentifier GNU = null;
    public static final ASN1ObjectIdentifier GnuPG = null;
    public static final ASN1ObjectIdentifier GnuRadar = null;
    public static final ASN1ObjectIdentifier Serpent = null;
    public static final ASN1ObjectIdentifier Serpent_128_CBC = null;
    public static final ASN1ObjectIdentifier Serpent_128_CFB = null;
    public static final ASN1ObjectIdentifier Serpent_128_ECB = null;
    public static final ASN1ObjectIdentifier Serpent_128_OFB = null;
    public static final ASN1ObjectIdentifier Serpent_192_CBC = null;
    public static final ASN1ObjectIdentifier Serpent_192_CFB = null;
    public static final ASN1ObjectIdentifier Serpent_192_ECB = null;
    public static final ASN1ObjectIdentifier Serpent_192_OFB = null;
    public static final ASN1ObjectIdentifier Serpent_256_CBC = null;
    public static final ASN1ObjectIdentifier Serpent_256_CFB = null;
    public static final ASN1ObjectIdentifier Serpent_256_ECB = null;
    public static final ASN1ObjectIdentifier Serpent_256_OFB = null;
    public static final ASN1ObjectIdentifier Tiger_192 = null;
    public static final ASN1ObjectIdentifier digestAlgorithm = null;
    public static final ASN1ObjectIdentifier ellipticCurve = null;
    public static final ASN1ObjectIdentifier encryptionAlgorithm = null;
    public static final ASN1ObjectIdentifier notation = null;
    public static final ASN1ObjectIdentifier pkaAddress = null;

    static {
        GNU = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.1");
        GnuPG = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2");
        notation = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1");
        pkaAddress = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1.1");
        GnuRadar = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.3");
        digestAlgorithm = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12");
        Tiger_192 = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12.2");
        encryptionAlgorithm = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13");
        Serpent = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2");
        Serpent_128_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.1");
        Serpent_128_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.2");
        Serpent_128_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.3");
        Serpent_128_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.4");
        Serpent_192_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.21");
        Serpent_192_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.22");
        Serpent_192_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.23");
        Serpent_192_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.24");
        Serpent_256_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.41");
        Serpent_256_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.42");
        Serpent_256_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.43");
        Serpent_256_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.44");
        CRC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14");
        CRC32 = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14.1");
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.15");
        ellipticCurve = r100;
        Ed25519 = r100.branch("1");
    }
}
