package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class TTWeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    /* JADX INFO: loaded from: classes5.dex */
    public interface IHandler {
        void handleMsg(Message r100);
    }

    public TTWeakHandler(IHandler r100) {
        this.mRef = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        IHandler r101 = this.mRef.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public TTWeakHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mRef = new WeakReference(r101);
    }
}
