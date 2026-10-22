package com.bytedance.ee.bear.middleground.permission.secret.detail;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public final boolean a;
    public final List<a> b;
    public int c;

    public j() {
        this(false, 7);
    }

    public j(boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        ArrayList r5 = new ArrayList();
    L9:
        Intrinsics.checkNotNullParameter(r5, "children");
        this.a = r3;
        this.b = r5;
        this.c = 0;
        return;
    L8:
        r5 = null;
        goto L9
    }
}
