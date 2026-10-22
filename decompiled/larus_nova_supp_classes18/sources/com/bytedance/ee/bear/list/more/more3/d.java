package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.list.more.itemv2.MoveItemV2;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements e0 {
    public final /* synthetic */ l a;

    public d(l r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.e0
    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r10, com.bytedance.ee.bear.more.protocol3.panel.e r11) {
        Intrinsics.checkNotNullParameter(r10, "<unused var>");
        Intrinsics.checkNotNullParameter(r11, "<unused var>");
        SpaceMoreItemFactory r12 = this.a.o;
        r12.getClass();
        return new MoveItemV2(r12.c, r12.d, r12.h, SpaceMoreItemFactory.u(), r12.l, r12.i, t0.o(r12.e), false);
    }
}
