package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T1, T2, R> f211622a = null;

    static {
        f211622a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r100;
        Intrinsics.checkNotNullParameter(r102, "result1");
        Intrinsics.checkNotNullParameter((List) r101, "<unused var>");
        return r102;
    }
}
