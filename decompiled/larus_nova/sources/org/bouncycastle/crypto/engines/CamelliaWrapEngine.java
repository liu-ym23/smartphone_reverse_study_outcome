package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes42.dex */
public class CamelliaWrapEngine extends RFC3394WrapEngine {
    public CamelliaWrapEngine() {
        super(new CamelliaEngine());
    }
}
