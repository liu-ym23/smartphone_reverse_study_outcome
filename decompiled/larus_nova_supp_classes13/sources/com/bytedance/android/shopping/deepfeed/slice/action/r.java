package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends b {
    public r(w r2) {
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
        Object r6 = r5.get("toggleMute");
    L7:
        if ((r6 instanceof Boolean) == true) goto L9;
        r6 = null;
    L9:
        Boolean r7 = (Boolean) r6;
        Map r8 = r3.getParams();
        if (r8 == null) goto L12;
        Object r9 = r8.get("togglePlaying");
    L14:
        if ((r9 instanceof Boolean) == false) goto L17;
        r0 = r9;
    L17:
        Boolean r1 = (Boolean) r0;
        if (r7 == null) goto L20;
        this.c.y(r7.booleanValue());
    L20:
        if (r1 == null) goto L24;
        this.c.b(r1.booleanValue());
        return false;
    L24:
        return false;
    L12:
        r9 = null;
        goto L14
    L5:
        r6 = null;
        goto L7
    }
}
