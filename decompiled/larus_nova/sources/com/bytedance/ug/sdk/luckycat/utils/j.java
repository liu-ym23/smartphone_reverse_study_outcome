package com.bytedance.ug.sdk.luckycat.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f271566a;

    public interface a {
        void handleMsg(Message r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        a r101 = this.f271566a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public j(Looper r100, a r101) {
        super(r100);
        this.f271566a = new WeakReference(r101);
    }
}
