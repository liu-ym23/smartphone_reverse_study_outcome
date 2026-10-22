package kotlinx.coroutines.scheduling;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.larus.apm.impl.protector.RunnableProtector;
import duc.g;
import duc.h;
import duc.j;
import duc.k;
import duc.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.w;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505060h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f505061i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505062j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b0 f505063k = null;
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f505064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f505066c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f505067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final duc.c f505068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final duc.c f505069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w<c> f505070g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum WorkerState extends Enum<WorkerState> {
        public static final WorkerState BLOCKING = null;
        public static final WorkerState CPU_ACQUIRED = null;
        public static final WorkerState DORMANT = null;
        public static final WorkerState PARKING = null;
        public static final WorkerState TERMINATED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WorkerState[] f505071a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f505072b = null;

        public static EnumEntries<WorkerState> getEntries() {
            return f505072b;
        }

        public static WorkerState valueOf(String r100) {
            return (WorkerState) r27.a.a(WorkerState.class, r100);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) f505071a.clone();
        }

        static {
            WorkerState r100 = new WorkerState("CPU_ACQUIRED", 0);
            CPU_ACQUIRED = r100;
            WorkerState r101 = new WorkerState("BLOCKING", 1);
            BLOCKING = r101;
            WorkerState r102 = new WorkerState("PARKING", 2);
            PARKING = r102;
            WorkerState r103 = new WorkerState("DORMANT", 3);
            DORMANT = r103;
            WorkerState r104 = new WorkerState("TERMINATED", 4);
            TERMINATED = r104;
            WorkerState[] r105 = {r100, r101, r102, r103, r104};
            f505071a = r105;
            f505072b = EnumEntriesKt.enumEntries(r105);
        }

        public WorkerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f505073a = null;

        static {
            int[] r100 = new int[WorkerState.values().length];
            r100[WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f505073a = r100;
        }
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f505074i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f505075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Ref.ObjectRef<g> f505076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WorkerState f505077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f505078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f505079e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f505080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f505081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ CoroutineScheduler f505082h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        static {
            f505074i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");
        }

        public c() {
            throw null;
        }

        public final g f() {
            if (e(2) != 0) goto L9;
            g r100 = this.f505082h.f505068e.d();
            if (r100 == null) goto L8;
            return r100;
        L8:
            return this.f505082h.f505069f.d();
        L9:
            g r101 = this.f505082h.f505069f.d();
            if (r101 == null) goto L13;
            return r101;
        L13:
            return this.f505082h.f505068e.d();
        }

        public final void d() {
        L3:
            boolean r100 = false;
        L4:
            CoroutineScheduler r101 = this.f505082h;
            r101.getClass();
            if (CoroutineScheduler.f505062j.get(r101) == 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L107;
            WorkerState r103 = this.f505077c;
            WorkerState r104 = WorkerState.TERMINATED;
            if (r103 == r104) goto L107;
            g r105 = a(this.f505081g);
            if (r105 != null) goto L13;
            this.f505081g = false;
            if (this.f505079e != 0) goto L42;
            Object r106 = this.nextParkedWorker;
            b0 r107 = CoroutineScheduler.f505063k;
            if (r106 == r107) goto L48;
            boolean r108 = true;
        L50:
            if (r108 == false) goto L51;
            int r109 = -1;
            f505074i.set(this, -1);
        L60:
            if (this.nextParkedWorker == CoroutineScheduler.f505063k) goto L62;
            boolean r110 = true;
        L63:
            if (r110 == false) goto L4;
            AtomicIntegerFieldUpdater r111 = f505074i;
            if (r111.get(this) != r109) goto L4;
            CoroutineScheduler r112 = this.f505082h;
            r112.getClass();
            AtomicIntegerFieldUpdater r113 = CoroutineScheduler.f505062j;
            if (r113.get(r112) == 0) goto L69;
            boolean r114 = true;
        L70:
            if (r114 == true) goto L4;
            WorkerState r115 = this.f505077c;
            WorkerState r116 = WorkerState.TERMINATED;
            if (r115 == r116) goto L4;
            i(WorkerState.PARKING);
            Thread.interrupted();
            if (this.f505078d != 0) goto L77;
            this.f505078d = System.nanoTime() + this.f505082h.f505066c;
        L77:
            LockSupport.parkNanos(this.f505082h.f505066c);
            if ((System.nanoTime() - this.f505078d) < 0) goto L106;
            this.f505078d = 0;
            CoroutineScheduler r117 = this.f505082h;
            w<c> r118 = r117.f505070g;
            monitor-enter(r118);
            if (r113.get(r117) == 0) goto L84;
            boolean r119 = true;
        L85:
            if (r119 == false) goto L88;
            monitor-exit(r118);
            goto L106
        L88:
            AtomicLongFieldUpdater r120 = CoroutineScheduler.f505061i;     // Catch: Throwable -> L103
            if (((int) (r120.get(r117) & 2097151)) > r117.f505064a) goto L94;
            monitor-exit(r118);
            goto L106
        L94:
            if (r111.compareAndSet(this, -1, 1) == true) goto L97;
            monitor-exit(r118);
            goto L106
        L97:
            int r121 = this.indexInArray;     // Catch: Throwable -> L103
            g(0);     // Catch: Throwable -> L103
            r117.c(this, r121, 0);     // Catch: Throwable -> L103
            int r122 = (int) (r120.getAndDecrement(r117) & 2097151);     // Catch: Throwable -> L103
            if (r122 == r121) goto L100;
            c r123 = r117.f505070g.b(r122);     // Catch: Throwable -> L103
            Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L103
            c r124 = r123;     // Catch: Throwable -> L103
            r117.f505070g.c(r121, r124);     // Catch: Throwable -> L103
            r124.g(r121);     // Catch: Throwable -> L103
            r117.c(r124, r122, r121);     // Catch: Throwable -> L103
        L100:
            r117.f505070g.c(r122, null);     // Catch: Throwable -> L103
            Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L103
            monitor-exit(r118);
            this.f505077c = r116;
            goto L106
        L84:
            r119 = false;
        L103:
            th = move-exception;
            throw th;
        L106:
            r109 = -1;
            goto L60
        L69:
            r114 = false;
            goto L70
        L62:
            r110 = false;
            goto L63
        L51:
            CoroutineScheduler r126 = this.f505082h;
            r126.getClass();
            if (this.nextParkedWorker != r107) goto L4;
            AtomicLongFieldUpdater r127 = CoroutineScheduler.f505060h;
        L55:
            long r128 = r127.get(r126);
            int r129 = (int) (r128 & 2097151);
            int r130 = this.indexInArray;
            this.nextParkedWorker = r126.f505070g.b(r129);
            if (CoroutineScheduler.f505060h.compareAndSet(r126, r128, ((2097152 + r128) & (-2097152)) | ((long) r130)) == false) goto L55;
        L48:
            r108 = false;
            goto L50
        L42:
            if (r100 == true) goto L44;
            r100 = true;
            goto L4
        L44:
            i(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.f505079e);
            this.f505079e = 0;
            goto L3
        L13:
            this.f505079e = 0;
            int r131 = r105.f470067b.getTaskMode();
            this.f505078d = 0;
            if (this.f505077c != WorkerState.PARKING) goto L16;
            this.f505077c = WorkerState.BLOCKING;
        L16:
            if (r131 != 0) goto L19;
        L27:
            this.f505082h.getClass();
            r105.run();     // Catch: Throwable -> L30
        L33:
            if (r131 == 0) goto L3;
            CoroutineScheduler r132 = this.f505082h;
            CoroutineScheduler.f505061i.addAndGet(r132, -2097152);
            if (this.f505077c == r104) goto L3;
            this.f505077c = WorkerState.DORMANT;
        L30:
            th = move-exception;
            Thread r133 = Thread.currentThread();     // Catch: Throwable -> L38
            r133.getUncaughtExceptionHandler().uncaughtException(r133, th);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        L19:
            if (i(WorkerState.BLOCKING) == false) goto L27;
            CoroutineScheduler r134 = this.f505082h;
            if (r134.e() == true) goto L27;
            if (r134.d(CoroutineScheduler.f505061i.get(r134)) == true) goto L27;
            r134.e();
        L107:
            i(WorkerState.TERMINATED);
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final g a(boolean r110) {
            boolean r100 = false;
            if (this.f505077c == WorkerState.CPU_ACQUIRED) goto L14;
            CoroutineScheduler r101 = this.f505082h;
            AtomicLongFieldUpdater r102 = CoroutineScheduler.f505061i;
        L6:
            long r103 = r102.get(r101);
            if (((int) ((9223367638808264704L & r103) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.f505061i.compareAndSet(r101, r103, r103 - 4398046511104L) == false) goto L6;
            boolean r104 = true;
        L12:
            if (r104 == false) goto L15;
            this.f505077c = WorkerState.CPU_ACQUIRED;
            goto L14
        L15:
            boolean r105 = false;
        L16:
            g r106 = null;
            if (r105 == false) goto L41;
            if (r110 == true) goto L20;
            g r111 = f();
            if (r111 == null) goto L40;
            return r111;
        L40:
            return l(3);
        L20:
            if (e(this.f505082h.f505064a * 2) != 0) goto L22;
            r100 = true;
        L22:
            if (r100 == false) goto L26;
            g r112 = f();
            if (r112 == null) goto L26;
            return r112;
        L26:
            m r113 = this.f505075a;
            r113.getClass();
            g r107 = (g) m.f470079b.getAndSet(r113, null);
            if (r107 != null) goto L29;
            g r114 = r113.c();
        L30:
            if (r114 != null) goto L88;
            if (r100 == true) goto L40;
            g r115 = f();
            if (r115 == null) goto L40;
            return r115;
        L88:
            return r114;
        L29:
            r114 = r107;
            goto L30
        L41:
            m r116 = this.f505075a;
            r116.getClass();
        L42:
            AtomicReferenceFieldUpdater r108 = m.f470079b;
            g r109 = (g) r108.get(r116);
            if (r109 == null) goto L58;
            if (r109.f470067b.getTaskMode() != 1) goto L48;
            boolean r117 = true;
        L49:
            if (r117 != true) goto L58;
        L51:
            if (r108.compareAndSet(r116, r109, null) == true) goto L52;
            if (r108.get(r116) == r109) goto L51;
            boolean r118 = false;
        L56:
            if (r118 == false) goto L42;
        L65:
            r106 = r109;
        L66:
            if (r106 != null) goto L91;
            g r119 = this.f505082h.f505069f.d();
            if (r119 == null) goto L70;
            return r119;
        L70:
            return l(1);
        L91:
            return r106;
        L52:
            r118 = true;
            goto L56
        L48:
            r117 = false;
        L58:
            int r120 = m.f470081d.get(r116);
            int r121 = m.f470080c.get(r116);
        L59:
            if (r120 == r121) goto L66;
            if (m.f470082e.get(r116) == 0) goto L66;
            r121 = r121 - 1;
            r109 = r116.d(r121, true);
            if (r109 == null) goto L59;
        L8:
            r104 = false;
        L14:
            r105 = true;
            goto L16
        }

        public final int e(int r100) {
            int r101 = this.f505080f;
            int r102 = r101 ^ (r101 << 13);
            int r103 = r102 ^ (r102 >> 17);
            int r104 = r103 ^ (r103 << 5);
            this.f505080f = r104;
            int r105 = r100 - 1;
            if ((r105 & r100) != 0) goto L7;
            return r104 & r105;
        L7:
            return (r104 & Integer.MAX_VALUE) % r100;
        }

        public final void g(int r100) {
            StringBuilder r101 = new StringBuilder();
            r101.append(this.f505082h.f505067d);
            r101.append("-worker-");
            if (r100 != 0) goto L5;
            String r102 = "TERMINATED";
        L6:
            r101.append(r102);
            setName(r101.toString());
            this.indexInArray = r100;
            return;
        L5:
            r102 = String.valueOf(r100);
            goto L6
        }

        public final void h(Object r100) {
            this.nextParkedWorker = r100;
        }

        public final boolean i(WorkerState r100) {
            WorkerState r101 = this.f505077c;
            if (r101 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            CoroutineScheduler r103 = this.f505082h;
            CoroutineScheduler.f505061i.addAndGet(r103, 4398046511104L);
        L8:
            if (r101 == r100) goto L10;
            this.f505077c = r100;
        L10:
            return r102;
        L5:
            r102 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v14, types: [duc.g] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5, types: [duc.g] */
        /* JADX WARN: Type inference failed for: r8v3, types: [T, duc.g, java.lang.Object] */
        public final g l(int r110) {
            int r100 = (int) (CoroutineScheduler.f505061i.get(this.f505082h) & 2097151);
            Object r101 = null;
            if (r100 >= 2) goto L5;
            return null;
        L5:
            int r102 = e(r100);
            CoroutineScheduler r103 = this.f505082h;
            int r111 = 0;
            long r112 = Long.MAX_VALUE;
        L6:
            if (r111 >= r100) goto L68;
            int r104 = r102 + 1;
            if (r104 <= r100) goto L10;
            r104 = 1;
        L10:
            c r105 = r103.f505070g.b(r104);
            if (r105 == null) goto L65;
            if (r105 == this) goto L65;
            m r106 = r105.f505075a;
            Ref.ObjectRef<g> r107 = this.f505076b;
            if (r110 != 3) goto L16;
            T r108 = r106.c();
        L29:
            if (r108 == 0) goto L31;
            r107.element = r108;
            int r113 = r104;
        L56:
            long r109 = -1;
            long r114 = -1;
        L58:
            if (r114 == r109) goto L59;
            if (r114 <= 0) goto L66;
            r112 = Math.min(r112, r114);
        L66:
            r111 = r111 + 1;
            r102 = r113;
            r101 = null;
            goto L6
        L59:
            Ref.ObjectRef<g> r115 = this.f505076b;
            g r116 = r115.element;
            r115.element = null;
            return r116;
        L31:
            AtomicReferenceFieldUpdater r117 = m.f470079b;
            ?? r118 = (g) r117.get(r106);
            if (r118 == 0) goto L43;
            if (r118.f470067b.getTaskMode() != 1) goto L37;
            boolean r119 = true;
        L38:
            if (r119 == false) goto L40;
            int r120 = 1;
        L42:
            if ((r120 & r110) == 0) goto L43;
            k.f470075f.getClass();
            r113 = r104;
            long r121 = System.nanoTime() - r118.f470066a;
            long r122 = k.f470071b;
            if (r121 < r122) goto L47;
        L49:
            if (r117.compareAndSet(r106, r118, null) == true) goto L50;
            if (r117.get(r106) == r118) goto L49;
            boolean r123 = false;
        L54:
            if (r123 == true) goto L55;
            r104 = r113;
            goto L31
        L55:
            r107.element = r118;
            goto L56
        L50:
            r123 = true;
            goto L54
        L47:
            r114 = r122 - r121;
        L44:
            r109 = -1;
            goto L58
        L40:
            r120 = 2;
            goto L42
        L37:
            r119 = false;
        L43:
            r114 = -2;
            r113 = r104;
            goto L44
        L16:
            r106.getClass();
            int r124 = m.f470081d.get(r106);
            int r125 = m.f470080c.get(r106);
            if (r110 != 1) goto L19;
            boolean r126 = true;
        L20:
            if (r124 == r125) goto L28;
            if (r126 == true) goto L23;
        L25:
            int r127 = r124 + 1;
            r108 = r106.d(r124, r126);
            if (r108 != 0) goto L29;
            r124 = r127;
            goto L20
        L23:
            if (m.f470082e.get(r106) != 0) goto L25;
        L28:
            r108 = r101;
            goto L29
        L19:
            r126 = false;
        L65:
            r113 = r104;
            goto L66
        L68:
            if (r112 != Long.MAX_VALUE) goto L71;
            r112 = 0;
        L71:
            this.f505079e = r112;
            return null;
        }

        public c(CoroutineScheduler r100, int r101) {
            this.f505082h = r100;
            setDaemon(true);
            setContextClassLoader(r100.getClass().getClassLoader());
            this.f505075a = new m();
            this.f505076b = new Ref.ObjectRef();
            this.f505077c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f505063k;
            int r102 = (int) System.nanoTime();
            if (r102 != 0) goto L6;
            r102 = 42;
        L6:
            this.f505080f = r102;
            g(r101);
        }
    }

    static {
        f505060h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        f505061i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        f505062j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        f505063k = new b0("NOT_IN_STACK");
    }

    public final int a() {
        w<c> r100 = this.f505070g;
        monitor-enter(r100);
    L41:
        th = move-exception;
        throw th;
    L5:
        boolean r101 = false;
        if (f505062j.get(this) == 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        monitor-exit(r100);
        return -1;
    L13:
        AtomicLongFieldUpdater r103 = f505061i;     // Catch: Throwable -> L41
        long r104 = r103.get(this);     // Catch: Throwable -> L41
        int r105 = (int) (r104 & 2097151);     // Catch: Throwable -> L41
        int r106 = RangesKt.coerceAtLeast(r105 - ((int) ((r104 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L41
        if (r106 < this.f505064a) goto L18;
        monitor-exit(r100);
        return 0;
    L18:
        if (r105 < this.f505065b) goto L21;
        monitor-exit(r100);
        return 0;
    L21:
        int r107 = ((int) (r103.get(this) & 2097151)) + 1;     // Catch: Throwable -> L41
        if (r107 > 0) goto L24;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == false) goto L40;
        c r109 = new c(this, r107);     // Catch: Throwable -> L41
        this.f505070g.c(r107, r109);     // Catch: Throwable -> L41
        if (r107 != ((int) (2097151 & r103.incrementAndGet(this)))) goto L32;
        r101 = true;
    L32:
        if (r101 == false) goto L38;
        int r110 = r106 + 1;
        monitor-exit(r100);
        r109.start();
        return r110;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L41
    L40:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L41
    L24:
        if (this.f505070g.b(r107) != null) goto L26;
        r108 = true;
        goto L27
    L8:
        r102 = false;
        goto L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f505062j.compareAndSet(this, 0, 1) == false) goto L75;
        Thread r100 = Thread.currentThread();
        if ((r100 instanceof c) == false) goto L8;
        c r101 = (c) r100;
    L9:
        if (r101 != null) goto L11;
    L13:
        r101 = null;
    L14:
        w<c> r102 = this.f505070g;
        monitor-enter(r102);
        int r103 = (int) (f505061i.get(this) & 2097151);
        monitor-exit(r102);
        if (1 > r103) goto L36;
        int r104 = 1;
    L21:
        c r105 = this.f505070g.b(r104);
        Intrinsics.checkNotNull(r105);
        c r106 = r105;
        if (r106 != r101) goto L24;
    L34:
        if (r104 == r103) goto L36;
        r104 = r104 + 1;
    L24:
        if (r106.getState() == Thread.State.TERMINATED) goto L26;
        LockSupport.unpark(r106);
        r106.join(10000);
        goto L24
    L26:
        m r107 = r106.f505075a;
        duc.c r108 = this.f505069f;
        r107.getClass();
        g r109 = (g) m.f470079b.getAndSet(r107, null);
        if (r109 == null) goto L29;
        r108.a(r109);
    L29:
        g r110 = r107.c();
        if (r110 != null) goto L32;
        boolean r111 = false;
    L33:
        if (r111 == true) goto L29;
    L32:
        r108.a(r110);
        r111 = true;
    L36:
        this.f505069f.b();
        this.f505068e.b();
    L37:
        if (r101 == null) goto L40;
        g r112 = r101.a(true);
        if (r112 == null) goto L40;
    L62:
        r112.run();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        Thread r113 = Thread.currentThread();     // Catch: Throwable -> L53
        r113.getUncaughtExceptionHandler().uncaughtException(r113, th);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L40:
        r112 = this.f505068e.d();
        if (r112 != null) goto L62;
        r112 = this.f505069f.d();
        if (r112 != null) goto L62;
        if (r101 == null) goto L46;
        r101.i(WorkerState.TERMINATED);
    L46:
        f505060h.set(this, 0);
        f505061i.set(this, 0);
        return;
    L55:
        th = move-exception;
        throw th;
    L11:
        if (Intrinsics.areEqual(r101.f505082h, this) == false) goto L13;
    L8:
        r101 = null;
        goto L9
    }

    public final boolean e() {
    L2:
        AtomicLongFieldUpdater r100 = f505060h;
    L3:
        long r101 = r100.get(this);
        int r102 = (int) (2097151 & r101);
        c r103 = this.f505070g.b(r102);
        if (r103 == null) goto L5;
        long r104 = (2097152 + r101) & (-2097152);
        Object r105 = r103.c();
    L7:
        b0 r110 = f505063k;
        if (r105 == r110) goto L9;
        if (r105 == null) goto L11;
        c r106 = (c) r105;
        int r107 = r106.b();
        if (r107 != 0) goto L14;
        r105 = r106.c();
    L14:
        if (r107 < 0) goto L3;
        if (f505060h.compareAndSet(this, r101, ((long) r107) | r104) == false) goto L3;
        r103.h(r110);
    L18:
        if (r103 == null) goto L19;
        if (c.f505074i.compareAndSet(r103, -1, 0) == false) goto L2;
        LockSupport.unpark(r103);
        return true;
    L19:
        return false;
    L11:
        r107 = 0;
        goto L14
    L9:
        r107 = -1;
        goto L14
    L5:
        r103 = null;
        goto L18
    }

    public final String toString() {
        ArrayList r100 = new ArrayList();
        int r101 = this.f505070g.a();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 1;
    L3:
        if (r107 >= r101) goto L29;
        c r108 = this.f505070g.b(r107);
        if (r108 == null) goto L28;
        m r110 = r108.f505075a;
        r110.getClass();
        Object r111 = m.f470079b.get(r110);
        int r112 = r110.b();
        if (r111 == null) goto L10;
        r112 = r112 + 1;
    L10:
        int r109 = b.f505073a[r108.f505077c.ordinal()];
        if (r109 != 1) goto L13;
        r104 = r104 + 1;
        goto L28
    L13:
        if (r109 != 2) goto L15;
        r103 = r103 + 1;
        StringBuilder r113 = new StringBuilder();
        r113.append(r112);
        r113.append(BlockDevice.UNIX_ID);
        r100.add(r113.toString());
        goto L28
    L15:
        if (r109 != 3) goto L17;
        r102 = r102 + 1;
        StringBuilder r114 = new StringBuilder();
        r114.append(r112);
        r114.append(CharacterDevice.UNIX_ID);
        r100.add(r114.toString());
        goto L28
    L17:
        if (r109 != 4) goto L19;
        r105 = r105 + 1;
        if (r112 <= 0) goto L28;
        StringBuilder r115 = new StringBuilder();
        r115.append(r112);
        r115.append(Directory.UNIX_ID);
        r100.add(r115.toString());
        goto L28
    L19:
        if (r109 != 5) goto L28;
        r106 = r106 + 1;
    L28:
        r107 = r107 + 1;
        goto L3
    L29:
        long r116 = f505061i.get(this);
        return this.f505067d + '@' + kotlinx.coroutines.b0.a(this) + "[Pool Size {core = " + this.f505064a + ", max = " + this.f505065b + "}, Worker States {CPU = " + r102 + ", blocking = " + r103 + ", parked = " + r104 + ", dormant = " + r105 + ", terminated = " + r106 + "}, running workers queues = " + r100 + ", global CPU queue size = " + this.f505068e.c() + ", global blocking queue size = " + this.f505069f.c() + ", Control State {created workers= " + ((int) (2097151 & r116)) + ", blocking tasks = " + ((int) ((4398044413952L & r116) >> 21)) + ", CPUs acquired = " + (this.f505064a - ((int) ((9223367638808264704L & r116) >> 42))) + "}]";
    }

    public final boolean d(long r100) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & r100)) - ((int) ((r100 & 4398044413952L) >> 21)), 0) >= this.f505064a) goto L11;
        int r101 = a();
        if (r101 == 1) goto L7;
    L9:
        if (r101 <= 0) goto L11;
        return true;
    L7:
        if (this.f505064a <= 1) goto L9;
        a();
    L11:
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        b(r100, k.f470076g, false);
    }

    public final void b(Runnable r100, h r110, boolean r111) {
        k.f470075f.getClass();
        long r101 = System.nanoTime();
        if ((r100 instanceof g) == false) goto L5;
        g r102 = (g) r100;
        r102.f470066a = r101;
        r102.f470067b = r110;
    L6:
        boolean r103 = false;
        if (r102.f470067b.getTaskMode() != 1) goto L9;
        boolean r112 = true;
    L10:
        if (r112 == false) goto L12;
        long r104 = f505061i.addAndGet(this, 2097152);
    L13:
        Thread r105 = Thread.currentThread();
        if ((r105 instanceof c) == false) goto L16;
        c r106 = (c) r105;
    L17:
        if (r106 != null) goto L19;
    L21:
        r106 = null;
    L22:
        if (r106 != null) goto L25;
    L39:
        if (r102 != null) goto L41;
    L51:
        if (r111 == false) goto L54;
        if (r106 == null) goto L54;
        r103 = true;
    L54:
        if (r112 == false) goto L64;
        if (r103 == false) goto L58;
        return;
    L58:
        if (e() == false) goto L61;
        return;
    L61:
        if (d(r104) == true) goto L77;
        e();
        return;
    L77:
        return;
    L64:
        if (r103 == false) goto L67;
        return;
    L67:
        if (e() == false) goto L70;
        return;
    L70:
        if (d(f505061i.get(this)) == true) goto L79;
        e();
        return;
    L79:
        return;
    L41:
        if (r102.f470067b.getTaskMode() != 1) goto L43;
        boolean r107 = true;
    L44:
        if (r107 == false) goto L46;
        boolean r108 = this.f505069f.a(r102);
    L47:
        if (r108 == true) goto L51;
        throw new RejectedExecutionException(this.f505067d + " was terminated");
    L46:
        r108 = this.f505068e.a(r102);
        goto L47
    L43:
        r107 = false;
        goto L44
    L25:
        if (r106.f505077c == WorkerState.TERMINATED) goto L39;
        if (r102.f470067b.getTaskMode() == 0) goto L30;
    L32:
        r106.f505081g = true;
        m r109 = r106.f505075a;
        if (r111 == false) goto L35;
        r102 = r109.a(r102);
        goto L39
    L35:
        r109.getClass();
        g r113 = (g) m.f470079b.getAndSet(r109, r102);
        if (r113 != null) goto L38;
        r102 = null;
        goto L39
    L38:
        r102 = r109.a(r113);
        goto L39
    L30:
        if (r106.f505077c != WorkerState.BLOCKING) goto L32;
    L19:
        if (Intrinsics.areEqual(r106.f505082h, this) == false) goto L21;
    L16:
        r106 = null;
        goto L17
    L12:
        r104 = 0;
        goto L13
    L9:
        r112 = false;
        goto L10
    L5:
        r102 = new j(r100, r101, r110);
        goto L6
    }

    public final void c(c r110, int r111, int r112) {
        AtomicLongFieldUpdater r100 = f505060h;
    L3:
        long r101 = r100.get(this);
        int r102 = (int) (2097151 & r101);
        long r103 = (2097152 + r101) & (-2097152);
        if (r102 != r111) goto L17;
        if (r112 != 0) goto L16;
        Object r104 = r110.c();
    L8:
        if (r104 == f505063k) goto L9;
        if (r104 == null) goto L11;
        c r105 = (c) r104;
        r102 = r105.b();
        if (r102 != 0) goto L17;
        r104 = r105.c();
        goto L8
    L11:
        r102 = 0;
        goto L17
    L9:
        r102 = -1;
        goto L17
    L16:
        r102 = r112;
    L17:
        if (r102 < 0) goto L3;
        if (f505060h.compareAndSet(this, r101, r103 | ((long) r102)) == false) goto L3;
    }

    public CoroutineScheduler(int r100, int r101, long r102, String r103) {
        this.f505064a = r100;
        this.f505065b = r101;
        this.f505066c = r102;
        this.f505067d = r103;
        boolean r104 = true;
        if (r100 < 1) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L31;
        if (r101 < r100) goto L9;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L29;
        if (r101 > 2097150) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L27;
        if (r102 > 0) goto L21;
        r104 = false;
    L21:
        if (r104 == false) goto L25;
        this.f505068e = new duc.c();
        this.f505069f = new duc.c();
        this.f505070g = new w((r100 + 1) * 2);
        this.controlState$volatile = ((long) r100) << 42;
        this._isTerminated$volatile = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r102 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r101 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r107 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r101 + " should be greater than or equals to core pool size " + r100).toString());
    L9:
        r106 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r100 + " should be at least 1").toString());
    L5:
        r105 = false;
        goto L6
    }
}
