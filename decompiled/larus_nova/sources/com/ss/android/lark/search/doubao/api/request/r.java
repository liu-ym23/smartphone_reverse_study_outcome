package com.ss.android.lark.search.doubao.api.request;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r {
    public static final s a(Function1<? super q, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        q r100 = new q();
        r110.invoke(r100);
        String r101 = r100.f439986a;
        Integer r102 = r100.f439987b;
        String r103 = r100.f439988c;
        k r104 = r100.f439990e;
        if (r104 == null) goto L5;
        l r105 = new l(r104.f439978b, r104.f439977a);
    L6:
        e r106 = r100.f439991f;
        if (r106 == null) goto L9;
        f r107 = new f(r106.f439961a, r106.f439962b);
    L11:
        if (r100.f439989d == null) goto L13;
        p r108 = new p();
    L14:
        t r109 = r100.f439992g;
        if (r109 == null) goto L17;
        u r111 = new u(r109.f440012a, r109.f440013b);
    L18:
        a r112 = r100.f439993h;
        if (r112 == null) goto L21;
        b r113 = new b(r112.f439950a);
    L22:
        i r114 = r100.f439994i;
        if (r114 == null) goto L25;
        j r115 = new j(r114.f439967a, r114.f439968b, r114.f439969c, r114.f439970d, r114.f439971e);
    L26:
        g r116 = r100.f439995j;
        if (r116 == null) goto L29;
        h r117 = new h(r116.f439965a);
    L30:
        m r118 = r100.f439996k;
        if (r118 == null) goto L33;
        n r119 = new n(r118.f439983a);
    L35:
        if (r100.f439997l == null) goto L37;
        w r120 = new w();
    L38:
        c r121 = r100.f439998m;
        if (r121 == null) goto L41;
        d r122 = new d(r121.f439952a, r121.f439953b, r121.f439954c, r121.f439955d);
    L43:
        return new s(r101, r102, r103, r105, r107, r108, r111, r113, r115, r117, r119, r120, r122);
    L41:
        r122 = null;
        goto L43
    L37:
        r120 = null;
        goto L38
    L33:
        r119 = null;
        goto L35
    L29:
        r117 = null;
        goto L30
    L25:
        r115 = null;
        goto L26
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L11
    L5:
        r105 = null;
        goto L6
    }
}
