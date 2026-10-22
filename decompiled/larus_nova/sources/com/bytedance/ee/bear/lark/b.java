package com.bytedance.ee.bear.lark;

import androidx.lifecycle.Observer;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseHeaderFragment f227280a;

    public b(BaseHeaderFragment r100) {
        this.f227280a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ForsetiViewMode r101 = (ForsetiViewMode) r100;
        BaseHeaderFragment r102 = this.f227280a;
        Intrinsics.checkNotNull(r101);
        r102.aa0(r101);
    }
}
