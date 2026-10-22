package com.ss.android.dypay.activity.g;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import qta.c;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<c> f408433a;

    public a(c r100) {
        super(null);
        this.f408433a = new WeakReference(r100);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        WeakReference<c> r102 = this.f408433a;
        if (r102 == null) goto L12;
        c r103 = r102.get();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.a(r100) != true) goto L14;
        WeakReference<c> r104 = this.f408433a;
        if (r104 == null) goto L15;
        r104.clear();
        return;
    L15:
        return;
    L14:
        return;
    }
}
