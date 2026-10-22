package com.bytedance.ee.permission;

import com.bytedance.ee.bear.middleground.permission.apply.ApplyDocPermPuller;
import com.larus.office.base.permission.r;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ut5.a<Boolean> f243024a;

    public c(r r100) {
        this.f243024a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ApplyDocPermPuller.Result r101 = (ApplyDocPermPuller.Result) r100;
        ut5.a<Boolean> r102 = this.f243024a;
        if (r102 == null) goto L6;
        r102.onResult(Boolean.valueOf(Intrinsics.areEqual(r101.getRet(), Boolean.TRUE)));
        return;
    }
}
