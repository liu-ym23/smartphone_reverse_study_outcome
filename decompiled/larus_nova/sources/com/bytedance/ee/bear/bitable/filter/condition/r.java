package com.bytedance.ee.bear.bitable.filter.condition;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r<T, R> f211866a = null;

    static {
        f211866a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        UserFilterConditionView.UserListResult r101 = (UserFilterConditionView.UserListResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getData();
    }
}
