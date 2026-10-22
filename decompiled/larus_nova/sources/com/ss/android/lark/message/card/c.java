package com.ss.android.lark.message.card;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import jrb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static boolean a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (r101.toLowerCase().startsWith("lark://msgcard/unsupported_action") == false) goto L10;
        d r102 = d.f500167f;
        OPMonitor r103 = jrb.c.a(r102);
        r103.setErrorMessage(r102.message);
        r103.flush();
        LKUIToast.show(r100, R.string.Lark_Legacy_MsgCardUnsupportedActionMobile);
        return true;
    L10:
        return false;
    }
}
