package com.bytedance.timonbase.utils;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TMThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f270904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f270905c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TMThreadUtils f270906d = null;

    public TMThreadUtils() {
    }

    static {
        f270906d = new TMThreadUtils();
        f270903a = LazyKt.lazy(TMThreadUtils$handlerThread$2.INSTANCE);
        f270905c = LazyKt.lazy(TMThreadUtils$mainHandler$2.INSTANCE);
    }

    public static boolean b() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public static void a(Function0 r100) {
        if (f270904b == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        f270904b = PThreadExecutorsUtils.newFixedThreadPool(8, new DefaultThreadFactory("TMThreadUtils"));
    L8:
        ExecutorService r102 = f270904b;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ioExecutor");
    L11:
        r102.execute(new b(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
