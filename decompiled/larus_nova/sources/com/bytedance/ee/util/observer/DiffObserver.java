package com.bytedance.ee.util.observer;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes19.dex */
public abstract class DiffObserver<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f243148a;

    public DiffObserver() {
    }

    public abstract void a(T r100);

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        if (r100 != null) goto L7;
        if (this.f243148a == null) goto L10;
        a(null);
        this.f243148a = null;
        return;
    L10:
        return;
    L7:
        if (r100.equals(this.f243148a) == true) goto L12;
        a(r100);
        this.f243148a = r100;
        return;
    }
}
