package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final View a(HashMap<View, BaseHorizontalPullLayout.a> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$getByType");
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        View r0 = r5.next().getKey();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L14;
        int r2 = ((BaseHorizontalPullLayout.LayoutParams) r1).getType();
        if (r4 == null) goto L4;
        if (r2 != r4.intValue()) goto L4;
        return r0;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    L15:
        return null;
    }
}
