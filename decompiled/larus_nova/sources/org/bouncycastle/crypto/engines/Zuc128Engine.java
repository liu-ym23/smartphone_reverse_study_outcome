package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public final class Zuc128Engine extends Zuc128CoreEngine {
    public Zuc128Engine() {
    }

    private Zuc128Engine(Zuc128Engine r100) {
        super(r100);
    }

    @Override // org.bouncycastle.crypto.engines.Zuc128CoreEngine, org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new Zuc128Engine(this);
    }
}
