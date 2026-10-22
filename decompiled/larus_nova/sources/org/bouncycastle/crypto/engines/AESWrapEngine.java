package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes42.dex */
public class AESWrapEngine extends RFC3394WrapEngine {
    public AESWrapEngine() {
        super(new AESEngine());
    }

    public AESWrapEngine(boolean r100) {
        super(new AESEngine(), r100);
    }
}
