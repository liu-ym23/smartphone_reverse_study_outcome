package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f387735a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387736a = null;

        static {
            int[] r100 = new int[Vote.values().length];
            r100[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f387736a = r100;
        }
    }

    static {
        f387735a = CollectionsKt.listOf(new Integer[]{0, 1, 5, 10, 20});
    }

    public static final String a(l5 r100, Vote r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 == (-1)) goto L16;
        if (r102 == 1) goto L18;
        if (r102 != 2) goto L13;
        return r100.f387368k;
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return r100.f387367j;
    L16:
        return r100.f387366i;
    L5:
        r102 = a.f387736a[r101.ordinal()];
        goto L6
    }
}
