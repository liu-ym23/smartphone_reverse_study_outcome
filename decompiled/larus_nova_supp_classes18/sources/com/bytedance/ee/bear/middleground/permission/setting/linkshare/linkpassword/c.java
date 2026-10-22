package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements ut5.a<Boolean> {
    public final /* synthetic */ a.InterfaceC0112a a;

    public c(f r1) {
        this.a = r1;
    }

    public final void onResult(Object r2) {
        Boolean r0 = Boolean.TRUE;
        if (r0.equals((Boolean) r2) == false) goto L6;
        f r3 = (f) this.a;
        ((b) r3.a.getView()).V5();
        r3.a.b.RN();
        return;
    }

    public final void onError(int r3, Throwable r4) {
        tt5.a.e("PasswordChecker", "checkPassword failed, code: " + r3, r4, false);
        a.InterfaceC0112a r5 = this.a;
        if (r4 != null) goto L6;
        r4 = new Throwable();
    L6:
        f r6 = (f) r5;
        ((b) r6.a.getView()).V5();
        if (ax4.d.b(r4, 10017) == false) goto L10;
        ((b) r6.a.getView()).P1();
        return;
    L10:
        if (ax4.d.b(r4, 10018) == false) goto L12;
        Context r7 = r6.a.a;
        Toast.showFailureText(r7, r7.getString(2131888105), 0);
        return;
    L12:
        Context r8 = r6.a.a;
        Toast.showFailureText(r8, r8.getString(2131887674), 0);
    }
}
