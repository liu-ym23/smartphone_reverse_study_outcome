package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedRequestAction extends b {
    public DeepFeedRequestAction(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(final IAction r5, final View r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        Map r0 = r5.getParams();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("type");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        int r4 = r3.hashCode();
        if (r4 == 17970594) goto L29;
        if (r4 == 949444906) goto L18;
        return false;
    L18:
        if (r3.equals("collect") == false) goto L32;
        w r7 = this.c;
        Map r8 = r5.getParams();
        if (r8 == null) goto L22;
        Object r9 = r8.get("is_collected");
    L24:
        if ((r9 instanceof Boolean) == false) goto L27;
        r1 = r9;
    L27:
        r7.m((Boolean) r1, r6);
        return false;
    L22:
        r9 = null;
        goto L24
    L32:
        return false;
    L29:
        if (r3.equals("mixCoupon") == false) goto L35;
        this.c.x(new DeepFeedRequestAction$onHandleAction$1(this, r5, r6));
        return true;
    L35:
        return false;
    L5:
        r2 = null;
        goto L7
    }
}
