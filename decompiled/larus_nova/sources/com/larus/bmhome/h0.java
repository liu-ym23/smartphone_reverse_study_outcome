package com.larus.bmhome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 implements f09.a.InterfaceC5845a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f311772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nr8.b f311773b;

    @Override // f09.a.InterfaceC5845a
    public final void onPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Intrinsics.areEqual(r100, this.f311772a) == false) goto L21;
        AppHost.f326268a.a().f(this);
        nr8.b r101 = this.f311773b;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    @Override // f09.a.InterfaceC5845a
    public final void onPreDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStart(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public h0(Activity r100, nr8.b r101) {
        this.f311772a = r100;
        this.f311773b = r101;
    }

    @Override // f09.a.InterfaceC5845a
    public final void onCreate(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }
}
