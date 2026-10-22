package com.obric.capabilitykit.entity;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer;", "", "()V", "Companion", "CustomThreadFactory", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityThreadContainer {
    public static final Companion Companion = null;
    private static final int corePoolSize = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityThreadContainer$Companion;", "", "()V", "corePoolSize", "", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CoroutineScope getScope() {
            return CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(new PThreadPoolExecutor(EntityThreadContainer.access$getCorePoolSize$cp(), 50, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(300), new a())));
        }
    }

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f396199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f396200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f396201c;

        public a() {
            Intrinsics.checkNotNullParameter("", "prefix");
            this.f396200b = "";
            this.f396201c = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f396199a = r101;
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            StringBuilder r101 = new StringBuilder();
            r101.append(this.f396200b);
            r101.append('-');
            AtomicInteger r102 = this.f396201c;
            Intrinsics.checkNotNull(r102);
            r101.append(r102.getAndIncrement());
            String r103 = r101.toString();
            PthreadThreadV2 r104 = new PthreadThreadV2(this.f396199a, r100, r103, 0);
            if (r104.isDaemon() == false) goto L5;
            r104.setDaemon(false);
        L5:
            return r104;
        }
    }

    static {
        Companion = new Companion(null);
        corePoolSize = Runtime.getRuntime().availableProcessors() + 1;
    }

    public EntityThreadContainer() {
    }

    public static final /* synthetic */ int access$getCorePoolSize$cp() {
        return corePoolSize;
    }
}
