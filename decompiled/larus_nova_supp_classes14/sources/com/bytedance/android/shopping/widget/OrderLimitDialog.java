package com.bytedance.android.shopping.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/widget/OrderLimitDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderLimitDialog extends AppCompatDialog implements View.OnClickListener {
    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 != null) goto L8;
    L10:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(this);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r3 == null) goto L24;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r2.getLooper()) goto L15;
        r2.post(DialogLancet.createDismissRunnable(this));
        return;
    L8:
        if (r1.isFinishing() != true) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L11;
        if (r1.isFinishing() != true) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I0(OrderLimitDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (Intrinsics.areEqual(r3, null) == false) goto L6;
        I0(this);
        return;
    L6:
        if (Intrinsics.areEqual(r3, null) == false) goto L10;
        I0(this);
        return;
    }
}
