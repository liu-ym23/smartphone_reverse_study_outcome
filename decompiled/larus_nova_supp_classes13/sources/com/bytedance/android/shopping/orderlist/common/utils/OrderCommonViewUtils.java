package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonViewUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.android.shopping.orderlist.common.widgets.task.b a(final String r1, final String r2, final Function0 r3) {
        return com.bytedance.android.shopping.orderlist.common.widgets.task.c.a(r2, new OrderCommonViewUtils$getInflateTask$1(r3, r1, r2));
    }

    public static void b(InflaterPriority r7, String r8, final Context r9, final int r10, final ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r7, "priority");
        Intrinsics.checkNotNullParameter(r8, "tag");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "root");
        int r12 = p.a[r7.ordinal()];
        if (r12 == 1) goto L9;
        if (r12 == 2) goto L8;
        if (r12 != 3) goto L13;
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r8, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$7(r9, r10, r11)), a(r8, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$8(r9, r10, r11)), a(r8, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$9(r9, r10, r11))}));
        return;
    L13:
        return;
    L8:
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r8, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$4(r9, r10, r11)), a(r8, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$5(r9, r10, r11)), a(r8, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$6(r9, r10, r11))}));
        return;
    L9:
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{a(r8, "OriginInflater", new OrderCommonViewUtils$safeInflateWithDegrade$1(r9, r10, r11)), a(r8, "AsyncInflater", new OrderCommonViewUtils$safeInflateWithDegrade$2(r9, r10, r11)), a(r8, "ContextInflateExt", new OrderCommonViewUtils$safeInflateWithDegrade$3(r9, r10, r11))}));
    }
}
