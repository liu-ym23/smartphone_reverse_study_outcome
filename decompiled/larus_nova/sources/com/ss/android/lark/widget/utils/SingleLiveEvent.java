package com.ss.android.lark.widget.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class SingleLiveEvent<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f449073a;

    public void call() {
        setValue(null);
    }

    public SingleLiveEvent() {
        this.f449073a = new AtomicBoolean(false);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f449073a.set(true);
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, final Observer<? super T> r101) {
        if (hasActiveObservers() == false) goto L5;
        Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
    L5:
        super.observe(r100, new f(this, r101));
    }
}
