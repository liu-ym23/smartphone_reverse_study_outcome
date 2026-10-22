package com.larus.sheet.sdk.impl;

import ew4.e0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class h implements e0 {
    public h() {
    }

    @Override // ew4.e0
    public final int s() {
        pw9.c r100 = sw9.g.f543730a;
        if (sw9.g.f543733d == false) goto L6;
        return sw9.g.f543732c;
    L6:
        return RangesKt.coerceAtLeast(sw9.g.a().b(), 0);
    }

    @Override // ew4.e0
    public final void j(ew4.a r100) {
        pw9.c r101 = sw9.g.f543730a;
        sw9.g.f543731b = r100;
        if (r100 != null) goto L5;
    L9:
        if (r100 == null) goto L12;
        r100.b(sw9.g.f543734e);
        return;
    L12:
        return;
    L5:
        if (sw9.g.f543733d == false) goto L7;
        int r102 = sw9.g.f543732c;
    L8:
        r100.a(r102);
        goto L9
    L7:
        r102 = RangesKt.coerceAtLeast(sw9.g.a().b(), 0);
        goto L8
    }
}
