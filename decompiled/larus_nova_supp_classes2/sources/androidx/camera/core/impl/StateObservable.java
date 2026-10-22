package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final Object mLock;
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet;
    private final AtomicReference<Object> mState;
    private boolean mUpdating;
    private int mVersion;
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap;

    public static abstract class ErrorWrapper {
        public ErrorWrapper() {
        }

        public abstract Throwable getError();

        public static ErrorWrapper wrap(Throwable r1) {
            return new AutoValue_StateObservable_ErrorWrapper(r1);
        }
    }

    public static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = null;
        private static final int NO_VERSION = -1;
        private final AtomicBoolean mActive;
        private final Executor mExecutor;
        private Object mLastState;
        private int mLatestSignalledVersion;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private boolean mWrapperUpdating;

        public void androidx_camera_core_impl_StateObservable$ObserverWrapper__run$___twin___() {
            monitor-enter(this);
        L31:
            th = move-exception;
            throw th;
        L4:
            if (this.mActive.get() == true) goto L8;
            this.mWrapperUpdating = false;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L8:
            Object r0 = this.mStateRef.get();     // Catch: Throwable -> L31
            int r2 = this.mLatestSignalledVersion;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
        L11:
            if (Objects.equals(this.mLastState, r0) == true) goto L16;
            this.mLastState = r0;
            if ((r0 instanceof ErrorWrapper) == false) goto L15;
            this.mObserver.onError(((ErrorWrapper) r0).getError());
            goto L16
        L15:
            this.mObserver.onNewData(r0);
        L16:
            monitor-enter(this);
        L28:
            th = move-exception;
            throw th;
        L18:
            if (r2 == this.mLatestSignalledVersion) goto L25;
            if (this.mActive.get() == false) goto L25;
            r0 = this.mStateRef.get();     // Catch: Throwable -> L28
            r2 = this.mLatestSignalledVersion;     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
        L25:
            this.mWrapperUpdating = false;     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_StateObservable$ObserverWrapper_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        static {
            NOT_SET = new Object();
        }

        public void close() {
            this.mActive.set(false);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_StateObservable$ObserverWrapper_com_larus_apm_impl_protector_RunnableLancet_run(ObserverWrapper r1) {
            r1.androidx_camera_core_impl_StateObservable$ObserverWrapper__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void update(int r2) {
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L4:
            if (this.mActive.get() == true) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L8:
            if (r2 > this.mLatestSignalledVersion) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L11:
            this.mLatestSignalledVersion = r2;     // Catch: Throwable -> L27
            if (this.mWrapperUpdating == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L15:
            this.mWrapperUpdating = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.mExecutor.execute(this);     // Catch: Throwable -> L19
            return;
        L19:
            monitor-enter(this);
            this.mWrapperUpdating = false;     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            throw th;
        }

        public ObserverWrapper(AtomicReference<Object> r3, Executor r4, Observable.Observer<? super T> r5) {
            this.mActive = new AtomicBoolean(true);
            this.mLastState = NOT_SET;
            this.mLatestSignalledVersion = -1;
            this.mWrapperUpdating = false;
            this.mStateRef = r3;
            this.mExecutor = r4;
            this.mObserver = r5;
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        Object r0 = this.mState.get();
        if ((r0 instanceof ErrorWrapper) == false) goto L7;
        return Futures.immediateFailedFuture(((ErrorWrapper) r0).getError());
    L7:
        return Futures.immediateFuture(r0);
    }

    public void removeObservers() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator r1 = new HashSet(this.mWrapperMap.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        removeObserverLocked((Observable.Observer) r1.next());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeObserverLocked(Observable.Observer<? super T> r2) {
        ObserverWrapper<T> r3 = this.mWrapperMap.remove(r2);
        if (r3 == null) goto L6;
        r3.close();
        this.mNotifySet.remove(r3);
        return;
    }

    private void updateStateInternal(Object r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mState.getAndSet(r4), r4) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L8:
        int r5 = this.mVersion + 1;     // Catch: Throwable -> L30
        this.mVersion = r5;     // Catch: Throwable -> L30
        if (this.mUpdating == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L12:
        this.mUpdating = true;     // Catch: Throwable -> L30
        Iterator<ObserverWrapper<T>> r1 = this.mNotifySet.iterator();     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
    L15:
        if (r1.hasNext() == true) goto L16;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (this.mVersion == r5) goto L21;
        Iterator<ObserverWrapper<T>> r6 = this.mNotifySet.iterator();     // Catch: Throwable -> L27
        int r3 = this.mVersion;     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        r1 = r6;
        r5 = r3;
        goto L15
    L21:
        this.mUpdating = false;     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        return;
    L16:
        r1.next().update(r5);
        goto L15
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeObserverLocked(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateState(T r1) {
        updateStateInternal(r1);
    }

    public void updateStateAsError(Throwable r1) {
        updateStateInternal(ErrorWrapper.wrap(r1));
    }

    public StateObservable(Object r2, boolean r3) {
        this.mLock = new Object();
        this.mVersion = 0;
        this.mUpdating = false;
        this.mWrapperMap = new HashMap();
        this.mNotifySet = new CopyOnWriteArraySet();
        if (r3 == false) goto L5;
        Preconditions.checkArgument(r2 instanceof Throwable, "Initial errors must be Throwable");
        this.mState = new AtomicReference(ErrorWrapper.wrap((Throwable) r2));
        return;
    L5:
        this.mState = new AtomicReference(r2);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r4, Observable.Observer<? super T> r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeObserverLocked(r5);     // Catch: Throwable -> L8
        ObserverWrapper<T> r1 = new ObserverWrapper(this.mState, r4, r5);     // Catch: Throwable -> L8
        this.mWrapperMap.put(r5, r1);     // Catch: Throwable -> L8
        this.mNotifySet.add(r1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r1.update(0);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
