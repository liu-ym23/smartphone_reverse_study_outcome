package com.larus.suggest.impl.repo;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f369913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f369914b = null;

    public c() {
    }

    static {
        f369913a = new c();
        f369914b = LazyKt.lazy(new b());
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "userId");
        ((Keva) f369914b.getValue()).erase(b(r100, r101));
    }

    public static String b(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "userId");
        return r100 + '_' + r101;
    }
}
