package w0b;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f557827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadingView f557828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f557829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f557830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f557831e;

    public static void a(Dialog r100) {
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

    public a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f557827a = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.cml_debug_download_progress_view, null);
        LinearLayout r103 = (LinearLayout) r102.findViewById(R.id.cml_debug_dialog_view);
        this.f557828b = (LoadingView) r102.findViewById(R.id.cml_debug_load_view);
        TextView r104 = (TextView) r102.findViewById(R.id.cml_debug_loading_text);
        this.f557829c = r104;
        if (r104 == null) goto L5;
        r104.setText(this.f557827a);
    L5:
        Dialog r105 = new Dialog(r100, R.style.chameleon_debug_loading_dialog);
        r105.setContentView(r103, new LinearLayout.LayoutParams(-1, -1));
        r105.setCancelable(false);
        this.f557830d = r105;
    }
}
