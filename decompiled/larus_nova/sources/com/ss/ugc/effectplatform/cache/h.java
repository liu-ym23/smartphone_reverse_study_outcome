package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.util.r;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z.b<String, j> f457336a = null;

    static {
        f457336a = new z.b(true);
    }

    public static j a(String r100) {
        if (r.b(r100) == false) goto L5;
        return null;
    L5:
        z.b<String, j> r101 = f457336a;
        if (r101.containsKey(r100) == true) goto L9;
        return null;
    L9:
        return r101.get(r100);
    }
}
