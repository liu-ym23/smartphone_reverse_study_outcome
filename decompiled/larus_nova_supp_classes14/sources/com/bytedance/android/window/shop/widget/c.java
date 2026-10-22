package com.bytedance.android.window.shop.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final View a(RecyclerView r4, Class<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$tryGetSpecificTypeView");
        Intrinsics.checkNotNullParameter(r5, "type");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r4.getChildAt(r1);
        if (Intrinsics.areEqual(r2.getClass(), r5) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }
}
