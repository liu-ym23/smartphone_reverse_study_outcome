package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f240956a;

    public x(y r100) {
        this.f240956a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        this.f240956a.f240958b.clear();
        Set<String> r102 = this.f240956a.f240958b;
        Intrinsics.checkNotNull(r101);
        r102.addAll(r101);
    }
}
