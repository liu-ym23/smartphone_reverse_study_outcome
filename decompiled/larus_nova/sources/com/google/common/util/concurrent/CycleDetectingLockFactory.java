package com.google.common.util.concurrent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class CycleDetectingLockFactory {
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = null;
    private static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> lockGraphNodesPerType = null;
    private static final Logger logger = null;
    final Policy policy;

    public interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r100 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r100;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r100, TimeUnit r101) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r102 = super.tryLock(r100, r101);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r102;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        private CycleDetectingReentrantLock(CycleDetectingLockFactory r100, LockGraphNode r101, boolean r102) {
            this.this$0 = r100;
            super(r102);
            r101.getClass();
            this.lockGraphNode = r101;
        }

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory r100, LockGraphNode r101, boolean r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r100 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r100;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        public CycleDetectingReentrantReadLock(CycleDetectingLockFactory r100, CycleDetectingReentrantReadWriteLock r101) {
            this.this$0 = r100;
            super(r101);
            this.readWriteLock = r101;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r100, TimeUnit r101) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r102 = super.tryLock(r100, r101);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r102;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            if (isWriteLockedByCurrentThread() == false) goto L5;
        L8:
            return true;
        L5:
            if (getReadHoldCount() > 0) goto L8;
            return false;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock readLock() {
            return readLock();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock writeLock() {
            return writeLock();
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r100, LockGraphNode r101, boolean r102) {
            super(r102);
            this.readLock = new CycleDetectingReentrantReadLock(r100, this);
            this.writeLock = new CycleDetectingReentrantWriteLock(r100, this);
            r101.getClass();
            this.lockGraphNode = r101;
        }

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r100, LockGraphNode r101, boolean r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r100 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r100;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        public CycleDetectingReentrantWriteLock(CycleDetectingLockFactory r100, CycleDetectingReentrantReadWriteLock r101) {
            this.this$0 = r100;
            super(r101);
            this.readWriteLock = r101;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r100, TimeUnit r101) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r102 = super.tryLock(r100, r101);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r102;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = null;
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = null;

        static {
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }

        public ExampleStackTrace(LockGraphNode r100, LockGraphNode r101) {
            super(r100.getLockName() + " -> " + r101.getLockName());
            StackTraceElement[] r102 = getStackTrace();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L16;
            if (WithExplicitOrdering.class.getName().equals(r102[r104].getClassName()) == true) goto L6;
            if (EXCLUDED_CLASS_NAMES.contains(r102[r104].getClassName()) == false) goto L9;
            r104 = r104 + 1;
            goto L3
        L9:
            setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r102, r104, r103));
            return;
        L6:
            setStackTrace(EMPTY_STACK_TRACE);
            return;
        }
    }

    public static class LockGraphNode {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks;
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks;
        final String lockName;

        public String getLockName() {
            return this.lockName;
        }

        public LockGraphNode(String r100) {
            MapMaker r101 = new MapMaker();
            r101.e();
            this.allowedPriorLocks = r101.c();
            MapMaker r102 = new MapMaker();
            r102.e();
            this.disallowedPriorLocks = r102.c();
            r100.getClass();
            this.lockName = r100;
        }

        @CheckForNull
        private ExampleStackTrace findPathTo(LockGraphNode r100, Set<LockGraphNode> r101) {
            if (r101.add(this) == true) goto L5;
            return null;
        L5:
            ExampleStackTrace r102 = this.allowedPriorLocks.get(r100);
            if (r102 == null) goto L8;
            return r102;
        L8:
            Iterator<Map.Entry<LockGraphNode, ExampleStackTrace>> r103 = this.allowedPriorLocks.entrySet().iterator();
        L10:
            if (r103.hasNext() == false) goto L15;
            Map.Entry<LockGraphNode, ExampleStackTrace> r104 = r103.next();
            LockGraphNode r105 = r104.getKey();
            ExampleStackTrace r106 = r105.findPathTo(r100, r101);
            if (r106 == null) goto L10;
            ExampleStackTrace r107 = new ExampleStackTrace(r105, this);
            r107.setStackTrace(r104.getValue().getStackTrace());
            r107.initCause(r106);
            return r107;
        L15:
            return null;
        }

        public void checkAcquiredLock(Policy r100, LockGraphNode r101) {
            if (this == r101) goto L4;
            boolean r102 = true;
        L5:
            com.google.common.base.m.s(r102, "Attempted to acquire multiple locks with the same rank %s", r101.getLockName());
            if (this.allowedPriorLocks.containsKey(r101) == false) goto L8;
            return;
        L8:
            PotentialDeadlockException r103 = this.disallowedPriorLocks.get(r101);
            AnonymousClass1 r104 = null;
            if (r103 == null) goto L12;
            r100.handlePotentialDeadlock(new PotentialDeadlockException(r101, this, r103.getConflictingStackTrace(), r104));
            return;
        L12:
            ExampleStackTrace r105 = r101.findPathTo(this, Collections.newSetFromMap(new IdentityHashMap()));
            if (r105 != null) goto L15;
            this.allowedPriorLocks.put(r101, new ExampleStackTrace(r101, this));
            return;
        L15:
            PotentialDeadlockException r106 = new PotentialDeadlockException(r101, this, r105, r104);
            this.disallowedPriorLocks.put(r101, r106);
            r100.handlePotentialDeadlock(r106);
            return;
        L4:
            r102 = false;
            goto L5
        }

        public void checkAcquiredLocks(Policy r100, List<LockGraphNode> r101) {
            Iterator<LockGraphNode> r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            checkAcquiredLock(r100, r102.next());
            goto L4
        }
    }

    public static abstract enum Policies extends Enum<Policies> implements Policy {
        private static final /* synthetic */ Policies[] $VALUES = null;
        public static final Policies DISABLED = null;
        public static final Policies THROW = null;
        public static final Policies WARN = null;

        private static /* synthetic */ Policies[] $values() {
            return new Policies[]{THROW, WARN, DISABLED};
        }

        static {
            final String r100 = "THROW";
            final int r101 = 0;
            THROW = new AnonymousClass1(r100, r101);
            final String r102 = "WARN";
            final int r103 = 1;
            WARN = new AnonymousClass2(r102, r103);
            final String r104 = "DISABLED";
            final int r105 = 2;
            DISABLED = new AnonymousClass3(r104, r105);
            $VALUES = $values();
        }

        public static Policies[] values() {
            return (Policies[]) $VALUES.clone();
        }

        public static Policies valueOf(String r100) {
            return (Policies) r27.a.a(Policies.class, r100);
        }

        private Policies(String r100, int r101) {
            super(r100, r101);
        }

        public /* synthetic */ Policies(String r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException r100);
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        @Override // java.lang.Throwable
        public String getMessage() {
            String r100 = super.getMessage();
            Objects.requireNonNull(r100);
            StringBuilder r101 = new StringBuilder(r100);
            Throwable r102 = this.conflictingStackTrace;
        L3:
            if (r102 == null) goto L6;
            r101.append(", ");
            r101.append(r102.getMessage());
            r102 = r102.getCause();
            goto L3
        L6:
            return r101.toString();
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        private PotentialDeadlockException(LockGraphNode r100, LockGraphNode r101, ExampleStackTrace r102) {
            super(r100, r101);
            this.conflictingStackTrace = r102;
            initCause(r102);
        }

        public /* synthetic */ PotentialDeadlockException(LockGraphNode r100, LockGraphNode r101, ExampleStackTrace r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        public ReentrantLock newReentrantLock(E r100) {
            return newReentrantLock(r100, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r100) {
            return newReentrantReadWriteLock(r100, false);
        }

        public WithExplicitOrdering(Policy r100, Map<E, LockGraphNode> r101) {
            super(r100, null);
            this.lockGraphNodes = r101;
        }

        public ReentrantLock newReentrantLock(E r100, boolean r101) {
            if (this.policy == Policies.DISABLED) goto L7;
            LockGraphNode r102 = this.lockGraphNodes.get(r100);
            Objects.requireNonNull(r102);
            return new CycleDetectingReentrantLock(this, r102, r101, null);
        L7:
            return new ReentrantLock(r101);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r100, boolean r101) {
            if (this.policy == Policies.DISABLED) goto L7;
            LockGraphNode r102 = this.lockGraphNodes.get(r100);
            Objects.requireNonNull(r102);
            return new CycleDetectingReentrantReadWriteLock(this, r102, r101, null);
        L7:
            return new ReentrantReadWriteLock(r101);
        }
    }

    static {
        MapMaker r100 = new MapMaker();
        r100.e();
        lockGraphNodesPerType = r100.c();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new AnonymousClass1();
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    private CycleDetectingLockFactory(Policy r100) {
        r100.getClass();
        this.policy = r100;
    }

    private void aboutToAcquire(CycleDetectingLock r100) {
        if (r100.isAcquiredByCurrentThread() == true) goto L6;
        ArrayList<LockGraphNode> r101 = acquiredLocks.get();
        LockGraphNode r102 = r100.getLockGraphNode();
        r102.checkAcquiredLocks(this.policy, r101);
        r101.add(r102);
        return;
    }

    public static /* synthetic */ void access$700(CycleDetectingLock r100) {
        lockStateChanged(r100);
    }

    public static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> r100) {
        r100.getClass();
        EnumMap r101 = new EnumMap(r100);
        E[] r102 = r100.getEnumConstants();
        int r103 = r102.length;
        ArrayList r104 = Lists.d(r103);
        int r105 = r102.length;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L5;
        E r108 = r102[r107];
        LockGraphNode r109 = new LockGraphNode(getLockName(r108));
        r104.add(r109);
        r101.put(r108, r109);
        r107 = r107 + 1;
        goto L3
    L5:
        int r110 = 1;
    L6:
        if (r110 >= r103) goto L9;
        ((LockGraphNode) ListProtector.get(r104, r110)).checkAcquiredLocks(Policies.THROW, r104.subList(0, r110));
        r110 = r110 + 1;
    L9:
        if (r106 >= (r103 - 1)) goto L12;
        r106 = r106 + 1;
        ((LockGraphNode) ListProtector.get(r104, r106)).checkAcquiredLocks(Policies.DISABLED, r104.subList(r106, r103));
        goto L9
    L12:
        return Collections.unmodifiableMap(r101);
    }

    private static String getLockName(Enum<?> r100) {
        return r100.getDeclaringClass().getSimpleName() + "." + r100.name();
    }

    private static <E extends Enum<E>> Map<? extends E, LockGraphNode> getOrCreateNodes(Class<E> r100) {
        ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> r101 = lockGraphNodesPerType;
        Map<? extends E, LockGraphNode> r102 = (Map) r101.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        Map<? extends Enum<?>, LockGraphNode> r103 = createNodes(r100);
        return (Map) com.google.common.base.j.a(r101.putIfAbsent(r100, r103), r103);
    }

    private static void lockStateChanged(CycleDetectingLock r100) {
        if (r100.isAcquiredByCurrentThread() == true) goto L10;
        ArrayList<LockGraphNode> r101 = acquiredLocks.get();
        LockGraphNode r102 = r100.getLockGraphNode();
        int r103 = r101.size() - 1;
    L5:
        if (r103 < 0) goto L14;
        if (ListProtector.get(r101, r103) == r102) goto L8;
        r103 = r103 - 1;
        goto L5
    L8:
        ListProtector.remove(r101, r103);
        return;
    L14:
        return;
    }

    public static CycleDetectingLockFactory newInstance(Policy r100) {
        return new CycleDetectingLockFactory(r100);
    }

    public ReentrantLock newReentrantLock(String r100) {
        return newReentrantLock(r100, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r100) {
        return newReentrantReadWriteLock(r100, false);
    }

    public /* synthetic */ CycleDetectingLockFactory(Policy r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ void access$600(CycleDetectingLockFactory r100, CycleDetectingLock r101) {
        r100.aboutToAcquire(r101);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> r100, Policy r101) {
        r100.getClass();
        r101.getClass();
        return new WithExplicitOrdering(r101, getOrCreateNodes(r100));
    }

    public ReentrantLock newReentrantLock(String r100, boolean r101) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantLock(r101);
    L6:
        return new CycleDetectingReentrantLock(this, new LockGraphNode(r100), r101, null);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r100, boolean r101) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantReadWriteLock(r101);
    L6:
        return new CycleDetectingReentrantReadWriteLock(this, new LockGraphNode(r100), r101, null);
    }
}
