package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f209255a;

    public c(Ref.ObjectRef<Function0<Unit>> r100) {
        this.f209255a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FilterFieldOption r101 = (FilterFieldOption) r100;
        this.f209255a.element.invoke();
    }
}
