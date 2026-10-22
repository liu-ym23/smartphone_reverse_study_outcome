package com.kunminx.architecture.ui.callback;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes23.dex */
public class ProtectedUnPeekLiveData<T> extends LiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f278563a;

    public class a implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f278564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f278565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ProtectedUnPeekLiveData f278566c;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f278564a});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (a.class == r100.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.f278564a, ((a) r100).f278564a);
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (this.f278566c.f278563a.get() <= this.f278565b) goto L8;
            if (r100 != null) goto L6;
            this.f278566c.getClass();
            return;
        L6:
            this.f278564a.onChanged(r100);
            return;
        }

        public a(ProtectedUnPeekLiveData r100, Observer<? super T> r101, int r102) {
            this.f278566c = r100;
            this.f278565b = -1;
            this.f278564a = r101;
            this.f278565b = r102;
        }
    }

    public ProtectedUnPeekLiveData() {
        this.f278563a = new AtomicInteger(-1);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        super.observeForever(new a(this, r100, this.f278563a.get()));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        if (r100.getClass().isAssignableFrom(a.class) == false) goto L5;
        super.removeObserver(r100);
        return;
    L5:
        super.removeObserver(new a(this, r100, -1));
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T r100) {
        this.f278563a.getAndIncrement();
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        super.observe(r100, new a(this, r101, this.f278563a.get()));
    }
}
