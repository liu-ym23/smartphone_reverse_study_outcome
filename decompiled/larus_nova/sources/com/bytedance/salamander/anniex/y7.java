package com.bytedance.salamander.anniex;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class y7 implements i3 {
    public y7() {
    }

    @Override // com.bytedance.salamander.anniex.i3
    public final void a(y4 r100, Function1<? super z4, Unit> r101, Function2<? super Integer, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "success");
        Intrinsics.checkNotNullParameter(r102, "fail");
        a5 r103 = r100.f268528f;
        q2 r104 = null;
        if (r103 == null) goto L5;
        q2 r105 = r103.f267953a;
    L7:
        if (r105 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        q2 r106 = r103.f267953a;
        r106.getClass();
        Intrinsics.checkNotNullParameter("settings", "<set-?>");
        r106.f268319o = "settings";
    L9:
        int r107 = q1.f268304a;
        Object r108 = com.bytedance.ies.bullet.service.base.h.s0(r100.f268524b);     // Catch: Throwable -> L12
    L13:
        String r109 = (String) r108;
        if (r109 != null) goto L23;
        a5 r110 = r100.f268528f;
        if (r110 == null) goto L19;
        r104 = r110.f267953a;
    L19:
        if (r104 == null) goto L21;
        Intrinsics.checkNotNull(r110);
        q2 r111 = r110.f267953a;
        int r112 = x4.f268501d;
        r111.f268314j = 3;
        a5 r113 = r100.f268528f;
        Intrinsics.checkNotNull(r113);
        q2 r114 = r113.f267953a;
        r114.getClass();
        Intrinsics.checkNotNullParameter("no entry config", "<set-?>");
        r114.f268318n = "no entry config";
    L21:
        int r115 = x4.f268501d;
        r102.invoke(3, "no entry config");
        return;
    L23:
        a5 r116 = r100.f268528f;
        if (r116 == null) goto L26;
        r104 = r116.f267953a;
    L26:
        if (r104 == null) goto L28;
        Intrinsics.checkNotNull(r116);
        q2 r117 = r116.f267953a;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r117.f268307c = r109;
    L28:
        r101.invoke(new z4(r109));
        return;
    L12:
        r108 = null;
        goto L13
    L5:
        r105 = null;
        goto L7
    }
}
