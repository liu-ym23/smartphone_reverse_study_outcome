package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends b {
    public o(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Map r5 = r3.getParams();
        String r0 = "";
        if (r5 == null) goto L12;
        Object r6 = r5.get("tag");
        if ((r6 instanceof String) == true) goto L7;
        r6 = null;
    L7:
        String r7 = (String) r6;
        if (r7 == null) goto L12;
        r0 = r7;
    L12:
        if (r0.length() <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        this.c.h(r4, r0);
    L17:
        return false;
    L14:
        r8 = false;
        goto L15
    }
}
