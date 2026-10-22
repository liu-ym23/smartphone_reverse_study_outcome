package com.bytedance.awemeopen.apps.framework.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0 extends Handler {
    public final WeakReference<a> a;

    public interface a {
        void handleMsg(Message r1);
    }

    public r0(a r2) {
        if (Looper.myLooper() != null) goto L5;
        Looper r0 = Looper.getMainLooper();
    L6:
        super(r0);
        this.a = new WeakReference(r2);
        return;
    L5:
        r0 = Looper.myLooper();
        goto L6
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        a r0 = this.a.get();
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.handleMsg(r2);
        return;
    L8:
        return;
    }
}
