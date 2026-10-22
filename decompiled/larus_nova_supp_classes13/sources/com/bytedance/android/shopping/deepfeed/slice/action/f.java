package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends b {
    public f(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Map r5 = r3.getParams();
        Object r0 = null;
        if (r5 == null) goto L5;
        Object r6 = r5.get("main_area");
    L7:
        if ((r6 instanceof String) == true) goto L9;
        r6 = null;
    L9:
        String r7 = (String) r6;
        if (r7 != null) goto L13;
        return true;
    L13:
        Map r8 = r3.getParams();
        if (r8 == null) goto L16;
        Object r9 = r8.get("mixed_media");
    L18:
        if ((r9 instanceof Boolean) == false) goto L21;
        r0 = r9;
    L21:
        Boolean r1 = (Boolean) r0;
        if (r1 == null) goto L24;
        boolean r2 = r1.booleanValue();
    L25:
        this.c.u(r7, r2);
        return false;
    L24:
        r2 = false;
        goto L25
    L16:
        r9 = null;
        goto L18
    L5:
        r6 = null;
        goto L7
    }
}
