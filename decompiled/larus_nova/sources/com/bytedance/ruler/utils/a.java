package com.bytedance.ruler.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f267757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f267758b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f267759c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f267760d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f267761e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f267762f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ScheduledExecutorService f267763g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ExecutorService f267764h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ExecutorService f267765i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f267766j = false;

    static {
        boolean r100 = com.bytedance.ruler.d.f267693q;
        f267766j = r100;
        f267761e = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId();
        if (r100 == false) goto L5;
        f267762f = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("AsyncExecutor"));
        f267763g = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("AsyncExecutor"));
        f267764h = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AsyncExecutor"));
        f267765i = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AsyncExecutor"));
        return;
    L5:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("RulerMainBackThread");
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("RulerBackThread");
        ThreadMethodProxy.start(r101);
        ThreadMethodProxy.start(r102);
        f267757a = new Handler(r101.getLooper());
        f267758b = new Handler(r102.getLooper());
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("RulerLogThread");
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("RulerMainLogThread");
        ThreadMethodProxy.start(r103);
        ThreadMethodProxy.start(r104);
        f267759c = new Handler(r103.getLooper());
        f267760d = new Handler(r104.getLooper());
    }

    public static void b(Function0 r100) {
        if (ThreadMethodProxy.currentThread().getId() != f267761e) goto L15;
        if (f267766j == false) goto L10;
        ExecutorService r101 = f267764h;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("executorForMainLog");
    L9:
        r101.execute(new b(r100));
        return;
    L10:
        Handler r102 = f267760d;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mainLogHandler");
    L13:
        r102.post(new b(r100));
        return;
    L15:
        if (f267766j == false) goto L20;
        ExecutorService r103 = f267765i;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("executorForLog");
    L19:
        r103.execute(new b(r100));
        return;
    L20:
        Handler r104 = f267759c;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("logHandler");
    L23:
        r104.post(new b(r100));
    }

    public static void a(Function0 r100, long r101) {
        if (ThreadMethodProxy.currentThread().getId() != f267761e) goto L15;
        if (f267766j == false) goto L10;
        ScheduledExecutorService r102 = f267762f;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("executorForMain");
    L9:
        r102.schedule(new b(r100), r101, TimeUnit.MILLISECONDS);
        return;
    L10:
        Handler r103 = f267757a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");
    L13:
        r103.postDelayed(new b(r100), r101);
        return;
    L15:
        if (f267766j == false) goto L20;
        ScheduledExecutorService r104 = f267763g;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("executorForBack");
    L19:
        r104.schedule(new b(r100), r101, TimeUnit.MILLISECONDS);
        return;
    L20:
        Handler r105 = f267758b;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("backHandler");
    L23:
        r105.postDelayed(new b(r100), r101);
    }
}
