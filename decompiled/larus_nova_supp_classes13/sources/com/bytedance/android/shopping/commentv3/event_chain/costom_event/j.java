package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.view.SheetPanelDialog;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;

    public j(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.OPEN_SHEET_PANEL.getType());
        this.d = r2;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r8, fc3.a r9, fc3.c r10, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "eventContext");
        Intrinsics.checkNotNullParameter(r9, "actionContext");
        Intrinsics.checkNotNullParameter(r10, "handleActionParams");
        Intrinsics.checkNotNullParameter(r11, "completion");
        Map r12 = r8.k;
        if (r12 == null) goto L5;
        Object r13 = r12.get("panel_show_action");
    L7:
        if ((r13 instanceof Map) == true) goto L9;
        r13 = null;
    L9:
        Map r4 = (Map) r13;
        Map r14 = r8.k;
        if (r14 == null) goto L12;
        Object r15 = r14.get("panel_close_action");
    L14:
        if ((r15 instanceof Map) == true) goto L16;
        r15 = null;
    L16:
        Map r5 = (Map) r15;
        Map r16 = r8.k;
        if (r16 == null) goto L19;
        Object r17 = r16.get("panel_cell_list");
    L21:
        if ((r17 instanceof List) == true) goto L23;
        r17 = null;
    L23:
        List r6 = (List) r17;
        List r18 = r6;
        if (r18 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == false) goto L33;
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r11.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "panel_cell_list is empty", null, null, 57));
        return;
    L33:
        BottomSheetDialog r21 = new SheetPanelDialog(this.d, r9, r4, r5, r6);
        if (DialogLancet.shouldBlockDialogShow(r21) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r21);
    L38:
        int r22 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r11.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L37:
        DialogLancet.beforeDialogShow(r21);
        r21.show();
        DialogLancet.afterDialogShow(r21);
        goto L38
    L26:
        if (r18.isEmpty() == true) goto L29;
        r19 = false;
        goto L30
    L19:
        r17 = null;
        goto L21
    L12:
        r15 = null;
        goto L14
    L5:
        r13 = null;
        goto L7
    }
}
