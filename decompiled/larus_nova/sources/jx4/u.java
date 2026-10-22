package jx4;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.debug.LoadingView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes16.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingView f500859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f500860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f500861c;

    public final void b() {
        if (this.f500860b == null) goto L12;
        LoadingView r100 = this.f500859a;     // Catch: Exception -> L9
        if (r100.f217357e == null) goto L7;
        r100.clearAnimation();     // Catch: Exception -> L9
        r100.f217357e.setRepeatCount(1);     // Catch: Exception -> L9
        r100.f217357e.cancel();     // Catch: Exception -> L9
        r100.f217357e.end();     // Catch: Exception -> L9
    L7:
        a(this.f500860b);     // Catch: Exception -> L9
        this.f500860b = null;     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public final void c() {
        Dialog r100 = this.f500860b;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r100);
    L7:
        LoadingView r101 = this.f500859a;
        if (r101.f217357e == null) goto L10;
        r101.clearAnimation();
        r101.f217357e.setRepeatCount(1);
        r101.f217357e.cancel();
        r101.f217357e.end();
    L10:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.f217357e = r102;
        r102.setDuration(1000);
        r101.f217357e.setInterpolator(new LinearInterpolator());
        r101.f217357e.setRepeatCount(-1);
        r101.f217357e.setRepeatMode(1);
        r101.f217357e.addUpdateListener(new v(r101));
        r101.f217357e.addListener(new w());
        if (r101.f217357e.isRunning() == true) goto L17;
        r101.f217357e.start();
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        goto L7
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public u(Context r100, String r101) {
        View r102 = LayoutInflater.from(r100).inflate(R.layout.loading_dialog_view, null);
        LinearLayout r103 = (LinearLayout) r102.findViewById(R.id.dialog_view);
        this.f500859a = (LoadingView) r102.findViewById(R.id.loading_view);
        TextView r104 = (TextView) r102.findViewById(R.id.loading_text);
        this.f500861c = r104;
        r104.setText(r101);
        Dialog r105 = new Dialog(r100, R.style.loading_dialog);
        this.f500860b = r105;
        r105.setContentView(r103, new LinearLayout.LayoutParams(-1, -1));
    }
}
