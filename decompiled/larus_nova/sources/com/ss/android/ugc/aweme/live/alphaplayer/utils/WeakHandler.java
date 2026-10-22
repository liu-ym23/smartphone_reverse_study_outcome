package com.ss.android.ugc.aweme.live.alphaplayer.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class WeakHandler extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<IHandler> f451249a;

    public interface IHandler {
        void handleMsg(Message r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        IHandler r101 = this.f451249a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public WeakHandler(PlayerProgressHelper r100, Looper r101) {
        super(r101);
        this.f451249a = new WeakReference(r100);
    }
}
