package com.monitor.cloudmessage.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bt3.b;
import com.bytedance.apm.util.m;
import com.larus.apm.impl.protector.RunnableProtector;
import x8a.c;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f384382a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (m.b(this.f384382a) == false) goto L9;
            c.b().a();     // Catch: Throwable -> L6
            return;
        }

        public a(Context r100) {
            this.f384382a = r100;
        }
    }

    public NetworkBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        b.d.f20539a.e(new a(r100));
    }
}
