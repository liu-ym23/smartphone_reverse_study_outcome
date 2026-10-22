package com.larus.image.loader;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f350989a = null;

    static {
        f350989a = LazyKt.lazy(new n());
    }

    public static final int a() {
        if (b0.f350967a == true) goto L5;
        return 0;
    L5:
        return ((Keva) f350989a.getValue()).getInt("image_test_flag", 0);
    }
}
