package com.bytedance.live.datacontext;

import io.reactivex.Completable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ConstantMemberConfig<T> extends o<h<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<? extends T> f255059d;

    public ConstantMemberConfig(Completable r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "onCleared");
        Intrinsics.checkNotNullParameter(r101, "fallback");
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        u r103 = b.f255078a;
        Intrinsics.checkNotNullParameter(r102, "valueGetter");
        super(r100, new DataContextKt$makeDefaultFinalizer$1(r102));
        this.f255059d = r101;
    }
}
