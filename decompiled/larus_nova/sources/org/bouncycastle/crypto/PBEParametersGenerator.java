package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    public PBEParametersGenerator() {
    }

    public static byte[] PKCS12PasswordToBytes(char[] r100) {
        int r101 = 0;
        if (r100 == null) goto L12;
        if (r100.length <= 0) goto L12;
        byte[] r102 = new byte[(r100.length + 1) * 2];
    L8:
        if (r101 == r100.length) goto L10;
        int r103 = r101 * 2;
        char r104 = r100[r101];
        r102[r103] = (byte) (r104 >>> '\b');
        r102[r103 + 1] = (byte) r104;
        r101 = r101 + 1;
        goto L8
    L10:
        return r102;
    L12:
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToBytes(char[] r100) {
        int r101 = 0;
        if (r100 == null) goto L9;
        int r102 = r100.length;
        byte[] r103 = new byte[r102];
    L5:
        if (r101 == r102) goto L7;
        r103[r101] = (byte) r100[r101];
        r101 = r101 + 1;
        goto L5
    L7:
        return r103;
    L9:
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] r100) {
        if (r100 == null) goto L6;
        return Strings.toUTF8ByteArray(r100);
    L6:
        return new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int r100);

    public abstract CipherParameters generateDerivedParameters(int r100);

    public abstract CipherParameters generateDerivedParameters(int r100, int r101);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void init(byte[] r100, byte[] r101, int r102) {
        this.password = r100;
        this.salt = r101;
        this.iterationCount = r102;
    }
}
