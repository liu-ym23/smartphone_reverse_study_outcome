package org.bouncycastle.asn1.eac;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateHolderReference {
    private static final String ReferenceEncoding = "ISO-8859-1";
    private String countryCode;
    private String holderMnemonic;
    private String sequenceNumber;

    public CertificateHolderReference(String r100, String r101, String r102) {
        this.countryCode = r100;
        this.holderMnemonic = r101;
        this.sequenceNumber = r102;
    }

    public CertificateHolderReference(byte[] r100) {
        String r101 = new String(r100, "ISO-8859-1");     // Catch: UnsupportedEncodingException -> L5
        this.countryCode = r101.substring(0, 2);     // Catch: UnsupportedEncodingException -> L5
        this.holderMnemonic = r101.substring(2, r101.length() - 5);     // Catch: UnsupportedEncodingException -> L5
        this.sequenceNumber = r101.substring(r101.length() - 5);     // Catch: UnsupportedEncodingException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e.toString());
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public byte[] getEncoded() {
        return (this.countryCode + this.holderMnemonic + this.sequenceNumber).getBytes("ISO-8859-1");
    L5:
        e = move-exception;
        throw new IllegalStateException(e.toString());
    }

    public String getHolderMnemonic() {
        return this.holderMnemonic;
    }

    public String getSequenceNumber() {
        return this.sequenceNumber;
    }
}
