package com.bytedance.awemeopen.apps.framework.card.dialog;

import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lr14/c;", "aweme", "", "invoke", "(Lr14/c;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class AosHostCardBottomPanelDialog$doReport$1 extends Lambda implements Function1<r14.c, Unit> {
    final /* synthetic */ AosHostCardBottomPanelDialog this$0;

    public AosHostCardBottomPanelDialog$doReport$1(AosHostCardBottomPanelDialog r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(r14.c r2) {
        AosEventReporter r3 = AosEventReporter.a;
        AosHostCardBottomPanelDialog r4 = this.this$0;
        int r0 = AosHostCardBottomPanelDialog.j;
        r4.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((r14.c) r1);
        return Unit.INSTANCE;
    }
}
