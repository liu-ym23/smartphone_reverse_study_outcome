package com.bytedance.ee.bear.office.common.upload;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z {
    static {
    }

    public static void a(FragmentActivity r1, b r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "availability");
        if ((r2 instanceof b.d) == false) goto L5;
        b.d r3 = (b.d) r2;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        r3.a.getCallback().a(r1, r3.a);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
