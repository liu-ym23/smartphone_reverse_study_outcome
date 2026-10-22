package com.larus.security.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class TTCNPAHelper$initIfNeeded$2$4 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public TTCNPAHelper$initIfNeeded$2$4(Object r100) {
        super(1, r100, TTCNPAHelper.class, "resumeInitFailure", "resumeInitFailure(Ljava/lang/Throwable;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        TTCNPAHelper r101 = (TTCNPAHelper) this.receiver;
        TTCNPAHelper r102 = TTCNPAHelper.f367850a;
        monitor-enter(r101);
        TTCNPAHelper.f367851b = false;     // Catch: Throwable -> L14
        TTCNPAHelper.f367852c = false;     // Catch: Throwable -> L14
        List<kotlinx.coroutines.i<Unit>> r103 = TTCNPAHelper.f367853d;     // Catch: Throwable -> L14
        List r104 = CollectionsKt.toList(r103);     // Catch: Throwable -> L14
        ((ArrayList) r103).clear();     // Catch: Throwable -> L14
        monitor-exit(r101);
        Iterator r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        kotlinx.coroutines.i r106 = (kotlinx.coroutines.i) r105.next();
        if (r106.isActive() == false) goto L9;
        Result.Companion r107 = Result.Companion;
        r106.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
