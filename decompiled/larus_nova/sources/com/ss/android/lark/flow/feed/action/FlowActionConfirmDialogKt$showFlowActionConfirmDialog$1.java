package com.ss.android.lark.flow.feed.action;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.foundation.dialog.FlowAlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/foundation/dialog/FlowAlertDialog;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowActionConfirmDialogKt$showFlowActionConfirmDialog$1 extends Lambda implements Function1<FlowAlertDialog, Unit> {
    final /* synthetic */ Function0<Unit> $onConfirm;

    public FlowActionConfirmDialogKt$showFlowActionConfirmDialog$1(Function0<Unit> r100) {
        this.$onConfirm = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FlowAlertDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$onConfirm.invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FlowAlertDialog r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
