package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LinkTagEditorPanel$selectedAdapter$1 extends FunctionReferenceImpl implements Function1<LinkTagOptionModel, Unit> {
    public LinkTagEditorPanel$selectedAdapter$1(Object r100) {
        super(1, r100, b.class, "onSelectedItemRemoved", "onSelectedItemRemoved(Lcom/bytedance/ee/bear/bitable/celleditor/editor/linktag/LinkTagOptionModel;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LinkTagOptionModel r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        b r101 = (b) this.receiver;
        r101.getClass();
        if (r100.getId() != null) goto L5;
        return;
    L5:
        LinkTagEditorModel r102 = r101.f209404p;
        if (r102 == null) goto L9;
        Intrinsics.areEqual(r102.getEnableMultiSelect(), Boolean.FALSE);
    L9:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LinkTagOptionModel r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
