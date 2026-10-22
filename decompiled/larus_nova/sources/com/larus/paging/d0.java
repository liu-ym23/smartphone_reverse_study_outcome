package com.larus.paging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class d0 implements FlowCollector<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f363799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadType f363800b;

    public d0(PageFetcherSnapshot r100, LoadType r101) {
        this.f363799a = r100;
        this.f363800b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(o r100, Continuation r101) {
        PageFetcherSnapshot r102 = this.f363799a;
        LoadType r103 = this.f363800b;
        Object r104 = PageFetcherSnapshot.b(r102, r103, r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }
}
