package com.bytedance.salamander.adapter;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v {
    public static final ConcurrentHashMap<String, j> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static final j a(String r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return new t(r0, r1);
    L5:
        return new a(r0, r1);
    }
}
