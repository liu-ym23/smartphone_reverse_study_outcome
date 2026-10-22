package com.bytedance.ee.bear.document.alert;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public final Activity a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public UDDialog d;
    public gp5.a e;

    public static final class a {
    }

    static {
    }

    public static int d(int r1) {
        if (r1 != 1) goto L5;
        return 2131102093;
    L5:
        if (r1 == 2) goto L7;
        return 2131106622;
    L7:
        return 2131105548;
    }

    public r(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
    }

    public static void a(UDDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static void c(r r2, String r3, String r4, tb5.m r5, boolean r6, Boolean r7, String r8, int r9) {
        if ((r9 & 8) == 0) goto L6;
        r6 = true;
    L6:
        if ((r9 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 32) == 0) goto L11;
        r8 = null;
    L11:
        r2.getClass();
        JSONObject r10 = new JSONObject();
        r10.put("id", r3);
        r10.put("input", r4);
        if (r7 == null) goto L14;
        r7.booleanValue();
        r10.put("isChecked", r7);
    L14:
        if (r8 == null) goto L16;
        r10.put("selectedRadioId", r8);
    L16:
        r5.b(r10);
        if (r6 == false) goto L22;
        UDDialog r11 = r2.d;
        if (r11 == null) goto L23;
        a(r11);
        return;
    L23:
        return;
    }
}
