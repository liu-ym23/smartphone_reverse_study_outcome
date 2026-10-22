package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

import hda.e1;
import hda.j0;
import hda.t1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AutoMemoryProRecordPresenter$detailView$1 extends FunctionReferenceImpl implements Function1<e1, List<? extends j0>> {
    public AutoMemoryProRecordPresenter$detailView$1(Object r100) {
        super(1, r100, f.class, "autoMemoryProBasicInfo", "autoMemoryProBasicInfo(Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewUiModel;)Ljava/util/List;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<j0> invoke2(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        f r101 = (f) this.receiver;
        f r102 = f.f387412b;
        r101.getClass();
        return t1.a(r100.f484661g, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends j0> invoke(e1 r100) {
        return invoke2(r100);
    }
}
