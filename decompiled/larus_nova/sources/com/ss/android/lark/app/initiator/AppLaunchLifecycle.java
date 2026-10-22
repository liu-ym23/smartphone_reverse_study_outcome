package com.ss.android.lark.app.initiator;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLaunchLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f408741a;

    public static final class a {
    }

    public interface b {
        void a(Context r100);

        void b(Context r100);

        void c(Configuration r100);

        void d(Context r100);

        void e(Context r100);

        void f(Context r100);

        void g(Context r100);

        void onConfigurationChanged(Configuration r100);
    }

    @Singleton
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f408742a;

        @Inject
        public c() {
            this.f408742a = -1;
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void c(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "configuration");
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void d(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Log.i("AppLaunchLifecycle", "[perf] application created, cost:" + (SystemClock.elapsedRealtime() - this.f408742a));
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void e(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void f(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f408742a = SystemClock.elapsedRealtime();
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void g(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "configuration");
        }
    }

    static {
    }

    @Inject
    public AppLaunchLifecycle(final Provider<Set<b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "observers");
        this.f408741a = LazyKt.lazy(new AppLaunchLifecycle$lifecycleObservers$2(r100));
    }

    public final void a(Function1<? super b, Unit> r100) {
        Iterator r101 = ((List) this.f408741a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((b) r101.next());
        goto L4
    }
}
