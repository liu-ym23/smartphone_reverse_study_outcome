package org.bouncycastle.pqc.crypto.xmss;

/* JADX INFO: loaded from: classes42.dex */
final class WOTSPlusSignature {
    private byte[][] signature;

    public WOTSPlusSignature(WOTSPlusParameters r100, byte[][] r101) {
        if (r100 == null) goto L26;
        if (r101 == null) goto L24;
        if (XMSSUtil.hasNullPointer(r101) == true) goto L22;
        if (r101.length != r100.getLen()) goto L20;
        int r102 = 0;
    L11:
        if (r102 >= r101.length) goto L17;
        if (r101[r102].length != r100.getTreeDigestSize()) goto L16;
        r102 = r102 + 1;
        goto L11
    L16:
        throw new IllegalArgumentException("wrong signature format");
    L17:
        this.signature = XMSSUtil.cloneArray(r101);
        return;
    L20:
        throw new IllegalArgumentException("wrong signature size");
    L22:
        throw new NullPointerException("signature byte array == null");
    L24:
        throw new NullPointerException("signature == null");
    L26:
        throw new NullPointerException("params == null");
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.signature);
    }
}
