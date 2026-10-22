package com.bytedance.ug.sdk.luckydog.task;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/task/CrossoverService;", "Landroid/app/Service;", "<init>", "()V", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final class CrossoverService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Messenger f271837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f271838b;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CrossoverService f271839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f271840b;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Message r101 = Message.obtain();
            if (r100.what != 36865) goto L16;
            r101.what = 36866;
            Object r102 = r100.obj;     // Catch: Throwable -> L14
            if ((r102 instanceof Bundle) == false) goto L12;
            if (r102 == null) goto L11;
            AppActivateHelper.f((Bundle) r102);     // Catch: Throwable -> L14
            goto L12
        L11:
            throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");     // Catch: Throwable -> L14
        L12:
            com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271839a.f271838b, "importer [" + this.f271840b + "] send TOKEN_CONSUME back");     // Catch: Throwable -> L14
            r100.replyTo.send(r101);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            String r103 = this.f271839a.f271838b;
            th.getLocalizedMessage();
        L16:
            super.handleMessage(r100);
        }

        public a(CrossoverService r100, String r101, Looper r102) {
            this.f271839a = r100;
            this.f271840b = r101;
            super(r102);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271838b, "Service onDestroy onCall");
        super.onDestroy();
    }

    public CrossoverService() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("luckydog_cross_opt_broadcast_importer_thread");
        this.f271838b = "CrossoverService";
        ThreadMethodProxy.start(r100);
        Application r101 = rk7.m.f538347a;
        this.f271837a = new Messenger(new a(this, String.valueOf(rk7.m.f()), r100.getLooper()));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d(this.f271838b, "Service onBind onCall");
        return this.f271837a.getBinder();
    }
}
