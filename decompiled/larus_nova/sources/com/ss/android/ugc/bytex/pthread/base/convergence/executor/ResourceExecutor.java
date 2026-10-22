package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.byted.cast.common.TeaEventTrack;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.ThreadUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0004?@ABBS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u0014H\u0016J\u0012\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0002J\u001b\u0010%\u001a\u0004\u0018\u00010\n2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0'H\u0082\bJ\u0006\u0010(\u001a\u00020#J\u0012\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0006\u0010/\u001a\u00020\u0006J\b\u00100\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u0014H\u0016J\n\u00106\u001a\u0004\u0018\u00010\nH\u0002J\n\u00107\u001a\u0004\u0018\u00010\nH\u0016J\n\u00108\u001a\u0004\u0018\u00010\nH\u0002J\b\u00109\u001a\u00020!H\u0016J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0016J\u0010\u0010<\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010=\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010>\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u0006H\u0002R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "executor", "Ljava/util/concurrent/Executor;", "minPoolSize", "", "maxPoolSize", "queue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "keepAliveTime", "", "executePolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "threadPrefix", "", "(Ljava/util/concurrent/Executor;IILjava/util/concurrent/BlockingQueue;JLcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;Ljava/lang/String;)V", "affiliatedExecutors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "consumeCount", "Ljava/util/concurrent/atomic/AtomicLong;", "createThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "cts", "maxThreadSize", "migrateCount", "migrateExecutors", "minThreadSize", "pendingCount", "waiterCount", "accepting", "", "addWorker", "", "force", "blockingTake", "taker", "Lkotlin/Function0;", "decrementWorker", "execute", "command", "getConsumeCount", "getInstrumentation", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", "getMaxPoolSize", "getMinPoolSize", "getPendingCount", "getPoolSize", "interruptIdle", "expectCount", "isMainTaskPending", "migrateTo", TeaEventTrack.ACTION_DRAMA_NEXT, "nextMigrant", "nextMigrateRunnable", "notifyMigrated", "prestart", "count", "setMaxPoolSize", "setMinPoolSize", "tryInterruptWaiter", "InterruptRunnable", "Notifier", "RuntimeInstrumentation", "Worker", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ResourceExecutor implements ExpandablePool, IResourceExecutor {
    private final CopyOnWriteArrayList<MigrateExecutor> affiliatedExecutors;
    private final AtomicLong consumeCount;
    private final AtomicInteger createThreadCount;
    private final AtomicInteger cts;
    private final IThreadExecutePolicy executePolicy;
    private final Executor executor;
    private long keepAliveTime;
    private volatile int maxThreadSize;
    private final AtomicInteger migrateCount;
    private final CopyOnWriteArrayList<MigrateExecutor> migrateExecutors;
    private volatile int minThreadSize;
    private final AtomicInteger pendingCount;
    private final BlockingQueue<Runnable> queue;
    private final String threadPrefix;
    private final AtomicInteger waiterCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor$InterruptRunnable;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/NothingRunnable;", "()V", "expectThreadCount", "", "getExpectThreadCount", "()I", "setExpectThreadCount", "(I)V", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "unlock", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class InterruptRunnable extends NothingRunnable {
        public static final InterruptRunnable INSTANCE = null;
        private static volatile int expectThreadCount;
        private static final AtomicBoolean running = null;

        static {
            INSTANCE = new InterruptRunnable();
            running = new AtomicBoolean();
        }

        private InterruptRunnable() {
        }

        public final int getExpectThreadCount() {
            return expectThreadCount;
        }

        public final boolean lock() {
            return running.compareAndSet(false, true);
        }

        public final void setExpectThreadCount(int r100) {
            expectThreadCount = r100;
        }

        public final void unlock() {
            running.set(false);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor$Notifier;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/NothingRunnable;", "()V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Notifier extends NothingRunnable {
        public static final Notifier INSTANCE = null;

        static {
            INSTANCE = new Notifier();
        }

        private Notifier() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor$RuntimeInstrumentation;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor;)V", "extra", "", "", "getMaxThreadSize", "", "getName", "getPendingSize", "getReleaseSize", "getThreadSize", "getWaiterSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class RuntimeInstrumentation implements Instrumentation {
        private final ResourceExecutor executor;

        public RuntimeInstrumentation(ResourceExecutor r100) {
            this.executor = r100;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public Map<String, String> extra() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("consume", String.valueOf(this.executor.getConsumeCount())), TuplesKt.to("queueSize: ", String.valueOf(ResourceExecutor.access$getQueue$p(this.executor).size())), TuplesKt.to("migrateCount", String.valueOf(ResourceExecutor.access$getMigrateCount$p(this.executor).get()))});
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public int getMaxThreadSize() {
            return ResourceExecutor.access$getMaxThreadSize$p(this.executor);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public String getName() {
            String r100 = ResourceExecutor.access$getThreadPrefix$p(this.executor);
            if (r100 != null) goto L7;
            return "null";
        L7:
            return r100;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public int getPendingSize() {
            return ResourceExecutor.access$getPendingCount$p(this.executor).get();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public int getReleaseSize() {
            return ResourceExecutor.access$getCreateThreadCount$p(this.executor).get() - this.executor.getPoolSize();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public int getThreadSize() {
            return this.executor.getPoolSize();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation
        public int getWaiterSize() {
            return ResourceExecutor.access$getWaiterCount$p(this.executor).get();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor$Worker;", "Ljava/lang/Runnable;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutor;)V", "run", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public final class Worker implements Runnable {
        final /* synthetic */ ResourceExecutor this$0;

        public Worker(ResourceExecutor r100) {
            this.this$0 = r100;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread r100 = Thread.currentThread();
            IThreadExecutePolicy r101 = ResourceExecutor.access$getExecutePolicy$p(this.this$0);
            if (ResourceExecutor.access$getThreadPrefix$p(this.this$0) == null) goto L6;
            r100.setName(ResourceExecutor.access$getThreadPrefix$p(this.this$0) + "-" + ResourceExecutor.access$getCreateThreadCount$p(this.this$0).incrementAndGet());
        L6:
            if (r101 == null) goto L11;
            r101.onThreadStartUp(r100);     // Catch: Throwable -> L9
        L9:
            Throwable th10 = th;
            boolean r102 = false;
        L44:
            ResourceExecutor.access$getCts$p(this.this$0).decrementAndGet();
            if (ResourceExecutor.access$getCts$p(this.this$0).get() <= ResourceExecutor.access$getMinThreadSize$p(this.this$0)) goto L47;
        L49:
            if (r102 == false) goto L51;
            ResourceExecutor.tryInterruptWaiter$default(this.this$0, 0, 1, null);
        L51:
            if (r101 == null) goto L73;
            r101.onThreadRelease(r100);
            throw th10;
        L73:
            throw th10;
        L47:
            if ((!ResourceExecutor.access$getQueue$p(this.this$0).isEmpty()) == false) goto L49;
            ResourceExecutor.addWorker$default(this.this$0, false, 1, null);
        L11:
            boolean r103 = false;
        L58:
            Runnable r104 = ResourceExecutor.access$nextMigrateRunnable(this.this$0);     // Catch: Throwable -> L42
            if (r104 == null) goto L15;
            boolean r105 = true;
        L16:
            if (r104 == null) goto L18;
            InterruptRunnable r106 = InterruptRunnable.INSTANCE;     // Catch: Throwable -> L42
            if (Intrinsics.areEqual(r104, r106) == false) goto L36;
            r106.unlock();     // Catch: Throwable -> L33
            r103 = true;
        L33:
            th10 = th;
            r102 = true;
            goto L44
        L36:
            if (Intrinsics.areEqual(r104, Notifier.INSTANCE) == true) goto L58;
            if (r105 == false) goto L39;
            ResourceExecutor.access$getMigrateCount$p(this.this$0).incrementAndGet();     // Catch: Throwable -> L9
        L40:
            r104.run();     // Catch: Throwable -> L9
            goto L11
        L39:
            ResourceExecutor.access$getPendingCount$p(this.this$0).decrementAndGet();     // Catch: Throwable -> L9
            ResourceExecutor.access$getConsumeCount$p(this.this$0).incrementAndGet();     // Catch: Throwable -> L9
            goto L40
        L18:
            if (this.this$0.decrementWorker() == false) goto L58;
            if (ResourceExecutor.access$getCts$p(this.this$0).get() <= ResourceExecutor.access$getMinThreadSize$p(this.this$0)) goto L22;
        L24:
            if (r103 == false) goto L26;
            ResourceExecutor.tryInterruptWaiter$default(this.this$0, 0, 1, null);
        L26:
            if (r101 == null) goto L72;
            r101.onThreadRelease(r100);
            return;
        L72:
            return;
        L22:
            if ((!ResourceExecutor.access$getQueue$p(this.this$0).isEmpty()) == false) goto L24;
            ResourceExecutor.addWorker$default(this.this$0, false, 1, null);
            goto L24
        L15:
            r104 = ResourceExecutor.access$next(this.this$0);     // Catch: Throwable -> L42
            r105 = false;
        L42:
            th = move-exception;
            r102 = r103;
            th10 = th;
            goto L44
        }
    }

    public ResourceExecutor(Executor r100, int r101, int r102, BlockingQueue<Runnable> r103, long r104, IThreadExecutePolicy r105, String r106) {
        this.executor = r100;
        this.queue = r103;
        this.keepAliveTime = r104;
        this.executePolicy = r105;
        this.threadPrefix = r106;
        this.maxThreadSize = r102;
        this.minThreadSize = r101;
        this.cts = new AtomicInteger();
        this.consumeCount = new AtomicLong();
        this.createThreadCount = new AtomicInteger();
        this.waiterCount = new AtomicInteger();
        this.pendingCount = new AtomicInteger();
        this.migrateCount = new AtomicInteger();
        this.migrateExecutors = new CopyOnWriteArrayList();
        this.affiliatedExecutors = new CopyOnWriteArrayList();
    }

    public /* synthetic */ ResourceExecutor(Executor r100, int r110, int r111, BlockingQueue r112, long r113, IThreadExecutePolicy r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 2) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r116 & 4) == 0) goto L9;
        int r102 = 1;
    L11:
        if ((r116 & 8) == 0) goto L13;
        BlockingQueue r103 = new LinkedBlockingQueue();
    L15:
        if ((r116 & 16) == 0) goto L17;
        long r104 = 0;
    L18:
        String r105 = null;
        if ((r116 & 32) == 0) goto L21;
        IThreadExecutePolicy r106 = null;
    L23:
        if ((r116 & 64) != 0) goto L26;
        r105 = r115;
    L26:
        this(r100, r101, r102, r103, r104, r106, r105);
        return;
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static final /* synthetic */ AtomicLong access$getConsumeCount$p(ResourceExecutor r100) {
        return r100.consumeCount;
    }

    public static final /* synthetic */ AtomicInteger access$getCreateThreadCount$p(ResourceExecutor r100) {
        return r100.createThreadCount;
    }

    public static final /* synthetic */ AtomicInteger access$getCts$p(ResourceExecutor r100) {
        return r100.cts;
    }

    public static final /* synthetic */ IThreadExecutePolicy access$getExecutePolicy$p(ResourceExecutor r100) {
        return r100.executePolicy;
    }

    public static final /* synthetic */ int access$getMaxThreadSize$p(ResourceExecutor r100) {
        return r100.maxThreadSize;
    }

    public static final /* synthetic */ AtomicInteger access$getMigrateCount$p(ResourceExecutor r100) {
        return r100.migrateCount;
    }

    public static final /* synthetic */ int access$getMinThreadSize$p(ResourceExecutor r100) {
        return r100.minThreadSize;
    }

    public static final /* synthetic */ AtomicInteger access$getPendingCount$p(ResourceExecutor r100) {
        return r100.pendingCount;
    }

    public static final /* synthetic */ BlockingQueue access$getQueue$p(ResourceExecutor r100) {
        return r100.queue;
    }

    public static final /* synthetic */ String access$getThreadPrefix$p(ResourceExecutor r100) {
        return r100.threadPrefix;
    }

    public static final /* synthetic */ AtomicInteger access$getWaiterCount$p(ResourceExecutor r100) {
        return r100.waiterCount;
    }

    public static final /* synthetic */ Runnable access$next(ResourceExecutor r100) {
        return r100.next();
    }

    public static final /* synthetic */ Runnable access$nextMigrateRunnable(ResourceExecutor r100) {
        return r100.nextMigrateRunnable();
    }

    public static final /* synthetic */ void access$setMaxThreadSize$p(ResourceExecutor r100, int r101) {
        r100.maxThreadSize = r101;
    }

    public static final /* synthetic */ void access$setMinThreadSize$p(ResourceExecutor r100, int r101) {
        r100.minThreadSize = r101;
    }

    private final boolean addWorker(boolean r100) {
        int r101 = this.cts.get();
        int r102 = this.maxThreadSize;
    L4:
        if (r101 >= r102) goto L14;
        if (r100 == true) goto L10;
        if (this.queue.isEmpty() == false) goto L10;
        return false;
    L10:
        if (this.cts.compareAndSet(r101, r101 + 1) == true) goto L11;
        r101 = this.cts.get();
        goto L4
    L11:
        this.executor.execute(new Worker(this));
        return true;
    L14:
        return false;
    }

    public static /* synthetic */ boolean addWorker$default(ResourceExecutor r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.addWorker(r101);
    }

    private final Runnable blockingTake(Function0<? extends Runnable> r100) {
        if ((!access$getQueue$p(this).isEmpty()) == false) goto L14;
        Runnable r101 = (Runnable) access$getQueue$p(this).poll();
        if (r101 == null) goto L14;
        return r101;
    L14:
        access$getWaiterCount$p(this).incrementAndGet();     // Catch: Throwable -> L9 InterruptedException -> L12
        Runnable r102 = r100.invoke();     // Catch: Throwable -> L9 InterruptedException -> L12
        InlineMarker.finallyStart(1);
        access$getWaiterCount$p(this).decrementAndGet();
        InlineMarker.finallyEnd(1);
        return r102;
    L12:
        InlineMarker.finallyStart(1);
        access$getWaiterCount$p(this).decrementAndGet();
        InlineMarker.finallyEnd(1);
        return null;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        access$getWaiterCount$p(this).decrementAndGet();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final void interruptIdle(int r100) {
        InterruptRunnable.INSTANCE.setExpectThreadCount(r100);
        tryInterruptWaiter$default(this, 0, 1, null);
    }

    private final boolean isMainTaskPending() {
        if (this.pendingCount.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final Runnable next() {
        int r100 = this.cts.get();
        Runnable r101 = null;
        if (r100 <= this.maxThreadSize) goto L6;
        return null;
    L6:
        if (r100 <= this.minThreadSize) goto L8;
        long r102 = this.keepAliveTime;
        if (r102 <= 0) goto L35;
        if ((!access$getQueue$p(this).isEmpty()) == false) goto L38;
        Runnable r103 = (Runnable) access$getQueue$p(this).poll();
        if (r103 == null) goto L38;
        return r103;
    L38:
        access$getWaiterCount$p(this).incrementAndGet();     // Catch: Throwable -> L29 InterruptedException -> L32
        Runnable r104 = this.queue.poll(r102, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L29 InterruptedException -> L32
        access$getWaiterCount$p(this).decrementAndGet();
        r101 = r104;
    L41:
        return r101;
    L32:
        access$getWaiterCount$p(this).decrementAndGet();
    L29:
        th = move-exception;
        access$getWaiterCount$p(this).decrementAndGet();
        throw th;
    L35:
        return this.queue.poll();
    L8:
        if ((!access$getQueue$p(this).isEmpty()) == false) goto L36;
        Runnable r105 = (Runnable) access$getQueue$p(this).poll();
        if (r105 == null) goto L36;
        return r105;
    L36:
        access$getWaiterCount$p(this).incrementAndGet();     // Catch: Throwable -> L14 InterruptedException -> L17
        Runnable r106 = this.queue.take();     // Catch: Throwable -> L14 InterruptedException -> L17
        access$getWaiterCount$p(this).decrementAndGet();
        r101 = r106;
    L19:
        return r101;
    L17:
        access$getWaiterCount$p(this).decrementAndGet();
    L14:
        th = move-exception;
        access$getWaiterCount$p(this).decrementAndGet();
        throw th;
    }

    private final Runnable nextMigrateRunnable() {
        if (isMainTaskPending() == false) goto L6;
        return null;
    L6:
        if (this.migrateExecutors.isEmpty() == false) goto L8;
        return null;
    L8:
        Iterator<T> r100 = this.migrateExecutors.iterator();
    L10:
        if (r100.hasNext() == false) goto L14;
        Runnable r101 = ((MigrateExecutor) r100.next()).nextMigrant();
        if (r101 == null) goto L10;
        return r101;
    L14:
        return null;
    }

    private final void tryInterruptWaiter(int r100) {
        if (this.queue.isEmpty() == true) goto L5;
        return;
    L5:
        if (r100 > this.minThreadSize) goto L7;
        return;
    L7:
        if (this.cts.get() > r100) goto L9;
        return;
    L9:
        if (this.waiterCount.get() <= 0) goto L17;
        InterruptRunnable r101 = InterruptRunnable.INSTANCE;
        if (r101.lock() == false) goto L18;
        this.queue.offer(r101);
        return;
    L18:
        return;
    }

    public static /* synthetic */ void tryInterruptWaiter$default(ResourceExecutor r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = InterruptRunnable.INSTANCE.getExpectThreadCount();
    L5:
        r100.tryInterruptWaiter(r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void accepting(MigrateExecutor r100) {
        this.migrateExecutors.add(r100);
    }

    public final boolean decrementWorker() {
        int r100 = this.minThreadSize;
    L3:
        int r101 = this.cts.get();
        if (r101 <= r100) goto L9;
        if (this.cts.compareAndSet(r101, r101 - 1) == false) goto L3;
        return true;
    L9:
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (r100 == null) goto L5;
        this.pendingCount.incrementAndGet();
        this.queue.offer(r100);
    L5:
        if (addWorker$default(this, false, 1, null) == false) goto L7;
        return;
    L7:
        if (this.waiterCount.get() == 0) goto L9;
        return;
    L9:
        if (isMainTaskPending() == true) goto L11;
        return;
    L11:
        if ((!this.affiliatedExecutors.isEmpty()) == true) goto L13;
        return;
    L13:
        if (ThreadUtils.isMainThread() == true) goto L23;
        Iterator<T> r101 = this.affiliatedExecutors.iterator();
    L16:
        if (r101.hasNext() == false) goto L24;
        ((MigrateExecutor) r101.next()).notifyMigrated();
        goto L16
    L24:
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public long getConsumeCount() {
        return this.consumeCount.get();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutor
    public Instrumentation getInstrumentation() {
        return new RuntimeInstrumentation(this);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getMaxPoolSize() {
        return this.maxThreadSize;
    }

    public final int getMinPoolSize() {
        return this.minThreadSize;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getPendingCount() {
        return this.pendingCount.get();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public int getPoolSize() {
        return this.cts.get();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void migrateTo(MigrateExecutor r100) {
        r100.accepting(this);
        this.affiliatedExecutors.add(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public Runnable nextMigrant() {
        if (isMainTaskPending() == true) goto L5;
        return null;
    L5:
        Runnable r100 = this.queue.poll();
        if (r100 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r100, InterruptRunnable.INSTANCE) == false) goto L12;
        tryInterruptWaiter$default(this, 0, 1, null);
        return null;
    L12:
        if (Intrinsics.areEqual(r100, Notifier.INSTANCE) == false) goto L14;
        return null;
    L14:
        this.pendingCount.decrementAndGet();
        this.consumeCount.incrementAndGet();
        return r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void notifyMigrated() {
        if (isMainTaskPending() == false) goto L5;
        return;
    L5:
        if (this.waiterCount.get() <= this.queue.size()) goto L9;
        this.queue.offer(Notifier.INSTANCE);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.PrestartableExecutor
    public void prestart(int r100) {
        Executor r101 = this.executor;
        if ((r101 instanceof PrestartableExecutor) == false) goto L5;
        ((PrestartableExecutor) r101).prestart(r100);
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r100) goto L11;
        if (addWorker(true) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool
    public void setMaxPoolSize(int r100) {
        int r101 = r100 - this.maxThreadSize;
        this.maxThreadSize = r100;
        if (r101 <= 0) goto L7;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        addWorker$default(this, false, 1, null);
        r102 = r102 + 1;
        goto L5
    L10:
        return;
    L7:
        interruptIdle(r100);
    }

    public final void setMinPoolSize(int r100) {
        if (r100 > 0) goto L4;
    L8:
        int r101 = this.minThreadSize - r100;
        this.minThreadSize = r100;
        int r102 = this.cts.get();
        if (r101 <= 0) goto L11;
        interruptIdle(r100);
        return;
    L11:
        if (r100 <= r102) goto L17;
        int r103 = r100 - r102;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L18;
        addWorker$default(this, false, 1, null);
        r104 = r104 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L4:
        if (this.keepAliveTime != 0) goto L8;
        throw new IllegalArgumentException("keepAliveTime must not be 0 when minPoolSize > 0");
    }
}
