package org.bouncycastle.asn1.x509;

import kotlin.UByte;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;

/* JADX INFO: loaded from: classes42.dex */
public class KeyUsage extends ASN1Object {
    public static final int cRLSign = 2;
    public static final int dataEncipherment = 16;
    public static final int decipherOnly = 32768;
    public static final int digitalSignature = 128;
    public static final int encipherOnly = 1;
    public static final int keyAgreement = 8;
    public static final int keyCertSign = 4;
    public static final int keyEncipherment = 32;
    public static final int nonRepudiation = 64;
    private DERBitString bitString;

    public KeyUsage(int r100) {
        this.bitString = new DERBitString(r100);
    }

    private KeyUsage(DERBitString r100) {
        this.bitString = r100;
    }

    public static KeyUsage fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.keyUsage));
    }

    public static KeyUsage getInstance(Object r100) {
        if ((r100 instanceof KeyUsage) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeyUsage(DERBitString.getInstance(r100));
    L5:
        return (KeyUsage) r100;
    }

    public byte[] getBytes() {
        return this.bitString.getBytes();
    }

    public int getPadBits() {
        return this.bitString.getPadBits();
    }

    public boolean hasUsages(int r100) {
        if ((this.bitString.intValue() & r100) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.bitString;
    }

    public String toString() {
        byte[] r100 = this.bitString.getBytes();
        if (r100.length != 1) goto L7;
        StringBuilder r101 = new StringBuilder("KeyUsage: 0x");
        int r102 = r100[0] & UByte.MAX_VALUE;
    L5:
        r101.append(Integer.toHexString(r102));
        return r101.toString();
    L7:
        r101 = new StringBuilder("KeyUsage: 0x");
        int r103 = (r100[1] & UByte.MAX_VALUE) << 8;
        r102 = (r100[0] & UByte.MAX_VALUE) | r103;
        goto L5
    }
}
