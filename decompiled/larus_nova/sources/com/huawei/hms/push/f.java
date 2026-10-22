package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<a> f277614a;

    public interface a {
        void a(Message r100);
    }

    public f(a r100) {
        this.f277614a = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        super.handleMessage(r100);
        a r101 = this.f277614a.get();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
