package com.bytedance.relax.ttmlstatic;

import com.bytedance.rts.kmp.foundation.j;
import com.bytedance.rts.kmp.foundation.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r87.c1;
import s87.i;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f267219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f267220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f267221c;

    public b(long r100, h r101) {
        Intrinsics.checkNotNullParameter(r101, "renderer");
        this.f267219a = r100;
        this.f267220b = r101;
        if (r101.f267249n == false) goto L6;
        long r102 = -1;
    L12:
        this.f267221c = r102;
        return;
    L6:
        if (r101.f267248m != null) goto L8;
        r101.f267248m = new LinkedHashMap();
    L8:
        Map<Long, Long> r103 = r101.f267248m;
        Intrinsics.checkNotNull(r103);
        Long r104 = (Long) j.c(r103, Long.valueOf(r100));
        if (r104 == null) goto L11;
        r102 = r104.longValue();
        goto L12
    L11:
        r101.f267247l++;
        Map<Long, Long> r105 = r101.f267248m;
        Intrinsics.checkNotNull(r105);
        j.e(r105, Long.valueOf(r100), Long.valueOf(r101.f267247l));
        r102 = r101.f267247l;
        goto L12
    }

    public final void a(Object r110, final c1 r111) {
        Intrinsics.checkNotNullParameter("setValue", com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "callback");
        h r100 = this.f267220b;
        long r101 = this.f267219a;
        long r102 = this.f267221c;
        if (r100.f267249n == true) goto L13;
        Map<Long, Long> r103 = r100.f267248m;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNull(r103);
        Long r104 = Long.valueOf(r101);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Long r105 = (Long) ((LinkedHashMap) r103).get(r104);
        if (r105 == null) goto L13;
        if (r105.longValue() != r102) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L16;
        return;
    L16:
        h r107 = this.f267220b;
        long r108 = this.f267219a;
        r107.getClass();
        Intrinsics.checkNotNullParameter("setValue", com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r107.f267249n == true) goto L51;
        if (r110 != null) goto L21;
        r110 = new LinkedHashMap();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Any");
    L21:
        final p r109 = new p(r107);
        Function1<Object, Unit> r112 = d.d(new TtmlStaticRenderer$invoke$wrappedCallback$1(r109, r111));
        s87.j r113 = r107.f267236a;
        s87.j r114 = null;
        if (r113 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r113 = null;
    L24:
        r113.getClass();
        Intrinsics.checkNotNullParameter("setValue", com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        int r115 = s87.e.f540981a;
        i r116 = r113.f540987a;
        Intrinsics.checkNotNullParameter(r116, "renderer");
        Intrinsics.checkNotNullParameter("setValue", com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        r116.a().E(r108, r110, s87.h.a(r112));
        if (r107.f267249n == false) goto L27;
        return;
    L27:
        if (r107.f267245j == true) goto L52;
        final int r117 = r107.f267244i + 1;
        r107.f267244i = r117;
        r107.f267245j = true;
        final p r118 = new p(r107);
        r107.f267241f = d.d(new TtmlStaticRenderer$scheduleFlushAfterInvoke$1(r118, r117));
        s87.j r119 = r107.f267236a;
        if (r119 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r119 = null;
    L32:
        Function1<Object, Unit> r120 = r107.f267241f;
        Intrinsics.checkNotNull(r120);
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "callback");
        i r121 = r119.f540987a;
        Intrinsics.checkNotNullParameter(r121, "renderer");
        Intrinsics.checkNotNullParameter(r120, "callback");
        long r122 = r121.a().M(s87.h.a(r120), 0);
        if (r107.f267245j == true) goto L35;
        return;
    L35:
        if (r107.f267244i != r117) goto L53;
        r107.f267242g = r122;
        s87.j r123 = r107.f267236a;
        if (r123 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L41:
        Function1<Object, Unit> r124 = r107.f267241f;
        Intrinsics.checkNotNull(r124);
        long r125 = r114.c(r124);
        if (r107.f267245j == true) goto L44;
        return;
    L44:
        if (r107.f267244i != r117) goto L50;
        r107.f267243h = r125;
        return;
    L50:
        return;
    L40:
        r114 = r123;
        goto L41
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L13:
        r106 = false;
        goto L14
    }
}
