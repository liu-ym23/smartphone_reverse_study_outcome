package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import android.app.Activity;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class PollingTrigger$mAppLifecycleCallback$1 extends uo7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PollingTrigger f271620a;

    public PollingTrigger$mAppLifecycleCallback$1(PollingTrigger r100) {
        this.f271620a = r100;
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        PollingTrigger r101 = this.f271620a;
        long r102 = r101.f271618k;
        long r103 = SystemClock.elapsedRealtime();
        PollingTrigger r104 = this.f271620a;
        r101.f271611d = r102 - (r103 - r104.f271610c);
        r104.f271612e = SystemClock.elapsedRealtime();
        ScheduledFuture<?> r105 = this.f271620a.f271613f;
        if (r105 == null) goto L5;
        r105.cancel(false);
    L5:
        this.f271620a.f271614g.set(true);
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        ScheduledFuture<?> r101 = this.f271620a.f271613f;
        if (r101 == null) goto L5;
        r101.cancel(false);
    L5:
        this.f271620a.f271614g.set(true);
        long r102 = SystemClock.elapsedRealtime();
        PollingTrigger r103 = this.f271620a;
        long r104 = r102 - r103.f271612e;
        if (r104 < r103.f271611d) goto L8;
        PThreadScheduledThreadPoolExecutor r105 = yk7.f.f568242a;
        yk7.f.b(new PollingTrigger$mAppLifecycleCallback$1$onEnterForeground$1(this));
        return;
    L8:
        PThreadScheduledThreadPoolExecutor r106 = yk7.f.f568242a;
        r103.f271613f = yk7.f.a(r103.d(), this.f271620a.f271611d - r104);
        this.f271620a.f271614g.set(false);
    }
}
