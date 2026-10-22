package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes41.dex */
class dz implements dy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f463421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f473a;

    @Override // com.xiaomi.push.dy.a
    public void a() {
        if (this.f472a == null) goto L11;
        AlarmManager r100 = (AlarmManager) this.f473a.getSystemService("alarm");
        r100.cancel(this.f472a);     // Catch: Throwable -> L7 Exception -> L13
    L7:
        th = move-exception;
        this.f472a = null;
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
        this.f463421a = 0;
        throw th;
    L10:
        this.f472a = null;
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
        this.f463421a = 0;
    L11:
        this.f463421a = 0;
    }

    @Override // com.xiaomi.push.dy.a
    /* JADX INFO: renamed from: a */
    public boolean mo9040a() {
        if (this.f463421a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public dz(Context r100) {
        this.f472a = null;
        this.f473a = null;
        this.f463421a = 0;
        this.f473a = r100;
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean r100) {
        long r101 = com.xiaomi.push.service.m.a(this.f473a).m9391a();
        if (r100 == false) goto L5;
    L7:
        if (r100 == false) goto L9;
        a();
    L9:
        long r102 = SystemClock.elapsedRealtime();
        if (r100 == false) goto L12;
    L19:
        this.f463421a = r102 + (r101 - (r102 % r101));
    L20:
        Intent r103 = new Intent(com.xiaomi.push.service.an.f464252q);
        r103.setPackage(this.f473a.getPackageName());
        a(r103, this.f463421a);
        return;
    L12:
        if (this.f463421a == 0) goto L19;
        if (this.f463421a > r102) goto L20;
        this.f463421a += r101;
        if (this.f463421a >= r102) goto L20;
        this.f463421a = r102 + r101;
        goto L20
    L5:
        if (this.f463421a != 0) goto L7;
    }

    public void a(Intent r100, long r101) {
        AlarmManager r102 = (AlarmManager) this.f473a.getSystemService("alarm");
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 31) goto L5;
        this.f472a = PendingIntent.getBroadcast(this.f473a, 0, r100, 33554432);
    L7:
        if (r103 < 31) goto L12;
        if (j.m9295a(this.f473a) == true) goto L12;
        r102.set(2, r101, this.f472a);
    L15:
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + r101);
        return;
    L12:
        if (r103 < 23) goto L14;
        av.a(r102, "setExactAndAllowWhileIdle", new Object[]{2, Long.valueOf(r101), this.f472a});
        goto L15
    L14:
        a(r102, r101, this.f472a);
        goto L15
    L5:
        this.f472a = PendingIntent.getBroadcast(this.f473a, 0, r100, 0);
        goto L7
    }

    private void a(AlarmManager r100, long r110, PendingIntent r111) {
        AlarmManager.class.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(r100, new Object[]{2, Long.valueOf(r110), r111});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
    }
}
