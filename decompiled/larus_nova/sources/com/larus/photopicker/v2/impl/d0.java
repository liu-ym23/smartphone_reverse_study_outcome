package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 implements Function0<ViewModelStoreOwner> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f364343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class<?> f364344b;

    public d0(Fragment r100, Class<?> r101) {
        this.f364343a = r100;
        this.f364344b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStoreOwner invoke() {
        Fragment r100 = this.f364343a;
        int r101 = e0.f364440a;
        Fragment r102 = e0.a(r100, this.f364344b);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("ownerProducer is null");
    }
}
