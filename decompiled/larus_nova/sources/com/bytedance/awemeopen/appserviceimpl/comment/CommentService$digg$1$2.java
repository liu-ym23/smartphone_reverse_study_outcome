package com.bytedance.awemeopen.appserviceimpl.comment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p24.b;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class CommentService$digg$1$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public CommentService$digg$1$2(Object r100) {
        super(0, r100, b.class, "onNetworkFail", "onNetworkFail()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((b) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
