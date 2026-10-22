package com.ss.android.ugc.effectmanager.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes40.dex */
public class WeakHandler extends Handler {
    private IHandler mHandler;

    public interface IHandler {
        void handleMsg(Message r100);
    }

    public WeakHandler(IHandler r100) {
        super(Looper.getMainLooper());
        this.mHandler = r100;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        IHandler r101 = this.mHandler;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public WeakHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mHandler = r101;
    }
}
