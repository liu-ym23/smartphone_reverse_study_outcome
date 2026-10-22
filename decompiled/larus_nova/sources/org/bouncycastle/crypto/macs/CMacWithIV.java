package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class CMacWithIV extends CMac {
    public CMacWithIV(BlockCipher r100) {
        super(r100);
    }

    public CMacWithIV(BlockCipher r100, int r101) {
        super(r100, r101);
    }

    @Override // org.bouncycastle.crypto.macs.CMac
    public void validate(CipherParameters r100) {
    }
}
