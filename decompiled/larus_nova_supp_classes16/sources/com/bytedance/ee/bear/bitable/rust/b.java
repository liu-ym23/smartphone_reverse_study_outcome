package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final String a(DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        a r0 = (a) r3.getHostAbilityOrNull(a.class);
        com.bytedance.ee.bear.bitable.load.d r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getContainerId();
    L6:
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        return r2;
    L14:
        x2 r5 = r3.getDocumentLoader();
        if ((r5 instanceof com.bytedance.ee.bear.bitable.load.d) == false) goto L17;
        r1 = (com.bytedance.ee.bear.bitable.load.d) r5;
    L17:
        if (r1 == null) goto L23;
        cu4.c r6 = r1.x(cu4.c.class);
        if (r6 == null) goto L23;
        String r7 = r6.getContainerId();
        if (r7 == null) goto L23;
        return r7;
    L23:
        return "";
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
