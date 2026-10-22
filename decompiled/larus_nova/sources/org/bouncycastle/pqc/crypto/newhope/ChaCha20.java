package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
class ChaCha20 {
    public ChaCha20() {
    }

    public static void process(byte[] r100, byte[] r101, byte[] r102, int r103, int r110) {
        ChaChaEngine r104 = new ChaChaEngine(20);
        r104.init(true, new ParametersWithIV(new KeyParameter(r100), r101));
        r104.processBytes(r102, r103, r110, r102, r103);
    }
}
