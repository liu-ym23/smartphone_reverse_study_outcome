package vb4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.bytedance.bdturing.livedetect.TuringLiveDetectWebActivity;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements sb4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554044a;

    @Override // sb4.l
    public final void a() {
        TuringLiveDetectActivity r100 = this.f554044a;
        int r101 = TuringLiveDetectActivity.f201828y;
        r100.getClass();
        TuringLiveDetectWebActivity.startActivity(r100, e.b(), r100.getString(R.string.turing_live_detect_help));
    }

    @Override // sb4.l
    public final void b() {
        sb4.k r100 = this.f554044a.f201842q;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f554044a.I1();
    }

    @Override // sb4.l
    public final void onCancel() {
        this.f554044a.finish();
    }

    public q(TuringLiveDetectActivity r100) {
        this.f554044a = r100;
    }
}
