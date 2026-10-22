package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = null;
    private final Monitor.Guard hasReachedRunning;
    private final Monitor.Guard isStartable;
    private final Monitor.Guard isStoppable;
    private final Monitor.Guard isStopped;
    private final ListenerCallQueue<Service.Listener> listeners;
    private final Monitor monitor;
    private volatile StateSnapshot snapshot;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractService$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State = null;

        static {
            int[] r100 = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = r100;
            r100[Service.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STOPPING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public final class HasReachedRunningGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public HasReachedRunningGuard(AbstractService r100) {
            this.this$0 = r100;
            super(AbstractService.access$000(r100));
        }
    }

    public final class IsStartableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state() != Service.State.NEW) goto L5;
            return true;
        L5:
            return false;
        }

        public IsStartableGuard(AbstractService r100) {
            this.this$0 = r100;
            super(AbstractService.access$000(r100));
        }
    }

    public final class IsStoppableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) > 0) goto L5;
            return true;
        L5:
            return false;
        }

        public IsStoppableGuard(AbstractService r100) {
            this.this$0 = r100;
            super(AbstractService.access$000(r100));
        }
    }

    public final class IsStoppedGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.TERMINATED) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public IsStoppedGuard(AbstractService r100) {
            this.this$0 = r100;
            super(AbstractService.access$000(r100));
        }
    }

    public static final class StateSnapshot {

        @CheckForNull
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        public Service.State externalState() {
            if (this.shutdownWhenStartupFinishes == false) goto L9;
            if (this.state != Service.State.STARTING) goto L9;
            return Service.State.STOPPING;
        L9:
            return this.state;
        }

        public Throwable failureCause() {
            Service.State r100 = this.state;
            if (r100 != Service.State.FAILED) goto L5;
            boolean r101 = true;
        L6:
            com.google.common.base.m.s(r101, "failureCause() is only valid if the service has failed, service is %s", r100);
            Throwable r102 = this.failure;
            Objects.requireNonNull(r102);
            return r102;
        L5:
            r101 = false;
            goto L6
        }

        public StateSnapshot(Service.State r100) {
            this(r100, false, null);
        }

        public StateSnapshot(Service.State r100, boolean r101, @CheckForNull Throwable r102) {
            boolean r103 = false;
            if (r101 == true) goto L5;
        L8:
            boolean r104 = true;
        L9:
            com.google.common.base.m.h(r104, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", r100);
            if (r102 == null) goto L12;
            boolean r105 = true;
        L14:
            if (r100 != Service.State.FAILED) goto L16;
            boolean r106 = true;
        L17:
            if (r105 != r106) goto L19;
            r103 = true;
        L19:
            com.google.common.base.m.i(r103, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", r100, r102);
            this.state = r100;
            this.shutdownWhenStartupFinishes = r101;
            this.failure = r102;
            return;
        L16:
            r106 = false;
            goto L17
        L12:
            r105 = false;
            goto L14
        L5:
            if (r100 == Service.State.STARTING) goto L8;
            r104 = false;
            goto L9
        }
    }

    public void doCancelStart() {
    }

    public abstract void doStart();

    public abstract void doStop();

    static {
        STARTING_EVENT = new AnonymousClass1();
        RUNNING_EVENT = new AnonymousClass2();
        Service.State r100 = Service.State.STARTING;
        STOPPING_FROM_STARTING_EVENT = stoppingEvent(r100);
        Service.State r101 = Service.State.RUNNING;
        STOPPING_FROM_RUNNING_EVENT = stoppingEvent(r101);
        TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
        TERMINATED_FROM_STARTING_EVENT = terminatedEvent(r100);
        TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(r101);
        TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    }

    private void dispatchListenerEvents() {
        if (this.monitor.isOccupiedByCurrentThread() == true) goto L6;
        this.listeners.dispatch();
        return;
    }

    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    public final void notifyStarted() {
        this.monitor.enter();
    L13:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    L4:
        if (this.snapshot.state == Service.State.STARTING) goto L6;
        IllegalStateException r100 = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);     // Catch: Throwable -> L13
        notifyFailed(r100);     // Catch: Throwable -> L13
        throw r100;     // Catch: Throwable -> L13
    L6:
        if (this.snapshot.shutdownWhenStartupFinishes == false) goto L8;
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L13
        doStop();     // Catch: Throwable -> L13
    L9:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        this.snapshot = new StateSnapshot(Service.State.RUNNING);     // Catch: Throwable -> L13
        enqueueRunningEvent();     // Catch: Throwable -> L13
        goto L9
    }

    public final void notifyStopped() {
        this.monitor.enter();
        Service.State r100 = state();     // Catch: Throwable -> L11
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r100.ordinal()]) {
            case 1: goto L8;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L9;
        };     // Catch: Throwable -> L11
    L6:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L11
        enqueueTerminatedEvent(r100);     // Catch: Throwable -> L11
    L9:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        throw new IllegalStateException("Cannot notifyStopped() when the service is " + r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable) == false) goto L14;
        this.snapshot = new StateSnapshot(Service.State.STARTING);     // Catch: Throwable -> L6
        enqueueStartingEvent();     // Catch: Throwable -> L6
        doStart();     // Catch: Throwable -> L6
    L8:
        this.monitor.leave();
        dispatchListenerEvents();
        return this;
    L6:
        th = move-exception;
        Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L10
        notifyFailed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    L14:
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable) == true) goto L22;
    L19:
        return this;
    L22:
        Service.State r100 = state();     // Catch: Throwable -> L13
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L15;
        };     // Catch: Throwable -> L13
    L9:
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L13
        enqueueStoppingEvent(Service.State.RUNNING);     // Catch: Throwable -> L13
        doStop();     // Catch: Throwable -> L13
        goto L15
    L10:
        Service.State r101 = Service.State.STARTING;     // Catch: Throwable -> L13
        this.snapshot = new StateSnapshot(r101, true, null);     // Catch: Throwable -> L13
        enqueueStoppingEvent(r101);     // Catch: Throwable -> L13
        doCancelStart();     // Catch: Throwable -> L13
        goto L15
    L11:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L13
        enqueueTerminatedEvent(Service.State.NEW);     // Catch: Throwable -> L13
    L15:
        this.monitor.leave();
        dispatchListenerEvents();
        goto L19
    L8:
        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L16
        notifyFailed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    public AbstractService() {
        this.monitor = new Monitor();
        this.isStartable = new IsStartableGuard(this);
        this.isStoppable = new IsStoppableGuard(this);
        this.hasReachedRunning = new HasReachedRunningGuard(this);
        this.isStopped = new IsStoppedGuard(this);
        this.listeners = new ListenerCallQueue();
        this.snapshot = new StateSnapshot(Service.State.NEW);
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() != Service.State.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ Monitor access$000(AbstractService r100) {
        return r100.monitor;
    }

    private void checkCurrentState(Service.State r100) {
        Service.State r101 = state();
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 != Service.State.FAILED) goto L9;
        throw new IllegalStateException("Expected the service " + this + " to be " + r100 + ", but the service has FAILED", failureCause());
    L9:
        throw new IllegalStateException("Expected the service " + this + " to be " + r100 + ", but was " + r101);
    }

    private void enqueueStoppingEvent(Service.State r100) {
        if (r100 != Service.State.STARTING) goto L6;
        this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        return;
    L6:
        if (r100 != Service.State.RUNNING) goto L10;
        this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
        return;
    L10:
        throw new AssertionError();
    }

    private void enqueueTerminatedEvent(Service.State r100) {
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r100.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L15;
        };
    L7:
        this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
        return;
    L8:
        this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
        return;
    L9:
        this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
        return;
    L10:
        this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
        return;
    L15:
        return;
    L6:
        throw new AssertionError();
    }

    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State r100) {
        return new AnonymousClass4(r100);
    }

    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State r100) {
        return new AnonymousClass3(r100);
    }

    public final void notifyFailed(Throwable r100) {
        r100.getClass();
        this.monitor.enter();
        Service.State r101 = state();     // Catch: Throwable -> L19
        int r102 = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r101.ordinal()];     // Catch: Throwable -> L19
        if (r102 == 1) goto L18;
        if (r102 != 2) goto L8;
    L14:
        this.snapshot = new StateSnapshot(Service.State.FAILED, false, r100);     // Catch: Throwable -> L19
        enqueueFailedEvent(r101, r100);     // Catch: Throwable -> L19
    L15:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        if (r102 == 3) goto L14;
        if (r102 == 4) goto L14;
        if (r102 != 5) goto L15;
    L18:
        throw new IllegalStateException("Failed while in state:" + r101, r100);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    private void enqueueFailedEvent(final Service.State r100, final Throwable r101) {
        this.listeners.enqueue(new AnonymousClass5(this, r100, r101));
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r100, Executor r101) {
        this.listeners.addListener(r100, r101);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r100, TimeUnit r101) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, r100, r101) == false) goto L11;
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L11:
        throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r100, TimeUnit r101) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, r100, r101) == false) goto L11;
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L11:
        throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
    }
}
