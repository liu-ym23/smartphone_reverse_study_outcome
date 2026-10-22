package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements oib.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardConfirmDialogConfig f425216a;

    @Override // oib.c
    public final void onCancelButtonClick() {
        RemoteOnForwardConfirmDialogListener r100 = this.f425216a.f425180g;     // Catch: RemoteException -> L6
        if (r100 == null) goto L11;
        r100.onCancelButtonClick();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onCancelButtonClick confirmDialogListener error: " + e, e);
    }

    @Override // oib.c
    public final void onDismissForward() {
        RemoteOnForwardConfirmDialogListener r100 = this.f425216a.f425180g;     // Catch: RemoteException -> L6
        if (r100 == null) goto L11;
        r100.onDismissForward();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onDismissForward confirmDialogListener error: " + e, e);
    }

    public d(ForwardConfirmDialogConfig r100) {
        this.f425216a = r100;
    }

    @Override // oib.c
    public final void onConfirmButtonClick(String r100, String r101) {
        RemoteOnForwardConfirmDialogListener r102 = this.f425216a.f425180g;     // Catch: RemoteException -> L6
        if (r102 == null) goto L11;
        r102.onConfirmButtonClick(r100, r101);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardConfirmDialogConfig", "onConfirmButtonClick confirmDialogListener error: " + e, e);
    }
}
