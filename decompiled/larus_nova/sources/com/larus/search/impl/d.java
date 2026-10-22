package com.larus.search.impl;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior<View> f367623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f367624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Dialog f367625c;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 3) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.height = this.f367624b;
        r100.setLayoutParams(r102);
        return;
    L5:
        if (r101 != 5) goto L7;
        Dialog r103 = this.f367625c;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r105 == null) goto L24;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r104.getLooper()) goto L15;
        r104.post(DialogLancet.createDismissRunnable(r103));
        return;
    L7:
        if (r101 != 6) goto L35;
        this.f367623a.setState(5);
        return;
    }

    public d(BottomSheetBehavior<View> r100, int r101, Dialog r102) {
        this.f367623a = r100;
        this.f367624b = r101;
        this.f367625c = r102;
    }
}
