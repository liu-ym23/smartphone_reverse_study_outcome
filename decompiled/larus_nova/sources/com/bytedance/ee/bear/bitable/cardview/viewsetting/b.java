package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f209254a;

    public b(Ref.ObjectRef<Function0<Unit>> r100) {
        this.f209254a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        this.f209254a.element.invoke();
    }
}
