package com.f.android.quality.base;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
public final class QualityLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f274059a = null;

    static {
        f274059a = LazyKt.lazy(QualityLogger$defLogger$2.INSTANCE);
    }

    public static void a(String r100) {
        rt7.a r101 = a.f274060a;
        rt7.b r102 = a.f274061b;
        if (r102 != null) goto L6;
        r102 = (rt7.b) f274059a.getValue();
    L6:
        r102.i(r100);
    }
}
