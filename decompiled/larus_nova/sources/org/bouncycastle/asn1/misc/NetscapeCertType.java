package org.bouncycastle.asn1.misc;

import kotlin.UByte;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes42.dex */
public class NetscapeCertType extends DERBitString {
    public static final int objectSigning = 16;
    public static final int objectSigningCA = 1;
    public static final int reserved = 8;
    public static final int smime = 32;
    public static final int smimeCA = 2;
    public static final int sslCA = 4;
    public static final int sslClient = 128;
    public static final int sslServer = 64;

    public NetscapeCertType(int r100) {
        super(ASN1BitString.getBytes(r100), ASN1BitString.getPadBits(r100));
    }

    public NetscapeCertType(DERBitString r100) {
        super(r100.getBytes(), r100.getPadBits());
    }

    @Override // org.bouncycastle.asn1.ASN1BitString
    public String toString() {
        return "NetscapeCertType: 0x" + Integer.toHexString(this.data[0] & UByte.MAX_VALUE);
    }
}
