package com.bytedance.apm.config;

import android.content.Intent;
import com.bytedance.apm.d;
import com.bytedance.apm.util.p;
import com.larus.apm.impl.protector.RunnableProtector;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Intent r0 = new Intent("com.apm.setting.update.action");     // Catch: Throwable -> L6 Exception -> L12
        d.getContext();     // Catch: Throwable -> L6 Exception -> L12
        r0.putExtra("PROCESS_NAME", p.a());     // Catch: Throwable -> L6 Exception -> L12
        d.getContext().sendBroadcast(r0);     // Catch: Throwable -> L6 Exception -> L12
        if (d.j() == false) goto L11;
        b.a(new String[]{"BroadcastReceiver.sendBroadUpdateSetting"});     // Catch: Throwable -> L6 Exception -> L12
        goto L17
    L15:
        return;
    L11:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    }

    public h() {
    }
}
