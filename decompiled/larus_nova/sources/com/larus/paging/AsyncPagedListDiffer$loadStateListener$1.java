package com.larus.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class AsyncPagedListDiffer$loadStateListener$1 extends FunctionReferenceImpl implements Function2<LoadType, u, Unit> {
    public AsyncPagedListDiffer$loadStateListener$1(Object r100) {
        super(2, r100, g0.c.class, "setState", "setState(Lcom/larus/paging/LoadType;Lcom/larus/paging/LoadState;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LoadType r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        g0.c r102 = (g0.c) this.receiver;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "state");
        int r103 = g0.c.a.f363854a[r100.ordinal()];
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L14;
        if (r103 == 3) goto L10;
    L21:
        r102.a(r100, r101);
        return;
    L10:
        if (Intrinsics.areEqual(r102.f363853c, r101) == true) goto L23;
        r102.f363853c = r101;
        goto L21
    L23:
        return;
    L14:
        if (Intrinsics.areEqual(r102.f363852b, r101) == true) goto L24;
        r102.f363852b = r101;
        goto L21
    L24:
        return;
    L18:
        if (Intrinsics.areEqual(r102.f363851a, r101) == true) goto L25;
        r102.f363851a = r101;
        goto L21
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(LoadType r100, u r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
