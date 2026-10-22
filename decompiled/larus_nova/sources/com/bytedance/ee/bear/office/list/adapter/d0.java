package com.bytedance.ee.bear.office.list.adapter;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 {
    public static final String a(z r100) {
        if (Intrinsics.areEqual(r100, z.d.f235884a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r100, z.b.f235882a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r100 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r100 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r100).f235881b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
