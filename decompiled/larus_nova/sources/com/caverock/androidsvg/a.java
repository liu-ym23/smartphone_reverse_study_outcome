package com.caverock.androidsvg;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f272980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f272981b;

    public a(long r100, int r101) {
        this.f272981b = r100;
        this.f272980a = r101;
    }

    public static a a(String r100, int r101, int r102) {
        if (r101 < r102) goto L5;
        return null;
    L5:
        long r103 = 0;
        int r104 = r101;
    L6:
        if (r104 >= r102) goto L15;
        char r105 = r100.charAt(r104);
        if (r105 < '0') goto L15;
        if (r105 > '9') goto L15;
        r103 = (r103 * 10) + ((long) (r105 - '0'));
        if (r103 > SieveCacheKt.NodeLinkMask) goto L13;
        r104 = r104 + 1;
        goto L6
    L13:
        return null;
    L15:
        if (r104 != r101) goto L18;
        return null;
    L18:
        return new a(r103, r104);
    }
}
