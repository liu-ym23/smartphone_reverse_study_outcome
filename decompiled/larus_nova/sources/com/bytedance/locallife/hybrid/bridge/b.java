package com.bytedance.locallife.hybrid.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final void a(IDLXBridgeMethod.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        Map<? extends String, ? extends Object> r104 = MapsKt.mapOf(TuplesKt.to("msg", r101));
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, ? extends Object> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0)});
        if (r104 != null) goto L14;
    L16:
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        r105.putAll(r104);
    L19:
        r100.invoke(r105);
        return;
    L14:
        if ((!r104.isEmpty()) != true) goto L16;
    L10:
        r104 = null;
        goto L11
    L5:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r101) != true) goto L7;
        r103 = true;
        goto L8
    }

    public static final void b(IDLXBridgeMethod.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        Map<? extends String, ? extends Object> r103 = MapsKt.mapOf(TuplesKt.to("msg", r101));
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, ? extends Object> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)});
        if (r103 == null) goto L14;
        r104.putAll(r103);
    L14:
        r100.invoke(r104);
        return;
    L10:
        r103 = null;
        goto L11
    L5:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r101) != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final void c(IDLXBridgeMethod.a r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, ? extends Object> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)});
        if (r101 == null) goto L5;
        r102.put("data", r101);
    L5:
        r100.invoke(r102);
    }
}
