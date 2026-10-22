package com.bytedance.ee.bear.more.view3;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.more.protocol3.k;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MoreFragmentV3 f235021a;

    public b(MoreFragmentV3 r100) {
        this.f235021a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        k r101 = (k) r100;
        if ((r101 instanceof zj5.b) == false) goto L5;
        MoreFragmentV3 r102 = this.f235021a;
        int r103 = MoreFragmentV3.f235014n;
        r102.ea0(r101);
        return;
    L5:
        MoreFragmentV3 r104 = this.f235021a;
        int r105 = MoreFragmentV3.f235014n;
        ((MoreAdapter) r104.f235016l.getValue()).z2(r101);
    }
}
