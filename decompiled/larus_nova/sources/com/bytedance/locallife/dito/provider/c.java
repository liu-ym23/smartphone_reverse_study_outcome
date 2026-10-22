package com.bytedance.locallife.dito.provider;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class c<T> extends b<T> {
    @Override // com.bytedance.locallife.dito.provider.b
    public final Map<String, Object> a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultValue");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("code", Integer.valueOf(b()));
        String r102 = d();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put("msg", r102);
        T r103 = c();
        if (r103 == true) goto L8;
        r103 = (T) new LinkedHashMap();
    L8:
        r101.put("data", r103);
        return r101;
    }

    public c(int r100, String r101, T r102) {
        super(r100, r101, r102, false, 8);
    }
}
