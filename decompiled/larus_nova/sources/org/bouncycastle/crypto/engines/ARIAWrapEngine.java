package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes42.dex */
public class ARIAWrapEngine extends RFC3394WrapEngine {
    public ARIAWrapEngine() {
        super(new ARIAEngine());
    }

    public ARIAWrapEngine(boolean r100) {
        super(new ARIAEngine(), r100);
    }
}
