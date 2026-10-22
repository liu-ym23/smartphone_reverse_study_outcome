package com.bytedance.awemeopen.appserviceimpl.report;

import f34.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class ReportService$report$1$6 extends FunctionReferenceImpl implements Function0<Unit> {
    public ReportService$report$1$6(Object r100) {
        super(0, r100, c.class, "onDuplication", "onDuplication()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((c) this.receiver).c();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
