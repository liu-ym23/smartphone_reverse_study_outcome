package com.bytedance.awemeopen.appserviceimpl.dislike;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import r24.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class DislikeService$dislike$3$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public DislikeService$dislike$3$5(Object r100) {
        super(0, r100, a.class, "onSuccess", "onSuccess()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((a) this.receiver).onSuccess();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
