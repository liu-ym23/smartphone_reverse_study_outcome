package com.ss.android.ugc.aweme.kiwi.viewmodel;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import vgc.a;

/* JADX INFO: loaded from: classes40.dex */
public class QArchLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f450938c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f450939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer, QArchLiveData<T>.NextObserver<T>> f450940b;

    public class NextObserver<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f450941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<R> f450942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f450943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ QArchLiveData f450944d;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(R r100) {
            if (this.f450943c == false) goto L5;
        L7:
            this.f450942b.onChanged(r100);
            return;
        L5:
            if (this.f450941a < this.f450944d.f450939a) goto L7;
        }

        public NextObserver(QArchLiveData r100, int r101, Observer<R> r102, boolean r103) {
            this.f450944d = r100;
            this.f450941a = r101;
            this.f450942b = r102;
            this.f450943c = r103;
        }
    }

    static {
        f450938c = new Handler(Looper.getMainLooper());
    }

    public QArchLiveData() {
        this.f450939a = -1;
        this.f450940b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<T> r100) {
        if (((HashMap) this.f450940b).containsKey(r100) == true) goto L7;
        NextObserver r101 = new NextObserver(this, this.f450939a, r100, false);
        ((HashMap) this.f450940b).put(r100, r101);
        super.observeForever(r101);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(final T r100) {
        f450938c.post(new a(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<T> r100) {
        NextObserver r101 = (NextObserver) ((HashMap) this.f450940b).remove(r100);
        if (r101 == null) goto L7;
        super.removeObserver(r101);
        return;
    L7:
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator r102 = ((HashMap) this.f450940b).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = (Observer) r103.getKey();
        super.removeObserver(r100);
    L15:
        if (r104 == null) goto L22;
        ((HashMap) this.f450940b).remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f450939a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<T> r101) {
        observe(r100, r101, false);
    }

    public final void observe(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        if (((HashMap) this.f450940b).containsKey(r101) == false) goto L5;
        return;
    L5:
        NextObserver r103 = new NextObserver(this, this.f450939a, r101, r102);
        ((HashMap) this.f450940b).put(r101, r103);
        super.observe(r100, r103);
    }
}
