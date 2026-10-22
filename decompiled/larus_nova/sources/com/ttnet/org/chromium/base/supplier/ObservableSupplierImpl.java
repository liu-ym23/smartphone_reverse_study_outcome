package com.ttnet.org.chromium.base.supplier;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObserverList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public class ObservableSupplierImpl<E> implements ObservableSupplier<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sIgnoreThreadChecksForTesting;
    private final Handler mHandler;
    private E mObject;
    private final ObserverList<Callback<E>> mObservers;
    private final Thread mThread;

    public static /* synthetic */ void a(ObservableSupplierImpl r100, Object r101, Callback r102) {
        r100.lambda$addObserver$0(r101, r102);
    }

    private void checkThread() {
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    public final /* synthetic */ boolean hasValue() {
        return Supplier.CC.$default$hasValue(this);
    }

    public ObservableSupplierImpl() {
        this.mThread = ThreadMethodProxy.currentThread();
        this.mHandler = new Handler();
        this.mObservers = new ObserverList();
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    public E get() {
        checkThread();
        return this.mObject;
    }

    static {
    }

    public static void setIgnoreThreadChecksForTesting(boolean r100) {
        sIgnoreThreadChecksForTesting = r100;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public E addObserver(final Callback<E> r100) {
        checkThread();
        this.mObservers.addObserver(r100);
        final E r101 = this.mObject;
        if (r101 == null) goto L6;
        this.mHandler.post(new a(this, r101, r100));
    L6:
        return this.mObject;
    }

    @Override // com.ttnet.org.chromium.base.supplier.ObservableSupplier
    public void removeObserver(Callback<E> r100) {
        checkThread();
        this.mObservers.removeObserver(r100);
    }

    public void set(E r100) {
        checkThread();
        if (r100 != this.mObject) goto L5;
        return;
    L5:
        this.mObject = r100;
        Iterator<Callback<E>> r101 = this.mObservers.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onResult(this.mObject);
        goto L7
    }

    private /* synthetic */ void lambda$addObserver$0(Object r100, Callback r101) {
        if (this.mObject == r100) goto L5;
        return;
    L5:
        if (this.mObservers.hasObserver(r101) == false) goto L10;
        r101.onResult(this.mObject);
        return;
    }
}
