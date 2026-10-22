package com.bytedance.live.datacontext;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class q {
    public static /* synthetic */ p c(DataContext r100) {
        return b(r100, MutableKt$mutable$1.INSTANCE);
    }

    public static final <T> p<n<T>> b(DataContext r100, Function1<? super MutableMemberConfig<T>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        MutableMemberConfig r102 = new MutableMemberConfig(r100.getOnCleared(), null);
        r101.invoke(r102);
        return new p(new t(r102));
    }

    public static /* synthetic */ p d(DataContext r100, Object r101) {
        return a(r100, r101, MutableKt$mutable$2.INSTANCE);
    }

    public static final <T> p<m<T>> a(DataContext r100, T r101, Function1<? super MutableMemberConfig<T>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "initialValue");
        Intrinsics.checkNotNullParameter(r102, "config");
        MutableMemberConfig r103 = new MutableMemberConfig(r100.getOnCleared(), r101);
        r102.invoke(r103);
        return new p(new s(r103));
    }
}
