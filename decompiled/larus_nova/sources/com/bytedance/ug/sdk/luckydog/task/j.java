package com.bytedance.ug.sdk.luckydog.task;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f271922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f271923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f271924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f271925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Set<String> f271926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile HashMap<String, Integer> f271927f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f271928a = null;

        static {
            f271928a = new j();
        }
    }

    public j() {
        this.f271926e = new CopyOnWriteArraySet();
        this.f271927f = new HashMap();
        o r100 = o.c.f272177a;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "init() on call; intervalSec = 1");
        r100.f272174c = this;
        r100.f272175d = 1;
        if (to7.c.c() == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyDogSceneTimeManager", "isForeground() is true");
        this.f271923b = false;
        this.f271925d = true;
        a();
        return;
    }

    public final synchronized void a() {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyDogSceneTimeManager", "tryStarTimerTask() on call; mIsTimerRunning = " + this.f271922a);     // Catch: Throwable -> L9
        if (this.f271922a == true) goto L7;
        o.c.f272177a.a();     // Catch: Throwable -> L9
        this.f271922a = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyDogSceneTimeManager", "tryStopTimerTask() on call; mIsReadTiming = " + this.f271924c + "; mIsUsageTiming = " + this.f271925d);     // Catch: Throwable -> L11
        if (this.f271924c == false) goto L7;
    L9:
        monitor-exit(this);
        return;
    L7:
        if (this.f271925d == true) goto L9;
        o.c.f272177a.b();     // Catch: Throwable -> L11
        this.f271922a = false;     // Catch: Throwable -> L11
        e.c.f271901a.d(false);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
