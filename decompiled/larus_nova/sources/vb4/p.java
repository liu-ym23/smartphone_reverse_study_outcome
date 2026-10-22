package vb4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements sb4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554043a;

    @Override // sb4.l
    public final void a() {
        EventReport.r(1, 1, "", this.f554043a.f201847v);
        this.f554043a.finish();
    }

    @Override // sb4.l
    public final void b() {
        sb4.k r100 = this.f554043a.f201842q;
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
        EventReport.r(1, 2, "", this.f554043a.f201847v);
        this.f554043a.I1();
    }

    @Override // sb4.l
    public final void onCancel() {
        EventReport.r(1, 3, "", this.f554043a.f201847v);
        this.f554043a.finish();
    }

    public p(TuringLiveDetectActivity r100) {
        this.f554043a = r100;
    }
}
