package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements oib.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardTargetConfig f425221a;

    @Override // oib.e
    public final String customDisableToastText() {
        RemoteOnForwardTargetCustomDisableListener r100 = this.f425221a.f425200g;     // Catch: RemoteException -> L10
        if (r100 == null) goto L15;
        String r101 = r100.customDisableToastText();     // Catch: RemoteException -> L10
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L15:
        return "";
    L10:
        e = move-exception;
        Log.e("ForwardTargetConfig", "customDisableToastText customDisableListener error: " + e, e);
        return "";
    }

    public f(ForwardTargetConfig r100) {
        this.f425221a = r100;
    }

    @Override // oib.e
    public final boolean customDisable(ForwardTargetBaseInfoNew r100) {
        RemoteOnForwardTargetCustomDisableListener r101 = this.f425221a.f425200g;     // Catch: RemoteException -> L7
        if (r101 == null) goto L12;
        return r101.customDisable(r100);
    L12:
        return false;
    L7:
        e = move-exception;
        Log.e("ForwardTargetConfig", "customDisable customDisableListener error: " + e, e);
        return false;
    }
}
