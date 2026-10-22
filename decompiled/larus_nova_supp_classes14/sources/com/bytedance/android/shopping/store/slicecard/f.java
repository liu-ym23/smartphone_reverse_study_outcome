package com.bytedance.android.shopping.store.slicecard;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object b(View r4, Map r5, String r6) {
        if (r5 == null) goto L5;
        Object r2 = r5.get(":".concat(r6));
    L6:
        if (r2 != null) goto L10;
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.get(r6);
    L10:
        BaseSlcViewManager r7 = SlcViewExtensionsKt.g(r4);
        if (r7 == null) goto L14;
        Map r3 = r7.l();
        if (r3 == null) goto L14;
    L15:
        if (r7 == null) goto L21;
        SlcTemplateContext r8 = r7.a;
        if (r8 == null) goto L21;
        SlcRenderContext r9 = r8.w;
        if (r9 == null) goto L21;
        SlcExprContext r10 = r9.m0;
    L22:
        if (r10 == null) goto L26;
        String r11 = String.valueOf(r5.get(":".concat(r6)));
        int r12 = SlcExprContext.g;
        return r10.a(r11, r3, null);
    L26:
        return null;
    L21:
        r10 = null;
    L14:
        r3 = new HashMap();
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    public static Map c(View r1, Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetView");
        Intrinsics.checkNotNullParameter(r3, "key");
        return com.bytedance.android.ecom.arch.slice.render.util.b.o(b(r1, r2, r3));
    }

    public static String d(View r1, Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetView");
        Intrinsics.checkNotNullParameter(r3, "key");
        return com.bytedance.android.ecom.arch.slice.render.util.b.r(b(r1, r2, r3));
    }

    public static String a(View r1, String r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r1, "targetView");
        Intrinsics.checkNotNullParameter(r3, "btmId");
        ECStoreFoldPhoneHelper.b(r2);
        int r0 = com.bytedance.android.ec.store.utils.b.a;
        PageFinder r5 = PageFinder.via(r1);
        BcmParams.Companion.getClass();
        return com.bytedance.android.ec.store.utils.b.b(r2, r3, r5, BcmParams.a.c(r4));
    }
}
