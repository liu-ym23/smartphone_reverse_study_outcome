package com.ss.android.ugc.aweme.search.common.base.livedata;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class NextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f451490c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f451491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> f451492b;

    public class NextObserver<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f451495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<R> f451496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f451497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f451498d;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(R r100) {
            if (this.f451497c == false) goto L5;
        L7:
            this.f451496b.onChanged(r100);
            return;
        L5:
            if (this.f451495a < this.f451498d.f451491a) goto L7;
        }

        public NextObserver(NextLiveData r100, int r101, Observer r102) {
            this.f451498d = r100;
            this.f451495a = r101;
            this.f451496b = r102;
            this.f451497c = false;
        }
    }

    static {
        f451490c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f451491a = -1;
        this.f451492b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        if (((HashMap) this.f451492b).containsKey(r100) == true) goto L7;
        NextObserver r101 = new NextObserver(this, this.f451491a, r100);
        ((HashMap) this.f451492b).put(r100, r101);
        super.observeForever(r101);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(final T r100) {
        f451490c.post(new AnonymousClass1(this, r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        NextObserver r101 = (NextObserver) ((HashMap) this.f451492b).remove(r100);
        if (r101 == null) goto L7;
        super.removeObserver(r101);
        return;
    L7:
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator r102 = ((HashMap) this.f451492b).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = (Observer) r103.getKey();
        super.removeObserver(r100);
    L15:
        if (r104 == null) goto L22;
        ((HashMap) this.f451492b).remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f451491a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        if (((HashMap) this.f451492b).containsKey(r101) == false) goto L6;
        return;
    L6:
        if (r100.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        NextObserver r102 = new NextObserver(this, this.f451491a, r101);
        ((HashMap) this.f451492b).put(r101, r102);
        super.observe(r100, r102);
        return;
    }
}
