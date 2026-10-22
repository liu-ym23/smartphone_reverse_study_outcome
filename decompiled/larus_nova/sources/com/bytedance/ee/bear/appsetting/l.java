package com.bytedance.ee.bear.appsetting;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f206264a = null;

    static {
        f206264a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        EmergencyFixConfig r101 = (EmergencyFixConfig) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        String r102 = r101.getId();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        return !r103;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }
}
