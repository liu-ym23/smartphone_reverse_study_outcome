package com.bytedance.awemeopen.apps.framework.card.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBSDialogInfoManager;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/dialog/AosHostCardBottomPanelDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/b0;", "Ls44/a;", "Landroid/app/Activity;", "getActivity", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosHostCardBottomPanelDialog extends LiveBottomSheetDialog implements b0, s44.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f193818j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Activity f193819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r24.c f193820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f193821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f193822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AosBSDialogInfoManager f193823i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final int getBottomSheetHeight() {
        return -1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final Dialog getDialog() {
        return this;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (this.f193819e.isFinishing() == false) goto L5;
        return;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        LiveBottomSheetDialog.I0(this);     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public Activity getActivity() {
        return this.f193819e;
    }

    public AosHostCardBottomPanelDialog(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "hostActivity");
        super(r100);
        this.f193819e = r100;
        d14.a r101 = b14.a.f16924a;
        this.f193820f = (r24.c) b14.a.a(r24.c.class);
        AosBSDialogInfoManager r102 = new AosBSDialogInfoManager();
        this.f193823i = r102;
        r102.f196850d = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        View r101 = View.inflate(getContext(), R.layout.aos_card_dialog_bottom_panel, null);
        View r102 = AosBSDialogInfoManager.d(this.f193823i, this, r101, new ViewGroup.LayoutParams(-1, -2));
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        setContentView(r101);
        Window r103 = getWindow();
        if (r103 == null) goto L9;
        r103.setLayout(-1, -1);
    L9:
        Window r104 = getWindow();
        if (r104 == null) goto L12;
        r104.setGravity(80);
    L12:
        LinearLayout r105 = (LinearLayout) findViewById(R.id.ll_panel_dialog_container);
        this.f193821g = findViewById(R.id.not_interesting_ll);
        this.f193822h = findViewById(R.id.report_ll_inner);
        View r106 = this.f193821g;
        if (r106 == null) goto L15;
        r106.setOnClickListener(new b(r106, this));
    L15:
        View r107 = this.f193822h;
        if (r107 == null) goto L18;
        r107.setOnClickListener(new c(r107, this));
    L18:
        setOnDismissListener(new com.bytedance.awemeopen.apps.framework.card.dialog.a(this));
    }
}
