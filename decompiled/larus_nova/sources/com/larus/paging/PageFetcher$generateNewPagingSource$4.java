package com.larus.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class PageFetcher$generateNewPagingSource$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public PageFetcher$generateNewPagingSource$4(Object r100) {
        super(0, r100, c0.class, "invalidate", "invalidate()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((c0) this.receiver).f363790d.a(Boolean.FALSE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
