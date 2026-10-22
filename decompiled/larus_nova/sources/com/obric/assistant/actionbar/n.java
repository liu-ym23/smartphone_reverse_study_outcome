package com.obric.assistant.actionbar;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f385245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f385246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f385247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f385248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f385249e = null;

    public static final class a implements gd9.b {
        public a() {
        }

        @Override // gd9.b
        public final void onAllActivityDestroyed() {
        }

        @Override // gd9.b
        public final void onAppBackground() {
            Lazy r100 = n.f385245a;
            n.f385246b = SystemClock.elapsedRealtime();
            n.f385247c = false;
            FLogger.f375446a.i("ObricOfficeTaskModeBackgroundResetManager", "startBackgroundTiming, reason=appBackground");
        }

        @Override // gd9.b
        public final void onAppForeground() {
            Lazy r100 = n.f385245a;
            long r101 = n.f385246b;
            if (r101 <= 0) goto L11;
            long r102 = SystemClock.elapsedRealtime() - r101;
            if (r102 < ((Number) n.f385245a.getValue()).longValue()) goto L8;
            boolean r103 = true;
        L9:
            n.f385247c = r103;
            n.f385246b = 0;
            FLogger.f375446a.i("ObricOfficeTaskModeBackgroundResetManager", "updateResetState, reason=appForeground, elapsed=" + r102 + ", shouldReset=" + n.f385247c);
            return;
        L8:
            r103 = false;
            goto L9
        }
    }

    static {
        f385245a = LazyKt.lazy(new m());
        f385249e = new a();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (f385246b <= 0) goto L5;
    L7:
        FLogger.f375446a.i("ObricOfficeTaskModeBackgroundResetManager", "clearBackgroundTiming, reason=" + r100);
        f385246b = 0;
        f385247c = false;
        return;
    L5:
        if (f385247c == true) goto L7;
    }
}
