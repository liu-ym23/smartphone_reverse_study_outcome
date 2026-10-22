package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import hda.e1;
import hda.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PersonalMemoryRecordPresenter$detailView$1 extends FunctionReferenceImpl implements Function1<e1, List<? extends j0>> {
    public PersonalMemoryRecordPresenter$detailView$1(Object r100) {
        super(1, r100, e.class, "personalMemoryBasicInfo", "personalMemoryBasicInfo(Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewUiModel;)Ljava/util/List;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<j0> invoke2(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        e r101 = (e) this.receiver;
        e r102 = e.f387442b;
        r101.getClass();
        return e.m(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends j0> invoke(e1 r100) {
        return invoke2(r100);
    }
}
