package com.bytedance.ee.bear.bizwidget.officesdk;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMOfficeSDKAssembleFG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f216511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f216512b = null;

    static {
        f216512b = LazyKt.lazy(CCMOfficeSDKAssembleFG$initExperimentEnable$2.INSTANCE);
    }

    public static boolean a() {
        if (f216511a != null) goto L16;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        Boolean r100 = Boolean.TRUE;
    L14:
        f216511a = r100;
        tt5.a.i("CCMOfficeSDKAssembleFG", "enable = " + f216511a + ", stack: ", new RuntimeException());
        goto L16
    L7:
        etb.a r101 = (etb.a) LarkContext.spiByDwarf(etb.a.class);
        if (r101 == null) goto L12;
        boolean r102 = true;
        if (r101.isEnable() != true) goto L12;
    L13:
        r100 = Boolean.valueOf(r102);
    L12:
        r102 = false;
    L16:
        return Intrinsics.areEqual(f216511a, Boolean.TRUE);
    }

    public static boolean b() {
        if (a() == false) goto L5;
    L10:
        return true;
    L5:
        if (a.a() == true) goto L10;
        if (((Boolean) f216512b.getValue()).booleanValue() == true) goto L10;
        return false;
    }
}
