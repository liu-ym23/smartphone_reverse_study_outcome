package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes41.dex */
final class u extends Handler {
    public u(Looper r100) {
        super(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Object r101 = r100.obj;
        if ((r101 instanceof s) == false) goto L6;
        s r102 = (s) r101;
        com.vivo.push.util.t.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(r102)));
        r102.run();
        return;
    }
}
