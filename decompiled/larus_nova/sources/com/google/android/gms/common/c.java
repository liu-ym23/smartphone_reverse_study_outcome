package com.google.android.gms.common;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static int a(int r100) {
        int[] r101 = {1, 2, 3};
        int r102 = 0;
    L3:
        if (r102 >= 3) goto L11;
        int r103 = r101[r102];
        int r104 = r103 - 1;
        if (r103 == 0) goto L10;
        if (r104 == r100) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return r103;
    L10:
        throw null;
    L11:
        return 1;
    }
}
