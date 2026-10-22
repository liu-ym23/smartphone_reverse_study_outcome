package com.ss.android.ugc.aweme.kiwi.extension;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/kiwi/extension/ObserveOnceExtensionKt$observeOnce$1", "Landroidx/lifecycle/Observer;", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class ObserveOnceExtensionKt$observeOnce$1 implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveData f450886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer f450887b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f450887b.onChanged(r100);
        this.f450886a.removeObserver(this);
    }

    public ObserveOnceExtensionKt$observeOnce$1(MutableLiveData r100, Observer r101) {
        this.f450886a = r100;
        this.f450887b = r101;
    }
}
