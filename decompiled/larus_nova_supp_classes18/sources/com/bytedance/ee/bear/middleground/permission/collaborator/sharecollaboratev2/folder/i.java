package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends t {
    public final /* synthetic */ f c;

    public i(f r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        com.bytedance.ee.bear.middleground.permission.c.V("restore", "ccm_permission_lock_restore_view");
        f r6 = this.c;
        r6.getClass();
        Context r0 = r6.getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r0);
        r1.autoDismiss(true);
        r1.title(2131887510);
        r1.message(2131887279);
        r1.messageGravity(8388611);
        g r2 = new g(r6);
        r1.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887719).textColorRes(2131101119).onClickListener(r2));
        r1.addActionButton(2131391778, 2131887716, h.a);
        r1.animStyle(2131954061);
        Dialog r3 = r1.build();
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r3);
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(r6.h, r6.getType(), r3);
        com.bytedance.ee.bear.middleground.permission.c.Z();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        goto L7
    }
}
