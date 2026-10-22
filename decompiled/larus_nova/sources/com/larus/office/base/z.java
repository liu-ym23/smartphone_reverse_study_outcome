package com.larus.office.base;

import kotlin.Lazy;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
public final class z implements itb.d {
    public z() {
    }

    @Override // itb.d
    public final int H1(int r100, boolean r101, Integer r102) {
        if (r101 == false) goto L4;
        return r100;
    L4:
        Lazy r103 = we8.e.f559400a;
        int r104 = c7.b(Integer.valueOf(we8.e.b(we8.e.f559403d)));
        if (r102 == null) goto L9;
        int r105 = r100 + r104;
        return Math.max(r105, r102.intValue());
    L9:
        return r100 + r104;
    }

    @Override // itb.d
    public final float v0(float r100, boolean r101, Float r102) {
        if (r101 == false) goto L4;
        return r100;
    L4:
        Lazy r103 = we8.e.f559400a;
        int r104 = we8.e.b(we8.e.f559403d);
        if (r102 != null) goto L8;
        return r100 + r104;
    L8:
        return Math.max(r100 + r104, r102.floatValue());
    }
}
