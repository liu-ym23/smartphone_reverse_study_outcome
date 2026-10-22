package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r100);
    }

    public WeakHandler(IHandler r100) {
        if (Looper.myLooper() != null) goto L5;
        Looper r101 = Looper.getMainLooper();
    L6:
        this(r101, r100);
        return;
    L5:
        r101 = Looper.myLooper();
        goto L6
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

    public WeakHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mRef = new WeakReference(r101);
    }
}
