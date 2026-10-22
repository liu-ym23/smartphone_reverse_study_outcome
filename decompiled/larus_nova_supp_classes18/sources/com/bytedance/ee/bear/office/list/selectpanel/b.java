package com.bytedance.ee.bear.office.list.selectpanel;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Fragment a;
    public final Function3<d, List<? extends Document>, Boolean, Unit> b;
    public final Function0<Unit> c;
    public final Function1<Integer, Unit> d;
    public OfficeSelectPanelDialog e;
    public List<? extends Document> f;
    public boolean g;

    public final void a() {
        OfficeSelectPanelDialog r0 = this.e;
        if (r0 != null) goto L8;
        Fragment r1 = this.a.getChildFragmentManager().findFragmentByTag("OfficeSelectPanelDialog");
        if ((r1 instanceof OfficeSelectPanelDialog) == false) goto L7;
        r0 = (OfficeSelectPanelDialog) r1;
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L17;
    L15:
        this.e = null;
        this.f = CollectionsKt.emptyList();
        this.d.invoke(0);
        return;
    L17:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L15;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Fragment r2, Function3<? super d, ? super List<? extends Document>, ? super Boolean, Unit> r3, Function0<Unit> r4, Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "onActionClick");
        Intrinsics.checkNotNullParameter(r4, "onBackClick");
        Intrinsics.checkNotNullParameter(r5, "onHeightChanged");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = CollectionsKt.emptyList();
    }
}
