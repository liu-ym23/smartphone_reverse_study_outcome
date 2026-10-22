package rm3;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f538534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f538535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Dialog f538536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f538537d;

    /* JADX INFO: renamed from: rm3.a$a, reason: collision with other inner class name */
    public static final class C7501a {
    }

    static {
    }

    public final void b() {
        this.f538534a.postDelayed(this.f538537d, this.f538535b);
        Dialog r100 = this.f538536c;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public a(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f538534a = new Handler();
        this.f538535b = 2000;
        Dialog r102 = new Dialog(r100, R.style.uicomponent_fake_toast_dialog);
        this.f538536c = r102;
        this.f538537d = new b(this);
        r102.setContentView(r101);
        Window r103 = r102.getWindow();
        if (r103 == null) goto L6;
        r103.addFlags(8);
        r103.addFlags(32);
        r103.addFlags(16);
        r103.setLayout(-2, -2);
        r103.setGravity(17);
        return;
    }
}
