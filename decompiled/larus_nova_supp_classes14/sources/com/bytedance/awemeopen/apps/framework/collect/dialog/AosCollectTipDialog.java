package com.bytedance.awemeopen.apps.framework.collect.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ey3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/dialog/AosCollectTipDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCollectTipDialog extends LiveBottomSheetDialog {
    public static final /* synthetic */ int e = 0;

    public AosCollectTipDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void J0(AosCollectTipDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.getClass();     // Catch: Exception -> L11 Throwable -> L17
        LiveBottomSheetDialog.I0(r3);     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L11:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131558620);
        Window r3 = getWindow();
        if (r3 == null) goto L5;
        r3.setLayout(-1, -1);
    L5:
        Window r4 = getWindow();
        if (r4 == null) goto L8;
        r4.setGravity(17);
    L8:
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        RelativeLayout r5 = (RelativeLayout) findViewById(2131384677);
        if (r5 == null) goto L11;
        r5.setOnClickListener(new ey3.d(this));
    L11:
        AppCompatTextView r6 = (DmtTextView) findViewById(2131390332);
        if (r6 == null) goto L15;
        r6.setOnClickListener(new e(this));
        return;
    }
}
