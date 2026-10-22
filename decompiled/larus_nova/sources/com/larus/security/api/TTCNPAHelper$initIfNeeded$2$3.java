package com.larus.security.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class TTCNPAHelper$initIfNeeded$2$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public TTCNPAHelper$initIfNeeded$2$3(Object r100) {
        super(0, r100, TTCNPAHelper.class, "resumeInitSuccess", "resumeInitSuccess()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TTCNPAHelper r100 = (TTCNPAHelper) this.receiver;
        TTCNPAHelper r101 = TTCNPAHelper.f367850a;
        monitor-enter(r100);
        TTCNPAHelper.f367852c = true;     // Catch: Throwable -> L14
        List<kotlinx.coroutines.i<Unit>> r102 = TTCNPAHelper.f367853d;     // Catch: Throwable -> L14
        List r103 = CollectionsKt.toList(r102);     // Catch: Throwable -> L14
        ((ArrayList) r102).clear();     // Catch: Throwable -> L14
        monitor-exit(r100);
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        kotlinx.coroutines.i r105 = (kotlinx.coroutines.i) r104.next();
        if (r105.isActive() == false) goto L9;
        Result.Companion r106 = Result.Companion;
        r105.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
