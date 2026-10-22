package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends b {
    public i(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "targetView");
        Map r6 = r4.getParams();
        Object r0 = null;
        if (r6 == null) goto L5;
        Object r7 = r6.get("type");
    L7:
        if ((r7 instanceof String) == true) goto L9;
        r7 = null;
    L9:
        String r8 = (String) r7;
        String r1 = "";
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        Map r9 = r4.getParams();
        if (r9 == null) goto L15;
        Object r10 = r9.get("ref");
    L17:
        if ((r10 instanceof String) == false) goto L20;
        r0 = r10;
    L20:
        String r2 = (String) r0;
        if (r2 == null) goto L24;
        r1 = r2;
    L24:
        vc3.b r11 = this.c.q();
        int r3 = r8.hashCode();
        if (r3 != (-1903464234)) goto L27;
        String r12 = "show_over";
        if (r8.equals("show_over") == false) goto L40;
    L39:
        r8 = r12;
    L40:
        int r13 = ie3.b.a;
        InFeedProductV2 r14 = r11.a;
        ie3.b.a(r8, r1);
        return false;
    L27:
        if (r3 != 3529469) goto L29;
        r12 = "show";
        if (r8.equals("show") == false) goto L40;
    L29:
        if (r3 != 94750088) goto L40;
        if (r8.equals("click") == false) goto L40;
        r8 = "realtime_click";
        goto L40
    L15:
        r10 = null;
        goto L17
    L5:
        r7 = null;
        goto L7
    }
}
