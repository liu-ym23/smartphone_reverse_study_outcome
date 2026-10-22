package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements oib.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardAdditionNoteConfig f425214a;

    public b(ForwardAdditionNoteConfig r100) {
        this.f425214a = r100;
    }

    @Override // oib.d
    public final void onFailed(String r100, String r101) {
        RemoteOnForwardNoteListener r102 = this.f425214a.f425156d;     // Catch: RemoteException -> L6
        if (r102 == null) goto L11;
        r102.onFailed(r100, r101);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardAdditionNoteConfig", "onFailed forwardNoteListener error, " + e, e);
    }

    @Override // oib.d
    public final void onSuccess(String r100, String r101, String r102) {
        RemoteOnForwardNoteListener r103 = this.f425214a.f425156d;     // Catch: RemoteException -> L6
        if (r103 == null) goto L11;
        r103.onSuccess(r100, r101, r102);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardAdditionNoteConfig", "onSuccess forwardNoteListener error, " + e, e);
    }
}
