package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final String a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getActionName");
        int r0 = r2.getAction();
        if (r0 != 0) goto L5;
        return "DOWN";
    L5:
        if (r0 != 1) goto L7;
        return "UP";
    L7:
        if (r0 != 2) goto L9;
        return "MOVE";
    L9:
        if (r0 != 3) goto L16;
        return "CANCEL";
    L16:
        return String.valueOf(r2.getAction());
    }
}
