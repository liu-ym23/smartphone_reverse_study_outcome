package com.bytedance.android.shopping.order;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ PreviewPanelFragment a;

    public d(PreviewPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L17:
        if (r4 != null) goto L20;
        return;
    L20:
        if (r4.intValue() != 2) goto L29;
        a r5 = this.a.d;
        if (r5 == null) goto L30;
        r5.onFailed();
        return;
    L30:
        return;
    L29:
        return;
    L6:
        if (r4.intValue() != 1) goto L17;
        a r6 = this.a.d;
        if (r6 == null) goto L25;
        r6.a();
    L25:
        this.a.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L27;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
