package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.dy;

/* JADX INFO: loaded from: classes41.dex */
public class XMJobService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Service f464143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IBinder f987a;

    public static class a extends JobService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Binder f464144a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Handler f988a;

        /* JADX INFO: renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        public static class HandlerC5561a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            JobService f464145a;

            public HandlerC5561a(JobService r100) {
                super(r100.getMainLooper());
                this.f464145a = r100;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                if (r100.what != 1) goto L10;
                JobParameters r101 = (JobParameters) r100.obj;
                com.xiaomi.channel.commonutils.logger.b.m8718a("Job finished " + r101.getJobId());
                this.f464145a.jobFinished(r101, false);
                if (r101.getJobId() != 1) goto L9;
                dy.a(false);
                return;
            L9:
                return;
            }
        }

        public a(Service r100) {
            this.f464144a = null;
            this.f464144a = (Binder) com.xiaomi.push.av.a(this, "onBind", new Object[]{new Intent()});
            com.xiaomi.push.av.a(this, "attachBaseContext", new Object[]{r100});
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters r100) {
            com.xiaomi.channel.commonutils.logger.b.m8718a("Job started " + r100.getJobId());
            Intent r101 = new Intent(this, XMPushService.class);
            r101.setAction("com.xiaomi.push.timer");
            r101.setPackage(getPackageName());
            startService(r101);
            if (this.f988a != null) goto L5;
            this.f988a = new HandlerC5561a(this);
        L5:
            Handler r102 = this.f988a;
            r102.sendMessage(Message.obtain(r102, 1, r100));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters r100) {
            com.xiaomi.channel.commonutils.logger.b.m8718a("Job stop " + r100.getJobId());
            return false;
        }
    }

    public XMJobService() {
        this.f987a = null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f987a = new a(this).f464144a;
        f464143a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f464143a = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        IBinder r101 = this.f987a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new Binder();
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
