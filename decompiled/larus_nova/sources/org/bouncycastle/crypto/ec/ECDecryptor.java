package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public interface ECDecryptor {
    ECPoint decrypt(ECPair r100);

    void init(CipherParameters r100);
}
