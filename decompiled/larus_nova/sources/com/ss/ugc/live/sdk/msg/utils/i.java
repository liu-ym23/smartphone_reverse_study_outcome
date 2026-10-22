package com.ss.ugc.live.sdk.msg.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes36.dex */
public final class i extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f458481a;

    public interface a {
        void handleMsg(Message r100);
    }

    public i(a r100) {
        this.f458481a = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        a r101 = this.f458481a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public i(Looper r100, a r101) {
        super(r100);
        this.f458481a = new WeakReference(r101);
    }
}
