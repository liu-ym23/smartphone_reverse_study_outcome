package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSParameters {
    private int[] K;
    private int[] heightOfTrees;
    private int numOfLayers;
    private int[] winternitzParameter;

    public GMSSParameters(int r100) throws IllegalArgumentException {
        if (r100 > 10) goto L6;
        init(1, new int[]{10}, new int[]{3}, new int[]{2});
        return;
    L6:
        if (r100 > 20) goto L8;
        init(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2});
        return;
    L8:
        init(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2});
    }

    public GMSSParameters(int r100, int[] r101, int[] r102, int[] r103) throws IllegalArgumentException {
        init(r100, r101, r102, r103);
    }

    private void init(int r100, int[] r101, int[] r102, int[] r110) throws IllegalArgumentException {
        this.numOfLayers = r100;
        if (r100 == r102.length) goto L5;
    L10:
        String r103 = "Unexpected parameterset format";
        boolean r104 = false;
    L11:
        int r105 = 0;
    L13:
        if (r105 >= this.numOfLayers) goto L25;
        int r106 = r110[r105];
        if (r106 >= 2) goto L17;
    L18:
        r103 = "Wrong parameter K (K >= 2 and H-K even required)!";
        r104 = false;
    L20:
        if (r101[r105] >= 4) goto L22;
    L23:
        r103 = "Wrong parameter H or w (H > 3 and w > 1 required)!";
        r104 = false;
    L24:
        r105 = r105 + 1;
        goto L13
    L22:
        if (r102[r105] >= 2) goto L24;
    L17:
        if (((r101[r105] - r106) % 2) == 0) goto L20;
    L25:
        if (r104 == false) goto L29;
        this.heightOfTrees = Arrays.clone(r101);
        this.winternitzParameter = Arrays.clone(r102);
        this.K = Arrays.clone(r110);
        return;
    L29:
        throw new IllegalArgumentException(r103);
    L5:
        if (r100 != r101.length) goto L10;
        if (r100 != r110.length) goto L10;
        r104 = true;
        r103 = "";
        goto L11
    }

    public int[] getHeightOfTrees() {
        return Arrays.clone(this.heightOfTrees);
    }

    public int[] getK() {
        return Arrays.clone(this.K);
    }

    public int getNumOfLayers() {
        return this.numOfLayers;
    }

    public int[] getWinternitzParameter() {
        return Arrays.clone(this.winternitzParameter);
    }
}
