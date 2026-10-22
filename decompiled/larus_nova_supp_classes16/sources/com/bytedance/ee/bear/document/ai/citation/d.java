package com.bytedance.ee.bear.document.ai.citation;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.log.Log;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements Observer, FunctionAdapter {
    public final /* synthetic */ DocAICitationFragment a;

    public d(DocAICitationFragment r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof Observer) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.a, DocAICitationFragment.class, "handleUiEvent", "handleUiEvent(Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel$UiEvent;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final void onChanged(Object r7) {
        DocAICitationViewModel.b r8 = (DocAICitationViewModel.b) r7;
        DocAICitationFragment r0 = this.a;
        int r1 = DocAICitationFragment.r;
        r0.getClass();
        if ((r8 instanceof DocAICitationViewModel.b.a) == false) goto L9;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(((DocAICitationViewModel.b.a) r8).a.getUrl(), new RouteBean());
        DocAICitationViewModel r9 = r0.k;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r9 = null;
    L7:
        DocAICitationViewModel.citationCallback$default(r9, DocAICitationClickType.ReferenceOpen.getType(), null, 2, null);
        r0.ea0();
        return;
    L9:
        if (Intrinsics.areEqual(r8, DocAICitationViewModel.b.C0050b.a) == false) goto L21;
        ShowCitationData r10 = r0.q;
        if (r10 == null) goto L31;
        Context r2 = r0.getContext();
        if (r2 == null) goto L28;
        Log.i("DocAICitationFragment", "showDeleteDialog");
        BearUDDialogBuilder r3 = new BearUDDialogBuilder(r2);
        r3.a.title(2131889085);
        r3.a.titleGravity(17);
        r3.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        BearUDDialogBuilder.a r4 = new BearUDDialogBuilder.a();
        r4.a = 2131391777;
        r4.b = 2131889086;
        r4.d = 2131106622;
        r4.f = new e(r0, r10);
        r3.d(r4);
        BearUDDialogBuilder.a r5 = new BearUDDialogBuilder.a();
        r5.a = 2131391778;
        r5.b = 2131889084;
        r5.d = 2131102080;
        r5.f = new f(r0, r10);
        r3.d(r5);
        r3.a.addActionButton(2131391779, 2131887716, g.a);
        h r6 = new h(r0, r10);
        Intrinsics.checkNotNullParameter(r6, "value");
        r3.a.onDismissListener(r6);
        UDDialog r11 = r3.e();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r11);
    L20:
        r0.ea0();
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L19:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L20
    L28:
        return;
    L31:
        return;
    L21:
        if (r8 != null) goto L24;
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
