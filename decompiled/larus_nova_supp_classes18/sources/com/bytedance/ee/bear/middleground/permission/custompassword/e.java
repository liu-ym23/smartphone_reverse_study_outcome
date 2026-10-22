package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public e(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = (String) r4;
        if (TextUtils.isEmpty(r5) == true) goto L20;
        jg5.j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r1 = this.a.v;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.getClass();
        rh5.a r2 = (rh5.a) ((HashMap) jg5.j.e).get(r1);
        if (r2 == null) goto L18;
        r2.c(0, r5);
    L18:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L21;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    }
}
