package com.ss.android.lark.appcontext.applifecycle;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class FocusHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f408807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ScheduledExecutorService f408808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ScheduledFuture<?> f408809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function1<? super Boolean, Unit> f408810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.larksuite.framework.thread.v f408811e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f408812f;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/appcontext/applifecycle/FocusHitPoint$Companion$FocusStatus;", "", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface FocusStatus {
        }

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f408813a;

            public a(long r100) {
                this.f408813a = r100;
            }

            public final void a() {
                boolean r100 = false;
                FocusHitPoint.f408807a = false;
                FocusHitPoint.f408812f = this.f408813a;
                Log.i("FocusHitPoint", "updateCurrentStatus ensured: " + this.f408813a);
                Log.i("FocusHitPoint", "handleIntervalExecutor called: " + FocusHitPoint.f408812f);
                if (FocusHitPoint.f408812f != 1) goto L17;
                com.larksuite.framework.thread.v r101 = FocusHitPoint.f408811e;
                if (r101.f285805b == null) goto L27;
                ScheduledFuture r102 = r101.f285806c;
                if (r102 != null) goto L10;
            L14:
                if (r100 == true) goto L27;
                r101.f285806c = r101.f285804a.scheduleAtFixedRate(r101.f285805b, 100, 60000, TimeUnit.MILLISECONDS);
                goto L27
            L10:
                if (r102.isCancelled() == true) goto L14;
                if (r101.f285806c.isDone() == true) goto L14;
                r100 = true;
            L27:
                FocusHitPoint.f408807a = true;
                return;
            L17:
                com.larksuite.framework.thread.v r103 = FocusHitPoint.f408811e;
                ScheduledFuture r104 = r103.f285806c;
                if (r104 != null) goto L20;
            L24:
                boolean r105 = false;
            L25:
                if (r105 == false) goto L27;
                r103.f285806c.cancel(false);
                r103.f285808e.set(0);
                goto L27
            L20:
                if (r104.isCancelled() == true) goto L24;
                if (r103.f285806c.isDone() == true) goto L24;
                r105 = true;
                goto L25
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
        }

        public static void a(long r100) {
            Log.i("FocusHitPoint", "FG_KEY_FIX_GETFOCUS_ANR is true! Using NEW logic");
            if (FocusHitPoint.f408808b != null) goto L6;
            Log.i("FocusHitPoint", "First Time, create a new ScheduledExecutorService now!");
            FocusHitPoint.f408808b = CoreThreadPool.getDefault().getSingleScheduledThreadPool("get_focus_task_thread");
        L6:
            if (FocusHitPoint.f408807a == false) goto L15;
            ScheduledFuture<?> r101 = FocusHitPoint.f408809c;
            if (r101 == null) goto L10;
            r101.cancel(false);
        L10:
            ScheduledFuture<?> r102 = null;
            FocusHitPoint.f408809c = null;
            a r103 = new a(r100);
            ScheduledExecutorService r104 = FocusHitPoint.f408808b;
            if (r104 == null) goto L13;
            r102 = r104.schedule(r103, 1000, TimeUnit.MILLISECONDS);
        L13:
            FocusHitPoint.f408809c = r102;
            return;
        }
    }

    public static final class a implements com.larksuite.framework.thread.v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f408814a = null;

        static {
            f408814a = new a();
        }

        public a() {
        }

        @Override // com.larksuite.framework.thread.v.a
        public final void a(AtomicInteger r100) {
            boolean r101 = true;
            if (r100.get() <= 1) goto L5;
            r101 = false;
        L5:
            Function1<? super Boolean, Unit> r102 = FocusHitPoint.f408810d;
            if (r102 == null) goto L9;
            r102.invoke(Boolean.valueOf(r101));
            return;
        }
    }

    static {
        f408807a = true;
        com.larksuite.framework.thread.v r100 = new com.larksuite.framework.thread.v();
        f408811e = r100;
        r100.f285807d = a.f408814a;
        f408812f = 1;
    }
}
