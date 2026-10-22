package com.ttnet.org.chromium.base;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class CallbackController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ArrayList<WeakReference<Cancelable>> mCancelables;
    private final ReentrantLock mReentrantLock;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CallbackController$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AutoCloseableLock implements AutoCloseable {
        private boolean mIsLocked;
        private final Lock mLock;

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mIsLocked == false) goto L7;
            this.mIsLocked = false;
            this.mLock.unlock();
            return;
        L7:
            throw new IllegalStateException("mLock isn't locked.");
        }

        public static AutoCloseableLock lock(Lock r100) {
            r100.lock();
            return new AutoCloseableLock(r100, true);
        }

        private AutoCloseableLock(Lock r100, boolean r101) {
            this.mLock = r100;
            this.mIsLocked = r101;
        }
    }

    public interface Cancelable {
        void cancel();
    }

    public class CancelableCallback<T> implements Cancelable, Callback<T> {
        private Callback<T> mCallback;
        final /* synthetic */ CallbackController this$0;

        @Override // com.ttnet.org.chromium.base.Callback
        public final /* synthetic */ Runnable bind(Object r100) {
            return Callback.CC.$default$bind(this, r100);
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mCallback = null;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(T r100) {
            AutoCloseableLock r101 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Callback<T> r102 = this.mCallback;     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
            r102.onResult(r100);     // Catch: Throwable -> L9
        L6:
            if (r101 == null) goto L20;
            r101.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r101 != null) goto L18;
        L15:
            throw th;
        L18:
            r101.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.addSuppressed(th);
            goto L15
        }

        private CancelableCallback(CallbackController r100, Callback<T> r101) {
            this.this$0 = r100;
            this.mCallback = r101;
        }

        public /* synthetic */ CancelableCallback(CallbackController r100, Callback r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public class CancelableRunnable implements Cancelable, Runnable {
        private Runnable mRunnable;
        final /* synthetic */ CallbackController this$0;

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mRunnable = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ttnet_org_chromium_base_CallbackController$CancelableRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ttnet_org_chromium_base_CallbackController$CancelableRunnable__run$___twin___() {
            AutoCloseableLock r100 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Runnable r101 = this.mRunnable;     // Catch: Throwable -> L9
            if (r101 == null) goto L6;
            r101.run();     // Catch: Throwable -> L9
        L6:
            if (r100 == null) goto L20;
            r100.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r100 != null) goto L18;
        L15:
            throw th;
        L18:
            r100.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.addSuppressed(th);
            goto L15
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ttnet_org_chromium_base_CallbackController$CancelableRunnable_com_larus_apm_impl_protector_RunnableLancet_run(CancelableRunnable r100) {
            r100.com_ttnet_org_chromium_base_CallbackController$CancelableRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private CancelableRunnable(CallbackController r100, Runnable r101) {
            this.this$0 = r100;
            this.mRunnable = r101;
        }

        public /* synthetic */ CancelableRunnable(CallbackController r100, Runnable r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    private void checkNotCanceled() {
        if (this.mCancelables == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("This CallbackController has already been destroyed.");
    }

    public void destroy() {
        AutoCloseableLock r100 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L11
        Iterator r101 = CollectionUtil.strengthen(this.mCancelables).iterator();     // Catch: Throwable -> L11
    L5:
        if (r101.hasNext() == false) goto L7;
        ((Cancelable) r101.next()).cancel();     // Catch: Throwable -> L11
        goto L5
    L7:
        this.mCancelables = null;     // Catch: Throwable -> L11
        if (r100 == null) goto L23;
        r100.close();
        return;
    L23:
        return;
    L11:
        th = move-exception;
        if (r100 != null) goto L18;
    L17:
        throw th;
    L18:
        r100.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public CallbackController() {
        this.mCancelables = new ArrayList();
        this.mReentrantLock = new ReentrantLock(true);
    }

    static {
    }

    public static /* synthetic */ ReentrantLock access$000(CallbackController r100) {
        return r100.mReentrantLock;
    }

    public <T> Callback<T> makeCancelable(Callback<T> r100) {
        AutoCloseableLock r101 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableCallback r102 = new CancelableCallback(this, r100, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r102));     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        r101.close();
    L6:
        return r102;
    L7:
        th = move-exception;
        if (r101 != null) goto L14;
    L13:
        throw th;
    L14:
        r101.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public Runnable makeCancelable(Runnable r100) {
        AutoCloseableLock r101 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableRunnable r102 = new CancelableRunnable(this, r100, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r102));     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        r101.close();
    L6:
        return r102;
    L7:
        th = move-exception;
        if (r101 != null) goto L14;
    L13:
        throw th;
    L14:
        r101.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
