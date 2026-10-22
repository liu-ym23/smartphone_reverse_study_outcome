package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends b {
    public j(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r8, "targetView");
        Map r0 = r7.getParams();
        if (r0 == null) goto L5;
        Object r1 = r0.get("query");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        if (r2.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        return false;
    L18:
        Map r9 = r7.getParams();
        if (r9 == null) goto L21;
        Object r10 = r9.get("feature_info_list");
    L23:
        if ((r10 instanceof List) == true) goto L25;
        r10 = null;
    L25:
        List r11 = (List) r10;
        if (r11 == null) goto L36;
        List<String> r4 = new ArrayList();
        Iterator r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L37;
        Object r5 = r12.next();
        if ((r5 instanceof String) == true) goto L33;
        r5 = null;
    L33:
        String r6 = (String) r5;
        if (r6 == null) goto L29;
        r4.add(r6);
    L37:
        this.c.d(r2, r4, r8);
        return false;
    L36:
        r4 = CollectionsKt.emptyList();
        goto L37
    L21:
        r10 = null;
        goto L23
    L15:
        r3 = false;
        goto L16
    L5:
        r1 = null;
        goto L7
    }
}
