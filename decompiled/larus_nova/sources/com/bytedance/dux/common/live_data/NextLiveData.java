package com.bytedance.dux.common.live_data;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class NextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f204902c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f204903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer<? super T>, NextLiveData<T>.b<? super T>> f204904b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f204905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f204906b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f204906b.setValue(this.f204905a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NextLiveData r100, Object r101) {
            this.f204906b = r100;
            this.f204905a = r101;
        }
    }

    public class b<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<R> f204908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f204909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f204910d;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(R r100) {
            if (this.f204909c == false) goto L5;
        L7:
            this.f204908b.onChanged(r100);
            return;
        L5:
            if (this.f204907a < this.f204910d.f204903a) goto L7;
        }

        public b(NextLiveData r100, int r101, Observer r102) {
            this.f204910d = r100;
            this.f204907a = r101;
            this.f204908b = r102;
            this.f204909c = false;
        }
    }

    static {
        f204902c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f204903a = -1;
        this.f204904b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        if (((HashMap) this.f204904b).containsKey(r100) == true) goto L7;
        b r101 = new b(this, this.f204903a, r100);
        ((HashMap) this.f204904b).put(r100, r101);
        super.observeForever(r101);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        f204902c.post(new a(this, r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        b r101 = (b) ((HashMap) this.f204904b).remove(r100);
        if (r101 == null) goto L7;
        super.removeObserver(r101);
        return;
    L7:
        if ((r100 instanceof b) == false) goto L21;
        Iterator r102 = ((HashMap) this.f204904b).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = (Observer) r103.getKey();
        super.removeObserver(r100);
    L15:
        if (r104 == null) goto L22;
        ((HashMap) this.f204904b).remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f204903a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        if (((HashMap) this.f204904b).containsKey(r101) == true) goto L7;
        b r102 = new b(this, this.f204903a, r101);
        ((HashMap) this.f204904b).put(r101, r102);
        super.observe(r100, r102);
        return;
    }
}
