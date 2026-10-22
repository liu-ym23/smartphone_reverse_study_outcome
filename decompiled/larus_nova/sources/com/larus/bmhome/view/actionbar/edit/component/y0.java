package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.api.ICommerceMembershipService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class y0 {
    public static final void a(Context r100, k0 r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r103 = ICommerceMembershipService.a.a();
        if (r103 == null) goto L5;
        r103.v(r101.f316394c, null);
    L5:
        String r104 = r101.a();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        int r105 = uz8.b.f552201e;
        SmartRouter.buildRoute(r100, b(r104, r102, uz8.b.a.a(r101.f316395d))).d();
    }

    public static final String b(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Uri r113 = UriProtector.parse(r110);
        String r100 = com.larus.utils.y0.f(r113, "target_url");
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L19;
        Intrinsics.checkNotNull(r113);
        Uri r114 = com.larus.utils.y0.l(r113, "enter_method", r111);
        if (r112 != null) goto L14;
    L16:
        r112 = null;
    L18:
        return com.larus.utils.y0.l(r114, "feature_detail", r112).toString();
    L14:
        if ((!StringsKt.isBlank(r112)) == false) goto L16;
    L19:
        int r103 = 0;
    L21:
        if (UriProtector.parse(r100).getScheme() != null) goto L26;
        String r104 = Uri.decode(r100);
        if (Intrinsics.areEqual(r104, r100) == true) goto L26;
        Intrinsics.checkNotNull(r104);
        r103 = r103 + 1;
        r100 = r104;
    L26:
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri r115 = com.larus.utils.y0.l(UriProtector.parse(r100), "enter_method", r111);
        if (r112 != null) goto L29;
    L31:
        r112 = null;
    L32:
        String r116 = com.larus.utils.y0.l(r115, "feature_detail", r112).toString();
        Intrinsics.checkNotNull(r113);
    L33:
        if (r101 >= r103) goto L36;
        r116 = Uri.encode(r116);
        r101 = r101 + 1;
        goto L33
    L36:
        return com.larus.utils.y0.l(r113, "target_url", r116).toString();
    L29:
        if ((!StringsKt.isBlank(r112)) == false) goto L31;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }
}
