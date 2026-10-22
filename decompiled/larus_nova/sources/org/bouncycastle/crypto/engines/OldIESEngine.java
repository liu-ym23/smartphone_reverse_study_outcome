package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class OldIESEngine extends IESEngine {
    public OldIESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102) {
        super(r100, r101, r102);
    }

    public OldIESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102, BufferedBlockCipher r103) {
        super(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.engines.IESEngine
    public byte[] getLengthTag(byte[] r100) {
        byte[] r101 = new byte[4];
        if (r100 == null) goto L5;
        Pack.intToBigEndian(r100.length * 8, r101, 0);
    L5:
        return r101;
    }
}
