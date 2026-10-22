package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.retrofit2.SsResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final OrderListRequestType a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final OrderAppletPageScene g;
    public final Function0<Unit> h;
    public final Function1<? super SsResponse<String>, Unit> i;
    public com.bytedance.android.shopping.orderlist.common.monitor.error.a j;

    public b() {
        throw null;
    }

    public final OrderListRequestType getType() {
        return this.a;
    }

    public b(OrderListRequestType r4, int r5, boolean r6, boolean r7, boolean r8, boolean r9, OrderAppletPageScene r10, com.bytedance.android.shopping.orderlist.common.monitor.error.a r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r5 = 1;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r6 = false;
    L9:
        if ((r12 & 8) == 0) goto L12;
        r7 = true;
    L12:
        if ((r12 & 16) == 0) goto L15;
        r8 = false;
    L15:
        if ((r12 & 32) == 0) goto L18;
        r9 = false;
    L18:
        if ((r12 & 64) == 0) goto L21;
        r10 = OrderAppletPageScene.PAGE_INTERNAL;
    L21:
        if ((r12 & 512) == 0) goto L23;
        r11 = null;
    L23:
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r10, "appletPageScene");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = null;
        this.i = null;
        this.j = r11;
    }
}
