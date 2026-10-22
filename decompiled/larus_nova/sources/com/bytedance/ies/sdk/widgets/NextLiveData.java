package com.bytedance.ies.sdk.widgets;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    private int mLatestVersion;
    private Map<Observer, NextObserver> nextObserverMap;

    public class NextObserver<T> implements Observer<T> {
        private int initVersion;
        private boolean notifyWhenObserve;
        private Observer<? super T> observer;
        final /* synthetic */ NextLiveData this$0;

        @Override // androidx.lifecycle.Observer
        public void onChanged(T r100) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r100);
            return;
        L5:
            if (this.initVersion < NextLiveData.access$000(this.this$0)) goto L7;
        }

        public NextObserver(NextLiveData r100, int r101, Observer<? super T> r102, boolean r103) {
            this.this$0 = r100;
            this.initVersion = r101;
            this.observer = r102;
            this.notifyWhenObserve = r103;
        }
    }

    public NextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    public static /* synthetic */ int access$000(NextLiveData r100) {
        return r100.mLatestVersion;
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r100) {
        observeForever(r100, false);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r100) {
        NextObserver r101 = this.nextObserverMap.remove(r100);
        if (r101 == null) goto L6;
        super.removeObserver(r101);
        return;
    L6:
        super.removeObserver(r100);
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator<Map.Entry<Observer, NextObserver>> r102 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<Observer, NextObserver> r103 = r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = r103.getKey();
    L15:
        if (r104 == null) goto L22;
        this.nextObserverMap.remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T r100) {
        this.mLatestVersion++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r100, Observer<? super T> r101) {
        observe(r100, r101, false);
    }

    public void observeForever(Observer<? super T> r100, boolean r101) {
        if (this.nextObserverMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        NextObserver r102 = new NextObserver(this, this.mLatestVersion, r100, r101);
        this.nextObserverMap.put(r100, r102);
        super.observeForever(r102);
    }

    public void observe(LifecycleOwner r100, Observer<? super T> r101, boolean r102) {
        if (this.nextObserverMap.containsKey(r101) == false) goto L5;
        return;
    L5:
        NextObserver r103 = new NextObserver(this, this.mLatestVersion, r101, r102);
        this.nextObserverMap.put(r101, r103);
        super.observe(r100, r103);
    }
}
