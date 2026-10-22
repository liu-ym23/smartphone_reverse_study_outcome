package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class LiveDataObservable<T> implements Observable<T> {
    final MutableLiveData<Result<T>> mLiveData;
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers;

    public static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {
        final AtomicBoolean mActive;
        final Executor mExecutor;
        final Observable.Observer<? super T> mObserver;

        public static /* synthetic */ void a(LiveDataObserverAdapter r0, Result r1) {
            r0.lambda$onChanged$0(r1);
        }

        public void disable() {
            this.mActive.set(false);
        }

        private /* synthetic */ void lambda$onChanged$0(Result r2) {
            if (this.mActive.get() == true) goto L6;
            return;
        L6:
            if (r2.completedSuccessfully() == false) goto L8;
            this.mObserver.onNewData((Object) r2.getValue());
            return;
        L8:
            Preconditions.checkNotNull(r2.getError());
            this.mObserver.onError(r2.getError());
        }

        public void onChanged(final Result<T> r3) {
            this.mExecutor.execute(new s(this, r3));
        }

        public /* bridge */ /* synthetic */ void onChanged(Object r1) {
            onChanged((Result) r1);
        }

        public LiveDataObserverAdapter(Executor r3, Observable.Observer<? super T> r4) {
            this.mActive = new AtomicBoolean(true);
            this.mExecutor = r3;
            this.mObserver = r4;
        }
    }

    public static final class Result<T> {
        private final Throwable mError;
        private final T mValue;

        public boolean completedSuccessfully() {
            if (this.mError != null) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[Result: <");
            if (completedSuccessfully() == false) goto L5;
            String r1 = "Value: " + this.mValue;
        L6:
            r0.append(r1);
            r0.append(">]");
            return r0.toString();
        L5:
            r1 = "Error: " + this.mError;
            goto L6
        }

        public T getValue() {
            if (completedSuccessfully() == false) goto L7;
            return this.mValue;
        L7:
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public Throwable getError() {
            return this.mError;
        }

        public static <T> Result<T> fromError(Throwable r2) {
            return new Result(null, (Throwable) Preconditions.checkNotNull(r2));
        }

        public static <T> Result<T> fromValue(T r2) {
            return new Result(r2, null);
        }

        private Result(T r1, Throwable r2) {
            this.mValue = r1;
            this.mError = r2;
        }
    }

    public static /* synthetic */ void a(LiveDataObservable r0, LiveDataObserverAdapter r1) {
        r0.lambda$removeObserver$3(r1);
    }

    public static /* synthetic */ void b(LiveDataObservable r0, LiveDataObserverAdapter r1, LiveDataObserverAdapter r2) {
        r0.lambda$addObserver$2(r1, r2);
    }

    public static /* synthetic */ void c(LiveDataObservable r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$fetchData$0(r1);
    }

    public static /* synthetic */ Object d(LiveDataObservable r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$fetchData$1(r1);
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.getFuture(new o(this));
    }

    public LiveDataObservable() {
        this.mLiveData = new MutableLiveData();
        this.mObservers = new HashMap();
    }

    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    private /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.Completer r3) {
        Result r0 = (Result) this.mLiveData.getValue();
        if (r0 != null) goto L6;
        r3.setException(new IllegalStateException("Observable has not yet been initialized with a value."));
        return;
    L6:
        if (r0.completedSuccessfully() == false) goto L8;
        r3.set(r0.getValue());
        return;
    L8:
        Preconditions.checkNotNull(r0.getError());
        r3.setException(r0.getError());
    }

    private /* synthetic */ Object lambda$fetchData$1(final CallbackToFutureAdapter.Completer r3) throws Exception {
        CameraXExecutors.mainThreadExecutor().execute(new p(this, r3));
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    private /* synthetic */ void lambda$removeObserver$3(LiveDataObserverAdapter r2) {
        this.mLiveData.removeObserver(r2);
    }

    public void postError(Throwable r2) {
        this.mLiveData.postValue(Result.fromError(r2));
    }

    public void postValue(T r2) {
        this.mLiveData.postValue(Result.fromValue(r2));
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r4) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> r0 = this.mObservers;
        monitor-enter(r0);
        final LiveDataObserverAdapter<T> r5 = this.mObservers.remove(r4);     // Catch: Throwable -> L9
        if (r5 == null) goto L7;
        r5.disable();     // Catch: Throwable -> L9
        CameraXExecutors.mainThreadExecutor().execute(new q(this, r5));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$addObserver$2(LiveDataObserverAdapter r2, LiveDataObserverAdapter r3) {
        if (r2 == null) goto L4;
        this.mLiveData.removeObserver(r2);
    L4:
        this.mLiveData.observeForever(r3);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r4, Observable.Observer<? super T> r5) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> r0 = this.mObservers;
        monitor-enter(r0);
        final LiveDataObserverAdapter<T> r1 = this.mObservers.get(r5);     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.disable();     // Catch: Throwable -> L10
    L7:
        final LiveDataObserverAdapter<T> r2 = new LiveDataObserverAdapter(r4, r5);     // Catch: Throwable -> L10
        this.mObservers.put(r5, r2);     // Catch: Throwable -> L10
        CameraXExecutors.mainThreadExecutor().execute(new r(this, r1, r2));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
