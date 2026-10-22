package com.bytedance.awemeopen.apps.framework.comment.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/report/AosCommentPassDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCommentPassDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f194171k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RelativeLayout f194172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f194173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f194174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f194175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f194176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f194177j;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.aos_comment_report_fragment;
    }

    public final void L0() {
        RelativeLayout r100 = this.f194172e;
        int r101 = 0;
        if (r100 != null) goto L6;
    L10:
        RelativeLayout r102 = this.f194173f;
        if (r102 != null) goto L14;
        return;
    L14:
        if (this.f194176i == true) goto L17;
        r101 = 8;
    L17:
        r102.setVisibility(r101);
        return;
    L6:
        if (this.f194177j == false) goto L8;
        int r103 = 0;
    L9:
        r100.setVisibility(r103);
        goto L10
    L8:
        r103 = 8;
        goto L9
    }

    public AosCommentPassDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public static void J0(AosCommentPassDialog r100) {
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
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -2);
    L5:
        this.f194172e = (RelativeLayout) findViewById(R.id.report_comment);
        this.f194173f = (RelativeLayout) findViewById(R.id.del_comment);
        RelativeLayout r102 = this.f194172e;
        if (r102 == null) goto L8;
        r102.setOnClickListener(new oy3.a(this));
    L8:
        RelativeLayout r103 = this.f194173f;
        if (r103 == null) goto L11;
        r103.setOnClickListener(new oy3.b(this));
    L11:
        L0();
    }
}
