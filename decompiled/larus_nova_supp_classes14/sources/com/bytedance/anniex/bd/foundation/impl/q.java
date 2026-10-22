package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.salamander.anniex.AnnieXServiceUtilKt;
import com.bytedance.salamander.anniex.j3;
import com.bytedance.salamander.anniex.t1;
import com.bytedance.salamander.anniex.u1;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class q {
    public final String a;
    public final s<String, h> b;
    public final Set<Function0<h>> c;

    public q(String r2) {
        Intrinsics.checkNotNullParameter(r2, "storeId");
        this.a = "";
        this.c = com.bytedance.rts.foundation.q.b(new Function0[0]);
        this.a = r2;
        this.b = new s();
        new ConcurrentHashMap();
    }

    public final h a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceId");
        s<String, h> r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceMap");
        r1 = null;
    L5:
        h r2 = r1.a.get(r4);
        if (r2 == null) goto L8;
        return r2;
    L8:
        t1 r3 = (t1) this;
        Intrinsics.checkNotNullParameter(r4, "serviceId");
        String r5 = r3.a;
        int r0 = u1.a;
        if (Intrinsics.areEqual(r5, "AnnieXDefaultServiceStore") == false) goto L12;
        ((j3) AnnieXRuntime.b.getValue()).b();
    L15:
        return null;
    L12:
        if (Intrinsics.areEqual(r3.a, "AnnieXHostServiceStore") == false) goto L14;
        ((j3) AnnieXRuntime.b.getValue()).c();
        goto L15
    L14:
        ((j3) AnnieXRuntime.b.getValue()).a((String) AnnieXServiceUtilKt.a.invoke(r3.a));
        goto L15
    }
}
