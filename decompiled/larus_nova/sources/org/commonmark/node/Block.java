package org.commonmark.node;

import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Block extends b {
    @Override // uvc.b
    public final b c() {
        return (Block) this.f551900a;
    }

    public Block() {
    }

    @Override // uvc.b
    public final void e(b r100) {
        if ((r100 instanceof Block) == false) goto L7;
        this.f551900a = r100;
        return;
    L7:
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
