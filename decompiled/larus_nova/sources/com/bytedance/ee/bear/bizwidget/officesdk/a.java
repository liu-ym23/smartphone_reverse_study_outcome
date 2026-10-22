package com.bytedance.ee.bear.bizwidget.officesdk;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import etb.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f216513a;

    static {
    }

    public static boolean a() {
        if (f216513a != null) goto L16;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        Boolean r100 = Boolean.TRUE;
    L14:
        f216513a = r100;
        tt5.a.i("CCMOfficeSpaceFG", "enable = " + f216513a + ", stack: ", new RuntimeException());
        goto L16
    L7:
        d r101 = (d) LarkContext.spiByDwarf(d.class);
        if (r101 == null) goto L12;
        boolean r102 = true;
        if (r101.isEnable() != true) goto L12;
    L13:
        r100 = Boolean.valueOf(r102);
    L12:
        r102 = false;
    L16:
        return Intrinsics.areEqual(f216513a, Boolean.TRUE);
    }
}
