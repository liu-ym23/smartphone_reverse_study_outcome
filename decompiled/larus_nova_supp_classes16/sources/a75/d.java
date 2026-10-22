package a75;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.UploadListFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends BaseTitleBar.e {
    public final /* synthetic */ UploadListFragment j;

    public final void performAction(View r7) {
        com.bytedance.ee.bear.drive.report.c r8 = o75.b.a().Ke();
        r8.I("", "", "cancel_upload_batch");
        r8.o("cancel", "ccm_drive_stop_upload_confirm_view", this.j.m);
        r8.A("ccm_drive_stop_upload_confirm_view", r8.i(null));
        UploadListFragment r0 = this.j;
        Dialog r1 = r0.h;
        if (r1 != null) goto L6;
        Context r2 = r0.getContext();
        final b75.c r3 = new b75.c(r2, r8);
        r3.b = new c(this);
        BearUDDialogBuilder r9 = new BearUDDialogBuilder(r2);
        r9.a.message(2131888452);
        r9.b(2131391777, 2131888375, 2131105548, new b75.a(r3));
        r9.b(2131391778, 2131888370, 2131106622, new b75.b(r3));
        r9.a.style(2131951622);
        r0.h = r9.h();
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public d(UploadListFragment r1, CharSequence r2) {
        this.j = r1;
        super(r2, 2131105548);
    }
}
