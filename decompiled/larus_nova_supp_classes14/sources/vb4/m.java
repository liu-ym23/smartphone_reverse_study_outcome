package vb4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity;
import com.bytedance.bdturing.livedetect.a;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements sb4.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ TuringLiveByteNNActivity b;

    public final void a() {
        EventReport.r(3, 1, this.a, this.b.v);
        this.b.finish();
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity, com.bytedance.bdturing.livedetect.a$c, java.lang.Object] */
    public final void b() {
        sb4.k r0 = this.b.q;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        EventReport.r(3, 2, this.a, this.b.v);
        if (this.b.A.get() == false) goto L27;
        if (this.b.z.get() == true) goto L27;
        ?? r3 = this.b;
        r3.B1(r3.getString(2131923576));
        a.f().e(r3.getClass().getName(), r3);
        return;
    L27:
        if (this.b.A.get() == false) goto L29;
    L31:
        this.b.finish();
        return;
    L29:
        if (this.b.z.get() == false) goto L31;
        TuringLiveByteNNActivity r4 = this.b;
        r4.getClass();
        LiveDetectService.getInstance().loadByteNNInNeed(r4.getClass().getName(), r4.C);
    }

    public final void onCancel() {
        EventReport.r(3, 3, this.a, this.b.v);
        this.b.finish();
    }

    public m(TuringLiveByteNNActivity r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
