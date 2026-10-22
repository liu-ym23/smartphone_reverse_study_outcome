package g15;

import android.R;
import android.app.Dialog;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements rw4.a {
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e a;

    @Override // rw4.a
    public final void onPolling(int r1) {
    }

    @Override // rw4.a
    public final void onStartPolling() {
    }

    @Override // rw4.a
    public final void onDismiss() {
        tt5.a.h("DocumentExportAction", "minutes audio export dismissed");
        this.a.l();
    }

    @Override // rw4.a
    public final void onExportStart() {
        tt5.a.h("DocumentExportAction", "minutes audio export start");
        final com.bytedance.ee.bear.document.export.e r0 = this.a;
        if (r0.a.isFinishing() == false) goto L5;
    L20:
        tt5.a.k("DocumentExportAction", "showMinutesAudioLoading fail, activity is invalid");
        return;
    L5:
        if (r0.a.isDestroyed() == true) goto L20;
        r0.l();
        Dialog r2 = new Dialog(r0.a, R.style.Theme.Translucent.NoTitleBar);
        r0.g = r2;
        r2.setOnDismissListener(new c(r0));
        Window r3 = r0.g.getWindow();
        if (r3 == null) goto L10;
        r3.setLayout(-1, -1);
        r3.addFlags(2);
        r3.setDimAmount(0.4f);
    L10:
        OpenLoadingView r4 = new OpenLoadingView(r0.a);
        r0.i = r4;
        r4.setCancelClickListener(new d(r0));
        FrameLayout r5 = new FrameLayout(r0.a);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 17;
        r5.addView(r0.i, r6);
        r0.g.setContentView(r5, new ViewGroup.LayoutParams(-1, -1));
        r0.g.setCancelable(false);
        Dialog r7 = r0.g;     // Catch: WindowManager.BadTokenException -> L18
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r7);     // Catch: WindowManager.BadTokenException -> L18
    L23:
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L16:
        DialogLancet.beforeDialogShow(r7);     // Catch: WindowManager.BadTokenException -> L18
        r7.show();     // Catch: WindowManager.BadTokenException -> L18
        DialogLancet.afterDialogShow(r7);     // Catch: WindowManager.BadTokenException -> L18
    L18:
        e = move-exception;
        tt5.a.l("DocumentExportAction", "showMinutesAudioLoading fail, bad token", e);
        r0.l();
    }

    @Override // rw4.a
    public final void onStartDownload() {
        OpenLoadingView r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.setProgress(20);
        return;
    }

    public u(com.bytedance.ee.bear.document.export.e r1) {
        this.a = r1;
    }

    @Override // rw4.a
    public final void onDownloading(int r2) {
        OpenLoadingView r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.setProgress(r2);
        return;
    }

    @Override // rw4.a
    public final void onSuccess(Uri r4) {
        tt5.a.h("DocumentExportAction", "minutes audio export success, uri = " + r4);
        this.a.l();
        com.bytedance.ee.bear.document.export.e r0 = this.a;
        r0.l = 0;
        r0.m = null;
        com.bytedance.ee.bear.document.export.e.d(r0, "audio");
        UDToast.show(this.a.a, this.a.a.getString(2131887288) + c1.c(this.a.a, r4), 2131256306);
    }

    @Override // rw4.a
    public final void onFail(int r4, Throwable r5) {
        tt5.a.e("DocumentExportAction", "minutes audio export fail, code = " + r4, r5, false);
        this.a.l();
        com.bytedance.ee.bear.document.export.e.c(this.a, r4, r5);
        com.bytedance.ee.bear.document.export.e.b(this.a, "audio");
        Toast.showFailureText(this.a.a, 2131887258);
    }
}
