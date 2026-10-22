package com.bytedance.applet.jsb;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i1 extends bx7.c {
    public final String getName() {
        return "x.setStorageItem";
    }

    public i1() {
    }

    public final void a(dx7.b r9, ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        p56.b r12 = (p56.b) e(p56.b.class);
        if (r12 == null) goto L5;
        r12.provideContainerID();
    L5:
        String r13 = r9.getString("key");
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        dx7.a r2 = r9.get("data");
        String r14 = r9.getString("biz");
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        ((d1) d1.a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r14, "biz");
        Keva r15 = d1.a(r14);
        long r3 = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(0);
        new LinkedHashMap();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ivy.ivykit.api.bridge.core.model.IvyDynamic");
        switch(d1.b.a[r2.getType().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L13;
        };
    L13:
        String r4 = "";
    L20:
        Intrinsics.checkNotNull(r4);
        r15.storeString(r13, r4);
        String r16 = r15.getString(r13, "");
        Intrinsics.checkNotNull(r16);
        MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", d1.b(r16))});
        r10.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L14:
        dx7.b r5 = r2.e();
        Intrinsics.checkNotNull(r5);
        Map r6 = r5.a();
        Gson r7 = d1.b;
        r4 = GsonProtectorUtils.toJson(r7, new f1("Map", GsonProtectorUtils.toJson(r7, r6), Long.valueOf(r3)));
        goto L20
    L15:
        dx7.e r8 = r2.a();
        Intrinsics.checkNotNull(r8);
        List r17 = r8.toList();
        Gson r18 = d1.b;
        r4 = GsonProtectorUtils.toJson(r18, new f1("Array", GsonProtectorUtils.toJson(r18, r17), Long.valueOf(r3)));
        goto L20
    L16:
        r4 = GsonProtectorUtils.toJson(d1.b, new f1("String", r2.f(), Long.valueOf(r3)));
        goto L20
    L17:
        r4 = GsonProtectorUtils.toJson(d1.b, new f1("Number", String.valueOf(r2.d()), Long.valueOf(r3)));
        goto L20
    L18:
        r4 = GsonProtectorUtils.toJson(d1.b, new f1("Int", String.valueOf(r2.d()), Long.valueOf(r3)));
        goto L20
    L19:
        r4 = GsonProtectorUtils.toJson(d1.b, new f1("Boolean", String.valueOf(r2.b()), Long.valueOf(r3)));
        goto L20
    }
}
