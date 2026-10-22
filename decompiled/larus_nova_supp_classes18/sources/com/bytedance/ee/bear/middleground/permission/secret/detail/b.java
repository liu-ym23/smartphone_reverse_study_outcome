package com.bytedance.ee.bear.middleground.permission.secret.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final int a;
    public final boolean b;
    public final String c;
    public int d;

    public b() {
        this(0, false, null, 15);
    }

    public b(int r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = "";
    L11:
        Intrinsics.checkNotNullParameter(r5, "title");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = 0;
    }
}
