package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Monitor {

    @CheckForNull
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;

        @CheckForNull
        Guard next;
        int waiterCount;

        public abstract boolean isSatisfied();

        public Guard(Monitor r100) {
            this.waiterCount = 0;
            com.google.common.base.m.l(r100, "monitor");
            this.monitor = r100;
            this.condition = Monitor.access$000(r100).newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    private void signalAllWaiters() {
        Guard r100 = this.activeGuards;
    L3:
        if (r100 == null) goto L5;
        r100.condition.signalAll();
        r100 = r100.next;
        goto L3
    }

    private void signalNextWaiter() {
        Guard r100 = this.activeGuards;
    L3:
        if (r100 == null) goto L11;
        if (isSatisfied(r100) == true) goto L6;
        r100 = r100.next;
        goto L3
    L6:
        r100.condition.signal();
        return;
    }

    public void enter() {
        this.lock.lock();
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock r100 = this.lock;
    L8:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (r100.getHoldCount() != 1) goto L6;
        signalNextWaiter();     // Catch: Throwable -> L8
    L6:
        r100.unlock();
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean isFair() {
        return this.fair;
    }

    public Monitor(boolean r100) {
        this.activeGuards = null;
        this.fair = r100;
        this.lock = new ReentrantLock(r100);
    }

    public static /* synthetic */ ReentrantLock access$000(Monitor r100) {
        return r100.lock;
    }

    private void beginWaitingFor(Guard r100) {
        int r101 = r100.waiterCount;
        r100.waiterCount = r101 + 1;
        if (r101 != 0) goto L6;
        r100.next = this.activeGuards;
        this.activeGuards = r100;
        return;
    }

    private void endWaitingFor(Guard r100) {
        int r101 = r100.waiterCount - 1;
        r100.waiterCount = r101;
        if (r101 != 0) goto L11;
        Guard r102 = this.activeGuards;
        Guard r103 = null;
    L5:
        if (r102 == r100) goto L6;
        r103 = r102;
        r102 = r102.next;
        goto L5
    L6:
        if (r103 != null) goto L8;
        this.activeGuards = r102.next;
    L9:
        r102.next = null;
        return;
    L8:
        r103.next = r102.next;
        goto L9
    }

    private static long initNanoTime(long r100) {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        long r101 = System.nanoTime();
        if (r101 != 0) goto L9;
        return 1;
    L9:
        return r101;
    }

    private boolean isSatisfied(Guard r100) {
        return r100.isSatisfied();
    L6:
        e = move-exception;
        signalAllWaiters();
        throw e;
    }

    public boolean enterIf(Guard r100) {
        if (r100.monitor != this) goto L13;
        ReentrantLock r101 = this.lock;
        r101.lock();
        boolean r102 = r100.isSatisfied();     // Catch: Throwable -> L9
        if (r102 == true) goto L8;
        r101.unlock();
    L8:
        return r102;
    L9:
        th = move-exception;
        r101.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r100) throws InterruptedException {
        if (r100.monitor != this) goto L13;
        ReentrantLock r101 = this.lock;
        r101.lockInterruptibly();
        boolean r102 = r100.isSatisfied();     // Catch: Throwable -> L9
        if (r102 == true) goto L8;
        r101.unlock();
    L8:
        return r102;
    L9:
        th = move-exception;
        r101.unlock();
        throw th;
    L13:
        throw new IllegalMonitorStateException();
    }

    public void enterWhen(Guard r100) throws InterruptedException {
        if (r100.monitor != this) goto L13;
        ReentrantLock r101 = this.lock;
        boolean r102 = r101.isHeldByCurrentThread();
        r101.lockInterruptibly();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r100.isSatisfied() == true) goto L16;
        await(r100, r102);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public void enterWhenUninterruptibly(Guard r100) {
        if (r100.monitor != this) goto L13;
        ReentrantLock r101 = this.lock;
        boolean r102 = r101.isHeldByCurrentThread();
        r101.lock();
    L9:
        th = move-exception;
        leave();
        throw th;
    L6:
        if (r100.isSatisfied() == true) goto L16;
        awaitUninterruptibly(r100, r102);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L13:
        throw new IllegalMonitorStateException();
    }

    public int getWaitQueueLength(Guard r100) {
        if (r100.monitor != this) goto L12;
        this.lock.lock();
        int r101 = r100.waiterCount;     // Catch: Throwable -> L8
        this.lock.unlock();
        return r101;
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L12:
        throw new IllegalMonitorStateException();
    }

    public boolean hasQueuedThread(Thread r100) {
        return this.lock.hasQueuedThread(ThreadMethodProxy.getAttachThread(r100));
    }

    public boolean hasWaiters(Guard r100) {
        if (getWaitQueueLength(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean tryEnterIf(Guard r100) {
        if (r100.monitor != this) goto L16;
        ReentrantLock r101 = this.lock;
        if (r101.tryLock() == true) goto L17;
        return false;
    L17:
        boolean r102 = r100.isSatisfied();     // Catch: Throwable -> L12
        if (r102 == true) goto L11;
        r101.unlock();
    L11:
        return r102;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public void waitFor(Guard r100) throws InterruptedException {
        if (r100.monitor != this) goto L11;
        if (this.lock.isHeldByCurrentThread() == false) goto L11;
        if (r100.isSatisfied() == true) goto L12;
        await(r100, true);
        return;
    L12:
        return;
    L11:
        throw new IllegalMonitorStateException();
    }

    public void waitForUninterruptibly(Guard r100) {
        if (r100.monitor != this) goto L11;
        if (this.lock.isHeldByCurrentThread() == false) goto L11;
        if (r100.isSatisfied() == true) goto L12;
        awaitUninterruptibly(r100, true);
        return;
    L12:
        return;
    L11:
        throw new IllegalMonitorStateException();
    }

    private void await(Guard r100, boolean r101) throws InterruptedException {
        if (r101 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r100);
    L12:
        r100.condition.await();     // Catch: Throwable -> L9
        if (r100.isSatisfied() == false) goto L12;
        endWaitingFor(r100);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r100);
        throw th;
    }

    private void awaitUninterruptibly(Guard r100, boolean r101) {
        if (r101 == false) goto L4;
        signalNextWaiter();
    L4:
        beginWaitingFor(r100);
    L12:
        r100.condition.awaitUninterruptibly();     // Catch: Throwable -> L9
        if (r100.isSatisfied() == false) goto L12;
        endWaitingFor(r100);
        return;
    L9:
        th = move-exception;
        endWaitingFor(r100);
        throw th;
    }

    private static long remainingNanos(long r100, long r101) {
        if (r101 > 0) goto L6;
        return 0;
    L6:
        return r101 - (System.nanoTime() - r100);
    }

    private static long toSafeNanos(long r100, TimeUnit r101) {
        return Math.min(Math.max(r101.toNanos(r100), 0), 6917529027641081853L);
    }

    public boolean enter(long r100, TimeUnit r110) {
        long r101 = toSafeNanos(r100, r110);
        ReentrantLock r111 = this.lock;
        boolean r102 = true;
        if (this.fair == false) goto L5;
    L7:
        boolean r103 = Thread.interrupted();
        long r104 = System.nanoTime();     // Catch: Throwable -> L18
        long r105 = r101;
    L25:
        boolean r106 = r111.tryLock(r105, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L14 Throwable -> L18
    L11:
        if (r103 == false) goto L13;
        ThreadMethodProxy.currentThread().interrupt();
    L13:
        return r106;
    L14:
        r105 = remainingNanos(r104, r101);     // Catch: Throwable -> L16
        r103 = true;
    L16:
        th = th;
    L20:
        if (r102 == false) goto L22;
        ThreadMethodProxy.currentThread().interrupt();
    L22:
        throw th;
    L18:
        th = th;
        r102 = r103;
        goto L20
    L5:
        if (r111.tryLock() == false) goto L7;
        return true;
    }

    public boolean enterInterruptibly(long r100, TimeUnit r101) throws InterruptedException {
        return this.lock.tryLock(r100, r101);
    }

    private boolean awaitNanos(Guard r100, long r101, boolean r110) throws InterruptedException {
        boolean r102 = true;
    L4:
        if (r101 <= 0) goto L5;
        if (r102 == false) goto L12;
        if (r110 == true) goto L21;
    L11:
        beginWaitingFor(r100);     // Catch: Throwable -> L17
        r102 = false;
        goto L12
    L21:
        signalNextWaiter();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r102 == true) goto L20;
        endWaitingFor(r100);
    L20:
        throw th;
    L12:
        r101 = r100.condition.awaitNanos(r101);     // Catch: Throwable -> L17
        if (r100.isSatisfied() == false) goto L4;
        if (r102 == true) goto L16;
        endWaitingFor(r100);
    L16:
        return true;
    L5:
        if (r102 == true) goto L7;
        endWaitingFor(r100);
    L7:
        return false;
    }

    public boolean enterIf(Guard r100, long r101, TimeUnit r102) {
        if (r100.monitor != this) goto L16;
        if (enter(r101, r102) == true) goto L17;
        return false;
    L17:
        boolean r103 = r100.isSatisfied();     // Catch: Throwable -> L12
        if (r103 == true) goto L11;
        this.lock.unlock();
    L11:
        return r103;
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterIfInterruptibly(Guard r100, long r101, TimeUnit r102) throws InterruptedException {
        if (r100.monitor != this) goto L16;
        ReentrantLock r103 = this.lock;
        if (r103.tryLock(r101, r102) == true) goto L17;
        return false;
    L17:
        boolean r104 = r100.isSatisfied();     // Catch: Throwable -> L12
        if (r104 == true) goto L11;
        r103.unlock();
    L11:
        return r104;
    L12:
        th = move-exception;
        r103.unlock();
        throw th;
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhen(Guard r110, long r111, TimeUnit r112) throws InterruptedException {
        long r100 = toSafeNanos(r111, r112);
        if (r110.monitor != this) goto L38;
        ReentrantLock r101 = this.lock;
        boolean r102 = r101.isHeldByCurrentThread();
        boolean r103 = false;
        if (this.fair == false) goto L7;
    L13:
        long r104 = initNanoTime(r100);
        if (r101.tryLock(r111, r112) == true) goto L39;
        return false;
    L39:
    L28:
        th = move-exception;
        if (r102 == false) goto L41;
    L35:
        r101.unlock();
        throw th;
    L41:
        signalNextWaiter();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r101.unlock();
        throw th;
    L17:
        if (r110.isSatisfied() == false) goto L19;
    L24:
        r103 = true;
    L25:
        if (r103 == true) goto L27;
        r101.unlock();
    L27:
        return r103;
    L19:
        if (r104 == 0) goto L22;
        r100 = remainingNanos(r104, r100);     // Catch: Throwable -> L28
    L22:
        if (awaitNanos(r110, r100, r102) == false) goto L25;
    L7:
        if (Thread.interrupted() == true) goto L12;
        if (r101.tryLock() == false) goto L13;
        r104 = 0;
        goto L39
    L12:
        throw new InterruptedException();
    L38:
        throw new IllegalMonitorStateException();
    }

    public boolean enterWhenUninterruptibly(Guard r110, long r111, TimeUnit r112) {
        long r113 = toSafeNanos(r111, r112);
        if (r110.monitor != this) goto L44;
        ReentrantLock r114 = this.lock;
        boolean r100 = r114.isHeldByCurrentThread();
        boolean r101 = Thread.interrupted();
        boolean r102 = true;
        if (this.fair == false) goto L8;
    L11:
        long r103 = initNanoTime(r113);     // Catch: Throwable -> L39
        long r104 = r113;
    L46:
        if (r114.tryLock(r104, TimeUnit.NANOSECONDS) == true) goto L48;
        if (r101 == false) goto L34;
        ThreadMethodProxy.currentThread().interrupt();
    L34:
        return false;
    L48:
    L31:
        r100 = false;
        r101 = true;
    L28:
        th = move-exception;
        r114.unlock();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L16:
        if (r110.isSatisfied() == true) goto L23;
        if (r103 != 0) goto L21;
        r103 = initNanoTime(r113);     // Catch: Throwable -> L28 InterruptedException -> L31
        long r105 = r113;
    L22:
        r102 = awaitNanos(r110, r105, r100);     // Catch: Throwable -> L28 InterruptedException -> L31
    L21:
        r105 = remainingNanos(r103, r113);     // Catch: Throwable -> L28 InterruptedException -> L31
    L23:
        if (r102 == true) goto L25;
        r114.unlock();     // Catch: Throwable -> L39
    L25:
        if (r101 == false) goto L27;
        ThreadMethodProxy.currentThread().interrupt();
    L27:
        return r102;
    L35:
        r104 = remainingNanos(r103, r113);     // Catch: Throwable -> L37
        r101 = true;
    L37:
        th = th;
        r101 = true;
    L40:
        if (r101 == false) goto L42;
        ThreadMethodProxy.currentThread().interrupt();
    L42:
        throw th;
    L8:
        if (r114.tryLock() == false) goto L11;
        r103 = 0;
    L39:
        th = th;
        goto L40
    L44:
        throw new IllegalMonitorStateException();
    }

    public boolean waitFor(Guard r100, long r101, TimeUnit r102) throws InterruptedException {
        long r103 = toSafeNanos(r101, r102);
        if (r100.monitor != this) goto L16;
        if (this.lock.isHeldByCurrentThread() == false) goto L16;
        if (r100.isSatisfied() == false) goto L10;
        return true;
    L10:
        if (Thread.interrupted() == true) goto L14;
        return awaitNanos(r100, r103, true);
    L14:
        throw new InterruptedException();
    L16:
        throw new IllegalMonitorStateException();
    }

    public boolean waitForUninterruptibly(Guard r100, long r101, TimeUnit r110) {
        long r102 = toSafeNanos(r101, r110);
        if (r100.monitor != this) goto L27;
        if (this.lock.isHeldByCurrentThread() == false) goto L27;
        boolean r103 = true;
        if (r100.isSatisfied() == false) goto L9;
        return true;
    L9:
        long r104 = initNanoTime(r102);
        boolean r111 = Thread.interrupted();
        long r105 = r102;
        boolean r106 = true;
    L28:
        boolean r107 = awaitNanos(r100, r105, r106);     // Catch: Throwable -> L14 InterruptedException -> L16
        goto L17
    L11:
        if (r111 == false) goto L13;
        ThreadMethodProxy.currentThread().interrupt();
    L13:
        return r107;
    L14:
        th = th;
        r103 = r111;
    L23:
        if (r103 == false) goto L25;
        ThreadMethodProxy.currentThread().interrupt();
    L25:
        throw th;
    L22:
        th = th;
    L17:
        if (r100.isSatisfied() == true) goto L18;
        r105 = remainingNanos(r104, r102);     // Catch: Throwable -> L22
        r106 = false;
        r111 = true;
        goto L28
    L18:
        ThreadMethodProxy.currentThread().interrupt();
        return true;
    L27:
        throw new IllegalMonitorStateException();
    }
}
