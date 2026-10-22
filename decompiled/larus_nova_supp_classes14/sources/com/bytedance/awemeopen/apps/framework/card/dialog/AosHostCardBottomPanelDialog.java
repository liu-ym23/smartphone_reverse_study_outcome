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
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/card/dialog/AosHostCardBottomPanelDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/b0;", "Ls44/a;", "Landroid/app/Activity;", "getActivity", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosHostCardBottomPanelDialog extends LiveBottomSheetDialog implements b0, s44.a {
    public static final /* synthetic */ int j = 0;
    public final Activity e;
    public final r24.c f;
    public View g;
    public View h;
    public final AosBSDialogInfoManager i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final int getBottomSheetHeight() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final Dialog getDialog() {
        return this;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void show() {
        if (this.e.isFinishing() == false) goto L5;
        return;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        LiveBottomSheetDialog.I0(this);     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public Activity getActivity() {
        return this.e;
    }

    public AosHostCardBottomPanelDialog(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "hostActivity");
        super(r2);
        this.e = r2;
        d14.a r3 = b14.a.a;
        this.f = b14.a.a(r24.c.class);
        AosBSDialogInfoManager r4 = new AosBSDialogInfoManager();
        this.i = r4;
        r4.d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setCanceledOnTouchOutside(true);
        View r6 = View.inflate(getContext(), 2131558592, null);
        View r0 = AosBSDialogInfoManager.d(this.i, this, r6, new ViewGroup.LayoutParams(-1, -2));
        if (r0 == null) goto L6;
        r6 = r0;
    L6:
        setContentView(r6);
        Window r7 = getWindow();
        if (r7 == null) goto L9;
        r7.setLayout(-1, -1);
    L9:
        Window r8 = getWindow();
        if (r8 == null) goto L12;
        r8.setGravity(80);
    L12:
        LinearLayout r9 = (LinearLayout) findViewById(2131378784);
        this.g = findViewById(2131381005);
        this.h = findViewById(2131384375);
        View r10 = this.g;
        if (r10 == null) goto L15;
        r10.setOnClickListener(new b(r10, this));
    L15:
        View r11 = this.h;
        if (r11 == null) goto L18;
        r11.setOnClickListener(new c(r11, this));
    L18:
        setOnDismissListener(new com.bytedance.awemeopen.apps.framework.card.dialog.a(this));
    }
}
