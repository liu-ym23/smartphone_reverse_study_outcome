package com.bytedance.live.datacontext;

import io.reactivex.Completable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class MutableMemberConfig<T> extends o<l<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f255075d;

    public MutableMemberConfig(Completable r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "onCleared");
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        u r103 = b.f255078a;
        Intrinsics.checkNotNullParameter(r102, "valueGetter");
        super(r100, new DataContextKt$makeDefaultFinalizer$1(r102));
        this.f255075d = r101;
    }
}
