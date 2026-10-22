package com.bytedance.bdinstall;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements r {
    public a() {
    }

    public abstract String c();

    @Override // com.bytedance.bdinstall.r
    public final Map<String, String> d() {
        String r100 = c();
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.put("x-tt-dt", r100);
        return r101;
    }
}
