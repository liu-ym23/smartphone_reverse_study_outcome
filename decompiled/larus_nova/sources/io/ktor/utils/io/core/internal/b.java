package io.ktor.utils.io.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final void a(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        throw new IllegalArgumentException("Long value " + r100 + " of " + r101 + " doesn't fit into 32-bit integer");
    }
}
