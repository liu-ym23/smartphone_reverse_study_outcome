package com.relax.relaxreact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class SnapshotKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f405454a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f405455b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d1 f405456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d1 f405457d;

    public static final d1 a() {
        if (f405456c != null) goto L5;
        f405456c = new d1(SnapshotKt$getWrapperSnapshot$1.INSTANCE, null, com.bytedance.rts.kmp.foundation.i.b(new Integer[]{16777216}));
    L5:
        d1 r100 = f405456c;
        Intrinsics.checkNotNull(r100);
        return r100;
    }
}
