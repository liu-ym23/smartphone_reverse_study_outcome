package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LinkVideoIntroduceDialog a;

    public g(LinkVideoIntroduceDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        IRoomModuleService r4 = k.f(IRoomModuleService.class);
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.linkvideo.b r5 = r4.getLinkVideoTea();
        if (r5 != null) goto L14;
        return;
    L14:
        if (LinkVideoIntroduceDialog.m == false) goto L16;
        String r0 = "auto_play";
    L17:
        r5.d(r0, this.a.j);
        return;
    L16:
        r0 = "active_click";
        goto L17
    L21:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L9;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
