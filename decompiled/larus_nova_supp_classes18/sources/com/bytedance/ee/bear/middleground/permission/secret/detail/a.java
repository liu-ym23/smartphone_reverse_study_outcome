package com.bytedance.ee.bear.middleground.permission.secret.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final boolean c;

    public a() {
        this(null, false, false, 7);
    }

    public a(String r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
