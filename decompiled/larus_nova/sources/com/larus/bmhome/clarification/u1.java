package com.larus.bmhome.clarification;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u1 {
    public static final String b(h2 r100) {
        if (Intrinsics.areEqual(r100, h2.c.f310539a) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof h2.b) == false) goto L9;
        return ((h2.b) r100).f310538a;
    L9:
        if ((r100 instanceof h2.a) == false) goto L13;
        return ((h2.a) r100).f310537a;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final String c(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return "unknown";
    L15:
        if (r100.intValue() != 3) goto L17;
        return "free_text";
    L10:
        if (r100.intValue() != 2) goto L12;
        return "multi_select";
    L5:
        if (r100.intValue() != 1) goto L7;
        return "single_select";
    }

    public static final boolean a(d2 r100, d2 r101) {
        if (Intrinsics.areEqual(r100.f310495a, r101.f310495a) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f310496b, r101.f310496b) == false) goto L11;
        if (Intrinsics.areEqual(r100.f310497c, r101.f310497c) == false) goto L11;
        if (Intrinsics.areEqual(r100.f310498d, r101.f310498d) == false) goto L11;
        return true;
    }
}
