package com.ss.android.lark.forwardv3.utils;

import android.content.DialogInterface;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.forwardv3.ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDialogContentLifecycleOwner f425581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qib.a f425582b;

    public i(ForwardDialogContentLifecycleOwner r100, ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 r101) {
        this.f425581a = r100;
        this.f425582b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        ForwardDialogContentLifecycleOwner r101 = this.f425581a;
        if (r101 == null) goto L7;
        Lifecycle.State r102 = r101.f425567a.getCurrentState();
        Lifecycle.State r103 = Lifecycle.State.DESTROYED;
        if (r102 == r103) goto L7;
        r101.f425567a.setCurrentState(r103);
    L7:
        this.f425582b.onDismissForward();
    }
}
