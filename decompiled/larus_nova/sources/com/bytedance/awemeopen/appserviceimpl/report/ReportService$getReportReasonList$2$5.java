package com.bytedance.awemeopen.appserviceimpl.report;

import com.bytedance.awemeopen.domain.report.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class ReportService$getReportReasonList$2$5 extends FunctionReferenceImpl implements Function1<List<? extends d>, Unit> {
    public ReportService$getReportReasonList$2$5(Object r100) {
        super(1, r100, f34.d.class, "onSuccess", "onSuccess(Ljava/util/List;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<d> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((f34.d) this.receiver).onSuccess(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends d> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
