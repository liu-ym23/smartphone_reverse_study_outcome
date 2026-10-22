package com.obric.assistant.util;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f393819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f393820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f393821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f393822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f393823e;

    public final void a() {
        long r100 = this.f393819a;
        p r101 = this.f393820b;
        if (r100 == r101.f393801k) goto L5;
    L16:
        r101.f393808r = null;
        return;
    L5:
        if (r101.f393807q == null) goto L16;
        long r102 = RangesKt.coerceAtLeast(this.f393821c - SystemClock.uptimeMillis(), 0);
        if (r102 > 0) goto L11;
        this.f393820b.f393808r = null;
        return;
    L11:
        FLogger.f375446a.i("AutoDismissDelegate", "dismiss countdown, ownerId=" + this.f393820b.f393795e + ", generation=" + this.f393819a + ", remainingSeconds=" + (((r102 + 1000) - 1) / 1000) + ", initial=" + this.f393822d + ", reason=" + this.f393823e);
        if (r102 <= 1000) goto L14;
        this.f393820b.f393797g.postDelayed(this, 1000);
        return;
    L14:
        this.f393820b.f393808r = null;
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

    public q(long r100, p r101, long r102, boolean r103, String r104) {
        this.f393819a = r100;
        this.f393820b = r101;
        this.f393821c = r102;
        this.f393822d = r103;
        this.f393823e = r104;
    }
}
