package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardGetListDataBridge;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardSetListDataBridge;
import com.bytedance.android.ec.hybrid.list.bridge.SaasAuthenticationBridge;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallBatchReportJsb;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallGetBCMFullChainJSB;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallOpenSchemaJsb;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallPreloadResourceJsb;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallReportJsb;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallSendDynamicRequestJsb;
import com.bytedance.android.shopping.mall.feed.jsb.ECMallUpdateTabMallBubbleJSB;
import com.bytedance.android.shopping.mall.homepage.jsb.ECMallReportALogListJsb;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a1 {
    public final qf3.d a;
    public final ECMallOpenSchemaJsb b;
    public final com.bytedance.android.shopping.mall.feed.jsb.p c;
    public final List<IDLXBridgeMethod> d;

    public a1(Context r4, ECMallFeed r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "mallFeed");
        qf3.d r0 = new qf3.d(r4, r5);
        this.a = r0;
        ECMallOpenSchemaJsb r6 = new ECMallOpenSchemaJsb(r0);
        this.b = r6;
        this.c = new com.bytedance.android.shopping.mall.feed.jsb.p(r0);
        this.d = CollectionsKt.listOf(new IDLXBridgeMethod[]{new SaasAuthenticationBridge(), new com.bytedance.android.ec.hybrid.list.bridge.b(), new ECLynxCardSetListDataBridge(r0.b.J), new ECLynxCardGetListDataBridge(r0.b.J), new ECMallSendDynamicRequestJsb(r0), new com.bytedance.android.shopping.mall.feed.jsb.o(r0), new ECMallReportJsb(r0), new com.bytedance.android.shopping.mall.feed.jsb.b(r0), new com.bytedance.android.shopping.mall.feed.jsb.j0(r0), r6, new ECMallBatchReportJsb(r0), new com.bytedance.android.shopping.mall.feed.jsb.a0(r0), new com.bytedance.android.shopping.mall.feed.jsb.u(r0), new com.bytedance.android.shopping.mall.feed.jsb.x(r0), new com.bytedance.android.shopping.mall.feed.jsb.r(r0), new com.bytedance.android.shopping.mall.feed.jsb.a(r0), new com.bytedance.android.shopping.mall.feed.jsb.p(r0), new com.bytedance.android.shopping.mall.feed.jsb.k0(r0), new com.bytedance.android.shopping.mall.feed.jsb.i0(r0), new com.bytedance.android.shopping.mall.feed.jsb.s(r0), new com.bytedance.android.shopping.mall.feed.jsb.q(r0), new com.bytedance.android.shopping.mall.feed.jsb.h0(r0), new com.bytedance.android.shopping.mall.feed.jsb.g(r0), new com.bytedance.android.shopping.mall.feed.jsb.w(r0), new com.bytedance.android.shopping.mall.feed.jsb.v(r0), new com.bytedance.android.shopping.mall.feed.jsb.g0(r0), new ECMallUpdateTabMallBubbleJSB(r0), new ECMallGetBCMFullChainJSB(r0), new ECMallPreloadResourceJsb(r0), new com.bytedance.android.shopping.mall.feed.jsb.d0(r0), new com.bytedance.android.shopping.mall.feed.jsb.e0(r0), new com.bytedance.android.shopping.mall.feed.jsb.f(r0), new com.bytedance.android.shopping.mall.feed.jsb.e(r0), new com.bytedance.android.shopping.mall.feed.jsb.y(r0), new com.bytedance.android.shopping.mall.feed.jsb.d(r0), new com.bytedance.android.shopping.mall.feed.jsb.t(r0), new com.bytedance.android.shopping.mall.feed.jsb.o0(r0), new com.bytedance.android.shopping.mall.feed.jsb.n0(r0), new ECMallReportALogListJsb(), new com.bytedance.android.shopping.mall.feed.jsb.m(r0), new com.bytedance.android.shopping.mall.feed.jsb.l(r0), new com.bytedance.android.shopping.mall.feed.jsb.h(r0), new com.bytedance.android.shopping.mall.homepage.jsb.r(r0), new com.bytedance.android.shopping.mall.feed.jsb.z(r0), new com.bytedance.android.shopping.mall.feed.jsb.f0(r0), new com.bytedance.android.shopping.mall.feed.jsb.c(r0), new com.bytedance.android.shopping.mall.feed.jsb.i(r0)});
    }
}
