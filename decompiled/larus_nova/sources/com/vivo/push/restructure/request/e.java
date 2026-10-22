package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.g;

/* JADX INFO: loaded from: classes41.dex */
final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f462507a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        int r101 = r100.what;
        if (d.a(this.f462507a).containsKey(Integer.valueOf(r101)) == false) goto L6;
        b r102 = (b) d.a(this.f462507a).remove(Integer.valueOf(r101));
        g.a().execute(new f(this, r102));
        return;
    }

    public e(d r100, Looper r101) {
        this.f462507a = r100;
        super(r101);
    }
}
