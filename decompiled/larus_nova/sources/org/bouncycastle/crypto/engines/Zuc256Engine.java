package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public final class Zuc256Engine extends Zuc256CoreEngine {
    public Zuc256Engine() {
    }

    public Zuc256Engine(int r100) {
        super(r100);
    }

    private Zuc256Engine(Zuc256Engine r100) {
        super(r100);
    }

    @Override // org.bouncycastle.crypto.engines.Zuc256CoreEngine, org.bouncycastle.crypto.engines.Zuc128CoreEngine, org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new Zuc256Engine(this);
    }
}
