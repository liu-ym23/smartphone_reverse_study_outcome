package com.bytedance.ee.bear.office.space;

import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Result<Unit>, Unit> f236123a;

    public n(com.larus.drive.sdk.impl.view.preview.b r100) {
        this.f236123a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("OfficeSpaceSdkImpl", "saveToSpace failed", r101, false);
        Function1<Result<Unit>, Unit> r102 = this.f236123a;
        Result.Companion r103 = Result.Companion;
        Intrinsics.checkNotNull(r101);
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
    }
}
