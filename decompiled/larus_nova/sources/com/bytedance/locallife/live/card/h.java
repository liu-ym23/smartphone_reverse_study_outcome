package com.bytedance.locallife.live.card;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f259241a = null;

    static {
        f259241a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
