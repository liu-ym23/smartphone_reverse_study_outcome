package com.bytedance.ee.bear.sheet.actionsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ActionSheetFragment$initRecyclerView$1$2 extends FunctionReferenceImpl implements Function2<c, f, Unit> {
    public ActionSheetFragment$initRecyclerView$1$2(Object r100) {
        super(2, r100, ActionSheetViewModel.class, "onClickItemRightIcon", "onClickItemRightIcon(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((ActionSheetViewModel) this.receiver).onClickItemRightIcon(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(c r100, f r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
