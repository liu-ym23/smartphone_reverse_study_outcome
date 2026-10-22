package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.PBEParametersGenerator;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12Key implements PBKDFKey {
    private final char[] password;
    private final boolean useWrongZeroLengthConversion;

    public PKCS12Key(char[] r100) {
        this(r100, false);
    }

    public PKCS12Key(char[] r100, boolean r101) {
        if (r100 != null) goto L5;
        r100 = new char[0];
    L5:
        char[] r102 = new char[r100.length];
        this.password = r102;
        this.useWrongZeroLengthConversion = r101;
        System.arraycopy(r100, 0, r102, 0, r100.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PKCS12";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.useWrongZeroLengthConversion == false) goto L9;
        if (this.password.length != 0) goto L9;
        return new byte[2];
    L9:
        return PBEParametersGenerator.PKCS12PasswordToBytes(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS12";
    }

    public char[] getPassword() {
        return this.password;
    }
}
