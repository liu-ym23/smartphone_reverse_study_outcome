package com.bytedance.ee.bear.middleground.permission.custompassword;

import androidx.lifecycle.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public c(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((jh5.b) r3).d == false) goto L21;
        CustomPasswordSettingFragment r4 = this.a;
        int r0 = CustomPasswordSettingFragment.D;
        jh5.b r1 = (jh5.b) r4.na0().getUiResult().getValue();
        if (r1 == null) goto L22;
        r4.pa0(r1.a);     // Catch: Throwable -> L16
        ArrayList<jh5.c> r2 = r1.b;     // Catch: Throwable -> L16
        if (r2 != null) goto L11;
        r2 = new ArrayList();     // Catch: Throwable -> L16
    L11:
        ArrayList<jh5.c> r5 = r1.c;     // Catch: Throwable -> L16
        if (r5 != null) goto L14;
        r5 = new ArrayList();     // Catch: Throwable -> L16
    L14:
        r4.oa0(r2, r5);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        tt5.a.d("CustomPasswordSettingFragment", "showPasswordView " + th.getMessage());
        return;
    L22:
        return;
    }
}
