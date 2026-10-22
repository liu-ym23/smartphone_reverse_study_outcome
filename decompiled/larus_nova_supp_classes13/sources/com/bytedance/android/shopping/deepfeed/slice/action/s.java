package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends a {
    public final y c;

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void c(DeepFeedSlcCardContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
    }

    public s(y r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContainer");
        this.c = r2;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "targetView");
        Map r8 = r6.getParams();
        Object r0 = null;
        if (r8 == null) goto L5;
        Object r9 = r8.get("scope");
    L7:
        if ((r9 instanceof Map) == true) goto L9;
        r9 = null;
    L9:
        Map r10 = (Map) r9;
        if (r10 == null) goto L41;
        Object r2 = r10.get("start");
        if ((r2 instanceof Integer) == true) goto L14;
        r2 = null;
    L14:
        Integer r3 = (Integer) r2;
        if (r3 == null) goto L17;
        int r4 = r3.intValue();
    L18:
        Object r11 = r10.get("end");
        if ((r11 instanceof Integer) == true) goto L21;
        r11 = null;
    L21:
        Integer r12 = (Integer) r11;
        if (r12 == null) goto L24;
        int r13 = r12.intValue();
    L25:
        Map r14 = r6.getParams();
        if (r14 == null) goto L28;
        Object r15 = r14.get("params");
    L30:
        if ((r15 instanceof Map) == false) goto L33;
        r0 = r15;
    L33:
        Map<String, ? extends Object> r1 = (Map) r0;
        if (r1 != null) goto L36;
        r1 = MapsKt.emptyMap();
    L36:
        if (r4 != (-1)) goto L39;
        if (r13 != (-1)) goto L39;
        this.c.C(r1);
        return false;
    L39:
        this.c.p(r4, r13, r1);
        return false;
    L28:
        r15 = null;
        goto L30
    L24:
        r13 = -1;
        goto L25
    L17:
        r4 = -1;
        goto L18
    L41:
        if (r6.getParams() == null) goto L58;
        Map r16 = r6.getParams();
        if (r16 == null) goto L45;
        Object r17 = r16.get("params");
    L47:
        if ((r17 instanceof Map) == false) goto L50;
        r0 = r17;
    L50:
        Map<String, ? extends Object> r5 = (Map) r0;
        if (r5 != null) goto L53;
        r5 = MapsKt.emptyMap();
    L53:
        this.c.C(r5);
        return false;
    L45:
        r17 = null;
        goto L47
    L58:
        return false;
    L5:
        r9 = null;
        goto L7
    }
}
