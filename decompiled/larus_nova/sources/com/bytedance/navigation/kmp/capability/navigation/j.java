package com.bytedance.navigation.kmp.capability.navigation;

import com.bytedance.bdnavigationsdk.b0;
import com.bytedance.bdnavigationsdk.c0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements b0 {
    public j() {
    }

    @Override // com.bytedance.bdnavigationsdk.b0
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 == null) goto L6;
        Map<String, ? extends Object> r102 = MapsKt.toMutableMap(r101);
        if (r102 == null) goto L6;
    L7:
        int r103 = w27.b.f558037a;
        r102.put("nav_sdk_version", "0.0.1-rc.44");
        int r104 = c0.f200006a;
        Intrinsics.areEqual("0.0.1-rc.44", Constants.Unspecified.getValue());
        r102.put("engine_sdk_version", "0.0.1-rc.44");
        e37.i r105 = com.bytedance.navigation.kmp.handler.tracker.n.f265930a.getValue();
        if (r105 == null) goto L11;
        r105.a(r100, r102);
        return;
    L11:
        return;
    L6:
        r102 = new LinkedHashMap();
        goto L7
    }
}
