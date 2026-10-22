package com.bytedance.ee.bear.lark;

import com.bytedance.ee.bear.lark.space.PadHomeMainFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements PadHomeMainFragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMPlaceHolderFragment f227331a;

    public c(CCMPlaceHolderFragment r100) {
        this.f227331a = r100;
    }

    @Override // com.bytedance.ee.bear.lark.space.PadHomeMainFragment.b
    public final void a(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f227331a.f227171m = r101;
        tt5.a.h("CCMPlaceHolderFragment", "onSubMenuSelect, mCurrentSubNavigationId = " + this.f227331a.f227171m + ", index:" + r100 + " id:" + r101 + " text:" + r102);
    }
}
