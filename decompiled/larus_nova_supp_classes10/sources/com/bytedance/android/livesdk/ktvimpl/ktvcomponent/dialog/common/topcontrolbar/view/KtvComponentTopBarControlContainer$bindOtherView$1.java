package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.BusinessSwitchState;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class KtvComponentTopBarControlContainer$bindOtherView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ KtvComponentTopBarControlContainer this$0;

    public KtvComponentTopBarControlContainer$bindOtherView$1(KtvComponentTopBarControlContainer r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(View r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        Object r6 = r5.getTag();
        if (r6 != BusinessSwitchState.MULTI_CHORUS) goto L10;
        com.bytedance.android.livesdk.ktvimpl.multichorus.c.g(this.this$0.getContext(), true, 2);
        final MusicPanel r7 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r7 == null) goto L17;
        MultiChorusContext.Companion.e(r7, new KtvComponentTopBarControlContainer$bindOtherView$1$$special$$inlined$let$lambda$1(r7, this), KtvComponentTopBarControlContainer$bindOtherView$1$1$2.INSTANCE);
        if (com.bytedance.android.livesdk.ktvimpl.multichorus.c.b(r7) == true) goto L18;
        we2.a.e(r7, "request_tab", "join_chorus");
        return;
    L18:
        return;
    L17:
        return;
    L10:
        if (r6 != BusinessSwitchState.NOT_SING) goto L20;
        final MusicPanel r8 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r8 == null) goto L21;
        MultiChorusContext.Companion.f(r8, new KtvComponentTopBarControlContainer$bindOtherView$1$$special$$inlined$let$lambda$2(r8, this), KtvComponentTopBarControlContainer$bindOtherView$1$2$2.INSTANCE);
        if (com.bytedance.android.livesdk.ktvimpl.multichorus.c.b(r8) == true) goto L22;
        we2.a.e(r8, "request_tab", "leave_chorus");
        return;
    L22:
        return;
    L21:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
