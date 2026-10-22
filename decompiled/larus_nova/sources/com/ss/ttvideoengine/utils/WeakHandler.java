package com.ss.ttvideoengine.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes35.dex */
public class WeakHandler extends Handler {
    private final WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMessage(Message r100);
    }

    public WeakHandler(IHandler r100) {
        this.mRef = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        IHandler r101 = this.mRef.get();
        if (r101 == null) goto L6;
        r101.handleMessage(r100);
        return;
    }

    public WeakHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mRef = new WeakReference(r101);
    }
}
