package com.ss.android.dypay.activity.g;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import qta.c;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<c> f408434a;

    public b(c r100) {
        super(null);
        this.f408434a = new WeakReference(r100);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        WeakReference<c> r102 = this.f408434a;
        if (r102 == null) goto L8;
        c r103 = r102.get();
        if (r103 == null) goto L9;
        r103.a(r100, r101);
        return;
    L9:
        return;
    }
}
