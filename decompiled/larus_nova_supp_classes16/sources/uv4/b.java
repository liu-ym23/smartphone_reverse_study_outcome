package uv4;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ c a;

    public final void onSlide(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public b(c r1) {
        this.a = r1;
    }

    public final void onStateChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 != 5) goto L30;
        BottomSheetDialog r5 = this.a.h;
        if (r5 == null) goto L23;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r5);
        goto L23
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r7 == null) goto L20;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L9:
        if (Looper.myLooper() == r6.getLooper()) goto L11;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L23:
        BottomSheetBehavior<View> r8 = this.a.i;
        if (r8 == null) goto L31;
        r8.setState(4);
        return;
    L31:
        return;
    }
}
