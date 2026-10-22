package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTWeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public TTWeakHandler(IHandler r2) {
        this.mRef = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r2) {
        IHandler r0 = this.mRef.get();
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.handleMsg(r2);
        return;
    L8:
        return;
    }

    public TTWeakHandler(Looper r1, IHandler r2) {
        super(r1);
        this.mRef = new WeakReference(r2);
    }
}
