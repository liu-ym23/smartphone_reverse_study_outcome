package com.bytedance.ee.bear.bizwidget.officesdk;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import etb.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static Boolean a;

    static {
    }

    public static boolean a() {
        if (a != null) goto L16;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        Boolean r0 = Boolean.TRUE;
    L14:
        a = r0;
        tt5.a.i("CCMOfficeSpaceFG", "enable = " + a + ", stack: ", new RuntimeException());
        goto L16
    L7:
        d r1 = (d) LarkContext.spiByDwarf(d.class);
        if (r1 == null) goto L12;
        boolean r2 = true;
        if (r1.isEnable() != true) goto L12;
    L13:
        r0 = Boolean.valueOf(r2);
    L12:
        r2 = false;
    L16:
        return Intrinsics.areEqual(a, Boolean.TRUE);
    }
}
