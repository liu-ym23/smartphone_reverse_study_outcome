package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnCancelMultiSelectListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements oib.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardSelectConfig f425220a;

    @Override // oib.a
    public final void cancel() {
        RemoteOnCancelMultiSelectListener r100 = this.f425220a.f425190e;     // Catch: RemoteException -> L6
        if (r100 == null) goto L11;
        r100.cancel();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardSelectConfig", "cancel cancelMultiSelectListener error: " + e, e);
    }

    public e(ForwardSelectConfig r100) {
        this.f425220a = r100;
    }
}
