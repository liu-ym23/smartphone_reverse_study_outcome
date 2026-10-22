package fo6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import bolts.Task;
import com.bytedance.locallife.biz.router.NoActivityStartedCallbackException;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f478148c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f478149d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f478150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, C5935b> f478151b;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: fo6.b$b, reason: collision with other inner class name */
    public static final class C5935b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f478152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f478153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f478154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<Activity, Unit> f478155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Runnable f478156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f478157f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public WeakReference<Activity> f478158g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<NoActivityStartedCallbackException, Unit> f478159h;

        public C5935b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5935b) == true) goto L8;
            return false;
        L8:
            C5935b r101 = (C5935b) r100;
            if (Intrinsics.areEqual(this.f478152a, r101.f478152a) == true) goto L12;
            return false;
        L12:
            if (this.f478153b == r101.f478153b) goto L15;
            return false;
        L15:
            if (this.f478154c == r101.f478154c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f478155d, r101.f478155d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f478156e, r101.f478156e) == true) goto L24;
            return false;
        L24:
            if (this.f478157f == r101.f478157f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f478158g, r101.f478158g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f478159h, r101.f478159h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f478152a.hashCode() * 31;
            long r101 = this.f478153b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f478154c;
            int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f478155d.hashCode()) * 31) + this.f478156e.hashCode()) * 31;
            if (this.f478157f == false) goto L5;
            int r105 = 1231;
        L6:
            int r106 = (r104 + r105) * 31;
            WeakReference<Activity> r107 = this.f478158g;
            if (r107 != null) goto L9;
            int r108 = 0;
        L11:
            return ((r106 + r108) * 31) + this.f478159h.hashCode();
        L9:
            r108 = r107.hashCode();
            goto L11
        L5:
            r105 = 1237;
            goto L6
        }

        public final String toString() {
            return "DelayedTaskInfo(triggerActivity=" + this.f478152a + ", initialDelay=" + this.f478153b + ", startTime=" + this.f478154c + ", targetAction=" + this.f478155d + ", runnable=" + this.f478156e + ", hasReceivedCallback=" + this.f478157f + ", lastCallbackActivity=" + this.f478158g + ", errorCallback=" + this.f478159h + ')';
        }

        public C5935b(WeakReference r100, long r101, long r102, Function1 r103, fo6.c r104, Function1 r105) {
            Intrinsics.checkNotNullParameter(r100, "triggerActivity");
            Intrinsics.checkNotNullParameter(r103, "targetAction");
            Intrinsics.checkNotNullParameter(r104, "runnable");
            Intrinsics.checkNotNullParameter(r105, "errorCallback");
            this.f478152a = r100;
            this.f478153b = r101;
            this.f478154c = r102;
            this.f478155d = r103;
            this.f478156e = r104;
            this.f478157f = false;
            this.f478158g = null;
            this.f478159h = r105;
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f478160a;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f478161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f478162b;

            public a(b r100, Activity r101) {
                this.f478161a = r100;
                this.f478162b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Set<Map.Entry<String, C5935b>> r100 = this.f478161a.f478151b.entrySet();
                Activity r101 = this.f478162b;
                ArrayList r102 = new ArrayList();
                Iterator<T> r103 = r100.iterator();
            L4:
                if (r103.hasNext() == false) goto L8;
                Object r104 = r103.next();
                if (Intrinsics.areEqual(((C5935b) ((Map.Entry) r104).getValue()).f478152a.get(), r101) == false) goto L4;
                r102.add(r104);
                goto L4
            L8:
                b r105 = this.f478161a;
                Iterator r106 = r102.iterator();
            L10:
                if (r106.hasNext() == false) goto L12;
                Map.Entry r107 = (Map.Entry) r106.next();
                r105.f478151b.remove(r107.getKey());
                goto L10
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        public c(b r100) {
            this.f478160a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Task.callInBackground(new a(this.f478160a, r100));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r110) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "onActivityStarted, " + r110.getLocalClassName());
            b r100 = this.f478160a;
            Iterator<Map.Entry<String, C5935b>> r101 = r100.f478151b.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L18;
            Map.Entry<String, C5935b> r102 = r101.next();
            String r103 = r102.getKey();
            C5935b r104 = r102.getValue();
            r104.f478157f = true;
            WeakReference<Activity> r105 = r104.f478158g;
            String r106 = null;
            if (r105 == null) goto L8;
            Activity r107 = r105.get();
        L9:
            if (r107 == null) goto L12;
            r106 = r107.getLocalClassName();
        L12:
            if (Intrinsics.areEqual(r107, r110) == true) goto L13;
            r104.f478158g = new WeakReference(r110);
            if ((SystemClock.uptimeMillis() - r104.f478154c) < r104.f478153b) goto L17;
            r104.f478155d.invoke(r110);
            r100.a(r103);
            com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "时间差<0（elapsedTime >= 初始延迟）→ 执行函数, " + r106);
        L17:
            com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "时间差>0 不做任何处理, " + r106);
            goto L4
        L13:
            com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "当前回调的Activity与上一次一致，不处理, " + r106);
            goto L4
        L8:
            r107 = null;
            goto L9
        }
    }

    static {
        f478148c = new a();
    }

    public b(Application r100) {
        this.f478150a = new Handler(Looper.getMainLooper());
        this.f478151b = new ConcurrentHashMap();
        r100.registerActivityLifecycleCallbacks(new c(this));
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        C5935b r101 = this.f478151b.get(r100);
        if (r101 == null) goto L6;
        this.f478150a.removeCallbacks(r101.f478156e);
        C5935b r102 = this.f478151b.remove(r100);
        return;
    }
}
