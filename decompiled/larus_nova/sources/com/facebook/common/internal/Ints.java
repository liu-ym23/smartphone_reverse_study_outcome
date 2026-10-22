package com.facebook.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public class Ints {
    private Ints() {
    }

    public static int max(int... r100) {
        int r101 = 1;
        if (r100.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        int r103 = r100[0];
    L8:
        if (r101 >= r100.length) goto L13;
        int r104 = r100[r101];
        if (r104 <= r103) goto L12;
        r103 = r104;
    L12:
        r101 = r101 + 1;
        goto L8
    L13:
        return r103;
    L5:
        r102 = false;
        goto L6
    }
}
