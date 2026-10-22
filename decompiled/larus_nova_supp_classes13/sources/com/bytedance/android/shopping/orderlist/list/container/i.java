package com.bytedance.android.shopping.orderlist.list.container;

import android.widget.LinearLayout;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public final int[] a;
    public final OrderListLinkedScrollView b;
    public final LinearLayout c;

    public i(OrderListLinkedScrollView r2, LinearLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r3, "stickyContainer");
        this.b = r2;
        this.c = r3;
        this.a = new int[2];
        new WeakReference(null);
    }
}
