package com.unionpay;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements Runnable {
    public h() {
    }

    public static void a() {
        a.f462144s.sendEmptyMessageDelayed(1001, 800);     // Catch: Exception -> L6
        wpc.b r100 = new wpc.b(a.f462143r, com.unionpay.utils.b.a(a.k()));     // Catch: Exception -> L6
        r100.b();     // Catch: Exception -> L6
        String r101 = r100.f560674a;     // Catch: Exception -> L6
        Handler r102 = a.f462144s;     // Catch: Exception -> L6
        if (r102 == null) goto L9;
        Message r103 = r102.obtainMessage();     // Catch: Exception -> L6
        r103.what = 1002;     // Catch: Exception -> L6
        r103.obj = r101;     // Catch: Exception -> L6
        a.f462144s.removeMessages(1001);     // Catch: Exception -> L6
        a.f462144s.sendMessage(r103);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
