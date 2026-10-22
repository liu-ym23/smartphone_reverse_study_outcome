package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: loaded from: classes41.dex */
public class ea implements dy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    JobScheduler f463422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f475a;

    @Override // com.xiaomi.push.dy.a
    public void a() {
        this.f475a = false;
        this.f463422a.cancel(1);
    }

    @Override // com.xiaomi.push.dy.a
    /* JADX INFO: renamed from: a */
    public boolean mo9040a() {
        return this.f475a;
    }

    public ea(Context r100) {
        this.f475a = false;
        this.f474a = r100;
        this.f463422a = (JobScheduler) r100.getSystemService("jobscheduler");
    }

    public void a(long r100) {
        JobInfo.Builder r101 = new JobInfo.Builder(1, new ComponentName(this.f474a.getPackageName(), XMJobService.class.getName()));
        r101.setMinimumLatency(r100);
        r101.setOverrideDeadline(r100);
        r101.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + r101.build().getId() + " in " + r100);
        this.f463422a.schedule(r101.build());
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean r100) {
        if (r100 == false) goto L4;
    L6:
        long r101 = ff.b();
        if (r100 == false) goto L9;
        a();
        r101 = r101 - (SystemClock.elapsedRealtime() % r101);
    L9:
        this.f475a = true;
        a(r101);
        return;
    L4:
        if (this.f475a == true) goto L6;
    }
}
