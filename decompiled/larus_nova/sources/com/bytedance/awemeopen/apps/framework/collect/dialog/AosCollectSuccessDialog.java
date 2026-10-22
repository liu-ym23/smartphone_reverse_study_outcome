package com.bytedance.awemeopen.apps.framework.collect.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ey3.a;
import ey3.b;
import ey3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/dialog/AosCollectSuccessDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/CommonBottomDialog;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCollectSuccessDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f193975i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FeedPageConfig f193976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f193977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<String, Unit> f193978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f193979h;

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.aos_dialog_collect_success;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f193978g.invoke("dismiss");
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        this.f193978g.invoke("show");
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public static void J0(AosCollectSuccessDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        ((ImageView) findViewById(R.id.iv_close)).setOnClickListener(this.f193979h);
        setOnCancelListener(new a());
        ((Button) findViewById(R.id.go_collect_btn)).setOnClickListener(new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ey3.c] */
    public AosCollectSuccessDialog(Context r100, FeedPageConfig r101, String r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "outContext");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        Intrinsics.checkNotNullParameter(r103, "clickCallback");
        super(r100);
        this.f193976e = r101;
        this.f193977f = r102;
        this.f193978g = r103;
        this.f193979h = new c(this);
    }
}
