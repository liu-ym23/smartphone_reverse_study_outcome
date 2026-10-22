package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 {
    public static Integer a;

    public static final HashMap<String, Object> d() {
        HashMap<String, Object> r0 = new HashMap();
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        if (r1 == null) goto L21;
        yj.g r2 = r1.getHostAB();
        if (r2 == null) goto L21;
        com.bytedance.android.ec.hybrid.data.i r3 = r2.k();
        if (r3 == null) goto L21;
        String r4 = "1";
        if (r3.b == false) goto L11;
        String r5 = "1";
    L13:
        if (r3.c == false) goto L15;
        String r6 = "1";
    L16:
        String r7 = r5.concat(r6) + r3.a();
        StringBuilder r8 = new StringBuilder();
        r8.append(r7);
        if (r3.f == true) goto L20;
        r4 = "0";
    L20:
        r8.append(r4);
        r0.put("ec_na_mall_preload_image_opt", r8.toString());
        goto L21
    L15:
        r6 = "0";
        goto L16
    L11:
        r5 = "0";
    L21:
        return r0;
    }

    public static void c(SimpleDraweeView r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "draweeView");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter("ec_na_mall", "bizTag");
        Intrinsics.checkNotNullParameter(r5, "sceneTag");
        boolean r0 = false;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r0 = b(r3, r4, "ec_na_mall", r5);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        if (r0 == true) goto L12;
        r3.setImageURI(r4);
        return;
    L12:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final boolean b(SimpleDraweeView r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "draweeView");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "bizTag");
        Intrinsics.checkNotNullParameter(r4, "sceneTag");
        return a(r1, null, r2, r3, r4);
    }

    public static final boolean a(SimpleDraweeView r9, BaseControllerListener r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "draweeView");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "bizTag");
        Intrinsics.checkNotNullParameter(r13, "sceneTag");
        HashMap<String, Object> r7 = d();
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L7;
        yj.l r1 = r0.getIHybridHostFrescoService();
        if (r1 == null) goto L7;
        yj.l.b.a(r1, r9, r10, r11, r12, r13, r7, 192);
        Boolean r14 = Boolean.FALSE;
    L8:
        if (r14 != null) goto L10;
    L12:
        return false;
    L10:
        if (Intrinsics.areEqual(r14, Boolean.FALSE) == true) goto L12;
        return true;
    L7:
        r14 = null;
        goto L8
    }
}
