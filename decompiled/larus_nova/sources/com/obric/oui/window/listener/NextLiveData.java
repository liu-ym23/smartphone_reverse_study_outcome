package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class NextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f403747c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f403748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer<? super T>, NextLiveData<T>.b<? super T>> f403749b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f403750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f403751b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f403751b.setValue(this.f403750a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NextLiveData r100, Object r101) {
            this.f403751b = r100;
            this.f403750a = r101;
        }
    }

    public class b<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f403752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<R> f403753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f403754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f403755d;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(R r100) {
            if (this.f403754c == false) goto L5;
        L7:
            this.f403753b.onChanged(r100);
            return;
        L5:
            if (this.f403752a < this.f403755d.f403748a) goto L7;
        }

        public b(NextLiveData r100, int r101, Observer r102) {
            this.f403755d = r100;
            this.f403752a = r101;
            this.f403753b = r102;
            this.f403754c = false;
        }
    }

    static {
        f403747c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f403748a = -1;
        this.f403749b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        if (((HashMap) this.f403749b).containsKey(r100) == true) goto L7;
        b r101 = new b(this, this.f403748a, r100);
        ((HashMap) this.f403749b).put(r100, r101);
        super.observeForever(r101);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        f403747c.post(new a(this, r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        b r101 = (b) ((HashMap) this.f403749b).remove(r100);
        if (r101 == null) goto L7;
        super.removeObserver(r101);
        return;
    L7:
        if ((r100 instanceof b) == false) goto L21;
        Iterator r102 = ((HashMap) this.f403749b).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = (Observer) r103.getKey();
        super.removeObserver(r100);
    L15:
        if (r104 == null) goto L22;
        ((HashMap) this.f403749b).remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f403748a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        if (((HashMap) this.f403749b).containsKey(r101) == true) goto L7;
        b r102 = new b(this, this.f403748a, r101);
        ((HashMap) this.f403749b).put(r101, r102);
        super.observe(r100, r102);
        return;
    }
}
