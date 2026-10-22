package com.ss.android.lark.filedetail.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final void a(Context r100, boolean r101, DialogInterface.OnDismissListener r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = y9c.d.i(r100, R.string.Lark_ChatFileStorage_ChatFileNotFoundDialogTitle);
        if (r101 == false) goto L5;
        String r104 = y9c.d.i(r100, R.string.Lark_ChatFileStorage_ChatFileNotFoundDialogOver90Days);
        Intrinsics.checkNotNull(r104);
    L6:
        com.larksuite.component.ui.dialog.d r105 = new com.larksuite.component.ui.dialog.d(r100);
        r105.k(r103);
        r105.h(r104);
        r105.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_IKnow, null);
        r105.f284132c.onDismissListener(r102);
        LKUIDialog r106 = r105.c();
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L5:
        r104 = y9c.d.i(r100, R.string.Lark_ChatFileStorage_ChatFileNotFoundDialogWithin90Days);
        Intrinsics.checkNotNull(r104);
        goto L6
    }
}
