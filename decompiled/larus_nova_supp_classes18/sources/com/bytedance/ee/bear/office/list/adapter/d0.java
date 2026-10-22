package com.bytedance.ee.bear.office.list.adapter;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 {
    public static final String a(z r2) {
        if (Intrinsics.areEqual(r2, z.d.a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r2, z.b.a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r2 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r2 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r2).b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
