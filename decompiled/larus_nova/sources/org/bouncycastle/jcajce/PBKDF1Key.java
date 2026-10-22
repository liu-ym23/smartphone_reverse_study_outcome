package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.CharToByteConverter;

/* JADX INFO: loaded from: classes42.dex */
public class PBKDF1Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF1Key(char[] r100, CharToByteConverter r101) {
        char[] r102 = new char[r100.length];
        this.password = r102;
        this.converter = r101;
        System.arraycopy(r100, 0, r102, 0, r100.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF1";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.converter.convert(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.converter.getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
