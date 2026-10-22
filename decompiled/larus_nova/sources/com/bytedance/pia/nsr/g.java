package com.bytedance.pia.nsr;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f266520a = null;

    static {
        f266520a = new g();
    }

    public g() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return Intrinsics.compare(((Number) ((Pair) r100).getFirst()).longValue(), ((Number) ((Pair) r101).getFirst()).longValue());
    }
}
