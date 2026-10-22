package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public interface ECPairTransform {
    void init(CipherParameters r100);

    ECPair transform(ECPair r100);
}
