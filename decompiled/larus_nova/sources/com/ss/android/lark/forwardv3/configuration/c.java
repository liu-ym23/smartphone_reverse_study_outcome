package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnCloseForwardListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements oib.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardCommonConfig f425215a;

    @Override // oib.b
    public final void onClose() {
        RemoteOnCloseForwardListener r100 = this.f425215a.f425166h;     // Catch: RemoteException -> L6
        if (r100 == null) goto L11;
        r100.onClose();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardCommonConfig", "onClose onCloseForwardListener: " + e, e);
    }

    public c(ForwardCommonConfig r100) {
        this.f425215a = r100;
    }
}
