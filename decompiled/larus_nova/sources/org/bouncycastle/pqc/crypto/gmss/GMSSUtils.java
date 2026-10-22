package org.bouncycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class GMSSUtils {
    public GMSSUtils() {
    }

    public static Vector[] clone(Vector[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Vector[] r101 = new Vector[r100.length];
        int r102 = 0;
    L7:
        if (r102 == r100.length) goto L13;
        r101[r102] = new Vector();
        Enumeration r103 = r100[r102].elements();
    L10:
        if (r103.hasMoreElements() == false) goto L12;
        r101[r102].addElement(r103.nextElement());
        goto L10
    L12:
        r102 = r102 + 1;
        goto L7
    L13:
        return r101;
    }

    public static GMSSLeaf[] clone(GMSSLeaf[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        GMSSLeaf[] r101 = new GMSSLeaf[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static GMSSRootCalc[] clone(GMSSRootCalc[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        GMSSRootCalc[] r101 = new GMSSRootCalc[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static GMSSRootSig[] clone(GMSSRootSig[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        GMSSRootSig[] r101 = new GMSSRootSig[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static Treehash[] clone(Treehash[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Treehash[] r101 = new Treehash[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static byte[][] clone(byte[][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[][] r101 = new byte[r100.length][];
        int r102 = 0;
    L7:
        if (r102 == r100.length) goto L9;
        r101[r102] = Arrays.clone(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static Vector[][] clone(Vector[][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Vector[][] r101 = new Vector[r100.length][];
        int r102 = 0;
    L7:
        if (r102 == r100.length) goto L9;
        r101[r102] = clone(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static Treehash[][] clone(Treehash[][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Treehash[][] r101 = new Treehash[r100.length][];
        int r102 = 0;
    L7:
        if (r102 == r100.length) goto L9;
        r101[r102] = clone(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static byte[][][] clone(byte[][][] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[][][] r101 = new byte[r100.length][][];
        int r102 = 0;
    L7:
        if (r102 == r100.length) goto L9;
        r101[r102] = clone(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }
}
