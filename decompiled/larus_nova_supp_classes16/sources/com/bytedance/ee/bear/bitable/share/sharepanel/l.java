package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

    public l(FormsQRCodePanelFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function0<Unit> r3 = this.a.s;
        if (r3 == null) goto L13;
        r3.invoke();
    L13:
        this.a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L15;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
