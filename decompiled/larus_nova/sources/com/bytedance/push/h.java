package com.bytedance.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f266873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v67.u f266874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f266875c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f266876a;

        public final void a() {
            if (k.f266885e != null) goto L5;
            com.ss.android.pushmanager.setting.b.b().getClass();
            k.f266885e = com.ss.android.pushmanager.setting.b.d().r();
        L5:
            int r100 = k.f266885e.pollingInterval;
            if (r100 <= 0) goto L12;
            h r101 = this.f266876a;
            k r102 = r101.f266875c;
            Context r103 = r101.f266873a;
            v67.u r104 = r101.f266874b;
            long r105 = ((long) r100) * 1000;
            k.a r106 = r102.f266886a;
            if (r106 == null) goto L10;
            r106.f266892d = true;
            r102.f266886a = null;
        L10:
            r102.f266886a = new k.a(r104, r103, r105);
            PushThreadHandlerManager.inst().postRunnable(r102.f266886a);
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

        public a(h r100) {
            this.f266876a = r100;
        }
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        if (((Boolean) r101).booleanValue() == false) goto L10;
        this.f266875c.f266887b = false;
        int r102 = k.f266884d;
        if (r102 != 1) goto L7;
    L8:
        PushThreadHandlerManager.inst().postRunnable(new a(this));
        return;
    L7:
        if (r102 == 3) goto L8;
        return;
    }

    public h(k r100, Context r101, v67.u r102) {
        this.f266875c = r100;
        this.f266873a = r101;
        this.f266874b = r102;
    }
}
