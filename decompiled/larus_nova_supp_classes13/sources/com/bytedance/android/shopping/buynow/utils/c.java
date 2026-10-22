package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.shopping.buynow.data.model.PageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pageType");
        if (r1.equals(PageType.CONTINUEPAY) == false) goto L5;
        return "a1.b25587.c0.d0";
    L5:
        return "a1.b7411.c0.d0";
    }
}
