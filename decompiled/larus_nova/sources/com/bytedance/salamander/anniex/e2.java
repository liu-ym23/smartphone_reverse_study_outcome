package com.bytedance.salamander.anniex;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e2 f268044b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.anniex.bd.foundation.impl.s<String, AnnieXBaseViewModel> f268045a;

    public static final class a {
        public static e2 a() {
            if (e2.f268044b != null) goto L5;
            e2.f268044b = new e2();
        L5:
            e2 r100 = e2.f268044b;
            Intrinsics.checkNotNull(r100);
            return r100;
        }
    }

    static {
    }

    public e2() {
        this.f268045a = new com.bytedance.anniex.bd.foundation.impl.s();
    }

    public final AnnieXBaseViewModel a(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        return this.f268045a.f190154a.get(r100);
    }

    public final void b(String r100, AnnieXBaseViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "anniexContainerId");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        ConcurrentHashMap<String, AnnieXBaseViewModel> r102 = this.f268045a.f190154a;
        if (r102 == null) goto L10;
        if (r102.containsKey(r100) == false) goto L7;
        return;
    L7:
        com.bytedance.anniex.bd.foundation.impl.s<String, AnnieXBaseViewModel> r103 = this.f268045a;
        r103.f190154a.containsKey(r100);
        ConcurrentHashMap<String, AnnieXBaseViewModel> r104 = r103.f190154a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        r104.put(r100, r101);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
