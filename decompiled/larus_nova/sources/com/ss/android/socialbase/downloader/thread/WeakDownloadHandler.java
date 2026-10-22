package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class WeakDownloadHandler extends Handler {
    private final WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r100);
    }

    public WeakDownloadHandler(IHandler r100) {
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

    public WeakDownloadHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mRef = new WeakReference(r101);
    }
}
