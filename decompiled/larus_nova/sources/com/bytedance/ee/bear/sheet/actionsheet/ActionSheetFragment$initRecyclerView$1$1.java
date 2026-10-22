package com.bytedance.ee.bear.sheet.actionsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ActionSheetFragment$initRecyclerView$1$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public ActionSheetFragment$initRecyclerView$1$1(Object r100) {
        super(1, r100, ActionSheetViewModel.class, "onClickItem", "onClickItem(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ActionSheetViewModel) this.receiver).onClickItem(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
