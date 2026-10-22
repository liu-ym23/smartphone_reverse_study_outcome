package com.bytedance.ee.bear.bitable.homepage.list;

import android.text.TextUtils;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f212789a = null;

    static {
        f212789a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Boolean r101 = (Boolean) r100;
        return !TextUtils.isEmpty(((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).t());
    }
}
