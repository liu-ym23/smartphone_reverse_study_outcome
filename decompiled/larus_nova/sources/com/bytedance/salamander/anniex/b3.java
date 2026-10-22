package com.bytedance.salamander.anniex;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b3 implements i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GeckoCDNInterceptor f267977a;

    public b3(GeckoCDNInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "geckoCDNInterceptor");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f267977a = r100;
    }

    @Override // com.bytedance.salamander.anniex.i3
    public final void a(y4 r100, Function1<? super z4, Unit> r101, Function2<? super Integer, ? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "success");
        Intrinsics.checkNotNullParameter(r110, "fail");
        a5 r102 = r100.f268528f;
        GeckoCDNInterceptor r103 = null;
        if (r102 == null) goto L5;
        q2 r104 = r102.f267953a;
    L6:
        if (r104 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        q2 r105 = r102.f267953a;
        r105.getClass();
        Intrinsics.checkNotNullParameter("cdn", "<set-?>");
        r105.f268319o = "cdn";
    L8:
        com.bytedance.anniex.bd.foundation.impl.i r106 = com.bytedance.anniex.bd.foundation.impl.a.f190139a;
        StringBuilder r107 = new StringBuilder("GeckoCDNRemoteInterceptor intercept, need fetch config:");
        GeckoCDNInterceptor r108 = this.f267977a;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("geckoCDNInterceptor");
        r108 = null;
    L12:
        boolean r109 = false;
        if (r108.f267883h != true) goto L15;
        boolean r111 = true;
    L16:
        r107.append(r111);
        r106.c("AnnieXRedirectTag", r107.toString());
        GeckoCDNInterceptor r112 = this.f267977a;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("geckoCDNInterceptor");
        r112 = null;
    L21:
        if (r112.f267883h != true) goto L23;
        r109 = true;
    L23:
        if (r109 != true) goto L29;
        GeckoCDNInterceptor r113 = this.f267977a;
        if (r113 == null) goto L27;
        r103 = r113;
    L28:
        r103.b(r100, r101, r110, "remote lazy");
        return;
    L27:
        Intrinsics.throwUninitializedPropertyAccessException("geckoCDNInterceptor");
        goto L28
    L29:
        int r114 = x4.f268501d;
        r110.invoke(4, "no match rule");
        return;
    L15:
        r111 = false;
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
