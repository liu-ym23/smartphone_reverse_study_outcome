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
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ey3.a;
import ey3.b;
import ey3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/dialog/AosCollectSuccessDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/CommonBottomDialog;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCollectSuccessDialog extends CommonBottomDialog {
    public static final /* synthetic */ int i = 0;
    public final FeedPageConfig e;
    public final String f;
    public final Function1<String, Unit> g;
    public final c h;

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog
    public final int getLayoutId() {
        return 2131558619;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void dismiss() {
        this.g.invoke("dismiss");
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
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
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void show() {
        this.g.invoke("show");
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void J0(AosCollectSuccessDialog r3) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog, com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setCanceledOnTouchOutside(true);
        ((ImageView) findViewById(2131376107)).setOnClickListener(this.h);
        setOnCancelListener(new a());
        ((Button) findViewById(2131373832)).setOnClickListener(new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ey3.c] */
    public AosCollectSuccessDialog(Context r2, FeedPageConfig r3, String r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "outContext");
        Intrinsics.checkNotNullParameter(r3, "pageConfig");
        Intrinsics.checkNotNullParameter(r5, "clickCallback");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = new c(this);
    }
}
