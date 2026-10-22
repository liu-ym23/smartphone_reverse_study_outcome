package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ApplyAuditEscapePanel a;

    public d(ApplyAuditEscapePanel r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        DefaultResponse r3 = (DefaultResponse) r2;
        Toast.cancelLoading();
        Toast.showSuccessText(this.a.getContext(), 2131887829);
        tt5.a.h("ApplyAuditEscapePanel", "sendRequest()...succeed");
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
