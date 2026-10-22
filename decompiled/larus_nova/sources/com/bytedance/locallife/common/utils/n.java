package com.bytedance.locallife.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class n extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f257153a;

    public interface a {
        void a();
    }

    public n(a r100) {
        if (Looper.myLooper() != null) goto L5;
        Looper r101 = Looper.getMainLooper();
    L6:
        super(r101);
        this.f257153a = new WeakReference(r100);
        return;
    L5:
        r101 = Looper.myLooper();
        goto L6
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        a r101 = this.f257153a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.a();
        return;
    L8:
        return;
    }
}
