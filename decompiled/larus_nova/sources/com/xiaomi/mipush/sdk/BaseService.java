package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BaseService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f463026a;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<BaseService> f463027a;

        public void a() {
            if (hasMessages(1001) == false) goto L5;
            removeMessages(1001);
        L5:
            sendEmptyMessageDelayed(1001, 1000);
        }

        public a(WeakReference<BaseService> r100) {
            this.f463027a = r100;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100.what != 1001) goto L17;
            WeakReference<BaseService> r101 = this.f463027a;
            if (r101 == null) goto L14;
            BaseService r102 = r101.get();
            if (r102 == null) goto L15;
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler " + r102.toString() + " kill self");
            if (r102.mo8742a() == true) goto L12;
            r102.stopSelf();
            return;
        L12:
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
            sendEmptyMessageDelayed(1001, 1000);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo8742a();

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    public BaseService() {
    }

    @Override // android.app.Service
    public void onStart(Intent r100, int r101) {
        super.onStart(r100, r101);
        if (this.f463026a != null) goto L5;
        this.f463026a = new a(new WeakReference(this));
    L5:
        this.f463026a.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        if (com.xiaomi.push.j.m9295a(this) == true) goto L7;
        return 2;
    L7:
        return r103;
    }
}
