package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f209232a;

    public a(Function0<Unit> r100) {
        this.f209232a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FilterFieldOption r101 = (FilterFieldOption) r100;
        this.f209232a.invoke();
    }
}
