package com.ss.android.lark.officesdk.runtime;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKCoreRuntime implements IOfficeSDKRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<OfficeSerialThreadExecutor> f437165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<OfficeSerialThreadExecutor> f437166b = null;

    public static final class OfficeSerialThreadExecutor implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f437167a;

        public OfficeSerialThreadExecutor(final int r100) {
            this.f437167a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new OfficeSDKCoreRuntime$OfficeSerialThreadExecutor$executor$2(r100));
        }
    }

    public static final class a {
    }

    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f437168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ThreadFactory f437169b;

        public b(int r100) {
            this.f437168a = r100;
            this.f437169b = Executors.defaultThreadFactory();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Thread r101 = this.f437169b.newThread(r100);
            ThreadMethodProxy.setPriority(r101, this.f437168a);
            ThreadMethodProxy.setName(r101, "OfficeSDK_CoreRuntime");
            return r101;
        }
    }

    public interface c {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f437165a = LazyKt.lazy(r100, OfficeSDKCoreRuntime$Companion$highPriorityExecutor$2.INSTANCE);
        f437166b = LazyKt.lazy(r100, OfficeSDKCoreRuntime$Companion$normalPriorityExecutor$2.INSTANCE);
    }
}
