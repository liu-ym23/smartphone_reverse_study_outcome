package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PKCS12KeyWithParameters(char[] r100, boolean r101, byte[] r102, int r103) {
        super(r100, r101);
        this.salt = Arrays.clone(r102);
        this.iterationCount = r103;
    }

    public PKCS12KeyWithParameters(char[] r100, byte[] r101, int r102) {
        super(r100);
        this.salt = Arrays.clone(r101);
        this.iterationCount = r102;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.salt;
    }
}
