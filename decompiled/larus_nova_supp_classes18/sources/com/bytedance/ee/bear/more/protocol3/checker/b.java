package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends j {
    public final e[] e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        oj5.c r0 = d();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r1 = r0.getType();
        e[] r2 = this.e;
        int r3 = r2.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L12;
        if (r1 == r2[r4].b) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public b(e... r2) {
        Intrinsics.checkNotNullParameter(r2, "types");
        this.e = r2;
    }
}
