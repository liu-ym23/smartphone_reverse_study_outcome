package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c2 {
    public static final Map<String, String> a(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        int r102 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;
        com.bytedance.anniex.bd.foundation.impl.u r103 = com.bytedance.anniex.bd.foundation.impl.u.a.a(r100);
        if (r103 != null) goto L8;
        return r101;
    L8:
        String r104 = r103.c("bdhm_bid");
        if (r104 != null) goto L11;
    L13:
        String r105 = r103.c("bdhm_pid");
        if (r105 != null) goto L16;
    L18:
        return r101;
    L16:
        if (r105.length() <= 0) goto L18;
        com.bytedance.rts.foundation.m.e(r101, "pid", r105);
        goto L18
    L11:
        if (r104.length() <= 0) goto L13;
        com.bytedance.rts.foundation.m.e(r101, "bid", r104);
        goto L13
    }

    public static final void b(String r100, Map<String, String> r101, boolean r102, Function0<Boolean> r103, Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "fieldName");
        Intrinsics.checkNotNullParameter(r101, "map");
        Intrinsics.checkNotNullParameter(r103, "conditionCallback");
        Intrinsics.checkNotNullParameter(r104, "updateCallback");
        if (com.bytedance.rts.foundation.m.b(r101, r100) == false) goto L11;
        a8 r105 = d2.f268022a;
        Object r106 = ((LinkedHashMap) r101).get(r100);
        Intrinsics.checkNotNull(r106);
        String r107 = r105.c(r100, r106);
        if (r107 == null) goto L12;
        if (r102 == false) goto L8;
    L9:
        r104.invoke(r107);
        return;
    L8:
        if (r103.invoke().booleanValue() == true) goto L9;
        return;
    L12:
        return;
    }
}
