package com.bytedance.ee.bear.office.space;

import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ Function1<Result<Unit>, Unit> a;

    public n(com.larus.drive.sdk.impl.view.preview.b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("OfficeSpaceSdkImpl", "saveToSpace failed", r5, false);
        Function1<Result<Unit>, Unit> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        Intrinsics.checkNotNull(r5);
        r0.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r5))));
    }
}
