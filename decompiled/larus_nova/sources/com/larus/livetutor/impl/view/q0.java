package com.larus.livetutor.impl.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q0 extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorSettingsDialog f356894a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public q0(LiveTutorSettingsDialog r100) {
        this.f356894a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 4) goto L5;
    L7:
        LiveTutorSettingsDialog r102 = this.f356894a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L5:
        if (r101 == 5) goto L7;
    }
}
