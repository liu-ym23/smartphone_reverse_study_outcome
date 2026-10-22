package com.bytedance.awemeopen.apps.framework.collect.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import ey3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/dialog/AosCollectTipDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCollectTipDialog extends LiveBottomSheetDialog {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f193980e = 0;

    public AosCollectTipDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public static void J0(AosCollectTipDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.getClass();     // Catch: Exception -> L11 Throwable -> L17
        LiveBottomSheetDialog.I0(r100);     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.aos_dialog_collect_tips);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(17);
    L8:
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        RelativeLayout r103 = (RelativeLayout) findViewById(R.id.rl_collect_container);
        if (r103 == null) goto L11;
        r103.setOnClickListener(new ey3.d(this));
    L11:
        DmtTextView r104 = (DmtTextView) findViewById(R.id.tv_collect_tips_dialog_confirm);
        if (r104 == null) goto L15;
        r104.setOnClickListener(new e(this));
        return;
    }
}
