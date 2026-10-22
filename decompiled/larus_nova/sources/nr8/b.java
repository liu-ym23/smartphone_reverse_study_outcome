package nr8;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import hq9.n3;
import hq9.q3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3 f520206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f520207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f520208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f520209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f520210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f520211f;

    public abstract void b();

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        FLogger.f375446a.i("NotificationControlManager", "onDetachedFromWindow");
        if (this.f520209d == true) goto L5;
        t0.f375468a.removeCallbacks(this.f520211f);
    L5:
        s r100 = this.f520210e;
        if (r100 == null) goto L8;
        r100.a();
    L8:
        super.onDetachedFromWindow();
    }

    public static void a(b r100) {
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

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        FLogger.f375446a.i("AbsInnerNotificationDialog", "show");
        b();
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setGravity(48);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        WindowManager.LayoutParams r103 = r102.getAttributes();
    L9:
        if (r103 == null) goto L11;
        r103.width = -1;
    L11:
        if (r103 == null) goto L13;
        r103.height = -2;
    L13:
        if (r103 == null) goto L15;
        r103.flags = 8;
    L15:
        Window r104 = getWindow();
        if (r104 == null) goto L18;
        r104.setAttributes(r103);
    L18:
        Window r105 = getWindow();
        if (r105 == null) goto L21;
        r105.setWindowAnimations(R.style.larus_dialog_animation);
    L21:
        setCanceledOnTouchOutside(false);
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f520208c = r100.getY();
        return false;
    L5:
        if (r101 == 1) goto L8;
        return false;
    L8:
        if (this.f520208c <= 0.0f) goto L22;
        float r102 = r100.getY();
        if (Math.abs(this.f520208c - r102) < 15.0f) goto L15;
        q3 r103 = this.f520206a.f486712j;
        if (r103 == null) goto L14;
        r103.a();
    L14:
        a(this);
        return false;
    L15:
        q3 r104 = this.f520206a.f486712j;
        if (r104 == null) goto L18;
        r104.c();
    L18:
        a(this);
        return false;
    L22:
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [nr8.a] */
    public b(final Context r100, n3 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        super(r100, R.style.larus_dialog_notification_top);
        this.f520206a = r101;
        this.f520211f = new a(this, r100);
    }
}
