package com.bytedance.android.shopping.sameproduct.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/widget/ECCommissionDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCommissionDialog extends AppCompatDialog implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public TextView c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Context r0 = getContext();
        Context r2 = null;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 != null) goto L8;
    L9:
        Context r3 = getContext();
        if ((r3 instanceof Activity) == false) goto L13;
        r2 = r3;
    L13:
        Activity r4 = (Activity) r2;
        if (r4 != null) goto L16;
    L18:
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(this);
        return;
    L28:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r6 == null) goto L32;
        d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L21:
        if (Looper.myLooper() == r5.getLooper()) goto L23;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    L16:
        if (r4.isDestroyed() != true) goto L18;
        return;
    L8:
        if (r1.isFinishing() != true) goto L9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECCommissionDialog(Context r1) {
        super(r1);
        setContentView(2131560651);
        this.a = (TextView) findViewById(2131370699);
        this.b = (TextView) findViewById(2131370698);
        TextView r2 = (TextView) findViewById(2131370697);
        this.c = r2;
        if (r2 == null) goto L5;
        r2.setOnClickListener(this);
    L5:
        setCanceledOnTouchOutside(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getId() != 2131370697) goto L26;
        Handler r4 = DialogLancet.resolveDialogHandler(this);
        if (r4 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r5 == null) goto L19;
        d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r4.getLooper()) goto L10;
        r4.post(DialogLancet.createDismissRunnable(this));
        return;
    }
}
