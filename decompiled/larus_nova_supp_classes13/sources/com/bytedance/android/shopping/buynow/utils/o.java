package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r6, List r7, List r8, List r9, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "videos");
        Intrinsics.checkNotNullParameter(r8, "images");
        Intrinsics.checkNotNullParameter(r9, "titlesList");
        int r13 = com.bytedance.android.shopping.utils.gallery.k.a;
        com.bytedance.android.shopping.utils.gallery.k.a(r6, CollectionsKt.emptyList(), r8, r9, r10, false);
    }
}
