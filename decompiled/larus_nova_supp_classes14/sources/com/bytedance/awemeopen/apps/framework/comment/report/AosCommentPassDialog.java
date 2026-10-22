package com.bytedance.awemeopen.apps.framework.comment.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/report/AosCommentPassDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/CommonBottomDialog;", "a", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosCommentPassDialog extends CommonBottomDialog {
    public static final /* synthetic */ int k = 0;
    public RelativeLayout e;
    public RelativeLayout f;
    public a g;
    public b h;
    public boolean i;
    public boolean j;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.CommonBottomDialog
    public final int getLayoutId() {
        return 2131558601;
    }

    public final void L0() {
        RelativeLayout r0 = this.e;
        int r1 = 0;
        if (r0 != null) goto L6;
    L10:
        RelativeLayout r2 = this.f;
        if (r2 != null) goto L14;
        return;
    L14:
        if (this.i == true) goto L17;
        r1 = 8;
    L17:
        r2.setVisibility(r1);
        return;
    L6:
        if (this.j == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        goto L10
    L8:
        r3 = 8;
        goto L9
    }

    public AosCommentPassDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void J0(AosCommentPassDialog r3) {
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
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setLayout(-1, -2);
    L5:
        this.e = (RelativeLayout) findViewById(2131384368);
        this.f = (RelativeLayout) findViewById(2131368773);
        RelativeLayout r5 = this.e;
        if (r5 == null) goto L8;
        r5.setOnClickListener(new oy3.a(this));
    L8:
        RelativeLayout r6 = this.f;
        if (r6 == null) goto L11;
        r6.setOnClickListener(new oy3.b(this));
    L11:
        L0();
    }
}
