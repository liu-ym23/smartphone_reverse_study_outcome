package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    List<? extends ListenableFuture<? extends V>> mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture<List<V>> mResult;
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    List<V> mValues;

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> r0 = this.mFutures;
        if (r0 != null) goto L5;
        return;
    L5:
        if (isDone() == true) goto L30;
        Iterator<? extends ListenableFuture<? extends V>> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L31;
        ListenableFuture<? extends V> r2 = r1.next();
    L11:
        if (r2.isDone() == true) goto L8;
        r2.get();     // Catch: Throwable -> L14 InterruptedException -> L17 Error -> L19
    L19:
        e = move-exception;
        throw e;
    L17:
        e = move-exception;
        throw e;
    L15:
        if (this.mAllMustSucceed == false) goto L11;
        return;
    L31:
        return;
    }

    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    public boolean isDone() {
        return this.mResult.isDone();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public List<V> m73get() throws InterruptedException, ExecutionException {
        callAllGets();
        return (List) this.mResult.get();
    }

    public /* bridge */ /* synthetic */ Object get() throws ExecutionException, InterruptedException {
        return m73get();
    }

    private void init(Executor r5) {
        addListener(new AnonymousClass2(this), CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty() == false) goto L6;
        this.mResultNotifier.set(new ArrayList(this.mValues));
        return;
    L6:
        final int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= this.mFutures.size()) goto L10;
        this.mValues.add(null);
        r1 = r1 + 1;
        goto L8
    L10:
        List<? extends ListenableFuture<? extends V>> r2 = this.mFutures;
    L12:
        if (r0 >= r2.size()) goto L14;
        final ListenableFuture r3 = (ListenableFuture) ListProtector.get(r2, r0);
        r3.addListener(new AnonymousClass3(this, r0, r3), r5);
        r0 = r0 + 1;
        goto L12
    }

    public boolean cancel(boolean r3) {
        List<? extends ListenableFuture<? extends V>> r0 = this.mFutures;
        if (r0 == null) goto L9;
        Iterator<? extends ListenableFuture<? extends V>> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r1.next().cancel(r3);
    L9:
        return this.mResult.cancel(r3);
    }

    public void addListener(Runnable r2, Executor r3) {
        this.mResult.addListener(r2, r3);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public List<V> m74get(long r2, TimeUnit r4) throws InterruptedException, ExecutionException, TimeoutException {
        return (List) this.mResult.get(r2, r4);
    }

    public void setOneValue(int r7, Future<? extends V> r8) {
        List<V> r1 = this.mValues;
        if (isDone() == true) goto L82;
        if (r1 == null) goto L82;
        boolean r2 = true;
        Preconditions.checkState(r8.isDone(), "Tried to set value from future which is not done");     // Catch: Throwable -> L19 Error -> L21 RuntimeException -> L32 ExecutionException -> L45 CancellationException -> L58
        r1.set(r7, (V) Futures.getUninterruptibly(r8));     // Catch: Throwable -> L19 Error -> L21 RuntimeException -> L32 ExecutionException -> L45 CancellationException -> L58
        int r9 = this.mRemaining.decrementAndGet();
        if (r9 >= 0) goto L12;
        r2 = false;
    L12:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r9 != 0) goto L70;
        List<V> r10 = this.mValues;
        if (r10 == null) goto L18;
        CallbackToFutureAdapter.Completer<List<V>> r11 = this.mResultNotifier;
        ArrayList r0 = new ArrayList(r10);
    L17:
        r11.set(r0);
        return;
    L18:
        Preconditions.checkState(isDone());
        return;
    L70:
        return;
    L19:
        th = move-exception;
        int r12 = this.mRemaining.decrementAndGet();
        if (r12 >= 0) goto L75;
        r2 = false;
    L75:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r12 != 0) goto L81;
        List<V> r13 = this.mValues;
        if (r13 == null) goto L80;
        this.mResultNotifier.set(new ArrayList(r13));
        goto L81
    L80:
        Preconditions.checkState(isDone());
    L81:
        throw th;
    L45:
        e = move-exception;
        if (this.mAllMustSucceed == false) goto L49;
        this.mResultNotifier.setException(e.getCause());     // Catch: Throwable -> L19
    L49:
        int r14 = this.mRemaining.decrementAndGet();
        if (r14 >= 0) goto L53;
        r2 = false;
    L53:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r14 != 0) goto L90;
        List<V> r15 = this.mValues;
        if (r15 == null) goto L18;
        r11 = this.mResultNotifier;
        r0 = new ArrayList(r15);
        goto L17
    L90:
        return;
    L32:
        e = move-exception;
        if (this.mAllMustSucceed == false) goto L36;
        this.mResultNotifier.setException(e);     // Catch: Throwable -> L19
    L36:
        int r16 = this.mRemaining.decrementAndGet();
        if (r16 >= 0) goto L40;
        r2 = false;
    L40:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r16 != 0) goto L89;
        List<V> r17 = this.mValues;
        if (r17 == null) goto L18;
        r11 = this.mResultNotifier;
        r0 = new ArrayList(r17);
        goto L17
    L89:
        return;
    L21:
        e = move-exception;
        this.mResultNotifier.setException(e);     // Catch: Throwable -> L19
        int r18 = this.mRemaining.decrementAndGet();
        if (r18 >= 0) goto L27;
        r2 = false;
    L27:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r18 != 0) goto L88;
        List<V> r19 = this.mValues;
        if (r19 == null) goto L18;
        r11 = this.mResultNotifier;
        r0 = new ArrayList(r19);
        goto L17
    L88:
        return;
    L59:
        if (this.mAllMustSucceed == false) goto L61;
        cancel(false);     // Catch: Throwable -> L19
    L61:
        int r20 = this.mRemaining.decrementAndGet();
        if (r20 >= 0) goto L65;
        r2 = false;
    L65:
        Preconditions.checkState(r2, "Less than 0 remaining futures");
        if (r20 != 0) goto L91;
        List<V> r21 = this.mValues;
        if (r21 == null) goto L18;
        r11 = this.mResultNotifier;
        r0 = new ArrayList(r21);
        goto L17
    L91:
        return;
    L82:
        Preconditions.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
    }

    public /* bridge */ /* synthetic */ Object get(long r1, TimeUnit r3) throws ExecutionException, InterruptedException, TimeoutException {
        return m74get(r1, r3);
    }

    public ListFuture(List<? extends ListenableFuture<? extends V>> r3, boolean r4, Executor r5) {
        this.mFutures = (List) Preconditions.checkNotNull(r3);
        this.mValues = new ArrayList(r3.size());
        this.mAllMustSucceed = r4;
        this.mRemaining = new AtomicInteger(r3.size());
        this.mResult = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this));
        init(r5);
    }
}
