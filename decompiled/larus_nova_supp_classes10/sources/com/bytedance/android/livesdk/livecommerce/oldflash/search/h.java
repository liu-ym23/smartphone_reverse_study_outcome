package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LiveFlashSearchDialogFragment a;

    public h(LiveFlashSearchDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == true) goto L12;
        return;
    L12:
        this.a.dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L15;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
