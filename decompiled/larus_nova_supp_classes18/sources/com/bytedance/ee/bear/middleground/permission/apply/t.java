package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ ApplyPermissionPanel a;
    public final /* synthetic */ String b;

    public t(ApplyPermissionPanel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        ApplyDocPermPuller.Result r5 = (ApplyDocPermPuller.Result) r4;
        tt5.a.h("ApplyPermissionPanel", "sendRequest()...succeed");
        Toast.showSuccessText(this.a.getContext(), 2131887829);
        ApplyPermissionPanel r6 = this.a;
        int r0 = r6.i;
        String r7 = r6.j;
        if (r7 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r7 = null;
    L6:
        if (this.b.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        PermissionAnalytic.h(r0, r7, "edit", r1);
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L19;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L8:
        r1 = false;
        goto L9
    }
}
