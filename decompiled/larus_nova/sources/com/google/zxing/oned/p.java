package com.google.zxing.oned;

/* JADX INFO: loaded from: classes23.dex */
public abstract class p extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f275955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f275956b = null;

    static {
        int r100 = 10;
        int[][] r101 = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f275955a = r101;
        int[][] r102 = new int[20][];
        f275956b = r102;
        System.arraycopy(r101, 0, r102, 0, 10);
    L3:
        if (r100 >= 20) goto L9;
        int[] r103 = f275955a[r100 - 10];
        int[] r104 = new int[r103.length];
        int r105 = 0;
    L6:
        if (r105 >= r103.length) goto L8;
        r104[r105] = r103[(r103.length - r105) - 1];
        r105 = r105 + 1;
        goto L6
    L8:
        f275956b[r100] = r104;
        r100 = r100 + 1;
        goto L3
    }

    public p() {
        new o();
        new g();
    }
}
