package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;
    private final int height;
    private final byte[] value;

    public XMSSNode(int r100, byte[] r101) {
        this.height = r100;
        this.value = r101;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getValue() {
        return XMSSUtil.cloneArray(this.value);
    }
}
