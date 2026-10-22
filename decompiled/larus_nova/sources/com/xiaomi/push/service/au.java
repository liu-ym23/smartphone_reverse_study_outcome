package com.xiaomi.push.service;

import com.xiaomi.push.gr;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class au {
    public static gr a(gr r100) {
        if (r100 == null) goto L6;
        Map<String, String> r101 = r100.f689b;
        if (r101 == null) goto L6;
        r101.remove("score_info");
    L6:
        return r100;
    }
}
