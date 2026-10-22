package com.bytedance.ies.sve_core;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class l<T> implements Observer<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f248696a;

    public l(Function1 r100) {
        this.f248696a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(s r100) {
        Function1 r101 = this.f248696a;
        r101.invoke(r100);
    }
}
