package com.bytedance.ee.bear.sheet.actionsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ActionSheetFragment$initRecyclerView$1$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public ActionSheetFragment$initRecyclerView$1$1(Object r8) {
        super(1, r8, ActionSheetViewModel.class, "onClickItem", "onClickItem(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;)V", 0);
    }

    public final void invoke(c r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ActionSheetViewModel) ((CallableReference) this).receiver).onClickItem(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
