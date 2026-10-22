package com.larus.office;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfflineDocReportGate$coordinator$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public OfflineDocReportGate$coordinator$2(Object r100) {
        super(1, r100, OfflineDocReportGate.class, "log", "log(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        OfflineDocReportGate r101 = (OfflineDocReportGate) this.receiver;
        OfflineDocReportGate r102 = OfflineDocReportGate.f360434a;
        r101.getClass();
        OfflineDocReportGate.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
