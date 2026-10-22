package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e[] f234789e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        oj5.c r100 = d();
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getType();
        e[] r102 = this.f234789e;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        if (r101 == r102[r104].f541317b) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public b(e... r100) {
        Intrinsics.checkNotNullParameter(r100, "types");
        this.f234789e = r100;
    }
}
