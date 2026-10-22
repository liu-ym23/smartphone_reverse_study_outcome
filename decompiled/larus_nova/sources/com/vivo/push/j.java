package com.vivo.push;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes41.dex */
final class j implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f462393a;

    public j(i r100) {
        this.f462393a = r100;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100 != null) goto L6;
        com.vivo.push.util.t.a("AidlManager", "handleMessage error : msg is null");
        return false;
    L6:
        int r101 = r100.what;
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L11;
        com.vivo.push.util.t.b("AidlManager", "unknow msg what [" + r100.what + "]");
    L17:
        return true;
    L11:
        if (i.a(this.f462393a).get() != 4) goto L13;
        i.c(this.f462393a);
    L13:
        i.b(this.f462393a);
        goto L17
    L14:
        com.vivo.push.util.t.a("AidlManager", "In connect, bind core service time out");
        if (i.a(this.f462393a).get() != 2) goto L17;
        i.b(this.f462393a);
        goto L17
    }
}
