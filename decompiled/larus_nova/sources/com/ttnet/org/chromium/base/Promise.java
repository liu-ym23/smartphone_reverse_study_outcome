package com.ttnet.org.chromium.base;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes41.dex */
public class Promise<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Callback<T>> mFulfillCallbacks;
    private final Handler mHandler;
    private final List<Callback<Exception>> mRejectCallbacks;
    private Exception mRejectReason;
    private T mResult;
    private int mState;
    private final Thread mThread;
    private boolean mThrowingRejectionHandler;

    public interface AsyncFunction<A, RT> extends Function<A, Promise<RT>> {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(Promise r100, Function r101, Object r102) {
        lambda$then$1(r100, r101, r102);
    }

    public static /* synthetic */ void b(AsyncFunction r100, Promise r101, Object r102) {
        lambda$then$2(r100, r101, r102);
    }

    public static /* synthetic */ void c(Exception r100) {
        lambda$then$0(r100);
    }

    private void checkThread() {
    }

    public void reject() {
        reject(null);
    }

    public static <T> Promise<T> rejected() {
        Promise<T> r100 = new Promise();
        r100.reject();
        return r100;
    }

    public Promise() {
        this.mState = 0;
        this.mFulfillCallbacks = new LinkedList();
        this.mRejectCallbacks = new LinkedList();
        this.mThread = ThreadMethodProxy.currentThread();
        this.mHandler = new Handler();
    }

    public boolean isFulfilled() {
        checkThread();
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRejected() {
        checkThread();
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }

    public T getResult() {
        return this.mResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> r100) {
        int r101 = this.mState;
        if (r101 != 2) goto L5;
        postCallbackToLooper(r100, this.mRejectReason);
        return;
    L5:
        if (r101 != 0) goto L9;
        this.mRejectCallbacks.add(r100);
        return;
    }

    public static <T> Promise<T> fulfilled(T r100) {
        Promise<T> r101 = new Promise();
        r101.fulfill(r100);
        return r101;
    }

    private static /* synthetic */ void lambda$then$0(Exception r100) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> r100) {
        int r101 = this.mState;
        if (r101 != 1) goto L5;
        postCallbackToLooper(r100, this.mResult);
        return;
    L5:
        if (r101 != 0) goto L9;
        this.mFulfillCallbacks.add(r100);
        return;
    }

    public void except(Callback<Exception> r100) {
        checkThread();
        exceptInner(r100);
    }

    public void fulfill(T r100) {
        checkThread();
        this.mState = 1;
        this.mResult = r100;
        Iterator<Callback<T>> r101 = this.mFulfillCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        postCallbackToLooper(r101.next(), r100);
        goto L4
    L6:
        this.mFulfillCallbacks.clear();
    }

    public void reject(Exception r100) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = r100;
        Iterator<Callback<Exception>> r101 = this.mRejectCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) r101.next(), r100);
        goto L4
    L6:
        this.mRejectCallbacks.clear();
    }

    public <RT> Promise<RT> then(final Function<T, RT> r100) {
        checkThread();
        final Promise<RT> r101 = new Promise();
        thenInner(new i(r101, r100));
        exceptInner(new f(r101));
        return r101;
    }

    public <RT> Promise<RT> then(final AsyncFunction<T, RT> r100) {
        checkThread();
        final Promise<RT> r101 = new Promise();
        thenInner(new e(r100, r101));
        exceptInner(new f(r101));
        return r101;
    }

    public void then(Callback<T> r100) {
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r100);
        return;
    L6:
        then(r100, new h());
        this.mThrowingRejectionHandler = true;
    }

    private <S> void postCallbackToLooper(Callback<S> r100, S r101) {
        this.mHandler.post(r100.bind(r101));
    }

    public void then(Callback<T> r100, Callback<Exception> r101) {
        checkThread();
        thenInner(r100);
        exceptInner(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$then$1(Promise r100, Function r101, Object r102) {
        r100.fulfill(r101.apply(r102));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r100.reject(e);
    }

    private static /* synthetic */ void lambda$then$2(AsyncFunction r100, final Promise r101, Object r102) {
        Promise r103 = r100.apply(r102);     // Catch: Exception -> L4
        Objects.requireNonNull(r101);     // Catch: Exception -> L4
        r103.then(new g(r101), new f(r101));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r101.reject(e);
    }
}
