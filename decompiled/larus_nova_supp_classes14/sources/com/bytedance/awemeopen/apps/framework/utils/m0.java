package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0 {
    public static long a;
    public static String b;

    static {
    }

    public static void a(Context r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = r7.getString(r8);
        long r0 = System.currentTimeMillis();
        if (Intrinsics.areEqual(r9, b) == true) goto L5;
    L7:
        new zx3.a(r7, r9).d();
        b = r9;
        a = r0;
        return;
    L5:
        if ((r0 - a) > ECDraweeView.ROUND) goto L7;
    }
}
