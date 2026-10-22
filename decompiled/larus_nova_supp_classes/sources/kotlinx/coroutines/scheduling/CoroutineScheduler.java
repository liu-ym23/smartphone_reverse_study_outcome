package kotlinx.coroutines.scheduling;

import android.util.EventsUtils;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.w;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater h = null;
    public static final /* synthetic */ AtomicLongFieldUpdater i = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = null;
    public static final b0 k = null;
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int a;
    public final int b;
    public final long c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;
    public final duc.c e;
    public final duc.c f;
    public final w<c> g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final enum WorkerState extends Enum<WorkerState> {
        public static final WorkerState BLOCKING = null;
        public static final WorkerState CPU_ACQUIRED = null;
        public static final WorkerState DORMANT = null;
        public static final WorkerState PARKING = null;
        public static final WorkerState TERMINATED = null;
        public static final /* synthetic */ WorkerState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<WorkerState> getEntries() {
            return b;
        }

        public static WorkerState valueOf(String r1) {
            return (WorkerState) r27.a.a(WorkerState.class, r1);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) a.clone();
        }

        static {
            WorkerState r0 = new WorkerState("CPU_ACQUIRED", 0);
            CPU_ACQUIRED = r0;
            WorkerState r1 = new WorkerState("BLOCKING", 1);
            BLOCKING = r1;
            WorkerState r3 = new WorkerState("PARKING", 2);
            PARKING = r3;
            WorkerState r5 = new WorkerState("DORMANT", 3);
            DORMANT = r5;
            WorkerState r7 = new WorkerState("TERMINATED", 4);
            TERMINATED = r7;
            WorkerState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public WorkerState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public final class c extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater i = null;
        public final m a;
        public final Ref$ObjectRef<g> b;
        public WorkerState c;
        public long d;
        public long e;
        public int f;
        public boolean g;
        public final /* synthetic */ CoroutineScheduler h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        static {
            i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");
        }

        public c() {
            throw null;
        }

        public final g f() {
            if (e(2) != 0) goto L9;
            g r0 = this.h.e.d();
            if (r0 == null) goto L8;
            return r0;
        L8:
            return this.h.f.d();
        L9:
            g r1 = this.h.f.d();
            if (r1 == null) goto L13;
            return r1;
        L13:
            return this.h.e.d();
        }

        public final void d() {
        L3:
            boolean r2 = false;
        L4:
            CoroutineScheduler r3 = this.h;
            r3.getClass();
            if (CoroutineScheduler.j.get(r3) == 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L107;
            WorkerState r5 = this.c;
            WorkerState r6 = WorkerState.TERMINATED;
            if (r5 == r6) goto L107;
            g r7 = a(this.g);
            if (r7 != null) goto L13;
            this.g = false;
            if (this.e != 0) goto L42;
            Object r8 = this.nextParkedWorker;
            b0 r9 = CoroutineScheduler.k;
            if (r8 == r9) goto L48;
            boolean r10 = true;
        L50:
            if (r10 == false) goto L51;
            int r11 = -1;
            i.set(this, -1);
        L60:
            if (this.nextParkedWorker == CoroutineScheduler.k) goto L62;
            boolean r12 = true;
        L63:
            if (r12 == false) goto L4;
            AtomicIntegerFieldUpdater r13 = i;
            if (r13.get(this) != r11) goto L4;
            CoroutineScheduler r14 = this.h;
            r14.getClass();
            AtomicIntegerFieldUpdater r15 = CoroutineScheduler.j;
            if (r15.get(r14) == 0) goto L69;
            boolean r16 = true;
        L70:
            if (r16 == true) goto L4;
            WorkerState r17 = this.c;
            WorkerState r18 = WorkerState.TERMINATED;
            if (r17 == r18) goto L4;
            i(WorkerState.PARKING);
            Thread.interrupted();
            if (this.d != 0) goto L77;
            this.d = System.nanoTime() + this.h.c;
        L77:
            LockSupport.parkNanos(this.h.c);
            if ((System.nanoTime() - this.d) < 0) goto L106;
            this.d = 0;
            CoroutineScheduler r19 = this.h;
            w<c> r20 = r19.g;
            monitor-enter(r20);
            if (r15.get(r19) == 0) goto L84;
            boolean r21 = true;
        L85:
            if (r21 == false) goto L88;
            monitor-exit(r20);
            goto L106
        L88:
            AtomicLongFieldUpdater r22 = CoroutineScheduler.i;     // Catch: Throwable -> L103
            if (((int) (r22.get(r19) & 2097151)) > r19.a) goto L94;
            monitor-exit(r20);
            goto L106
        L94:
            if (r13.compareAndSet(this, -1, 1) == true) goto L97;
            monitor-exit(r20);
            goto L106
        L97:
            int r23 = this.indexInArray;     // Catch: Throwable -> L103
            g(0);     // Catch: Throwable -> L103
            r19.c(this, r23, 0);     // Catch: Throwable -> L103
            int r24 = (int) (r22.getAndDecrement(r19) & 2097151);     // Catch: Throwable -> L103
            if (r24 == r23) goto L100;
            c r110 = r19.g.b(r24);     // Catch: Throwable -> L103
            Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L103
            c r111 = r110;     // Catch: Throwable -> L103
            r19.g.c(r23, r111);     // Catch: Throwable -> L103
            r111.g(r23);     // Catch: Throwable -> L103
            r19.c(r111, r24, r23);     // Catch: Throwable -> L103
        L100:
            r19.g.c(r24, null);     // Catch: Throwable -> L103
            Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L103
            monitor-exit(r20);
            this.c = r18;
            goto L106
        L84:
            r21 = false;
        L103:
            th = move-exception;
            throw th;
        L106:
            r11 = -1;
            goto L60
        L69:
            r16 = false;
            goto L70
        L62:
            r12 = false;
            goto L63
        L51:
            CoroutineScheduler r26 = this.h;
            r26.getClass();
            if (this.nextParkedWorker != r9) goto L4;
            AtomicLongFieldUpdater r28 = CoroutineScheduler.h;
        L55:
            long r112 = r28.get(r26);
            int r29 = (int) (r112 & 2097151);
            int r113 = this.indexInArray;
            this.nextParkedWorker = r26.g.b(r29);
            if (CoroutineScheduler.h.compareAndSet(r26, r112, ((2097152 + r112) & (-2097152)) | ((long) r113)) == false) goto L55;
        L48:
            r10 = false;
            goto L50
        L42:
            if (r2 == true) goto L44;
            r2 = true;
            goto L4
        L44:
            i(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.e);
            this.e = 0;
            goto L3
        L13:
            this.e = 0;
            int r30 = r7.b.getTaskMode();
            this.d = 0;
            if (this.c != WorkerState.PARKING) goto L16;
            this.c = WorkerState.BLOCKING;
        L16:
            if (r30 != 0) goto L19;
        L27:
            this.h.getClass();
            r7.run();     // Catch: Throwable -> L30
        L33:
            if (r30 == 0) goto L3;
            CoroutineScheduler r0 = this.h;
            CoroutineScheduler.i.addAndGet(r0, -2097152);
            if (this.c == r6) goto L3;
            this.c = WorkerState.DORMANT;
        L30:
            th = move-exception;
            Thread r1 = Thread.currentThread();     // Catch: Throwable -> L38
            r1.getUncaughtExceptionHandler().uncaughtException(r1, th);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        L19:
            if (i(WorkerState.BLOCKING) == false) goto L27;
            CoroutineScheduler r31 = this.h;
            if (r31.e() == true) goto L27;
            if (r31.d(CoroutineScheduler.i.get(r31)) == true) goto L27;
            r31.e();
        L107:
            i(WorkerState.TERMINATED);
            return;
        L7:
            r4 = false;
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

        public final g a(boolean r11) {
            boolean r2 = false;
            if (this.c == WorkerState.CPU_ACQUIRED) goto L14;
            CoroutineScheduler r0 = this.h;
            AtomicLongFieldUpdater r1 = CoroutineScheduler.i;
        L6:
            long r6 = r1.get(r0);
            if (((int) ((9223367638808264704L & r6) >> 42)) == 0) goto L8;
            if (CoroutineScheduler.i.compareAndSet(r0, r6, r6 - 4398046511104L) == false) goto L6;
            boolean r3 = true;
        L12:
            if (r3 == false) goto L15;
            this.c = WorkerState.CPU_ACQUIRED;
            goto L14
        L15:
            boolean r4 = false;
        L16:
            g r5 = null;
            if (r4 == false) goto L41;
            if (r11 == true) goto L20;
            g r12 = f();
            if (r12 == null) goto L40;
            return r12;
        L40:
            return l(3);
        L20:
            if (e(this.h.a * 2) != 0) goto L22;
            r2 = true;
        L22:
            if (r2 == false) goto L26;
            g r13 = f();
            if (r13 == null) goto L26;
            return r13;
        L26:
            m r14 = this.a;
            r14.getClass();
            g r7 = (g) m.b.getAndSet(r14, null);
            if (r7 != null) goto L29;
            g r15 = r14.c();
        L30:
            if (r15 != null) goto L88;
            if (r2 == true) goto L40;
            g r16 = f();
            if (r16 == null) goto L40;
            return r16;
        L88:
            return r15;
        L29:
            r15 = r7;
            goto L30
        L41:
            m r17 = this.a;
            r17.getClass();
        L42:
            AtomicReferenceFieldUpdater r8 = m.b;
            g r9 = (g) r8.get(r17);
            if (r9 == null) goto L58;
            if (r9.b.getTaskMode() != 1) goto L48;
            boolean r10 = true;
        L49:
            if (r10 != true) goto L58;
        L51:
            if (r8.compareAndSet(r17, r9, null) == true) goto L52;
            if (r8.get(r17) == r9) goto L51;
            boolean r18 = false;
        L56:
            if (r18 == false) goto L42;
        L65:
            r5 = r9;
        L66:
            if (r5 != null) goto L91;
            g r19 = this.h.f.d();
            if (r19 == null) goto L70;
            return r19;
        L70:
            return l(1);
        L91:
            return r5;
        L52:
            r18 = true;
            goto L56
        L48:
            r10 = false;
        L58:
            int r20 = m.d.get(r17);
            int r21 = m.c.get(r17);
        L59:
            if (r20 == r21) goto L66;
            if (m.e.get(r17) == 0) goto L66;
            r21 = r21 - 1;
            r9 = r17.d(r21, true);
            if (r9 == null) goto L59;
        L8:
            r3 = false;
        L14:
            r4 = true;
            goto L16
        }

        public final int e(int r4) {
            int r0 = this.f;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r3 = r2 ^ (r2 << 5);
            this.f = r3;
            int r5 = r4 - 1;
            if ((r5 & r4) != 0) goto L7;
            return r3 & r5;
        L7:
            return (r3 & Integer.MAX_VALUE) % r4;
        }

        public final void g(int r3) {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.h.d);
            r0.append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            r0.append(r1);
            setName(r0.toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public final void h(Object r1) {
            this.nextParkedWorker = r1;
        }

        public final boolean i(WorkerState r7) {
            WorkerState r0 = this.c;
            if (r0 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            CoroutineScheduler r2 = this.h;
            CoroutineScheduler.i.addAndGet(r2, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.c = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v14, types: [duc.g] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5, types: [duc.g] */
        /* JADX WARN: Type inference failed for: r8v3, types: [T, duc.g, java.lang.Object] */
        public final g l(int r19) {
            int r3 = (int) (CoroutineScheduler.i.get(this.h) & 2097151);
            Object r4 = null;
            if (r3 >= 2) goto L5;
            return null;
        L5:
            int r5 = e(r3);
            CoroutineScheduler r6 = this.h;
            int r10 = 0;
            long r11 = Long.MAX_VALUE;
        L6:
            if (r10 >= r3) goto L68;
            int r7 = r5 + 1;
            if (r7 <= r3) goto L10;
            r7 = 1;
        L10:
            c r2 = r6.g.b(r7);
            if (r2 == null) goto L65;
            if (r2 == this) goto L65;
            m r8 = r2.a;
            Ref$ObjectRef<g> r9 = this.b;
            if (r19 != 3) goto L16;
            T r12 = r8.c();
        L29:
            if (r12 == 0) goto L31;
            r9.element = r12;
            int r16 = r7;
        L56:
            long r13 = -1;
            long r14 = -1;
        L58:
            if (r14 == r13) goto L59;
            if (r14 <= 0) goto L66;
            r11 = Math.min(r11, r14);
        L66:
            r10 = r10 + 1;
            r5 = r16;
            r4 = null;
            goto L6
        L59:
            Ref$ObjectRef<g> r1 = this.b;
            g r15 = r1.element;
            r1.element = null;
            return r15;
        L31:
            AtomicReferenceFieldUpdater r17 = m.b;
            ?? r18 = (g) r17.get(r8);
            if (r18 == 0) goto L43;
            if (r18.b.getTaskMode() != 1) goto L37;
            boolean r110 = true;
        L38:
            if (r110 == false) goto L40;
            int r111 = 1;
        L42:
            if ((r111 & r19) == 0) goto L43;
            k.f.getClass();
            r16 = r7;
            long r112 = System.nanoTime() - r18.a;
            long r20 = k.b;
            if (r112 < r20) goto L47;
        L49:
            if (r17.compareAndSet(r8, r18, null) == true) goto L50;
            if (r17.get(r8) == r18) goto L49;
            boolean r21 = false;
        L54:
            if (r21 == true) goto L55;
            r7 = r16;
            goto L31
        L55:
            r9.element = r18;
            goto L56
        L50:
            r21 = true;
            goto L54
        L47:
            r14 = r20 - r112;
        L44:
            r13 = -1;
            goto L58
        L40:
            r111 = 2;
            goto L42
        L37:
            r110 = false;
        L43:
            r14 = -2;
            r16 = r7;
            goto L44
        L16:
            r8.getClass();
            int r22 = m.d.get(r8);
            int r23 = m.c.get(r8);
            if (r19 != 1) goto L19;
            boolean r113 = true;
        L20:
            if (r22 == r23) goto L28;
            if (r113 == true) goto L23;
        L25:
            int r114 = r22 + 1;
            r12 = r8.d(r22, r113);
            if (r12 != 0) goto L29;
            r22 = r114;
            goto L20
        L23:
            if (m.e.get(r8) != 0) goto L25;
        L28:
            r12 = r4;
            goto L29
        L19:
            r113 = false;
        L65:
            r16 = r7;
            goto L66
        L68:
            if (r11 != Long.MAX_VALUE) goto L71;
            r11 = 0;
        L71:
            this.e = r11;
            return null;
        }

        public c(CoroutineScheduler r3, int r4) {
            this.h = r3;
            setDaemon(true);
            setContextClassLoader(r3.getClass().getClassLoader());
            this.a = new m();
            this.b = new Ref$ObjectRef();
            this.c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.k;
            int r5 = (int) System.nanoTime();
            if (r5 != 0) goto L6;
            r5 = 42;
        L6:
            this.f = r5;
            g(r4);
        }
    }

    static {
        h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        k = new b0("NOT_IN_STACK");
    }

    public final int a() {
        w<c> r0 = this.g;
        monitor-enter(r0);
    L41:
        th = move-exception;
        throw th;
    L5:
        boolean r2 = false;
        if (j.get(this) == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        monitor-exit(r0);
        return -1;
    L13:
        AtomicLongFieldUpdater r3 = i;     // Catch: Throwable -> L41
        long r4 = r3.get(this);     // Catch: Throwable -> L41
        int r9 = (int) (r4 & 2097151);     // Catch: Throwable -> L41
        int r5 = RangesKt.coerceAtLeast(r9 - ((int) ((r4 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L41
        if (r5 < this.a) goto L18;
        monitor-exit(r0);
        return 0;
    L18:
        if (r9 < this.b) goto L21;
        monitor-exit(r0);
        return 0;
    L21:
        int r6 = ((int) (r3.get(this) & 2097151)) + 1;     // Catch: Throwable -> L41
        if (r6 > 0) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L40;
        c r10 = new c(this, r6);     // Catch: Throwable -> L41
        this.g.c(r6, r10);     // Catch: Throwable -> L41
        if (r6 != ((int) (2097151 & r3.incrementAndGet(this)))) goto L32;
        r2 = true;
    L32:
        if (r2 == false) goto L38;
        int r7 = r5 + 1;
        monitor-exit(r0);
        r10.start();
        return r7;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L41
    L40:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L41
    L24:
        if (this.g.b(r6) != null) goto L26;
        r8 = true;
        goto L27
    L8:
        r1 = false;
        goto L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (j.compareAndSet(this, 0, 1) == false) goto L75;
        Thread r0 = Thread.currentThread();
        if ((r0 instanceof c) == false) goto L8;
        c r1 = (c) r0;
    L9:
        if (r1 != null) goto L11;
    L13:
        r1 = null;
    L14:
        w<c> r3 = this.g;
        monitor-enter(r3);
        int r6 = (int) (i.get(this) & 2097151);
        monitor-exit(r3);
        if (1 > r6) goto L36;
        int r4 = 1;
    L21:
        c r5 = this.g.b(r4);
        Intrinsics.checkNotNull(r5);
        c r7 = r5;
        if (r7 != r1) goto L24;
    L34:
        if (r4 == r6) goto L36;
        r4 = r4 + 1;
    L24:
        if (r7.getState() == Thread.State.TERMINATED) goto L26;
        LockSupport.unpark(r7);
        r7.join(10000);
        goto L24
    L26:
        m r8 = r7.a;
        duc.c r9 = this.f;
        r8.getClass();
        g r10 = (g) m.b.getAndSet(r8, null);
        if (r10 == null) goto L29;
        r9.a(r10);
    L29:
        g r11 = r8.c();
        if (r11 != null) goto L32;
        boolean r12 = false;
    L33:
        if (r12 == true) goto L29;
    L32:
        r9.a(r11);
        r12 = true;
    L36:
        this.f.b();
        this.e.b();
    L37:
        if (r1 == null) goto L40;
        g r2 = r1.a(true);
        if (r2 == null) goto L40;
    L62:
        r2.run();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        Thread r13 = Thread.currentThread();     // Catch: Throwable -> L53
        r13.getUncaughtExceptionHandler().uncaughtException(r13, th);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L40:
        r2 = this.e.d();
        if (r2 != null) goto L62;
        r2 = this.f.d();
        if (r2 != null) goto L62;
        if (r1 == null) goto L46;
        r1.i(WorkerState.TERMINATED);
    L46:
        h.set(this, 0);
        i.set(this, 0);
        return;
    L55:
        th = move-exception;
        throw th;
    L11:
        if (Intrinsics.areEqual(r1.h, this) == false) goto L13;
    L8:
        r1 = null;
        goto L9
    }

    public final boolean e() {
    L2:
        AtomicLongFieldUpdater r0 = h;
    L3:
        long r3 = r0.get(this);
        int r2 = (int) (2097151 & r3);
        c r7 = this.g.b(r2);
        if (r7 == null) goto L5;
        long r1 = (2097152 + r3) & (-2097152);
        Object r5 = r7.c();
    L7:
        b0 r10 = k;
        if (r5 == r10) goto L9;
        if (r5 == null) goto L11;
        c r6 = (c) r5;
        int r8 = r6.b();
        if (r8 != 0) goto L14;
        r5 = r6.c();
    L14:
        if (r8 < 0) goto L3;
        if (h.compareAndSet(this, r3, ((long) r8) | r1) == false) goto L3;
        r7.h(r10);
    L18:
        if (r7 == null) goto L19;
        if (c.i.compareAndSet(r7, -1, 0) == false) goto L2;
        LockSupport.unpark(r7);
        return true;
    L19:
        return false;
    L11:
        r8 = 0;
        goto L14
    L9:
        r8 = -1;
        goto L14
    L5:
        r7 = null;
        goto L18
    }

    public final String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.g.a();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L29;
        c r9 = this.g.b(r8);
        if (r9 == null) goto L28;
        m r10 = r9.a;
        r10.getClass();
        Object r11 = m.b.get(r10);
        int r12 = r10.b();
        if (r11 == null) goto L10;
        r12 = r12 + 1;
    L10:
        int r13 = b.a[r9.c.ordinal()];
        if (r13 != 1) goto L13;
        r5 = r5 + 1;
        goto L28
    L13:
        if (r13 != 2) goto L15;
        r4 = r4 + 1;
        StringBuilder r14 = new StringBuilder();
        r14.append(r12);
        r14.append('b');
        r0.add(r14.toString());
        goto L28
    L15:
        if (r13 != 3) goto L17;
        r2 = r2 + 1;
        StringBuilder r15 = new StringBuilder();
        r15.append(r12);
        r15.append('c');
        r0.add(r15.toString());
        goto L28
    L17:
        if (r13 != 4) goto L19;
        r6 = r6 + 1;
        if (r12 <= 0) goto L28;
        StringBuilder r16 = new StringBuilder();
        r16.append(r12);
        r16.append('d');
        r0.add(r16.toString());
        goto L28
    L19:
        if (r13 != 5) goto L28;
        r7 = r7 + 1;
    L28:
        r8 = r8 + 1;
        goto L3
    L29:
        long r17 = i.get(this);
        return this.d + '@' + kotlinx.coroutines.b0.a(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + r2 + ", blocking = " + r4 + ", parked = " + r5 + ", dormant = " + r6 + ", terminated = " + r7 + "}, running workers queues = " + r0 + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & r17)) + ", blocking tasks = " + ((int) ((4398044413952L & r17) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & r17) >> 42))) + "}]";
    }

    public final boolean d(long r5) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & r5)) - ((int) ((r5 & 4398044413952L) >> 21)), 0) >= this.a) goto L11;
        int r6 = a();
        if (r6 == 1) goto L7;
    L9:
        if (r6 <= 0) goto L11;
        return true;
    L7:
        if (this.a <= 1) goto L9;
        a();
    L11:
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r3) {
        b(r3, k.g, false);
    }

    public final void b(Runnable r9, h r10, boolean r11) {
        k.f.getClass();
        long r0 = System.nanoTime();
        if ((r9 instanceof g) == false) goto L5;
        g r12 = (g) r9;
        r12.a = r0;
        r12.b = r10;
    L6:
        boolean r1 = false;
        if (r12.b.getTaskMode() != 1) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
        long r2 = i.addAndGet(this, 2097152);
    L13:
        Thread r4 = Thread.currentThread();
        if ((r4 instanceof c) == false) goto L16;
        c r5 = (c) r4;
    L17:
        if (r5 != null) goto L19;
    L21:
        r5 = null;
    L22:
        if (r5 != null) goto L25;
    L39:
        if (r12 != null) goto L41;
    L51:
        if (r11 == false) goto L54;
        if (r5 == null) goto L54;
        r1 = true;
    L54:
        if (r13 == false) goto L64;
        if (r1 == false) goto L58;
        return;
    L58:
        if (e() == false) goto L61;
        return;
    L61:
        if (d(r2) == true) goto L77;
        e();
        return;
    L77:
        return;
    L64:
        if (r1 == false) goto L67;
        return;
    L67:
        if (e() == false) goto L70;
        return;
    L70:
        if (d(i.get(this)) == true) goto L79;
        e();
        return;
    L79:
        return;
    L41:
        if (r12.b.getTaskMode() != 1) goto L43;
        boolean r6 = true;
    L44:
        if (r6 == false) goto L46;
        boolean r14 = this.f.a(r12);
    L47:
        if (r14 == true) goto L51;
        throw new RejectedExecutionException(this.d + " was terminated");
    L46:
        r14 = this.e.a(r12);
        goto L47
    L43:
        r6 = false;
        goto L44
    L25:
        if (r5.c == WorkerState.TERMINATED) goto L39;
        if (r12.b.getTaskMode() == 0) goto L30;
    L32:
        r5.g = true;
        m r7 = r5.a;
        if (r11 == false) goto L35;
        r12 = r7.a(r12);
        goto L39
    L35:
        r7.getClass();
        g r15 = (g) m.b.getAndSet(r7, r12);
        if (r15 != null) goto L38;
        r12 = null;
        goto L39
    L38:
        r12 = r7.a(r15);
        goto L39
    L30:
        if (r5.c != WorkerState.BLOCKING) goto L32;
    L19:
        if (Intrinsics.areEqual(r5.h, this) == false) goto L21;
    L16:
        r5 = null;
        goto L17
    L12:
        r2 = 0;
        goto L13
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = new j(r9, r0, r10);
        goto L6
    }

    public final void c(c r10, int r11, int r12) {
        AtomicLongFieldUpdater r0 = h;
    L3:
        long r3 = r0.get(this);
        int r2 = (int) (2097151 & r3);
        long r5 = (2097152 + r3) & (-2097152);
        if (r2 != r11) goto L17;
        if (r12 != 0) goto L16;
        Object r1 = r10.c();
    L8:
        if (r1 == k) goto L9;
        if (r1 == null) goto L11;
        c r4 = (c) r1;
        r2 = r4.b();
        if (r2 != 0) goto L17;
        r1 = r4.c();
        goto L8
    L11:
        r2 = 0;
        goto L17
    L9:
        r2 = -1;
        goto L17
    L16:
        r2 = r12;
    L17:
        if (r2 < 0) goto L3;
        if (h.compareAndSet(this, r3, r5 | ((long) r2)) == false) goto L3;
    }

    public CoroutineScheduler(int r4, int r5, long r6, String r8) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r8;
        boolean r0 = true;
        if (r4 < 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L31;
        if (r5 < r4) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L29;
        if (r5 > 2097150) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L27;
        if (r6 > 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L25;
        this.e = new duc.c();
        this.f = new duc.c();
        this.g = new w((r4 + 1) * 2);
        this.controlState$volatile = ((long) r4) << 42;
        this._isTerminated$volatile = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r6 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r3 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should be greater than or equals to core pool size " + r4).toString());
    L9:
        r2 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r4 + " should be at least 1").toString());
    L5:
        r1 = false;
        goto L6
    }
}
