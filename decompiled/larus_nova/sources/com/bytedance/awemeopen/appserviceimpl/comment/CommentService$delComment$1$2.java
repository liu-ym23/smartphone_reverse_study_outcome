package com.bytedance.awemeopen.appserviceimpl.comment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import o14.d;
import p24.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class CommentService$delComment$1$2 extends FunctionReferenceImpl implements Function1<d, Unit> {
    public CommentService$delComment$1$2(Object r100) {
        super(1, r100, a.class, "onSuccess", "onSuccess(Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((a) this.receiver).onSuccess(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
