package com.bytedance.ee.bear.bizwidget.officesdk;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMOfficeSDKAssembleFG {
    public static Boolean a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(CCMOfficeSDKAssembleFG$initExperimentEnable$2.INSTANCE);
    }

    public static boolean a() {
        if (a != null) goto L16;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        Boolean r0 = Boolean.TRUE;
    L14:
        a = r0;
        tt5.a.i("CCMOfficeSDKAssembleFG", "enable = " + a + ", stack: ", new RuntimeException());
        goto L16
    L7:
        etb.a r1 = (etb.a) LarkContext.spiByDwarf(etb.a.class);
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

    public static boolean b() {
        if (a() == false) goto L5;
    L10:
        return true;
    L5:
        if (a.a() == true) goto L10;
        if (((Boolean) b.getValue()).booleanValue() == true) goto L10;
        return false;
    }
}
