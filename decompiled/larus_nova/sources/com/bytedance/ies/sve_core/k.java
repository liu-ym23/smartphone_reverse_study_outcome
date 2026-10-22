package com.bytedance.ies.sve_core;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes19.dex */
public final class k<S> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<S> f248694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observer<S> f248695b;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.ies.sve_core.g
    public final void dispose() {
        this.f248694a.removeObserver((Observer<? super S>) this.f248695b);
    }

    public k(MutableLiveData r100, l r101) {
        this.f248694a = r100;
        this.f248695b = r101;
    }
}
