package com.obric.oui.material;

import android.content.res.Resources;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p {
    public static final boolean b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return OMaterialHelper.j(r100.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(View r100, c r101) {
        if ((r100 instanceof com.obric.oui.common.style.b) == false) goto L18;
        com.obric.oui.common.style.b r102 = (com.obric.oui.common.style.b) r100;
        if (r102.e1() == false) goto L21;
        com.obric.oui.shadow.a[] r103 = r101.f401460i;
        if (r103 != null) goto L12;
        r102.h1(null, null);
        return;
    L12:
        if (r103.length <= 1) goto L15;
        Resources r104 = r100.getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        com.obric.oui.common.style.q r106 = com.obric.oui.common.style.q.f399591h;
        com.obric.oui.shadow.a r107 = r103[0];
        Intrinsics.checkNotNullParameter(r107, "config");
        com.obric.oui.common.style.q r108 = com.obric.oui.common.style.q.a.a(r107.b(), r105);
        com.obric.oui.shadow.a r109 = r103[1];
        Intrinsics.checkNotNullParameter(r109, "config");
        ((com.obric.oui.common.style.b) r100).h1(r108, com.obric.oui.common.style.q.a.a(r109.b(), r105));
        return;
    L15:
        if (r103.length != 1) goto L20;
        Resources r110 = r100.getResources();
        float r111 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density;
        com.obric.oui.common.style.q r112 = com.obric.oui.common.style.q.f399591h;
        com.obric.oui.shadow.a r113 = r103[0];
        Intrinsics.checkNotNullParameter(r113, "config");
        ((com.obric.oui.common.style.b) r100).h1(com.obric.oui.common.style.q.a.a(r113.b(), r111), null);
        return;
    L20:
        return;
    L21:
        return;
    }

    public static final void g(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == (-1)) goto L6;
        OMaterialHelper.q(r100, r101);
        return;
    }

    public static final void e(View r100, c[] r101, boolean r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "materials");
        boolean r104 = true;
        if (r103 == null) goto L5;
        c r105 = r101[r103.intValue() - 1];     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r105, "material");     // Catch: Exception -> L13
        f(r100, r105, r102, 3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.toString();
        return;
    L5:
        if (r101.length == 0) goto L8;
        r104 = false;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        d(r100, r101, r102, 3, 8);
    }

    public static final void f(View r100, c r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "material");
        a(r100, r101);
        if (OMaterialHelper.k() == true) goto L5;
        return;
    L5:
        if (r102 == false) goto L7;
        r100.setBackgroundColor(0);
    L7:
        Resources r104 = r100.getResources();
        OMaterialHelper.v(r100, r103, r101, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density);
    }

    public static final void c(View r100, c[] r101, boolean r102, int r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "materials");
        if (r104 == null) goto L5;
        f(r100, r101[r104.intValue() - 1], r102, r103);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.toString();
        return;
    L5:
        if (r101.length != 1) goto L8;
        c r105 = r101[0];
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "material");
        f(r100, r105, r102, r103);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "materials");
        if (r102 == false) goto L11;
        r100.setBackgroundColor(0);
    L11:
        Resources r106 = r100.getResources();
        OMaterialHelper.w(r100, r103, r101, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r107 = OMaterialHelper.g(r100.getContext());
        a(r100, r101[Math.min(r101.length - 1, Math.max(0, r107 - 1))]);
    }

    public static /* synthetic */ void d(View r100, c[] r101, boolean r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 2;
    L8:
        c(r100, r101, r102, r103, null);
    }
}
