package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f216470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f216471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Dialog f216472c;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if (r100.orientation == this.f216470a.element) goto L5;
    L6:
        Dialog r101 = this.f216472c;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
    L21:
        Ref.IntRef r103 = this.f216470a;
        r103.element = r100.orientation;
        Ref.IntRef r104 = this.f216471b;
        r104.element = r100.screenLayout;
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r105 == null) goto L20;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L21
    L5:
        if (r100.screenLayout != this.f216471b.element) goto L6;
    }

    public k(Ref.IntRef r100, Ref.IntRef r101, Dialog r102) {
        this.f216470a = r100;
        this.f216471b = r101;
        this.f216472c = r102;
    }
}
