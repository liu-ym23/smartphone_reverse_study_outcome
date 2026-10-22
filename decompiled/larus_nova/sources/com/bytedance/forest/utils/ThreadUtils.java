package com.bytedance.forest.utils;

import android.os.AsyncTask;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainThreadExecutor f244502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f244503b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f244504c = null;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/forest/utils/ThreadUtils$Priority;", "", "HIGH", EffectConstants.NORMAL, "forest_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Priority extends Enum<Priority> {
        public static final Priority HIGH = null;
        public static final Priority NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Priority[] f244505a = null;

        static {
            Priority r100 = new Priority("HIGH", 0);
            HIGH = r100;
            Priority r101 = new Priority(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            f244505a = new Priority[]{r100, r101};
        }

        public static Priority valueOf(String r100) {
            return (Priority) r27.a.a(Priority.class, r100);
        }

        public static Priority[] values() {
            return (Priority[]) f244505a.clone();
        }

        public Priority(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f244502a = new MainThreadExecutor();
        f244503b = LazyKt.lazy(ThreadUtils$forestHandler$2.INSTANCE);
        f244504c = LazyKt.lazy(ThreadUtils$reportHandler$2.INSTANCE);
    }

    public static boolean a() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public static void b(Runnable r100) {
        if (a() == false) goto L5;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r100);
        return;
    L5:
        r100.run();
    }
}
