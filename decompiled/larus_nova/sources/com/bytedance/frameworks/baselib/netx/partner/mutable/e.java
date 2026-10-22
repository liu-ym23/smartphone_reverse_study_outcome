package com.bytedance.frameworks.baselib.netx.partner.mutable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<String>> f244845a;

    public e() {
        this.f244845a = new LinkedHashMap();
    }

    public final void a(String r100, String r101) {
        String r102 = a.c(r100, 0, r100.length(), true);
        if (r101 != null) goto L5;
        String r103 = null;
    L6:
        List<String> r104 = (List) ((LinkedHashMap) this.f244845a).get(r102);
        if (r104 != null) goto L9;
        r104 = new ArrayList();
        this.f244845a.put(r102, r104);
    L9:
        r104.add(r103);
        return;
    L5:
        r103 = a.c(r101, 0, r101.length(), true);
        goto L6
    }
}
