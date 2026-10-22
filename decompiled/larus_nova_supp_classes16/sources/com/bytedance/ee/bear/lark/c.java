package com.bytedance.ee.bear.lark;

import com.bytedance.ee.bear.lark.space.PadHomeMainFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements PadHomeMainFragment.b {
    public final /* synthetic */ CCMPlaceHolderFragment a;

    public c(CCMPlaceHolderFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.lark.space.PadHomeMainFragment.b
    public final void a(int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        this.a.m = r4;
        tt5.a.h("CCMPlaceHolderFragment", "onSubMenuSelect, mCurrentSubNavigationId = " + this.a.m + ", index:" + r3 + " id:" + r4 + " text:" + r5);
    }
}
