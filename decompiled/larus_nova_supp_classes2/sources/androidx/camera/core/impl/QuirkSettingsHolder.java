package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class QuirkSettingsHolder {
    public static final QuirkSettings DEFAULT = null;
    private static final QuirkSettingsHolder sInstance = null;
    private final MutableStateObservable<QuirkSettings> mObservable;

    public static class ObserverToConsumerAdapter<T> implements Observable.Observer<T> {
        private static final String TAG = "ObserverToConsumerAdapter";
        private final Consumer<T> mDelegate;

        public ObserverToConsumerAdapter(Consumer<T> r1) {
            this.mDelegate = r1;
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(Throwable r3) {
            Logger.e(TAG, "Unexpected error in Observable", r3);
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onNewData(T r2) {
            this.mDelegate.accept(r2);
        }
    }

    public QuirkSettings get() {
        return (QuirkSettings) this.mObservable.fetchData().get();
    L4:
        e = move-exception;
        throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e);
    }

    public void reset() {
        this.mObservable.removeObservers();
        this.mObservable.setState(DEFAULT);
    }

    static {
        DEFAULT = QuirkSettings.withDefaultBehavior();
        sInstance = new QuirkSettingsHolder();
    }

    public QuirkSettingsHolder() {
        this.mObservable = MutableStateObservable.withInitialState(DEFAULT);
    }

    public static QuirkSettingsHolder instance() {
        return sInstance;
    }

    public void set(QuirkSettings r2) {
        this.mObservable.setState(r2);
    }

    public void observe(Executor r3, Consumer<QuirkSettings> r4) {
        this.mObservable.addObserver(r3, new ObserverToConsumerAdapter(r4));
    }
}
