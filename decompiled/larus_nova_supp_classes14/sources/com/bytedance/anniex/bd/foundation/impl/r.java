package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public final Keva a;

    public static final class a {
    }

    static {
    }

    public r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheId");
        this.a = Keva.getRepo(r2, 1);
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        Keva r0 = this.a;
        if (r0 == null) goto L6;
        r0.storeString(r2, r3);
        return;
    }
}
