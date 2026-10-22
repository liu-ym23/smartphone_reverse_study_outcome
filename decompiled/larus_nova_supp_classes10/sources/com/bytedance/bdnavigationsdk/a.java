package com.bytedance.bdnavigationsdk;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final a a = null;
    public static volatile Context b;

    static {
        a = new a();
    }

    public a() {
    }

    public final Context getContext() {
        if (b == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Context r1 = b;
        Intrinsics.checkNotNull(r1);
        return r1;
    L10:
        throw new IllegalStateException("BDNAAppContext 没有初始化".toString());
    L5:
        r0 = false;
        goto L6
    }
}
