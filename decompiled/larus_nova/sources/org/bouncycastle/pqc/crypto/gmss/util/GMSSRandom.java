package org.bouncycastle.pqc.crypto.gmss.util;

import kotlin.UByte;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSRandom {
    private Digest messDigestTree;

    public GMSSRandom(Digest r100) {
        this.messDigestTree = r100;
    }

    private void addByteArrays(byte[] r100, byte[] r101) {
        int r102 = 0;
        byte r103 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        int r104 = ((r100[r102] & UByte.MAX_VALUE) + (r101[r102] & UByte.MAX_VALUE)) + r103;
        r100[r102] = (byte) r104;
        r103 = (byte) (r104 >> 8);
        r102 = r102 + 1;
        goto L4
    }

    private void addOne(byte[] r100) {
        byte r101 = 1;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        int r103 = (r100[r102] & UByte.MAX_VALUE) + r101;
        r100[r102] = (byte) r103;
        r101 = (byte) (r103 >> 8);
        r102 = r102 + 1;
        goto L4
    }

    public byte[] nextSeed(byte[] r100) {
        byte[] r101 = new byte[r100.length];
        this.messDigestTree.update(r100, 0, r100.length);
        byte[] r102 = new byte[this.messDigestTree.getDigestSize()];
        this.messDigestTree.doFinal(r102, 0);
        addByteArrays(r100, r102);
        addOne(r100);
        return r102;
    }
}
