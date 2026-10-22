package com.larus.gallery.api;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f343841a = null;

        static {
            int[] r100 = new int[DisplayGravity.values().length];
            r100[DisplayGravity.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DisplayGravity.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f343841a = r100;
        }
    }

    public static final int a(DisplayGravity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f343841a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 17;
    L5:
        if (r101 != 2) goto L8;
        return 8388659;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
