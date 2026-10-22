package com.bytedance.ee.bear.bitable.homepage.list.newlist;

import com.bytedance.ee.bear.bitable.homepage.n0;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements gqa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableHomeListNewFragment f212833a;

    public a(BitableHomeListNewFragment r100) {
        this.f212833a = r100;
    }

    @Override // gqa.d
    public final void d2(h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        n0 r101 = this.f212833a.f212822l;
        if (r101 == null) goto L6;
        r101.onRefresh();
        return;
    }
}
