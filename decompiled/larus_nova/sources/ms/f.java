package ms;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.a1;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f515453a;

    public f(a r100) {
        this.f515453a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f515453a;
        if (r101.f515095f != 1) goto L7;
        y0 r102 = y0.f52963a;
        r102.h(r101.getContext(), r101.f515093d, r101.f515094e, false);
        r102.a(this.f515453a.getContext(), this.f515453a.f515093d);
        if (a1.b().getInt("gamecp.key.DOWNLOAD_PAUSE_MOBLE_DATA_TOAST", 0) != 0) goto L7;
        ToastUtil.a(R.string.gamecp_download_pause_mobile_data_tips_dialog_toast);
        a1.a().putInt("gamecp.key.DOWNLOAD_PAUSE_MOBLE_DATA_TOAST", 1).apply();
    L7:
        a r103 = this.f515453a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r105 == null) goto L21;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r104.getLooper()) goto L12;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
