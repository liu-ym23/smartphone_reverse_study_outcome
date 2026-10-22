package com.bytedance.ee.bear.sheet.actionsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ActionSheetFragment$initRecyclerView$1$2 extends FunctionReferenceImpl implements Function2<c, f, Unit> {
    public ActionSheetFragment$initRecyclerView$1$2(Object r8) {
        super(2, r8, ActionSheetViewModel.class, "onClickItemRightIcon", "onClickItemRightIcon(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;)V", 0);
    }

    public final void invoke(c r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        ((ActionSheetViewModel) ((CallableReference) this).receiver).onClickItemRightIcon(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((c) r1, (f) r2);
        return Unit.INSTANCE;
    }
}
