package com.bytedance.ee.bear.drive.biz.preview.banner;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223234a;

    public c(a r100) {
        this.f223234a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        a r102 = this.f223234a;
        Intrinsics.checkNotNull(r101);
        r102.f223221r = r101.intValue();
        this.f223234a.c();
    }
}
