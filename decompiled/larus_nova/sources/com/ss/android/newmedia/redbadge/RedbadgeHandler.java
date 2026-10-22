package com.ss.android.newmedia.redbadge;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import kfc.c;

/* JADX INFO: loaded from: classes38.dex */
public class RedbadgeHandler extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHandler f449143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f449144b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f449145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RedbadgeHandler f449146b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f449146b.a(this.f449145a);     // Catch: Throwable -> L4
            this.f449146b.stopSelf();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(RedbadgeHandler r100, Intent r101) {
            this.f449146b = r100;
            this.f449145a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f449147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RedbadgeHandler f449148b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f449148b.a(this.f449147a);     // Catch: Throwable -> L4
            this.f449148b.stopSelf();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(RedbadgeHandler r100, Intent r101) {
            this.f449148b = r100;
            this.f449147a = r101;
        }
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f.b("RedbadgeHandler", WidgetCostModule.TYPE_ON_CREATE);
        this.f449143a = new WeakHandler(this);
        this.f449144b = new Messenger(this.f449143a);
    }

    public RedbadgeHandler() {
    }

    public final void a(Intent r100) {
        f.b("RedbadgeHandler", "onHandleIntent = " + r100);
        if (r100 != null) goto L26;
        return;
    L26:
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if ("com.ss.android.redbadge.message".equals(r100.getAction()) == false) goto L27;
        String r101 = r100.getStringExtra("message_data");     // Catch: Throwable -> L21
        boolean r102 = r100.getBooleanExtra("has_app_foreground", false);     // Catch: Throwable -> L21
        String r103 = r100.getStringExtra("red_data_from");     // Catch: Throwable -> L21
        String r104 = r100.getStringExtra("use_last_resp_reason");     // Catch: Throwable -> L21
        if (c.f503296j == null) goto L10;
    L19:
        c.f503296j.a(r101, r102, r103, r104);     // Catch: Throwable -> L21
        return;
    L10:
        monitor-enter(c.class);     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L12:
        if (c.f503296j != null) goto L14;
        c.f503296j = new c(this);     // Catch: Throwable -> L16
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        PushThreadHandlerManager.inst().postRunnable(new b(this, r100));
        return this.f449144b.getBinder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        PushThreadHandlerManager.inst().postRunnable(new a(this, r100));
        int r103 = super.onStartCommand(r100, r101, r102);
        if (((zfc.a.b) rgc.b.a(zfc.a.b.class)).f() == false) goto L6;
        return 2;
    L6:
        return r103;
    }
}
