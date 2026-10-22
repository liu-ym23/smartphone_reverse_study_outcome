package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class LiveData<T> {
    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        public boolean isAttachedTo(LifecycleOwner r2) {
            if (this.mOwner != r2) goto L5;
            return true;
        L5:
            return false;
        }

        public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Lifecycle.State r4 = this.mOwner.getLifecycle().getCurrentState();
            if (r4 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(((ObserverWrapper) this).mObserver);
            return;
        L6:
            Lifecycle.State r5 = null;
        L7:
            if (r5 == r4) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r6 = this.mOwner.getLifecycle().getCurrentState();
            r5 = r4;
            r4 = r6;
            goto L7
        }

        public LifecycleBoundObserver(LiveData r1, LifecycleOwner r2, Observer<? super T> r3) {
            this.this$0 = r1;
            super(r1, r3);
            this.mOwner = r2;
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    static {
        NOT_SET = new Object();
    }

    public T getValue() {
        T r0 = (T) this.mData;
        if (r0 == NOT_SET) goto L5;
        return r0;
    L5:
        return null;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInitialized() {
        if (this.mData == NOT_SET) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r0 = NOT_SET;
        this.mPendingData = r0;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r0;
        this.mVersion = -1;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public LiveData(T r3) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r3;
        this.mVersion = 0;
    }

    public static void assertMainThread(String r3) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r3 + " on a background thread");
    }

    /* JADX WARN: Incorrect inner types in method signature: (Landroidx/lifecycle/LiveData<TT;>.ObserverWrapper;)V */
    private void considerNotify(ObserverWrapper r3) {
        if (r3.mActive == true) goto L6;
        return;
    L6:
        if (r3.shouldBeActive() == true) goto L9;
        r3.activeStateChanged(false);
        return;
    L9:
        int r0 = r3.mLastVersion;
        int r1 = this.mVersion;
        if (r0 < r1) goto L12;
        return;
    L12:
        r3.mLastVersion = r1;
        r3.mObserver.onChanged(this.mData);
    }

    public void changeActiveCounter(int r5) {
        int r0 = this.mActiveCount;
        this.mActiveCount = r5 + r0;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L27:
        int r2 = this.mActiveCount;     // Catch: Throwable -> L24
        if (r0 == r2) goto L22;
        if (r0 != 0) goto L12;
        if (r2 <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r0 <= 0) goto L16;
        if (r2 != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r3 == false) goto L19;
        onActive();     // Catch: Throwable -> L24
    L21:
        r0 = r2;
        goto L27
    L19:
        if (r1 == false) goto L21;
        onInactive();     // Catch: Throwable -> L24
    L16:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    L22:
        this.mChangingActiveState = false;
        return;
    L24:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    /* JADX WARN: Incorrect inner types in method signature: (Landroidx/lifecycle/LiveData<TT;>.ObserverWrapper;)V */
    public void dispatchingValue(ObserverWrapper r4) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r4 == null) goto L10;
        considerNotify(r4);
        r4 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap.IteratorWithAdditions r1 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r1.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) ((Map.Entry) r1.next()).getValue());
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    public void observeForever(Observer<? super T> r3) {
        assertMainThread("observeForever");
        LiveData<T>.ObserverWrapper r0 = new AlwaysActiveObserver(this, r3);
        LiveData<T>.ObserverWrapper r4 = this.mObservers.putIfAbsent(r3, r0);
        if ((r4 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r4 == null) goto L6;
        return;
    L6:
        r0.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void postValue(T r4) {
        Object r0 = this.mDataLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r1 = true;
    L8:
        this.mPendingData = r4;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void removeObserver(Observer<? super T> r2) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r3 = this.mObservers.remove(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        r3.detachObserver();
        r3.activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner r4) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r0 = this.mObservers.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r1 = r0.next();
        if (r1.getValue().isAttachedTo(r4) == false) goto L4;
        removeObserver(r1.getKey());
        goto L4
    }

    public void setValue(T r2) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r2;
        dispatchingValue(null);
    }

    public void observe(LifecycleOwner r3, Observer<? super T> r4) {
        assertMainThread("observe");
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r0 = new LifecycleBoundObserver(this, r3, r4);
        LiveData<T>.ObserverWrapper r5 = this.mObservers.putIfAbsent(r4, r0);
        if (r5 != null) goto L8;
    L12:
        if (r5 == null) goto L14;
        return;
    L14:
        r3.getLifecycle().addObserver(r0);
        return;
    L8:
        if (r5.isAttachedTo(r3) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
}
