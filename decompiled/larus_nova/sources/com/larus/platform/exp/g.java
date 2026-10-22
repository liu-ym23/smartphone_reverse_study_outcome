package com.larus.platform.exp;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f365383a = null;

    static {
        f365383a = LazyKt.lazy(new f());
    }

    public static boolean a() {
        Lazy r100 = f365383a;
        if (((kq9.n) r100.getValue()).a() == false) goto L5;
    L8:
        return true;
    L5:
        if (((kq9.n) r100.getValue()).b() == true) goto L8;
        return false;
    }
}
