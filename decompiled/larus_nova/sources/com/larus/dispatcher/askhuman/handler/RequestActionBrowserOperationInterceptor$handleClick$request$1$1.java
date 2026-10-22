package com.larus.dispatcher.askhuman.handler;

import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class RequestActionBrowserOperationInterceptor$handleClick$request$1$1 extends FunctionReferenceImpl implements Function1<BrowserTakeoverOpenResult, Unit> {
    public RequestActionBrowserOperationInterceptor$handleClick$request$1$1(Object r100) {
        super(1, r100, BrowserTakeoverEntryMonitor.class, "onOpenResult", "onOpenResult(Lcom/larus/browsertakeover/api/BrowserTakeoverOpenResult;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BrowserTakeoverOpenResult r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        BrowserTakeoverEntryMonitor r101 = (BrowserTakeoverEntryMonitor) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "result");
        r101.f330873d = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BrowserTakeoverOpenResult r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
