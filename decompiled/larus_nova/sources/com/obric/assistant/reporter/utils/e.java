package com.obric.assistant.reporter.utils;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f391444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f391445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AppStartState f391446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f391447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f391448e = null;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            e r100 = e.f391444a;
            e.f391446c = AppStartState.WarmStart;
            FLogger.f375446a.i("ObricAppStartManager", "onAllActivityDestroyed: state=" + e.f391446c);
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            int r100 = AppHost.f326268a.a().g().size();
            if (r100 <= 0) goto L5;
            e r101 = e.f391444a;
            e.f391446c = AppStartState.HotStart;
        L5:
            FLogger.f375446a.i("ObricAppStartManager", "onAppBackground: aliveActivityCount=" + r100 + ", state=" + e.f391446c);
        }
    }

    public e() {
    }

    static {
        f391444a = new e();
        f391446c = AppStartState.ColdStart;
        f391447d = SystemClock.elapsedRealtime();
        f391448e = new a();
    }
}
