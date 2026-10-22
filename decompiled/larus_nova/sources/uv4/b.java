package uv4;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551842a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public b(c r100) {
        this.f551842a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 5) goto L30;
        BottomSheetDialog r102 = this.f551842a.f551851h;
        if (r102 == null) goto L23;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r102);
        goto L23
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r104 == null) goto L20;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L9:
        if (Looper.myLooper() == r103.getLooper()) goto L11;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L23:
        BottomSheetBehavior<View> r105 = this.f551842a.f551852i;
        if (r105 == null) goto L31;
        r105.setState(4);
        return;
    L31:
        return;
    }
}
