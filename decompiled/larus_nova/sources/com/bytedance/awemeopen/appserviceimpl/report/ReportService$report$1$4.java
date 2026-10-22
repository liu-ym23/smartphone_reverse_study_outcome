package com.bytedance.awemeopen.appserviceimpl.report;

import f34.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class ReportService$report$1$4 extends FunctionReferenceImpl implements Function1<Exception, Unit> {
    public ReportService$report$1$4(Object r100) {
        super(1, r100, c.class, "onFail", "onFail(Ljava/lang/Exception;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception r100) {
        ((c) this.receiver).onFail(r100);
    }
}
